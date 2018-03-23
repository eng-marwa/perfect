package eg.com.perfect_contracting.perfect.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eg.com.perfect_contracting.perfect.R;

/**
 * Created by java on 14/10/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private Context context;
    public NewsAdapter(Context context){
       this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_card,parent,false));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        public NewsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
