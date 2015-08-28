package com.activeandroid.query;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.content.ContentProvider;
import com.activeandroid.util.Log;
import com.activeandroid.util.SQLiteUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class From
  implements Sqlable
{
  private Sqlable a;
  private Class<? extends Model> b;
  private String c;
  private List<Join> d;
  private final StringBuilder e = new StringBuilder();
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private List<Object> k;
  
  public From(Class<? extends Model> paramClass, Sqlable paramSqlable)
  {
    this.b = paramClass;
    this.d = new ArrayList();
    this.a = paramSqlable;
    this.d = new ArrayList();
    this.k = new ArrayList();
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("FROM ");
    paramStringBuilder.append(Cache.c(this.b)).append(" ");
    if (this.c != null)
    {
      paramStringBuilder.append("AS ");
      paramStringBuilder.append(this.c);
      paramStringBuilder.append(" ");
    }
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      paramStringBuilder.append(((Join)localIterator.next()).a());
    }
  }
  
  private void c(StringBuilder paramStringBuilder)
  {
    if (this.e.length() > 0)
    {
      paramStringBuilder.append("WHERE ");
      paramStringBuilder.append(this.e);
      paramStringBuilder.append(" ");
    }
  }
  
  private void d(StringBuilder paramStringBuilder)
  {
    if (this.f != null)
    {
      paramStringBuilder.append("GROUP BY ");
      paramStringBuilder.append(this.f);
      paramStringBuilder.append(" ");
    }
  }
  
  private void e(StringBuilder paramStringBuilder)
  {
    if (this.g != null)
    {
      paramStringBuilder.append("HAVING ");
      paramStringBuilder.append(this.g);
      paramStringBuilder.append(" ");
    }
  }
  
  private void f(StringBuilder paramStringBuilder)
  {
    if (this.h != null)
    {
      paramStringBuilder.append("ORDER BY ");
      paramStringBuilder.append(this.h);
      paramStringBuilder.append(" ");
    }
  }
  
  private void g(StringBuilder paramStringBuilder)
  {
    if (this.i != null)
    {
      paramStringBuilder.append("LIMIT ");
      paramStringBuilder.append(this.i);
      paramStringBuilder.append(" ");
    }
  }
  
  private void h(StringBuilder paramStringBuilder)
  {
    if (this.j != null)
    {
      paramStringBuilder.append("OFFSET ");
      paramStringBuilder.append(this.j);
      paramStringBuilder.append(" ");
    }
  }
  
  private String i(StringBuilder paramStringBuilder)
  {
    String str = paramStringBuilder.toString().trim();
    if (Log.a()) {
      Log.a(str + " " + TextUtils.join(",", d()));
    }
    return str;
  }
  
  public From a(int paramInt)
  {
    return c(String.valueOf(paramInt));
  }
  
  public From a(String paramString)
  {
    if (this.e.length() > 0) {
      this.e.append(" AND ");
    }
    this.e.append(paramString);
    return this;
  }
  
  public From a(String paramString, Object... paramVarArgs)
  {
    a(paramString).a(paramVarArgs);
    return this;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a());
    a(localStringBuilder);
    b(localStringBuilder);
    c(localStringBuilder);
    d(localStringBuilder);
    e(localStringBuilder);
    f(localStringBuilder);
    g(localStringBuilder);
    h(localStringBuilder);
    return i(localStringBuilder);
  }
  
  void a(Object[] paramArrayOfObject)
  {
    int m = paramArrayOfObject.length;
    int n = 0;
    if (n < m)
    {
      Object localObject = paramArrayOfObject[n];
      if ((localObject.getClass() == Boolean.TYPE) || (localObject.getClass() == Boolean.class)) {
        if (!localObject.equals(Boolean.valueOf(true))) {
          break label76;
        }
      }
      label76:
      for (int i1 = 1;; i1 = 0)
      {
        localObject = Integer.valueOf(i1);
        this.k.add(localObject);
        n++;
        break;
      }
    }
  }
  
  public From b(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public <T extends Model> List<T> b()
  {
    if ((this.a instanceof Select)) {
      return SQLiteUtils.a(this.b, a(), d());
    }
    SQLiteUtils.a(a(), d());
    Cache.d().getContentResolver().notifyChange(ContentProvider.a(this.b, null), null);
    return null;
  }
  
  public <T extends Model> T c()
  {
    if ((this.a instanceof Select))
    {
      a(1);
      return SQLiteUtils.b(this.b, a(), d());
    }
    a(1);
    SQLiteUtils.b(this.b, a(), d()).delete();
    return null;
  }
  
  public From c(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public String[] d()
  {
    int m = this.k.size();
    String[] arrayOfString = new String[m];
    for (int n = 0; n < m; n++) {
      arrayOfString[n] = this.k.get(n).toString();
    }
    return arrayOfString;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.query.From
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */