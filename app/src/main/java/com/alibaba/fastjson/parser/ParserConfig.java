package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.BooleanFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.CharArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.ClassDerializer;
import com.alibaba.fastjson.parser.deserializer.CollectionDeserializer;
import com.alibaba.fastjson.parser.deserializer.DateDeserializer;
import com.alibaba.fastjson.parser.deserializer.DateFormatDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.IntegerFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.LongFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.StringFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimestampDeserializer;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CharsetCodec;
import com.alibaba.fastjson.serializer.CurrencyCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.InetAddressCodec;
import com.alibaba.fastjson.serializer.InetSocketAddressCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LocaleCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.PatternCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.serializer.TimeZoneCodec;
import com.alibaba.fastjson.serializer.URICodec;
import com.alibaba.fastjson.serializer.URLCodec;
import com.alibaba.fastjson.serializer.UUIDCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class ParserConfig
{
  private static ParserConfig global = new ParserConfig();
  private final IdentityHashMap<Type, ObjectDeserializer> derializers = new IdentityHashMap();
  private final Set<Class<?>> primitiveClasses = new HashSet();
  protected final SymbolTable symbolTable = new SymbolTable();
  
  public ParserConfig()
  {
    this.primitiveClasses.add(Boolean.TYPE);
    this.primitiveClasses.add(Boolean.class);
    this.primitiveClasses.add(Character.TYPE);
    this.primitiveClasses.add(Character.class);
    this.primitiveClasses.add(Byte.TYPE);
    this.primitiveClasses.add(Byte.class);
    this.primitiveClasses.add(Short.TYPE);
    this.primitiveClasses.add(Short.class);
    this.primitiveClasses.add(Integer.TYPE);
    this.primitiveClasses.add(Integer.class);
    this.primitiveClasses.add(Long.TYPE);
    this.primitiveClasses.add(Long.class);
    this.primitiveClasses.add(Float.TYPE);
    this.primitiveClasses.add(Float.class);
    this.primitiveClasses.add(Double.TYPE);
    this.primitiveClasses.add(Double.class);
    this.primitiveClasses.add(BigInteger.class);
    this.primitiveClasses.add(BigDecimal.class);
    this.primitiveClasses.add(String.class);
    this.primitiveClasses.add(java.util.Date.class);
    this.primitiveClasses.add(java.sql.Date.class);
    this.primitiveClasses.add(Time.class);
    this.primitiveClasses.add(Timestamp.class);
    this.derializers.put(SimpleDateFormat.class, DateFormatDeserializer.instance);
    this.derializers.put(Timestamp.class, TimestampDeserializer.instance);
    this.derializers.put(java.sql.Date.class, SqlDateDeserializer.instance);
    this.derializers.put(Time.class, TimeDeserializer.instance);
    this.derializers.put(java.util.Date.class, DateDeserializer.instance);
    this.derializers.put(Calendar.class, CalendarCodec.instance);
    this.derializers.put(JSONObject.class, JSONObjectDeserializer.instance);
    this.derializers.put(JSONArray.class, JSONArrayDeserializer.instance);
    this.derializers.put(Map.class, MapDeserializer.instance);
    this.derializers.put(HashMap.class, MapDeserializer.instance);
    this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
    this.derializers.put(TreeMap.class, MapDeserializer.instance);
    this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
    this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
    this.derializers.put(Collection.class, CollectionDeserializer.instance);
    this.derializers.put(List.class, CollectionDeserializer.instance);
    this.derializers.put(ArrayList.class, CollectionDeserializer.instance);
    this.derializers.put(Object.class, JavaObjectDeserializer.instance);
    this.derializers.put(String.class, StringCodec.instance);
    this.derializers.put(Character.TYPE, CharacterCodec.instance);
    this.derializers.put(Character.class, CharacterCodec.instance);
    this.derializers.put(Byte.TYPE, NumberDeserializer.instance);
    this.derializers.put(Byte.class, NumberDeserializer.instance);
    this.derializers.put(Short.TYPE, NumberDeserializer.instance);
    this.derializers.put(Short.class, NumberDeserializer.instance);
    this.derializers.put(Integer.TYPE, IntegerCodec.instance);
    this.derializers.put(Integer.class, IntegerCodec.instance);
    this.derializers.put(Long.TYPE, LongCodec.instance);
    this.derializers.put(Long.class, LongCodec.instance);
    this.derializers.put(BigInteger.class, BigIntegerCodec.instance);
    this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
    this.derializers.put(Float.TYPE, FloatCodec.instance);
    this.derializers.put(Float.class, FloatCodec.instance);
    this.derializers.put(Double.TYPE, NumberDeserializer.instance);
    this.derializers.put(Double.class, NumberDeserializer.instance);
    this.derializers.put(Boolean.TYPE, BooleanCodec.instance);
    this.derializers.put(Boolean.class, BooleanCodec.instance);
    this.derializers.put(Class.class, ClassDerializer.instance);
    this.derializers.put([C.class, CharArrayDeserializer.instance);
    this.derializers.put(UUID.class, UUIDCodec.instance);
    this.derializers.put(TimeZone.class, TimeZoneCodec.instance);
    this.derializers.put(Locale.class, LocaleCodec.instance);
    this.derializers.put(Currency.class, CurrencyCodec.instance);
    this.derializers.put(InetAddress.class, InetAddressCodec.instance);
    this.derializers.put(Inet4Address.class, InetAddressCodec.instance);
    this.derializers.put(Inet6Address.class, InetAddressCodec.instance);
    this.derializers.put(InetSocketAddress.class, InetSocketAddressCodec.instance);
    this.derializers.put(URI.class, URICodec.instance);
    this.derializers.put(URL.class, URLCodec.instance);
    this.derializers.put(Pattern.class, PatternCodec.instance);
    this.derializers.put(Charset.class, CharsetCodec.instance);
    this.derializers.put(Number.class, NumberDeserializer.instance);
    this.derializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
    this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    Field localField = getField0(paramClass, paramString);
    if (localField == null) {
      localField = getField0(paramClass, "_" + paramString);
    }
    if (localField == null) {
      localField = getField0(paramClass, "m_" + paramString);
    }
    return localField;
  }
  
  private static Field getField0(Class<?> paramClass, String paramString)
  {
    for (Field localField : paramClass.getDeclaredFields()) {
      if (paramString.equals(localField.getName())) {
        return localField;
      }
    }
    if ((paramClass.getSuperclass() != null) && (paramClass.getSuperclass() != Object.class)) {
      return getField(paramClass.getSuperclass(), paramString);
    }
    return null;
  }
  
  public static ParserConfig getGlobalInstance()
  {
    return global;
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    Class localClass = paramFieldInfo.getFieldClass();
    if ((localClass == Boolean.TYPE) || (localClass == Boolean.class)) {
      return new BooleanFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    }
    if ((localClass == Integer.TYPE) || (localClass == Integer.class)) {
      return new IntegerFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    }
    if ((localClass == Long.TYPE) || (localClass == Long.class)) {
      return new LongFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    }
    if (localClass == String.class) {
      return new StringFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    }
    if ((localClass == List.class) || (localClass == ArrayList.class)) {
      return new ArrayListTypeFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    }
    return new DefaultFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(Class<?> paramClass, Type paramType)
  {
    return new JavaBeanDeserializer(this, paramClass, paramType);
  }
  
  public IdentityHashMap<Type, ObjectDeserializer> getDerializers()
  {
    return this.derializers;
  }
  
  public ObjectDeserializer getDeserializer(FieldInfo paramFieldInfo)
  {
    return getDeserializer(paramFieldInfo.getFieldClass(), paramFieldInfo.getFieldType());
  }
  
  public ObjectDeserializer getDeserializer(Class<?> paramClass, Type paramType)
  {
    ObjectDeserializer localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObjectDeserializer != null) {}
    do
    {
      do
      {
        do
        {
          return localObjectDeserializer;
          if (paramType == null) {
            paramType = paramClass;
          }
          localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramType);
        } while (localObjectDeserializer != null);
        JSONType localJSONType = (JSONType)paramClass.getAnnotation(JSONType.class);
        if (localJSONType != null)
        {
          Class localClass = localJSONType.mappingTo();
          if (localClass != Void.class) {
            return getDeserializer(localClass, localClass);
          }
        }
        if (((paramType instanceof WildcardType)) || ((paramType instanceof TypeVariable)) || ((paramType instanceof ParameterizedType))) {
          localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramClass);
        }
      } while (localObjectDeserializer != null);
      localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramType);
    } while (localObjectDeserializer != null);
    Object localObject;
    if (paramClass.isEnum()) {
      localObject = new EnumDeserializer(paramClass);
    }
    for (;;)
    {
      putDeserializer(paramType, (ObjectDeserializer)localObject);
      return localObject;
      if (paramClass.isArray()) {
        localObject = ArrayDeserializer.instance;
      } else if ((paramClass == Set.class) || (paramClass == HashSet.class) || (paramClass == Collection.class) || (paramClass == List.class) || (paramClass == ArrayList.class)) {
        localObject = CollectionDeserializer.instance;
      } else if (Collection.class.isAssignableFrom(paramClass)) {
        localObject = CollectionDeserializer.instance;
      } else if (Map.class.isAssignableFrom(paramClass)) {
        localObject = MapDeserializer.instance;
      } else if (Throwable.class.isAssignableFrom(paramClass)) {
        localObject = new ThrowableDeserializer(this, paramClass);
      } else {
        localObject = createJavaBeanDeserializer(paramClass, paramType);
      }
    }
  }
  
  public ObjectDeserializer getDeserializer(Type paramType)
  {
    ObjectDeserializer localObjectDeserializer = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObjectDeserializer != null) {
      return localObjectDeserializer;
    }
    if ((paramType instanceof Class)) {
      return getDeserializer((Class)paramType, paramType);
    }
    if ((paramType instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)paramType).getRawType();
      if ((localType instanceof Class)) {
        return getDeserializer((Class)localType, paramType);
      }
      return getDeserializer(localType);
    }
    return JavaObjectDeserializer.instance;
  }
  
  public Map<String, FieldDeserializer> getFieldDeserializers(Class<?> paramClass)
  {
    ObjectDeserializer localObjectDeserializer = getDeserializer(paramClass);
    if ((localObjectDeserializer instanceof JavaBeanDeserializer)) {
      return ((JavaBeanDeserializer)localObjectDeserializer).getFieldDeserializerMap();
    }
    return Collections.emptyMap();
  }
  
  public SymbolTable getSymbolTable()
  {
    return this.symbolTable;
  }
  
  public boolean isPrimitive(Class<?> paramClass)
  {
    return this.primitiveClasses.contains(paramClass);
  }
  
  public void putDeserializer(Type paramType, ObjectDeserializer paramObjectDeserializer)
  {
    this.derializers.put(paramType, paramObjectDeserializer);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.ParserConfig
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */