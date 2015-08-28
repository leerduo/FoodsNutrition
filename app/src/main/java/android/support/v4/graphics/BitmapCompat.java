package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public class BitmapCompat
{
  static final BitmapCompat.BitmapImpl IMPL = new BitmapCompat.BaseBitmapImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      IMPL = new BitmapCompat.KitKatBitmapCompatImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new BitmapCompat.JbMr2BitmapCompatImpl();
      return;
    }
    if (i >= 12)
    {
      IMPL = new BitmapCompat.HcMr1BitmapCompatImpl();
      return;
    }
  }
  
  public static int getAllocationByteCount(Bitmap paramBitmap)
  {
    return IMPL.getAllocationByteCount(paramBitmap);
  }
  
  public static boolean hasMipMap(Bitmap paramBitmap)
  {
    return IMPL.hasMipMap(paramBitmap);
  }
  
  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
  {
    IMPL.setHasMipMap(paramBitmap, paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.BitmapCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */