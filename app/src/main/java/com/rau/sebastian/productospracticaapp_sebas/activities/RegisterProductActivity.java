package com.rau.sebastian.productospracticaapp_sebas.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rau.sebastian.productospracticaapp_sebas.R;
import com.rau.sebastian.productospracticaapp_sebas.models.Product;
import com.rau.sebastian.productospracticaapp_sebas.models.User;
import com.rau.sebastian.productospracticaapp_sebas.repositories.ProductRepository;
import com.rau.sebastian.productospracticaapp_sebas.repositories.UserRepository;

public class RegisterProductActivity extends AppCompatActivity {

    private EditText productnameInput;
    private EditText productpriceInput;
    private EditText productdescInput;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        productnameInput = findViewById(R.id.product_name_input);
        productpriceInput = findViewById(R.id.product_price_input);
        productdescInput =    findViewById(R.id.product_description_input);

    }


    public void callRegister(View view){

        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // get username from SharedPreferences
        String username = sharedPreferences.getString("username", null);

        //Get Parameters from Current USER
        User user = UserRepository.getUser(username);
        assert user != null;

        String productname = productnameInput.getText().toString();
        String productprice = productpriceInput.getText().toString();
        String productdesc = productdescInput.getText().toString();
        String productstate = "FAV";
        Long id_user = user.getId();



        if(productname.isEmpty() ||productprice.isEmpty() || productdesc.isEmpty()){
            Toast.makeText(this, "You must complete all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ProductRepository.create( productname, productprice, productdesc, productstate, id_user);
        startActivity(new Intent(this, DashboardActivity.class));
        finish();

    }

    public void callCancel(View view) {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }
}
