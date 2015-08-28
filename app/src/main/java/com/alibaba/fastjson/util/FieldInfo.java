package com.alibaba.fastjson.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo
  implements Comparable<FieldInfo>
{
  private final Class<?> declaringClass;
  private final Field field;
  private final Class<?> fieldClass;
  private final Type fieldType;
  private boolean getOnly = false;
  private final Method method;
  private final String name;
  private int ordinal = 0;
  
  public FieldInfo(String paramString, Class<?> paramClass1, Class<?> paramClass2, Type paramType, Field paramField, int paramInt1, int paramInt2)
  {
    this.name = paramString;
    this.declaringClass = paramClass1;
    this.fieldClass = paramClass2;
    this.fieldType = paramType;
    this.method = null;
    this.field = paramField;
    this.ordinal = paramInt1;
    if (paramField != null) {
      TypeUtils.setAccessible(paramField);
    }
  }
  
  public FieldInfo(String paramString, Method paramMethod, Field paramField)
  {
    this(paramString, paramMethod, paramField, null, null);
  }
  
  public FieldInfo(String paramString, Method paramMethod, Field paramField, int paramInt1, int paramInt2)
  {
    this(paramString, paramMethod, paramField, null, null, paramInt1, paramInt2);
  }
  
  public FieldInfo(String paramString, Method paramMethod, Field paramField, Class<?> paramClass, Type paramType)
  {
    this(paramString, paramMethod, paramField, paramClass, paramType, 0, 0);
  }
  
  public FieldInfo(String paramString, Method paramMethod, Field paramField, Class<?> paramClass, Type paramType, int paramInt1, int paramInt2)
  {
    this.name = paramString;
    this.method = paramMethod;
    this.field = paramField;
    this.ordinal = paramInt1;
    if (paramMethod != null) {
      TypeUtils.setAccessible(paramMethod);
    }
    if (paramField != null) {
      TypeUtils.setAccessible(paramField);
    }
    Class localClass3;
    Type localType1;
    Class localClass1;
    if (paramMethod != null) {
      if (paramMethod.getParameterTypes().length == 1)
      {
        localClass3 = paramMethod.getParameterTypes()[0];
        localType1 = paramMethod.getGenericParameterTypes()[0];
        this.declaringClass = paramMethod.getDeclaringClass();
        localClass1 = localClass3;
      }
    }
    for (;;)
    {
      if ((paramClass == null) || (localClass1 != Object.class) || (!(localType1 instanceof TypeVariable))) {
        break label188;
      }
      Type localType3 = getInheritGenericType(paramClass, (TypeVariable)localType1);
      if (localType3 == null) {
        break label188;
      }
      this.fieldClass = TypeUtils.getClass(localType3);
      this.fieldType = localType3;
      return;
      localClass3 = paramMethod.getReturnType();
      localType1 = paramMethod.getGenericReturnType();
      this.getOnly = true;
      break;
      localClass1 = paramField.getType();
      localType1 = paramField.getGenericType();
      this.declaringClass = paramField.getDeclaringClass();
    }
    label188:
    Type localType2 = getFieldType(paramClass, paramType, localType1);
    Class localClass2;
    if (localType2 != localType1) {
      if ((localType2 instanceof ParameterizedType)) {
        localClass2 = TypeUtils.getClass(localType2);
      }
    }
    for (;;)
    {
      this.fieldType = localType2;
      this.fieldClass = localClass2;
      return;
      if ((localType2 instanceof Class)) {
        localClass2 = TypeUtils.getClass(localType2);
      } else {
        localClass2 = localClass1;
      }
    }
  }
  
  public static Type getFieldType(Class<?> paramClass, Type paramType1, Type paramType2)
  {
    if ((paramClass == null) || (paramType1 == null)) {}
    do
    {
      do
      {
        Type localType2;
        Type localType3;
        do
        {
          return paramType2;
          if (!(paramType2 instanceof GenericArrayType)) {
            break;
          }
          localType2 = ((GenericArrayType)paramType2).getGenericComponentType();
          localType3 = getFieldType(paramClass, paramType1, localType2);
        } while (localType2 == localType3);
        return Array.newInstance(TypeUtils.getClass(localType3), 0).getClass();
      } while (!TypeUtils.isGenericParamType(paramType1));
      if ((paramType2 instanceof TypeVariable))
      {
        ParameterizedType localParameterizedType3 = (ParameterizedType)TypeUtils.getGenericParamType(paramType1);
        Class localClass = TypeUtils.getClass(localParameterizedType3);
        TypeVariable localTypeVariable2 = (TypeVariable)paramType2;
        for (int i1 = 0; i1 < localClass.getTypeParameters().length; i1++) {
          if (localClass.getTypeParameters()[i1].getName().equals(localTypeVariable2.getName())) {
            return localParameterizedType3.getActualTypeArguments()[i1];
          }
        }
      }
    } while (!(paramType2 instanceof ParameterizedType));
    ParameterizedType localParameterizedType1 = (ParameterizedType)paramType2;
    Type[] arrayOfType = localParameterizedType1.getActualTypeArguments();
    int i = 0;
    int j = 0;
    label176:
    int m;
    if (i < arrayOfType.length)
    {
      Type localType1 = arrayOfType[i];
      if (!(localType1 instanceof TypeVariable)) {
        break label326;
      }
      TypeVariable localTypeVariable1 = (TypeVariable)localType1;
      if (!(paramType1 instanceof ParameterizedType)) {
        break label326;
      }
      ParameterizedType localParameterizedType2 = (ParameterizedType)paramType1;
      m = j;
      for (int n = 0; n < paramClass.getTypeParameters().length; n++) {
        if (paramClass.getTypeParameters()[n].getName().equals(localTypeVariable1.getName()))
        {
          arrayOfType[i] = localParameterizedType2.getActualTypeArguments()[n];
          m = 1;
        }
      }
    }
    label326:
    for (int k = m;; k = j)
    {
      i++;
      j = k;
      break label176;
      if (j == 0) {
        break;
      }
      return new ParameterizedTypeImpl(arrayOfType, localParameterizedType1.getOwnerType(), localParameterizedType1.getRawType());
    }
  }
  
  public static Type getInheritGenericType(Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    GenericDeclaration localGenericDeclaration = paramTypeVariable.getGenericDeclaration();
    Type localType;
    do
    {
      localType = paramClass.getGenericSuperclass();
      if (localType == null) {
        return null;
      }
      if ((localType instanceof ParameterizedType))
      {
        ParameterizedType localParameterizedType = (ParameterizedType)localType;
        if (localParameterizedType.getRawType() == localGenericDeclaration)
        {
          TypeVariable[] arrayOfTypeVariable = localGenericDeclaration.getTypeParameters();
          Type[] arrayOfType = localParameterizedType.getActualTypeArguments();
          for (int i = 0; i < arrayOfTypeVariable.length; i++) {
            if (arrayOfTypeVariable[i] == paramTypeVariable) {
              return arrayOfType[i];
            }
          }
          return null;
        }
      }
      paramClass = TypeUtils.getClass(localType);
    } while (localType != null);
    return null;
  }
  
  public int compareTo(FieldInfo paramFieldInfo)
  {
    if (this.ordinal < paramFieldInfo.ordinal) {
      return -1;
    }
    if (this.ordinal > paramFieldInfo.ordinal) {
      return 1;
    }
    return this.name.compareTo(paramFieldInfo.name);
  }
  
  public String gerQualifiedName()
  {
    Member localMember = getMember();
    return localMember.getDeclaringClass().getName() + "." + localMember.getName();
  }
  
  public Object get(Object paramObject)
  {
    if (this.method != null) {
      return this.method.invoke(paramObject, new Object[0]);
    }
    return this.field.get(paramObject);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Method localMethod = this.method;
    Annotation localAnnotation = null;
    if (localMethod != null) {
      localAnnotation = this.method.getAnnotation(paramClass);
    }
    if ((localAnnotation == null) && (this.field != null)) {
      localAnnotation = this.field.getAnnotation(paramClass);
    }
    return localAnnotation;
  }
  
  public Class<?> getDeclaringClass()
  {
    return this.declaringClass;
  }
  
  public Field getField()
  {
    return this.field;
  }
  
  public Class<?> getFieldClass()
  {
    return this.fieldClass;
  }
  
  public Type getFieldType()
  {
    return this.fieldType;
  }
  
  public Member getMember()
  {
    if (this.method != null) {
      return this.method;
    }
    return this.field;
  }
  
  public Method getMethod()
  {
    return this.method;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isGetOnly()
  {
    return this.getOnly;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    if (this.method != null)
    {
      this.method.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    this.field.set(paramObject1, paramObject2);
  }
  
  public void setAccessible(boolean paramBoolean)
  {
    if (this.method != null)
    {
      TypeUtils.setAccessible(this.method);
      return;
    }
    TypeUtils.setAccessible(this.field);
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.util.FieldInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */