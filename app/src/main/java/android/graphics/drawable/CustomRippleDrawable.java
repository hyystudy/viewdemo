package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by sks on 2016/11/23.
 */
public class CustomRippleDrawable extends LayerDrawable {
    public static final int RADIUS_AUTO = -1;

    CustomRippleDrawable() {
        this(null, null);
    }

    private CustomRippleDrawable(ColorStateList state, Drawable[] res) {
        super(res);
    }
    public CustomRippleDrawable(ColorStateList color, Drawable content, Drawable mask) {
        this(color, null);
    }

    public void jumpToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    public int getOpacity() {
        throw new RuntimeException("Stub!");
    }

    protected boolean onStateChange(int[] stateSet) {
        throw new RuntimeException("Stub!");
    }

    protected void onBoundsChange(Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    public boolean setVisible(boolean visible, boolean restart) {
        throw new RuntimeException("Stub!");
    }

    public boolean isStateful() {
        throw new RuntimeException("Stub!");
    }

    public void setColor(ColorStateList color) {
        throw new RuntimeException("Stub!");
    }

    public void setRadius(int radius) {
        throw new RuntimeException("Stub!");
    }

    public int getRadius() {
        throw new RuntimeException("Stub!");
    }

    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        throw new RuntimeException("Stub!");
    }

    public boolean setDrawableByLayerId(int id, Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    public void setPaddingMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    public void applyTheme(Resources.Theme t) {
        throw new RuntimeException("Stub!");
    }

    public boolean canApplyTheme() {
        throw new RuntimeException("Stub!");
    }

    public void setHotspot(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    public void setHotspotBounds(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    public void getHotspotBounds(Rect outRect) {
        throw new RuntimeException("Stub!");
    }

    public void getOutline(Outline outline) {
        throw new RuntimeException("Stub!");
    }

    public void draw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    public void invalidateSelf() {
        throw new RuntimeException("Stub!");
    }

    public Rect getDirtyBounds() {
        throw new RuntimeException("Stub!");
    }

    public Drawable.ConstantState getConstantState() {
        throw new RuntimeException("Stub!");
    }

    public Drawable mutate() {
        throw new RuntimeException("Stub!");
    }
}
