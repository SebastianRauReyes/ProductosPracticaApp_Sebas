package com.rau.sebastian.productospracticaapp_sebas.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rau.sebastian.productospracticaapp_sebas.R;
import com.rau.sebastian.productospracticaapp_sebas.models.User;
import com.rau.sebastian.productospracticaapp_sebas.repositories.UserRepository;

public class DashboardActivity extends AppCompatActivity {

    private static final String TAG = DashboardActivity.class.getSimpleName();
    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private TextView usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        usernameText = findViewById(R.id.fullname_text);

        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // get username from SharedPreferences
        String username = sharedPreferences.getString("username", null);
        Log.d(TAG, "username: " + username);


        User user = UserRepository.getUser(username);
        usernameText.setText(user.getFullname());



        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Toast.makeText(DashboardActivity.this, "Go home section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_camera:
                        Toast.makeText(DashboardActivity.this, "Go camera section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_search:
                        Toast.makeText(DashboardActivity.this, "Go share section...", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

    }

    
    public void callLogout(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("islogged").commit();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_about:
                callLogout();
        }

        return super.onOptionsItemSelected(item);
    }


}
