package eg.com.perfect_contracting.perfect.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.adapter.DesignAdapter;
import eg.com.perfect_contracting.perfect.model.Design;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinishingFragment extends Fragment {
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    private DesignAdapter adapter;

    public FinishingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_finishing, container, false);
        ButterKnife.bind(this,viewRoot);
        setupRecycler();
        return  viewRoot;
    }

    private void setupRecycler() {
        StaggeredGridLayoutManager mngr = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mngr);
        adapter = new DesignAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        init();
    }
    private void init(){
        List<Design> pic = new ArrayList<>();
        pic.add(new Design("",R.mipmap.v1));
        pic.add(new Design("",R.mipmap.v2));
        pic.add(new Design("",R.mipmap.v3));
        pic.add(new Design("",R.mipmap.v4));
        adapter.setData(pic);
    }

}


