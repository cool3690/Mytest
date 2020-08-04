package com.cs.mytest;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class Mytest {
    MainActivity myMath;
    @Before
    public void setup() {
        myMath = new MainActivity();
    }
    @Test
    public void test_add (){
        //arrange
        int first =  99990;
        int second =  9999900;
        int expect = 3;

        //act
        int actual = myMath.cal(first, second );

        //assert
        assertEquals(first*second, actual);
    }

}