package com.alpesh.stripedprocessbtn;

import com.alpesh.strippedprocessbutton.StripedDrawable;
import ohos.agp.text.Font;
import ohos.agp.utils.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class StripedDrawableTest {
    @Test
    public void setStripeWidth() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeWidth(20.0f);
        assertEquals(String.valueOf(stripedDrawable.getStripeWidth()),String.valueOf(20.0f));
    }

    @Test
    public void setColorBack() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setColorBack(Color.getIntColor("#4CAF50"));
        assertEquals(Color.getIntColor("#4CAF50"),stripedDrawable.getColorBack());
    }

    @Test
    public void setColorMain() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setColorMain(Color.getIntColor("#4CAF50"));
        assertEquals(Color.getIntColor("#4CAF50"),stripedDrawable.getColorMain());
    }

    @Test
    public void setColorSub() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setColorSub(Color.getIntColor("#4CAF50"));
        assertEquals(Color.getIntColor("#4CAF50"),stripedDrawable.getColorSub());
    }

    @Test
    public void setStripeAlpha() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeAlpha(20.0f);
        assertEquals(String.valueOf(stripedDrawable.getStripeAlpha()),String.valueOf(20.0f));
    }

    @Test
    public void setCornerRadius() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setCornerRadius(20.0f);
        assertEquals(String.valueOf(stripedDrawable.getCornerRadius()),String.valueOf(20.0f));
    }

    @Test
    public void setStripeDuration() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeDuration(200);
        assertEquals(String.valueOf(stripedDrawable.getStripeDuration()),String.valueOf(200));
    }

    @Test
    public void setTilt() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setTilt(20f);
        assertEquals(String.valueOf(stripedDrawable.getTilt()),String.valueOf(20f));
    }

    @Test
    public void setStripeRevert() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeRevert(true);
        assertTrue(stripedDrawable.isStripeRevert());
    }

    @Test
    public void setShowStripes() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setShowStripes(true);
        assertTrue(stripedDrawable.isShowStripes());
    }

    @Test
    public void setStripeGradient() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setStripeGradient(true);
        assertTrue(stripedDrawable.isStripeGradient());
    }

    @Test
    public void setLoadingText() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setLoadingText("20f");
        assertEquals("20f",stripedDrawable.getLoadingText());
    }

    @Test
    public void setButtonText() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setButtonText("20f");
        assertEquals("20f",stripedDrawable.getButtonText());
    }

    @Test
    public void setTextColor() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setTextColor(0x4CAF50);
        assertEquals(0x4CAF50,stripedDrawable.getTextColor());
    }

    @Test
    public void setTextSize() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setTextSize(20);
        assertEquals(String.valueOf(stripedDrawable.getTextSize()),String.valueOf(20));
    }

    @Test
    public void setFont() {
        StripedDrawable stripedDrawable = new StripedDrawable();
        stripedDrawable.setFont(Font.SANS_SERIF);
        assertEquals(Font.SANS_SERIF,stripedDrawable.getFont());
    }
}