package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeUtils
{
  public static boolean compatibleWithJavaBean = false;
  private static ConcurrentMap<String, Class<?>> mappings;
  private static boolean setAccessibleEnable = true;
  
  static
  {
    mappings = new ConcurrentHashMap();
    addBaseClassMappings();
  }
  
  public static void addBaseClassMappings()
  {
    mappings.put("byte", Byte.TYPE);
    mappings.put("short", Short.TYPE);
    mappings.put("int", Integer.TYPE);
    mappings.put("long", Long.TYPE);
    mappings.put("float", Float.TYPE);
    mappings.put("double", Double.TYPE);
    mappings.put("boolean", Boolean.TYPE);
    mappings.put("char", Character.TYPE);
    mappings.put("[byte", [B.class);
    mappings.put("[short", [S.class);
    mappings.put("[int", [I.class);
    mappings.put("[long", [J.class);
    mappings.put("[float", [F.class);
    mappings.put("[double", [D.class);
    mappings.put("[boolean", [Z.class);
    mappings.put("[char", [C.class);
    mappings.put(HashMap.class.getName(), HashMap.class);
  }
  
  public static void addClassMapping(String paramString, Class<?> paramClass)
  {
    if (paramString == null) {
      paramString = paramClass.getName();
    }
    mappings.put(paramString, paramClass);
  }
  
  public static final <T> T cast(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      Map localMap;
      do
      {
        do
        {
          do
          {
            return paramObject;
            if (paramClass == null) {
              throw new IllegalArgumentException("clazz is null");
            }
          } while (paramClass == paramObject.getClass());
          if (!(paramObject instanceof Map)) {
            break;
          }
        } while (paramClass == Map.class);
        localMap = (Map)paramObject;
      } while ((paramClass == Object.class) && (!localMap.containsKey(JSON.DEFAULT_TYPE_KEY)));
      return castToJavaBean((Map)paramObject, paramClass, paramParserConfig);
      if (paramClass.isArray())
      {
        if ((paramObject instanceof Collection))
        {
          Collection localCollection = (Collection)paramObject;
          int i = 0;
          Object localObject = Array.newInstance(paramClass.getComponentType(), localCollection.size());
          Iterator localIterator = localCollection.iterator();
          while (localIterator.hasNext())
          {
            Array.set(localObject, i, cast(localIterator.next(), paramClass.getComponentType(), paramParserConfig));
            i++;
          }
          return localObject;
        }
        if (paramClass == [B.class) {
          return castToBytes(paramObject);
        }
      }
    } while (paramClass.isAssignableFrom(paramObject.getClass()));
    if ((paramClass == Boolean.TYPE) || (paramClass == Boolean.class)) {
      return castToBoolean(paramObject);
    }
    if ((paramClass == Byte.TYPE) || (paramClass == Byte.class)) {
      return castToByte(paramObject);
    }
    if ((paramClass == Short.TYPE) || (paramClass == Short.class)) {
      return castToShort(paramObject);
    }
    if ((paramClass == Integer.TYPE) || (paramClass == Integer.class)) {
      return castToInt(paramObject);
    }
    if ((paramClass == Long.TYPE) || (paramClass == Long.class)) {
      return castToLong(paramObject);
    }
    if ((paramClass == Float.TYPE) || (paramClass == Float.class)) {
      return castToFloat(paramObject);
    }
    if ((paramClass == Double.TYPE) || (paramClass == Double.class)) {
      return castToDouble(paramObject);
    }
    if (paramClass == String.class) {
      return castToString(paramObject);
    }
    if (paramClass == BigDecimal.class) {
      return castToBigDecimal(paramObject);
    }
    if (paramClass == BigInteger.class) {
      return castToBigInteger(paramObject);
    }
    if (paramClass == java.util.Date.class) {
      return castToDate(paramObject);
    }
    if (paramClass == java.sql.Date.class) {
      return castToSqlDate(paramObject);
    }
    if (paramClass == Timestamp.class) {
      return castToTimestamp(paramObject);
    }
    if (paramClass.isEnum()) {
      return castToEnum(paramObject, paramClass, paramParserConfig);
    }
    if (Calendar.class.isAssignableFrom(paramClass))
    {
      java.util.Date localDate = castToDate(paramObject);
      Calendar localCalendar;
      if (paramClass == Calendar.class) {
        localCalendar = Calendar.getInstance();
      }
      for (;;)
      {
        localCalendar.setTime(localDate);
        return localCalendar;
        try
        {
          localCalendar = (Calendar)paramClass.newInstance();
        }
        catch (Exception localException)
        {
          throw new JSONException("can not cast to : " + paramClass.getName(), localException);
        }
      }
    }
    if (((paramObject instanceof String)) && (((String)paramObject).length() == 0)) {
      return null;
    }
    throw new JSONException("can not cast to : " + paramClass.getName());
  }
  
  public static final <T> T cast(Object paramObject, ParameterizedType paramParameterizedType, ParserConfig paramParserConfig)
  {
    Type localType1 = paramParameterizedType.getRawType();
    Object localObject;
    if ((localType1 == Set.class) || (localType1 == HashSet.class) || (localType1 == TreeSet.class) || (localType1 == List.class) || (localType1 == ArrayList.class))
    {
      Type localType2 = paramParameterizedType.getActualTypeArguments()[0];
      if ((paramObject instanceof Iterable))
      {
        if ((localType1 == Set.class) || (localType1 == HashSet.class)) {
          localObject = new HashSet();
        }
        for (;;)
        {
          Iterator localIterator2 = ((Iterable)paramObject).iterator();
          while (localIterator2.hasNext()) {
            ((Collection)localObject).add(cast(localIterator2.next(), localType2, paramParserConfig));
          }
          if (localType1 == TreeSet.class) {
            localObject = new TreeSet();
          } else {
            localObject = new ArrayList();
          }
        }
      }
    }
    if ((localType1 == Map.class) || (localType1 == HashMap.class))
    {
      Type localType3 = paramParameterizedType.getActualTypeArguments()[0];
      Type localType4 = paramParameterizedType.getActualTypeArguments()[1];
      if ((paramObject instanceof Map))
      {
        HashMap localHashMap = new HashMap();
        Iterator localIterator1 = ((Map)paramObject).entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          localHashMap.put(cast(localEntry.getKey(), localType3, paramParserConfig), cast(localEntry.getValue(), localType4, paramParserConfig));
        }
        localObject = localHashMap;
        return localObject;
      }
    }
    if (((paramObject instanceof String)) && (((String)paramObject).length() == 0)) {
      return null;
    }
    if ((paramParameterizedType.getActualTypeArguments().length == 1) && ((paramParameterizedType.getActualTypeArguments()[0] instanceof WildcardType))) {
      return cast(paramObject, localType1, paramParserConfig);
    }
    throw new JSONException("can not cast to : " + paramParameterizedType);
  }
  
  public static final <T> T cast(Object paramObject, Type paramType, ParserConfig paramParserConfig)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      return paramObject;
      if ((paramType instanceof Class)) {
        return cast(paramObject, (Class)paramType, paramParserConfig);
      }
      if ((paramType instanceof ParameterizedType)) {
        return cast(paramObject, (ParameterizedType)paramType, paramParserConfig);
      }
      if (((paramObject instanceof String)) && (((String)paramObject).length() == 0)) {
        return null;
      }
    } while ((paramType instanceof TypeVariable));
    throw new JSONException("can not cast to : " + paramType);
  }
  
  public static final BigDecimal castToBigDecimal(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof BigDecimal)) {
      return (BigDecimal)paramObject;
    }
    if ((paramObject instanceof BigInteger)) {
      return new BigDecimal((BigInteger)paramObject);
    }
    String str = paramObject.toString();
    if (str.length() == 0) {
      return null;
    }
    return new BigDecimal(str);
  }
  
  public static final BigInteger castToBigInteger(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof BigInteger)) {
      return (BigInteger)paramObject;
    }
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double))) {
      return BigInteger.valueOf(((Number)paramObject).longValue());
    }
    String str = paramObject.toString();
    if (str.length() == 0) {
      return null;
    }
    return new BigInteger(str);
  }
  
  public static final Boolean castToBoolean(Object paramObject)
  {
    int i = 1;
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof Number))
    {
      if (((Number)paramObject).intValue() == i) {}
      for (;;)
      {
        return Boolean.valueOf(i);
        int j = 0;
      }
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if (str.length() == 0) {
        return null;
      }
      if ("true".equalsIgnoreCase(str)) {
        return Boolean.TRUE;
      }
      if ("false".equalsIgnoreCase(str)) {
        return Boolean.FALSE;
      }
      if ("1".equals(str)) {
        return Boolean.TRUE;
      }
      if ("0".equals(str)) {
        return Boolean.FALSE;
      }
      if ("null".equals(str)) {
        return null;
      }
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final Byte castToByte(Object paramObject)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Byte.valueOf(((Number)paramObject).byteValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
    } while ((str.length() == 0) || ("null".equals(str)));
    return Byte.valueOf(Byte.parseByte(str));
    throw new JSONException("can not cast to byte, value : " + paramObject);
  }
  
  public static final byte[] castToBytes(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return (byte[])paramObject;
    }
    if ((paramObject instanceof String)) {
      return Base64.decodeFast((String)paramObject);
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final Character castToChar(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Character)) {
      return (Character)paramObject;
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if (str.length() == 0) {
        return null;
      }
      if (str.length() != 1) {
        throw new JSONException("can not cast to byte, value : " + paramObject);
      }
      return Character.valueOf(str.charAt(0));
    }
    throw new JSONException("can not cast to byte, value : " + paramObject);
  }
  
  public static final java.util.Date castToDate(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Calendar)) {
      return ((Calendar)paramObject).getTime();
    }
    if ((paramObject instanceof java.util.Date)) {
      return (java.util.Date)paramObject;
    }
    long l = -1L;
    if ((paramObject instanceof Number)) {
      l = ((Number)paramObject).longValue();
    }
    if ((paramObject instanceof String))
    {
      String str1 = (String)paramObject;
      if (str1.indexOf('-') != -1)
      {
        String str2;
        if (str1.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
          str2 = JSON.DEFFAULT_DATE_FORMAT;
        }
        for (;;)
        {
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(str2);
          try
          {
            java.util.Date localDate = localSimpleDateFormat.parse(str1);
            return localDate;
          }
          catch (ParseException localParseException)
          {
            throw new JSONException("can not cast to Date, value : " + str1);
          }
          if (str1.length() == 10) {
            str2 = "yyyy-MM-dd";
          } else if (str1.length() == "yyyy-MM-dd HH:mm:ss".length()) {
            str2 = "yyyy-MM-dd HH:mm:ss";
          } else {
            str2 = "yyyy-MM-dd HH:mm:ss.SSS";
          }
        }
      }
      if (str1.length() == 0) {
        return null;
      }
      l = Long.parseLong(str1);
    }
    if (l < 0L) {
      throw new JSONException("can not cast to Date, value : " + paramObject);
    }
    return new java.util.Date(l);
  }
  
  public static final Double castToDouble(Object paramObject)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Double.valueOf(((Number)paramObject).doubleValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      str = paramObject.toString();
    } while ((str.length() == 0) || ("null".equals(str)));
    return Double.valueOf(Double.parseDouble(str));
    throw new JSONException("can not cast to double, value : " + paramObject);
  }
  
  public static final <T> T castToEnum(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    int i = 0;
    Enum localEnum;
    try
    {
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if (str.length() == 0) {
          return null;
        }
        return Enum.valueOf(paramClass, str);
      }
      if ((paramObject instanceof Number))
      {
        int j = ((Number)paramObject).intValue();
        Object[] arrayOfObject = (Object[])paramClass.getMethod("values", new Class[0]).invoke(null, new Object[0]);
        int k = arrayOfObject.length;
        while (i < k)
        {
          localEnum = (Enum)arrayOfObject[i];
          int m = localEnum.ordinal();
          if (m == j) {
            break label181;
          }
          i++;
        }
      }
      throw new JSONException("can not cast to : " + paramClass.getName());
    }
    catch (Exception localException)
    {
      throw new JSONException("can not cast to : " + paramClass.getName(), localException);
    }
    label181:
    return localEnum;
  }
  
  public static final Float castToFloat(Object paramObject)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Float.valueOf(((Number)paramObject).floatValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      str = paramObject.toString();
    } while ((str.length() == 0) || ("null".equals(str)));
    return Float.valueOf(Float.parseFloat(str));
    throw new JSONException("can not cast to float, value : " + paramObject);
  }
  
  public static final Integer castToInt(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String))
    {
      String str = (String)paramObject;
      if (str.length() == 0) {
        return null;
      }
      if ("null".equals(str)) {
        return null;
      }
      return Integer.valueOf(Integer.parseInt(str));
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final <T> T castToJavaBean(Object paramObject, Class<T> paramClass)
  {
    return cast(paramObject, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static final <T> T castToJavaBean(Map<String, Object> paramMap, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    if (paramClass == StackTraceElement.class) {}
    Class localClass;
    try
    {
      String str1 = (String)paramMap.get("className");
      String str2 = (String)paramMap.get("methodName");
      String str3 = (String)paramMap.get("fileName");
      Number localNumber = (Number)paramMap.get("lineNumber");
      int i = 0;
      if (localNumber == null) {}
      for (;;)
      {
        return new StackTraceElement(str1, str2, str3, i);
        i = localNumber.intValue();
      }
      Object localObject1 = paramMap.get(JSON.DEFAULT_TYPE_KEY);
      if (!(localObject1 instanceof String)) {
        break label195;
      }
      String str5 = (String)localObject1;
      localClass = loadClass(str5);
      if (localClass == null) {
        throw new ClassNotFoundException(str5 + " not found");
      }
    }
    catch (Exception localException)
    {
      throw new JSONException(localException.getMessage(), localException);
    }
    if (!localClass.equals(paramClass)) {
      return castToJavaBean(paramMap, localClass, paramParserConfig);
    }
    label195:
    if (paramClass.isInterface())
    {
      if ((paramMap instanceof JSONObject)) {}
      for (JSONObject localJSONObject = (JSONObject)paramMap;; localJSONObject = new JSONObject(paramMap)) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { paramClass }, localJSONObject);
      }
    }
    if (paramParserConfig == null) {
      paramParserConfig = ParserConfig.getGlobalInstance();
    }
    Map localMap = paramParserConfig.getFieldDeserializers(paramClass);
    Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
    if (!localConstructor.isAccessible()) {
      localConstructor.setAccessible(true);
    }
    Object localObject2 = localConstructor.newInstance(new Object[0]);
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str4 = (String)localEntry.getKey();
      FieldDeserializer localFieldDeserializer = (FieldDeserializer)localEntry.getValue();
      if (paramMap.containsKey(str4))
      {
        Object localObject3 = paramMap.get(str4);
        Method localMethod = localFieldDeserializer.getMethod();
        if (localMethod != null)
        {
          localMethod.invoke(localObject2, new Object[] { cast(localObject3, localMethod.getGenericParameterTypes()[0], paramParserConfig) });
        }
        else
        {
          Field localField = localFieldDeserializer.getField();
          localField.set(localObject2, cast(localObject3, localField.getGenericType(), paramParserConfig));
        }
      }
    }
    return localObject2;
  }
  
  public static final Long castToLong(Object paramObject)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Long.valueOf(((Number)paramObject).longValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
    } while ((str.length() == 0) || ("null".equals(str)));
    JSONScanner localJSONScanner;
    try
    {
      Long localLong = Long.valueOf(Long.parseLong(str));
      return localLong;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localJSONScanner = new JSONScanner(str);
      if (!localJSONScanner.scanISO8601DateIfMatch(false)) {}
    }
    for (Calendar localCalendar = localJSONScanner.getCalendar();; localCalendar = null)
    {
      localJSONScanner.close();
      if (localCalendar != null) {
        return Long.valueOf(localCalendar.getTimeInMillis());
      }
      throw new JSONException("can not cast to long, value : " + paramObject);
    }
  }
  
  public static final Short castToShort(Object paramObject)
  {
    if (paramObject == null) {}
    String str;
    do
    {
      return null;
      if ((paramObject instanceof Number)) {
        return Short.valueOf(((Number)paramObject).shortValue());
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
    } while ((str.length() == 0) || ("null".equals(str)));
    return Short.valueOf(Short.parseShort(str));
    throw new JSONException("can not cast to short, value : " + paramObject);
  }
  
  public static final java.sql.Date castToSqlDate(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Calendar)) {
      return new java.sql.Date(((Calendar)paramObject).getTimeInMillis());
    }
    if ((paramObject instanceof java.sql.Date)) {
      return (java.sql.Date)paramObject;
    }
    if ((paramObject instanceof java.util.Date)) {
      return new java.sql.Date(((java.util.Date)paramObject).getTime());
    }
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if (str.length() == 0) {
          return null;
        }
        l = Long.parseLong(str);
      }
      if (l <= 0L) {
        throw new JSONException("can not cast to Date, value : " + paramObject);
      }
      return new java.sql.Date(l);
    }
  }
  
  public static final String castToString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return paramObject.toString();
  }
  
  public static final Timestamp castToTimestamp(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Calendar)) {
      return new Timestamp(((Calendar)paramObject).getTimeInMillis());
    }
    if ((paramObject instanceof Timestamp)) {
      return (Timestamp)paramObject;
    }
    if ((paramObject instanceof java.util.Date)) {
      return new Timestamp(((java.util.Date)paramObject).getTime());
    }
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if (str.length() == 0) {
          return null;
        }
        l = Long.parseLong(str);
      }
      if (l <= 0L) {
        throw new JSONException("can not cast to Date, value : " + paramObject);
      }
      return new Timestamp(l);
    }
  }
  
  public static void clearClassMapping()
  {
    mappings.clear();
    addBaseClassMappings();
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, Map<String, String> paramMap)
  {
    return computeGetters(paramClass, paramMap, true);
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, Map<String, String> paramMap, boolean paramBoolean)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Method[] arrayOfMethod = paramClass.getMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    if (j < i)
    {
      Method localMethod = arrayOfMethod[j];
      String str2 = localMethod.getName();
      if (Modifier.isStatic(localMethod.getModifiers())) {}
      int i7;
      int i8;
      label269:
      char c2;
      Object localObject3;
      label333:
      label478:
      label504:
      do
      {
        Field localField3;
        String str5;
        do
        {
          String str6;
          do
          {
            JSONField localJSONField4;
            do
            {
              do
              {
                for (;;)
                {
                  j++;
                  break;
                  if ((!localMethod.getReturnType().equals(Void.TYPE)) && (localMethod.getParameterTypes().length == 0) && (localMethod.getReturnType() != ClassLoader.class) && ((!localMethod.getName().equals("getMetaClass")) || (!localMethod.getReturnType().getName().equals("groovy.lang.MetaClass"))))
                  {
                    JSONField localJSONField2 = (JSONField)localMethod.getAnnotation(JSONField.class);
                    if (localJSONField2 == null) {
                      localJSONField2 = getSupperMethodAnnotation(paramClass, localMethod);
                    }
                    i7 = 0;
                    i8 = 0;
                    if (localJSONField2 == null) {
                      break label269;
                    }
                    if (localJSONField2.serialize())
                    {
                      i7 = localJSONField2.ordinal();
                      i8 = SerializerFeature.of(localJSONField2.serialzeFeatures());
                      if (localJSONField2.name().length() == 0) {
                        break label269;
                      }
                      Object localObject4 = localJSONField2.name();
                      if (paramMap != null)
                      {
                        String str7 = (String)paramMap.get(localObject4);
                        if (str7 != null) {
                          localObject4 = str7;
                        }
                      }
                      else
                      {
                        localLinkedHashMap.put(localObject4, new FieldInfo((String)localObject4, localMethod, null, i7, i8));
                      }
                    }
                  }
                }
                if (!str2.startsWith("get")) {
                  break label504;
                }
              } while ((str2.length() < 4) || (str2.equals("getClass")));
              c2 = str2.charAt(3);
              if (!Character.isUpperCase(c2)) {
                break label771;
              }
              if (!compatibleWithJavaBean) {
                break label735;
              }
              localObject3 = decapitalize(str2.substring(3));
              if (isJSONTypeIgnore(paramClass, (String)localObject3)) {
                break label840;
              }
              localField3 = ParserConfig.getField(paramClass, (String)localObject3);
              if (localField3 == null) {
                break label452;
              }
              localJSONField4 = (JSONField)localField3.getAnnotation(JSONField.class);
              if (localJSONField4 == null) {
                break label452;
              }
            } while (!localJSONField4.serialize());
            i7 = localJSONField4.ordinal();
            i8 = SerializerFeature.of(localJSONField4.serialzeFeatures());
            if (localJSONField4.name().length() == 0) {
              break label452;
            }
            localObject3 = localJSONField4.name();
            if (paramMap == null) {
              break label452;
            }
            str6 = (String)paramMap.get(localObject3);
          } while (str6 == null);
          localObject3 = str6;
          if (paramMap == null) {
            break label478;
          }
          str5 = (String)paramMap.get(localObject3);
        } while (str5 == null);
        localObject3 = str5;
        localLinkedHashMap.put(localObject3, new FieldInfo((String)localObject3, localMethod, localField3, i7, i8));
      } while ((!str2.startsWith("is")) || (str2.length() < 3));
      label452:
      char c1 = str2.charAt(2);
      Object localObject2;
      if (Character.isUpperCase(c1)) {
        if (compatibleWithJavaBean) {
          localObject2 = decapitalize(str2.substring(2));
        }
      }
      for (;;)
      {
        Field localField2 = ParserConfig.getField(paramClass, (String)localObject2);
        if (localField2 == null) {
          localField2 = ParserConfig.getField(paramClass, str2);
        }
        if (localField2 != null)
        {
          JSONField localJSONField3 = (JSONField)localField2.getAnnotation(JSONField.class);
          if (localJSONField3 != null)
          {
            if (!localJSONField3.serialize()) {
              break;
            }
            i7 = localJSONField3.ordinal();
            i8 = SerializerFeature.of(localJSONField3.serialzeFeatures());
            if (localJSONField3.name().length() != 0)
            {
              localObject2 = localJSONField3.name();
              if (paramMap != null)
              {
                String str4 = (String)paramMap.get(localObject2);
                if (str4 == null) {
                  break;
                }
                localObject2 = str4;
              }
            }
          }
        }
        if (paramMap != null)
        {
          String str3 = (String)paramMap.get(localObject2);
          if (str3 == null) {
            break;
          }
          localObject2 = str3;
        }
        localLinkedHashMap.put(localObject2, new FieldInfo((String)localObject2, localMethod, localField2, i7, i8));
        break;
        label735:
        localObject3 = Character.toLowerCase(str2.charAt(3)) + str2.substring(4);
        break label333;
        label771:
        if (c2 == '_')
        {
          localObject3 = str2.substring(4);
          break label333;
        }
        if (c2 == 'f')
        {
          localObject3 = str2.substring(3);
          break label333;
        }
        if ((str2.length() < 5) || (!Character.isUpperCase(str2.charAt(4)))) {
          break;
        }
        localObject3 = decapitalize(str2.substring(3));
        break label333;
        label840:
        break;
        localObject2 = Character.toLowerCase(str2.charAt(2)) + str2.substring(3);
        continue;
        if (c1 == '_')
        {
          localObject2 = str2.substring(3);
        }
        else
        {
          if (c1 != 'f') {
            break;
          }
          localObject2 = str2.substring(2);
        }
      }
    }
    Field[] arrayOfField = paramClass.getFields();
    int k = arrayOfField.length;
    int m = 0;
    if (m < k)
    {
      Field localField1 = arrayOfField[m];
      if (Modifier.isStatic(localField1.getModifiers())) {}
      for (;;)
      {
        m++;
        break;
        JSONField localJSONField1 = (JSONField)localField1.getAnnotation(JSONField.class);
        Object localObject1 = localField1.getName();
        int i5 = 0;
        int i6 = 0;
        if (localJSONField1 != null)
        {
          if (localJSONField1.serialize())
          {
            i5 = localJSONField1.ordinal();
            i6 = SerializerFeature.of(localJSONField1.serialzeFeatures());
            if (localJSONField1.name().length() != 0) {
              localObject1 = localJSONField1.name();
            }
          }
        }
        else if (paramMap != null)
        {
          String str1 = (String)paramMap.get(localObject1);
          if (str1 != null) {
            localObject1 = str1;
          }
        }
        else if (!localLinkedHashMap.containsKey(localObject1))
        {
          localLinkedHashMap.put(localObject1, new FieldInfo((String)localObject1, null, localField1, i5, i6));
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    JSONType localJSONType = (JSONType)paramClass.getAnnotation(JSONType.class);
    String[] arrayOfString2;
    int n;
    int i4;
    String[] arrayOfString1;
    if (localJSONType != null)
    {
      arrayOfString2 = localJSONType.orders();
      if ((arrayOfString2 != null) && (arrayOfString2.length == localLinkedHashMap.size()))
      {
        n = 1;
        int i3 = arrayOfString2.length;
        i4 = 0;
        if (i4 < i3)
        {
          if (!localLinkedHashMap.containsKey(arrayOfString2[i4])) {
            n = 0;
          }
        }
        else {
          arrayOfString1 = arrayOfString2;
        }
      }
    }
    for (;;)
    {
      if (n != 0)
      {
        int i1 = arrayOfString1.length;
        for (int i2 = 0; i2 < i1; i2++) {
          localArrayList.add((FieldInfo)localLinkedHashMap.get(arrayOfString1[i2]));
        }
        i4++;
        break;
        arrayOfString1 = arrayOfString2;
        n = 0;
        continue;
      }
      Iterator localIterator = localLinkedHashMap.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((FieldInfo)localIterator.next());
      }
      if (paramBoolean) {
        Collections.sort(localArrayList);
      }
      return localArrayList;
      n = 0;
      arrayOfString1 = null;
    }
  }
  
  public static String decapitalize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((paramString.length() > 1) && (Character.isUpperCase(paramString.charAt(1))) && (Character.isUpperCase(paramString.charAt(0)))) {
      return paramString;
    }
    char[] arrayOfChar = paramString.toCharArray();
    arrayOfChar[0] = Character.toLowerCase(arrayOfChar[0]);
    return new String(arrayOfChar);
  }
  
  public static Class<?> getClass(Type paramType)
  {
    if (paramType.getClass() == Class.class) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType)) {
      return getClass(((ParameterizedType)paramType).getRawType());
    }
    return Object.class;
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    for (Field localField : paramClass.getDeclaredFields()) {
      if (paramString.equals(localField.getName())) {
        return localField;
      }
    }
    Class localClass = paramClass.getSuperclass();
    if ((localClass != null) && (localClass != Object.class)) {
      return getField(localClass, paramString);
    }
    return null;
  }
  
  public static Type getGenericParamType(Type paramType)
  {
    if ((paramType instanceof ParameterizedType)) {}
    while (!(paramType instanceof Class)) {
      return paramType;
    }
    return getGenericParamType(((Class)paramType).getGenericSuperclass());
  }
  
  public static int getParserFeatures(Class<?> paramClass)
  {
    JSONType localJSONType = (JSONType)paramClass.getAnnotation(JSONType.class);
    if (localJSONType == null) {
      return 0;
    }
    return Feature.of(localJSONType.parseFeatures());
  }
  
  public static int getSerializeFeatures(Class<?> paramClass)
  {
    JSONType localJSONType = (JSONType)paramClass.getAnnotation(JSONType.class);
    if (localJSONType == null) {
      return 0;
    }
    return SerializerFeature.of(localJSONType.serialzeFeatures());
  }
  
  public static JSONField getSupperMethodAnnotation(Class<?> paramClass, Method paramMethod)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    int j = 0;
    int m;
    label34:
    Method localMethod;
    if (j < i)
    {
      Method[] arrayOfMethod = arrayOfClass[j].getMethods();
      int k = arrayOfMethod.length;
      m = 0;
      if (m < k)
      {
        localMethod = arrayOfMethod[m];
        if (localMethod.getName().equals(paramMethod.getName())) {}
      }
    }
    label165:
    for (;;)
    {
      label63:
      m++;
      break label34;
      if (localMethod.getParameterTypes().length == paramMethod.getParameterTypes().length)
      {
        int n = 0;
        label86:
        if (n < localMethod.getParameterTypes().length) {
          if (localMethod.getParameterTypes()[n].equals(paramMethod.getParameterTypes()[n])) {}
        }
        for (int i1 = 0;; i1 = 1)
        {
          if (i1 == 0) {
            break label165;
          }
          JSONField localJSONField = (JSONField)localMethod.getAnnotation(JSONField.class);
          if (localJSONField == null) {
            break label63;
          }
          return localJSONField;
          n++;
          break label86;
          j++;
          break;
          return null;
        }
      }
    }
  }
  
  public static boolean isGenericParamType(Type paramType)
  {
    if ((paramType instanceof ParameterizedType)) {
      return true;
    }
    if ((paramType instanceof Class)) {
      return isGenericParamType(((Class)paramType).getGenericSuperclass());
    }
    return false;
  }
  
  private static boolean isJSONTypeIgnore(Class<?> paramClass, String paramString)
  {
    JSONType localJSONType = (JSONType)paramClass.getAnnotation(JSONType.class);
    if ((localJSONType != null) && (localJSONType.ignores() != null))
    {
      String[] arrayOfString = localJSONType.ignores();
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++) {
        if (paramString.equalsIgnoreCase(arrayOfString[j])) {
          return true;
        }
      }
    }
    return (paramClass.getSuperclass() != Object.class) && (paramClass.getSuperclass() != null) && (isJSONTypeIgnore(paramClass.getSuperclass(), paramString));
  }
  
  public static Class<?> loadClass(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = (Class)mappings.get(paramString);
    } while (localObject != null);
    if (paramString.charAt(0) == '[') {
      return Array.newInstance(loadClass(paramString.substring(1)), 0).getClass();
    }
    if ((paramString.startsWith("L")) && (paramString.endsWith(";"))) {
      return loadClass(paramString.substring(1, -1 + paramString.length()));
    }
    try
    {
      ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
      if (localClassLoader != null)
      {
        localObject = localClassLoader.loadClass(paramString);
        addClassMapping(paramString, (Class)localObject);
        return localObject;
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localObject = Class.forName(paramString);
        addClassMapping(paramString, (Class)localObject);
        return localObject;
      }
      catch (Throwable localThrowable2) {}
    }
    return localObject;
  }
  
  static void setAccessible(AccessibleObject paramAccessibleObject)
  {
    if (!setAccessibleEnable) {}
    while (paramAccessibleObject.isAccessible()) {
      return;
    }
    try
    {
      paramAccessibleObject.setAccessible(true);
      return;
    }
    catch (AccessControlException localAccessControlException)
    {
      setAccessibleEnable = false;
    }
  }
  
  public static Type unwrap(Type paramType)
  {
    Type localType;
    if ((paramType instanceof GenericArrayType))
    {
      localType = ((GenericArrayType)paramType).getGenericComponentType();
      if (localType != Byte.TYPE) {
        break label29;
      }
      paramType = [B.class;
    }
    label29:
    while (localType != Character.TYPE) {
      return paramType;
    }
    return [C.class;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.util.TypeUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */