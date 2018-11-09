package com.woodrdk.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.View.OnClickListener;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity implements OnEditorActionListener,OnClickListener
{
    public Button square1;
    public Button square2;
    public Button square3;
    public Button square4;
    public Button square5;
    public Button square6;
    public Button square7;
    public Button square8;
    public Button square9;
    public Button newGame;
    public TextView turnView;
    public int turn  = 1;
    public int count = 0;
    public String playerName;
    public String playerWin;
    Button[] buttons = new Button[9];
    String Player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons[0] = findViewById(R.id.square1);
        buttons[1] = findViewById(R.id.square2);
        buttons[2] = findViewById(R.id.square3);
        buttons[3] = findViewById(R.id.square4);
        buttons[4] = findViewById(R.id.square5);
        buttons[5] = findViewById(R.id.square6);
        buttons[6] = findViewById(R.id.square7);
        buttons[7] = findViewById(R.id.square8);
        buttons[8] = findViewById(R.id.square9);
        newGame = findViewById(R.id.newGame);
        turnView = findViewById(R.id.turnView);
        for(int z = 0; z < buttons.length; z++){
            buttons[z].setOnEditorActionListener(this);
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
        }
        return false;
    }
    public boolean validate(int q, int w, int e){
        if( (  (buttons[q].getText() == "X") && (buttons[w].getText() == "X") && (buttons[e].getText() == "X")
        ||   (buttons[q].getText() == "O") && (buttons[w].getText() == "O") && (buttons[e].getText() == "O"))){
            return true;
        }
        return false;
    }
    public void checkWin(){

        if(validate(0,1,2) == true) {
             turnView.setText(playerWin + " won this game, Try again? ");
             changeColor(0, 1, 2);
             endGameButtons();
        }
        else if(validate(3,4,5) == true) {
             turnView.setText( playerWin + " won this game, Try again? " );
             changeColor(3,4,5);
             endGameButtons();
        }
        else if(validate(6,7,8) == true) {
                turnView.setText(playerWin + " won this game, Try again? ");
                changeColor(6, 7, 8);
                endGameButtons();
        }
        else if(validate(0,3,6) == true) {
                turnView.setText(playerWin + " won this game, Try again? ");
                changeColor(0, 3, 6);
                endGameButtons();
        }
        else if(validate(1,4,7) == true) {
                turnView.setText(playerWin + " won this game, Try again? ");
                changeColor(1, 4, 7);
                endGameButtons();
        }
        else if(validate(2,5,8) == true) {
                turnView.setText(playerWin + " won this game, Try again? ");
                changeColor(2, 5, 8);
                endGameButtons();
        }
        else if(validate(0,4,8) == true) {
                turnView.setText(playerWin + " won this game, Try again? ");
                changeColor(0, 4, 8);
                endGameButtons();
        }
        else if(validate(6,4,2) == true) {
                turnView.setText(playerWin + " won this game, Try again? ");
                changeColor(6, 4, 2);
                endGameButtons();
        }
        else if(turn == 10){
            turnView.setText( "Tie game, Try again? " );
        }
        else{
            nameChange();
        }
    }

    public void nameChange(){
        turnView.setText( playerName + "'s Turn" );
    }

    @Override
    public void onClick(View v) {
        if (turn % 2 == 0){
            Player = "O";
            playerName = "Player X ";
            playerWin = "Player O";
        }
        else{
            Player = "X";
            playerName = "Player O";
            playerWin = "Player X";
        }
        turn++;
        count++;
        switch (v.getId()){
            case R.id.square1:
                eachButton(0);
                break;
            case R.id.square2:eachButton(1);
                break;
            case R.id.square3:eachButton(2);
                break;
            case R.id.square4:
                eachButton(3);
                break;
            case R.id.square5:
                eachButton(4);
                break;
            case R.id.square6:
                eachButton(5);
                break;
            case R.id.square7:
                eachButton(6);
                break;
            case R.id.square8:
                eachButton(7);
                break;
            case R.id.square9:
                eachButton(8);
                break;
            case R.id.newGame:
                for(int i = 0; i < buttons.length; i++){
                    buttons[i].setClickable(true);
                    buttons[i].setBackgroundColor(Color.LTGRAY);
                    buttons[i].setText("");
                }
                turn = 1;
                turnView.setText( "Player X 's Turn" );
                count = 0;
        }
    }

    public void endGameButtons(){
        for(int k = 0; k < buttons.length; k++){
            buttons[k].setClickable(false);
        }
    }
    public void changeColor(int a, int b, int c){
        buttons[a].setBackgroundColor(Color.RED);
        buttons[b].setBackgroundColor(Color.RED);
        buttons[c].setBackgroundColor(Color.RED);
    }
    public void eachButton(int x){
        buttons[x].setText(Player);
        checkWin();
        buttons[x].setClickable(false);
    }
}
