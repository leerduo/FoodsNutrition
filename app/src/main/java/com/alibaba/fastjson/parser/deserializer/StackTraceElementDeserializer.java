package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import java.lang.reflect.Type;

public class StackTraceElementDeserializer
  implements ObjectDeserializer
{
  public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      return null;
    }
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new JSONException("syntax error: " + JSONToken.name(localJSONLexer.token()));
    }
    String str1 = null;
    String str2 = null;
    String str3 = null;
    int i = 0;
    String str4;
    label532:
    label534:
    label544:
    do
    {
      String str5;
      do
      {
        for (;;)
        {
          str4 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
          if (str4 == null)
          {
            if (localJSONLexer.token() == 13)
            {
              localJSONLexer.nextToken(16);
              return new StackTraceElement(str1, str2, str3, i);
            }
            if ((localJSONLexer.token() == 16) && (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas))) {}
          }
          else
          {
            localJSONLexer.nextTokenWithColon(4);
            if ("className".equals(str4)) {
              if (localJSONLexer.token() == 8) {
                str1 = null;
              }
            }
            for (;;)
            {
              if (localJSONLexer.token() != 13) {
                break label532;
              }
              localJSONLexer.nextToken(16);
              break;
              if (localJSONLexer.token() == 4)
              {
                str1 = localJSONLexer.stringVal();
              }
              else
              {
                throw new JSONException("syntax error");
                if ("methodName".equals(str4))
                {
                  if (localJSONLexer.token() == 8) {
                    str2 = null;
                  } else if (localJSONLexer.token() == 4) {
                    str2 = localJSONLexer.stringVal();
                  } else {
                    throw new JSONException("syntax error");
                  }
                }
                else if ("fileName".equals(str4))
                {
                  if (localJSONLexer.token() == 8) {
                    str3 = null;
                  } else if (localJSONLexer.token() == 4) {
                    str3 = localJSONLexer.stringVal();
                  } else {
                    throw new JSONException("syntax error");
                  }
                }
                else if ("lineNumber".equals(str4))
                {
                  if (localJSONLexer.token() == 8) {
                    i = 0;
                  } else if (localJSONLexer.token() == 2) {
                    i = localJSONLexer.intValue();
                  } else {
                    throw new JSONException("syntax error");
                  }
                }
                else
                {
                  if (!"nativeMethod".equals(str4)) {
                    break label544;
                  }
                  if (localJSONLexer.token() == 8)
                  {
                    localJSONLexer.nextToken(16);
                  }
                  else if (localJSONLexer.token() == 6)
                  {
                    localJSONLexer.nextToken(16);
                  }
                  else
                  {
                    if (localJSONLexer.token() != 7) {
                      break label534;
                    }
                    localJSONLexer.nextToken(16);
                  }
                }
              }
            }
          }
        }
        throw new JSONException("syntax error");
        if (str4 != JSON.DEFAULT_TYPE_KEY) {
          break label632;
        }
        if (localJSONLexer.token() != 4) {
          break;
        }
        str5 = localJSONLexer.stringVal();
      } while (str5.equals("java.lang.StackTraceElement"));
      throw new JSONException("syntax error : " + str5);
    } while (localJSONLexer.token() == 8);
    throw new JSONException("syntax error");
    label632:
    throw new JSONException("syntax error : " + str4);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */