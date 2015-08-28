package com.umeng.update.net;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;

public class a
{
  private static final String b = a.class.getName();
  final Messenger a = new Messenger(new a.b(this));
  private Context c;
  private d d;
  private Messenger e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String[] k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private ServiceConnection o = new a.1(this);
  
  public a(Context paramContext, String paramString1, String paramString2, String paramString3, d paramd)
  {
    this.c = paramContext.getApplicationContext();
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.d = paramd;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.c, DownloadingService.class);
    this.c.bindService(localIntent, this.o, 1);
    this.c.startService(new Intent(this.c, DownloadingService.class));
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.k = paramArrayOfString;
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */