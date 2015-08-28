package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class TintCheckedTextView
  extends CheckedTextView
{
  private static final int[] a = { 16843016 };
  private final TintManager b;
  
  public TintCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public TintCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, a, paramInt, 0);
    setCheckMarkDrawable(localTintTypedArray.a(0));
    localTintTypedArray.b();
    this.b = localTintTypedArray.c();
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(this.b.a(paramInt));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintCheckedTextView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */