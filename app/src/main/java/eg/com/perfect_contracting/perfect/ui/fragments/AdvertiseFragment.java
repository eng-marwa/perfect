package eg.com.perfect_contracting.perfect.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.adapter.AdsAdapter;
import eg.com.perfect_contracting.perfect.model.LandsAds;
import eg.com.perfect_contracting.perfect.ui.activities.AdsActivity;
import eg.com.perfect_contracting.perfect.util.FirebaseUtil;
import eg.com.perfect_contracting.perfect.util.NotificationDialogUtil;
import eg.com.perfect_contracting.perfect.util.SharedPrefUtil;


public class AdvertiseFragment extends Fragment {
    @BindView(R.id.lands)
    RecyclerView landsRecyclerView;
    @BindView(R.id.residential)
    RecyclerView residentialRecyclerView;
    @BindView(R.id.furniture)
    RecyclerView furnitureRecyclerView;
    @BindView(R.id.applicance)
    RecyclerView applicanceRecyclerView;
    private AdsAdapter adapter;

    @OnClick(R.id.card_view7)
    public void advertiseNow(){
        if(!SharedPrefUtil.isSavedInShared(getActivity())){
            NotificationDialogUtil.loginUserDialog(getActivity());
        }else{
            Intent i = new Intent(getActivity(), AdsActivity.class);
            startActivity(i);
        }

    }
    public AdvertiseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_advertise, container, false);
        ButterKnife.bind(this,viewRoot);
        setupRecyclerViews();
        viewAllData();
        return viewRoot;
    }

    private void viewAllData() {
        final List<LandsAds> lands = new ArrayList<>();
        FirebaseUtil.getLandsAdsRef().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot data:children) {
                    LandsAds landsAds = data.getValue(LandsAds.class);
                    lands.add(landsAds);
                }

                adapter.setData(lands);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setupRecyclerViews() {
        landsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        residentialRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        furnitureRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        applicanceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        adapter = new AdsAdapter(getActivity());
        adapter.setData(initData());
        landsRecyclerView.setAdapter(adapter);
        AdsAdapter adapter2 = new AdsAdapter(getActivity());
        adapter2.setData(initData());
        residentialRecyclerView.setAdapter(adapter2);
        AdsAdapter adapter3 = new AdsAdapter(getActivity());
        adapter3.setData(initData());
        furnitureRecyclerView.setAdapter(adapter3);
        AdsAdapter adapter1 = new AdsAdapter(getActivity());
        adapter1.setData(initData());
        applicanceRecyclerView.setAdapter(adapter1);
    }

    private List<LandsAds> initData() {
        List<LandsAds> lands = new ArrayList<>();
        lands.add(new LandsAds("Add Title",R.mipmap.add));
        lands.add(new LandsAds("Add Title",R.mipmap.add));
        lands.add(new LandsAds("Add Title",R.mipmap.add));
        lands.add(new LandsAds("Add Title",R.mipmap.add));
        lands.add(new LandsAds("Add Title",R.mipmap.add));
        return lands;
    }


}
