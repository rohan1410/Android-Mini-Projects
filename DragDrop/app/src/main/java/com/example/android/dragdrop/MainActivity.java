package com.example.android.dragdrop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.textView1).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(null, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE); //drag me text should be made invisible on parent layout
                    return true;
                }
                else {
                    return false;
                }
            }
        });
        findViewById(R.id.pinkLayout).setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View layoutview, DragEvent dragevent) {
                int action = dragevent.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Log.d("MainActivity:", "Drag event started");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d("MainActivity:", "Drag event entered into "+layoutview.toString());
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d("MainActivity:", "Drag event exited from "+layoutview.toString());
                        break;
                    case DragEvent.ACTION_DROP:
                        Log.d("MainActivity:", "Dropped");
                        View view = (View) dragevent.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        LinearLayout container = (LinearLayout) layoutview;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d("MainActivity:", "Drag ended");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        findViewById(R.id.yellowLayout).setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View layoutview, DragEvent dragevent) {
                int action = dragevent.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Log.d("MainActivity:", "Drag event started");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d("MainActivity:", "Drag event entered into "+layoutview.toString());
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d("MainActivity:", "Drag event exited from "+layoutview.toString());
                        break;
                    case DragEvent.ACTION_DROP:
                        Log.d("MainActivity:", "Dropped");
                        View view = (View) dragevent.getLocalState();   //text drag me view is taken
                        ViewGroup owner = (ViewGroup) view.getParent(); //parent viewgroup of drag me
                        owner.removeView(view);  //drag me view gets removed from the parent viewgroup
                        LinearLayout container = (LinearLayout) layoutview;
                        container.addView(view);   //drag me view gets added in the new group
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d("MainActivity:", "Drag ended");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
