package com.alibaba.fastjson.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public final class ListSerializer
  implements ObjectSerializer
{
  public static final ListSerializer instance = new ListSerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    int i = 0;
    boolean bool = paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName);
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    Type localType;
    SerialContext localSerialContext;
    label146:
    label296:
    Iterator localIterator1;
    if ((bool) && ((paramType instanceof ParameterizedType)))
    {
      localType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      if (paramObject1 == null)
      {
        if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty))
        {
          localSerializeWriter.write("[]");
          return;
        }
        localSerializeWriter.writeNull();
        return;
      }
      List localList = (List)paramObject1;
      if (localList.size() == 0)
      {
        localSerializeWriter.append("[]");
        return;
      }
      localSerialContext = paramJSONSerializer.getContext();
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, 0);
      try
      {
        if (!localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
          break label296;
        }
        localSerializeWriter.append('[');
        paramJSONSerializer.incrementIndent();
        Iterator localIterator2 = localList.iterator();
        if (!localIterator2.hasNext()) {
          break label273;
        }
        Object localObject3 = localIterator2.next();
        if (i != 0) {
          localSerializeWriter.append(',');
        }
        paramJSONSerializer.println();
        if (localObject3 != null) {
          if (paramJSONSerializer.containsReference(localObject3))
          {
            paramJSONSerializer.writeReference(localObject3);
          }
          else
          {
            ObjectSerializer localObjectSerializer = paramJSONSerializer.getObjectWriter(localObject3.getClass());
            paramJSONSerializer.setContext(new SerialContext(localSerialContext, paramObject1, paramObject2, 0));
            localObjectSerializer.write(paramJSONSerializer, localObject3, Integer.valueOf(i), localType);
          }
        }
      }
      finally
      {
        paramJSONSerializer.setContext(localSerialContext);
      }
      paramJSONSerializer.getWriter().writeNull();
      break label517;
      label273:
      paramJSONSerializer.decrementIdent();
      paramJSONSerializer.println();
      localSerializeWriter.append(']');
      paramJSONSerializer.setContext(localSerialContext);
      return;
      localSerializeWriter.append('[');
      localIterator1 = localList.iterator();
    }
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        Object localObject2 = localIterator1.next();
        if (i != 0) {
          localSerializeWriter.append(',');
        }
        if (localObject2 == null)
        {
          localSerializeWriter.append("null");
        }
        else
        {
          Class localClass = localObject2.getClass();
          if (localClass == Integer.class)
          {
            localSerializeWriter.writeInt(((Integer)localObject2).intValue());
          }
          else if (localClass == Long.class)
          {
            long l = ((Long)localObject2).longValue();
            if (bool) {
              localSerializeWriter.writeLongAndChar(l, 'L');
            } else {
              localSerializeWriter.writeLong(l);
            }
          }
          else
          {
            paramJSONSerializer.setContext(new SerialContext(localSerialContext, paramObject1, paramObject2, 0));
            if (paramJSONSerializer.containsReference(localObject2)) {
              paramJSONSerializer.writeReference(localObject2);
            } else {
              paramJSONSerializer.getObjectWriter(localObject2.getClass()).write(paramJSONSerializer, localObject2, Integer.valueOf(i), localType);
            }
          }
        }
      }
      else
      {
        localSerializeWriter.append(']');
        paramJSONSerializer.setContext(localSerialContext);
        return;
        localType = null;
        break;
        label517:
        i++;
        break label146;
      }
      i++;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.ListSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */