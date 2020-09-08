package com.example.appoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText userInput;
    protected EditText passInput;
    protected Button btnLogin;
    protected TextView helpText;

    private final String user = "admin";
    private final String pass = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.userInput = (EditText) findViewById(R.id.userInput);
        this.passInput = (EditText) findViewById(R.id.passInput);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.helpText = (TextView) findViewById(R.id.helpText);


        this.btnLogin.setOnClickListener(this);
        this.helpText.setOnClickListener(this);
    }


    private void login()
    {
        User user = new User(this.userInput.getText().toString(), this.passInput.getText().toString());

        if(!user.isEmpty())
        {
            if(user.compare(this.user, this.pass))
            {
                Intent intent = new Intent(this, OperationsActivity.class);
                startActivity(intent);
                finishAffinity();
            }else
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.btnLogin:
                this.login();
            break;
            case R.id.helpText:
                Toast.makeText(
                        this,
                        "Usuario: "+this.user+"\nContraseña: "+this.pass,
                        Toast.LENGTH_LONG).show();
            break;
        }
    }

}