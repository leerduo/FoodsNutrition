package com.qiniu.android.storage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class UploadOptions
{
  final UpCancellationSignal cancellationSignal;
  final boolean checkCrc;
  final String mimeType;
  final Map<String, String> params;
  final UpProgressHandler progressHandler;
  
  public UploadOptions(Map<String, String> paramMap, String paramString, boolean paramBoolean, UpProgressHandler paramUpProgressHandler, UpCancellationSignal paramUpCancellationSignal)
  {
    this.params = filterParam(paramMap);
    this.mimeType = mime(paramString);
    this.checkCrc = paramBoolean;
    if (paramUpProgressHandler != null)
    {
      this.progressHandler = paramUpProgressHandler;
      if (paramUpCancellationSignal == null) {
        break label61;
      }
    }
    for (;;)
    {
      this.cancellationSignal = paramUpCancellationSignal;
      return;
      paramUpProgressHandler = new UploadOptions.1(this);
      break;
      label61:
      paramUpCancellationSignal = new UploadOptions.2(this);
    }
  }
  
  static UploadOptions defaultOptions()
  {
    return new UploadOptions(null, null, false, null, null);
  }
  
  private static Map<String, String> filterParam(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap == null) {
      return localHashMap;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((String)localEntry.getKey()).startsWith("x:")) && (localEntry.getValue() != null) && (!((String)localEntry.getValue()).equals(""))) {
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  private static String mime(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      paramString = "application/octet-stream";
    }
    return paramString;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.UploadOptions
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */