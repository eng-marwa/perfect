package eg.com.perfect_contracting.perfect.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import eg.com.perfect_contracting.perfect.ui.fragments.AdvertiseFragment;
import eg.com.perfect_contracting.perfect.ui.fragments.OffersFragment;
import eg.com.perfect_contracting.perfect.ui.fragments.PerfectFragment;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.ui.fragments.NewsFragment;

/**
 * Created by java on 12/10/2017.
 */

public class PerfectPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    public PerfectPagerAdapter(FragmentManager fm , Context context) {
        super(fm);
        this.context =context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AdvertiseFragment();
            case 1:
                return new PerfectFragment();
            case 2:
                return new OffersFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.advertisment);
            case 1:
                return context.getString(R.string.perfect);
            case 2:
                return context.getString(R.string.offers);
        }
        return null;
    }
}
