package com.example.hima.recyclingfacts;

import android.content.Context;

import java.util.Random;

public class RecyclingFactsGenerator {

        // متغيرات
        String facts[];

        public RecyclingFactsGenerator(Context context){
            facts = context.getResources().getStringArray(R.array.facts);

        }

        // أفعال
        public String generateFact(){
            String fact;
            Random randomGen = new Random();
            int randomNumber = randomGen.nextInt(facts.length);

            fact = facts[randomNumber];

            return fact;
        }

}

