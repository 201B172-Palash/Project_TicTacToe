package com.example.a201b172_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;//Check for the winner in the program
    int imageClicked=-1;//check the box is clicked  or not
    int player=1;
    int [][]winningStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gameStates={-1,-1,-1,-1,-1,-1,-1,-1,-1};
//    int player1_res=0,player2_res=0;
    public void load(View view)
    {
            ImageView v = (ImageView100) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClicked=gameStates[tag];
            if(!isWinner && imageClicked==-1)
            {
                if (player == 1)
                {
                    v.setImageResource(R.drawable.cross);
                    gameStates[tag] = player;
                    Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                    player = 0;
                }
                else
                {
                    v.setImageResource(R.drawable.zero);
                    gameStates[tag] = player;
                    Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                    player = 1;
            }
                for (int[] winningState : winningStates) {
                    if (gameStates[winningState[0]] == gameStates[winningState[1]]
                            && gameStates[winningState[1]] == gameStates[winningState[2]] &&
                            gameStates[winningState[0]] > -1) {
                        Toast.makeText(this, "Winner is Player : " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
//                        if(player==0)
//                            player1_res=player1_res+1;
//                        else
//                            player2_res=player1_res+1;
                        isWinner = true;
                    }
//                else if (gameStates[winningStates[i+3][0]] == gameStates[winningStates[i+3][1]]
//                        && gameStates[winningStates[i+3][1]] == gameStates[winningStates[i+3][2]] &&
//                        gameStates[winningStates[i][0]] > -1)
//                {
//                    Toast.makeText(this, "Winner is Player : " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
//                    isWinner=true;
//                }
//                else if(gameStates[winningStates[0][0]]==gameStates[winningStates[1][1]]
//                    && gameStates[winningStates[1][1]]==gameStates[winningStates[2][2]] &&
//                    gameStates[winningStates[i][i]]>-1)
//                Toast.makeText(this, "Winner is Player : "+(player==0?1:0), Toast.LENGTH_SHORT).show();

                }
        }
    }
    public void reset(View view)
    {
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++)
        {
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClicked=-1;
        player =1;
        Arrays.fill(gameStates, -1);

    }
//    public void winner(View view)
//    {
//        TextView T =findViewById(R.id.textView2);
//
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}