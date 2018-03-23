package eg.com.perfect_contracting.perfect.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.model.LandsAds;

/**
 * Created by java on 14/10/2017.
 */

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.NewsViewHolder> {
    private Context context;
    private List<LandsAds> lands;

    public AdsAdapter(Context context){
       this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_card,parent,false));
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {

            LandsAds landsAds = lands.get(position);
            if (landsAds.getImage() != null) {
                Glide.with(context.getApplicationContext()).load(landsAds.getImage())
                        .thumbnail(0.5f)
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.adImage);
           }
// else {
//                Glide.with(context.getApplicationContext()).load(R.mipmap.perfect_img)
//                        .thumbnail(0.5f)
//                        .crossFade()
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(holder.adImage);
//            }
            holder.adTitle.setText(landsAds.getAdTitle());
        }




    @Override
    public int getItemCount() {
        return lands!=null?(lands.size()>5?5:lands.size()):0;
    }

    public void setData(List<LandsAds> lands) {
      this.lands =lands;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView4)
        ImageView adImage;
        @BindView(R.id.textView5)
        TextView adTitle;
        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
