package exampleoncreatingfixedfragment.example.com.dominos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import exampleoncreatingfixedfragment.example.com.dominos.JavaClasses.GridElementClass;
import exampleoncreatingfixedfragment.example.com.dominos.R;
import exampleoncreatingfixedfragment.example.com.dominos.adapters.GridScoreAdapter;

/**
 * Created by 450 G1 on 03/11/2016.
 */

public class PlayingActivity extends Activity{

    TextView textView;
    ArrayList<GridElementClass> mylist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_layout);
        LinearLayout l = (LinearLayout) findViewById(R.id.linearPlay);
        l.setBackground(getResources().getDrawable(R.drawable.jkn));
        GridView gridView = (GridView) findViewById(R.id.gridView);
        textView = (TextView) findViewById(R.id.score_text);
        mylist = new ArrayList<>();
        Intent intent = getIntent();
        String player1 = intent.getStringExtra("player1") ;
        String player2 = intent.getStringExtra("player2") ;
        String player3 = intent.getStringExtra("player3") ;
        String player4 = intent.getStringExtra("player4") ;
        String []players = {player1, player2, player3, player4};

        for(int i = 0; i < 4; i++){
            mylist.add(new GridElementClass(players[i]));
            GridScoreAdapter scoreAdapter = new GridScoreAdapter(this, R.layout.grid_view_element_layout, mylist);
            gridView.setAdapter(scoreAdapter);
        }
        Button bestPlay = (Button) findViewById(R.id.best_play_activity);
        bestPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayingActivity.this, BestPlayActivity.class));
            }
        });


    }
}
