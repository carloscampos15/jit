package com.campos.jit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.campos.jit.R;
import com.campos.jit.models.Enterprise;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Enterprise> enterprises;

    public HomeAdapter(Context context, int layout, ArrayList<Enterprise> enterprises) {
        this.context = context;
        this.layout = layout;
        this.enterprises = enterprises;
    }

    @Override
    public int getCount() {
        return this.enterprises.size();
    }

    @Override
    public Object getItem(int position) {
        return this.enterprises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.list_item_home, null);
        Enterprise currentEnterprise = enterprises.get(position);

        //Poner la imagen
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewBtnHome);
        Picasso.get().load(currentEnterprise.getUrl_image()).into(imageView);

        //Asignar el texto
        TextView textView = (TextView) view.findViewById(R.id.textViewBtnHome);
        textView.setText(currentEnterprise.getName());

        return view;
    }
}
