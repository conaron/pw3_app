package ifrs.pw3.view;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import ifrs.pw3.R;
import ifrs.pw3.controle.LoginControle;
import ifrs.pw3.model.Usuario;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText senha;
    private Activity atividade;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.password);
        atividade = this;
        Button enviar = (Button) findViewById(R.id.email_sign_in_button);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hash = null;
                String base = email.getText().toString() + senha.getText().toString();

                try {
                    MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
                    byte messageDigest[] = algorithm.digest(base.getBytes("UTF-8"));
                    hash = Arrays.toString(messageDigest);
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                new LoginControle(atividade).carrega(hash);
            }
        });


    }
}

