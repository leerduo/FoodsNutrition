package com.alibaba.fastjson.serializer;

public class PascalNameFilter
  implements NameFilter
{
  public String process(Object paramObject1, String paramString, Object paramObject2)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    char[] arrayOfChar = paramString.toCharArray();
    arrayOfChar[0] = Character.toUpperCase(arrayOfChar[0]);
    return new String(arrayOfChar);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.PascalNameFilter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */