package com.example.hima.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArrayAdapterCustom extends ArrayAdapter<Word> {

    Context contextAdapter;
    int resourceAdapter;

    private int mColorResourceId;
    ArrayList<Word> wordArray;

    public ArrayAdapterCustom(@NonNull Context context, int resource, ArrayList<Word> words, int colorResourceId) {
        super(context, resource, words);
        contextAdapter=context;
        resourceAdapter=resource;
        wordArray=words;
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView ;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        final Word currentWord = getItem(position);
        TextView WordEnglish = listItemView.findViewById(R.id.word_english);
        TextView WordMiwok = listItemView.findViewById(R.id.word_miwok);
        ImageView imageView = listItemView.findViewById(R.id.imageView);
        final Button btPlay = listItemView.findViewById(R.id.play);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundId = contextAdapter.getResources().getIdentifier(String.valueOf(currentWord.getSound()),"raw",contextAdapter.getPackageName());
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),soundId);
                mediaPlayer.start();
            }
        });


        WordEnglish.setText(currentWord.getWordOfEnglish());
        WordMiwok.setText(currentWord.getWordOfMiwok());


        int imageId = contextAdapter.getResources().getIdentifier(String.valueOf(currentWord.getImage()),"drawable",contextAdapter.getPackageName());

        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(imageId);
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
