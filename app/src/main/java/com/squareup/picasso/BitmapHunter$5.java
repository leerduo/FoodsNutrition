package com.squareup.picasso;

final class BitmapHunter$5
  implements Runnable
{
  BitmapHunter$5(Transformation paramTransformation) {}
  
  public void run()
  {
    throw new IllegalStateException("Transformation " + this.a.a() + " returned input Bitmap but recycled it.");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.BitmapHunter.5
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */