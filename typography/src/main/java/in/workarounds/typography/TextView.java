package in.workarounds.typography;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by madki on 22/08/15.
 */
public class TextView extends android.widget.TextView {
    private String mFontName;
    private String mFontVariant;

    public TextView(Context context) {
        super(context);
        setFont();
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
        setFont();
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(attrs);
        setFont();
    }

    private void getAttrs(AttributeSet attrs){
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TextView);
        try{
            mFontName = a.getString(R.styleable.TextView_font_name);
            mFontVariant = a.getString(R.styleable.TextView_font_variant);
        } finally{
            a.recycle();
        }
    }

    private void setFont() {
        if(isInEditMode()) {
            return;
        }

        Typeface typeface = FontLoader.getInstance(getContext()).getTypeface(mFontName, mFontVariant);
        setTypeface(typeface);
    }
}
