package eg.com.perfect_contracting.perfect.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.ui.activities.Contracting;
import eg.com.perfect_contracting.perfect.ui.activities.Maintenance;
import eg.com.perfect_contracting.perfect.ui.activities.RealEstate;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfectFragment extends Fragment {



        @OnClick({R.id.card1,R.id.linear1,R.id.imageView14})
        public void viewMaintenance(){
            Intent intent = new Intent(getActivity(), Maintenance.class);
            intent.putExtra("extra","maintenance");
            (getActivity()).startActivity(intent);
            }


        @OnClick({R.id.card4,R.id.linear4,R.id.imageView8})
        public void viewContracting(){
            Intent intent = new Intent(getActivity(), Contracting.class);
            intent.putExtra("extra","contracting");
            (getActivity()).startActivity(intent);

        }

    public PerfectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_perfect, container, false);
        ButterKnife.bind(this,viewRoot);
        return viewRoot;
    }

}
