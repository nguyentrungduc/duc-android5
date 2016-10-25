package com.example.duc.hw153.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.hw153.R;
import com.example.duc.hw153.adapters.CategoriSortListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesSortFragment extends DialogFragment {

    @BindView(R.id.rv_categorysort)
    RecyclerView rvCategorySort;
    private CategoriSortListAdapter categoriSortListAdapter;


    public CategoriesSortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories_sort, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvCategorySort.setLayoutManager(staggeredGridLayoutManager);
        //setup adapter
        categoriSortListAdapter = new CategoriSortListAdapter();
        rvCategorySort.setAdapter(categoriSortListAdapter);
    }


}
