package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;

class MediaStoreRequestHandler
  extends ContentStreamRequestHandler
{
  private static final String[] b = { "orientation" };
  
  MediaStoreRequestHandler(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  static int a(ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getstatic 14	com/squareup/picasso/MediaStoreRequestHandler:b	[Ljava/lang/String;
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: invokevirtual 28	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   11: astore 6
    //   13: aload 6
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +16 -> 33
    //   20: aload_3
    //   21: invokeinterface 34 1 0
    //   26: istore 9
    //   28: iload 9
    //   30: ifne +19 -> 49
    //   33: aload_3
    //   34: ifnull +9 -> 43
    //   37: aload_3
    //   38: invokeinterface 37 1 0
    //   43: iconst_0
    //   44: istore 7
    //   46: iload 7
    //   48: ireturn
    //   49: aload_3
    //   50: iconst_0
    //   51: invokeinterface 41 2 0
    //   56: istore 10
    //   58: iload 10
    //   60: istore 7
    //   62: aload_3
    //   63: ifnull -17 -> 46
    //   66: aload_3
    //   67: invokeinterface 37 1 0
    //   72: iload 7
    //   74: ireturn
    //   75: astore 4
    //   77: aconst_null
    //   78: astore 5
    //   80: aload 5
    //   82: ifnull +10 -> 92
    //   85: aload 5
    //   87: invokeinterface 37 1 0
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_3
    //   97: aload_3
    //   98: ifnull +9 -> 107
    //   101: aload_3
    //   102: invokeinterface 37 1 0
    //   107: aload_2
    //   108: athrow
    //   109: astore_2
    //   110: goto -13 -> 97
    //   113: astore 8
    //   115: aload_3
    //   116: astore 5
    //   118: goto -38 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContentResolver	ContentResolver
    //   0	121	1	paramUri	Uri
    //   94	14	2	localObject1	java.lang.Object
    //   109	1	2	localObject2	java.lang.Object
    //   15	101	3	localCursor1	android.database.Cursor
    //   75	1	4	localRuntimeException1	java.lang.RuntimeException
    //   78	39	5	localCursor2	android.database.Cursor
    //   11	3	6	localCursor3	android.database.Cursor
    //   44	29	7	i	int
    //   113	1	8	localRuntimeException2	java.lang.RuntimeException
    //   26	3	9	bool	boolean
    //   56	3	10	j	int
    // Exception table:
    //   from	to	target	type
    //   0	13	75	java/lang/RuntimeException
    //   0	13	94	finally
    //   20	28	109	finally
    //   49	58	109	finally
    //   20	28	113	java/lang/RuntimeException
    //   49	58	113	java/lang/RuntimeException
  }
  
  static MediaStoreRequestHandler.PicassoKind a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= MediaStoreRequestHandler.PicassoKind.a.e) && (paramInt2 <= MediaStoreRequestHandler.PicassoKind.a.f)) {
      return MediaStoreRequestHandler.PicassoKind.a;
    }
    if ((paramInt1 <= MediaStoreRequestHandler.PicassoKind.b.e) && (paramInt2 <= MediaStoreRequestHandler.PicassoKind.b.f)) {
      return MediaStoreRequestHandler.PicassoKind.b;
    }
    return MediaStoreRequestHandler.PicassoKind.c;
  }
  
  public boolean a(Request paramRequest)
  {
    Uri localUri = paramRequest.d;
    return ("content".equals(localUri.getScheme())) && ("media".equals(localUri.getAuthority()));
  }
  
  public RequestHandler.Result b(Request paramRequest)
  {
    int i = 1;
    ContentResolver localContentResolver = this.a.getContentResolver();
    int j = a(localContentResolver, paramRequest.d);
    String str = localContentResolver.getType(paramRequest.d);
    int k;
    if ((str != null) && (str.startsWith("video/"))) {
      k = i;
    }
    while (paramRequest.d())
    {
      MediaStoreRequestHandler.PicassoKind localPicassoKind = a(paramRequest.h, paramRequest.i);
      if ((k == 0) && (localPicassoKind == MediaStoreRequestHandler.PicassoKind.c))
      {
        return new RequestHandler.Result(c(paramRequest), Picasso.LoadedFrom.b, j);
        k = 0;
      }
      else
      {
        long l = ContentUris.parseId(paramRequest.d);
        BitmapFactory.Options localOptions = d(paramRequest);
        localOptions.inJustDecodeBounds = i;
        a(paramRequest.h, paramRequest.i, localPicassoKind.e, localPicassoKind.f, localOptions, paramRequest);
        if (k != 0) {
          if (localPicassoKind != MediaStoreRequestHandler.PicassoKind.c) {}
        }
        for (Bitmap localBitmap = MediaStore.Video.Thumbnails.getThumbnail(localContentResolver, l, i, localOptions);; localBitmap = MediaStore.Images.Thumbnails.getThumbnail(localContentResolver, l, localPicassoKind.d, localOptions))
        {
          if (localBitmap == null) {
            break label221;
          }
          return new RequestHandler.Result(localBitmap, Picasso.LoadedFrom.b, j);
          i = localPicassoKind.d;
          break;
        }
      }
    }
    label221:
    return new RequestHandler.Result(c(paramRequest), Picasso.LoadedFrom.b, j);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.MediaStoreRequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */