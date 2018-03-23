package eg.com.perfect_contracting.perfect.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.model.Design;
import eg.com.perfect_contracting.perfect.util.DynamicHeightNetworkImageView;


/**
 * Created by MarwaTalaat on 4/5/2017.
 */
public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.ArticleViewHolder> {
    private Context mContext;
    private List<Design> pic;

    public DesignAdapter(Context context) {
        mContext = context;

    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_thumbinal, parent, false);
        return new ArticleViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Design design = pic.get(position);
       // holder.titleView.setText(design.getTitle());
        Glide.with(mContext)
                .load(design.getImage())
                .placeholder(R.mipmap.aa)
                .into(holder.thumbnailView);
        holder.titleView.setText(design.getTitle());

    }
    @Override
    public int getItemCount() {
        return pic!=null?pic.size():0;
    }

    public void setData(List<Design> pic) {
        this.pic = pic;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailView;
        public TextView titleView;

        public ArticleViewHolder(View view) {
            super(view);
            thumbnailView = (ImageView) view.findViewById(R.id.thumbnail);
            titleView = (TextView) view.findViewById(R.id.article_title);

        }
    }


}
