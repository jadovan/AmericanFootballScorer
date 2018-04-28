package com.example.jadov.americanfootballscorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // declare variables
    private static final String SCORE_A = "scoreA";
    private static final String SCORE_B = "scoreB";
    private static final String TIMEOUT_A = "timeoutA";
    private static final String TIMEOUT_B = "timeoutB";

    private TextView scoreViewA;
    private TextView scoreViewB;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    private TextView timeoutViewA;
    private TextView timeoutViewB;
    private int timeoutTeamA = 3;
    private int timeoutTeamB = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call TextViews
        scoreViewA = findViewById(R.id.team_a_score);
        timeoutViewA = findViewById(R.id.timeouts_team_a);
        scoreViewB = findViewById(R.id.team_b_score);
        timeoutViewB = findViewById(R.id.timeouts_team_b);

        displayForTeamA(scoreTeamA);
        timeoutForTeamA(timeoutTeamA);
        displayForTeamB(scoreTeamB);
        timeoutForTeamB(timeoutTeamB);

        // handles orientation changes
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt(SCORE_A, scoreTeamA);
            timeoutTeamA = savedInstanceState.getInt(TIMEOUT_A, timeoutTeamA);
            scoreTeamB = savedInstanceState.getInt(SCORE_B, scoreTeamB);
            timeoutTeamB = savedInstanceState.getInt(TIMEOUT_B, timeoutTeamB);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // handles orientation changes
        scoreTeamA = savedInstanceState.getInt(SCORE_A, scoreTeamA);
        timeoutTeamA = savedInstanceState.getInt(TIMEOUT_A, timeoutTeamA);
        scoreTeamB = savedInstanceState.getInt(SCORE_B, scoreTeamB);
        timeoutTeamB = savedInstanceState.getInt(TIMEOUT_B, timeoutTeamB);

        displayForTeamA(scoreTeamA);
        timeoutForTeamA(timeoutTeamA);
        displayForTeamB(scoreTeamB);
        timeoutForTeamB(timeoutTeamB);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // handles orientation changes
        outState.putInt(SCORE_A, scoreTeamA);
        outState.putInt(TIMEOUT_A, timeoutTeamA);
        outState.putInt(SCORE_B, scoreTeamB);
        outState.putInt(TIMEOUT_B, timeoutTeamB);
    }

    // displays score for Team A
    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    // displays timeouts for Team A
    public void timeoutForTeamA(int timeout) {
        timeoutViewA.setText(String.valueOf(timeout));
    }

    // displays score for Team B
    public void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    // displays timeouts for Team B
    public void timeoutForTeamB(int timeout) {
        timeoutViewB.setText(String.valueOf(timeout));
    }

    /* methods for scoring and timeouts for Team A ********************************************** */

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

    public void takeTimeoutTeamA(View view) {
        if (timeoutTeamA > 0) {
            timeoutTeamA -= 1;
            timeoutForTeamA(timeoutTeamA);
        }
    }

    /* ****************************************************************************************** */

    /* methods for scoring and timeouts for Team A ********************************************** */

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

    public void takeTimeoutTeamB(View view) {
        if (timeoutTeamB > 0) {
            timeoutTeamB -= 1;
            timeoutForTeamB(timeoutTeamB);
        }
    }

    /* ****************************************************************************************** */

    // resets all scores and timeouts
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        timeoutTeamA = 3;
        timeoutTeamB = 3;
        timeoutForTeamA(timeoutTeamA);
        timeoutForTeamB(timeoutTeamB);
    }

}

