package com.silver5302.submitmaterial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alfo06-19 on 2017-06-19.
 */

public class PagerAdapter extends FragmentPagerAdapter {


    Fragment[] fragments=new Fragment[2];
        String[] title=new String[]{"축구기사","축구스페셜"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new Fragment01();
        fragments[1]=new Fragment02();
    }


    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }


    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
