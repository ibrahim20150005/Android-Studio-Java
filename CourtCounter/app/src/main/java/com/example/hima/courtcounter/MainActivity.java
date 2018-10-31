package com.example.hima.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA,scoreB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView resultA = findViewById(R.id.resultTeameA);
        final TextView resultB = findViewById(R.id.resultTeameB);
        final Button points3A = findViewById(R.id.Points3A);
        final Button points3B = findViewById(R.id.Points3B);
        final Button points2A = findViewById(R.id.Points2A);
        final Button points2B = findViewById(R.id.Points2B);
        final Button freeThrowA = findViewById(R.id.FreeThrowA);
        final Button freeThrowB = findViewById(R.id.FreeThrowB);
        final Button Rest = findViewById(R.id.Rest);

        //the result of score A for 2 points
        points2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA=scoreA+2;
                resultA.setText(""+scoreA);
            }
        });
        //the result of score B for 2 points
        points2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB=scoreB+2;
                resultB.setText(""+scoreB);
            }
        });
        //the result of score A for 3 points
        points3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA=scoreA+3;
                resultA.setText(""+scoreA);
            }
        });
        //the result of score B for 3 points
        points3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB=scoreB+3;
                resultB.setText(""+scoreB);
            }
        });
        //the result of score A for free throw points
        freeThrowA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA=scoreA+1;
                resultA.setText(""+scoreA);
            }
        });
        //the result of score B for free throw points
        freeThrowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB=scoreB+1;
                resultB.setText(""+scoreB);
            }
        });
        //Reset All the result of score A && B
        Rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA=0;
                scoreB=0;
                resultA.setText("0");
                resultB.setText("0");
            }
        });
    }
}
