package com.example.phinmadinerv2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phinmadinerv2.R;
import com.example.phinmadinerv2.models.FoodsFragmentModel;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class FoodsFragmentAdapter extends RecyclerView.Adapter<FoodsFragmentAdapter.ViewHolder> {
    Context context;
    List<FoodsFragmentModel> list;

    public FoodsFragmentAdapter(Context context, List<FoodsFragmentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.foods_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.shapeableImageView.setImageResource(list.get(position).getFoodsImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.foods_image);
        }
    }
}
