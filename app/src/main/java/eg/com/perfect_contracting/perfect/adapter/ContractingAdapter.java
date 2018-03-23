package eg.com.perfect_contracting.perfect.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.model.Design;
import eg.com.perfect_contracting.perfect.ui.fragments.ConstructionFragment;
import eg.com.perfect_contracting.perfect.ui.fragments.DesignFragment;
import eg.com.perfect_contracting.perfect.ui.fragments.FinishingFragment;
import eg.com.perfect_contracting.perfect.ui.fragments.SupplialFragment;

/**
 * Created by java on 02/12/2017.
 */

public class ContractingAdapter extends FragmentPagerAdapter {
    private Context context;
    private Fragment fragment[] = {new DesignFragment(),new ConstructionFragment(),new FinishingFragment(),new SupplialFragment()};
    public ContractingAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment[position];
    }

    @Override
    public int getCount() {
        return fragment.length;
    }
      @Override
    public CharSequence getPageTitle(int position) {
        int title[] ={R.string.design,R.string.construction,R.string.finishing,R.string.supplial};
        return context.getString(title[position]);
    }
}
