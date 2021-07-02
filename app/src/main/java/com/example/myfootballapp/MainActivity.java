package com.example.myfootballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    TextView teamScoreA;
    TextView teamScoreB;

    //Define incrementBy, teamAScore, teamBScore AS integer;
    int incrementBy;
    int teamAScore;
    int teamBScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign score for both team A and Team B AS 0;
        teamAScore = 0;
        teamBScore = 0;

        //finding all the views by ids
        //refer to the xml page for the ids,

        RadioGroup radioGroup = findViewById(R.id.radio_group);

        teamScoreA = findViewById(R.id.Team_scoreA);
        teamScoreB = findViewById(R.id.Team_scoreB);

        Button upTeamA = findViewById(R.id.increaseTeamA);
        Button downTeamA= findViewById(R.id.decreaseTeamA);
        Button upTeamB = findViewById(R.id.increaseTeamB);
        Button downTeamB = findViewById(R.id.decreaseTeamB);

        //setting the onClick listeners for the buttons
        radioGroup.setOnCheckedChangeListener(this);
        upTeamA.setOnClickListener(this::onClick);
        downTeamA.setOnClickListener(this::onClick);
        upTeamB.setOnClickListener(this::onClick);
        downTeamB.setOnClickListener(this::onClick);


    }


    //method for radioGroup buttons, increment by button 1, button 2, button 3,
    // method uses the switch statement.
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //selecting the increment value using the radio button
        switch (i) {
            case 1:
                incrementBy = 1;
                break;
            case 2:
                incrementBy = 2;
                break;
            case 3:
                incrementBy = 3;
                break;
            default:
        }
    }
    //method for the onClick buttons, buttons to increase and decrease score for TeamA
    //buttons to increase and decrease score for TeamB
    // Method uses the switch statement.
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onClick(View view) {
        int id = view.getId();
        //according to the buttons clicked the respective functions will be performed
        switch (id) {
            case R.id.increaseTeamA:
                teamAScore += incrementBy;
                teamScoreA.setText(Integer.toString(teamAScore));
                break;
            case R.id.decreaseTeamA:
                if (teamAScore <= 0) teamAScore = 0;
                else teamAScore -= incrementBy;
                teamScoreA.setText(Integer.toString(teamAScore));
                break;
            case R.id.increaseTeamB:
                teamBScore += incrementBy;
                teamScoreB.setText(Integer.toString(teamBScore));
                break;
            case R.id.decreaseTeamB:
                if (teamBScore <= 0) teamBScore = 0;
                else teamBScore -= incrementBy;
                teamScoreB.setText(Integer.toString(teamBScore));
                break;


        }
    }

    //Method for setTeamScoreA
    @SuppressLint("SetTextI18n")
    public void setTeamScoreA(int i) {
        TextView textView = findViewById(R.id.Team_scoreA);
        textView.setText("" + i);
    }

    //Method for setTeamScoreB
    @SuppressLint("SetTextI18n")
    public void setTeamScoreB(int i) {
        TextView textView = findViewById(R.id.Team_scoreB);
        textView.setText("" + i);
    }
    //method for onClick resetGame
    public void resetGame (View view){
        teamAScore = 0;
        teamBScore = 0;
        setTeamScoreA(0);
        setTeamScoreB(0);



    }

}
