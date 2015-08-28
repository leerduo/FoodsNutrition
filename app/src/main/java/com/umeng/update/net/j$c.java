package com.umeng.update.net;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;
import u.upd.b;

class j$c
  extends AsyncTask<Object, Integer, Drawable>
{
  private Context a;
  private String b;
  private ImageView c;
  private j.b d;
  private boolean e;
  private j.a f;
  private Animation g;
  private boolean h;
  private File i;
  
  public j$c(Context paramContext, ImageView paramImageView, String paramString, j.b paramb, File paramFile, boolean paramBoolean1, j.a parama, Animation paramAnimation, boolean paramBoolean2)
  {
    this.i = paramFile;
    this.a = paramContext;
    this.b = paramString;
    this.f = parama;
    this.d = paramb;
    this.e = paramBoolean1;
    this.g = paramAnimation;
    this.c = paramImageView;
    this.h = paramBoolean2;
  }
  
  protected Drawable a(Object... paramVarArgs)
  {
    if (j.a) {}
    try
    {
      Thread.sleep(3000L);
      if ((this.i != null) && (this.i.exists()))
      {
        Drawable localDrawable2 = j.a(this.i.getAbsolutePath());
        if (localDrawable2 == null) {
          this.i.delete();
        }
        b.c(j.a(), "get drawable from cacheFile.");
        return localDrawable2;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    for (;;)
    {
      try
      {
        j.a(this.a, this.b);
        File localFile = j.b(this.a, this.b);
        if ((localFile != null) && (localFile.exists()))
        {
          localDrawable1 = j.a(localFile.getAbsolutePath());
          b.c(j.a(), "get drawable from net else file.");
          return localDrawable1;
        }
      }
      catch (Exception localException)
      {
        b.d(j.a(), localException.toString(), localException);
        return null;
      }
      Drawable localDrawable1 = null;
    }
  }
  
  protected void a(Drawable paramDrawable)
  {
    j.a(this.a, this.c, paramDrawable, this.e, this.f, this.g, this.h, this.b);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.f != null) {
      this.f.a(this.d);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.j.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */