package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class FilterUtils
{
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    List localList = paramJSONSerializer.getPropertyFiltersDirect();
    if (localList == null) {
      return true;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (!((PropertyFilter)localIterator.next()).apply(paramObject1, paramString, paramObject2)) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean applyName(JSONSerializer paramJSONSerializer, Object paramObject, String paramString)
  {
    List localList = paramJSONSerializer.getPropertyPreFiltersDirect();
    if (localList == null) {
      return true;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (!((PropertyPreFilter)localIterator.next()).apply(paramJSONSerializer, paramObject, paramString)) {
        return false;
      }
    }
    return true;
  }
  
  public static Type getExtratype(DefaultJSONParser paramDefaultJSONParser, Object paramObject, String paramString)
  {
    List localList = paramDefaultJSONParser.getExtraTypeProvidersDirect();
    Type localType = null;
    if (localList == null) {}
    for (;;)
    {
      return localType;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        localType = ((ExtraTypeProvider)localIterator.next()).getExtraType(paramObject, paramString);
      }
    }
  }
  
  public static void processExtra(DefaultJSONParser paramDefaultJSONParser, Object paramObject1, String paramString, Object paramObject2)
  {
    List localList = paramDefaultJSONParser.getExtraProcessorsDirect();
    if (localList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((ExtraProcessor)localIterator.next()).processExtra(paramObject1, paramString, paramObject2);
      }
    }
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    List localList = paramJSONSerializer.getNameFiltersDirect();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramString = ((NameFilter)localIterator.next()).process(paramObject1, paramString, paramObject2);
      }
    }
    return paramString;
  }
  
  public static Object processValue(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    List localList = paramJSONSerializer.getValueFiltersDirect();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramObject2 = ((ValueFilter)localIterator.next()).process(paramObject1, paramString, paramObject2);
      }
    }
    return paramObject2;
  }
  
  public static char writeAfter(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar)
  {
    List localList = paramJSONSerializer.getAfterFiltersDirect();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramChar = ((AfterFilter)localIterator.next()).writeAfter(paramJSONSerializer, paramObject, paramChar);
      }
    }
    return paramChar;
  }
  
  public static char writeBefore(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar)
  {
    List localList = paramJSONSerializer.getBeforeFiltersDirect();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramChar = ((BeforeFilter)localIterator.next()).writeBefore(paramJSONSerializer, paramObject, paramChar);
      }
    }
    return paramChar;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.FilterUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */