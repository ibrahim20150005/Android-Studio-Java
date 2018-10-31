package com.example.hima.miwok;

public class Word {
    String WordOfEnglish;
    String WordOfMiwok;
    int Sound;
    int Image=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String wordOfEnglish, String wordOfMiwok) {
        WordOfEnglish = wordOfEnglish;
        WordOfMiwok = wordOfMiwok;
    }

    public Word(String wordOfEnglish, String wordOfMiwok, int image,int sound) {
        WordOfEnglish = wordOfEnglish;
        WordOfMiwok = wordOfMiwok;
        Image=image;
        Sound=sound;
    }

    public Word(String wordOfEnglish, String wordOfMiwok, int sound) {

        WordOfEnglish = wordOfEnglish;
        WordOfMiwok = wordOfMiwok;
        Sound=sound;
    }

    public String getWordOfEnglish() {
        return WordOfEnglish;
    }

    public String getWordOfMiwok() {
        return WordOfMiwok;
    }

    public int getImage() { return Image; }


    public int getSound() { return Sound; }

    public boolean hasImage() { return Image != NO_IMAGE_PROVIDED;}
}
