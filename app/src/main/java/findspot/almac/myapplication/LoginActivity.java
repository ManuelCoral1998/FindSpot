package findspot.almac.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText et_usuario;
    private EditText et_contrasenha;

    private Button btn_ingresar;
    private Button btn_registrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_usuario = findViewById(R.id.et_usuario);
        et_contrasenha = findViewById(R.id.et_contraseña);

        btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_registrate = findViewById(R.id.btn_registrarte);



    }
}
