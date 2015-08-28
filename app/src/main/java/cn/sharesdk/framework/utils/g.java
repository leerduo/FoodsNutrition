package cn.sharesdk.framework.utils;

import android.util.Base64;
import cn.sharesdk.framework.network.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class g
{
  private g.b a = new g.b();
  private h b = new h("-._~", false);
  
  private ArrayList<f<String>> a(long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new f("oauth_consumer_key", this.a.a));
    localArrayList.add(new f("oauth_signature_method", paramString));
    localArrayList.add(new f("oauth_timestamp", String.valueOf(paramLong / 1000L)));
    localArrayList.add(new f("oauth_nonce", String.valueOf(paramLong)));
    localArrayList.add(new f("oauth_version", "1.0"));
    String str = this.a.c;
    if ((str != null) && (str.length() > 0)) {
      localArrayList.add(new f("oauth_token", str));
    }
    return localArrayList;
  }
  
  private ArrayList<f<String>> a(long paramLong, ArrayList<f<String>> paramArrayList, String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      Iterator localIterator3 = paramArrayList.iterator();
      while (localIterator3.hasNext())
      {
        f localf2 = (f)localIterator3.next();
        localHashMap.put(a(localf2.a), a((String)localf2.b));
      }
    }
    ArrayList localArrayList1 = a(paramLong, paramString);
    if (localArrayList1 != null)
    {
      Iterator localIterator2 = localArrayList1.iterator();
      while (localIterator2.hasNext())
      {
        f localf1 = (f)localIterator2.next();
        localHashMap.put(a(localf1.a), a((String)localf1.b));
      }
    }
    String[] arrayOfString = new String[localHashMap.size()];
    Iterator localIterator1 = localHashMap.entrySet().iterator();
    for (int j = 0; localIterator1.hasNext(); j++) {
      arrayOfString[j] = ((String)((Map.Entry)localIterator1.next()).getKey());
    }
    Arrays.sort(arrayOfString);
    ArrayList localArrayList2 = new ArrayList();
    int k = arrayOfString.length;
    while (i < k)
    {
      String str = arrayOfString[i];
      localArrayList2.add(new f(str, localHashMap.get(str)));
      i++;
    }
    return localArrayList2;
  }
  
  private ArrayList<f<String>> a(String paramString1, String paramString2, ArrayList<f<String>> paramArrayList, g.a parama)
  {
    String str1 = null;
    long l = System.currentTimeMillis();
    Object localObject;
    switch (g.1.a[parama.ordinal()])
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      ArrayList localArrayList = a(l, str1);
      localArrayList.add(new f("oauth_signature", localObject));
      return localArrayList;
      str1 = "HMAC-SHA1";
      SecretKeySpec localSecretKeySpec = new SecretKeySpec((a(this.a.b) + '&' + a(this.a.d)).getBytes("utf-8"), "HMAC-SHA1");
      Mac localMac = Mac.getInstance("HMAC-SHA1");
      localMac.init(localSecretKeySpec);
      String str2 = b(a(l, paramArrayList, str1));
      localObject = new String(Base64.encode(localMac.doFinal((paramString2 + '&' + a(paramString1.toLowerCase()) + '&' + a(str2)).getBytes("utf-8")), 0)).trim();
      continue;
      str1 = "PLAINTEXT";
      localObject = a(this.a.b) + '&' + a(this.a.d);
    }
  }
  
  private String b(ArrayList<f<String>> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      f localf = (f)localIterator.next();
      if (i > 0) {
        localStringBuilder.append('&');
      }
      localStringBuilder.append(localf.a).append('=').append((String)localf.b);
    }
    return localStringBuilder.toString();
  }
  
  public g.b a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return this.b.escape(paramString);
  }
  
  public ArrayList<f<String>> a(String paramString, ArrayList<f<String>> paramArrayList)
  {
    return a(paramString, paramArrayList, g.a.a);
  }
  
  public ArrayList<f<String>> a(String paramString, ArrayList<f<String>> paramArrayList, g.a parama)
  {
    return a(paramString, "POST", paramArrayList, parama);
  }
  
  public ArrayList<f<String>> a(ArrayList<f<String>> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder("OAuth ");
    Iterator localIterator = paramArrayList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      f localf = (f)localIterator.next();
      if (i > 0) {
        localStringBuilder.append(',');
      }
      String str = a((String)localf.b);
      localStringBuilder.append(localf.a).append("=\"").append(str).append("\"");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new f("Authorization", localStringBuilder.toString()));
    localArrayList.add(new f("Content-Type", "application/x-www-form-urlencoded"));
    return localArrayList;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.c = paramString1;
    this.a.d = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.a = paramString1;
    this.a.b = paramString2;
    this.a.e = paramString3;
  }
  
  public ArrayList<f<String>> b(String paramString, ArrayList<f<String>> paramArrayList)
  {
    return b(paramString, paramArrayList, g.a.a);
  }
  
  public ArrayList<f<String>> b(String paramString, ArrayList<f<String>> paramArrayList, g.a parama)
  {
    return a(paramString, "GET", paramArrayList, parama);
  }
  
  public ArrayList<f<String>> c(String paramString, ArrayList<f<String>> paramArrayList, g.a parama)
  {
    return a(paramString, "PUT", paramArrayList, parama);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */