package com.example.lab9_storage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterName extends BaseAdapter {
    private Context context;
    private List<Name> lstName;
    private int idLayout;
    private int positionSelection = -1;

    public AdapterName(Context context, int idLayout, List<Name> nameList){
        this.context = context;
        this.idLayout = idLayout;
        this.lstName = nameList;
    }

    @Override
    public int getCount() {
        if(!lstName.isEmpty() && lstName.size()>0)
            return lstName.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }
        TextView tvName = view.findViewById(R.id.tvName);
        ImageView imgName = view.findViewById(R.id.imgName);

        Picasso.get().load(lstName.get(i).getImg()).into(imgName);
        tvName.setText(lstName.get(i).getName());
        return view;
    }
}

