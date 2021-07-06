package com.alpesh.stripedprocessbtn;

import com.nikartm.stripedprocessbutton.Util;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 0;
    private Util util;

    @Test
    public void computeAlpha() {
        assertEquals(util.computeAlpha(1),MAX_ALPHA);
        assertEquals(util.computeAlpha(0),MIN_ALPHA);
        assertEquals(util.computeAlpha(0.5f),(int)(MAX_ALPHA/2));
    }
}