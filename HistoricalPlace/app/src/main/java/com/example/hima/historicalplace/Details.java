package com.example.hima.historicalplace;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    ImageView imageView;
    TextView country,description;
    Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.TypeImage);
        country = findViewById(R.id.country);
        description = findViewById(R.id.description);
        share = findViewById(R.id.share);

        Intent in = getIntent();
        Bitmap bitmap =  in.getParcelableExtra("image");
        imageView.setImageBitmap(bitmap);
        country.setText(in.getStringExtra("country"));
        description.setText(in.getStringExtra("description"));

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,description.getText().toString());
                startActivity(Intent.createChooser(intent,getString(R.string.app_name)));
            }
        });

    }
}
