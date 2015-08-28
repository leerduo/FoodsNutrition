package com.google.zxing.client.android;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

final class ViewfinderResultPointCallback
  implements ResultPointCallback
{
  private final ViewfinderView a;
  
  ViewfinderResultPointCallback(ViewfinderView paramViewfinderView)
  {
    this.a = paramViewfinderView;
  }
  
  public void a(ResultPoint paramResultPoint)
  {
    this.a.a(paramResultPoint);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.ViewfinderResultPointCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */