package com.example.bbizet.javarssfeed.row;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bbizet.javarssfeed.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bbizet on 26/04/2017.
 */

public class FluxRowAdapter extends ArrayAdapter<FluxRow>{
    public FluxRowAdapter(Context context, List<FluxRow> rows) {
        super(context, 0, rows);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_flux,parent, false);
        }
        FluxViewHolder viewHolder = (FluxViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new FluxViewHolder();
            viewHolder.flux_title = (TextView) convertView.findViewById(R.id.flux_title);
            viewHolder.flux_descri = (TextView) convertView.findViewById(R.id.flux_description);
            viewHolder.date = (TextView) convertView.findViewById(R.id.flux_date);
            convertView.setTag(viewHolder);
            viewHolder.flux_id = 0;
        }
        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        FluxRow flux = getItem(position);


        viewHolder.flux_title.setText(flux.getTitle());
        viewHolder.flux_descri.setText(flux.getDescription());
        viewHolder.date.setText(flux.getPubDate());
        viewHolder.flux_id = flux.getIdfeed();

        return convertView;
    }

    public int getFluxId(int position)
    {
        FluxRow select = getItem(position);

        return select.getIdfeed();
    }


    private class FluxViewHolder{
        public int  flux_id;
        public TextView flux_title;
        public TextView flux_descri;
        public TextView date;
    }
}
