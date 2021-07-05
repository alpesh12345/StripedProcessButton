package com.alpesh.stripedprocessbtn;

import com.alpesh.strippedprocessbutton.Util;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import ohos.app.Context;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class UtilTest {

    private Context context;
    private AttrSet attrSet;
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 0;
    private Util util;
    @Before
    public void setUp() throws Exception {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        attrSet = new AttrSet() {
            @Override
            public Optional<String> getStyle() {
                return Optional.empty();
            }

            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public Optional<Attr> getAttr(int i) {
                return Optional.empty();
            }

            @Override
            public Optional<Attr> getAttr(String s) {
                return Optional.empty();
            }
        };

    }

    @Test
    public void computeAlpha() {
        assertEquals(util.computeAlpha(1),MAX_ALPHA);
        assertEquals(util.computeAlpha(0),MIN_ALPHA);
        assertEquals(util.computeAlpha(0.5f),(int)(255/2));
    }
}