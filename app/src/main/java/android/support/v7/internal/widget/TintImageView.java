package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TintImageView
  extends ImageView
{
  private static final int[] a = { 16842964, 16843033 };
  private final TintManager b;
  
  public TintImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TintImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TintImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, a, paramInt, 0);
    if (localTintTypedArray.a() > 0)
    {
      if (localTintTypedArray.d(0)) {
        setBackgroundDrawable(localTintTypedArray.a(0));
      }
      if (localTintTypedArray.d(1)) {
        setImageDrawable(localTintTypedArray.a(1));
      }
    }
    localTintTypedArray.b();
    this.b = localTintTypedArray.c();
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(this.b.a(paramInt));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintImageView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */