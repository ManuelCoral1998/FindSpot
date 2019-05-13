package findspot.almac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import findspot.almac.myapplication.model.Usuario;

public class RegistroActivity extends AppCompatActivity {


    private EditText et_usuario;
    private EditText et_carrera;
    private EditText et_correo;
    private EditText pass;
    private EditText passConfirm;
    private Spinner spinnerUniversidades;
    private Button btnRegistrarse;

    FirebaseAuth auth;
    FirebaseDatabase rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        auth = FirebaseAuth.getInstance();
        rtdb = FirebaseDatabase.getInstance();

        et_usuario = findViewById(R.id.et_usuario_registro);
        et_correo = findViewById(R.id.et_correo_registro);
        et_carrera = findViewById(R.id.et_carrera_registro);

        pass = findViewById(R.id.et_contraseña_registro);
        passConfirm = findViewById(R.id.et_contraseña_registro_confirmar);

        spinnerUniversidades = findViewById(R.id.spinner_universidades_registro);

        btnRegistrarse = findViewById(R.id.btn_listo);

        ArrayAdapter<CharSequence> universidades = ArrayAdapter.createFromResource(this, R.array.universidades, android.R.layout.simple_spinner_item);

        spinnerUniversidades.setAdapter(universidades);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pass.length() < 6) {
                    Toast.makeText(RegistroActivity.this, "La contraseña debe de tener por lo menos 6 caracteres", Toast.LENGTH_LONG).show();
                } else {
                    if (pass.getText().toString().equals(passConfirm.getText().toString())) {

                        final String correo = et_correo.getText().toString();
                        final String contrasenha = pass.getText().toString();

                        auth.createUserWithEmailAndPassword(correo, contrasenha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                String carrera = et_carrera.getText().toString();
                                String nombre = et_usuario.getText().toString();

                                Usuario usuario = new Usuario(nombre, carrera, correo, contrasenha);

                                rtdb.getReference().child("usuario").child(auth.getCurrentUser().getUid()).setValue(usuario);

                                Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();

                            }
                        });

                    } else {
                        Toast.makeText(RegistroActivity.this, "Las contraseñas deben de ser iguales", Toast.LENGTH_LONG).show();
                    }
                }



            }
        });


    }
}
