package com.umeng.update.net;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import com.umeng.update.util.b;
import u.upd.c;
import u.upd.j;
import u.upd.l;

class c$a
  extends b
{
  public c$a(Context paramContext)
  {
    super(paramContext);
  }
  
  public a a()
  {
    this.c.contentView.setViewVisibility(j.e(this.b), 8);
    this.c.contentView.setViewVisibility(j.f(this.b), 8);
    return this;
  }
  
  public a a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.d.setProgress(paramInt1, paramInt2, paramBoolean);
    }
    this.c.contentView.setProgressBar(j.c(this.b), 100, paramInt2, false);
    return this;
  }
  
  public a a(PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
  {
    this.c.contentView.setOnClickPendingIntent(j.e(this.b), paramPendingIntent1);
    this.c.contentView.setViewVisibility(j.e(this.b), 0);
    this.c.contentView.setViewVisibility(j.f(this.b), 0);
    this.c.contentView.setOnClickPendingIntent(j.f(this.b), paramPendingIntent2);
    return this;
  }
  
  public a a(RemoteViews paramRemoteViews)
  {
    this.c.contentView = paramRemoteViews;
    return this;
  }
  
  public a a(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.d.setContentText(paramCharSequence);
    }
    this.c.contentView.setTextViewText(j.a(this.b), paramCharSequence);
    return this;
  }
  
  public void a(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.d.addAction(paramInt, paramString, paramPendingIntent);
    }
  }
  
  public a b()
  {
    int i = j.e(this.b);
    this.c.contentView.setTextViewText(i, this.b.getResources().getString(l.e(this.b.getApplicationContext())));
    this.c.contentView.setInt(i, "setBackgroundResource", c.a(this.b).b("umeng_common_gradient_green"));
    return this;
  }
  
  public a b(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.d.setContentTitle(paramCharSequence);
    }
    this.c.contentView.setTextViewText(j.d(this.b), paramCharSequence);
    return this;
  }
  
  public a c()
  {
    int i = j.e(this.b);
    this.c.contentView.setTextViewText(i, this.b.getResources().getString(l.d(this.b.getApplicationContext())));
    this.c.contentView.setInt(i, "setBackgroundResource", c.a(this.b).b("umeng_common_gradient_orange"));
    return this;
  }
  
  public Notification d()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.d.build();
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return this.d.getNotification();
    }
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.c.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */