package eg.com.perfect_contracting.perfect.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.adapter.PerfectPagerAdapter;
import eg.com.perfect_contracting.perfect.adapter.SliderAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.header_pager)
    ViewPager headerViewPager;
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    //     toolbar.getBackground().setAlpha(0);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setViewPager();
        Intent intent = getIntent();
        if(intent!=null && intent.hasExtra("home")){
            String home = intent.getExtras().getString("home");
            switch (home){
                case "perfect":
                    tabs.getTabAt(1).select();
                    break;
                    case "offer":
                    tabs.getTabAt(2).select();
                    break;
                    case "real":
                    tabs.getTabAt(0).select();
                    break;
            }
        }
        setTabIcon();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        tabs.getTabAt(0).select();
                        break;
                        case R.id.profile:
                            Intent i1 = new Intent(MainActivity.this,ProfileActivity.class);
                            startActivity(i1);
                        break;
                        case R.id.navigation_notifications:
                            Intent i2 = new Intent(MainActivity.this,EventActivity.class);
                            startActivity(i2);
                        break;
                }
                return true;
            }
        });
    }

    private void setViewPager() {
        PerfectPagerAdapter adapter = new PerfectPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager,true);
        final int[] images= {R.mipmap.header,R.mipmap.dd,R.mipmap.bb};
        SliderAdapter adapter1 = new SliderAdapter(this,images);
        headerViewPager.setAdapter(adapter1);
        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);
        indicator.setViewPager(headerViewPager);

        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                headerViewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 4000, 3000);

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



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setTabIcon() {
        final int[] icons = new int[]{
                R.drawable.ic_advert,
                R.drawable.ic_logo,
                R.drawable.ic_black_shop_tag};
        for (int i = 0; i < icons.length; i++) {
            tabs.getTabAt(i).setIcon(icons[i]);

        }
    }
}
