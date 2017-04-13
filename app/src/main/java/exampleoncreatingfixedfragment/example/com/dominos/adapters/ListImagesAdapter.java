package exampleoncreatingfixedfragment.example.com.dominos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import exampleoncreatingfixedfragment.example.com.dominos.JavaClasses.Field;
import exampleoncreatingfixedfragment.example.com.dominos.R;

/**
 * Created by 450 G1 on 03/11/2016.
 */

public class ListImagesAdapter extends ArrayAdapter {
    Context mContext ;
    List<Field> listaya;
    public ListImagesAdapter(Context context, List<Field> list) {
        super(context, 0, list);
        this.listaya = list;
        this.mContext = context;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("hello from adapter ");
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_view_element_layout,parent, false);
        }

        ImageView imageView = (ImageView)  convertView.findViewById(R.id.image_view);
        imageView.setImageResource(listaya.get(position).getDrawable());

        TextView gainScoreText= (TextView) convertView.findViewById(R.id.gain_score);
        gainScoreText.setText(""+listaya.get(position).getScore()+"");

        final TextView scoreText= (TextView) convertView.findViewById(R.id.matche_with);
        scoreText.setText(""+listaya.get(position).getMatchedWith()+"");

        return convertView;
    }
}
