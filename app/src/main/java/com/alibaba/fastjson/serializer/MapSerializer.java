package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapSerializer
  implements ObjectSerializer
{
  public static MapSerializer instance = new MapSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    Map localMap = (Map)paramObject1;
    Object localObject1;
    SerialContext localSerialContext;
    if ((localSerializeWriter.isEnabled(SerializerFeature.SortField)) && (!(localMap instanceof SortedMap)) && (!(localMap instanceof LinkedHashMap))) {
      try
      {
        TreeMap localTreeMap = new TreeMap(localMap);
        localObject1 = localTreeMap;
        if (paramJSONSerializer.containsReference(paramObject1))
        {
          paramJSONSerializer.writeReference(paramObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = localMap;
        }
        localSerialContext = paramJSONSerializer.getContext();
        paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
      }
    }
    label533:
    label570:
    label606:
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      int j;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      try
      {
        localSerializeWriter.write('{');
        paramJSONSerializer.incrementIndent();
        localObject3 = null;
        localObject4 = null;
        int i = 1;
        if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
        {
          localSerializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
          localSerializeWriter.writeString(paramObject1.getClass().getName());
          i = 0;
        }
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        j = i;
        if (!localIterator.hasNext()) {
          break label770;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localObject5 = localEntry.getValue();
        localObject6 = localEntry.getKey();
        List localList1 = paramJSONSerializer.getPropertyPreFiltersDirect();
        if ((localList1 != null) && (localList1.size() > 0))
        {
          if ((localObject6 != null) && (!(localObject6 instanceof String))) {
            break label498;
          }
          if (!FilterUtils.applyName(paramJSONSerializer, paramObject1, (String)localObject6)) {
            continue;
          }
        }
        List localList2 = paramJSONSerializer.getPropertyFiltersDirect();
        if ((localList2 != null) && (localList2.size() > 0))
        {
          if ((localObject6 != null) && (!(localObject6 instanceof String))) {
            break label533;
          }
          if (!FilterUtils.apply(paramJSONSerializer, paramObject1, (String)localObject6, localObject5)) {
            continue;
          }
        }
        List localList3 = paramJSONSerializer.getNameFiltersDirect();
        if ((localList3 != null) && (localList3.size() > 0))
        {
          if ((localObject6 != null) && (!(localObject6 instanceof String))) {
            break label570;
          }
          localObject6 = FilterUtils.processKey(paramJSONSerializer, paramObject1, (String)localObject6, localObject5);
        }
        List localList4 = paramJSONSerializer.getValueFiltersDirect();
        if ((localList4 == null) || (localList4.size() <= 0)) {
          break label813;
        }
        if ((localObject6 != null) && (!(localObject6 instanceof String))) {
          break label606;
        }
        localObject7 = FilterUtils.processValue(paramJSONSerializer, paramObject1, (String)localObject6, localObject5);
        if ((localObject7 == null) && (!paramJSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue))) {
          continue;
        }
        if (!(localObject6 instanceof String)) {
          break label642;
        }
        String str = (String)localObject6;
        if (j == 0) {
          localSerializeWriter.write(',');
        }
        if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
          paramJSONSerializer.println();
        }
        localSerializeWriter.writeFieldName(str, true);
        if (localObject7 != null) {
          break label704;
        }
        localSerializeWriter.writeNull();
        j = 0;
        continue;
        if (localObject6.getClass().isPrimitive()) {}
      }
      finally
      {
        paramJSONSerializer.setContext(localSerialContext);
      }
      label498:
      if (((localObject6 instanceof Number)) && (!FilterUtils.applyName(paramJSONSerializer, paramObject1, JSON.toJSONString(localObject6))))
      {
        continue;
        if (((localObject6.getClass().isPrimitive()) || ((localObject6 instanceof Number))) && (!FilterUtils.apply(paramJSONSerializer, paramObject1, JSON.toJSONString(localObject6), localObject5)))
        {
          continue;
          if ((localObject6.getClass().isPrimitive()) || ((localObject6 instanceof Number)))
          {
            localObject6 = FilterUtils.processKey(paramJSONSerializer, paramObject1, JSON.toJSONString(localObject6), localObject5);
            continue;
            Object localObject8;
            Object localObject9;
            if ((localObject6.getClass().isPrimitive()) || ((localObject6 instanceof Number)))
            {
              localObject7 = FilterUtils.processValue(paramJSONSerializer, paramObject1, JSON.toJSONString(localObject6), localObject5);
              continue;
              if (j == 0) {
                localSerializeWriter.write(',');
              }
              if ((localSerializeWriter.isEnabled(SerializerFeature.BrowserCompatible)) || (localSerializeWriter.isEnabled(SerializerFeature.WriteNonStringKeyAsString))) {
                paramJSONSerializer.write(JSON.toJSONString(localObject6));
              }
              for (;;)
              {
                localSerializeWriter.write(':');
                break;
                paramJSONSerializer.write(localObject6);
              }
              Class localClass = localObject7.getClass();
              if (localClass == localObject3)
              {
                localObject4.write(paramJSONSerializer, localObject7, localObject6, null);
                localObject8 = localObject4;
                localObject9 = localObject3;
              }
              else
              {
                localObject8 = paramJSONSerializer.getObjectWriter(localClass);
                ((ObjectSerializer)localObject8).write(paramJSONSerializer, localObject7, localObject6, null);
                localObject9 = localClass;
                break label827;
                paramJSONSerializer.setContext(localSerialContext);
                paramJSONSerializer.decrementIdent();
                if ((localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) && (((Map)localObject1).size() > 0)) {
                  paramJSONSerializer.println();
                }
                localSerializeWriter.write('}');
              }
            }
            else
            {
              localObject7 = localObject5;
              continue;
              localObject1 = localMap;
              break;
              localObject4 = localObject8;
              localObject3 = localObject9;
              j = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.MapSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */