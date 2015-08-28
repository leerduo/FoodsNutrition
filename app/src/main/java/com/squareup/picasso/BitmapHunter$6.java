package com.squareup.picasso;

final class BitmapHunter$6
  implements Runnable
{
  BitmapHunter$6(Transformation paramTransformation) {}
  
  public void run()
  {
    throw new IllegalStateException("Transformation " + this.a.a() + " mutated input Bitmap but failed to recycle the original.");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.BitmapHunter.6
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */