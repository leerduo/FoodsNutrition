package com.loopj.android.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class RetryHandler
  implements HttpRequestRetryHandler
{
  private static final HashSet<Class<?>> exceptionBlacklist;
  private static final HashSet<Class<?>> exceptionWhitelist = new HashSet();
  private final int maxRetries;
  private final int retrySleepTimeMS;
  
  static
  {
    exceptionBlacklist = new HashSet();
    exceptionWhitelist.add(NoHttpResponseException.class);
    exceptionWhitelist.add(UnknownHostException.class);
    exceptionWhitelist.add(SocketException.class);
    exceptionBlacklist.add(InterruptedIOException.class);
    exceptionBlacklist.add(SSLException.class);
  }
  
  public RetryHandler(int paramInt1, int paramInt2)
  {
    this.maxRetries = paramInt1;
    this.retrySleepTimeMS = paramInt2;
  }
  
  static void addClassToBlacklist(Class<?> paramClass)
  {
    exceptionBlacklist.add(paramClass);
  }
  
  static void addClassToWhitelist(Class<?> paramClass)
  {
    exceptionWhitelist.add(paramClass);
  }
  
  protected boolean isInList(HashSet<Class<?>> paramHashSet, Throwable paramThrowable)
  {
    Iterator localIterator = paramHashSet.iterator();
    while (localIterator.hasNext()) {
      if (((Class)localIterator.next()).isInstance(paramThrowable)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool1 = true;
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    boolean bool2;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      bool2 = bool1;
      if (paramInt <= this.maxRetries) {
        break label71;
      }
      bool1 = false;
    }
    for (;;)
    {
      if ((!bool1) || ((HttpUriRequest)paramHttpContext.getAttribute("http.request") != null)) {
        break label107;
      }
      return false;
      bool2 = false;
      break;
      label71:
      if (!isInList(exceptionWhitelist, paramIOException)) {
        if (isInList(exceptionBlacklist, paramIOException)) {
          bool1 = false;
        } else if (bool2) {}
      }
    }
    label107:
    if (bool1) {
      SystemClock.sleep(this.retrySleepTimeMS);
    }
    for (;;)
    {
      return bool1;
      paramIOException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.RetryHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */