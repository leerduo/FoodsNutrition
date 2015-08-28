package com.boohee.pictures;

import com.boohee.pictures.model.AuthParams;

public class PictureUpload
{
  public static boolean DEBUG = false;
  static int MAX_PIC_SIZE;
  static AuthParams sAuthParams;
  static int sMaxPicNumber = 1;
  static String sUploadPath;
  
  static
  {
    MAX_PIC_SIZE = 1048576;
  }
  
  public static PictureUpload init(AuthParams paramAuthParams, int paramInt, String paramString)
  {
    if (paramAuthParams == null) {
      throw new RuntimeException("AuthParams must not null !");
    }
    if (paramInt <= 0) {
      throw new RuntimeException("Max Picture Number must big than 0 !");
    }
    sAuthParams = paramAuthParams;
    sMaxPicNumber = paramInt;
    sUploadPath = paramString;
    return new PictureUpload();
  }
  
  public void configMaxPicSize(int paramInt)
  {
    if (1024 * (paramInt * 1024) > MAX_PIC_SIZE) {
      MAX_PIC_SIZE = 1024 * (paramInt * 1024);
    }
  }
  
  public void debug(boolean paramBoolean)
  {
    DEBUG = paramBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.PictureUpload
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */