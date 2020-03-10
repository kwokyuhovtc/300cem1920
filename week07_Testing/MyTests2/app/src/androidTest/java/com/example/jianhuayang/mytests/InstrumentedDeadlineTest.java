package com.example.jianhuayang.mytests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jianhuayang on 14/11/2017.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class InstrumentedDeadlineTest {

    private Deadline deadline;

    @Before
    public void initTests() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        deadline = new Deadline("04/12/17", context);
    }

    @Test
    public void testCalculate() {
        Log.d("actual_results", Integer.toString(deadline.calculate()));
        assertThat(deadline.calculate(), is(equalTo(8)));
    }

}