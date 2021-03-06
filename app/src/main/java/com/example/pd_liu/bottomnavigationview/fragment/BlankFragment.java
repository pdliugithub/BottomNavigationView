package com.example.pd_liu.bottomnavigationview.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pd_liu.bottomnavigationview.R;

import java.util.Random;

public class BlankFragment extends Fragment {

    private TextView mContentTxt;
    private int[] colors = new int[]{Color.RED, Color.GRAY, Color.GREEN, Color.YELLOW};

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mInflaterView = inflater.inflate(R.layout.fragment_blank, container, false);
        Random random = new Random();
        int value = random.nextInt(colors.length);
        mInflaterView.setBackgroundColor(colors[value]);
        mContentTxt = (TextView) mInflaterView.findViewById(R.id.content_tv);
        return mInflaterView;
    }

    /**
     * set this text content.
     * @param content string content
     */
    public void setContentTxt(String content) {
        mContentTxt.setText(content);
    }
}
