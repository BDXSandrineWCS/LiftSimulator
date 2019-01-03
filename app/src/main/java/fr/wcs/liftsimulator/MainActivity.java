package fr.wcs.liftsimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    private Integer[]  levelArray;

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
                Toast.makeText(gridview.getContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
