package com.umeng.update.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import u.upd.b;

public class e
{
  private static final String a = "UMENG_RUNTIME_CACHE";
  private static final String b = e.class.getName();
  private final Context c;
  
  public e(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public List<Integer> a()
  {
    localArrayList = new ArrayList();
    try
    {
      SharedPreferences localSharedPreferences = this.c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
      Iterator localIterator = localSharedPreferences.getAll().keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          localSharedPreferences.edit().clear().commit();
          return localArrayList;
        }
        String str = (String)localIterator.next();
        try
        {
          int i = Integer.parseInt(str);
          localArrayList.add(Integer.valueOf(i));
          b.a(b, "get nid [" + i + "]");
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
      return localArrayList;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt)
  {
    try
    {
      SharedPreferences localSharedPreferences = this.c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      try
      {
        localEditor.putString(paramInt, "");
        localEditor.commit();
        b.a(b, "add nid [" + paramInt + "] to runtime cache.");
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(int paramInt)
  {
    try
    {
      SharedPreferences localSharedPreferences = this.c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
      if (localSharedPreferences.contains(paramInt))
      {
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localEditor.remove(paramInt);
        localEditor.commit();
      }
      b.a(b, "remove nid [" + paramInt + "] to runtime cache.");
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean b()
  {
    int i = this.c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0).getAll().size();
    boolean bool = false;
    if (i > 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */