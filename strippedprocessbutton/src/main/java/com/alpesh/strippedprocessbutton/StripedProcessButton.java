package com.alpesh.strippedprocessbutton;

import static ohos.agp.components.AttrHelper.getDensity;

import com.alpesh.strippedprocessbutton.constant.Constants;
import ohos.agp.components.AttrSet;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.render.Canvas;
import ohos.app.Context;

/**
 * Striped process button.
 */
public class StripedProcessButton extends Button implements Component.BindStateChangedListener, Component.DrawTask {
    private AnimatedStripedDrawable animatedDrawable;
    private StripedDrawable stripedDrawable;
    private State state = State.STOP;
    private long startAnimDuration = Constants.NO_INIT;
    private long stopAnimDuration = Constants.NO_INIT;
    private boolean buttonAnimated = Constants.DEF_BUTTON_ANIM;
    private String defaultText;
    private float density;

    public StripedProcessButton(Context context) {
        super(context);
        initAttrs(null);
    }

    public StripedProcessButton(Context context, AttrSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public StripedProcessButton(Context context, AttrSet attrs, String defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    private void initAttrs(AttrSet attrs) {
        density = getDensity(getContext());
        AttributeController attrController = new AttributeController(attrs);
        stripedDrawable = attrController.getStripedDrawable();
        addOhosAttr(stripedDrawable);
        try {
            animatedDrawable = new AnimatedStripedDrawable(stripedDrawable);
            animatedDrawable.setComponent(this);
        } catch (Exception e) {
            //
        }
        setBindStateChangedListener(this);
        addDrawTask(this:: onDraw);
    }

    /**
     * Store attributes of ohosButton in stripedDrawable.
     */
    private void addOhosAttr(StripedDrawable stripedDrawable) {
        stripedDrawable.setButtonText(getText());
        stripedDrawable.setTextColor(getTextColor().getValue());
        stripedDrawable.setTextSize(getTextSize());
        stripedDrawable.setFont(getFont());
    }

    @Override
    public void onComponentBoundToWindow(Component component) {
        defaultText = getText() != null ? getText() : "test...";
        launchAnimationWithDelay();
    }

    @Override
    public void onComponentUnboundFromWindow(Component component) {
        //
    }

    /**
     * Launch animation with delay when view attached to window.
     */
    private void launchAnimationWithDelay() {
        switch (state) {
            case START:
                start();
                break;
            case STOP:
                stop();
                break;
            default:
                break;
        }
    }

    @Override
    public void onDraw(Component component, Canvas canvas) {
        setBackground(animatedDrawable);
        setEnabled(!isRunning());
        animatedDrawable.drawToCanvas(canvas);
    }

    /**
     * when called, checks state, if Start
     * then start AnimatedStripedDrawable.
     */
    public void start() {
        state = State.START;
        if (isRunning() || !isBoundToWindow()) {
            return;
        }
        setEnabled(isRunning());
        animatedDrawable.start();
        animateButton(isRunning());
    }

    /**
     * when called, checks state, if Stop
     * then stop AnimatedStripedDrawable.
     */
    public void stop() {
        state = State.STOP;
        if (!isRunning() || !isBoundToWindow()) {
            return;
        }
        setEnabled(isRunning());
        animatedDrawable.stop();
        animateButton(isRunning());
    }

    public boolean isRunning() {
        return isBoundToWindow() && animatedDrawable.isRunning();
    }

    private void animateButton(boolean start) {
        if (isButtonAnimated()) {
            setCurrentText(start);
        }
    }

    /**
     * Set the button Text which gets hidden by rectangle drawn on it,
     * but takes care for match content and related width.
     *
     * @param start helps in determining about which text to show.
     */
    private void setCurrentText(boolean start) {
        String currentText;
        if (start) {
            currentText = stripedDrawable.getLoadingText() == null
                    ? defaultText
                    : stripedDrawable.getLoadingText();
        } else {
            currentText = defaultText;
        }
        setText(currentText);
    }

    /**
     * Get current start animation duration.
     *
     * @return start duration in ms
     */
    public long getStartAnimDuration() {
        return startAnimDuration;
    }

    /**
     * Set start animation duration in ms.
     *
     * @param startAnimDuration set duration in ms.
     */
    public StripedProcessButton setStartAnimDuration(long startAnimDuration) {
        this.startAnimDuration = startAnimDuration;
        invalidate();
        return this;
    }

    /**
     * Get current stop animation duration in ms.
     */
    public long getStopAnimDuration() {
        return stopAnimDuration;
    }

    /**
     * Set stop animation duration in ms.
     *
     * @param stopAnimDuration set duration.
     */
    public StripedProcessButton setStopAnimDuration(long stopAnimDuration) {
        this.stopAnimDuration = stopAnimDuration;
        invalidate();
        return this;
    }

    /**
     * Get text when button has loading state.
     */
    public String getLoadingText() {
        return stripedDrawable.getLoadingText();
    }

    /**
     * Set text when button has loading state.
     *
     * @param loadingText sets text when loading started
     */
    public StripedProcessButton setLoadingText(String loadingText) {
        stripedDrawable.setLoadingText(loadingText);
        invalidate();
        return this;
    }

    /**
     * Get button stripe animation state.
     *
     * @return true if button is animated else false
     */
    public boolean isButtonAnimated() {
        return buttonAnimated;
    }

    /**
     * Set button stripe animation state.
     *
     * @param buttonAnimated if true button can be animated
     */
    public StripedProcessButton setButtonAnimated(boolean buttonAnimated) {
        this.buttonAnimated = buttonAnimated;
        invalidate();
        return this;
    }

    /**
     * Get width of stripes.
     */
    public float getStripeWidth() {
        return stripedDrawable.getStripeWidth();
    }

    /**
     * Set width of stripes.
     *
     * @param stripeWidth on view
     */
    public StripedProcessButton setStripeWidth(float stripeWidth) {
        stripedDrawable.setStripeWidth(stripeWidth * density);
        invalidate();
        return this;
    }

    /**
     * Get drawable background color.
     */
    public int getColorBack() {
        return stripedDrawable.getColorBack();
    }

    /**
     * Set drawable background color.
     *
     * @param colorBack background color
     */
    public StripedProcessButton setColorBack(int colorBack) {
        stripedDrawable.setColorBack(colorBack);
        invalidate();
        return this;
    }

    /**
     * Get color the main stripe.
     */
    public int getColorMain() {
        return stripedDrawable.getColorMain();
    }

    /**
     * Set color the main stripe.
     *
     * @param colorMain color of main stripe
     */
    public StripedProcessButton setColorMain(int colorMain) {
        stripedDrawable.setColorMain(colorMain);
        invalidate();
        return this;
    }

    /**
     * Get color the sub stripe.
     */
    public int getColorSub() {
        return stripedDrawable.getColorSub();
    }

    /**
     * Set color the sub stripe.
     *
     * @param colorSub color of sub stripe
     */
    public StripedProcessButton setColorSub(int colorSub) {
        stripedDrawable.setColorSub(colorSub);
        invalidate();
        return this;
    }

    /**
     * Get alpha stripes.
     */
    public float getStripeAlpha() {
        return stripedDrawable.getStripeAlpha();
    }

    /**
     * Set alpha drawable stripes.
     *
     * @param alpha stripes
     */
    public StripedProcessButton setStripeAlpha(float alpha) {
        stripedDrawable.setStripeAlpha(alpha);
        invalidate();
        return this;
    }

    /**
     * Get drawable corner radius.
     */
    public float getCornerRadius() {
        return stripedDrawable.getCornerRadius();
    }

    /**
     * Set drawable corner radius.
     *
     * @param cornerRadius radius
     */
    public StripedProcessButton setCornerRadius(float cornerRadius) {
        stripedDrawable.setCornerRadius(cornerRadius);
        invalidate();
        return this;
    }

    /**
     * Get duration of stripes animation.
     */
    public int getStripeDuration() {
        return stripedDrawable.getStripeDuration();
    }

    /**
     * Set duration of stripes animation.
     *
     * @param stripeDuration set duration.
     */
    public StripedProcessButton setStripeDuration(int stripeDuration) {
        stripedDrawable.setStripeDuration(stripeDuration);
        invalidate();
        return this;
    }

    /**
     * Get tilt of stripes.
     */
    public float getTilt() {
        return stripedDrawable.getTilt();
    }

    /**
     * Set tilt of stripes.
     *
     * @param tilt of stripes.
     */
    public StripedProcessButton setTilt(float tilt) {
        stripedDrawable.setTilt(tilt);
        invalidate();
        return this;
    }

    /**
     * Get state of tilt stripes. If true - tilt to left, false - tilt to right.
     */
    public boolean isStripeRevert() {
        return stripedDrawable.isStripeRevert();
    }

    /**
     * Get state of tilt stripes.
     *
     * @param stripeRevert If true - tilt to left, false - tilt to right.
     */
    public StripedProcessButton setStripeRevert(boolean stripeRevert) {
        stripedDrawable.setStripeRevert(stripeRevert);
        invalidate();
        return this;
    }

    /**
     * Get states of showing stripes.
     */
    public boolean isShowStripes() {
        return stripedDrawable.isShowStripes();
    }

    /**
     * Set states of showing stripes.
     *
     * @param showStripes If true - stripes showing, false - stripes gone.
     */
    public StripedProcessButton setShowStripes(boolean showStripes) {
        stripedDrawable.setShowStripes(showStripes);
        invalidate();
        return this;
    }

    /**
     * Get states of stripes appearance.
     */
    public boolean isStripeGradient() {
        return stripedDrawable.isStripeGradient();
    }

    /**
     * Set the state of striped appearance of drawable.
     *
     * @param stripeGradient if true stripes has gradient style, false - flat strips.
     */
    public StripedProcessButton setStripeGradient(boolean stripeGradient) {
        stripedDrawable.setStripeGradient(stripeGradient);
        invalidate();
        return this;
    }

    /**
     * State of launch methods with delay.
     */
    private enum State {
        START, STOP
    }

}
