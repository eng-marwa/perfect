package eg.com.perfect_contracting.perfect.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eg.com.perfect_contracting.perfect.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Residential extends Fragment {
    private static String imageUrl;
    private StorageReference mStorageRef;
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;

    private static final int RESULT_LOAD_IMAGE = 100;
    @BindView(R.id.rent)
    RadioButton rentButton;
    @BindView(R.id.sale)
    RadioButton saleButton;
    @BindView(R.id.group)
    RadioGroup groupButton;

    @BindView(R.id.image)
    ImageButton imageView;
    @BindView(R.id.desc)
    EditText adDesc;
    @BindView(R.id.title)
    EditText adTitle;
    @BindView(R.id.price)
    EditText adprice;
    @BindView(R.id.priceDesView)
    EditText adpriceDesView;
    @BindView(R.id.areaView)
    EditText areaView;
    @BindView(R.id.locView)
    EditText locView;
    @BindView(R.id.addressView)
    EditText addressView;
    private String option;

    @OnClick(R.id.image)
    public void adsImage() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }



    public Residential() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_residential, container, false);
        ButterKnife.bind(this,viewRoot);
        groupButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rent) {
                   option = "Rent";
                } else if (checkedId == R.id.sale) {
                   option = "Sale";
                }
            }
        });

        return viewRoot;
    }

    public void saveResidentialInFirebase() {
    }
}
