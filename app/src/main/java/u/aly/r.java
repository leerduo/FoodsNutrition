package u.aly;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class r
{
  private final int a = 1;
  private String b;
  private String c = "10.0.0.172";
  private int d = 80;
  private Context e;
  private w f;
  private f g;
  
  public r(Context paramContext)
  {
    this.e = paramContext;
    this.g = h.b(paramContext);
    this.b = a(paramContext);
  }
  
  private String a(Context paramContext)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("Android");
    localStringBuffer1.append("/");
    localStringBuffer1.append("5.2.4");
    localStringBuffer1.append(" ");
    try
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(bi.p(paramContext));
      localStringBuffer2.append("/");
      localStringBuffer2.append(bi.b(paramContext));
      localStringBuffer2.append(" ");
      localStringBuffer2.append(Build.MODEL);
      localStringBuffer2.append("/");
      localStringBuffer2.append(Build.VERSION.RELEASE);
      localStringBuffer2.append(" ");
      localStringBuffer2.append(bv.a(AnalyticsConfig.getAppkey(paramContext)));
      localStringBuffer1.append(URLEncoder.encode(localStringBuffer2.toString(), "UTF-8"));
      return localStringBuffer1.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean a()
  {
    if (this.e.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.e.getPackageName()) != 0) {
      return false;
    }
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.e.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1))
      {
        String str = localNetworkInfo.getExtraInfo();
        if (str != null) {
          if ((!str.equals("cmwap")) && (!str.equals("3gwap")))
          {
            boolean bool = str.equals("uniwap");
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    localHttpPost.addHeader("X-Umeng-Sdk", this.b);
    localHttpPost.addHeader("Msg-Type", "envelope");
    try
    {
      if (a())
      {
        HttpHost localHttpHost = new HttpHost(this.c, this.d);
        localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
      }
      localHttpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length));
      if (this.f != null) {
        this.f.d();
      }
      HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
      if (this.f != null) {
        this.f.e();
      }
      int i = localHttpResponse.getStatusLine().getStatusCode();
      bj.a("MobclickAgent", "status code : " + i);
      if (localHttpResponse.getStatusLine().getStatusCode() == 200)
      {
        bj.a("MobclickAgent", "Sent message to " + paramString);
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity != null)
        {
          InputStream localInputStream = localHttpEntity.getContent();
          try
          {
            byte[] arrayOfByte = bv.b(localInputStream);
            return arrayOfByte;
          }
          finally
          {
            bv.c(localInputStream);
          }
        }
      }
      return null;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      bj.b("MobclickAgent", "ClientProtocolException,Failed to send message.", localClientProtocolException);
      return null;
      return null;
      return null;
    }
    catch (IOException localIOException)
    {
      bj.b("MobclickAgent", "IOException,Failed to send message.", localIOException);
    }
  }
  
  private int b(byte[] paramArrayOfByte)
  {
    bb localbb = new bb();
    cc localcc = new cc(new cr.a());
    try
    {
      localcc.a(localbb, paramArrayOfByte);
      if (localbb.a == 1)
      {
        this.g.b(localbb.d());
        this.g.c();
      }
      bj.a("MobclickAgent", "send log:" + localbb.b());
      if (localbb.a == 1) {
        return 2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return 3;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = null;
    for (int i = 0;; i++)
    {
      if (i < a.f.length)
      {
        arrayOfByte = a(paramArrayOfByte, a.f[i]);
        if (arrayOfByte == null) {
          break label47;
        }
        if (this.f != null) {
          this.f.b();
        }
      }
      if (arrayOfByte != null) {
        break;
      }
      return 1;
      label47:
      if (this.f != null) {
        this.f.c();
      }
    }
    return b(arrayOfByte);
  }
  
  public void a(w paramw)
  {
    this.f = paramw;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.r
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */