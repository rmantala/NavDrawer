package id.ac.poliban.roman.navdrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nv = findViewById(R.id.navigation_view);
        nv.setNavigationItemSelectedListener(menuItem -> executeMenuItem(menuItem));
    }

    private boolean executeMenuItem(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mi_dashboard :
                showMessage("This is dashboard!");
                break;
            case R.id.mi_events :
                showMessage("This is Events!");
                break;
            case R.id.mi_searching :
                showMessage("This is Searching event!");
                break;
            case R.id.mi_activities :
                showMessage("This is Activities!");
                break;
            case R.id.mi_settings :
                showMessage("This is Setting!");
                break;
            case R.id.mi_logout :
                showMessage("are you sure!");
                break;
        }

        return true;
    }

    private void showMessage(String s) {
        new AlertDialog.Builder(this)
                .setTitle("information")
                .setMessage(s)
                .show();
    }
}
