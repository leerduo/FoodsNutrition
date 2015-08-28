package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler
  extends TextHttpResponseHandler
{
  private static final String LOG_TAG = "JsonHttpResponseHandler";
  
  public JsonHttpResponseHandler()
  {
    super("UTF-8");
  }
  
  public JsonHttpResponseHandler(String paramString)
  {
    super(paramString);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable)
  {
    Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", paramThrowable);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONArray paramJSONArray)
  {
    Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", paramThrowable);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONObject paramJSONObject)
  {
    Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", paramThrowable);
  }
  
  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    if (paramArrayOfByte != null)
    {
      JsonHttpResponseHandler.2 local2 = new JsonHttpResponseHandler.2(this, paramArrayOfByte, paramInt, paramArrayOfHeader, paramThrowable);
      if (!getUseSynchronousMode())
      {
        new Thread(local2).start();
        return;
      }
      local2.run();
      return;
    }
    Log.v("JsonHttpResponseHandler", "response body is null, calling onFailure(Throwable, JSONObject)");
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, (JSONObject)null);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], String) was not overriden, but callback was received");
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray)
  {
    Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
  }
  
  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    if (paramInt != 204)
    {
      JsonHttpResponseHandler.1 local1 = new JsonHttpResponseHandler.1(this, paramArrayOfByte, paramInt, paramArrayOfHeader);
      if (!getUseSynchronousMode())
      {
        new Thread(local1).start();
        return;
      }
      local1.run();
      return;
    }
    onSuccess(paramInt, paramArrayOfHeader, new JSONObject());
  }
  
  protected Object parseResponse(byte[] paramArrayOfByte)
  {
    Object localObject1;
    if (paramArrayOfByte == null) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject1 = getResponseString(paramArrayOfByte, getCharset());
      localObject2 = null;
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).trim();
        if (((String)localObject1).startsWith("﻿")) {
          localObject1 = ((String)localObject1).substring(1);
        }
        if (!((String)localObject1).startsWith("{"))
        {
          boolean bool = ((String)localObject1).startsWith("[");
          localObject2 = null;
          if (!bool) {}
        }
        else
        {
          localObject2 = new JSONTokener((String)localObject1).nextValue();
        }
      }
    } while (localObject2 == null);
    return localObject2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.JsonHttpResponseHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */