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
    //2 means unplayed
    int[] gameState={2,2,2,2,2,2,2,2,2};
    //this array contains the winning  positions

    int[][] winningPositions= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2) {
            counter.setTranslationY(-1000f);
             gameState[tappedCounter]=activePlayer;
             //check active player number
            //0==yellow
            //1==red
            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            //animate back to the screen
            counter.animate().translationYBy(1000f).setDuration(300);
            for(int[] winningPosition : winningPositions){
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] !=2){
                    System.out.println(gameState[winningPosition[0]]);
                }
            }
        }
    }
}
