package com.example.hima.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView number,color,family,phrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.number);
        color = findViewById(R.id.color);
        family = findViewById(R.id.family);
        phrases = findViewById(R.id.phrases);

        number.setOnClickListener(this);
        color.setOnClickListener(this);
        family.setOnClickListener(this);
        phrases.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==number)
        {
            Intent intent = new Intent(MainActivity.this,NumbersActivity.class);
            startActivity(intent);
        }
        else if (v==color)
        {
            Intent intent = new Intent(MainActivity.this,ColorsActivity.class);
            startActivity(intent);
        }

        else if (v==family)
        {
            Intent intent = new Intent(MainActivity.this,FamilyActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(MainActivity.this,PharesesActivity.class);
            startActivity(intent);
        }
    }
}
