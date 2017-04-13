package exampleoncreatingfixedfragment.example.com.dominos.JavaClasses;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 450 G1 on 03/11/2016.
 */

public class GridElementClass {
    private String nameStr;
    private int soreInt;
    private TextView name, score;
    Button plusBtn, minusBtn;

    public GridElementClass(String nameStr) {
        this.nameStr = nameStr;
    }

//    public  void plusNumber(){
//        int x = Integer.parseInt(score.getText().toString());
//        x++;
//        score.setText(x+"");
//    }
//    public  void minusNumber(){
//        int x = Integer.parseInt(score.getText().toString());
//        if(x>0)x--;
//        score.setText(x+"");
//    }

    public String getNameStr() {
        return nameStr;
    }



    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public int getSoreInt() {
        return soreInt;
    }


}
