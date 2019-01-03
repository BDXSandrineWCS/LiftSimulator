package fr.wcs.liftsimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    private Integer[]  levelArray;
    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        levelArray= new Integer[]{7,8,9,4,5,6,1,2,3,0};

        final GridView gridview = (GridView) findViewById(R.id.grid_level);
        gridview.setAdapter(new LevelAdapter(this,levelArray));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            isLiftMoving = true;
            waitForIt();
            currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            moveNextFloor(floor);
        }
    }

    private void waitForIt() {
        // TODO : à compléter
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
}
