package com.example.android.courtcounter2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreforA=0;
    int scoreforB=0;

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
    public void addThreeforA(View v)
    {
        scoreforA=scoreforA+3;
        displayForTeamA(scoreforA);
    }
    public void addTwoforA(View v)
    {
        scoreforA = scoreforA + 2;
        displayForTeamA(scoreforA);
    }
    public void addOneforA(View v)
    {
        scoreforA=scoreforA+1;
        displayForTeamA(scoreforA);
    }
    public void addThreeforB(View v)
    {
        scoreforB=scoreforB+3;
        displayForTeamB(scoreforB);
    }
    public void addTwoforB(View v)
    {
        scoreforB = scoreforB + 2;
        displayForTeamB(scoreforB);
    }
    public void addOneforB(View v)
    {
        scoreforB=scoreforB+1;
        displayForTeamB(scoreforB);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void resetScore(View v)
    {
        scoreforA =0;
        scoreforB=0;
        displayForTeamA(scoreforA);
        displayForTeamB(scoreforB);
    }
}
