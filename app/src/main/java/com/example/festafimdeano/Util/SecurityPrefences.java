package com.example.festafimdeano.Util;

import android.content.Context;
import android.content.SharedPreferences;

    public class SecurityPrefences {

        private final SharedPreferences mSharedPreferences;

        public SecurityPrefences(Context context){
            this.mSharedPreferences = context.getSharedPreferences("FimDeANO", Context.MODE_PRIVATE);

        }
        public void storyString (String key, String Value){
            this.mSharedPreferences.edit().putString(key, Value).apply();
        }
        public String getStoredString(String key){
           return this.mSharedPreferences.getString(key,"");

        }
    }



