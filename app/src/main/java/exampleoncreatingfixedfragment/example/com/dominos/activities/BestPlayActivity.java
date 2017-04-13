package exampleoncreatingfixedfragment.example.com.dominos.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import exampleoncreatingfixedfragment.example.com.dominos.JavaClasses.Field;
import exampleoncreatingfixedfragment.example.com.dominos.R;
import exampleoncreatingfixedfragment.example.com.dominos.adapters.ListImagesAdapter;

/**
 * Created by 450 G1 on 03/11/2016.
 */

public class BestPlayActivity extends Activity {
    NumberPicker num1, num2, num3, num4;
    Button generate;
    List<Integer> nonDuplicatedList;
    List<Integer> numsFromSpinner;
    ListView imagesListView;
    List<List<Field>> allLists;
    List<Field> oneList;
    List<Integer> bases; // List of number that being pre addnig
    List<Integer> resultScore; // each score list in allScoresList
    List<List> allScoresLists; // list of four score Lists
    List<Field> zero, one, two, three, four, five, six;
    List<Integer> listOfMatched;
    ListImagesAdapter listImagesAdapter;
    List<Integer> numbersFrom0To6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_play_layout);
        LinearLayout l = (LinearLayout) findViewById(R.id.lin);
        l.setBackground(getResources().getDrawable(R.drawable.jkn));
        initializeControls();
        intializeDrawableLists();
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeControls();
                intializeDrawableLists();
//clear duplicated numbers that have entered in spinners
//and store it in nonDuplicatedList  list OF integer
                oneList.clear();
                nonDuplicatedList.clear();
                numsFromSpinner.clear();
                nonDuplicatedList.add(num1.getValue());
                if (!nonDuplicatedList.contains(num2.getValue()))
                    nonDuplicatedList.add(num2.getValue());
                if (!nonDuplicatedList.contains(num3.getValue()))
                    nonDuplicatedList.add(num3.getValue());
                if (!nonDuplicatedList.contains(num4.getValue()))
                    nonDuplicatedList.add(num4.getValue());
                System.out.println("elements in nonDuplicateList :");
                for (int i = 0; i < nonDuplicatedList.size(); i++)
                    System.out.println(nonDuplicatedList.get(i));
