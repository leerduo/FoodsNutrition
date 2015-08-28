package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ThrowableDeserializer
  extends JavaBeanDeserializer
{
  public ThrowableDeserializer(ParserConfig paramParserConfig, Class<?> paramClass)
  {
    super(paramParserConfig, paramClass);
  }
  
  private Throwable createException(String paramString, Throwable paramThrowable, Class<?> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Constructor[] arrayOfConstructor = paramClass.getConstructors();
    int i = arrayOfConstructor.length;
    int j = 0;
    Object localObject3 = null;
    Object localObject4;
    Object localObject5;
    if (j < i)
    {
      localObject4 = arrayOfConstructor[j];
      if (((Constructor)localObject4).getParameterTypes().length == 0)
      {
        Object localObject6 = localObject2;
        localObject5 = localObject4;
        localObject4 = localObject6;
      }
    }
    for (;;)
    {
      j++;
      localObject1 = localObject5;
      localObject2 = localObject4;
      break;
      if ((((Constructor)localObject4).getParameterTypes().length == 1) && (localObject4.getParameterTypes()[0] == String.class))
      {
        localObject5 = localObject1;
      }
      else if ((((Constructor)localObject4).getParameterTypes().length == 2) && (localObject4.getParameterTypes()[0] == String.class) && (localObject4.getParameterTypes()[1] == Throwable.class))
      {
        localObject3 = localObject4;
        localObject4 = localObject2;
        localObject5 = localObject1;
        continue;
        if (localObject3 != null) {
          return (Throwable)localObject3.newInstance(new Object[] { paramString, paramThrowable });
        }
        if (localObject2 != null) {
          return (Throwable)localObject2.newInstance(new Object[] { paramString });
        }
        if (localObject1 != null) {
          return (Throwable)localObject1.newInstance(new Object[0]);
        }
        return null;
      }
      else
      {
        localObject4 = localObject2;
        localObject5 = localObject1;
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    Object localObject9;
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      localObject9 = null;
      return localObject9;
    }
    label44:
    Object localObject1;
    Class localClass1;
    if (paramDefaultJSONParser.getResolveStatus() == 2)
    {
      paramDefaultJSONParser.setResolveStatus(0);
      localObject1 = null;
      if ((paramType == null) || (!(paramType instanceof Class))) {
        break label602;
      }
      localClass1 = (Class)paramType;
      if (!Throwable.class.isAssignableFrom(localClass1)) {
        break label602;
      }
    }
    for (;;)
    {
      Object localObject2 = null;
      Object localObject3 = null;
      HashMap localHashMap = new HashMap();
      Object localObject4 = localClass1;
      label93:
      String str1 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
      if (str1 == null) {
        if (localJSONLexer.token() == 13)
        {
          localJSONLexer.nextToken(16);
          if (localObject4 != null) {
            break label555;
          }
          localObject9 = new Exception((String)localObject2, (Throwable)localObject1);
        }
      }
      while (localObject3 != null)
      {
        ((Throwable)localObject9).setStackTrace((StackTraceElement[])localObject3);
        return localObject9;
        if (localJSONLexer.token() == 12) {
          break label44;
        }
        throw new JSONException("syntax error");
        if ((localJSONLexer.token() == 16) && (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas))) {
          break label93;
        }
        localJSONLexer.nextTokenWithColon(4);
        Object localObject8;
        Object localObject7;
        Object localObject5;
        Object localObject6;
        if (JSON.DEFAULT_TYPE_KEY.equals(str1)) {
          if (localJSONLexer.token() == 4)
          {
            Class localClass2 = TypeUtils.loadClass(localJSONLexer.stringVal());
            localJSONLexer.nextToken(16);
            localObject8 = localObject1;
            Object localObject12 = localObject2;
            localObject7 = localClass2;
            localObject5 = localObject3;
            localObject6 = localObject12;
          }
        }
        for (;;)
        {
          if (localJSONLexer.token() != 13) {
            break label536;
          }
          localJSONLexer.nextToken(16);
          localObject1 = localObject8;
          localObject4 = localObject7;
          localObject2 = localObject6;
          localObject3 = localObject5;
          break;
          throw new JSONException("syntax error");
          if ("message".equals(str1))
          {
            if (localJSONLexer.token() == 8) {}
            for (String str2 = null;; str2 = localJSONLexer.stringVal())
            {
              localJSONLexer.nextToken();
              localObject7 = localObject4;
              localObject8 = localObject1;
              Object localObject11 = localObject3;
              localObject6 = str2;
              localObject5 = localObject11;
              break;
              if (localJSONLexer.token() != 4) {
                break label411;
              }
            }
            label411:
            throw new JSONException("syntax error");
          }
          if ("cause".equals(str1))
          {
            Throwable localThrowable = (Throwable)deserialze(paramDefaultJSONParser, null, "cause");
            Object localObject10 = localObject3;
            localObject6 = localObject2;
            localObject7 = localObject4;
            localObject8 = localThrowable;
            localObject5 = localObject10;
          }
          else if ("stackTrace".equals(str1))
          {
            localObject5 = (StackTraceElement[])paramDefaultJSONParser.parseObject([Ljava.lang.StackTraceElement.class);
            localObject6 = localObject2;
            localObject7 = localObject4;
            localObject8 = localObject1;
          }
          else
          {
            localHashMap.put(str1, paramDefaultJSONParser.parse());
            localObject5 = localObject3;
            localObject6 = localObject2;
            localObject7 = localObject4;
            localObject8 = localObject1;
          }
        }
        label536:
        localObject1 = localObject8;
        localObject4 = localObject7;
        localObject2 = localObject6;
        localObject3 = localObject5;
        break label93;
        try
        {
          label555:
          localObject9 = createException((String)localObject2, (Throwable)localObject1, (Class)localObject4);
          if (localObject9 == null) {
            localObject9 = new Exception((String)localObject2, (Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          throw new JSONException("create instance error", localException);
        }
      }
      label602:
      localClass1 = null;
    }
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */