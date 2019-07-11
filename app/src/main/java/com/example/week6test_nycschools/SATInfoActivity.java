package com.example.week6test_nycschools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.week6test_nycschools.model.OkHttpClass;
import com.example.week6test_nycschools.model.SATResponse;

public class SATInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satinfo);

        SATResponse satResponse= getIntent().getParcelableExtra("dbn");

        TextView tvSchoolName = findViewById(R.id.tvSchoolName);
        TextView tvNumOfTestTakers = findViewById(R.id.tvNumOfTestTakers);
        TextView tvReadingScore = findViewById(R.id.tvReadingAvgScore);
        TextView tvMathScore = findViewById(R.id.tvMathAvgScore);
        TextView tvWritingScore = findViewById(R.id.tvWritingAvgScore);

        tvSchoolName.setText(satResponse.getSchoolName());

        // check if there is a value in getNumOfSatTestTakers
        if(satResponse.getNumOfSatTestTakers().isEmpty()) {
            tvNumOfTestTakers.setText("Number of Test Takers: No value found");
        }
        else {
            tvNumOfTestTakers.setText("Number of Test Takers = " + satResponse.getNumOfSatTestTakers());
        }

        // check if there is a value in getSatMathAvgScore
        if(satResponse.getSatMathAvgScore().isEmpty()) {
            tvNumOfTestTakers.setText("Average math score: No value found");
        }
        else {
            tvMathScore.setText("Average math score = " + satResponse.getSatMathAvgScore());
        }

        // check if there is a value in getReadingAvgScore
        if(satResponse.getSatCriticalReadingAvgScore().isEmpty()) {
            tvReadingScore.setText("Average reading score = No value found");
        }
        else {
            tvReadingScore.setText("Average reading score = " + satResponse.getSatCriticalReadingAvgScore());
        }

        // check if there is a value in getWritingAvgScore
        if(satResponse.getSatWritingAvgScore().isEmpty()) {
            tvWritingScore.setText("Average writing score : No Score Found");
        }
        else {
            tvNumOfTestTakers.setText("Average writing score = " + satResponse.getSatWritingAvgScore());
        }
    }
}
