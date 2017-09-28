package com.silver5302.submitmaterial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by alfo06-19 on 2017-06-19.
 */

public class Fragment02 extends Fragment {

    ArrayList<Item02> item02s=new ArrayList<>();
    RecyclerAdapter02 adapter02;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        item02s.add(new Item02(R.drawable.alexis,"AlexisSanchez","Nation : Chile","Position : FW"));
        item02s.add(new Item02(R.drawable.dinho,"Ronaldinho","Nation : Brazil","Position : FW"));
        item02s.add(new Item02(R.drawable.drogba,"Drogba","Nation : IvoryCoast","Position : FW"));
        item02s.add(new Item02(R.drawable.gerrad,"Gerrard","Nation : England","Position : MF"));
        item02s.add(new Item02(R.drawable.hazrd,"Hazard","Nation : Belgium","Position : MF"));
        item02s.add(new Item02(R.drawable.ibra,"Ibrahimovic","Nation : Sweden","Position : FW"));
        item02s.add(new Item02(R.drawable.iniesta,"Iniesta","Nation : Spain","Position : MF"));
        item02s.add(new Item02(R.drawable.messi,"Messi","Nation : Argentina","Position : FW"));
        item02s.add(new Item02(R.drawable.neymar,"Neymar","Nation : Brazil","Position : FW"));
        item02s.add(new Item02(R.drawable.ozil,"Ozil","Nation : Germany","Position : MF"));
        item02s.add(new Item02(R.drawable.pogba,"Pogba","Nation : France","Position : MF"));
        item02s.add(new Item02(R.drawable.rampard,"Lampard","Nation : England","Position : MF"));
        item02s.add(new Item02(R.drawable.ronaldo,"Ronaldo","Nation : Portugal","Position : FW"));
        item02s.add(new Item02(R.drawable.rooney,"Rooney","Nation : England","Position : FW"));
        item02s.add(new Item02(R.drawable.son,"손흥민","Nation : Korea","Position : FW"));
        item02s.add(new Item02(R.drawable.zidane,"Zidane","Nation : France","Position : MF"));
        item02s.add(new Item02(R.drawable.young,"AshleyYoung","Nation : England","Position : MF"));
        item02s.add(new Item02(R.drawable.torres,"Torres","Nation : Spain","Position : FW"));
        item02s.add(new Item02(R.drawable.xavi,"Xavi","Nation : Spain","Position : MF"));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View page=inflater.inflate(R.layout.layout_fragment02,container,false);

        recyclerView=(RecyclerView)page.findViewById(R.id.recycler);
        adapter02=new RecyclerAdapter02(item02s,getActivity());
        recyclerView.setAdapter(adapter02);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);



        return page;
    }
}
