package com.alpesh.stripedprocessbtn;

import com.alpesh.strippedprocessbutton.AttributeController;
import com.alpesh.strippedprocessbutton.StripedDrawable;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorValue;
import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import ohos.app.Context;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import static org.junit.Assert.*;

public class AnimatedStripedDrawableTest {
    private StripedDrawable drawable;
    private AnimatorValue animator;
    private Context context;
    private AttrSet attrSet;

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
    public void isRunning_initially() {
        AttributeController attrController = new AttributeController(attrSet);
        drawable = attrController.getStripedDrawable();
        animator = new AnimatorValue();
        animator.setCurveType(Animator.CurveType.LINEAR);
        animator.setDuration(drawable.getStripeDuration());
        animator.setLoopedCount(AnimatorValue.INFINITE);
        assertFalse(animator.isRunning());
    }

    @Test
    public void isRunning_onStart() {
        AttributeController attrController = new AttributeController(attrSet);
        drawable = attrController.getStripedDrawable();
        animator = new AnimatorValue();
        animator.setCurveType(Animator.CurveType.LINEAR);
        animator.setDuration(drawable.getStripeDuration());
        animator.setLoopedCount(AnimatorValue.INFINITE);
        animator.start();
        assertTrue(animator.isRunning());
    }

    @Test
    public void isRunning_onStop() {
        AttributeController attrController = new AttributeController(attrSet);
        drawable = attrController.getStripedDrawable();
        animator = new AnimatorValue();
        animator.setCurveType(Animator.CurveType.LINEAR);
        animator.setDuration(drawable.getStripeDuration());
        animator.setLoopedCount(AnimatorValue.INFINITE);
        animator.start();
        animator.stop();
        assertFalse(animator.isRunning());
    }
}