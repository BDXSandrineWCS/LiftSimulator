package fr.wcs.liftsimulator;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelAdapter extends BaseAdapter {

    private Context context;
    private Integer[] levelArray;

    public LevelAdapter(Context context, Integer[] levelArray) {
        this.context = context;
        this.levelArray=levelArray;
    }

    @Override
    public int getCount() {
        return levelArray.length;
    }

    @Override
    public Object getItem(int position) {
        return levelArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView levelButton;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            levelButton = new TextView(context);
            ViewGroup.LayoutParams layoutButton =new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            levelButton.setLayoutParams(layoutButton);
            levelButton.setBackgroundColor(context.getResources().getColor(R.color.colorButton));


        } else {
            levelButton = (TextView) convertView;
        }

        levelButton.setText(levelArray[position].toString());
        levelButton.setClickable(true);
        levelButton.setEnabled(true);
        levelButton.setFocusable(true);
        levelButton.setGravity(Gravity.CENTER);
        levelButton.setPadding(0,16,0,16);

        return levelButton;
    }



}
