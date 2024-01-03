package com.example.navigationbutton;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.navigationbutton.fragment.BtFragment;
import com.example.navigationbutton.fragment.HomeFragment;
import com.example.navigationbutton.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bnv);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutId,new ProfileFragment());
        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if (item.getItemId()==R.id.homeId){
                    transaction.replace(R.id.frameLayoutId, new HomeFragment());
                }
                if (item.getItemId()==R.id.bloothId){
                    transaction.replace(R.id.frameLayoutId, new BtFragment());
                }
                if (item.getItemId()==R.id.profileId){
                    transaction.replace(R.id.frameLayoutId, new ProfileFragment());
                }
                transaction.commit();
                return true;
            }
        });
    }
}