package com.silver5302.submitmaterial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by alfo06-19 on 2017-06-21.
 */

public class RecyclerAdapter02 extends RecyclerView.Adapter<RecyclerAdapter02.MyHolder02> {

    ArrayList<Item02> item02s;
    Context context;

    public RecyclerAdapter02(ArrayList<Item02> item02s, Context context) {
        this.item02s = item02s;
        this.context = context;
    }

    @Override
    public RecyclerAdapter02.MyHolder02 onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item02, parent, false);

        MyHolder02 holder02 = new MyHolder02(view);

        return holder02;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter02.MyHolder02 holder, int position) {

        Glide.with(context).load(item02s.get(position).img).into(holder.img);
        holder.name.setText(item02s.get(position).name);
        holder.nation.setText(item02s.get(position).nation);
        holder.position.setText(item02s.get(position).position);

    }

    @Override
    public int getItemCount() {
        return item02s.size();
    }

    class MyHolder02 extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        TextView nation;
        TextView position;

        public MyHolder02(View itemView) {
            super(itemView);


            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            nation = (TextView) itemView.findViewById(R.id.tv_nation);
            position = (TextView) itemView.findViewById(R.id.tv_position);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/results?search_query="
                            +item02s.get(getLayoutPosition()).name)).setPackage("com.google.android.youtube");
                    context.startActivity(intent);
                }
            });

        }
    }
}
