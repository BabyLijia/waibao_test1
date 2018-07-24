package com.example.asus.waibao_test1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.waibao_test1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {


    public static TextFragment newInstance(String msg) {
        Bundle bundle = new Bundle();
        bundle.putString("msg",msg);
        TextFragment textFragment = new TextFragment();
        textFragment.setArguments(bundle);
        return textFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        String msg = getArguments().getString("msg");
        textView.setText(msg);
        return textView;

    }

}
