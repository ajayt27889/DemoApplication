package com.ajay.demoapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ajay.demoapplication.R;
import com.ajay.demoapplication.model.unsplash.Photo;
import java.util.List;
import javax.inject.Inject;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{

    @Inject
    public PhotoAdapter(){
    }

    List<Photo> photos;
    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_photos, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.name.setText(photos.get(position).getAltDescription());
        holder.color.setText(""+photos.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void submitNewList(List<Photo> photos){
        this.photos = photos;
        notifyDataSetChanged();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView color;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            color = itemView.findViewById(R.id.color);
        }
    }
}
