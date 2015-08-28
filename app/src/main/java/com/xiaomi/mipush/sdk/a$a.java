package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.push.service.g;

class a$a
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public boolean h = true;
  public boolean i = false;
  public int j = 1;
  
  private a$a(a parama) {}
  
  private String d()
  {
    return a.a(a.a(this.k), a.a(this.k).getPackageName());
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.f = g.e(a.a(this.k));
    this.e = d();
    this.h = true;
    SharedPreferences.Editor localEditor = this.k.j().edit();
    localEditor.putString("regId", paramString1);
    localEditor.putString("regSec", paramString2);
    localEditor.putString("devId", this.f);
    localEditor.putString("vName", d());
    localEditor.putBoolean("valid", true);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.g = paramString3;
    SharedPreferences.Editor localEditor = this.k.j().edit();
    localEditor.putString("appId", this.a);
    localEditor.putString("appToken", paramString2);
    localEditor.putString("regResource", paramString3);
    localEditor.commit();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean a()
  {
    return b(this.a, this.b);
  }
  
  public void b()
  {
    this.k.j().edit().clear().commit();
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.f = null;
    this.e = null;
    this.h = false;
    this.i = false;
    this.j = 1;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return (TextUtils.equals(this.a, paramString1)) && (TextUtils.equals(this.b, paramString2)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)) && (TextUtils.equals(this.f, g.e(a.a(this.k))));
  }
  
  public void c()
  {
    this.h = false;
    this.k.j().edit().putBoolean("valid", this.h).commit();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.a.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */