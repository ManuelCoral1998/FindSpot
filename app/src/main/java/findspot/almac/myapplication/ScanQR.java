package findspot.almac.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import findspot.almac.myapplication.model.Edificio;

public class ScanQR extends AppCompatActivity {

    private SurfaceView camara;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;

    FirebaseDatabase rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        rtdb = FirebaseDatabase.getInstance();
        camara = findViewById(R.id.camarePreview);

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 640)
                .build();

        camara.getHolder().addCallback(new SurfaceHolder.Callback() {
            @SuppressLint("MissingPermission")
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                try {
                    cameraSource.start(camara.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                SparseArray<Barcode> grcore = detections.getDetectedItems();

                if (grcore.size() > 0) {
                    Log.d("QR", grcore.valueAt(0).displayValue);

                    String proyectoQr = grcore.valueAt(0).displayValue;

                    final String edificioString = proyectoQr.charAt(0)+"";
                    String pisoString = proyectoQr.charAt(3)+"";

                    final int piso = Integer.parseInt(pisoString)-1;

                    String mesaString = proyectoQr.charAt(6)+"";

                    final int mesa = Integer.parseInt(mesaString)-1;

                    rtdb.getReference().child("edificios").child(edificioString).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Edificio edificio = dataSnapshot.getValue(Edificio.class);
                            edificio.cambiarDatos(piso, mesa);
                            rtdb.getReference().child("edificios").child(edificioString).setValue(edificio);
                            if (edificio.getPisos().get(piso).getMesas().get(mesa).isOcupada()) {
                                Toast.makeText(ScanQR.this, "El estado actual de la mesa es: Ocupado", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(ScanQR.this, "El estado actual de la mesa es: Desocupado", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }

                    });

                    barcodeDetector.release();
                    setResult(70);
                    finish();
                    cameraSource.stop();

                }
            }
        });

    }
}
