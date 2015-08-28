package com.activeandroid;

import android.content.Context;
import com.activeandroid.util.Log;

public final class ActiveAndroid
{
  public static void a() {}
  
  public static void a(Context paramContext)
  {
    a(new Configuration.Builder(paramContext).a());
  }
  
  public static void a(Configuration paramConfiguration)
  {
    a(paramConfiguration, false);
  }
  
  public static void a(Configuration paramConfiguration, boolean paramBoolean)
  {
    a(paramBoolean);
    Cache.a(paramConfiguration);
  }
  
  public static void a(boolean paramBoolean)
  {
    Log.a(paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.ActiveAndroid
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */