package com.example.jadov.americanfootballscorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String SCORE_A = "scoreA";
    private static final String SCORE_B = "scoreB";

    private TextView scoreViewA;
    private TextView scoreViewB;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt(SCORE_A, scoreTeamA);
            scoreTeamB = savedInstanceState.getInt(SCORE_B, scoreTeamB);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        scoreTeamA = savedInstanceState.getInt(SCORE_A, scoreTeamA);
        scoreTeamB = savedInstanceState.getInt(SCORE_B, scoreTeamB);

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SCORE_A, scoreTeamA);
        outState.putInt(SCORE_B, scoreTeamB);
    }

    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    public void touchdownTeamA(View view) {
        scoreTeamA += 6;
        displayForTeamA(scoreTeamA);
    }

    public void twoPointTeamA(View view) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    public void onePointConversionTeamA(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void fieldGoalTeamA(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void touchdownTeamB(View view) {
        scoreTeamB += 6;
        displayForTeamB(scoreTeamB);
    }

    public void twoPointTeamB(View view) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    public void onePointConversionTeamB(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void fieldGoalTeamB(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


}

