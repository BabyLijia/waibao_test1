package com.example.asus.waibao_test1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.asus.tab_list.VpHeadActivity;
import com.example.asus.waibao_test1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_rv;
    private Button bt_vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_rv = (Button) findViewById(R.id.bt_rv);
        bt_vp = (Button) findViewById(R.id.bt_vp);

        bt_rv.setOnClickListener(this);
        bt_vp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,v.getId()==R.id.bt_rv?RvHeadActivity.class:VpHeadActivity.class);
        startActivity(intent);
    }
}
