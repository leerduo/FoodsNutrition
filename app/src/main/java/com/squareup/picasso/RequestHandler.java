package com.squareup.picasso;

import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;

public abstract class RequestHandler
{
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions, Request paramRequest)
  {
    int i = 1;
    if ((paramInt4 > paramInt2) || (paramInt3 > paramInt1))
    {
      if (paramInt2 != 0) {
        break label43;
      }
      i = (int)Math.floor(paramInt3 / paramInt1);
    }
    for (;;)
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      return;
      label43:
      if (paramInt1 == 0)
      {
        i = (int)Math.floor(paramInt4 / paramInt2);
      }
      else
      {
        int j = (int)Math.floor(paramInt4 / paramInt2);
        int k = (int)Math.floor(paramInt3 / paramInt1);
        if (paramRequest.k) {
          i = Math.max(j, k);
        } else {
          i = Math.min(j, k);
        }
      }
    }
  }
  
  static void a(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, Request paramRequest)
  {
    a(paramInt1, paramInt2, paramOptions.outWidth, paramOptions.outHeight, paramOptions, paramRequest);
  }
  
  static boolean a(BitmapFactory.Options paramOptions)
  {
    return (paramOptions != null) && (paramOptions.inJustDecodeBounds);
  }
  
  static BitmapFactory.Options d(Request paramRequest)
  {
    boolean bool = paramRequest.d();
    if (paramRequest.p != null) {}
    for (int i = 1;; i = 0)
    {
      BitmapFactory.Options localOptions;
      if (!bool)
      {
        localOptions = null;
        if (i == 0) {}
      }
      else
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = bool;
        if (i != 0) {
          localOptions.inPreferredConfig = paramRequest.p;
        }
      }
      return localOptions;
    }
  }
  
  int a()
  {
    return 0;
  }
  
  public abstract boolean a(Request paramRequest);
  
  boolean a(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    return false;
  }
  
  public abstract RequestHandler.Result b(Request paramRequest);
  
  boolean b()
  {
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */