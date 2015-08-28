package com.boohee.pictures;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PictureHelper
{
  public static String createPicture(Cursor paramCursor)
  {
    return getPicturePath(-1, paramCursor);
  }
  
  public static List<String> getAllPictures(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    paramCursor.moveToFirst();
    for (int i = 0; i < paramCursor.getCount(); i++)
    {
      localArrayList.add(createPicture(paramCursor));
      paramCursor.moveToNext();
    }
    return localArrayList;
  }
  
  public static Uri getImageUri(Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, i + "");
  }
  
  public static Picture getPictureFromUri(Context paramContext, Uri paramUri)
  {
    String[] arrayOfString = { "_data", "_size", "height", "width" };
    Cursor localCursor = paramContext.getContentResolver().query(paramUri, arrayOfString, null, null, null);
    if (localCursor == null) {
      return null;
    }
    localCursor.moveToFirst();
    Picture localPicture = new Picture();
    localPicture.path = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
    localPicture.width = localCursor.getInt(localCursor.getColumnIndex("width"));
    localPicture.height = localCursor.getInt(localCursor.getColumnIndex("height"));
    localPicture.size = localCursor.getInt(localCursor.getColumnIndex("_size"));
    return localPicture;
  }
  
  public static String getPicturePath(int paramInt, Cursor paramCursor)
  {
    if (paramInt >= 0) {
      paramCursor.moveToPosition(paramInt);
    }
    return paramCursor.getString(paramCursor.getColumnIndex("_data"));
  }
  
  public static Picture parsePictureFromPath(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    BitmapFactory.Options localOptions;
    do
    {
      Uri localUri;
      do
      {
        do
        {
          return null;
          localFile = new File(paramString);
        } while ((localFile == null) || (!localFile.exists()));
        localUri = Uri.fromFile(localFile);
      } while (localUri == null);
      localOptions = BitmapUtils.getBitmapOptions(paramContext, localUri);
    } while (localOptions == null);
    Picture localPicture = new Picture();
    localPicture.width = localOptions.outWidth;
    localPicture.height = localOptions.outHeight;
    localPicture.size = ((int)localFile.length());
    localPicture.path = paramString;
    return localPicture;
  }
  
  public static List<Picture> parsePictureListFromPathList(Context paramContext, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Picture localPicture = parsePictureFromPath(paramContext, (String)localIterator.next());
      if (localPicture != null) {
        localArrayList.add(localPicture);
      }
    }
    return localArrayList;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.PictureHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */