package fr.wcs.liftsimulator;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button levelButton;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            levelButton = new Button(context);
            levelButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            levelButton.setBackgroundColor(context.getResources().getColor(R.color.colorButton));

        } else {
            levelButton = (Button) convertView;
        }

        levelButton.setText(levelArray[position].toString());
        return levelButton;
    }



}
