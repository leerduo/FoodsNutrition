package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArrayListTypeFieldDeserializer
  extends FieldDeserializer
{
  private ObjectDeserializer deserializer;
  private int itemFastMatchToken;
  private final Type itemType;
  
  public ArrayListTypeFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    super(paramClass, paramFieldInfo);
    if ((getFieldType() instanceof ParameterizedType))
    {
      this.itemType = ((ParameterizedType)getFieldType()).getActualTypeArguments()[0];
      return;
    }
    this.itemType = Object.class;
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public final void parseArray(DefaultJSONParser paramDefaultJSONParser, Type paramType, Collection paramCollection)
  {
    Type localType = this.itemType;
    ObjectDeserializer localObjectDeserializer1 = this.deserializer;
    TypeVariable localTypeVariable;
    ParameterizedType localParameterizedType;
    if (((localType instanceof TypeVariable)) && ((paramType instanceof ParameterizedType)))
    {
      localTypeVariable = (TypeVariable)localType;
      localParameterizedType = (ParameterizedType)paramType;
      if (!(localParameterizedType.getRawType() instanceof Class)) {
        break label428;
      }
    }
    label428:
    for (Class localClass = (Class)localParameterizedType.getRawType();; localClass = null)
    {
      int m;
      if (localClass != null)
      {
        int k = localClass.getTypeParameters().length;
        m = 0;
        if (m < k) {
          if (!localClass.getTypeParameters()[m].getName().equals(localTypeVariable.getName())) {}
        }
      }
      for (int j = m;; j = -1)
      {
        if (j != -1)
        {
          localType = localParameterizedType.getActualTypeArguments()[j];
          if (localType.equals(this.itemType)) {}
        }
        for (ObjectDeserializer localObjectDeserializer2 = paramDefaultJSONParser.getConfig().getDeserializer(localType);; localObjectDeserializer2 = localObjectDeserializer1)
        {
          JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
          if (localJSONLexer.token() != 14)
          {
            String str = "exepct '[', but " + JSONToken.name(localJSONLexer.token());
            if (paramType != null) {
              str = str + ", type : " + paramType;
            }
            throw new JSONException(str);
            m++;
            break;
          }
          if (localObjectDeserializer2 == null)
          {
            localObjectDeserializer2 = paramDefaultJSONParser.getConfig().getDeserializer(localType);
            this.deserializer = localObjectDeserializer2;
            this.itemFastMatchToken = this.deserializer.getFastMatchToken();
          }
          localJSONLexer.nextToken(this.itemFastMatchToken);
          for (int i = 0;; i++)
          {
            if (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
              while (localJSONLexer.token() == 16) {
                localJSONLexer.nextToken();
              }
            }
            if (localJSONLexer.token() == 15)
            {
              localJSONLexer.nextToken(16);
              return;
            }
            paramCollection.add(localObjectDeserializer2.deserialze(paramDefaultJSONParser, localType, Integer.valueOf(i)));
            paramDefaultJSONParser.checkListResolve(paramCollection);
            if (localJSONLexer.token() == 16) {
              localJSONLexer.nextToken(this.itemFastMatchToken);
            }
          }
        }
      }
    }
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    if (paramDefaultJSONParser.getLexer().token() == 8)
    {
      setValue(paramObject, null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ParseContext localParseContext = paramDefaultJSONParser.getContext();
    paramDefaultJSONParser.setContext(localParseContext, paramObject, this.fieldInfo.getName());
    parseArray(paramDefaultJSONParser, paramType, localArrayList);
    paramDefaultJSONParser.setContext(localParseContext);
    if (paramObject == null)
    {
      paramMap.put(this.fieldInfo.getName(), localArrayList);
      return;
    }
    setValue(paramObject, localArrayList);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */