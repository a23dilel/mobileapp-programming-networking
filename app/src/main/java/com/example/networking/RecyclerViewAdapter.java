package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<Mountain> mountains;
    public RecyclerViewAdapter(Context context, ArrayList<Mountain> mountains){
        this.context = context;
        this.mountains = mountains;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This one does inflate the layout for example giving a look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        // this one does give values to the views which created in the layout file
        holder.textViewMountainsID.setText(String.format("%s %s", context.getString(R.string.mountains_id), mountains.get(position).getID()));
        holder.textViewMountainsName.setText(String.format("%s %s", context.getString(R.string.mountains_name), mountains.get(position).getName()));
        holder.textViewMountainsType.setText(String.format("%s %s", context.getString(R.string.mountains_type), mountains.get(position).getType()));
    }

    @Override
    public int getItemCount() {
        // this one does show how many views is there to show displayed
        return mountains.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grab the views from layout file almost like onCreate

        TextView textViewMountainsID;
        TextView textViewMountainsName;
        TextView textViewMountainsType;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewMountainsID = itemView.findViewById(R.id.textViewMountainsID);
            textViewMountainsName = itemView.findViewById(R.id.textViewMountainsName);
            textViewMountainsType = itemView.findViewById(R.id.textViewMountainsType);

        }
    }
}
