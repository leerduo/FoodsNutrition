package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;

class FileRequestHandler
  extends ContentStreamRequestHandler
{
  FileRequestHandler(Context paramContext)
  {
    super(paramContext);
  }
  
  static int a(Uri paramUri)
  {
    switch (new ExifInterface(paramUri.getPath()).getAttributeInt("Orientation", 1))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public boolean a(Request paramRequest)
  {
    return "file".equals(paramRequest.d.getScheme());
  }
  
  public RequestHandler.Result b(Request paramRequest)
  {
    return new RequestHandler.Result(c(paramRequest), Picasso.LoadedFrom.b, a(paramRequest.d));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.FileRequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */