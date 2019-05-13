package findspot.almac.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final int requestCamaraPermissionID = 1001;

    private LinearLayout linearPlantaFisica;
    private LinearLayout linearFiltros;
    private LinearLayout linearEscaner;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        linearPlantaFisica = findViewById(R.id.linear_planta_fisica);
        linearFiltros = findViewById(R.id.linear_filtros);
        linearEscaner = findViewById(R.id.linear_escaner);

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA}, requestCamaraPermissionID);
        }

        if (auth.getCurrentUser() == null) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }

        linearPlantaFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListaEdificios.class);
                startActivity(i);
            }
        });

        linearFiltros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearEscaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ScanQR.class);
                startActivity(i);
            }
        });

    }
}
