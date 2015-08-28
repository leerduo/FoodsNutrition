package cn.sharesdk.framework.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
{
  private ArrayList<Object> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramJSONArray.length();
    int j = 0;
    if (j < i)
    {
      Object localObject = paramJSONArray.opt(j);
      if ((localObject instanceof JSONObject)) {
        localObject = a((JSONObject)localObject);
      }
      for (;;)
      {
        localArrayList.add(localObject);
        j++;
        break;
        if ((localObject instanceof JSONArray)) {
          localObject = a((JSONArray)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private HashMap<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      if (JSONObject.NULL.equals(localObject)) {
        localObject = null;
      }
      if (localObject != null)
      {
        if ((localObject instanceof JSONObject)) {
          localObject = a((JSONObject)localObject);
        }
        for (;;)
        {
          localHashMap.put(str, localObject);
          break;
          if ((localObject instanceof JSONArray)) {
            localObject = a((JSONArray)localObject);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private JSONArray a(ArrayList<Object> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof HashMap)) {
        localObject = b((HashMap)localObject);
      }
      for (;;)
      {
        localJSONArray.put(localObject);
        break;
        if ((localObject instanceof ArrayList)) {
          localObject = a((ArrayList)localObject);
        }
      }
    }
    return localJSONArray;
  }
  
  private boolean a(Object paramObject)
  {
    return ((paramObject instanceof byte[])) || ((paramObject instanceof short[])) || ((paramObject instanceof int[])) || ((paramObject instanceof long[])) || ((paramObject instanceof float[])) || ((paramObject instanceof double[])) || ((paramObject instanceof char[])) || ((paramObject instanceof boolean[])) || ((paramObject instanceof String[]));
  }
  
  private ArrayList<?> b(Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof byte[]))
    {
      localArrayList = new ArrayList();
      byte[] arrayOfByte = (byte[])paramObject;
      int j = arrayOfByte.length;
      while (i < j)
      {
        localArrayList.add(Byte.valueOf(arrayOfByte[i]));
        i++;
      }
    }
    if ((paramObject instanceof short[]))
    {
      localArrayList = new ArrayList();
      short[] arrayOfShort = (short[])paramObject;
      int k = arrayOfShort.length;
      while (i < k)
      {
        localArrayList.add(Short.valueOf(arrayOfShort[i]));
        i++;
      }
    }
    if ((paramObject instanceof int[]))
    {
      localArrayList = new ArrayList();
      int[] arrayOfInt = (int[])paramObject;
      int m = arrayOfInt.length;
      while (i < m)
      {
        localArrayList.add(Integer.valueOf(arrayOfInt[i]));
        i++;
      }
    }
    if ((paramObject instanceof long[]))
    {
      localArrayList = new ArrayList();
      long[] arrayOfLong = (long[])paramObject;
      int n = arrayOfLong.length;
      while (i < n)
      {
        localArrayList.add(Long.valueOf(arrayOfLong[i]));
        i++;
      }
    }
    if ((paramObject instanceof float[]))
    {
      localArrayList = new ArrayList();
      float[] arrayOfFloat = (float[])paramObject;
      int i1 = arrayOfFloat.length;
      while (i < i1)
      {
        localArrayList.add(Float.valueOf(arrayOfFloat[i]));
        i++;
      }
    }
    if ((paramObject instanceof double[]))
    {
      localArrayList = new ArrayList();
      double[] arrayOfDouble = (double[])paramObject;
      int i2 = arrayOfDouble.length;
      while (i < i2)
      {
        localArrayList.add(Double.valueOf(arrayOfDouble[i]));
        i++;
      }
    }
    if ((paramObject instanceof char[]))
    {
      localArrayList = new ArrayList();
      char[] arrayOfChar = (char[])paramObject;
      int i3 = arrayOfChar.length;
      while (i < i3)
      {
        localArrayList.add(Character.valueOf(arrayOfChar[i]));
        i++;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      localArrayList = new ArrayList();
      boolean[] arrayOfBoolean = (boolean[])paramObject;
      int i4 = arrayOfBoolean.length;
      while (i < i4)
      {
        localArrayList.add(Boolean.valueOf(arrayOfBoolean[i]));
        i++;
      }
    }
    if ((paramObject instanceof String[]))
    {
      localArrayList = new ArrayList();
      String[] arrayOfString = (String[])paramObject;
      int i5 = arrayOfString.length;
      while (i < i5)
      {
        localArrayList.add(arrayOfString[i]);
        i++;
      }
    }
    ArrayList localArrayList = null;
    return localArrayList;
  }
  
  private JSONObject b(HashMap<String, Object> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof HashMap)) {
        localObject = b((HashMap)localObject);
      }
      for (;;)
      {
        localJSONObject.put((String)localEntry.getKey(), localObject);
        break;
        if ((localObject instanceof ArrayList)) {
          localObject = a((ArrayList)localObject);
        } else if (a(localObject)) {
          localObject = a(b(localObject));
        }
      }
    }
    return localJSONObject;
  }
  
  public String a(HashMap<String, Object> paramHashMap)
  {
    try
    {
      String str = b(paramHashMap).toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
    return "";
  }
  
  public HashMap<String, Object> a(String paramString)
  {
    try
    {
      if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
        paramString = "{\"fakelist\":" + paramString + "}";
      }
      HashMap localHashMap = a(new JSONObject(paramString));
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      e.c(paramString, new Object[0]);
      e.c(localThrowable);
    }
    return new HashMap();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */