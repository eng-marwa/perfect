package eg.com.perfect_contracting.perfect.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eg.com.perfect_contracting.perfect.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Furniture extends Fragment {


    public Furniture() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_furniture, container, false);
    }

    public void saveFurnitureInFirebase() {
    }
}
