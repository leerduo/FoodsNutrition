package com.qiniu.android.http;

import android.os.Build;
import android.os.Build.VERSION;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import org.apache.http.Header;

public final class HttpManager
{
  private static final String userAgent = ;
  private AsyncHttpClient client = new AsyncHttpClient();
  
  public HttpManager()
  {
    this(null);
  }
  
  public HttpManager(Proxy paramProxy)
  {
    this.client.setConnectTimeout(10000);
    this.client.setResponseTimeout(30000);
    this.client.setUserAgent(userAgent);
    this.client.setEnableRedirects(false);
    if (paramProxy != null) {
      this.client.setProxy(paramProxy.hostAddress, paramProxy.port, paramProxy.user, paramProxy.password);
    }
  }
  
  private static String genId()
  {
    Random localRandom = new Random();
    return System.currentTimeMillis() + "" + localRandom.nextInt(999);
  }
  
  private static String getUserAgent()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "7.0.2";
    arrayOfObject[1] = Build.VERSION.RELEASE;
    arrayOfObject[2] = Build.MODEL;
    arrayOfObject[3] = genId();
    return String.format("QiniuAndroid/%s (%s; %s; %s)", arrayOfObject);
  }
  
  public void multipartPost(String paramString, PostArgs paramPostArgs, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler)
  {
    RequestParams localRequestParams = new RequestParams(paramPostArgs.params);
    if (paramPostArgs.data != null) {
      localRequestParams.put("file", new ByteArrayInputStream(paramPostArgs.data), paramPostArgs.fileName, paramPostArgs.mimeType);
    }
    for (;;)
    {
      ResponseHandler localResponseHandler = new ResponseHandler(paramString, paramCompletionHandler, paramProgressHandler);
      this.client.post(paramString, localRequestParams, localResponseHandler);
      return;
      try
      {
        localRequestParams.put("file", paramPostArgs.file, paramPostArgs.mimeType);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        paramCompletionHandler.complete(ResponseInfo.fileError(localFileNotFoundException), null);
      }
    }
  }
  
  public void postData(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Header[] paramArrayOfHeader, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler)
  {
    ResponseHandler localResponseHandler = new ResponseHandler(paramString, paramCompletionHandler, paramProgressHandler);
    ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(paramArrayOfByte, paramInt1, paramInt2);
    this.client.post(null, paramString, paramArrayOfHeader, localByteArrayEntity, "application/octet-stream", localResponseHandler);
  }
  
  public void postData(String paramString, byte[] paramArrayOfByte, Header[] paramArrayOfHeader, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler)
  {
    postData(paramString, paramArrayOfByte, 0, paramArrayOfByte.length, paramArrayOfHeader, paramProgressHandler, paramCompletionHandler);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.http.HttpManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */