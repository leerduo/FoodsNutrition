package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private List<a> f = null;
  
  public h(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<a> paramList)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.d = paramString2;
    this.c = paramString3;
    this.e = paramString4;
    this.f = paramList;
  }
  
  public h(Bundle paramBundle)
  {
    this.a = paramBundle.getInt("ext_err_code");
    if (paramBundle.containsKey("ext_err_type")) {
      this.b = paramBundle.getString("ext_err_type");
    }
    this.c = paramBundle.getString("ext_err_cond");
    this.d = paramBundle.getString("ext_err_reason");
    this.e = paramBundle.getString("ext_err_msg");
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("ext_exts");
    if (arrayOfParcelable != null)
    {
      this.f = new ArrayList(arrayOfParcelable.length);
      int i = arrayOfParcelable.length;
      for (int j = 0; j < i; j++)
      {
        a locala = a.a((Bundle)arrayOfParcelable[j]);
        if (locala != null) {
          this.f.add(locala);
        }
      }
    }
  }
  
  public h(h.a parama)
  {
    a(parama);
    this.e = null;
  }
  
  public h(h.a parama, String paramString)
  {
    a(parama);
    this.e = paramString;
  }
  
  private void a(h.a parama)
  {
    this.c = h.a.a(parama);
  }
  
  public String a()
  {
    return this.d;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Bundle c()
  {
    Bundle localBundle1 = new Bundle();
    if (this.b != null) {
      localBundle1.putString("ext_err_type", this.b);
    }
    localBundle1.putInt("ext_err_code", this.a);
    if (this.d != null) {
      localBundle1.putString("ext_err_reason", this.d);
    }
    if (this.c != null) {
      localBundle1.putString("ext_err_cond", this.c);
    }
    if (this.e != null) {
      localBundle1.putString("ext_err_msg", this.e);
    }
    Bundle[] arrayOfBundle;
    int i;
    int j;
    if (this.f != null)
    {
      arrayOfBundle = new Bundle[this.f.size()];
      Iterator localIterator = this.f.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Bundle localBundle2 = ((a)localIterator.next()).e();
        if (localBundle2 == null) {
          break label175;
        }
        j = i + 1;
        arrayOfBundle[i] = localBundle2;
      }
    }
    for (;;)
    {
      i = j;
      break;
      localBundle1.putParcelableArray("ext_exts", arrayOfBundle);
      return localBundle1;
      label175:
      j = i;
    }
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<error code=\"").append(this.a).append("\"");
    if (this.b != null)
    {
      localStringBuilder.append(" type=\"");
      localStringBuilder.append(this.b);
      localStringBuilder.append("\"");
    }
    if (this.d != null)
    {
      localStringBuilder.append(" reason=\"");
      localStringBuilder.append(this.d);
      localStringBuilder.append("\"");
    }
    localStringBuilder.append(">");
    if (this.c != null)
    {
      localStringBuilder.append("<").append(this.c);
      localStringBuilder.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
    }
    if (this.e != null)
    {
      localStringBuilder.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
      localStringBuilder.append(this.e);
      localStringBuilder.append("</text>");
    }
    Iterator localIterator = e().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((a)localIterator.next()).d());
    }
    localStringBuilder.append("</error>");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public List<a> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/xiaomi/smack/packet/h:f	Ljava/util/List;
    //   6: ifnonnull +15 -> 21
    //   9: invokestatic 167	java/util/Collections:emptyList	()Ljava/util/List;
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_3
    //   20: areturn
    //   21: aload_0
    //   22: getfield 21	com/xiaomi/smack/packet/h:f	Ljava/util/List;
    //   25: invokestatic 171	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   28: astore_2
    //   29: aload_2
    //   30: astore_3
    //   31: goto -14 -> 17
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	h
    //   34	4	1	localObject1	Object
    //   28	2	2	localList1	List
    //   16	15	3	localObject2	Object
    //   12	3	4	localList2	List
    // Exception table:
    //   from	to	target	type
    //   2	14	34	finally
    //   21	29	34	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.c != null) {
      localStringBuilder.append(this.c);
    }
    localStringBuilder.append("(").append(this.a).append(")");
    if (this.e != null) {
      localStringBuilder.append(" ").append(this.e);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.packet.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */