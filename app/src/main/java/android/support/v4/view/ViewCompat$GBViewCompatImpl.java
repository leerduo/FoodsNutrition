package android.support.v4.view;

import android.view.View;

class ViewCompat$GBViewCompatImpl
  extends ViewCompat.EclairMr1ViewCompatImpl
{
  public int getOverScrollMode(View paramView)
  {
    return ViewCompatGingerbread.getOverScrollMode(paramView);
  }
  
  public void setOverScrollMode(View paramView, int paramInt)
  {
    ViewCompatGingerbread.setOverScrollMode(paramView, paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.GBViewCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */