package com.rau.sebastian.productospracticaapp_sebas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rau.sebastian.productospracticaapp_sebas.R;
import com.rau.sebastian.productospracticaapp_sebas.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameInput = findViewById(R.id.username_input);
        fullnameInput = findViewById(R.id.fullname_input);
        emailInput =    findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
    }


    public void callRegister(View view){
        String username = usernameInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(username.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        UserRepository.create(username, fullname, email, password);
        startActivity(new Intent(this, LoginActivity.class));
        finish();

    }


    public void callCancel(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
