package com.digitalhouse.marvelapi.view;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.digitalhouse.marvelapi.R;
import com.digitalhouse.marvelapi.util.Util;
import com.digitalhouse.marvelapi.view.activity.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private Button botaoLogin;
    private TextInputLayout loginUsuario;
    private TextInputLayout loginSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaCampos()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void initViews() {
        loginUsuario = findViewById(R.id.textEmailLogin);
        loginSenha = findViewById(R.id.textPasswordLogin);
        botaoLogin = findViewById(R.id.buttonLogIn);
        botaoLogin = findViewById(R.id.buttonLogIn);
    }

    private boolean validaCampos(){
        String usuario = loginUsuario.getEditText().getText().toString();
        String senha = loginSenha.getEditText().getText().toString();

        if (Util.isEmptyString(usuario) || Util.isEmptyString(senha))
            notificacao( getString(R.string.msg_campos_invalido));
        else if (!Util.usuarioValido(usuario) || !Util.senhaValida(senha))
            notificacao( getString(R.string.msg_user_senha_invalido));
        else
            return true;

        return false;
    }

    protected void notificacao (String sMensagem){
        Toast toast = Toast.makeText(getApplicationContext(), sMensagem,  Toast.LENGTH_LONG);
        toast.show();
    }
}