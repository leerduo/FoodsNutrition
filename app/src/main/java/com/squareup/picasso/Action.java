package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

abstract class Action<T>
{
  final Picasso a;
  final Request b;
  final WeakReference<T> c;
  final boolean d;
  final boolean e;
  final int f;
  final Drawable g;
  final String h;
  final Object i;
  boolean j;
  boolean k;
  
  Action(Picasso paramPicasso, T paramT, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Drawable paramDrawable, String paramString, Object paramObject)
  {
    this.a = paramPicasso;
    this.b = paramRequest;
    Action.RequestWeakReference localRequestWeakReference;
    if (paramT == null)
    {
      localRequestWeakReference = null;
      this.c = localRequestWeakReference;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramInt;
      this.g = paramDrawable;
      this.h = paramString;
      if (paramObject == null) {
        break label87;
      }
    }
    for (;;)
    {
      this.i = paramObject;
      return;
      localRequestWeakReference = new Action.RequestWeakReference(this, paramT, paramPicasso.i);
      break;
      label87:
      paramObject = this;
    }
  }
  
  abstract void a();
  
  abstract void a(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom);
  
  void b()
  {
    this.k = true;
  }
  
  Request c()
  {
    return this.b;
  }
  
  T d()
  {
    if (this.c == null) {
      return null;
    }
    return this.c.get();
  }
  
  String e()
  {
    return this.h;
  }
  
  boolean f()
  {
    return this.k;
  }
  
  boolean g()
  {
    return this.j;
  }
  
  Picasso h()
  {
    return this.a;
  }
  
  Picasso.Priority i()
  {
    return this.b.q;
  }
  
  Object j()
  {
    return this.i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Action
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */