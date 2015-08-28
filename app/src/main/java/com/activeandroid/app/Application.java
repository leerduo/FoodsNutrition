package com.activeandroid.app;

import com.activeandroid.ActiveAndroid;

public class Application
  extends android.app.Application
{
  public void onCreate()
  {
    super.onCreate();
    ActiveAndroid.a(this);
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    ActiveAndroid.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.app.Application
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */