package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.util.List;

class AssetRequestHandler
  extends RequestHandler
{
  private static final int a = "file:///android_asset/".length();
  private final AssetManager b;
  
  public AssetRequestHandler(Context paramContext)
  {
    this.b = paramContext.getAssets();
  }
  
  /* Error */
  android.graphics.Bitmap a(Request paramRequest, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 37	com/squareup/picasso/AssetRequestHandler:d	(Lcom/squareup/picasso/Request;)Landroid/graphics/BitmapFactory$Options;
    //   6: astore 4
    //   8: aload 4
    //   10: invokestatic 40	com/squareup/picasso/AssetRequestHandler:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   13: ifeq +38 -> 51
    //   16: aload_0
    //   17: getfield 32	com/squareup/picasso/AssetRequestHandler:b	Landroid/content/res/AssetManager;
    //   20: aload_2
    //   21: invokevirtual 46	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_3
    //   25: aload_3
    //   26: aconst_null
    //   27: aload 4
    //   29: invokestatic 52	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: pop
    //   33: aload_3
    //   34: invokestatic 57	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   37: aload_1
    //   38: getfield 62	com/squareup/picasso/Request:h	I
    //   41: aload_1
    //   42: getfield 65	com/squareup/picasso/Request:i	I
    //   45: aload 4
    //   47: aload_1
    //   48: invokestatic 68	com/squareup/picasso/AssetRequestHandler:a	(IILandroid/graphics/BitmapFactory$Options;Lcom/squareup/picasso/Request;)V
    //   51: aload_0
    //   52: getfield 32	com/squareup/picasso/AssetRequestHandler:b	Landroid/content/res/AssetManager;
    //   55: aload_2
    //   56: invokevirtual 46	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: astore 5
    //   61: aload 5
    //   63: aconst_null
    //   64: aload 4
    //   66: invokestatic 52	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   69: astore 7
    //   71: aload 5
    //   73: invokestatic 57	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   76: aload 7
    //   78: areturn
    //   79: astore 8
    //   81: aload_3
    //   82: invokestatic 57	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   85: aload 8
    //   87: athrow
    //   88: astore 6
    //   90: aload 5
    //   92: invokestatic 57	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   95: aload 6
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	AssetRequestHandler
    //   0	98	1	paramRequest	Request
    //   0	98	2	paramString	String
    //   1	81	3	localInputStream1	java.io.InputStream
    //   6	59	4	localOptions	android.graphics.BitmapFactory.Options
    //   59	32	5	localInputStream2	java.io.InputStream
    //   88	8	6	localObject1	java.lang.Object
    //   69	8	7	localBitmap	android.graphics.Bitmap
    //   79	7	8	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   16	33	79	finally
    //   61	71	88	finally
  }
  
  public boolean a(Request paramRequest)
  {
    Uri localUri = paramRequest.d;
    boolean bool1 = "file".equals(localUri.getScheme());
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = localUri.getPathSegments().isEmpty();
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = "android_asset".equals(localUri.getPathSegments().get(0));
        bool2 = false;
        if (bool4) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public RequestHandler.Result b(Request paramRequest)
  {
    return new RequestHandler.Result(a(paramRequest, paramRequest.d.toString().substring(a)), Picasso.LoadedFrom.b);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.AssetRequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */