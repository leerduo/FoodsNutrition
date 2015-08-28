package com.umeng.analytics.social;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public abstract class c
{
  private static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      return null;
    }
    catch (IOException localIOException2)
    {
      b.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException2);
      for (;;)
      {
        try
        {
          paramInputStream.close();
          return null;
        }
        catch (IOException localIOException3)
        {
          b.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException3);
          return null;
        }
        try
        {
          paramInputStream.close();
          return localStringBuilder.toString();
        }
        catch (IOException localIOException4)
        {
          b.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException4);
          return null;
        }
      }
    }
    finally
    {
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        b.b("MobclickAgent", "Caught IOException in convertStreamToString()", localIOException1);
      }
    }
  }
  
  protected static String a(String paramString)
  {
    int i = new Random().nextInt(1000);
    label444:
    for (;;)
    {
      try
      {
        String str1 = System.getProperty("line.separator");
        if (paramString.length() <= 1)
        {
          b.b("MobclickAgent", i + ":\tInvalid baseUrl.");
          return null;
        }
        HttpGet localHttpGet = new HttpGet(paramString);
        b.a("MobclickAgent", i + ": GET_URL: " + paramString);
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        HttpResponse localHttpResponse = new DefaultHttpClient(localBasicHttpParams).execute(localHttpGet);
        InputStream localInputStream;
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          if (localHttpEntity == null) {
            break;
          }
          localInputStream = localHttpEntity.getContent();
          Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader != null) && (localHeader.getValue().equalsIgnoreCase("gzip")))
          {
            b.a("MobclickAgent", i + "  Use GZIPInputStream get data....");
            localObject = new GZIPInputStream(localInputStream);
            String str2 = a((InputStream)localObject);
            b.a("MobclickAgent", i + ":\tresponse: " + str1 + str2);
            if (str2 == null) {
              break;
            }
            return str2;
          }
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate"))) {
            break label444;
          }
          b.a("MobclickAgent", i + "  Use InflaterInputStream get data....");
          localObject = new InflaterInputStream(localInputStream);
          continue;
        }
        Object localObject = localInputStream;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        b.c("MobclickAgent", i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        b.a("MobclickAgent", i + ":\tFailed to get message." + paramString);
        return null;
      }
      catch (Exception localException)
      {
        b.c("MobclickAgent", i + ":\tIOException,Failed to send message." + paramString, localException);
        return null;
      }
    }
    return null;
  }
  
  protected static String a(String paramString1, String paramString2)
  {
    int i = new Random().nextInt(1000);
    String str1 = System.getProperty("line.separator");
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    b.a("MobclickAgent", i + ": POST_URL: " + paramString1);
    String str2;
    for (;;)
    {
      InputStream localInputStream;
      try
      {
        HttpPost localHttpPost = new HttpPost(paramString1);
        if (!TextUtils.isEmpty(paramString2))
        {
          b.a("MobclickAgent", i + ": POST_BODY: " + paramString2);
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(new BasicNameValuePair("data", paramString2));
          localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        }
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          if (localHttpEntity == null) {
            break;
          }
          localInputStream = localHttpEntity.getContent();
          Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader != null) && (localHeader.getValue().equalsIgnoreCase("deflate")))
          {
            localObject = new InflaterInputStream(localInputStream);
            str2 = a((InputStream)localObject);
            b.a("MobclickAgent", i + ":\tresponse: " + str1 + str2);
            if (str2 != null) {
              break label421;
            }
            return null;
          }
        }
        else
        {
          b.c("MobclickAgent", i + ":\tFailed to send message." + paramString1);
          return null;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        b.c("MobclickAgent", i + ":\tClientProtocolException,Failed to send message." + paramString1, localClientProtocolException);
        return null;
      }
      catch (IOException localIOException)
      {
        b.c("MobclickAgent", i + ":\tIOException,Failed to send message." + paramString1, localIOException);
        return null;
      }
      Object localObject = localInputStream;
    }
    return null;
    label421:
    return str2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */