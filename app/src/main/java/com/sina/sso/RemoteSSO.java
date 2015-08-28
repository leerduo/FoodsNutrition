package com.sina.sso;

import android.os.IInterface;

public abstract interface RemoteSSO
  extends IInterface
{
  public abstract String getActivityName();
  
  public abstract String getPackageName();
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.sina.sso.RemoteSSO
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */