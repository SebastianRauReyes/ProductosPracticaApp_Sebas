package com.rau.sebastian.productospracticaapp_sebas.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rau.sebastian.productospracticaapp_sebas.R;

public class FragmentArchivedActivity extends Fragment {

    private static final String TAG = FragmentArchivedActivity.class.getSimpleName();

    public FragmentArchivedActivity() {
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
        View view = inflater.inflate(R.layout.fragment_archived, container, false);
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
