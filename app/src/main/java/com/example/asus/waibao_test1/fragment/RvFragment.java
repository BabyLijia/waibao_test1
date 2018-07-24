package com.example.asus.waibao_test1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.waibao_test1.R;
import com.example.asus.waibao_test1.adapter.RecyclAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RvFragment extends Fragment {


    public static RvFragment newInstance() {
        Bundle bundle = new Bundle();
        RvFragment rvFragment = new RvFragment();
        rvFragment.setArguments(bundle);
        return rvFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclAdapter(getActivity()));
        return recyclerView;
    }

}
