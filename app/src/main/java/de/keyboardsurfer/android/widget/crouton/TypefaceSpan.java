package de.keyboardsurfer.android.widget.crouton;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class TypefaceSpan
  extends MetricAffectingSpan
{
  private static LruCache<String, Typeface> a = new LruCache(5);
  private Typeface b;
  
  public TypefaceSpan(Context paramContext, String paramString)
  {
    this.b = ((Typeface)a.get(paramString));
    if (this.b == null)
    {
      this.b = Typeface.createFromAsset(paramContext.getApplicationContext().getAssets(), String.format("%s", new Object[] { paramString }));
      a.put(paramString, this.b);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setTypeface(this.b);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    paramTextPaint.setTypeface(this.b);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     de.keyboardsurfer.android.widget.crouton.TypefaceSpan
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */