package com.example.phinmadinerv2.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.phinmadinerv2.R;
import com.example.phinmadinerv2.models.DealsFragmentModel;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DealsFragmentAdapter extends RecyclerView.Adapter<DealsFragmentAdapter.ViewHolder> {
    Context context;
    List<DealsFragmentModel> list;

    Button btn_order_cancel, btn_order_buy;
    TextView orderName, stubPrice;
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_POINTS = "points";


    public DealsFragmentAdapter(Context context, List<DealsFragmentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.shapeableImageView.setImageResource(list.get(position).getDealsImage());
        AlertDialog.Builder confirmOrder = new AlertDialog.Builder(context);
        View confirmOrderLayout = LayoutInflater.from(context).inflate(R.layout.confirm_order_layout, null);
        confirmOrder.setView(confirmOrderLayout);
        confirmOrder.setCancelable(false);
        final AlertDialog dialog = confirmOrder.create();

        btn_order_cancel = (Button) confirmOrderLayout.findViewById(R.id.btn_order_cancel);
        btn_order_buy = (Button) confirmOrderLayout.findViewById(R.id.btn_order_buy);
        orderName = (TextView) confirmOrderLayout.findViewById(R.id.order_name_content);
        stubPrice = (TextView) confirmOrderLayout.findViewById(R.id.stub_price_content);
        orderName.setText(list.get(position).getDealsName());
        stubPrice.setText(list.get(position).getDealsPointsString());
        SharedPreferences sp = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        float points = sp.getFloat("Points", 0);

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
                if(list.get(position).getDealsPoints() <= points) {
                    SharedPreferences.Editor editor = sp.edit();
                    float pointsToSubtract = list.get(position).getDealsPoints();
                    float newValueofPoints = points - pointsToSubtract;
                    editor.putFloat("Points", newValueofPoints);
                    editor.apply();
                    dialog.dismiss();
                    updateDatabasePoints();

                } else {
                    Toast.makeText(context, "You don't have enough points", Toast.LENGTH_SHORT).show();
                }

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
            shapeableImageView = itemView.findViewById(R.id.deals_image);
        }
    }
    private void updateDatabasePoints(){
        SharedPreferences sp = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        String Username = sp.getString("Username", "");
        String Email = sp.getString("Email", "");
        float Points = sp.getFloat("Points", 0.0f);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://phinmadiner.000webhostapp.com/updatepoints.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, ""+error, Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, Username);
                map.put(KEY_EMAIL, Email);
                map.put(KEY_POINTS, String.valueOf(Points));
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}