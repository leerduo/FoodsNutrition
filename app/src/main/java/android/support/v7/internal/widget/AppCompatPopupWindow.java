package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

public class AppCompatPopupWindow
  extends PopupWindow
{
  private final boolean a;
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, R.styleable.PopupWindow, paramInt, 0);
    this.a = localTintTypedArray.a(R.styleable.PopupWindow_overlapAnchor, false);
    setBackgroundDrawable(localTintTypedArray.a(R.styleable.PopupWindow_android_popupBackground));
    localTintTypedArray.b();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if ((Build.VERSION.SDK_INT < 21) && (this.a)) {
      paramInt2 -= paramView.getHeight();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  @TargetApi(19)
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((Build.VERSION.SDK_INT < 21) && (this.a)) {
      paramInt2 -= paramView.getHeight();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((Build.VERSION.SDK_INT < 21) && (this.a)) {}
    for (int i = paramInt2 - paramView.getHeight();; i = paramInt2)
    {
      super.update(paramView, paramInt1, i, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AppCompatPopupWindow
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */