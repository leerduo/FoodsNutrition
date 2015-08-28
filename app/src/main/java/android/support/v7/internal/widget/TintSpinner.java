package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;

public class TintSpinner
  extends Spinner
{
  private static final int[] a = { 16842964, 16843126 };
  
  public TintSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842881);
  }
  
  public TintSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, a, paramInt, 0);
    setBackgroundDrawable(localTintTypedArray.a(0));
    Drawable localDrawable;
    if (localTintTypedArray.d(1))
    {
      localDrawable = localTintTypedArray.a(1);
      if (Build.VERSION.SDK_INT < 16) {
        break label66;
      }
      setPopupBackgroundDrawable(localDrawable);
    }
    for (;;)
    {
      localTintTypedArray.b();
      return;
      label66:
      if (Build.VERSION.SDK_INT >= 11) {
        a(this, localDrawable);
      }
    }
  }
  
  @TargetApi(11)
  private static void a(Spinner paramSpinner, Drawable paramDrawable)
  {
    try
    {
      Field localField = Spinner.class.getDeclaredField("mPopup");
      localField.setAccessible(true);
      Object localObject = localField.get(paramSpinner);
      if ((localObject instanceof ListPopupWindow)) {
        ((ListPopupWindow)localObject).setBackgroundDrawable(paramDrawable);
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintSpinner
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */