package eg.com.perfect_contracting.perfect.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.adapter.PerfectSpinnerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Appliance extends Fragment {
@BindView(R.id.spinner)
    Spinner spinner;

    public Appliance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_appliance, container, false);
        ButterKnife.bind(this,viewRoot);
        initSimpleSpinner();
        return viewRoot;
    }

    public void saveApplianceInFirebase() {
    }
    private void initSimpleSpinner() {
        // Spinner element

        // Spinner Drop down elements
        List<String> languages = Arrays.asList(getActivity().getResources().getStringArray(R.array.categories));


        // Creating adapter for spinner
        spinner.setAdapter(new PerfectSpinnerAdapter(getActivity(),languages));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
