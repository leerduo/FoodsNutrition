package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;

class ResourceRequestHandler
  extends RequestHandler
{
  private final Context a;
  
  ResourceRequestHandler(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static Bitmap a(Resources paramResources, int paramInt, Request paramRequest)
  {
    BitmapFactory.Options localOptions = d(paramRequest);
    if (a(localOptions))
    {
      BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
      a(paramRequest.h, paramRequest.i, localOptions, paramRequest);
    }
    return BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
  }
  
  public boolean a(Request paramRequest)
  {
    if (paramRequest.e != 0) {
      return true;
    }
    return "android.resource".equals(paramRequest.d.getScheme());
  }
  
  public RequestHandler.Result b(Request paramRequest)
  {
    Resources localResources = Utils.a(this.a, paramRequest);
    return new RequestHandler.Result(a(localResources, Utils.a(localResources, paramRequest), paramRequest), Picasso.LoadedFrom.b);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ResourceRequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */