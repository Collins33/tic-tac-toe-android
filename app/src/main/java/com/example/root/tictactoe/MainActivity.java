package com.example.root.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
                       //set textview according to winner
                        String winner="red";
                    if(gameState[winningPosition[0]] == 0){
                           winner ="yellow";
                    };

                    //someone has won
                    //find the layout to display
                    TextView winnerMessage=(TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " is the winner");
                    LinearLayout winLayout=(LinearLayout) findViewById(R.id.winLayout);
                    //make layout visible
                    winLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view){
        //MAKE MESSAGE DISAPPEAR
        LinearLayout winLayout=(LinearLayout) findViewById(R.id.winLayout);

        winLayout.setVisibility(View.INVISIBLE);
        //set game back to default
         activePlayer=0;
        //2 means unplayed
        for(int i=0; i<gameState.length;i++){
            gameState[i] =2;
        }
        //get the gridlayout
        GridLayout grid=(GridLayout) findViewById(R.id.gridLayout);
        //loop through the grid
        for(int i=0; i<grid.getChildCount();i++){
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }

    }
}
