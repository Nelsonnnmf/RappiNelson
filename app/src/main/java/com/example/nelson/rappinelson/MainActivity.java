package com.example.nelson.rappinelson;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = (RelativeLayout) findViewById(R.id.contenedor_lista);


        if (view != null) {
            getSupportFragmentManager()
                    .beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).
                    replace(R.id.contenedor_lista, new Categoria()).commit();
        } else {

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            getSupportFragmentManager()
                    .beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).
                    replace(R.id.contenedor, new ListaApp()).commit();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_categoria) {
            getSupportFragmentManager()
                    .beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).
                    replace(R.id.contenedor, new Categoria()).commit();
        } else if (id == R.id.nav_apps) {
            getSupportFragmentManager()
                    .beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).
                    replace(R.id.contenedor, new ListaApp()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
