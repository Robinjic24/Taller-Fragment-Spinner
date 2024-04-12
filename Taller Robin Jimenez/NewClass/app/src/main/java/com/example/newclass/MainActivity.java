package com.example.newclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    InicioFragment IniFragment = new InicioFragment();

    SettingsFragment SettiFragment = new SettingsFragment();

    FrameLayout frm_app;

    BottomNavigationView btm_menuNavigation;

    private Spinner spinnerme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frm_app = findViewById(R.id.frm_app);
        btm_menuNavigation = findViewById(R.id.btm_menuNavigation);
        btm_menuNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_inicio){
                    load_fragment(IniFragment);
                    return true;
                } else if (item.getItemId() == R.id.nav_settings) {
                    load_fragment(SettiFragment);
                    return true;
                }
                return false;
            }
        });
        spinnerme.findViewById(R.id.spinner);
        ArrayList<String> Messi =new ArrayList<>();
        Messi.add("Messi1");
        Messi.add("Messi2");
        Messi.add("Messi3");
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Messi);
        spinnerme.setAdapter((adapter));

    }

    public void load_fragment(Fragment fr){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frm_app, fr);
        ft.commit();
    }
}