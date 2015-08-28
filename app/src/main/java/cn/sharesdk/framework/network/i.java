package cn.sharesdk.framework.network;

import android.content.Context;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class i
{
  public static int a;
  public static int b;
  
  private String a(ArrayList<f<String>> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      String str1 = a.c(localf.a, "utf-8");
      if (localf.b != null) {}
      for (String str2 = a.c((String)localf.b, "utf-8");; str2 = "")
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append(str1).append('=').append(str2);
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  private HttpClient a()
  {
    KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    localKeyStore.load(null, null);
    l locall = new l(localKeyStore);
    locall.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", locall, 443));
    return new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }
  
  private HttpPost a(String paramString, ArrayList<f<String>> paramArrayList)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    if (paramArrayList != null)
    {
      n localn = new n();
      localn.a(a(paramArrayList));
      InputStreamEntity localInputStreamEntity = localn.c();
      localInputStreamEntity.setContentType("application/x-www-form-urlencoded");
      localHttpPost.setEntity(localInputStreamEntity);
    }
    return localHttpPost;
  }
  
  private HttpPost a(String paramString, ArrayList<f<String>> paramArrayList1, ArrayList<f<String>> paramArrayList2)
  {
    String str1 = UUID.randomUUID().toString();
    HttpPost localHttpPost = new HttpPost(paramString);
    localHttpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + str1);
    g localg = new g();
    n localn1 = new n();
    if (paramArrayList1 != null)
    {
      Iterator localIterator2 = paramArrayList1.iterator();
      while (localIterator2.hasNext())
      {
        f localf2 = (f)localIterator2.next();
        localn1.a("--").a(str1).a("\r\n");
        localn1.a("Content-Disposition: form-data; name=\"").a(localf2.a).a("\"\r\n\r\n");
        localn1.a((String)localf2.b).a("\r\n");
      }
    }
    localg.a(localn1);
    Iterator localIterator1 = paramArrayList2.iterator();
    if (localIterator1.hasNext())
    {
      f localf1 = (f)localIterator1.next();
      n localn3 = new n();
      File localFile = new File((String)localf1.b);
      localn3.a("--").a(str1).a("\r\n");
      localn3.a("Content-Disposition: form-data; name=\"").a(localf1.a).a("\"; filename=\"").a(localFile.getName()).a("\"\r\n");
      String str2 = URLConnection.getFileNameMap().getContentTypeFor((String)localf1.b);
      if ((str2 == null) || (str2.length() <= 0))
      {
        if ((!((String)localf1.b).toLowerCase().endsWith("jpg")) && (!((String)localf1.b).toLowerCase().endsWith("jpeg"))) {
          break label427;
        }
        str2 = "image/jpeg";
      }
      for (;;)
      {
        localn3.a("Content-Type: ").a(str2).a("\r\n\r\n");
        localg.a(localn3);
        d locald = new d();
        locald.a((String)localf1.b);
        localg.a(locald);
        n localn4 = new n();
        localn4.a("\r\n");
        localg.a(localn4);
        break;
        label427:
        if (((String)localf1.b).toLowerCase().endsWith("png"))
        {
          str2 = "image/png";
        }
        else if (((String)localf1.b).toLowerCase().endsWith("gif"))
        {
          str2 = "image/gif";
        }
        else
        {
          FileInputStream localFileInputStream = new FileInputStream((String)localf1.b);
          str2 = URLConnection.guessContentTypeFromStream(localFileInputStream);
          localFileInputStream.close();
          if ((str2 == null) || (str2.length() <= 0)) {
            str2 = "application/octet-stream";
          }
        }
      }
    }
    n localn2 = new n();
    localn2.a("--").a(str1).a("--\r\n");
    localg.a(localn2);
    localHttpPost.setEntity(localg.c());
    return localHttpPost;
  }
  
  public String a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    cn.sharesdk.framework.utils.e.b("downloading: " + paramString1, new Object[0]);
    if (paramBoolean)
    {
      File localFile1 = new File(R.getCachePath(paramContext, paramString2), a.b(paramString1));
      if ((paramBoolean) && (localFile1.exists()))
      {
        cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return localFile1.getAbsolutePath();
      }
    }
    HttpGet localHttpGet = new HttpGet(paramString1);
    if (paramString1.startsWith("https://")) {}
    HttpResponse localHttpResponse;
    int i;
    Object localObject2;
    for (Object localObject1 = a();; localObject1 = new DefaultHttpClient())
    {
      localHttpResponse = ((HttpClient)localObject1).execute(localHttpGet);
      i = localHttpResponse.getStatusLine().getStatusCode();
      if (i != 200) {
        break label800;
      }
      Header[] arrayOfHeader1 = localHttpResponse.getHeaders("Content-Disposition");
      localObject2 = null;
      if (arrayOfHeader1 == null) {
        break;
      }
      int n = arrayOfHeader1.length;
      localObject2 = null;
      if (n <= 0) {
        break;
      }
      for (String str6 : arrayOfHeader1[0].getValue().split(";")) {
        if (str6.trim().startsWith("filename"))
        {
          localObject2 = str6.split("=")[1];
          if ((((String)localObject2).startsWith("\"")) && (((String)localObject2).endsWith("\""))) {
            localObject2 = ((String)localObject2).substring(1, -1 + ((String)localObject2).length());
          }
        }
      }
    }
    String str2;
    if (localObject2 == null)
    {
      str2 = a.b(paramString1);
      Header[] arrayOfHeader2 = localHttpResponse.getHeaders("Content-Type");
      if ((arrayOfHeader2 == null) || (arrayOfHeader2.length <= 0)) {
        break label880;
      }
      String str3 = arrayOfHeader2[0].getValue().trim();
      if (!str3.startsWith("image/")) {
        break label517;
      }
      String str5 = str3.substring("image/".length());
      StringBuilder localStringBuilder = new StringBuilder().append(str2).append(".");
      if ("jpeg".equals(str5)) {
        str5 = "jpg";
      }
      localObject2 = str5;
    }
    for (;;)
    {
      File localFile2 = new File(R.getCachePath(paramContext, paramString2), (String)localObject2);
      if ((paramBoolean) && (localFile2.exists()))
      {
        ((HttpClient)localObject1).getConnectionManager().shutdown();
        cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return localFile2.getAbsolutePath();
        label517:
        int k = paramString1.lastIndexOf('/');
        String str4 = null;
        if (k > 0) {
          str4 = paramString1.substring(k + 1);
        }
        if ((str4 != null) && (str4.length() > 0))
        {
          int m = str4.lastIndexOf('.');
          if ((m > 0) && (str4.length() - m < 10)) {
            localObject2 = str2 + str4.substring(m);
          }
        }
      }
      else
      {
        if (!localFile2.getParentFile().exists()) {
          localFile2.getParentFile().mkdirs();
        }
        if (localFile2.exists()) {
          localFile2.delete();
        }
        try
        {
          InputStream localInputStream = localHttpResponse.getEntity().getContent();
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
          byte[] arrayOfByte = new byte[1024];
          for (int j = localInputStream.read(arrayOfByte); j > 0; j = localInputStream.read(arrayOfByte)) {
            localFileOutputStream.write(arrayOfByte, 0, j);
          }
          localFileOutputStream.flush();
          localInputStream.close();
          localFileOutputStream.close();
          ((HttpClient)localObject1).getConnectionManager().shutdown();
          cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
          return localFile2.getAbsolutePath();
        }
        catch (Throwable localThrowable)
        {
          if (localFile2.exists()) {
            localFile2.delete();
          }
          throw localThrowable;
        }
        label800:
        String str1 = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
        HashMap localHashMap = new HashMap();
        localHashMap.put("error", str1);
        localHashMap.put("status", Integer.valueOf(i));
        ((HttpClient)localObject1).getConnectionManager().shutdown();
        throw new Throwable(new cn.sharesdk.framework.utils.d().a(localHashMap));
        label880:
        localObject2 = str2;
      }
    }
  }
  
  public String a(String paramString, ArrayList<f<String>> paramArrayList1, f<String> paramf, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramf != null) && (paramf.b != null) && (new File((String)paramf.b).exists())) {
      localArrayList.add(paramf);
    }
    return a(paramString, paramArrayList1, localArrayList, paramArrayList2, paramArrayList);
  }
  
  public String a(String paramString, ArrayList<f<String>> paramArrayList1, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList)
  {
    long l = System.currentTimeMillis();
    cn.sharesdk.framework.utils.e.b("httpGet: " + paramString, new Object[0]);
    if (paramArrayList1 != null)
    {
      String str3 = a(paramArrayList1);
      if (str3.length() > 0) {
        paramString = paramString + "?" + str3;
      }
    }
    HttpGet localHttpGet = new HttpGet(paramString);
    if (paramArrayList2 != null)
    {
      Iterator localIterator2 = paramArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        f localf2 = (f)localIterator2.next();
        localHttpGet.setHeader(localf2.a, (String)localf2.b);
      }
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, a);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, b);
    Iterator localIterator1;
    if (paramArrayList != null) {
      localIterator1 = paramArrayList.iterator();
    }
    for (;;)
    {
      f localf1;
      if (localIterator1.hasNext()) {
        localf1 = (f)localIterator1.next();
      }
      try
      {
        int j = Integer.parseInt(String.valueOf(localf1.b));
        localBasicHttpParams.setIntParameter(localf1.a, j);
      }
      catch (Exception localException) {}
      localHttpGet.setParams(localBasicHttpParams);
      if (paramString.startsWith("https://")) {}
      HttpResponse localHttpResponse;
      int i;
      for (Object localObject = a();; localObject = new DefaultHttpClient())
      {
        localHttpResponse = ((HttpClient)localObject).execute(localHttpGet);
        i = localHttpResponse.getStatusLine().getStatusCode();
        if (i != 200) {
          break;
        }
        String str2 = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
        ((HttpClient)localObject).getConnectionManager().shutdown();
        cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return str2;
      }
      String str1 = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
      HashMap localHashMap = new HashMap();
      localHashMap.put("error", str1);
      localHashMap.put("status", Integer.valueOf(i));
      ((HttpClient)localObject).getConnectionManager().shutdown();
      throw new Throwable(new cn.sharesdk.framework.utils.d().a(localHashMap));
    }
  }
  
  public String a(String paramString, ArrayList<f<String>> paramArrayList1, ArrayList<f<String>> paramArrayList2, ArrayList<f<String>> paramArrayList3, ArrayList<f<?>> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    a(paramString, paramArrayList1, paramArrayList2, paramArrayList3, paramArrayList, new j(this, localHashMap));
    return (String)localHashMap.get("resp");
  }
  
  public void a(String paramString, ArrayList<f<String>> paramArrayList, e parame, RawNetworkCallback paramRawNetworkCallback)
  {
    long l = System.currentTimeMillis();
    cn.sharesdk.framework.utils.e.b("raw post: " + paramString, new Object[0]);
    HttpPost localHttpPost = new HttpPost(paramString);
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        localHttpPost.setHeader(localf.a, (String)localf.b);
      }
    }
    localHttpPost.setEntity(parame.c());
    if (paramString.startsWith("https://")) {}
    HttpResponse localHttpResponse;
    int i;
    for (Object localObject = a();; localObject = new DefaultHttpClient())
    {
      localHttpResponse = ((HttpClient)localObject).execute(localHttpPost);
      i = localHttpResponse.getStatusLine().getStatusCode();
      if (i != 200) {
        break;
      }
      cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      if (paramRawNetworkCallback != null) {
        paramRawNetworkCallback.onResponse(localHttpResponse.getEntity().getContent());
      }
      ((HttpClient)localObject).getConnectionManager().shutdown();
      return;
    }
    String str = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
    HashMap localHashMap = new HashMap();
    localHashMap.put("error", str);
    localHashMap.put("status", Integer.valueOf(i));
    ((HttpClient)localObject).getConnectionManager().shutdown();
    throw new Throwable(new cn.sharesdk.framework.utils.d().a(localHashMap));
  }
  
  public void a(String paramString, ArrayList<f<String>> paramArrayList1, ArrayList<f<String>> paramArrayList2, ArrayList<f<String>> paramArrayList3, ArrayList<f<?>> paramArrayList, HttpResponseCallback paramHttpResponseCallback)
  {
    long l = System.currentTimeMillis();
    cn.sharesdk.framework.utils.e.b("httpPost: " + paramString, new Object[0]);
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {}
    for (HttpPost localHttpPost = a(paramString, paramArrayList1, paramArrayList2); paramArrayList3 != null; localHttpPost = a(paramString, paramArrayList1))
    {
      Iterator localIterator2 = paramArrayList3.iterator();
      while (localIterator2.hasNext())
      {
        f localf2 = (f)localIterator2.next();
        localHttpPost.setHeader(localf2.a, (String)localf2.b);
      }
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, a);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, b);
    cn.sharesdk.framework.utils.e.b("before set SO_TIMEOUT :" + localBasicHttpParams.getIntParameter("http.socket.timeout", b), new Object[0]);
    cn.sharesdk.framework.utils.e.b("before set CONNECTION_TIMEOUT :" + localBasicHttpParams.getIntParameter("http.connection.timeout", a), new Object[0]);
    Iterator localIterator1;
    if (paramArrayList != null) {
      localIterator1 = paramArrayList.iterator();
    }
    Object localObject;
    for (;;)
    {
      f localf1;
      if (localIterator1.hasNext()) {
        localf1 = (f)localIterator1.next();
      }
      try
      {
        int i = Integer.parseInt(String.valueOf(localf1.b));
        localBasicHttpParams.setIntParameter(localf1.a, i);
      }
      catch (Exception localException) {}
      cn.sharesdk.framework.utils.e.b("before set SO_TIMEOUT :" + localBasicHttpParams.getIntParameter("http.socket.timeout", b), new Object[0]);
      cn.sharesdk.framework.utils.e.b("before set CONNECTION_TIMEOUT :" + localBasicHttpParams.getIntParameter("http.connection.timeout", a), new Object[0]);
      localHttpPost.setParams(localBasicHttpParams);
      if (paramString.startsWith("https://")) {}
      for (localObject = a();; localObject = new DefaultHttpClient())
      {
        HttpResponse localHttpResponse = ((HttpClient)localObject).execute(localHttpPost);
        if (paramHttpResponseCallback != null) {}
        try
        {
          paramHttpResponseCallback.onResponse(localHttpResponse);
          ((HttpClient)localObject).getConnectionManager().shutdown();
          cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
          return;
        }
        catch (Throwable localThrowable)
        {
          ((HttpClient)localObject).getConnectionManager().shutdown();
          throw localThrowable;
        }
      }
    }
  }
  
  public String b(String paramString, ArrayList<f<String>> paramArrayList1, f<String> paramf, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList)
  {
    long l = System.currentTimeMillis();
    cn.sharesdk.framework.utils.e.b("httpPut: " + paramString, new Object[0]);
    if (paramArrayList1 != null)
    {
      String str3 = a(paramArrayList1);
      if (str3.length() > 0) {
        paramString = paramString + "?" + str3;
      }
    }
    HttpPut localHttpPut = new HttpPut(paramString);
    if (paramArrayList2 != null)
    {
      Iterator localIterator2 = paramArrayList2.iterator();
      while (localIterator2.hasNext())
      {
        f localf2 = (f)localIterator2.next();
        localHttpPut.setHeader(localf2.a, (String)localf2.b);
      }
    }
    d locald = new d();
    locald.a((String)paramf.b);
    InputStreamEntity localInputStreamEntity = locald.c();
    localInputStreamEntity.setContentEncoding("application/octet-stream");
    localHttpPut.setEntity(localInputStreamEntity);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, a);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, b);
    Iterator localIterator1;
    if (paramArrayList != null) {
      localIterator1 = paramArrayList.iterator();
    }
    for (;;)
    {
      f localf1;
      if (localIterator1.hasNext()) {
        localf1 = (f)localIterator1.next();
      }
      try
      {
        int j = Integer.parseInt(String.valueOf(localf1.b));
        localBasicHttpParams.setIntParameter(localf1.a, j);
      }
      catch (Exception localException) {}
      localHttpPut.setParams(localBasicHttpParams);
      if (paramString.startsWith("https://")) {}
      HttpResponse localHttpResponse;
      int i;
      for (Object localObject = a();; localObject = new DefaultHttpClient())
      {
        localHttpResponse = ((HttpClient)localObject).execute(localHttpPut);
        i = localHttpResponse.getStatusLine().getStatusCode();
        if ((i != 200) && (i != 201)) {
          break;
        }
        String str1 = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
        ((HttpClient)localObject).getConnectionManager().shutdown();
        cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return str1;
      }
      String str2 = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
      HashMap localHashMap = new HashMap();
      localHashMap.put("error", str2);
      localHashMap.put("status", Integer.valueOf(i));
      ((HttpClient)localObject).getConnectionManager().shutdown();
      throw new Throwable(new cn.sharesdk.framework.utils.d().a(localHashMap));
    }
  }
  
  public String b(String paramString, ArrayList<f<String>> paramArrayList1, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList)
  {
    long l = System.currentTimeMillis();
    cn.sharesdk.framework.utils.e.b("jsonPost: " + paramString, new Object[0]);
    HttpPost localHttpPost = new HttpPost(paramString);
    n localn = new n();
    if (paramArrayList1 != null)
    {
      HashMap localHashMap1 = new HashMap();
      Iterator localIterator1 = paramArrayList1.iterator();
      while (localIterator1.hasNext())
      {
        f localf3 = (f)localIterator1.next();
        localHashMap1.put(localf3.a, localf3.b);
      }
      localn.a(new cn.sharesdk.framework.utils.d().a(localHashMap1));
    }
    InputStreamEntity localInputStreamEntity = localn.c();
    localInputStreamEntity.setContentType("application/json");
    localHttpPost.setEntity(localInputStreamEntity);
    if (paramArrayList2 != null)
    {
      Iterator localIterator3 = paramArrayList2.iterator();
      while (localIterator3.hasNext())
      {
        f localf2 = (f)localIterator3.next();
        localHttpPost.setHeader(localf2.a, (String)localf2.b);
      }
    }
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, a);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, b);
    Iterator localIterator2;
    if (paramArrayList != null) {
      localIterator2 = paramArrayList.iterator();
    }
    for (;;)
    {
      f localf1;
      if (localIterator2.hasNext()) {
        localf1 = (f)localIterator2.next();
      }
      try
      {
        int j = Integer.parseInt(String.valueOf(localf1.b));
        localBasicHttpParams.setIntParameter(localf1.a, j);
      }
      catch (Exception localException) {}
      localHttpPost.setParams(localBasicHttpParams);
      if (paramString.startsWith("https://")) {}
      HttpResponse localHttpResponse;
      int i;
      for (Object localObject = a();; localObject = new DefaultHttpClient())
      {
        localHttpResponse = ((HttpClient)localObject).execute(localHttpPost);
        i = localHttpResponse.getStatusLine().getStatusCode();
        if ((i != 200) && (i != 201)) {
          break;
        }
        String str1 = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
        ((HttpClient)localObject).getConnectionManager().shutdown();
        cn.sharesdk.framework.utils.e.b("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return str1;
      }
      String str2 = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("error", str2);
      localHashMap2.put("status", Integer.valueOf(i));
      ((HttpClient)localObject).getConnectionManager().shutdown();
      throw new Throwable(new cn.sharesdk.framework.utils.d().a(localHashMap2));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */