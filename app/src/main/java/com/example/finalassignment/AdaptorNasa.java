package com.example.finalassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.model.NasaItem;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptorNasa extends RecyclerView.Adapter<AdaptorNasa.NasaViewHolder> {


    private List<NasaItem> imageList;
    private Context context;

    public AdaptorNasa(List<NasaItem> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }


    class NasaViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;
        TextView txtDescription;
        private ImageView coverImage;

        NasaViewHolder(View itemView) {
            super(itemView);
            this.mView = itemView;
            this.txtTitle = mView.findViewById(R.id.imgTitle);
            this.txtDescription = mView.findViewById(R.id.description);
            this.coverImage = mView.findViewById(R.id.Image);
        }
    }

    @Override
    public NasaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.nasa_row, parent, false);
        return new NasaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NasaViewHolder holder, int position) {
        holder.txtTitle.setText(imageList.get(position).getData().get(position).getTitle());
        holder.txtDescription.setText(imageList.get(position).getData().get(position).getDescription());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(imageList.get(position).getLinks().get(position).getHref())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }
    @Override
    public int getItemCount() {
        return imageList.size();
    }

}
