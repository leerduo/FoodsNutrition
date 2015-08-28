package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class TintRadioButton
  extends RadioButton
{
  private static final int[] a = { 16843015 };
  private final TintManager b;
  
  public TintRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842878);
  }
  
  public TintRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, a, paramInt, 0);
    setButtonDrawable(localTintTypedArray.a(0));
    localTintTypedArray.b();
    this.b = localTintTypedArray.c();
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(this.b.a(paramInt));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintRadioButton
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */