package com.example.hima.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    ListView listViewFamily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        listViewFamily = findViewById(R.id.word_list);
        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        words.add( new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add( new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
        words.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));

        ArrayAdapterCustom adapter = new ArrayAdapterCustom(this,R.layout.list_items,words, R.color.colorFamily);
        listViewFamily.setAdapter(adapter);
    }
}
