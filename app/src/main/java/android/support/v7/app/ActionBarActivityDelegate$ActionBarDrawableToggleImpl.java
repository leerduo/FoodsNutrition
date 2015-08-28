package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

class ActionBarActivityDelegate$ActionBarDrawableToggleImpl
  implements android.support.v4.app.ActionBarDrawerToggle.Delegate, ActionBarDrawerToggle.Delegate
{
  private ActionBarActivityDelegate$ActionBarDrawableToggleImpl(ActionBarActivityDelegate paramActionBarActivityDelegate) {}
  
  public Drawable getThemeUpIndicator()
  {
    Context localContext = this.a.l();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.a.j();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(arrayOfInt);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public void setActionBarDescription(int paramInt)
  {
    ActionBar localActionBar = this.a.b();
    if (localActionBar != null) {
      localActionBar.a(paramInt);
    }
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.a.b();
    if (localActionBar != null)
    {
      localActionBar.a(paramDrawable);
      localActionBar.a(paramInt);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegate.ActionBarDrawableToggleImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */