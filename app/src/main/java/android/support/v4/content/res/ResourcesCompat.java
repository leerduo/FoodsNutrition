package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class ResourcesCompat
{
  public static Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ResourcesCompatApi21.getDrawable(paramResources, paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.ResourcesCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */