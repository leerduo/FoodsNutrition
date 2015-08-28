package android.support.v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

class ContextCompatApi21
{
  public static File getCodeCacheDir(Context paramContext)
  {
    return paramContext.getCodeCacheDir();
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    return paramContext.getDrawable(paramInt);
  }
  
  public static File getNoBackupFilesDir(Context paramContext)
  {
    return paramContext.getNoBackupFilesDir();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompatApi21
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */