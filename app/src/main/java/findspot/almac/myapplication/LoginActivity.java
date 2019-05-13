package findspot.almac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private EditText et_contrasenha;
    private EditText et_correo;

    private Button btn_ingresar;
    private Button btn_registrate;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        et_contrasenha = findViewById(R.id.et_contraseña);
        et_correo = findViewById(R.id.et_correo);

        btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_registrate = findViewById(R.id.btn_registrarte);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = et_correo.getText().toString();
                String contrasenha = et_contrasenha.getText().toString();

                if (!contrasenha.equals("") || !correo.equals("")) {

                    auth.signInWithEmailAndPassword(correo, contrasenha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            // A la pagina principal
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                    });

                } else {
                    Toast.makeText(LoginActivity.this, "Ingresa tu usuario y contraseña", Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}
