package com.silver5302.submitmaterial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by alfo06-19 on 2017-06-19.
 */

public class Fragment01 extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<Item> items = new ArrayList<>();
    Item item;
    Spinner spinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View page = inflater.inflate(R.layout.layout_fragment01, container, false);


        recyclerView = (RecyclerView) page.findViewById(R.id.recycler);
        adapter = new RecyclerAdapter(items, getActivity());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(page.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        spinner = (Spinner) page.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    items.clear();
                    new ParsingTask().execute("http://www.footballjournal.co.kr/rss/S1N1.xml");

                } else if(position==1){
                    items.clear();
                    new ParsingTask().execute("http://www.footballjournal.co.kr/rss/S1N6.xml");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return page;
    }



    class ParsingTask extends AsyncTask<String, Void, Void> {


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

            adapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(String... params) {


            try {
                URL url = new URL(params[0]);
                InputStream is = url.openStream();

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(is, "euc-kr");

                int eventType = xpp.next();
                String name;


                while (eventType != XmlPullParser.END_DOCUMENT) {

                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            name = xpp.getName();

                            if (name.equals("item")) {

                                item = new Item();
                            } else if (name.equals("title")) {
                                if (item == null) break;
                                xpp.next();
                                item.title = xpp.getText();

                            } else if (name.equals("link")) {
                                if (item == null) break;
                                xpp.next();
                                item.link = xpp.getText();
                                item.link = item.link.replace("http://www.", "http://m.");

                            } else if (name.equals("description")) {
                                if (item == null) break;
                                xpp.next();
                                item.desc = xpp.getText();
                                item.desc = item.desc.replace("&nbsp;&nbsp;&nbsp;&nbsp;", "");

                            } else if (name.equals("pubDate")) {
                                if (item == null) break;
                                xpp.next();
                                item.date = xpp.getText();

                            }

                            break;


                        case XmlPullParser.END_TAG:
                            name = xpp.getName();
                            if (name.equals("item")) {
                                items.add(item);
                                publishProgress();
                            }
                            break;
                    }

                    eventType = xpp.next();

                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
