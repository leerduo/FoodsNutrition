package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;

@TargetApi(11)
class Utils$ActivityManagerHoneycomb
{
  static int a(ActivityManager paramActivityManager)
  {
    return paramActivityManager.getLargeMemoryClass();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Utils.ActivityManagerHoneycomb
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */