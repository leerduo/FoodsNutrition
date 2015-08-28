package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class TintEditText
  extends EditText
{
  private static final int[] a = { 16842964 };
  
  public TintEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public TintEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, a, paramInt, 0);
    setBackgroundDrawable(localTintTypedArray.a(0));
    localTintTypedArray.b();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintEditText
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */