package com.loopj.android.http;

import java.io.File;

public class RequestParams$FileWrapper
{
  public final String contentType;
  public final String customFileName;
  public final File file;
  
  public RequestParams$FileWrapper(File paramFile, String paramString1, String paramString2)
  {
    this.file = paramFile;
    this.contentType = paramString1;
    this.customFileName = paramString2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.RequestParams.FileWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */