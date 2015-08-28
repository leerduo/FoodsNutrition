package android.support.v7.internal.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class TintResources
  extends Resources
{
  private final TintManager a;
  
  public TintResources(Resources paramResources, TintManager paramTintManager)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.a = paramTintManager;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    if (localDrawable != null) {
      this.a.a(paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintResources
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */