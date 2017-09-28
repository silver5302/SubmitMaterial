package com.silver5302.submitmaterial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-19 on 2017-06-19.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    ArrayList<Item> items;
    Context context;

    public RecyclerAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);

        MyHolder holder=new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyHolder holder, int position) {

        holder.title.setText(items.get(position).title);
        holder.desc.setText(items.get(position).desc);
        holder.date.setText(items.get(position).date);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView title,desc,date;
        public MyHolder(final View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.tv_title);
            desc=(TextView)itemView.findViewById(R.id.tv_desc);
            date=(TextView)itemView.findViewById(R.id.tv_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String link=items.get(getLayoutPosition()).link;
                    Intent intent=new Intent(context,WebViewActivity.class);
                    intent.putExtra("link",link);
                    context.startActivity(intent);
                }
            });
        }
    }
}
