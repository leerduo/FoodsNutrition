package android.support.v4.graphics;

import android.graphics.Bitmap;

class BitmapCompat$BaseBitmapImpl
  implements BitmapCompat.BitmapImpl
{
  public int getAllocationByteCount(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public boolean hasMipMap(Bitmap paramBitmap)
  {
    return false;
  }
  
  public void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.BitmapCompat.BaseBitmapImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */