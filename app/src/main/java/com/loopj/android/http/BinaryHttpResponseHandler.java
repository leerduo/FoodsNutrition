package com.loopj.android.http;

import android.util.Log;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class BinaryHttpResponseHandler
  extends AsyncHttpResponseHandler
{
  private static final String LOG_TAG = "BinaryHttpResponseHandler";
  private String[] mAllowedContentTypes = { "application/octet-stream", "image/jpeg", "image/png", "image/gif" };
  
  public BinaryHttpResponseHandler() {}
  
  public BinaryHttpResponseHandler(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.mAllowedContentTypes = paramArrayOfString;
      return;
    }
    Log.e("BinaryHttpResponseHandler", "Constructor passed allowedContentTypes was null !");
  }
  
  public String[] getAllowedContentTypes()
  {
    return this.mAllowedContentTypes;
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte);
  
  public final void sendResponseMessage(HttpResponse paramHttpResponse)
  {
    int i = 0;
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    Header[] arrayOfHeader = paramHttpResponse.getHeaders("Content-Type");
    if (arrayOfHeader.length != 1)
    {
      sendFailureMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
      return;
    }
    Header localHeader = arrayOfHeader[0];
    String[] arrayOfString = getAllowedContentTypes();
    int j = arrayOfString.length;
    int k = 0;
    for (;;)
    {
      if (k < j)
      {
        String str = arrayOfString[k];
        try
        {
          boolean bool = Pattern.matches(str, localHeader.getValue());
          if (bool) {
            i = 1;
          }
          k++;
        }
        catch (PatternSyntaxException localPatternSyntaxException)
        {
          for (;;)
          {
            Log.e("BinaryHttpResponseHandler", "Given pattern is not valid: " + str, localPatternSyntaxException);
          }
        }
      }
    }
    if (i == 0)
    {
      sendFailureMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), "Content-Type not allowed!"));
      return;
    }
    super.sendResponseMessage(paramHttpResponse);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.BinaryHttpResponseHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */