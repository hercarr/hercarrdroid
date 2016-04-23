package mx.hercarr.hercarrdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import mx.hercarr.hercarrdroid.activities.LoginActivity;
import mx.hercarr.hercarrdroid.fragments.CameraFragment;
import mx.hercarr.hercarrdroid.fragments.LocalFriendListFragment;
import mx.hercarr.hercarrdroid.fragments.RemoteFriendListFragment;
import mx.hercarr.hercarrdroid.fragments.ViewPagerFragment;
import mx.hercarr.hercarrdroid.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        validateSession();
        setToolbar();
        setNavigationDrawer();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)  {
            case R.id.nav_recycler_view:
                loadFragment(LocalFriendListFragment.newInstance());
                break;
            case R.id.nav_web_service:
                loadFragment(RemoteFriendListFragment.newInstance());
                break;
            case R.id.nav_view_pager:
                loadFragment(ViewPagerFragment.newInstance());
                break;
            case R.id.nav_camera:
                loadFragment(CameraFragment.newInstance());
                break;
            case R.id.nav_map:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_logout:
                logout();
                break;
            default:
                break;
        }
        closeDrawer();
        return true;
    }

    private void validateSession() {
        if (!LoginPresenter.isLogged(this)) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
        setSupportActionBar(toolbar);
    }

    private void setNavigationDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
        closeDrawer();
    }

    private void closeDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void logout() {
        LoginPresenter.setLogout(this);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}