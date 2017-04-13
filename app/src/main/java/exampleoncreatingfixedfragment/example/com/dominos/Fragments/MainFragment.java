package exampleoncreatingfixedfragment.example.com.dominos.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import exampleoncreatingfixedfragment.example.com.dominos.R;
import exampleoncreatingfixedfragment.example.com.dominos.activities.PlayingActivity;

/**
 * Created by 450 G1 on 03/11/2016.
 */

public class MainFragment extends Fragment{
    EditText player1, player2, player3,player4;
    Button nxtBtn;
    List<EditText> editTextList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editTextList = new ArrayList<>();
    }
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_layout, container, false);

        player1 = (EditText) view.findViewById(R.id.player_one);
        player2 = (EditText) view.findViewById(R.id.player_two);
        player3 = (EditText) view.findViewById(R.id.player_three);
        player4 = (EditText) view.findViewById(R.id.player_four);

        editTextList.add(player1);
        editTextList.add(player2);
        editTextList.add(player3);
        editTextList.add(player4);

        nxtBtn = (Button) view.findViewById(R.id.nxtBtn);

        nxtBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlayingActivity.class);
                int index =1;
                for(int i = 0; i < 4; i++)
                {
                    String player_name = editTextList.get(i).getText().toString();
                    intent.putExtra("player"+index, player_name);
                    index++;
                }
                startActivity(intent);
            }
        });
        return view;
    }

}
