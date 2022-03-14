package com.example.ongk;

import android.content.Context;
import android.graphics.Color;
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

import java.util.List;
import java.util.concurrent.TimeoutException;

public class DonutAdapter extends BaseAdapter {
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
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvdescription = (TextView) view.findViewById(R.id.tvDescription);
        TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);
        ImageView imageView = (ImageView) view.findViewById(R.id.logo);
        final ConstraintLayout contraintLayout = (ConstraintLayout) view.findViewById(R.id.idContraintLayout);
        final Donut donut = listDonut.get(position);
        if (listDonut != null && !listDonut.isEmpty()) {
            tvName.setText(donut.getTen());
            tvdescription.setText(donut.getMoTa());
            tvPrice.setText(donut.getGia());
            int idDount = donut.getId();
            switch (idDount) {
                case 1:
                    imageView.setImageResource(R.drawable.donut_red_1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.donut_yellow_1);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.green_donut_1);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.tasty_donut_1);
                    break;
                default:
                    break;
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, donut.getTen(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });


        return view;
    }

}
