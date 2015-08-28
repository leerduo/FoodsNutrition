package com.boohee.pictures;

import com.boohee.pictures.util.ParseUtils;

class Picture
{
  public int height;
  public String path;
  public int size;
  public int width;
  
  public String toString()
  {
    return ParseUtils.toJson(this);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.Picture
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */