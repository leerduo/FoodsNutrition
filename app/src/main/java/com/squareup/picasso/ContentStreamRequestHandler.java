package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;

class ContentStreamRequestHandler
  extends RequestHandler
{
  final Context a;
  
  ContentStreamRequestHandler(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a(Request paramRequest)
  {
    return "content".equals(paramRequest.d.getScheme());
  }
  
  public RequestHandler.Result b(Request paramRequest)
  {
    return new RequestHandler.Result(c(paramRequest), Picasso.LoadedFrom.b);
  }
  
  /* Error */
  protected android.graphics.Bitmap c(Request paramRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 13	com/squareup/picasso/ContentStreamRequestHandler:a	Landroid/content/Context;
    //   6: invokevirtual 56	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: astore_3
    //   10: aload_1
    //   11: invokestatic 59	com/squareup/picasso/ContentStreamRequestHandler:d	(Lcom/squareup/picasso/Request;)Landroid/graphics/BitmapFactory$Options;
    //   14: astore 4
    //   16: aload 4
    //   18: invokestatic 62	com/squareup/picasso/ContentStreamRequestHandler:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   21: ifeq +38 -> 59
    //   24: aload_3
    //   25: aload_1
    //   26: getfield 22	com/squareup/picasso/Request:d	Landroid/net/Uri;
    //   29: invokevirtual 68	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: astore_2
    //   33: aload_2
    //   34: aconst_null
    //   35: aload 4
    //   37: invokestatic 74	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: pop
    //   41: aload_2
    //   42: invokestatic 79	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   45: aload_1
    //   46: getfield 83	com/squareup/picasso/Request:h	I
    //   49: aload_1
    //   50: getfield 86	com/squareup/picasso/Request:i	I
    //   53: aload 4
    //   55: aload_1
    //   56: invokestatic 89	com/squareup/picasso/ContentStreamRequestHandler:a	(IILandroid/graphics/BitmapFactory$Options;Lcom/squareup/picasso/Request;)V
    //   59: aload_3
    //   60: aload_1
    //   61: getfield 22	com/squareup/picasso/Request:d	Landroid/net/Uri;
    //   64: invokevirtual 68	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   67: astore 5
    //   69: aload 5
    //   71: aconst_null
    //   72: aload 4
    //   74: invokestatic 74	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: astore 7
    //   79: aload 5
    //   81: invokestatic 79	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   84: aload 7
    //   86: areturn
    //   87: astore 8
    //   89: aload_2
    //   90: invokestatic 79	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   93: aload 8
    //   95: athrow
    //   96: astore 6
    //   98: aload 5
    //   100: invokestatic 79	com/squareup/picasso/Utils:a	(Ljava/io/InputStream;)V
    //   103: aload 6
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	ContentStreamRequestHandler
    //   0	106	1	paramRequest	Request
    //   1	89	2	localInputStream1	java.io.InputStream
    //   9	51	3	localContentResolver	android.content.ContentResolver
    //   14	59	4	localOptions	android.graphics.BitmapFactory.Options
    //   67	32	5	localInputStream2	java.io.InputStream
    //   96	8	6	localObject1	java.lang.Object
    //   77	8	7	localBitmap	android.graphics.Bitmap
    //   87	7	8	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	41	87	finally
    //   69	79	96	finally
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ContentStreamRequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */