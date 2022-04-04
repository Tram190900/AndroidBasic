package com.example.lab7_listtravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterTravel extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Travel> listTravel;
    private int positionSelect = -1;
    public AdapterTravel(Context context,int idLayout, List<Travel> listTravel){
        this.context = context;
        this.idLayout = idLayout;
        this.listTravel = listTravel;
    }
    @Override
    public int getCount() {
        if(!listTravel.isEmpty() && listTravel.size() > 0)
            return listTravel.size();
        return 0;
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
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup, false);
        }
        TextView tvId = view.findViewById(R.id.tv_id);
        TextView tvName = view.findViewById(R.id.tv_Name);
        tvId.setText(listTravel.get(i).getId());
        tvName.setText(listTravel.get(i).getName());
        return view;
    }
}
