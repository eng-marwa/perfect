package eg.com.perfect_contracting.perfect.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.ui.fragments.Appliance;
import eg.com.perfect_contracting.perfect.ui.fragments.Furniture;
import eg.com.perfect_contracting.perfect.ui.fragments.Lands;
import eg.com.perfect_contracting.perfect.ui.fragments.Residential;
import eg.com.perfect_contracting.perfect.ui.fragments.Shops;
import eg.com.perfect_contracting.perfect.util.PermissionUtil;

public class AdDescriptionActivity extends AppCompatActivity {


    private String category;
    private Lands lands;
    private Residential residential;
    private Furniture furniture;
    private Appliance appliance;
    private Shops shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PermissionUtil.checkPermission((AppCompatActivity) this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
            });
        }
        Intent intent = getIntent();
        if (intent.hasExtra("category")) {
            category = intent.getExtras().getString("category");
            switch (category) {
                case "lands":
                    lands = new Lands();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, lands).commit();
                    break;
                case "residential":
                    residential = new Residential();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, residential).commit();
                    break;
                case "furniture":
                    furniture = new Furniture();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, furniture).commit();
                    break;
                case "appliance":
                    appliance = new Appliance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, appliance).commit();
                    break;
                case "shop":
                    shops = new Shops();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, shops).commit();
                    break;
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int g : grantResults)
            if (PackageManager.PERMISSION_GRANTED != g) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    PermissionUtil.checkPermission((AppCompatActivity) this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE

                    });
                }
                return;
            }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ads, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(AdDescriptionActivity.this, AdsActivity.class));
                break;
            case R.id.done:
                switch (category) {
                    case "lands":
                        lands.saveLandInFirebase();
                        break;
                    case "residential":
                        residential.saveResidentialInFirebase();
                        break;
                    case "furniture":
                        furniture.saveFurnitureInFirebase();
                        break;
                    case "appliance":
                        appliance.saveApplianceInFirebase();
                        break;
                        default:
                            shops.saveShopsInFirebase();
                }
        }

        return true;
    }
}
