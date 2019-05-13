package findspot.almac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import findspot.almac.myapplication.model.Edificio;
import findspot.almac.myapplication.model.Mesa;
import findspot.almac.myapplication.model.Piso;

public class ListaMesas extends AppCompatActivity {

    private ListView listaPisos;
    private AdapterPisos adapter;

    FirebaseAuth auth;
    FirebaseDatabase rtdb;
    private ArrayList<Piso> pisos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mesas);

        Edificio aBuscar = (Edificio) getIntent().getSerializableExtra("Edificio");


        listaPisos = findViewById(R.id.list_view_mesas);

        auth = FirebaseAuth.getInstance();
        rtdb = FirebaseDatabase.getInstance();

        adaptador(aBuscar);

        listaPisos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Piso aBuscar = (Piso) parent.getItemAtPosition(position);


            }
        });


    }

    private void adaptador(Edificio edificio) {

        pisos = new ArrayList<>();

        for (int i = 0; i < edificio.getPisos().size(); i++){
            pisos.add(edificio.getPisos().get(i));
        }

        adapter = new AdapterPisos(ListaMesas.this, pisos);
        listaPisos.setAdapter(adapter);

    }
}
