package fr.wcs.liftsimulator;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity
{

    private Integer[]  levelArray;
    private boolean isLiftMoving = false;
    private int currentFloor = 0;
    protected static Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            isLiftMoving = true; 
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            new MoveLift().execute(floor);
        }
    }

    public Integer[] getLevelArray() {
        return levelArray;
    }

    public void setLevelArray(Integer[] levelArray) {
        this.levelArray = levelArray;
    }

    public boolean isLiftMoving() {
        return isLiftMoving;
    }

    public void setLiftMoving(boolean liftMoving) {
        isLiftMoving = liftMoving;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }


    private void init(){
        appContext=getApplicationContext();
        levelArray= new Integer[]{7,8,9,4,5,6,1,2,3,0};

        GridView gridview = (GridView) findViewById(R.id.grid_level);
        LevelAdapter levelAdapter= new LevelAdapter(this,levelArray);
        gridview.setAdapter(levelAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToFloor((int)id);
            }
        });
    }

    private class MoveLift extends AsyncTask<Integer ,Void, Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Integer doInBackground(Integer... ints) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ints[0];

        }

        @Override
        protected void onPostExecute(Integer level) {
            super.onPostExecute(level);
            currentFloor = (level > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            moveNextFloor(level);
        }

    }

}
