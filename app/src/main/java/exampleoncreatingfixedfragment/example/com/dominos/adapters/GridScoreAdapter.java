package exampleoncreatingfixedfragment.example.com.dominos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import exampleoncreatingfixedfragment.example.com.dominos.JavaClasses.GridElementClass;
import exampleoncreatingfixedfragment.example.com.dominos.R;

/**
 * Created by 450 G1 on 03/11/2016.
 */

public class GridScoreAdapter extends ArrayAdapter {
    Context mContext ;
    ArrayList<GridElementClass> listaya;
    public GridScoreAdapter(Context mContext, int resource, ArrayList<GridElementClass> list) {
        super(mContext,  resource,  list);
        this.listaya = list;
        this.mContext = mContext;

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.grid_view_element_layout,parent, false);
        }
        GridElementClass gridElementClass = (GridElementClass) getItem(position);

        TextView nameText= (TextView) convertView.findViewById(R.id.name_text);
        nameText.setText(gridElementClass.getNameStr());
        final TextView scoreText= (TextView) convertView.findViewById(R.id.score_text);
        scoreText.setText(gridElementClass.getSoreInt()+"");
        Button miBtn = (Button) convertView.findViewById(R.id.minus);
        miBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(scoreText.getText().toString());
                if(x>0)x--;
                scoreText.setText(x+"");
            }
        });
        miBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int x = 0;

                scoreText.setText(x+"");

                return false;
            }
        });
        Button plBtn = (Button) convertView.findViewById(R.id.plus);
        plBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(scoreText.getText().toString());
                x++;
                scoreText.setText(x+"");
            }
        });
        plBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int x = Integer.parseInt(scoreText.getText().toString());
                x++;
                scoreText.setText(x+"");

                return false;
            }
        });
        return convertView;
    }
}
