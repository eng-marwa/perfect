package eg.com.perfect_contracting.perfect.ui.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.adapter.PerfectPagerAdapter;
import eg.com.perfect_contracting.perfect.adapter.PerfectSpinnerAdapter;
import eg.com.perfect_contracting.perfect.adapter.SliderAdapter;

public class Maintenance extends AppCompatActivity {

    private int currentPage;
    @BindView(R.id.header_pager)
    ViewPager headerViewPager;
    private Spinner serviceSpinner;
    private Spinner serviceTypeSpinner;
    private Spinner offerSpinner;

    @OnClick(R.id.button3)
    public void calc(){
        viewDialog();
    }
    @OnClick(R.id.offer)
    public void getOffer(){
        Intent intent = new Intent(Maintenance.this,MainActivity.class);
        intent.putExtra("home","offer");
        startActivity(intent);
    }

    public void viewDialog() {
        final Dialog dialog = new Dialog(Maintenance.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog);
        serviceSpinner = dialog.findViewById(R.id.spinner1);
        serviceTypeSpinner = dialog.findViewById(R.id.spinner2);
        offerSpinner = dialog.findViewById(R.id.spinner1);
        Button calc = dialog.findViewById(R.id.button5);
        Button order = dialog.findViewById(R.id.button4);
        dialog.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewPager();
    }

    private void setViewPager() {
        PerfectPagerAdapter adapter = new PerfectPagerAdapter(getSupportFragmentManager(),this);
        headerViewPager.setAdapter(adapter);
        final int[] images= {R.mipmap.ee,R.mipmap.dd,R.mipmap.bb};
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
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("home","perfect");
                startActivity(intent);
                break;
        }
        return true;
    }
}
