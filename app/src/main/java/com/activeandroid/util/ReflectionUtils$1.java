package com.activeandroid.util;

import java.lang.reflect.Field;
import java.util.Comparator;

final class ReflectionUtils$1
  implements Comparator<Field>
{
  public int a(Field paramField1, Field paramField2)
  {
    return paramField2.getName().compareTo(paramField1.getName());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.ReflectionUtils.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */