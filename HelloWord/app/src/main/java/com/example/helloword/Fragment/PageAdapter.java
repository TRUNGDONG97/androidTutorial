package com.example.helloword.Fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> data;
    //ArrayList<String> listTitle = new ArrayList<>();
    Context context;


    public PageAdapter(FragmentManager fm,ArrayList<Fragment> data,Context context) {
        super( fm );
        this.data=data;
        this.context=context;
    }

    @Override
    public Fragment getItem(int i) {
        return data.get( i );
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
