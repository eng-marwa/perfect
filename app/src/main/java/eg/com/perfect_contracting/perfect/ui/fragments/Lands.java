package eg.com.perfect_contracting.perfect.ui.fragments;


import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.model.LandsAds;
import eg.com.perfect_contracting.perfect.ui.activities.AdDescriptionActivity;
import eg.com.perfect_contracting.perfect.util.FirebaseUtil;
import eg.com.perfect_contracting.perfect.util.PermissionUtil;
import eg.com.perfect_contracting.perfect.util.UploadFirebaseTask;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lands extends Fragment {

    private static String imageUrl;
    private StorageReference mStorageRef;
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;

    private static final int RESULT_LOAD_IMAGE = 100;
    @BindView(R.id.image)
    ImageButton imageButton;
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
    @OnClick(R.id.image)
    public void adsImage() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }
    public Lands() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_lands, container, false);
        ButterKnife.bind(this,viewRoot);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        database = FirebaseDatabase.getInstance();

        return viewRoot;
    }

    public void saveLandInFirebase() {
        String title = adTitle.getText().toString();
        String description = adDesc.getText().toString();
        String address = addressView.getText().toString();
        String location = locView.getText().toString();
        String price = adprice.getText().toString();
        String priceDetails = adpriceDesView.getText().toString();
        String area = areaView.getText().toString();
        System.out.println("hellooooo "+imageUrl);
        LandsAds lands = new LandsAds(title, description, imageUrl, location, address, area, price, priceDetails);
        FirebaseUtil.getLandsAdsRef().push().setValue(lands);
        Toast.makeText(getActivity(), "Ad added", Toast.LENGTH_LONG).show();
        getActivity().finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {
            imageButton.setImageURI(data.getData());
            new UploadFirebaseTask(getActivity()).execute(data.getData());
        }
    }

    public static void getDownloadUrl(String downloadUrl) {
        imageUrl = downloadUrl;
    }

}
