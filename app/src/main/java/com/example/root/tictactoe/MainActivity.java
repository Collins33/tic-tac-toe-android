package com.example.root.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //intially 0=yello 1=red

    int activePlayer=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view){

        ImageView counter=(ImageView) view;

        counter.setTranslationY(-1000f);
        System.out.println(counter.getTag().toString());

        if(activePlayer == 0){

        counter.setImageResource(R.drawable.yellow);
            activePlayer=1;
        }
        else{
            counter.setImageResource(R.drawable.red);
            activePlayer=0;
        }
        //animate back to the screen
        counter.animate().translationYBy(1000f).setDuration(300);
    }
}
