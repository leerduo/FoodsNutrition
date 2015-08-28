package com.umeng.update.net;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import u.upd.b;
import u.upd.n;

class c$1
  implements Runnable
{
  c$1(c paramc, String[] paramArrayOfString, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    i = new Random().nextInt(1000);
    if (this.b == null) {
      b.a(c.a(), i + "service report: urls is null");
    }
    String[] arrayOfString;
    int j;
    int k;
    do
    {
      return;
      arrayOfString = this.b;
      j = arrayOfString.length;
      k = 0;
    } while (k >= j);
    str1 = arrayOfString[k];
    String str2 = n.a();
    String str3 = str2.split(" ")[0];
    String str4 = str2.split(" ")[1];
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder(str1);
    localStringBuilder.append("&data=").append(str3);
    localStringBuilder.append("&time=").append(str4);
    localStringBuilder.append("&ts=").append(l);
    label171:
    Iterator localIterator;
    if (this.c)
    {
      localStringBuilder.append("&action_type=").append(1);
      if (this.d != null) {
        localIterator = this.d.keySet().iterator();
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (localIterator.hasNext()) {
          break label378;
        }
        try
        {
          b.a(c.a(), i + ": service report:\tget: " + localStringBuilder.toString());
          HttpGet localHttpGet = new HttpGet(localStringBuilder.toString());
          BasicHttpParams localBasicHttpParams = new BasicHttpParams();
          HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
          HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
          HttpResponse localHttpResponse = new DefaultHttpClient(localBasicHttpParams).execute(localHttpGet);
          b.a(c.a(), i + ": service report:status code:  " + localHttpResponse.getStatusLine().getStatusCode());
          int m = localHttpResponse.getStatusLine().getStatusCode();
          if (m == 200) {
            break;
          }
          k++;
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          for (;;)
          {
            String str5;
            b.c(c.a(), i + ": service report:\tClientProtocolException,Failed to send message." + str1, localClientProtocolException);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label378:
            b.c(c.a(), i + ": service report:\tIOException,Failed to send message." + str1, localIOException);
          }
        }
      }
      localStringBuilder.append("&action_type=").append(-2);
      break label171;
      str5 = (String)localIterator.next();
      localStringBuilder.append("&").append(str5).append("=").append((String)this.d.get(str5));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.c.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */