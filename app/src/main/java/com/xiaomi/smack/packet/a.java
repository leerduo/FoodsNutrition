package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smack.util.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a
  implements e
{
  private String a;
  private String b;
  private String[] c = null;
  private String[] d = null;
  private String e;
  private List<a> f = null;
  
  public a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
  }
  
  public a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString3, List<a> paramList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
    this.e = paramString3;
    this.f = paramList;
  }
  
  public static a a(Bundle paramBundle)
  {
    int i = 0;
    String str1 = paramBundle.getString("ext_ele_name");
    String str2 = paramBundle.getString("ext_ns");
    String str3 = paramBundle.getString("ext_text");
    Bundle localBundle = paramBundle.getBundle("attributes");
    Set localSet = localBundle.keySet();
    String[] arrayOfString1 = new String[localSet.size()];
    String[] arrayOfString2 = new String[localSet.size()];
    Iterator localIterator = localSet.iterator();
    for (int j = 0; localIterator.hasNext(); j++)
    {
      String str4 = (String)localIterator.next();
      arrayOfString1[j] = str4;
      arrayOfString2[j] = localBundle.getString(str4);
    }
    if (paramBundle.containsKey("children"))
    {
      Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("children");
      localArrayList = new ArrayList(arrayOfParcelable.length);
      int k = arrayOfParcelable.length;
      while (i < k)
      {
        localArrayList.add(a((Bundle)arrayOfParcelable[i]));
        i++;
      }
    }
    ArrayList localArrayList = null;
    return new a(str1, str2, arrayOfString1, arrayOfString2, str3, localArrayList);
  }
  
  public static Parcelable[] a(List<a> paramList)
  {
    return a((a[])paramList.toArray(new a[paramList.size()]));
  }
  
  public static Parcelable[] a(a[] paramArrayOfa)
  {
    if (paramArrayOfa == null) {
      return null;
    }
    Parcelable[] arrayOfParcelable = new Parcelable[paramArrayOfa.length];
    for (int i = 0; i < paramArrayOfa.length; i++) {
      arrayOfParcelable[i] = paramArrayOfa[i].f();
    }
    return arrayOfParcelable;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (this.c != null) {
      for (int i = 0; i < this.c.length; i++) {
        if (paramString.equals(this.c[i])) {
          return this.d[i];
        }
      }
    }
    return null;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.e = g.a(paramString);
      return;
    }
    this.e = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return g.b(this.e);
    }
    return this.e;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<").append(this.a);
    if (!TextUtils.isEmpty(this.b)) {
      localStringBuilder.append(" ").append("xmlns=").append("\"").append(this.b).append("\"");
    }
    if ((this.c != null) && (this.c.length > 0)) {
      for (int i = 0; i < this.c.length; i++) {
        if (!TextUtils.isEmpty(this.d[i])) {
          localStringBuilder.append(" ").append(this.c[i]).append("=\"").append(g.a(this.d[i])).append("\"");
        }
      }
    }
    if (!TextUtils.isEmpty(this.e)) {
      localStringBuilder.append(">").append(this.e).append("</").append(this.a).append(">");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if ((this.f != null) && (this.f.size() > 0))
      {
        localStringBuilder.append(">");
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((a)localIterator.next()).d());
        }
        localStringBuilder.append("</").append(this.a).append(">");
      }
      else
      {
        localStringBuilder.append("/>");
      }
    }
  }
  
  public Bundle e()
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("ext_ele_name", this.a);
    localBundle1.putString("ext_ns", this.b);
    localBundle1.putString("ext_text", this.e);
    Bundle localBundle2 = new Bundle();
    if ((this.c != null) && (this.c.length > 0)) {
      for (int i = 0; i < this.c.length; i++) {
        localBundle2.putString(this.c[i], this.d[i]);
      }
    }
    localBundle1.putBundle("attributes", localBundle2);
    if ((this.f != null) && (this.f.size() > 0)) {
      localBundle1.putParcelableArray("children", a(this.f));
    }
    return localBundle1;
  }
  
  public Parcelable f()
  {
    return e();
  }
  
  public String toString()
  {
    return d();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.packet.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */