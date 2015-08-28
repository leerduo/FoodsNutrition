package u.aly;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
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
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class bo
{
  private static final String a = bo.class.getName();
  private Map<String, String> b;
  
  private static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {}
        try
        {
          paramInputStream.close();
          return localStringBuilder.toString();
        }
        catch (IOException localIOException4)
        {
          bj.b(a, "Caught IOException in convertStreamToString()", localIOException4);
        }
        localStringBuilder.append(str + "\n");
      }
      return null;
    }
    catch (IOException localIOException2)
    {
      bj.b(a, "Caught IOException in convertStreamToString()", localIOException2);
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (IOException localIOException3)
      {
        bj.b(a, "Caught IOException in convertStreamToString()", localIOException3);
        return null;
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
        bj.b(a, "Caught IOException in convertStreamToString()", localIOException1);
        return null;
      }
    }
  }
  
  private JSONObject a(String paramString)
  {
    int i = new Random().nextInt(1000);
    for (;;)
    {
      HttpResponse localHttpResponse;
      InputStream localInputStream;
      try
      {
        String str1 = System.getProperty("line.separator");
        if (paramString.length() <= 1)
        {
          bj.b(a, i + ":\tInvalid baseUrl.");
          return null;
        }
        bj.a(a, i + ":\tget: " + paramString);
        HttpGet localHttpGet = new HttpGet(paramString);
        Iterator localIterator;
        Header localHeader;
        String str2;
        if ((this.b != null) && (this.b.size() > 0))
        {
          localIterator = this.b.keySet().iterator();
          if (localIterator.hasNext()) {}
        }
        else
        {
          localHttpResponse = new DefaultHttpClient(b()).execute(localHttpGet);
          if (localHttpResponse.getStatusLine().getStatusCode() != 200) {
            break label490;
          }
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          if (localHttpEntity == null) {
            break label540;
          }
          localInputStream = localHttpEntity.getContent();
          localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("gzip"))) {
            continue;
          }
          bj.a(a, i + "  Use GZIPInputStream get data....");
          localObject = new GZIPInputStream(localInputStream);
          str2 = a((InputStream)localObject);
          bj.a(a, i + ":\tresponse: " + str1 + str2);
          if (str2 != null) {
            break label480;
          }
          return null;
        }
        String str3 = (String)localIterator.next();
        localHttpGet.addHeader(str3, (String)this.b.get(str3));
        continue;
        return new JSONObject(str2);
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        bj.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate"))) {
          break label542;
        }
        bj.a(a, i + "  Use InflaterInputStream get data....");
        localObject = new InflaterInputStream(localInputStream);
        continue;
      }
      catch (Exception localException)
      {
        bj.c(a, i + ":\tIOException,Failed to send message." + paramString, localException);
        return null;
      }
      label480:
      label490:
      bj.c(a, i + ":\tFailed to send message. StatusCode = " + localHttpResponse.getStatusLine().getStatusCode() + bv.a + paramString);
      label540:
      return null;
      label542:
      Object localObject = localInputStream;
    }
  }
  
  private JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.toString();
    int i = new Random().nextInt(1000);
    bj.c(a, i + ":\trequest: " + paramString + bv.a + str1);
    HttpPost localHttpPost = new HttpPost(paramString);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(b());
    label516:
    for (;;)
    {
      try
      {
        HttpResponse localHttpResponse;
        InputStream localInputStream;
        String str2;
        if (a())
        {
          byte[] arrayOfByte = bu.a("content=" + str1, Charset.defaultCharset().toString());
          localHttpPost.addHeader("Content-Encoding", "deflate");
          localHttpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(arrayOfByte), arrayOfByte.length));
          localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
          if (localHttpResponse.getStatusLine().getStatusCode() != 200) {
            continue;
          }
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          if (localHttpEntity == null) {
            break;
          }
          localInputStream = localHttpEntity.getContent();
          Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate"))) {
            break label516;
          }
          localObject = new InflaterInputStream(localInputStream);
          str2 = a((InputStream)localObject);
          bj.a(a, i + ":\tresponse: " + bv.a + str2);
          if (str2 == null) {
            return null;
          }
        }
        else
        {
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(new BasicNameValuePair("content", str1));
          localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
          continue;
        }
        Object localObject = localInputStream;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        bj.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        return new JSONObject(str2);
        bj.c(a, i + ":\tFailed to send message. StatusCode = " + localHttpResponse.getStatusLine().getStatusCode() + bv.a + paramString);
        return null;
      }
      catch (IOException localIOException)
      {
        bj.c(a, i + ":\tIOException,Failed to send message." + paramString, localIOException);
        return null;
      }
      catch (JSONException localJSONException)
      {
        bj.c(a, i + ":\tIOException,Failed to send message." + paramString, localJSONException);
        return null;
      }
    }
    return null;
  }
  
  private HttpParams b()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, System.getProperty("http.agent"));
    return localBasicHttpParams;
  }
  
  private void b(String paramString)
  {
    if ((bv.c(paramString)) || (!(bp.c.equals(paramString.trim()) ^ bp.b.equals(paramString.trim())))) {
      throw new RuntimeException("验证请求方式失败[" + paramString + "]");
    }
  }
  
  public bo a(Map<String, String> paramMap)
  {
    this.b = paramMap;
    return this;
  }
  
  public <T extends bq> T a(bp parambp, Class<T> paramClass)
  {
    String str = parambp.c().trim();
    b(str);
    JSONObject localJSONObject;
    if (bp.c.equals(str)) {
      localJSONObject = a(parambp.b());
    }
    for (;;)
    {
      if (localJSONObject == null)
      {
        return null;
        if (bp.b.equals(str)) {
          localJSONObject = a(parambp.d, parambp.a());
        }
      }
      else
      {
        try
        {
          bq localbq = (bq)paramClass.getConstructor(new Class[] { JSONObject.class }).newInstance(new Object[] { localJSONObject });
          return localbq;
        }
        catch (SecurityException localSecurityException)
        {
          bj.b(a, "SecurityException", localSecurityException);
          return null;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          for (;;)
          {
            bj.b(a, "NoSuchMethodException", localNoSuchMethodException);
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            bj.b(a, "IllegalArgumentException", localIllegalArgumentException);
          }
        }
        catch (InstantiationException localInstantiationException)
        {
          for (;;)
          {
            bj.b(a, "InstantiationException", localInstantiationException);
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            bj.b(a, "IllegalAccessException", localIllegalAccessException);
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            bj.b(a, "InvocationTargetException", localInvocationTargetException);
          }
        }
        localJSONObject = null;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */