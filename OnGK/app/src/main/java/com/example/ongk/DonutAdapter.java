package com.example.ongk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class DonutAdapter extends BaseAdapter{
    private Context context;
    private int idLayout;
    private List<Donut> listDonut;
    private int positionSelect = -1;

    public DonutAdapter(Context context, int idLayout, List<Donut> lst){
        this.context = context;
        this.idLayout = idLayout;
        this.listDonut = lst;
    }
    @Override
    public int getCount() {
        if(listDonut.size()!=0&&!listDonut.isEmpty())
            return listDonut.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvdescription = view.findViewById(R.id.tvDescription);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        ImageView imageView = view.findViewById(R.id.logo);
        final ConstraintLayout contraintLayout = view.findViewById(R.id.idContraintLayout);
        final Donut donut = listDonut.get(position);
        if (listDonut != null && !listDonut.isEmpty()) {
            imageView.setImageResource(donut.getId());
            tvName.setText(donut.getTen());
            tvdescription.setText(donut.getMoTa());
            tvPrice.setText(donut.getGia());
//            int idDount = donut.getId();
//            switch (idDount) {
//                case 1:
//                    imageView.setImageResource(R.drawable.donut_red_1);
//                    break;
//                case 2:
//                    imageView.setImageResource(R.drawable.donut_yellow_1);
//                    break;
//                case 3:
//                    imageView.setImageResource(R.drawable.green_donut_1);
//                    break;
//                case 4:
//                    imageView.setImageResource(R.drawable.tasty_donut_1);
//                    break;
//                default:
//                    break;
//            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DonutActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putInt("id",listDonut.get(position).getId());
//                bundle.putString("name",listDonut.get(position).getTen());
//                bundle.putString("description",listDonut.get(position).getMoTa());
//                bundle.putString("price",listDonut.get(position).getGia());
//                bundle.putString("loai",listDonut.get(position).getLoai());
                intent.putExtra("selection",donut);
                context.startActivity(intent);
            }
        });


        return view;
    }



}
