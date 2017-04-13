package exampleoncreatingfixedfragment.example.com.dominos.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import exampleoncreatingfixedfragment.example.com.dominos.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rL = (RelativeLayout) findViewById(R.id.activity_main);
        rL.setBackground(getResources().getDrawable(R.drawable.jkn));
    }
}
//