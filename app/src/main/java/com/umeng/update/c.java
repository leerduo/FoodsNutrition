package com.umeng.update;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.umeng.update.net.d;
import com.umeng.update.util.b;
import java.io.File;

public class c
  implements d
{
  private final String a = "delta_update";
  private final String b = "update_normal";
  private UmengDownloadListener c = null;
  private String d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private Context h = null;
  private String i = null;
  private com.umeng.update.net.a j = null;
  private boolean k = false;
  
  private void a(com.umeng.update.net.a parama)
  {
    try
    {
      m = this.h.getPackageManager().getPackageInfo(this.h.getPackageName(), 0).applicationInfo.targetSdkVersion;
      if ((Build.VERSION.SDK_INT >= 16) && (m >= 14) && (UpdateConfig.isRichNotification()) && (!UpdateConfig.isSilentDownload())) {
        parama.a(true);
      }
      parama.b(UpdateConfig.isSilentDownload());
      parama.c(UpdateConfig.isSilentDownload());
      parama.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c != null) {
      this.c.OnDownloadUpdate(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.k = false;
      if (this.c != null) {
        this.c.OnDownloadEnd(paramInt1, paramString);
      }
      return;
      c();
    }
  }
  
  public void a(Context paramContext, UpdateResponse paramUpdateResponse, boolean paramBoolean, File paramFile)
  {
    Intent localIntent = new Intent(paramContext, UpdateDialogActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("response", paramUpdateResponse);
    if (paramBoolean) {
      localBundle.putString("file", paramFile.getAbsolutePath());
    }
    for (;;)
    {
      localBundle.putBoolean("force", UpdateConfig.isUpdateForce());
      localIntent.putExtras(localBundle);
      localIntent.addFlags(335544320);
      paramContext.startActivity(localIntent);
      return;
      localBundle.putString("file", null);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, UmengDownloadListener paramUmengDownloadListener)
  {
    this.h = paramContext;
    this.i = u.upd.a.j(paramContext);
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.c = paramUmengDownloadListener;
  }
  
  public boolean a()
  {
    return this.k;
  }
  
  public c.a b(Context paramContext, UpdateResponse paramUpdateResponse, boolean paramBoolean, File paramFile)
  {
    String str1 = u.upd.a.j(paramContext);
    String str2 = paramUpdateResponse.a(paramContext, paramBoolean);
    String str3;
    Intent localIntent;
    if (paramBoolean)
    {
      str3 = paramContext.getString(u.upd.c.a(paramContext).d("UMDialog_InstallAPK"));
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    }
    for (;;)
    {
      String str4 = str1 + str3;
      PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
      c.a locala = new c.a(this, paramContext);
      locala.c(str2).b(str1).a(str3).d(str4).a(localPendingIntent).a(17301629).b(true);
      return locala;
      str3 = paramContext.getString(u.upd.c.a(paramContext).d("UMUpdateTitle"));
      localIntent = new Intent(paramContext, UpdateDialogActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("response", paramUpdateResponse);
      localBundle.putString("file", null);
      localBundle.putBoolean("force", UpdateConfig.isUpdateForce());
      localIntent.putExtras(localBundle);
      localIntent.addFlags(335544320);
    }
  }
  
  public void b()
  {
    this.j = new com.umeng.update.net.a(this.h, this.a, this.i, this.f, this);
    this.j.a(this.g);
    this.j.b(this.e);
    a(this.j);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return;
    case 2: 
    case 7: 
      this.k = true;
      return;
    }
    this.k = false;
  }
  
  public void c()
  {
    this.j = new com.umeng.update.net.a(this.h, this.b, this.i, this.d, this);
    this.j.a(this.e);
    this.j.b(this.e);
    a(this.j);
  }
  
  public void d()
  {
    this.k = true;
    if (this.c != null) {
      this.c.OnDownloadStart();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */