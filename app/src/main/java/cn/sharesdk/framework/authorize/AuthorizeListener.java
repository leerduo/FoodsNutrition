package cn.sharesdk.framework.authorize;

import android.os.Bundle;

public abstract interface AuthorizeListener
{
  public abstract void onCancel();
  
  public abstract void onComplete(Bundle paramBundle);
  
  public abstract void onError(Throwable paramThrowable);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.AuthorizeListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */