package com.xiaomi.network;

import android.content.Context;
import android.util.Log;
import com.xiaomi.common.logger.thrift.a;
import com.xiaomi.common.logger.thrift.mfs.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
import org.apache.thrift.f;
import org.apache.thrift.protocol.b.a;

public class UploadHostStatHelper
{
  private static UploadHostStatHelper e;
  private List<UploadHostStatHelper.HttpRecordCallback> a = new ArrayList();
  private final Random b = new Random();
  private Timer c = new Timer("Upload Http Record Timer");
  private boolean d = false;
  private Context f = null;
  
  private UploadHostStatHelper(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
  }
  
  public static UploadHostStatHelper a()
  {
    try
    {
      UploadHostStatHelper localUploadHostStatHelper = e;
      return localUploadHostStatHelper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(b(paramString));
      String str = String.format("%1$032X", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new UploadHostStatHelper(paramContext);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = String.valueOf(System.nanoTime());
    String str2 = String.valueOf(System.currentTimeMillis());
    localArrayList.add(new BasicNameValuePair("n", str1));
    localArrayList.add(new BasicNameValuePair("d", paramString2));
    localArrayList.add(new BasicNameValuePair("t", str2));
    localArrayList.add(new BasicNameValuePair("s", a(str1 + paramString2 + str2 + "56C6A520%$C99119A0&^229(!@2746C7")));
    String str3 = String.format("http://%1$s/diagnoses/v1/report", new Object[] { paramString1 });
    Network.a(this.f, str3, localArrayList);
  }
  
  private void a(List<b> paramList, double paramDouble)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      com.xiaomi.common.logger.thrift.mfs.c localc = new com.xiaomi.common.logger.thrift.mfs.c();
      localc.a("httpapi");
      localc.a(localb);
      localc.a(new a());
      String str = new String(Base64Coder.a(new f(new b.a()).a(localc)));
      if (this.b.nextInt(10000) < 10000.0D * paramDouble) {
        try
        {
          a("f3.mi-stat.gslb.mi-idc.com", str);
        }
        catch (IOException localIOException)
        {
          Log.e("uploadhoststat", null, localIOException);
        }
        catch (Exception localException)
        {
          Log.e("uploadhoststat", null, localException);
        }
      }
    }
  }
  
  private byte[] b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString.getBytes();
  }
  
  public void a(UploadHostStatHelper.HttpRecordCallback paramHttpRecordCallback)
  {
    this.a.add(paramHttpRecordCallback);
  }
  
  public void b()
  {
    if (!this.d)
    {
      this.d = true;
      this.c.schedule(new c(this), 60000L);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.UploadHostStatHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */