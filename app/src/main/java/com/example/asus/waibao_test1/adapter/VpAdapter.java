package com.example.asus.waibao_test1.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asus.waibao_test1.fragment.RvFragment;
import com.example.asus.waibao_test1.fragment.TextFragment;

public class VpAdapter extends FragmentPagerAdapter {
    public VpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return RvFragment.newInstance();
                default:
                    return TextFragment.newInstance("TextFragment : " + position);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "VpAdapter   TAB"+position;
    }
}
