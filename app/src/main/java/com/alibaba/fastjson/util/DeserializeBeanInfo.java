package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DeserializeBeanInfo
{
  private Constructor<?> creatorConstructor;
  private Constructor<?> defaultConstructor;
  private Method factoryMethod;
  private final List<FieldInfo> fieldList = new ArrayList();
  private int parserFeatures = 0;
  private final List<FieldInfo> sortedFieldList = new ArrayList();
  
  public DeserializeBeanInfo(Class<?> paramClass)
  {
    this.parserFeatures = TypeUtils.getParserFeatures(paramClass);
  }
  
  public static DeserializeBeanInfo computeSetters(Class<?> paramClass, Type paramType)
  {
    DeserializeBeanInfo localDeserializeBeanInfo = new DeserializeBeanInfo(paramClass);
    Constructor localConstructor1 = getDefaultConstructor(paramClass);
    int i7;
    label41:
    Method localMethod3;
    String str4;
    if (localConstructor1 != null)
    {
      TypeUtils.setAccessible(localConstructor1);
      localDeserializeBeanInfo.setDefaultConstructor(localConstructor1);
      Method[] arrayOfMethod1 = paramClass.getMethods();
      int i6 = arrayOfMethod1.length;
      i7 = 0;
      if (i7 >= i6) {
        break label1023;
      }
      localMethod3 = arrayOfMethod1[i7];
      str4 = localMethod3.getName();
      if (str4.length() >= 4) {
        break label523;
      }
    }
    for (;;)
    {
      i7++;
      break label41;
      if ((localConstructor1 != null) || (paramClass.isInterface()) || (Modifier.isAbstract(paramClass.getModifiers()))) {
        break;
      }
      Constructor localConstructor2 = getCreatorConstructor(paramClass);
      if (localConstructor2 != null)
      {
        TypeUtils.setAccessible(localConstructor2);
        localDeserializeBeanInfo.setCreatorConstructor(localConstructor2);
        for (int i1 = 0; i1 < localConstructor2.getParameterTypes().length; i1++)
        {
          Annotation[] arrayOfAnnotation2 = localConstructor2.getParameterAnnotations()[i1];
          int i2 = arrayOfAnnotation2.length;
          JSONField localJSONField2;
          for (int i3 = 0;; i3++)
          {
            localJSONField2 = null;
            if (i3 < i2)
            {
              Annotation localAnnotation2 = arrayOfAnnotation2[i3];
              if ((localAnnotation2 instanceof JSONField)) {
                localJSONField2 = (JSONField)localAnnotation2;
              }
            }
            else
            {
              if (localJSONField2 != null) {
                break;
              }
              throw new JSONException("illegal json creator");
            }
          }
          Class localClass2 = localConstructor2.getParameterTypes()[i1];
          Type localType2 = localConstructor2.getGenericParameterTypes()[i1];
          Field localField2 = TypeUtils.getField(paramClass, localJSONField2.name());
          int i4 = localJSONField2.ordinal();
          int i5 = SerializerFeature.of(localJSONField2.serialzeFeatures());
          localDeserializeBeanInfo.add(new FieldInfo(localJSONField2.name(), paramClass, localClass2, localType2, localField2, i4, i5));
        }
        return localDeserializeBeanInfo;
      }
      Method localMethod1 = getFactoryMethod(paramClass);
      if (localMethod1 != null)
      {
        TypeUtils.setAccessible(localMethod1);
        localDeserializeBeanInfo.setFactoryMethod(localMethod1);
        for (int i = 0; i < localMethod1.getParameterTypes().length; i++)
        {
          Annotation[] arrayOfAnnotation1 = localMethod1.getParameterAnnotations()[i];
          int j = arrayOfAnnotation1.length;
          JSONField localJSONField1;
          for (int k = 0;; k++)
          {
            localJSONField1 = null;
            if (k < j)
            {
              Annotation localAnnotation1 = arrayOfAnnotation1[k];
              if ((localAnnotation1 instanceof JSONField)) {
                localJSONField1 = (JSONField)localAnnotation1;
              }
            }
            else
            {
              if (localJSONField1 != null) {
                break;
              }
              throw new JSONException("illegal json creator");
            }
          }
          Class localClass1 = localMethod1.getParameterTypes()[i];
          Type localType1 = localMethod1.getGenericParameterTypes()[i];
          Field localField1 = TypeUtils.getField(paramClass, localJSONField1.name());
          int m = localJSONField1.ordinal();
          int n = SerializerFeature.of(localJSONField1.serialzeFeatures());
          localDeserializeBeanInfo.add(new FieldInfo(localJSONField1.name(), paramClass, localClass1, localType1, localField1, m, n));
        }
        return localDeserializeBeanInfo;
      }
      throw new JSONException("default constructor not found. " + paramClass);
      label523:
      if ((!Modifier.isStatic(localMethod3.getModifiers())) && ((localMethod3.getReturnType().equals(Void.TYPE)) || (localMethod3.getReturnType().equals(paramClass))) && (localMethod3.getParameterTypes().length == 1))
      {
        JSONField localJSONField5 = (JSONField)localMethod3.getAnnotation(JSONField.class);
        if (localJSONField5 == null) {
          localJSONField5 = TypeUtils.getSupperMethodAnnotation(paramClass, localMethod3);
        }
        int i15 = 0;
        int i16 = 0;
        if (localJSONField5 != null)
        {
          if (localJSONField5.deserialize())
          {
            i15 = localJSONField5.ordinal();
            i16 = SerializerFeature.of(localJSONField5.serialzeFeatures());
            if (localJSONField5.name().length() != 0)
            {
              localDeserializeBeanInfo.add(new FieldInfo(localJSONField5.name(), localMethod3, null, paramClass, paramType, i15, i16));
              TypeUtils.setAccessible(localMethod3);
            }
          }
        }
        else if (str4.startsWith("set"))
        {
          char c = str4.charAt(3);
          String str5;
          if (Character.isUpperCase(c)) {
            if (TypeUtils.compatibleWithJavaBean) {
              str5 = TypeUtils.decapitalize(str4.substring(3));
            }
          }
          for (;;)
          {
            Field localField4 = TypeUtils.getField(paramClass, str5);
            if ((localField4 == null) && (localMethod3.getParameterTypes()[0] == Boolean.TYPE)) {
              localField4 = TypeUtils.getField(paramClass, "is" + Character.toUpperCase(str5.charAt(0)) + str5.substring(1));
            }
            if (localField4 == null) {
              break label992;
            }
            JSONField localJSONField6 = (JSONField)localField4.getAnnotation(JSONField.class);
            if (localJSONField6 == null) {
              break label992;
            }
            i15 = localJSONField6.ordinal();
            i16 = SerializerFeature.of(localJSONField6.serialzeFeatures());
            if (localJSONField6.name().length() == 0) {
              break label992;
            }
            localDeserializeBeanInfo.add(new FieldInfo(localJSONField6.name(), localMethod3, localField4, paramClass, paramType, i15, i16));
            break;
            str5 = Character.toLowerCase(str4.charAt(3)) + str4.substring(4);
            continue;
            if (c == '_')
            {
              str5 = str4.substring(4);
            }
            else if (c == 'f')
            {
              str5 = str4.substring(3);
            }
            else
            {
              if ((str4.length() < 5) || (!Character.isUpperCase(str4.charAt(4)))) {
                break;
              }
              str5 = TypeUtils.decapitalize(str4.substring(3));
            }
          }
          label992:
          localDeserializeBeanInfo.add(new FieldInfo(str5, localMethod3, null, paramClass, paramType, i15, i16));
          TypeUtils.setAccessible(localMethod3);
        }
      }
    }
    label1023:
    Field[] arrayOfField = paramClass.getFields();
    int i8 = arrayOfField.length;
    int i9 = 0;
    if (i9 < i8)
    {
      Field localField3 = arrayOfField[i9];
      if (Modifier.isStatic(localField3.getModifiers())) {}
      for (;;)
      {
        i9++;
        break;
        Iterator localIterator = localDeserializeBeanInfo.getFieldList().iterator();
        int i12 = 0;
        while (localIterator.hasNext()) {
          if (((FieldInfo)localIterator.next()).getName().equals(localField3.getName())) {
            i12 = 1;
          }
        }
        if (i12 == 0)
        {
          String str3 = localField3.getName();
          JSONField localJSONField4 = (JSONField)localField3.getAnnotation(JSONField.class);
          int i13 = 0;
          int i14 = 0;
          if (localJSONField4 != null)
          {
            i13 = localJSONField4.ordinal();
            i14 = SerializerFeature.of(localJSONField4.serialzeFeatures());
            if (localJSONField4.name().length() != 0) {
              str3 = localJSONField4.name();
            }
          }
          localDeserializeBeanInfo.add(new FieldInfo(str3, null, localField3, paramClass, paramType, i13, i14));
        }
      }
    }
    Method[] arrayOfMethod2 = paramClass.getMethods();
    int i10 = arrayOfMethod2.length;
    int i11 = 0;
    if (i11 < i10)
    {
      Method localMethod2 = arrayOfMethod2[i11];
      String str1 = localMethod2.getName();
      if (str1.length() < 4) {}
      while ((Modifier.isStatic(localMethod2.getModifiers())) || (!str1.startsWith("get")) || (!Character.isUpperCase(str1.charAt(3))) || (localMethod2.getParameterTypes().length != 0) || ((!Collection.class.isAssignableFrom(localMethod2.getReturnType())) && (!Map.class.isAssignableFrom(localMethod2.getReturnType()))))
      {
        i11++;
        break;
      }
      JSONField localJSONField3 = (JSONField)localMethod2.getAnnotation(JSONField.class);
      if ((localJSONField3 != null) && (localJSONField3.name().length() > 0)) {}
      for (String str2 = localJSONField3.name();; str2 = Character.toLowerCase(str1.charAt(3)) + str1.substring(4))
      {
        localDeserializeBeanInfo.add(new FieldInfo(str2, localMethod2, null, paramClass, paramType));
        TypeUtils.setAccessible(localMethod2);
        break;
      }
    }
    return localDeserializeBeanInfo;
  }
  
  public static Constructor<?> getCreatorConstructor(Class<?> paramClass)
  {
    for (Constructor localConstructor : paramClass.getDeclaredConstructors()) {
      if ((JSONCreator)localConstructor.getAnnotation(JSONCreator.class) != null)
      {
        if (0 != 0) {
          throw new JSONException("multi-json creator");
        }
        return localConstructor;
      }
    }
    return null;
  }
  
  public static Constructor<?> getDefaultConstructor(Class<?> paramClass)
  {
    boolean bool = Modifier.isAbstract(paramClass.getModifiers());
    Constructor<?> localConstructor = null;
    if (bool) {
      return localConstructor;
    }
    Constructor[] arrayOfConstructor1 = paramClass.getDeclaredConstructors();
    int i = arrayOfConstructor1.length;
    int j = 0;
    label28:
    Constructor localConstructor1;
    if (j < i)
    {
      localConstructor1 = arrayOfConstructor1[j];
      if (localConstructor1.getParameterTypes().length != 0) {}
    }
    for (;;)
    {
      if ((localConstructor1 == null) && (paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers())))
      {
        Constructor[] arrayOfConstructor2 = paramClass.getDeclaredConstructors();
        int k = arrayOfConstructor2.length;
        int m = 0;
        for (;;)
        {
          if (m < k)
          {
            localConstructor = arrayOfConstructor2[m];
            if ((localConstructor.getParameterTypes().length == 1) && (localConstructor.getParameterTypes()[0].equals(paramClass.getDeclaringClass()))) {
              break;
            }
            m++;
            continue;
            j++;
            break label28;
          }
        }
      }
      return localConstructor1;
      localConstructor1 = null;
    }
  }
  
  public static Method getFactoryMethod(Class<?> paramClass)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    if (j < i)
    {
      Method localMethod = arrayOfMethod[j];
      if (!Modifier.isStatic(localMethod.getModifiers())) {}
      while ((!paramClass.isAssignableFrom(localMethod.getReturnType())) || ((JSONCreator)localMethod.getAnnotation(JSONCreator.class) == null))
      {
        j++;
        break;
      }
      if (0 != 0) {
        throw new JSONException("multi-json creator");
      }
      return localMethod;
    }
    return null;
  }
  
  public boolean add(FieldInfo paramFieldInfo)
  {
    Iterator localIterator = this.fieldList.iterator();
    while (localIterator.hasNext())
    {
      FieldInfo localFieldInfo = (FieldInfo)localIterator.next();
      if ((localFieldInfo.getName().equals(paramFieldInfo.getName())) && ((!localFieldInfo.isGetOnly()) || (paramFieldInfo.isGetOnly()))) {
        return false;
      }
    }
    this.fieldList.add(paramFieldInfo);
    this.sortedFieldList.add(paramFieldInfo);
    Collections.sort(this.sortedFieldList);
    return true;
  }
  
  public Constructor<?> getCreatorConstructor()
  {
    return this.creatorConstructor;
  }
  
  public Constructor<?> getDefaultConstructor()
  {
    return this.defaultConstructor;
  }
  
  public Method getFactoryMethod()
  {
    return this.factoryMethod;
  }
  
  public List<FieldInfo> getFieldList()
  {
    return this.fieldList;
  }
  
  public int getParserFeatures()
  {
    return this.parserFeatures;
  }
  
  public List<FieldInfo> getSortedFieldList()
  {
    return this.sortedFieldList;
  }
  
  public void setCreatorConstructor(Constructor<?> paramConstructor)
  {
    this.creatorConstructor = paramConstructor;
  }
  
  public void setDefaultConstructor(Constructor<?> paramConstructor)
  {
    this.defaultConstructor = paramConstructor;
  }
  
  public void setFactoryMethod(Method paramMethod)
  {
    this.factoryMethod = paramMethod;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.util.DeserializeBeanInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */