package com.example.drawerlayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private List<Fragment> lists;
    public void setFragments(List<Fragment> list){
        lists = list;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = lists.get(position);

        return fragment;
    }

    @Override
    public int getCount() {
        return lists.size();
    }


}