//store nums from spinners in list to use it later in generating score numbers
                numsFromSpinner.add(num1.getValue());
                numsFromSpinner.add(num2.getValue());
                numsFromSpinner.add(num3.getValue());
                numsFromSpinner.add(num4.getValue());
                System.out.println("size of numsFromSpinner : " + numsFromSpinner.size());
                int otherNumsSum = 0;
                Integer tempMatchedWith = 0;
                List<Field> returnedList = null;

                for (int i = 0; i < nonDuplicatedList.size(); i++) {
                    Integer temp = nonDuplicatedList.get(i);
                    returnedList = convertNumToList(temp).get(0);
                    tempMatchedWith = returnedList.get(i).getMatchedWith();
                    System.out.println("temp Matched with : " + tempMatchedWith);
                    otherNumsSum= 0;
                    for (int u = 0; u < 4; u++) {
                        if (numsFromSpinner.get(u) == tempMatchedWith)
                            continue;
                        else
                            otherNumsSum += numsFromSpinner.get(u);
                    }
                    System.out.println("the otherNumSum variable equal = " + otherNumsSum);

                    for (int z = 0; z < numbersFrom0To6.size(); z++) {
                        Integer j;
//                        ((numbersFrom0To6.get(z) + otherNumsSum) / 5) == ((Integer)(numbersFrom0To6.get(z) + otherNumsSum) / 5)
                        if ((numbersFrom0To6.get(z) + otherNumsSum) % 5 == 0) {

                                System.out.println("the other num when matched equal 4 is " + otherNumsSum);
                                j = ((numbersFrom0To6.get(z) + otherNumsSum) / 5);
                                returnedList.get(z).setScore(j);
                                System.out.println("score setted with" + j);

                        } else {
                            System.out.println("there is piece not gained score");
                            returnedList.get(z).setScore(0);
                        }
                    }
                    allLists.add(returnedList);

                }
                if (allLists == null) {
                    System.out.println("all list is nullllll also");
                } else {
                    System.out.println("this is alllists");
                    for (int r = 0; r < allLists.size(); r++) {
                        for (int d = 0; d < allLists.get(r).size(); d++) {
                            System.out.println("drwable " + allLists.get(r).get(d).getDrawable() +
                                    " Score " + allLists.get(r).get(d).getScore());
                        }
                    }
                }
                for (int r = 0; r < allLists.size(); r++) {
                    for (int d = 0; d < allLists.get(r).size(); d++) {
                        if(allLists.get(r).get(d).getScore() != 0)
                        oneList.add(allLists.get(r).get(d));

                    }
                }


                if (oneList == null)
                    System.out.println("one list is noooooot nuuuuuuuuuuulllllllllllllllllllll");
                else
                    System.out.println("one list is nuuuuuuuuuuulllllllllllllllllllll");


                listImagesAdapter = new ListImagesAdapter(getBaseContext(), oneList);
                imagesListView.setAdapter(listImagesAdapter);

            }

        });
    }


    public void initializeControls() {
        num1 = (NumberPicker) findViewById(R.id.numberPicker1);
        num2 = (NumberPicker) findViewById(R.id.numberPicker2);
        num3 = (NumberPicker) findViewById(R.id.numberPicker3);
        num4 = (NumberPicker) findViewById(R.id.numberPicker4);

        num1.setMinValue(0);
        num1.setMaxValue(6);
        num1.setWrapSelectorWheel(true);

        num2.setMinValue(0);
        num2.setMaxValue(6);
        num2.setWrapSelectorWheel(true);

        num3.setMinValue(0);
        num3.setMaxValue(6);
        num3.setWrapSelectorWheel(true);

        num4.setMinValue(0);
        num4.setMaxValue(6);
        num4.setWrapSelectorWheel(true);

        nonDuplicatedList = new ArrayList<>();
        numsFromSpinner = new ArrayList<>();

        numbersFrom0To6 = new ArrayList<>();
        numbersFrom0To6.add(0);
        numbersFrom0To6.add(1);
        numbersFrom0To6.add(2);
        numbersFrom0To6.add(3);
        numbersFrom0To6.add(4);
        numbersFrom0To6.add(5);
        numbersFrom0To6.add(6);
        allLists = new ArrayList<>();
        oneList = new ArrayList<>();
        generate = (Button) findViewById(R.id.generate_images);
        imagesListView = (ListView) findViewById(R.id.images_list_view);


    }

    public void intializeDrawableLists() {
        zero = new ArrayList<>();
        Field _00 = new Field(R.drawable.i1_0, 0);
        Field _01 = new Field(R.drawable.i1_0, 0);
        Field _02 = new Field(R.drawable.i2_0, 0);
        Field _03 = new Field(R.drawable.i3_0, 0);
        Field _04 = new Field(R.drawable.i4_0, 0);
        Field _05 = new Field(R.drawable.i5_0, 0);
        Field _06 = new Field(R.drawable.i6_0, 0);


        zero.add(_00);
        zero.add(_01);
        zero.add(_02);
        zero.add(_03);
        zero.add(_04);
        zero.add(_05);
        zero.add(_06);


        one = new ArrayList<>();
        Field _1_00 = new Field(R.drawable.i1_0, 1);
        Field _1_01 = new Field(R.drawable.i1_1, 1);
        Field _1_02 = new Field(R.drawable.i1_2, 1);
        Field _1_03 = new Field(R.drawable.i1_3, 1);
        Field _1_04 = new Field(R.drawable.i1_4, 1);
        Field _1_05 = new Field(R.drawable.i1_5, 1);
        Field _1_06 = new Field(R.drawable.i1_6, 1);

        one.add(_1_00);
        one.add(_1_01);
        one.add(_1_02);
        one.add(_1_03);
        one.add(_1_04);
        one.add(_1_05);
        one.add(_1_06);

        two = new ArrayList<>();
        Field _2_00 = new Field(R.drawable.i2_0, 2);
        Field _2_01 = new Field(R.drawable.i1_2, 2);
        Field _2_02 = new Field(R.drawable.i2_2, 2);
        Field _2_03 = new Field(R.drawable.i2_3, 2);
        Field _2_04 = new Field(R.drawable.i2_4, 2);
        Field _2_05 = new Field(R.drawable.i2_5, 2);
        Field _2_06 = new Field(R.drawable.i2_6, 2);

        two.add(_2_00);
        two.add(_2_01);
        two.add(_2_02);
        two.add(_2_03);
        two.add(_2_04);
        two.add(_2_05);
        two.add(_2_06);

        three = new ArrayList<>();
        Field _3_00 = new Field(R.drawable.i3_0, 3);
        Field _3_01 = new Field(R.drawable.i1_3, 3);
        Field _3_02 = new Field(R.drawable.i2_3, 3);
        Field _3_03 = new Field(R.drawable.i3_3, 3);
        Field _3_04 = new Field(R.drawable.i3_4, 3);
        Field _3_05 = new Field(R.drawable.i3_5, 3);
        Field _3_06 = new Field(R.drawable.i3_6, 3);

        three.add(_3_00);
        three.add(_3_01);
        three.add(_3_02);
        three.add(_3_03);
        three.add(_3_04);
        three.add(_3_05);
        three.add(_3_06);

        four = new ArrayList<>();
        Field _4_00 = new Field(R.drawable.i4_0, 4);
        Field _4_01 = new Field(R.drawable.i1_4, 4);
        Field _4_02 = new Field(R.drawable.i2_4, 4);
        Field _4_03 = new Field(R.drawable.i3_4, 4);
        Field _4_04 = new Field(R.drawable.i4_4, 4);
        Field _4_05 = new Field(R.drawable.i4_5, 4);
        Field _4_06 = new Field(R.drawable.i4_6, 4);

        four.add(_4_00);
        four.add(_4_01);
        four.add(_4_02);
        four.add(_4_03);
        four.add(_4_04);
        four.add(_4_05);
        four.add(_4_06);


        five = new ArrayList<>();
        Field _5_00 = new Field(R.drawable.i5_0, 5);
        Field _5_01 = new Field(R.drawable.i1_5, 5);
        Field _5_02 = new Field(R.drawable.i2_5, 5);
        Field _5_03 = new Field(R.drawable.i3_5, 5);
        Field _5_04 = new Field(R.drawable.i4_5, 5);
        Field _5_05 = new Field(R.drawable.i5_5, 5);
        Field _5_06 = new Field(R.drawable.i5_6, 5);

        five.add(_5_00);
        five.add(_5_01);
        five.add(_5_02);
        five.add(_5_03);
        five.add(_5_04);
        five.add(_5_05);
        five.add(_5_06);

        six = new ArrayList<>();
        Field _6_00 = new Field(R.drawable.i6_0, 6);
        Field _6_01 = new Field(R.drawable.i1_6, 6);
        Field _6_02 = new Field(R.drawable.i2_6, 6);
        Field _6_03 = new Field(R.drawable.i3_6, 6);
        Field _6_04 = new Field(R.drawable.i4_6, 6);
        Field _6_05 = new Field(R.drawable.i5_6, 6);
        Field _6_06 = new Field(R.drawable.i6_6, 6);

        six.add(_6_00);
        six.add(_6_01);
        six.add(_6_02);
        six.add(_6_03);
        six.add(_6_04);
        six.add(_6_05);
        six.add(_6_06);


    }

    public List<List<Field>> convertNumToList(Integer params) {
        List<List<Field>> temp = new ArrayList<>();


        switch (params) {
            case 0:
                temp.add(zero);
                break;
            case 1:
                temp.add(one);
                break;
            case 2:
                temp.add(two);
                break;
            case 3:
                temp.add(three);
                break;
            case 4:
                temp.add(four);
                break;
            case 5:
                temp.add(five);
                break;
            case 6:
                temp.add(six);
                break;
        }
        return temp;
    }


}
