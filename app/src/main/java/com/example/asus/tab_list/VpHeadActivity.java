package com.example.asus.tab_list;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.asus.waibao_test1.R;

import java.util.ArrayList;
import java.util.List;

public class VpHeadActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    private TabLayout mTabLayout;
    private ListView mlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_head);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            String text = null;
            switch (i) {
                case 0:
                    text = "宝贝";
                    break;
                case 1:
                    text = "详情";
                    break;
                case 2:
                    text = "推荐";
                    break;
            }
            SpannableStringBuilder textC = new SpannableStringBuilder(text);
            textC.setSpan(new ForegroundColorSpan(Color.BLACK), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            textC.setSpan(new AbsoluteSizeSpan(22, true), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            mTabLayout.addTab(mTabLayout.newTab().setText(textC), i, i == 0);
        }
    }

    int a;
    private List<String> mList=new ArrayList();
    private void initView() {
        mlv = (ListView) findViewById(R.id.mlv);
        mList.add("宝贝");
        mList.add("详情");
        mList.add("推荐");
        LvAdapter lvAdapter = new LvAdapter(VpHeadActivity.this, mList);
        mlv.setAdapter(lvAdapter);
        mlv.setOnScrollListener(this);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               CharSequence text = tab.getText();
                for (int i = 0; i < mList.size(); i++) {
                    if(mList.get(i).contains(text)){
                        a=i;
                        break;
                    }
                }
                mlv.setSelection(a);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    int b;
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (b){
            case 0:
                TabLayout.Tab tabAt = mTabLayout.getTabAt(b);
                tabAt.select();
                break;
            case 1:
                tabAt = mTabLayout.getTabAt(b);
                tabAt.select();
                break;
            case 2:
                tabAt = mTabLayout.getTabAt(b);
                tabAt.select();
                break;


        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            switch (firstVisibleItem){
                case 0:
                    b=0;
                    break;
                case 1:
                    b=firstVisibleItem;
                    break;
                case 2:
                    b=firstVisibleItem;
                    break;
            }
    }
}
