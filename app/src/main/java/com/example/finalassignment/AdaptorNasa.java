package com.example.finalassignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.model.NasaCollection;
import com.example.finalassignment.model.NasaItem;
import com.example.finalassignment.model.NasaItemData;
import com.example.finalassignment.model.NasaItemLink;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptorNasa extends RecyclerView.Adapter<AdaptorNasa.NasaViewHolder> {


    private View.OnClickListener onItemClickListener;
    private NasaCollection imagecollection;
    private Context context;

    public AdaptorNasa(NasaCollection imageList, Context context) {
        this.imagecollection = imageList;
        this.context = context;
    }


    public void setItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }
    public NasaItem getItem(int position) {
        if (imagecollection.getItems() != null && position >= 0 && position < imagecollection.getItems().size()) {
            return imagecollection.getItems().get(position);
        } else {
            return null;
        }
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
            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);
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
        List<NasaItem> items = imagecollection.getItems();

        // Check if items is not null and position is within bounds
        if (items != null && position >= 0 && position < items.size()) {
            NasaItem item = items.get(position);
            List<NasaItemData> dataList = item.getData();
            List<NasaItemLink> linksList = item.getLinks();

            // Check if dataList and linksList are not null and not empty because the api sometimes return null values
            if (dataList != null && !dataList.isEmpty() && linksList != null && !linksList.isEmpty()) {
                holder.txtTitle.setText(dataList.get(0).getTitle());
                holder.txtDescription.setText(dataList.get(0).getDescription());

                Picasso.Builder builder = new Picasso.Builder(context);
                builder.downloader(new OkHttp3Downloader(context));
                builder.build().load(linksList.get(0).getHref())
                        .placeholder((R.drawable.ic_launcher_background))
                        .error(R.drawable.ic_launcher_background)
                        .into(holder.coverImage);
            } else {
                holder.txtTitle.setText("No Title");
                holder.txtDescription.setText("No Description");
                holder.coverImage.setImageResource(R.drawable.ic_launcher_background);
                Log.d("AB", "itemsData and image is empty");

            }
        } else {
            Log.d("AB", "items is empty");
        }
    }

    @Override
    public int getItemCount() {
        return imagecollection.getItems() != null ? imagecollection.getItems().size() : 0;
    }

}
