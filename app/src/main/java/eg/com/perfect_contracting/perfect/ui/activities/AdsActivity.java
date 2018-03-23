package eg.com.perfect_contracting.perfect.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;
import eg.com.perfect_contracting.perfect.R;

public class AdsActivity extends AppCompatActivity {

    @OnClick({R.id.card1, R.id.linear1, R.id.imageView14})
    public void landsForSale() {
        Intent intent = new Intent(AdsActivity.this, AdDescriptionActivity.class);
        intent.putExtra("category", "lands");
        startActivity(intent);
    }

    @OnClick({R.id.card2, R.id.linear2, R.id.imageView5})
    public void residentialForSale() {
        Intent intent = new Intent(AdsActivity.this, AdDescriptionActivity.class);
        intent.putExtra("category", "residential");
        startActivity(intent);
    }

    @OnClick({R.id.card3, R.id.linear3, R.id.imageView7})
    public void furnitureForSale() {
        Intent intent = new Intent(AdsActivity.this, AdDescriptionActivity.class);
        intent.putExtra("category", "furniture");
        startActivity(intent);
    }

    @OnClick({R.id.card4, R.id.linear4, R.id.imageView13})
    public void applianceForSale() {
        Intent intent = new Intent(AdsActivity.this, AdDescriptionActivity.class);
        intent.putExtra("category", "appliance");
        startActivity(intent);
    }

    @OnClick({R.id.card5, R.id.linear5, R.id.imageView12})
    public void shopForSale() {
        Intent intent = new Intent(AdsActivity.this, AdDescriptionActivity.class);
        intent.putExtra("category", "shop");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent i = new Intent(AdsActivity.this,MainActivity.class);
                i.putExtra("home","real");
                startActivity(i);
                break;
        }
        return true;
    }
}
