package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest
  implements Runnable
{
  private boolean cancelIsNotified;
  private final AbstractHttpClient client;
  private final HttpContext context;
  private int executionCount;
  private boolean isCancelled;
  private boolean isFinished;
  private boolean isRequestPreProcessed;
  private final HttpUriRequest request;
  private final ResponseHandlerInterface responseHandler;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    this.client = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.request = paramHttpUriRequest;
    this.responseHandler = paramResponseHandlerInterface;
  }
  
  private void makeRequest()
  {
    if (isCancelled()) {}
    HttpResponse localHttpResponse;
    do
    {
      do
      {
        do
        {
          return;
          if (this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
          }
          localHttpResponse = this.client.execute(this.request, this.context);
        } while ((isCancelled()) || (this.responseHandler == null));
        this.responseHandler.onPreProcessResponse(this.responseHandler, localHttpResponse);
      } while (isCancelled());
      this.responseHandler.sendResponseMessage(localHttpResponse);
    } while (isCancelled());
    this.responseHandler.onPostProcessResponse(this.responseHandler, localHttpResponse);
  }
  
  private void makeRequestWithRetries()
  {
    IOException localIOException1 = null;
    HttpRequestRetryHandler localHttpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
    boolean bool1 = true;
    if (bool1) {}
    for (;;)
    {
      IOException localIOException3;
      boolean bool3;
      try
      {
        makeRequest();
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localIOException3 = new IOException("UnknownHostException exception: " + localUnknownHostException.getMessage());
        if (this.executionCount > 0)
        {
          int k = 1 + this.executionCount;
          this.executionCount = k;
          if (localHttpRequestRetryHandler.retryRequest(localIOException3, k, this.context))
          {
            bool3 = true;
            break label284;
            if ((!bool1) || (this.responseHandler == null)) {
              break;
            }
            this.responseHandler.sendRetryMessage(this.executionCount);
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("AsyncHttpRequest", "Unhandled exception origin cause", localException);
        localIOException1 = new IOException("Unhandled exception: " + localException.getMessage());
        throw localIOException1;
        bool3 = false;
      }
      catch (NullPointerException localNullPointerException)
      {
        localIOException1 = new IOException("NPE in HttpClient: " + localNullPointerException.getMessage());
        int j = 1 + this.executionCount;
        this.executionCount = j;
        bool1 = localHttpRequestRetryHandler.retryRequest(localIOException1, j, this.context);
        continue;
      }
      catch (IOException localIOException2)
      {
        if (isCancelled()) {
          continue;
        }
        int i = 1 + this.executionCount;
        this.executionCount = i;
        boolean bool2 = localHttpRequestRetryHandler.retryRequest(localIOException2, i, this.context);
        bool1 = bool2;
        continue;
      }
      label284:
      bool1 = bool3;
      Object localObject = localIOException3;
    }
  }
  
  private void sendCancelNotification()
  {
    try
    {
      if ((!this.isFinished) && (this.isCancelled) && (!this.cancelIsNotified))
      {
        this.cancelIsNotified = true;
        if (this.responseHandler != null) {
          this.responseHandler.sendCancelMessage();
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.isCancelled = true;
    this.request.abort();
    return isCancelled();
  }
  
  public boolean isCancelled()
  {
    if (this.isCancelled) {
      sendCancelNotification();
    }
    return this.isCancelled;
  }
  
  public boolean isDone()
  {
    return (isCancelled()) || (this.isFinished);
  }
  
  public void onPostProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void onPreProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void run()
  {
    if (isCancelled()) {}
    for (;;)
    {
      return;
      if (!this.isRequestPreProcessed)
      {
        this.isRequestPreProcessed = true;
        onPreProcessRequest(this);
      }
      if (isCancelled()) {
        continue;
      }
      if (this.responseHandler != null) {
        this.responseHandler.sendStartMessage();
      }
      if (isCancelled()) {
        continue;
      }
      try
      {
        makeRequestWithRetries();
        if (isCancelled()) {
          continue;
        }
        if (this.responseHandler != null) {
          this.responseHandler.sendFinishMessage();
        }
        if (isCancelled()) {
          continue;
        }
        onPostProcessRequest(this);
        this.isFinished = true;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if ((!isCancelled()) && (this.responseHandler != null)) {
            this.responseHandler.sendFailureMessage(0, null, null, localIOException);
          } else {
            Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", localIOException);
          }
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.AsyncHttpRequest
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */