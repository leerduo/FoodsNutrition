package cn.sharesdk.framework.authorize;

import android.os.Bundle;

public abstract interface SSOListener
{
  public abstract void onCancel();
  
  public abstract void onComplete(Bundle paramBundle);
  
  public abstract void onFailed(Throwable paramThrowable);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.SSOListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */