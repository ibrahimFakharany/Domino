package exampleoncreatingfixedfragment.example.com.dominos.JavaClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 450 G1 on 03/11/2016.
 */

public class Field extends ArrayList{
    private Integer drawable;
    private Integer matchedWith;
    private Integer score;


    public Field(Integer drawable, Integer matchedWith) {
        this.matchedWith = matchedWith;
        this.drawable = drawable;
        this.score = 0;

    }


    public Integer getDrawable() {
        return drawable;
    }

    public void setDrawable(Integer drawable) {
        this.drawable = drawable;
    }

    public Integer getMatchedWith() {
        return matchedWith;
    }

    public void setMatchedWith(Integer matchedWith) {
        this.matchedWith = matchedWith;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }







}
