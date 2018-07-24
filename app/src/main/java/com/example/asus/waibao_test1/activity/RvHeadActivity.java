package com.example.asus.waibao_test1.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.waibao_test1.R;
import com.example.asus.waibao_test1.adapter.RecyclAdapter;
import com.example.asus.waibao_test1.scrollview.StickHeadScrollView;

public class RvHeadActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StickHeadScrollView sv;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_head);
        initView();
    }

    private void initView() {
        //recyclerView适配器
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclAdapter(RvHeadActivity.this));
        //mSwipeRefreshLayout 上拉加载，下拉刷新监听
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sl);
        //设置监听，需要重写onRefresh()方法，顶部下拉时会调用这个方法，在里面实现请求数据的逻辑，设置下拉进度条消失等等
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RvHeadActivity.this, "fresh finish", Toast.LENGTH_SHORT).show();
                //设置刷新状态，true表示正在刷新，false表示取消刷新
                mSwipeRefreshLayout.setRefreshing(false);

            }
        });
        View headView = (TextView) findViewById(R.id.tv_head);
        headView.setFocusable(true);
        headView.setFocusableInTouchMode(true);
        headView.requestFocus();

        //set Hight
        sv = (StickHeadScrollView) findViewById(R.id.sv);
        sv.resetHeight(headView,recyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toggle,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.refresh_toggle:
                mSwipeRefreshLayout.setEnabled(!mSwipeRefreshLayout.isEnabled());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
