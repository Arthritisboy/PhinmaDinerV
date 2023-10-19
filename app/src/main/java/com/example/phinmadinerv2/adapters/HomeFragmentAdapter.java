package com.example.phinmadinerv2.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phinmadinerv2.R;
import com.example.phinmadinerv2.models.HomeFragmentModel;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeFragmentModel> list;

    Button btn_order_cancel, btn_order_buy;

    TextView orderName, stubPrice, customer;


    public HomeFragmentAdapter(Context context, ArrayList<HomeFragmentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.shapeableImageView.setImageResource(list.get(position).getHomeImage());
        AlertDialog.Builder confirmOrder = new AlertDialog.Builder(context);
        View confirmOrderLayout = LayoutInflater.from(context).inflate(R.layout.confirm_order_layout, null);
        confirmOrder.setView(confirmOrderLayout);
        confirmOrder.setCancelable(false);
        final AlertDialog dialog = confirmOrder.create();

        btn_order_cancel = (Button) confirmOrderLayout.findViewById(R.id.btn_order_cancel);
        btn_order_buy = (Button) confirmOrderLayout.findViewById(R.id.btn_order_buy);
        orderName = (TextView) confirmOrderLayout.findViewById(R.id.order_name_content);
        stubPrice = (TextView) confirmOrderLayout.findViewById(R.id.stub_price_content);
        orderName.setText(list.get(position).getHomeName());
        stubPrice.setText(list.get(position).getHomePointsString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        btn_order_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btn_order_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.menu_image);
        }
    }
}