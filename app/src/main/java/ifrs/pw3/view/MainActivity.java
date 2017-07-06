package ifrs.pw3.view;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ifrs.pw3.R;
import ifrs.pw3.dao.NoticiaRepository;
import ifrs.pw3.fragment.ConhecaFragment;
import ifrs.pw3.fragment.EnqueteFragment;
import ifrs.pw3.fragment.InscricaoFragment;
import ifrs.pw3.fragment.NoticiasFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Montagem de pequena lista para teste
        (new NoticiaRepository(this.getBaseContext())).auto_popular();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), LoginActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frg_corpo, new NoticiasFragment());
//        ft.replace(R.id.frg_corpo, new EnqueteFragment());
        ft.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_facebook) {

            String facebookPageID = "ncc.belem";
            String facebookUrl = "https://www.facebook.com/" + facebookPageID;
            String facebookUrlScheme = "fb://page/" + facebookPageID;

            try {
                int versionCode = getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;

                if (versionCode >= 3002850) {
                    Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrlScheme)));
                }
            } catch (PackageManager.NameNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl)));

            }
        } else if (id == R.id.action_email) {
            sendEmail();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        View view = findViewById(R.id.vw_corpo);
        ViewGroup parent = (ViewGroup) view.getParent();
        ConstraintLayout.LayoutParams param = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        if (id == R.id.nav_noticias) {
            setTitle("Notícias");
            ft.replace(R.id.frg_corpo, new NoticiasFragment());
        } else if (id == R.id.nav_enquete) {
            setTitle("Enquete do mês");
            ft.replace(R.id.frg_corpo, new EnqueteFragment());
        } else if (id == R.id.nav_conheca) {
            setTitle("Sobre o NCC");
            ft.replace(R.id.frg_corpo, new ConhecaFragment());
        } else if (id == R.id.nav_inscricoes) {
            setTitle("Inscrição");
            ft.replace(R.id.frg_corpo, new InscricaoFragment());
        }

        ft.commit();
//        Toast toast = Toast.makeText(this.getApplicationContext(), mensagem_da_ssora, Toast.LENGTH_SHORT);
//        toast.show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void sendEmail() {
        String[] TO = {"conaron@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contato a partir do app");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar e-mail usando..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "Não tem cliente de e-mail instalado", Toast.LENGTH_SHORT).show();
        }
    }


}
