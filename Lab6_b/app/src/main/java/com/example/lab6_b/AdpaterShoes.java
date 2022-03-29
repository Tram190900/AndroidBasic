package com.example.lab6_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdpaterShoes extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Shoes> lstShoes;
    private int positionSelection = -1;

    public AdpaterShoes(Context context, int idLayout, List<Shoes> lstShoes) {
        this.context = context;
        this.idLayout = idLayout;
        this.lstShoes = lstShoes;
    }

    @Override
    public int getCount() {
        return lstShoes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }
        TextView tvMoTa = view.findViewById(R.id.tvMoTa);
        ImageView img = view.findViewById(R.id.imgShoes);

        tvMoTa.setText(lstShoes.get(i).getMoTa());
        img.setImageResource(lstShoes.get(i).getImg());
        return view;
    }
}
