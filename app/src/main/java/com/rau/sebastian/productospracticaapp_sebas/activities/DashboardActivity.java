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
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.rau.sebastian.productospracticaapp_sebas.R;
import com.rau.sebastian.productospracticaapp_sebas.adapters.ProductAdapter;
import com.rau.sebastian.productospracticaapp_sebas.fragments.FragmentArchivedActivity;
import com.rau.sebastian.productospracticaapp_sebas.fragments.FragmentFavoritesActivity;
import com.rau.sebastian.productospracticaapp_sebas.fragments.FragmentHomeActivity;
import com.rau.sebastian.productospracticaapp_sebas.models.Product;
import com.rau.sebastian.productospracticaapp_sebas.models.User;
import com.rau.sebastian.productospracticaapp_sebas.repositories.ProductRepository;
import com.rau.sebastian.productospracticaapp_sebas.repositories.UserRepository;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    //TAG
    private static final String TAG = DashboardActivity.class.getSimpleName();
    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private TextView usernameText;
    // RecyclerView
    private RecyclerView productsList;

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

        //Get Parameters from Current USER
        User user = UserRepository.getUser(username);
        assert user != null;
        String name = "  "+user.getFullname();
        usernameText.setText(name);



        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment fragmentHome = new FragmentHomeActivity();
        fragmentManager.beginTransaction().replace(R.id.relativeLayoutContend, fragmentHome).addToBackStack("tag").commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId()) {
                    case R.id.menu_home:
                        onOptionsItemSelected(item);
                        Toast.makeText(DashboardActivity.this, "Go home section...", Toast.LENGTH_SHORT).show();

                        fragmentManager.beginTransaction().replace(R.id.relativeLayoutContend, fragmentHome).addToBackStack("tag").commit();

                        break;
                    case R.id.menu_favorite:
                        Toast.makeText(DashboardActivity.this, "Go favorite section...", Toast.LENGTH_SHORT).show();

                        // Create FirstFragment
                        Fragment fragmentFavorite = new FragmentFavoritesActivity();
                        // Replace content
                        fragmentManager.beginTransaction().replace(R.id.relativeLayoutContend, fragmentFavorite).addToBackStack("tag").commit();


                        break;
                    case R.id.menu_archived:
                        Toast.makeText(DashboardActivity.this, "Go archived section...", Toast.LENGTH_SHORT).show();
                        // Create FirstFragment
                        Fragment fragmentArchived = new FragmentArchivedActivity();
                        // Replace content
                        fragmentManager.beginTransaction().replace(R.id.relativeLayoutContend, fragmentArchived ).addToBackStack("tag").commit();

                        break;

                }
                return true;
            }
        });

    }

    // return from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // refresh data
        ProductAdapter adapter = (ProductAdapter)productsList.getAdapter();
        List<Product> products = ProductRepository.list();
        adapter.setProducts(products);
        adapter.notifyDataSetChanged();

    }

    public void callLogout(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("islogged").apply();
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
            case R.id.action_logout:
                callLogout();
                return true;
            case R.id.action_add:
                registerProduct();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void registerProduct(){
        startActivity(new Intent(this, RegisterProductActivity.class));

    }






}
