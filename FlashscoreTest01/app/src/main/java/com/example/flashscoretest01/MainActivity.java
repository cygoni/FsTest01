package com.example.flashscoretest01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import static android.app.ActionBar.DISPLAY_SHOW_CUSTOM;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    NavigationView nav;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Fragment[] fragments = new Fragment[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.layout_drawer);
        nav = findViewById(R.id.nav);

        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar,R.string.app_name, R.string.app_name);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        fragments[0] = new LiveFragment();
        fragments[1] = new FavoriteFragment();
        fragments[2] = new AllFragment();
        fragments[3] = new MyTeamFragment();
        fragments[4] = new ChatFragment();

        FragmentTransaction tran = fragmentManager.beginTransaction();
        tran.add(R.id.container, fragments[0]);
        tran.commit();

        bottomNavigationView= findViewById(R.id.bn);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                FragmentTransaction tran = fragmentManager.beginTransaction();

                switch ( menuItem.getItemId() ){
                    case R.id.bn_live :
                        tran.replace(R.id.container, fragments[0]);
                        break;

                    case R.id.bn_Favorite :
                        tran.replace(R.id.container, fragments[1]);
                        break;

                    case R.id.bn_All :
                        tran.replace(R.id.container, fragments[2]);
                        break;

                    case R.id.bn_MyTeam :
                        tran.replace(R.id.container, fragments[3]);
                        break;

                    case R.id.bn_Chat :
                        tran.replace(R.id.container, fragments[4]);
                        break;
                }

                tran.commit();

                return true;
            }
        });

    }

    public void clickLogin(){


    }
    
    
}