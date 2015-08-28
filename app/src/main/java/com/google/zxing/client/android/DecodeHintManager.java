package com.google.zxing.client.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.DecodeHintType;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

final class DecodeHintManager
{
  private static final String a = DecodeHintManager.class.getSimpleName();
  private static final Pattern b = Pattern.compile(",");
  
  static Map<DecodeHintType, Object> a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if ((localBundle == null) || (localBundle.isEmpty())) {
      return null;
    }
    EnumMap localEnumMap = new EnumMap(DecodeHintType.class);
    DecodeHintType[] arrayOfDecodeHintType = DecodeHintType.values();
    int i = arrayOfDecodeHintType.length;
    int j = 0;
    if (j < i)
    {
      DecodeHintType localDecodeHintType = arrayOfDecodeHintType[j];
      if ((localDecodeHintType == DecodeHintType.e) || (localDecodeHintType == DecodeHintType.j) || (localDecodeHintType == DecodeHintType.c)) {}
      for (;;)
      {
        j++;
        break;
        String str = localDecodeHintType.name();
        if (localBundle.containsKey(str)) {
          if (localDecodeHintType.a().equals(Void.class))
          {
            localEnumMap.put(localDecodeHintType, Boolean.TRUE);
          }
          else
          {
            Object localObject = localBundle.get(str);
            if (localDecodeHintType.a().isInstance(localObject)) {
              localEnumMap.put(localDecodeHintType, localObject);
            } else {
              Log.w(a, "Ignoring hint " + localDecodeHintType + " because it is not assignable from " + localObject);
            }
          }
        }
      }
    }
    Log.i(a, "Hints from the Intent: " + localEnumMap);
    return localEnumMap;
  }
  
  static Map<DecodeHintType, ?> a(Uri paramUri)
  {
    String str1 = paramUri.getEncodedQuery();
    if ((str1 == null) || (str1.isEmpty())) {
      return null;
    }
    Map localMap = a(str1);
    EnumMap localEnumMap = new EnumMap(DecodeHintType.class);
    DecodeHintType[] arrayOfDecodeHintType = DecodeHintType.values();
    int i = arrayOfDecodeHintType.length;
    int j = 0;
    DecodeHintType localDecodeHintType;
    if (j < i)
    {
      localDecodeHintType = arrayOfDecodeHintType[j];
      if ((localDecodeHintType != DecodeHintType.e) && (localDecodeHintType != DecodeHintType.j) && (localDecodeHintType != DecodeHintType.c)) {}
    }
    label534:
    for (;;)
    {
      j++;
      break;
      String str2 = (String)localMap.get(localDecodeHintType.name());
      if (str2 != null) {
        if (localDecodeHintType.a().equals(Object.class))
        {
          localEnumMap.put(localDecodeHintType, str2);
        }
        else if (localDecodeHintType.a().equals(Void.class))
        {
          localEnumMap.put(localDecodeHintType, Boolean.TRUE);
        }
        else if (localDecodeHintType.a().equals(String.class))
        {
          localEnumMap.put(localDecodeHintType, str2);
        }
        else if (localDecodeHintType.a().equals(Boolean.class))
        {
          if (str2.isEmpty()) {
            localEnumMap.put(localDecodeHintType, Boolean.TRUE);
          } else if (("0".equals(str2)) || ("false".equalsIgnoreCase(str2)) || ("no".equalsIgnoreCase(str2))) {
            localEnumMap.put(localDecodeHintType, Boolean.FALSE);
          } else {
            localEnumMap.put(localDecodeHintType, Boolean.TRUE);
          }
        }
        else
        {
          int[] arrayOfInt;
          Object localObject;
          if (localDecodeHintType.a().equals([I.class))
          {
            if ((!str2.isEmpty()) && (str2.charAt(-1 + str2.length()) == ',')) {
              str2 = str2.substring(0, -1 + str2.length());
            }
            String[] arrayOfString = b.split(str2);
            arrayOfInt = new int[arrayOfString.length];
            int k = 0;
            for (;;)
            {
              if (k < arrayOfString.length) {
                try
                {
                  arrayOfInt[k] = Integer.parseInt(arrayOfString[k]);
                  k++;
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  Log.w(a, "Skipping array of integers hint " + localDecodeHintType + " due to invalid numeric value: '" + arrayOfString[k] + '\'');
                  localObject = null;
                }
              }
            }
          }
          for (;;)
          {
            if (localObject == null) {
              break label534;
            }
            localEnumMap.put(localDecodeHintType, localObject);
            break;
            Log.w(a, "Unsupported hint type '" + localDecodeHintType + "' of type " + localDecodeHintType.a());
            break;
            Log.i(a, "Hints from the URI: " + localEnumMap);
            return localEnumMap;
            localObject = arrayOfInt;
          }
        }
      }
    }
  }
  
  private static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      String str4;
      if (i < paramString.length())
      {
        if (paramString.charAt(i) == '&')
        {
          i++;
        }
        else
        {
          j = paramString.indexOf('&', i);
          k = paramString.indexOf('=', i);
          if (j < 0) {
            if (k < 0) {
              str4 = Uri.decode(paramString.substring(i).replace('+', ' '));
            }
          }
        }
      }
      else
      {
        for (String str5 = "";; str5 = Uri.decode(paramString.substring(k + 1).replace('+', ' ')))
        {
          if (!localHashMap.containsKey(str4)) {
            localHashMap.put(str4, str5);
          }
          return localHashMap;
          str4 = Uri.decode(paramString.substring(i, k).replace('+', ' '));
        }
        if ((k < 0) || (k > j))
        {
          String str1 = Uri.decode(paramString.substring(i, j).replace('+', ' '));
          if (!localHashMap.containsKey(str1)) {
            localHashMap.put(str1, "");
          }
          i = j + 1;
        }
        else
        {
          String str2 = Uri.decode(paramString.substring(i, k).replace('+', ' '));
          String str3 = Uri.decode(paramString.substring(k + 1, j).replace('+', ' '));
          if (!localHashMap.containsKey(str2)) {
            localHashMap.put(str2, str3);
          }
          i = j + 1;
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.DecodeHintManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */