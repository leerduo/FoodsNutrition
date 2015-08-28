package com.loopj.android.http;

import org.apache.http.Header;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE>
  extends TextHttpResponseHandler
{
  private static final String LOG_TAG = "BaseJsonHttpResponseHandler";
  
  public BaseJsonHttpResponseHandler()
  {
    this("UTF-8");
  }
  
  public BaseJsonHttpResponseHandler(String paramString)
  {
    super(paramString);
  }
  
  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable)
  {
    if (paramString != null)
    {
      BaseJsonHttpResponseHandler.2 local2 = new BaseJsonHttpResponseHandler.2(this, paramString, paramInt, paramArrayOfHeader, paramThrowable);
      if (!getUseSynchronousMode())
      {
        new Thread(local2).start();
        return;
      }
      local2.run();
      return;
    }
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, null, null);
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, String paramString, JSON_TYPE paramJSON_TYPE);
  
  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    if (paramInt != 204)
    {
      BaseJsonHttpResponseHandler.1 local1 = new BaseJsonHttpResponseHandler.1(this, paramString, paramInt, paramArrayOfHeader);
      if (!getUseSynchronousMode())
      {
        new Thread(local1).start();
        return;
      }
      local1.run();
      return;
    }
    onSuccess(paramInt, paramArrayOfHeader, null, null);
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString, JSON_TYPE paramJSON_TYPE);
  
  protected abstract JSON_TYPE parseResponse(String paramString, boolean paramBoolean);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.BaseJsonHttpResponseHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */