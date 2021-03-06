package com.rau.sebastian.productospracticaapp_sebas.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rau.sebastian.productospracticaapp_sebas.R;
import com.rau.sebastian.productospracticaapp_sebas.adapters.ProductAdapter;
import com.rau.sebastian.productospracticaapp_sebas.models.Product;
import com.rau.sebastian.productospracticaapp_sebas.repositories.ProductRepository;

import java.util.List;


public class FragmentHomeActivity extends Fragment {

    private static final String TAG = FragmentHomeActivity.class.getSimpleName();

    private RecyclerView productsList;

    public FragmentHomeActivity() {
    }

    //----------------------------------------------------------------------------------------------------------------------------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");



    }

    //----------------------------------------------------------------------------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Configure ReciclerView
        productsList = view.findViewById(R.id.product_list);
        productsList.setLayoutManager(new LinearLayoutManager(getContext()));
        // Set Data Adapter to ReciclerView
        List<Product> products= ProductRepository.list();
        productsList.setAdapter(new ProductAdapter(products));

        return view;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onCreateView");

    }

    //----------------------------------------------------------------------------------------------------------------------------
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onCreateView");
    }


}
