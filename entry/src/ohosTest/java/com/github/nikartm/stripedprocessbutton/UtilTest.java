/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.nikartm.stripedprocessbutton;

import com.github.nikartm.support.Util;
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