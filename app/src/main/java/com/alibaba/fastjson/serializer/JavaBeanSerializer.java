package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JavaBeanSerializer
  implements ObjectSerializer
{
  private int features = 0;
  private final FieldSerializer[] getters;
  private final FieldSerializer[] sortedGetters;
  
  public JavaBeanSerializer(Class<?> paramClass)
  {
    this(paramClass, (Map)null);
  }
  
  public JavaBeanSerializer(Class<?> paramClass, Map<String, String> paramMap)
  {
    this.features = TypeUtils.getSerializeFeatures(paramClass);
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = TypeUtils.computeGetters(paramClass, paramMap, false).iterator();
    while (localIterator1.hasNext()) {
      localArrayList1.add(createFieldSerializer((FieldInfo)localIterator1.next()));
    }
    this.getters = ((FieldSerializer[])localArrayList1.toArray(new FieldSerializer[localArrayList1.size()]));
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator2 = TypeUtils.computeGetters(paramClass, paramMap, true).iterator();
    while (localIterator2.hasNext()) {
      localArrayList2.add(createFieldSerializer((FieldInfo)localIterator2.next()));
    }
    this.sortedGetters = ((FieldSerializer[])localArrayList2.toArray(new FieldSerializer[localArrayList2.size()]));
  }
  
  public JavaBeanSerializer(Class<?> paramClass, String... paramVarArgs)
  {
    this(paramClass, createAliasMap(paramVarArgs));
  }
  
  static Map<String, String> createAliasMap(String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramVarArgs[j];
      localHashMap.put(str, str);
    }
    return localHashMap;
  }
  
  public FieldSerializer createFieldSerializer(FieldInfo paramFieldInfo)
  {
    if (paramFieldInfo.getFieldClass() == Number.class) {
      return new NumberFieldSerializer(paramFieldInfo);
    }
    return new ObjectFieldSerializer(paramFieldInfo);
  }
  
  public FieldSerializer[] getGetters()
  {
    return this.getters;
  }
  
  public boolean isWriteAsArray(JSONSerializer paramJSONSerializer)
  {
    if (SerializerFeature.isEnabled(this.features, SerializerFeature.BeanToArray)) {}
    while (paramJSONSerializer.isEnabled(SerializerFeature.BeanToArray)) {
      return true;
    }
    return false;
  }
  
  protected boolean isWriteClassName(JSONSerializer paramJSONSerializer, Object paramObject1, Type paramType, Object paramObject2)
  {
    return paramJSONSerializer.isWriteClassName(paramType, paramObject1);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      localSerializeWriter.writeNull();
    }
    while (writeReference(paramJSONSerializer, paramObject1)) {
      return;
    }
    FieldSerializer[] arrayOfFieldSerializer;
    SerialContext localSerialContext;
    boolean bool1;
    char c1;
    label76:
    char c2;
    if (localSerializeWriter.isEnabled(SerializerFeature.SortField))
    {
      arrayOfFieldSerializer = this.sortedGetters;
      localSerialContext = paramJSONSerializer.getContext();
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, this.features);
      bool1 = isWriteAsArray(paramJSONSerializer);
      if (!bool1) {
        break label268;
      }
      c1 = '[';
      if (!bool1) {
        break label275;
      }
      c2 = ']';
    }
    label85:
    int i;
    label175:
    char c3;
    int j;
    label193:
    int m;
    FieldSerializer localFieldSerializer;
    int k;
    int n;
    label249:
    Object localObject3;
    try
    {
      localSerializeWriter.append(c1);
      if ((arrayOfFieldSerializer.length > 0) && (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)))
      {
        paramJSONSerializer.incrementIndent();
        paramJSONSerializer.println();
      }
      boolean bool2 = isWriteClassName(paramJSONSerializer, paramObject1, paramType, paramObject2);
      i = 0;
      if (!bool2) {
        break label869;
      }
      Class localClass1 = paramObject1.getClass();
      i = 0;
      if (localClass1 == paramType) {
        break label869;
      }
      localSerializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
      paramJSONSerializer.write(paramObject1.getClass());
      i = 1;
    }
    catch (Exception localException)
    {
      Field localField;
      boolean bool3;
      label268:
      label275:
      label282:
      label294:
      Object localObject2;
      String str;
      label676:
      throw new JSONException("write javaBean error", localException);
    }
    finally
    {
      paramJSONSerializer.setContext(localSerialContext);
    }
    if (FilterUtils.writeBefore(paramJSONSerializer, paramObject1, c3) == ',')
    {
      j = 1;
      break label881;
      if (m >= arrayOfFieldSerializer.length) {
        break label897;
      }
      localFieldSerializer = arrayOfFieldSerializer[m];
      if (!paramJSONSerializer.isEnabled(SerializerFeature.SkipTransientField)) {
        break label294;
      }
      localField = localFieldSerializer.getField();
      if (localField == null) {
        break label294;
      }
      bool3 = Modifier.isTransient(localField.getModifiers());
      if (!bool3) {
        break label294;
      }
      n = k;
    }
    for (;;)
    {
      m++;
      k = n;
      break label193;
      arrayOfFieldSerializer = this.getters;
      break;
      c1 = '{';
      break label76;
      c2 = '}';
      break label85;
      c3 = '\000';
      break label175;
      j = 0;
      break label881;
      if (!FilterUtils.applyName(paramJSONSerializer, paramObject1, localFieldSerializer.getName()))
      {
        n = k;
      }
      else
      {
        localObject2 = localFieldSerializer.getPropertyValue(paramObject1);
        if (!FilterUtils.apply(paramJSONSerializer, paramObject1, localFieldSerializer.getName(), localObject2))
        {
          n = k;
        }
        else
        {
          str = FilterUtils.processKey(paramJSONSerializer, paramObject1, localFieldSerializer.getName(), localObject2);
          localObject3 = FilterUtils.processValue(paramJSONSerializer, paramObject1, localFieldSerializer.getName(), localObject2);
          if ((localObject3 == null) && (!bool1) && (!localFieldSerializer.isWriteNull()) && (!paramJSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue)))
          {
            n = k;
          }
          else
          {
            if ((localObject3 == null) || (!paramJSONSerializer.isEnabled(SerializerFeature.NotWriteDefaultValue))) {
              break label676;
            }
            Class localClass2 = localFieldSerializer.fieldInfo.getFieldClass();
            if ((localClass2 == Byte.TYPE) && ((localObject3 instanceof Byte)) && (((Byte)localObject3).byteValue() == 0))
            {
              n = k;
            }
            else if ((localClass2 == Short.TYPE) && ((localObject3 instanceof Short)) && (((Short)localObject3).shortValue() == 0))
            {
              n = k;
            }
            else if ((localClass2 == Integer.TYPE) && ((localObject3 instanceof Integer)) && (((Integer)localObject3).intValue() == 0))
            {
              n = k;
            }
            else if ((localClass2 == Long.TYPE) && ((localObject3 instanceof Long)) && (((Long)localObject3).longValue() == 0L))
            {
              n = k;
            }
            else if ((localClass2 == Float.TYPE) && ((localObject3 instanceof Float)) && (((Float)localObject3).floatValue() == 0.0F))
            {
              n = k;
            }
            else if ((localClass2 == Double.TYPE) && ((localObject3 instanceof Double)) && (((Double)localObject3).doubleValue() == 0.0D))
            {
              n = k;
            }
            else
            {
              if ((localClass2 != Boolean.TYPE) || (!(localObject3 instanceof Boolean)) || (((Boolean)localObject3).booleanValue())) {
                break label676;
              }
              n = k;
            }
          }
        }
      }
    }
    if (k != 0)
    {
      localSerializeWriter.append(',');
      if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
        paramJSONSerializer.println();
      }
    }
    if (str != localFieldSerializer.getName())
    {
      if (!bool1) {
        localSerializeWriter.writeFieldName(str);
      }
      paramJSONSerializer.write(localObject3);
    }
    else if (localObject2 != localObject3)
    {
      if (!bool1) {
        localFieldSerializer.writePrefix(paramJSONSerializer);
      }
      paramJSONSerializer.write(localObject3);
    }
    else if (!bool1)
    {
      localFieldSerializer.writeProperty(paramJSONSerializer, localObject3);
    }
    else
    {
      localFieldSerializer.writeValue(paramJSONSerializer, localObject3);
    }
    for (;;)
    {
      label815:
      FilterUtils.writeAfter(paramJSONSerializer, paramObject1, c4);
      if ((arrayOfFieldSerializer.length > 0) && (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)))
      {
        paramJSONSerializer.decrementIdent();
        paramJSONSerializer.println();
      }
      localSerializeWriter.append(c2);
      paramJSONSerializer.setContext(localSerialContext);
      return;
      label869:
      label881:
      do
      {
        c4 = '\000';
        break label815;
        if (i == 0) {
          break label282;
        }
        c3 = ',';
        break;
        k = j;
        m = 0;
        break label193;
        n = 1;
        break label249;
      } while (k == 0);
      label897:
      char c4 = ',';
    }
  }
  
  public boolean writeReference(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    SerialContext localSerialContext = paramJSONSerializer.getContext();
    if ((localSerialContext != null) && (localSerialContext.isEnabled(SerializerFeature.DisableCircularReferenceDetect))) {}
    while (!paramJSONSerializer.containsReference(paramObject)) {
      return false;
    }
    paramJSONSerializer.writeReference(paramObject);
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JavaBeanSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */