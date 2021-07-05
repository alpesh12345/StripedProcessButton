package com.alpesh.strippedprocessbutton;

import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorValue;
import ohos.agp.components.Component;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.render.Canvas;
import ohos.agp.render.LinearShader;
import ohos.agp.render.Paint;
import ohos.agp.render.Shader;
import ohos.agp.utils.Color;
import ohos.agp.utils.Point;
import ohos.agp.utils.Rect;
import ohos.agp.utils.RectFloat;
import ohos.agp.utils.TextAlignment;


/**
 * AnimatedStripedDrawable Class.
 */
public class AnimatedStripedDrawable extends ShapeElement implements Element.OnChangeListener {
    private int viewHeight;
    private int viewWidth;
    private float tiltLeft = 0f;
    private float tiltRight = 0f;
    private boolean running = false;
    private StripedDrawable drawable;
    private AnimatorValue animator;
    private Shader stripesShader;
    private Component mcomponent;

    public AnimatedStripedDrawable(StripedDrawable drawable) {
        this.drawable = drawable;
        setCallback(this::onChange);
    }

    @Override
    public void onChange(Element element) {
        viewHeight = mcomponent.getEstimatedHeight();
        viewWidth = mcomponent.getEstimatedWidth();
        adjustStripes();
    }

    private void adjustStripes() {
        if (!drawable.isStripeRevert()) {
            tiltLeft = drawable.getTilt();
            tiltRight = 0;
        } else {
            tiltRight = drawable.getTilt();
            tiltLeft = 0;
        }
    }

    private void initAnimator() {
        if (animator == null) {
            animator = new AnimatorValue();
            animator.setCurveType(Animator.CurveType.LINEAR);
            animator.setDuration(drawable.getStripeDuration());
            animator.setLoopedCount(-1);
            animator.setLoopedListener(animator -> {
                shiftColor(drawable.getColorMain(), drawable.getColorSub());
                invalidateSelf();
            });
        }
    }

    @Override
    public int getWidth() {
        return viewWidth > 0 ? viewWidth : super.getWidth();
    }

    @Override
    public int getHeight() {
        return viewHeight > 0 ? viewHeight : super.getHeight();
    }

    @Override
    public void setAlpha(int alpha) {
        //
    }

    @Override
    public void drawToCanvas(Canvas canvas) {
        super.drawToCanvas(canvas);
        drawStripes(canvas);
        startStripesAnimation();
    }

    private void startStripesAnimation() {
        if (running) {
            start();
        } else {
            drawable.setShowStripes(false);
        }
    }

    private void drawStripes(Canvas canvas) {
        final Paint paintBack = new Paint();
        final Paint paintStripes = new Paint();
        final Paint textpaint = new Paint();
        final Rect rect = new Rect(0, 0, viewWidth, viewHeight);
        final RectFloat rectF = new RectFloat(rect);
        final int stripesAlpha = Util.computeAlpha(drawable.getStripeAlpha());
        paintBack.setAntiAlias(true);
        paintStripes.setAntiAlias(true);
        if (drawable.isStripeGradient()) {
            stripesShader = createGradientShader();
        } else {
            stripesShader = createShader();
        }
        textpaint.setAntiAlias(true);
        textpaint.setColor(new Color(drawable.getTextColor()));
        textpaint.setTextAlign(TextAlignment.CENTER);
        textpaint.setTextSize(drawable.getTextSize());
        textpaint.setFont(drawable.getFont());
        paintBack.setColor(new Color(drawable.getColorBack()));
        float cornerRadius = drawable.getCornerRadius();
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paintBack);
        canvas.drawText(textpaint, drawable.getButtonText(),
                viewWidth / 2f, (viewHeight + textpaint.getTextSize()) / 2f);
        if (drawable.isShowStripes()) {
            paintStripes.setAlpha(stripesAlpha);
            paintStripes.setShader(stripesShader, Paint.ShaderType.LINEAR_SHADER);
            canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paintStripes);
            canvas.drawText(textpaint, drawable.getLoadingText(),
                    viewWidth / 2f, (viewHeight + textpaint.getTextSize()) / 2f);
        }
    }

    private LinearShader createShader() {
        return new LinearShader(new Point[] {new Point(drawable.getStripeWidth(), tiltLeft), new Point(0, tiltRight)},
                new float[]{0.5f, 0.5f},
                new Color[] { new Color(drawable.getColorMain()), new Color(drawable.getColorSub())},
                Shader.TileMode.REPEAT_TILEMODE);
    }

    private LinearShader createGradientShader() {
        return new LinearShader(new Point[] {new Point(drawable.getStripeWidth(), tiltLeft), new Point(0, tiltRight)},
                null,
                new Color[] { new Color(drawable.getColorMain()), new Color(drawable.getColorSub())},
                Shader.TileMode.REPEAT_TILEMODE);
    }

    private void shiftColor(int mainColor, int subColor) {
        drawable.setColorMain(subColor);
        drawable.setColorSub(mainColor);
    }

    /**
     * Start stripes animation.
     */
    protected void start() {
        if (isRunning()) {
            return;
        }
        running = true;
        initAnimator();
        animator.start();
        drawable.setShowStripes(true);
        invalidateSelf();
    }

    /**
     * Stop stripes animation.
     */
    protected void stop() {
        if (!isRunning()) {
            return;
        }
        running = false;
        animator.cancel();
        drawable.setShowStripes(false);
        invalidateSelf();
    }

    /**
     * Check if stripes animation running.
     */
    protected boolean isRunning() {
        return animator != null && animator.isRunning();
    }

    /**
     * mcomponent is used to get viewHeight and viewWidth in this class.
     *
     * @param component is set to mcomponent here.
     */
    public void setComponent(Component component) {
        mcomponent = component;
    }

    /**
     * Used to check if component is linked or not.
     */
    public void invalidateSelf() {
        if (mcomponent != null) {
            mcomponent.invalidate();
        }
    }
}