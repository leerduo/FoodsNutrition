package com.activeandroid.serializer;

import java.io.File;

public final class FileSerializer
  extends TypeSerializer
{
  public Class<?> a()
  {
    return File.class;
  }
  
  public String a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return ((File)paramObject).toString();
  }
  
  public File b(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new File((String)paramObject);
  }
  
  public Class<?> b()
  {
    return String.class;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.serializer.FileSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */