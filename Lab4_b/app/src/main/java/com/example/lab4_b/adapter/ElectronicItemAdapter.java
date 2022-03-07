package com.example.lab4_b.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.lab4_b.R;
import com.example.lab4_b.model.ElectronicItem;

import java.util.List;

public class ElectronicItemAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<ElectronicItem> listElectronicItem;
    private int positionSelect = -1;

    public ElectronicItemAdapter(Context context, int idLayout, List<ElectronicItem> lst){
        this.context = context;
        this.idLayout = idLayout;
        this.listElectronicItem = lst;
    }

    @Override
    public int getCount() {
        if(listElectronicItem.size()!=0&&!listElectronicItem.isEmpty()){
            return listElectronicItem.size();
        }
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }
        ImageView imgItem = (ImageView) view.findViewById(R.id.imgItem);
        TextView tvItemName = (TextView) view.findViewById(R.id.txtName);
        TextView tvSLDanhGia = (TextView) view.findViewById(R.id.txtSoLuongDanhGia);
        TextView tvGia = (TextView) view.findViewById(R.id.txtPrice);
        TextView tvSale = (TextView) view.findViewById(R.id.txtSale);

        final ConstraintLayout constraintLayout = view.findViewById(R.id.idConstraintLayout);
        final ElectronicItem electronicItem = listElectronicItem.get(position);

        if (listElectronicItem != null && !listElectronicItem.isEmpty()){
            int idItem = electronicItem.getIdItem();
            switch (idItem){
                case 1:
                    imgItem.setImageResource(R.drawable.giacchuyen_1);
                    break;
                case 2:
                    imgItem.setImageResource(R.drawable.daynguon_1);
                    break;
                case 3:
                    imgItem.setImageResource(R.drawable.dauchuyendoipsps2_1);
                    break;
                case 4:
                    imgItem.setImageResource(R.drawable.dauchuyendoi_1);
                    break;
                case 5:
                    imgItem.setImageResource(R.drawable.carbusbtops2_1);
                    break;
                case 6:
                    imgItem.setImageResource(R.drawable.daucam_1);
                    break;
                default:
                    break;
            }
            tvItemName.setText(electronicItem.getName());
            tvSLDanhGia.setText(electronicItem.getSlDanhGia());
            tvGia.setText(electronicItem.getGia());
            tvSale.setText(electronicItem.getSale());
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, electronicItem.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });
        if (positionSelect == position) {
            constraintLayout.setBackgroundColor(Color.LTGRAY);
        } else {
            constraintLayout.setBackgroundColor(Color.WHITE);
        }
        return view;
    }
}
