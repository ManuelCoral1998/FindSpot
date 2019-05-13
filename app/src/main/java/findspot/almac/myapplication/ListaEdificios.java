package findspot.almac.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import findspot.almac.myapplication.model.Edificio;
import findspot.almac.myapplication.model.Mesa;
import findspot.almac.myapplication.model.Piso;

public class ListaEdificios extends AppCompatActivity {

    public static final String[] NOMBRES_EDIFICIOS = {"A"};
    private ListView listaEdificos;
    private Adapter adapter;

    FirebaseAuth auth;
    FirebaseDatabase rtdb;
    private ArrayList<Edificio> edificios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_edificios);

       /* Mesa mesa = new Mesa("A-P1-M1", false);

        ArrayList<Mesa> mesas = new ArrayList<>();
        mesas.add(mesa);

        Piso piso = new Piso("1", mesas, 1);

        ArrayList<Piso> pisos = new ArrayList<>();
        pisos.add(piso);

        Edificio edificio = new Edificio("A", 1, 1, 1, pisos);*/

        auth = FirebaseAuth.getInstance();
        rtdb = FirebaseDatabase.getInstance();

       // rtdb.getReference().child("edificios").child("A").setValue(edificio);


        listaEdificos = findViewById(R.id.list_view_edificios);

        adaptador();

        listaEdificos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Edificio aBuscar = (Edificio) parent.getItemAtPosition(position);
                Toast.makeText(ListaEdificios.this, aBuscar.getNombreEdificio(), Toast.LENGTH_LONG).show();

                Intent i = new Intent(ListaEdificios.this, ListaMesas.class);
                i.putExtra("Edificio", aBuscar);
                startActivity(i);

            }
        });

    }

    private void adaptador() {

        edificios = new ArrayList<>();

        for (int i = 0; i < NOMBRES_EDIFICIOS.length; i++) {
            rtdb.getReference().child("edificios").child(NOMBRES_EDIFICIOS[i]).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Edificio edificio = dataSnapshot.getValue(Edificio.class);
                    edificios.add(edificio);
                    adapter = new Adapter(ListaEdificios.this, edificios);
                    listaEdificos.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }

            });
        }


    }
}
