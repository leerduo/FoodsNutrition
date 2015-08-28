package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.FilterUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaBeanDeserializer
  implements ObjectDeserializer
{
  private DeserializeBeanInfo beanInfo;
  private final Class<?> clazz;
  private final Map<String, FieldDeserializer> feildDeserializerMap = new IdentityHashMap();
  private final List<FieldDeserializer> fieldDeserializers = new ArrayList();
  private final List<FieldDeserializer> sortedFieldDeserializers = new ArrayList();
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass)
  {
    this(paramParserConfig, paramClass, paramClass);
  }
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType)
  {
    this.clazz = paramClass;
    this.beanInfo = DeserializeBeanInfo.computeSetters(paramClass, paramType);
    Iterator localIterator1 = this.beanInfo.getFieldList().iterator();
    while (localIterator1.hasNext()) {
      addFieldDeserializer(paramParserConfig, paramClass, (FieldInfo)localIterator1.next());
    }
    Iterator localIterator2 = this.beanInfo.getSortedFieldList().iterator();
    while (localIterator2.hasNext())
    {
      FieldInfo localFieldInfo = (FieldInfo)localIterator2.next();
      FieldDeserializer localFieldDeserializer = (FieldDeserializer)this.feildDeserializerMap.get(localFieldInfo.getName().intern());
      this.sortedFieldDeserializers.add(localFieldDeserializer);
    }
  }
  
  private void addFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    String str = paramFieldInfo.getName().intern();
    FieldDeserializer localFieldDeserializer = createFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    this.feildDeserializerMap.put(str, localFieldDeserializer);
    this.fieldDeserializers.add(localFieldDeserializer);
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    return paramParserConfig.createFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
  }
  
  /* Error */
  public Object createInstance(DefaultJSONParser paramDefaultJSONParser, Type paramType)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 115
    //   4: ifeq +57 -> 61
    //   7: aload_0
    //   8: getfield 40	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   11: invokevirtual 118	java/lang/Class:isInterface	()Z
    //   14: ifeq +47 -> 61
    //   17: aload_2
    //   18: checkcast 115	java/lang/Class
    //   21: astore 12
    //   23: invokestatic 124	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   26: invokevirtual 128	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   29: astore 13
    //   31: new 130	com/alibaba/fastjson/JSONObject
    //   34: dup
    //   35: invokespecial 131	com/alibaba/fastjson/JSONObject:<init>	()V
    //   38: astore 14
    //   40: aload 13
    //   42: iconst_1
    //   43: anewarray 115	java/lang/Class
    //   46: dup
    //   47: iconst_0
    //   48: aload 12
    //   50: aastore
    //   51: aload 14
    //   53: invokestatic 137	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload 7
    //   60: areturn
    //   61: aload_0
    //   62: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   65: invokevirtual 141	com/alibaba/fastjson/util/DeserializeBeanInfo:getDefaultConstructor	()Ljava/lang/reflect/Constructor;
    //   68: ifnonnull +5 -> 73
    //   71: aconst_null
    //   72: areturn
    //   73: aload_0
    //   74: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   77: invokevirtual 141	com/alibaba/fastjson/util/DeserializeBeanInfo:getDefaultConstructor	()Ljava/lang/reflect/Constructor;
    //   80: astore 4
    //   82: aload 4
    //   84: invokevirtual 147	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   87: arraylength
    //   88: ifne +123 -> 211
    //   91: aload 4
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokevirtual 151	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore 11
    //   102: aload 11
    //   104: astore 7
    //   106: aload_1
    //   107: getstatic 157	com/alibaba/fastjson/parser/Feature:InitStringFieldAsEmpty	Lcom/alibaba/fastjson/parser/Feature;
    //   110: invokevirtual 163	com/alibaba/fastjson/parser/DefaultJSONParser:isEnabled	(Lcom/alibaba/fastjson/parser/Feature;)Z
    //   113: ifeq -55 -> 58
    //   116: aload_0
    //   117: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   120: invokevirtual 52	com/alibaba/fastjson/util/DeserializeBeanInfo:getFieldList	()Ljava/util/List;
    //   123: invokeinterface 58 1 0
    //   128: astore 8
    //   130: aload 8
    //   132: invokeinterface 64 1 0
    //   137: ifeq -79 -> 58
    //   140: aload 8
    //   142: invokeinterface 68 1 0
    //   147: checkcast 70	com/alibaba/fastjson/util/FieldInfo
    //   150: astore 9
    //   152: aload 9
    //   154: invokevirtual 167	com/alibaba/fastjson/util/FieldInfo:getFieldClass	()Ljava/lang/Class;
    //   157: ldc 83
    //   159: if_acmpne -29 -> 130
    //   162: aload 9
    //   164: aload 7
    //   166: ldc 169
    //   168: invokevirtual 173	com/alibaba/fastjson/util/FieldInfo:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   171: goto -41 -> 130
    //   174: astore 10
    //   176: new 175	com/alibaba/fastjson/JSONException
    //   179: dup
    //   180: new 177	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   187: ldc 180
    //   189: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_0
    //   193: getfield 40	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   196: invokevirtual 185	java/lang/Class:getName	()Ljava/lang/String;
    //   199: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: aload 10
    //   207: invokespecial 191	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: athrow
    //   211: iconst_1
    //   212: anewarray 4	java/lang/Object
    //   215: astore 5
    //   217: aload 5
    //   219: iconst_0
    //   220: aload_1
    //   221: invokevirtual 195	com/alibaba/fastjson/parser/DefaultJSONParser:getContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   224: invokevirtual 200	com/alibaba/fastjson/parser/ParseContext:getObject	()Ljava/lang/Object;
    //   227: aastore
    //   228: aload 4
    //   230: aload 5
    //   232: invokevirtual 151	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   235: astore 6
    //   237: aload 6
    //   239: astore 7
    //   241: goto -135 -> 106
    //   244: astore_3
    //   245: new 175	com/alibaba/fastjson/JSONException
    //   248: dup
    //   249: new 177	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   256: ldc 180
    //   258: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: getfield 40	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   265: invokevirtual 185	java/lang/Class:getName	()Ljava/lang/String;
    //   268: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: aload_3
    //   275: invokespecial 191	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	JavaBeanDeserializer
    //   0	279	1	paramDefaultJSONParser	DefaultJSONParser
    //   0	279	2	paramType	Type
    //   244	31	3	localException1	java.lang.Exception
    //   80	149	4	localConstructor	java.lang.reflect.Constructor
    //   215	16	5	arrayOfObject	Object[]
    //   235	3	6	localObject1	Object
    //   56	184	7	localObject2	Object
    //   128	13	8	localIterator	Iterator
    //   150	13	9	localFieldInfo	FieldInfo
    //   174	32	10	localException2	java.lang.Exception
    //   100	3	11	localObject3	Object
    //   21	28	12	localClass	Class
    //   29	12	13	localClassLoader	java.lang.ClassLoader
    //   38	14	14	localJSONObject	com.alibaba.fastjson.JSONObject
    // Exception table:
    //   from	to	target	type
    //   162	171	174	java/lang/Exception
    //   73	102	244	java/lang/Exception
    //   211	237	244	java/lang/Exception
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return deserialze(paramDefaultJSONParser, paramType, paramObject, null);
  }
  
  /* Error */
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 209	com/alibaba/fastjson/parser/DefaultJSONParser:getLexer	()Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: astore 5
    //   6: aload 5
    //   8: invokeinterface 215 1 0
    //   13: bipush 8
    //   15: if_icmpne +14 -> 29
    //   18: aload 5
    //   20: bipush 16
    //   22: invokeinterface 219 2 0
    //   27: aconst_null
    //   28: areturn
    //   29: aload_1
    //   30: invokevirtual 195	com/alibaba/fastjson/parser/DefaultJSONParser:getContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   33: astore 6
    //   35: aload 4
    //   37: ifnull +1433 -> 1470
    //   40: aload 6
    //   42: ifnull +1428 -> 1470
    //   45: aload 6
    //   47: invokevirtual 222	com/alibaba/fastjson/parser/ParseContext:getParentContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 9
    //   58: aload 5
    //   60: invokeinterface 215 1 0
    //   65: bipush 13
    //   67: if_icmpne +51 -> 118
    //   70: aload 5
    //   72: bipush 16
    //   74: invokeinterface 219 2 0
    //   79: aconst_null
    //   80: astore 8
    //   82: aload 4
    //   84: ifnonnull +15 -> 99
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: invokevirtual 224	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   93: astore 47
    //   95: aload 47
    //   97: astore 4
    //   99: iconst_0
    //   100: ifeq +9 -> 109
    //   103: aconst_null
    //   104: aload 4
    //   106: invokevirtual 228	com/alibaba/fastjson/parser/ParseContext:setObject	(Ljava/lang/Object;)V
    //   109: aload_1
    //   110: aload 7
    //   112: invokevirtual 232	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   115: aload 4
    //   117: areturn
    //   118: aload 5
    //   120: invokeinterface 215 1 0
    //   125: istore 12
    //   127: aconst_null
    //   128: astore 8
    //   130: iload 12
    //   132: bipush 14
    //   134: if_icmpne +49 -> 183
    //   137: aload_0
    //   138: aload 5
    //   140: invokevirtual 236	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:isSupportArrayToBean	(Lcom/alibaba/fastjson/parser/JSONLexer;)Z
    //   143: istore 13
    //   145: aconst_null
    //   146: astore 8
    //   148: iload 13
    //   150: ifeq +33 -> 183
    //   153: aload_0
    //   154: aload_1
    //   155: aload_2
    //   156: aload_3
    //   157: aload 4
    //   159: invokevirtual 239	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:deserialzeArrayMapping	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: astore 14
    //   164: iconst_0
    //   165: ifeq +9 -> 174
    //   168: aconst_null
    //   169: aload 4
    //   171: invokevirtual 228	com/alibaba/fastjson/parser/ParseContext:setObject	(Ljava/lang/Object;)V
    //   174: aload_1
    //   175: aload 7
    //   177: invokevirtual 232	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   180: aload 14
    //   182: areturn
    //   183: aload 5
    //   185: invokeinterface 215 1 0
    //   190: istore 15
    //   192: aconst_null
    //   193: astore 8
    //   195: iload 15
    //   197: bipush 12
    //   199: if_icmpeq +121 -> 320
    //   202: aload 5
    //   204: invokeinterface 215 1 0
    //   209: istore 16
    //   211: aconst_null
    //   212: astore 8
    //   214: iload 16
    //   216: bipush 16
    //   218: if_icmpeq +102 -> 320
    //   221: new 241	java/lang/StringBuffer
    //   224: dup
    //   225: invokespecial 242	java/lang/StringBuffer:<init>	()V
    //   228: ldc 244
    //   230: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   233: aload 5
    //   235: invokeinterface 250 1 0
    //   240: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   243: ldc 252
    //   245: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   248: aload 5
    //   250: invokeinterface 255 1 0
    //   255: invokevirtual 258	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   258: astore 17
    //   260: aload_3
    //   261: instanceof 83
    //   264: ifeq +16 -> 280
    //   267: aload 17
    //   269: ldc_w 260
    //   272: invokevirtual 247	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   275: aload_3
    //   276: invokevirtual 263	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   279: pop
    //   280: new 175	com/alibaba/fastjson/JSONException
    //   283: dup
    //   284: aload 17
    //   286: invokevirtual 264	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   289: invokespecial 267	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   292: athrow
    //   293: astore 10
    //   295: aload 4
    //   297: astore 11
    //   299: aload 8
    //   301: ifnull +10 -> 311
    //   304: aload 8
    //   306: aload 11
    //   308: invokevirtual 228	com/alibaba/fastjson/parser/ParseContext:setObject	(Ljava/lang/Object;)V
    //   311: aload_1
    //   312: aload 7
    //   314: invokevirtual 232	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   317: aload 10
    //   319: athrow
    //   320: aload_1
    //   321: invokevirtual 270	com/alibaba/fastjson/parser/DefaultJSONParser:getResolveStatus	()I
    //   324: iconst_2
    //   325: if_icmpne +8 -> 333
    //   328: aload_1
    //   329: iconst_0
    //   330: invokevirtual 273	com/alibaba/fastjson/parser/DefaultJSONParser:setResolveStatus	(I)V
    //   333: aconst_null
    //   334: astore 19
    //   336: aload 4
    //   338: astore 20
    //   340: aload 5
    //   342: aload_1
    //   343: invokevirtual 277	com/alibaba/fastjson/parser/DefaultJSONParser:getSymbolTable	()Lcom/alibaba/fastjson/parser/SymbolTable;
    //   346: invokeinterface 281 2 0
    //   351: astore 21
    //   353: aload 21
    //   355: ifnonnull +117 -> 472
    //   358: aload 5
    //   360: invokeinterface 215 1 0
    //   365: bipush 13
    //   367: if_icmpne +83 -> 450
    //   370: aload 5
    //   372: bipush 16
    //   374: invokeinterface 219 2 0
    //   379: aload 20
    //   381: astore 11
    //   383: aload 19
    //   385: astore 8
    //   387: aload 11
    //   389: ifnonnull +1045 -> 1434
    //   392: aload 9
    //   394: ifnonnull +801 -> 1195
    //   397: aload_0
    //   398: aload_1
    //   399: aload_2
    //   400: invokevirtual 224	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   403: astore 40
    //   405: aload 40
    //   407: astore 4
    //   409: aload 8
    //   411: ifnonnull +1030 -> 1441
    //   414: aload_1
    //   415: aload 7
    //   417: aload 4
    //   419: aload_3
    //   420: invokevirtual 284	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   423: astore 42
    //   425: aload 42
    //   427: astore 41
    //   429: aload 41
    //   431: ifnull +10 -> 441
    //   434: aload 41
    //   436: aload 4
    //   438: invokevirtual 228	com/alibaba/fastjson/parser/ParseContext:setObject	(Ljava/lang/Object;)V
    //   441: aload_1
    //   442: aload 7
    //   444: invokevirtual 232	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   447: aload 4
    //   449: areturn
    //   450: aload 5
    //   452: invokeinterface 215 1 0
    //   457: bipush 16
    //   459: if_icmpne +13 -> 472
    //   462: aload_1
    //   463: getstatic 287	com/alibaba/fastjson/parser/Feature:AllowArbitraryCommas	Lcom/alibaba/fastjson/parser/Feature;
    //   466: invokevirtual 163	com/alibaba/fastjson/parser/DefaultJSONParser:isEnabled	(Lcom/alibaba/fastjson/parser/Feature;)Z
    //   469: ifne -129 -> 340
    //   472: ldc_w 289
    //   475: aload 21
    //   477: if_acmpne +318 -> 795
    //   480: aload 5
    //   482: iconst_4
    //   483: invokeinterface 292 2 0
    //   488: aload 5
    //   490: invokeinterface 215 1 0
    //   495: iconst_4
    //   496: if_icmpne +222 -> 718
    //   499: aload 5
    //   501: invokeinterface 295 1 0
    //   506: astore 22
    //   508: ldc_w 297
    //   511: aload 22
    //   513: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   516: ifeq +42 -> 558
    //   519: aload 7
    //   521: invokevirtual 200	com/alibaba/fastjson/parser/ParseContext:getObject	()Ljava/lang/Object;
    //   524: astore 20
    //   526: aload 5
    //   528: bipush 13
    //   530: invokeinterface 219 2 0
    //   535: aload 5
    //   537: invokeinterface 215 1 0
    //   542: bipush 13
    //   544: if_icmpeq +211 -> 755
    //   547: new 175	com/alibaba/fastjson/JSONException
    //   550: dup
    //   551: ldc_w 302
    //   554: invokespecial 267	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   557: athrow
    //   558: ldc_w 304
    //   561: aload 22
    //   563: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   566: ifeq +55 -> 621
    //   569: aload 7
    //   571: invokevirtual 222	com/alibaba/fastjson/parser/ParseContext:getParentContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   574: astore 25
    //   576: aload 25
    //   578: invokevirtual 200	com/alibaba/fastjson/parser/ParseContext:getObject	()Ljava/lang/Object;
    //   581: ifnull +13 -> 594
    //   584: aload 25
    //   586: invokevirtual 200	com/alibaba/fastjson/parser/ParseContext:getObject	()Ljava/lang/Object;
    //   589: astore 26
    //   591: goto +899 -> 1490
    //   594: aload_1
    //   595: new 306	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   598: dup
    //   599: aload 25
    //   601: aload 22
    //   603: invokespecial 309	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   606: invokevirtual 313	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   609: aload_1
    //   610: iconst_1
    //   611: invokevirtual 273	com/alibaba/fastjson/parser/DefaultJSONParser:setResolveStatus	(I)V
    //   614: aload 20
    //   616: astore 26
    //   618: goto +872 -> 1490
    //   621: ldc_w 315
    //   624: aload 22
    //   626: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   629: ifeq +66 -> 695
    //   632: aload 7
    //   634: astore 23
    //   636: aload 23
    //   638: invokevirtual 222	com/alibaba/fastjson/parser/ParseContext:getParentContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   641: ifnull +13 -> 654
    //   644: aload 23
    //   646: invokevirtual 222	com/alibaba/fastjson/parser/ParseContext:getParentContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   649: astore 23
    //   651: goto -15 -> 636
    //   654: aload 23
    //   656: invokevirtual 200	com/alibaba/fastjson/parser/ParseContext:getObject	()Ljava/lang/Object;
    //   659: ifnull +13 -> 672
    //   662: aload 23
    //   664: invokevirtual 200	com/alibaba/fastjson/parser/ParseContext:getObject	()Ljava/lang/Object;
    //   667: astore 20
    //   669: goto -143 -> 526
    //   672: aload_1
    //   673: new 306	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   676: dup
    //   677: aload 23
    //   679: aload 22
    //   681: invokespecial 309	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   684: invokevirtual 313	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   687: aload_1
    //   688: iconst_1
    //   689: invokevirtual 273	com/alibaba/fastjson/parser/DefaultJSONParser:setResolveStatus	(I)V
    //   692: goto -166 -> 526
    //   695: aload_1
    //   696: new 306	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   699: dup
    //   700: aload 7
    //   702: aload 22
    //   704: invokespecial 309	com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask:<init>	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   707: invokevirtual 313	com/alibaba/fastjson/parser/DefaultJSONParser:addResolveTask	(Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   710: aload_1
    //   711: iconst_1
    //   712: invokevirtual 273	com/alibaba/fastjson/parser/DefaultJSONParser:setResolveStatus	(I)V
    //   715: goto -189 -> 526
    //   718: new 175	com/alibaba/fastjson/JSONException
    //   721: dup
    //   722: new 177	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 317
    //   732: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 5
    //   737: invokeinterface 215 1 0
    //   742: invokestatic 323	com/alibaba/fastjson/parser/JSONToken:name	(I)Ljava/lang/String;
    //   745: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokespecial 267	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   754: athrow
    //   755: aload 5
    //   757: bipush 16
    //   759: invokeinterface 219 2 0
    //   764: aload_1
    //   765: aload 7
    //   767: aload 20
    //   769: aload_3
    //   770: invokevirtual 284	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   773: pop
    //   774: aload 19
    //   776: ifnull +10 -> 786
    //   779: aload 19
    //   781: aload 20
    //   783: invokevirtual 228	com/alibaba/fastjson/parser/ParseContext:setObject	(Ljava/lang/Object;)V
    //   786: aload_1
    //   787: aload 7
    //   789: invokevirtual 232	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   792: aload 20
    //   794: areturn
    //   795: getstatic 329	com/alibaba/fastjson/JSON:DEFAULT_TYPE_KEY	Ljava/lang/String;
    //   798: aload 21
    //   800: if_acmpne +151 -> 951
    //   803: aload 5
    //   805: iconst_4
    //   806: invokeinterface 292 2 0
    //   811: aload 5
    //   813: invokeinterface 215 1 0
    //   818: iconst_4
    //   819: if_icmpne +121 -> 940
    //   822: aload 5
    //   824: invokeinterface 295 1 0
    //   829: astore 44
    //   831: aload 5
    //   833: bipush 16
    //   835: invokeinterface 219 2 0
    //   840: aload_2
    //   841: instanceof 115
    //   844: ifeq +48 -> 892
    //   847: aload 44
    //   849: aload_2
    //   850: checkcast 115	java/lang/Class
    //   853: invokevirtual 185	java/lang/Class:getName	()Ljava/lang/String;
    //   856: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   859: ifeq +33 -> 892
    //   862: aload 5
    //   864: invokeinterface 215 1 0
    //   869: bipush 13
    //   871: if_icmpne -531 -> 340
    //   874: aload 5
    //   876: invokeinterface 331 1 0
    //   881: aload 20
    //   883: astore 11
    //   885: aload 19
    //   887: astore 8
    //   889: goto -502 -> 387
    //   892: aload 44
    //   894: invokestatic 337	com/alibaba/fastjson/util/TypeUtils:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   897: astore 45
    //   899: aload_1
    //   900: invokevirtual 341	com/alibaba/fastjson/parser/DefaultJSONParser:getConfig	()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   903: aload 45
    //   905: invokevirtual 345	com/alibaba/fastjson/parser/ParserConfig:getDeserializer	(Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   908: aload_1
    //   909: aload 45
    //   911: aload_3
    //   912: invokeinterface 347 4 0
    //   917: astore 46
    //   919: aload 19
    //   921: ifnull +10 -> 931
    //   924: aload 19
    //   926: aload 20
    //   928: invokevirtual 228	com/alibaba/fastjson/parser/ParseContext:setObject	(Ljava/lang/Object;)V
    //   931: aload_1
    //   932: aload 7
    //   934: invokevirtual 232	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   937: aload 46
    //   939: areturn
    //   940: new 175	com/alibaba/fastjson/JSONException
    //   943: dup
    //   944: ldc_w 349
    //   947: invokespecial 267	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   950: athrow
    //   951: aload 20
    //   953: ifnonnull +495 -> 1448
    //   956: aload 9
    //   958: ifnonnull +490 -> 1448
    //   961: aload_0
    //   962: aload_1
    //   963: aload_2
    //   964: invokevirtual 224	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:createInstance	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   967: astore 20
    //   969: aload 20
    //   971: ifnonnull +21 -> 992
    //   974: new 351	java/util/HashMap
    //   977: dup
    //   978: aload_0
    //   979: getfield 36	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:fieldDeserializers	Ljava/util/List;
    //   982: invokeinterface 354 1 0
    //   987: invokespecial 356	java/util/HashMap:<init>	(I)V
    //   990: astore 9
    //   992: aload_1
    //   993: aload 7
    //   995: aload 20
    //   997: aload_3
    //   998: invokevirtual 284	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   1001: astore 43
    //   1003: aload 43
    //   1005: astore 27
    //   1007: aload 20
    //   1009: astore 28
    //   1011: aload_0
    //   1012: aload_1
    //   1013: aload 21
    //   1015: aload 28
    //   1017: aload_2
    //   1018: aload 9
    //   1020: invokevirtual 360	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:parseField	(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)Z
    //   1023: ifne +33 -> 1056
    //   1026: aload 5
    //   1028: invokeinterface 215 1 0
    //   1033: bipush 13
    //   1035: if_icmpne +424 -> 1459
    //   1038: aload 5
    //   1040: invokeinterface 331 1 0
    //   1045: aload 27
    //   1047: astore 8
    //   1049: aload 28
    //   1051: astore 11
    //   1053: goto -666 -> 387
    //   1056: aload 5
    //   1058: invokeinterface 215 1 0
    //   1063: bipush 16
    //   1065: if_icmpne +14 -> 1079
    //   1068: aload 28
    //   1070: astore 20
    //   1072: aload 27
    //   1074: astore 19
    //   1076: goto -736 -> 340
    //   1079: aload 5
    //   1081: invokeinterface 215 1 0
    //   1086: bipush 13
    //   1088: if_icmpne +23 -> 1111
    //   1091: aload 5
    //   1093: bipush 16
    //   1095: invokeinterface 219 2 0
    //   1100: aload 27
    //   1102: astore 8
    //   1104: aload 28
    //   1106: astore 11
    //   1108: goto -721 -> 387
    //   1111: aload 5
    //   1113: invokeinterface 215 1 0
    //   1118: bipush 18
    //   1120: if_icmpeq +14 -> 1134
    //   1123: aload 5
    //   1125: invokeinterface 215 1 0
    //   1130: iconst_1
    //   1131: if_icmpne +53 -> 1184
    //   1134: new 175	com/alibaba/fastjson/JSONException
    //   1137: dup
    //   1138: new 177	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1145: ldc_w 362
    //   1148: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: aload 5
    //   1153: invokeinterface 215 1 0
    //   1158: invokestatic 323	com/alibaba/fastjson/parser/JSONToken:name	(I)Ljava/lang/String;
    //   1161: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokespecial 267	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   1170: athrow
    //   1171: astore 10
    //   1173: aload 27
    //   1175: astore 8
    //   1177: aload 28
    //   1179: astore 11
    //   1181: goto -882 -> 299
    //   1184: aload 28
    //   1186: astore 20
    //   1188: aload 27
    //   1190: astore 19
    //   1192: goto -852 -> 340
    //   1195: aload_0
    //   1196: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   1199: invokevirtual 52	com/alibaba/fastjson/util/DeserializeBeanInfo:getFieldList	()Ljava/util/List;
    //   1202: astore 30
    //   1204: aload 30
    //   1206: invokeinterface 354 1 0
    //   1211: istore 31
    //   1213: iload 31
    //   1215: anewarray 4	java/lang/Object
    //   1218: astore 32
    //   1220: iconst_0
    //   1221: istore 33
    //   1223: iload 33
    //   1225: iload 31
    //   1227: if_icmpge +36 -> 1263
    //   1230: aload 32
    //   1232: iload 33
    //   1234: aload 9
    //   1236: aload 30
    //   1238: iload 33
    //   1240: invokeinterface 365 2 0
    //   1245: checkcast 70	com/alibaba/fastjson/util/FieldInfo
    //   1248: invokevirtual 81	com/alibaba/fastjson/util/FieldInfo:getName	()Ljava/lang/String;
    //   1251: invokeinterface 92 2 0
    //   1256: aastore
    //   1257: iinc 33 1
    //   1260: goto -37 -> 1223
    //   1263: aload_0
    //   1264: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   1267: invokevirtual 368	com/alibaba/fastjson/util/DeserializeBeanInfo:getCreatorConstructor	()Ljava/lang/reflect/Constructor;
    //   1270: astore 34
    //   1272: aload 34
    //   1274: ifnull +83 -> 1357
    //   1277: aload_0
    //   1278: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   1281: invokevirtual 368	com/alibaba/fastjson/util/DeserializeBeanInfo:getCreatorConstructor	()Ljava/lang/reflect/Constructor;
    //   1284: aload 32
    //   1286: invokevirtual 151	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1289: astore 39
    //   1291: aload 39
    //   1293: astore 29
    //   1295: aload 8
    //   1297: ifnull +10 -> 1307
    //   1300: aload 8
    //   1302: aload 29
    //   1304: invokevirtual 228	com/alibaba/fastjson/parser/ParseContext:setObject	(Ljava/lang/Object;)V
    //   1307: aload_1
    //   1308: aload 7
    //   1310: invokevirtual 232	com/alibaba/fastjson/parser/DefaultJSONParser:setContext	(Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1313: aload 29
    //   1315: areturn
    //   1316: astore 38
    //   1318: new 175	com/alibaba/fastjson/JSONException
    //   1321: dup
    //   1322: new 177	java/lang/StringBuilder
    //   1325: dup
    //   1326: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1329: ldc_w 370
    //   1332: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: aload_0
    //   1336: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   1339: invokevirtual 368	com/alibaba/fastjson/util/DeserializeBeanInfo:getCreatorConstructor	()Ljava/lang/reflect/Constructor;
    //   1342: invokevirtual 373	java/lang/reflect/Constructor:toGenericString	()Ljava/lang/String;
    //   1345: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1351: aload 38
    //   1353: invokespecial 191	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1356: athrow
    //   1357: aload_0
    //   1358: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   1361: invokevirtual 377	com/alibaba/fastjson/util/DeserializeBeanInfo:getFactoryMethod	()Ljava/lang/reflect/Method;
    //   1364: astore 35
    //   1366: aload 35
    //   1368: ifnull +66 -> 1434
    //   1371: aload_0
    //   1372: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   1375: invokevirtual 377	com/alibaba/fastjson/util/DeserializeBeanInfo:getFactoryMethod	()Ljava/lang/reflect/Method;
    //   1378: aconst_null
    //   1379: aload 32
    //   1381: invokevirtual 383	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1384: astore 37
    //   1386: aload 37
    //   1388: astore 29
    //   1390: goto -95 -> 1295
    //   1393: astore 36
    //   1395: new 175	com/alibaba/fastjson/JSONException
    //   1398: dup
    //   1399: new 177	java/lang/StringBuilder
    //   1402: dup
    //   1403: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1406: ldc_w 385
    //   1409: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: aload_0
    //   1413: getfield 48	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   1416: invokevirtual 377	com/alibaba/fastjson/util/DeserializeBeanInfo:getFactoryMethod	()Ljava/lang/reflect/Method;
    //   1419: invokevirtual 386	java/lang/reflect/Method:toString	()Ljava/lang/String;
    //   1422: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1428: aload 36
    //   1430: invokespecial 191	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1433: athrow
    //   1434: aload 11
    //   1436: astore 29
    //   1438: goto -143 -> 1295
    //   1441: aload 8
    //   1443: astore 41
    //   1445: goto -1016 -> 429
    //   1448: aload 19
    //   1450: astore 27
    //   1452: aload 20
    //   1454: astore 28
    //   1456: goto -445 -> 1011
    //   1459: aload 28
    //   1461: astore 20
    //   1463: aload 27
    //   1465: astore 19
    //   1467: goto -1127 -> 340
    //   1470: aload 6
    //   1472: astore 7
    //   1474: goto -1422 -> 52
    //   1477: astore 10
    //   1479: aload 20
    //   1481: astore 11
    //   1483: aload 19
    //   1485: astore 8
    //   1487: goto -1188 -> 299
    //   1490: aload 26
    //   1492: astore 20
    //   1494: goto -968 -> 526
    //   1497: astore 10
    //   1499: goto -1200 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1502	0	this	JavaBeanDeserializer
    //   0	1502	1	paramDefaultJSONParser	DefaultJSONParser
    //   0	1502	2	paramType	Type
    //   0	1502	3	paramObject1	Object
    //   0	1502	4	paramObject2	Object
    //   4	1148	5	localJSONLexer	JSONLexer
    //   33	1438	6	localParseContext1	com.alibaba.fastjson.parser.ParseContext
    //   50	1423	7	localParseContext2	com.alibaba.fastjson.parser.ParseContext
    //   53	1433	8	localObject1	Object
    //   56	1179	9	localHashMap	java.util.HashMap
    //   293	25	10	localObject2	Object
    //   1171	1	10	localObject3	Object
    //   1477	1	10	localObject4	Object
    //   1497	1	10	localObject5	Object
    //   297	1185	11	localObject6	Object
    //   125	10	12	i	int
    //   143	6	13	bool	boolean
    //   162	19	14	localObject7	Object
    //   190	10	15	j	int
    //   209	10	16	k	int
    //   258	27	17	localStringBuffer	java.lang.StringBuffer
    //   334	1150	19	localObject8	Object
    //   338	1155	20	localObject9	Object
    //   351	663	21	str1	String
    //   506	197	22	str2	String
    //   634	44	23	localParseContext3	com.alibaba.fastjson.parser.ParseContext
    //   574	26	25	localParseContext4	com.alibaba.fastjson.parser.ParseContext
    //   589	902	26	localObject10	Object
    //   1005	459	27	localObject11	Object
    //   1009	451	28	localObject12	Object
    //   1293	144	29	localObject13	Object
    //   1202	35	30	localList	List
    //   1211	17	31	m	int
    //   1218	162	32	arrayOfObject	Object[]
    //   1221	37	33	n	int
    //   1270	3	34	localConstructor	java.lang.reflect.Constructor
    //   1364	3	35	localMethod	java.lang.reflect.Method
    //   1393	36	36	localException1	java.lang.Exception
    //   1384	3	37	localObject14	Object
    //   1316	36	38	localException2	java.lang.Exception
    //   1289	3	39	localObject15	Object
    //   403	3	40	localObject16	Object
    //   427	1017	41	localObject17	Object
    //   423	3	42	localParseContext5	com.alibaba.fastjson.parser.ParseContext
    //   1001	3	43	localParseContext6	com.alibaba.fastjson.parser.ParseContext
    //   829	64	44	str3	String
    //   897	13	45	localClass	Class
    //   917	21	46	localObject18	Object
    //   93	3	47	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   58	79	293	finally
    //   87	95	293	finally
    //   118	127	293	finally
    //   137	145	293	finally
    //   153	164	293	finally
    //   183	192	293	finally
    //   202	211	293	finally
    //   221	280	293	finally
    //   280	293	293	finally
    //   320	333	293	finally
    //   414	425	293	finally
    //   1011	1045	1171	finally
    //   1056	1068	1171	finally
    //   1079	1100	1171	finally
    //   1111	1134	1171	finally
    //   1134	1171	1171	finally
    //   1277	1291	1316	java/lang/Exception
    //   1371	1386	1393	java/lang/Exception
    //   340	353	1477	finally
    //   358	379	1477	finally
    //   450	472	1477	finally
    //   480	526	1477	finally
    //   526	558	1477	finally
    //   558	591	1477	finally
    //   594	614	1477	finally
    //   621	632	1477	finally
    //   636	651	1477	finally
    //   654	669	1477	finally
    //   672	692	1477	finally
    //   695	715	1477	finally
    //   718	755	1477	finally
    //   755	774	1477	finally
    //   795	881	1477	finally
    //   892	919	1477	finally
    //   940	951	1477	finally
    //   961	969	1477	finally
    //   974	992	1477	finally
    //   992	1003	1477	finally
    //   397	405	1497	finally
    //   1195	1220	1497	finally
    //   1230	1257	1497	finally
    //   1263	1272	1497	finally
    //   1277	1291	1497	finally
    //   1318	1357	1497	finally
    //   1357	1366	1497	finally
    //   1371	1386	1497	finally
    //   1395	1434	1497	finally
  }
  
  public <T> T deserialzeArrayMapping(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() != 14) {
      throw new JSONException("error");
    }
    Object localObject = createInstance(paramDefaultJSONParser, paramType);
    int i = this.sortedFieldDeserializers.size();
    int j = 0;
    if (j < i)
    {
      char c;
      label71:
      FieldDeserializer localFieldDeserializer;
      Class localClass;
      if (j == i - 1)
      {
        c = ']';
        localFieldDeserializer = (FieldDeserializer)this.sortedFieldDeserializers.get(j);
        localClass = localFieldDeserializer.getFieldClass();
        if (localClass != Integer.TYPE) {
          break label131;
        }
        localFieldDeserializer.setValue(localObject, localJSONLexer.scanInt(c));
      }
      label131:
      label284:
      do
      {
        for (;;)
        {
          j++;
          break;
          c = ',';
          break label71;
          if (localClass == String.class)
          {
            localFieldDeserializer.setValue(localObject, localJSONLexer.scanString(c));
          }
          else if (localClass == Long.TYPE)
          {
            localFieldDeserializer.setValue(localObject, localJSONLexer.scanLong(c));
          }
          else if (localClass.isEnum())
          {
            localFieldDeserializer.setValue(localObject, localJSONLexer.scanEnum(localClass, paramDefaultJSONParser.getSymbolTable(), c));
          }
          else
          {
            localJSONLexer.nextToken(14);
            localFieldDeserializer.setValue(localObject, paramDefaultJSONParser.parseObject(localFieldDeserializer.getFieldType()));
            if (c != ']') {
              break label284;
            }
            if (localJSONLexer.token() != 15) {
              throw new JSONException("syntax error");
            }
            localJSONLexer.nextToken(16);
          }
        }
      } while ((c != ',') || (localJSONLexer.token() == 16));
      throw new JSONException("syntax error");
    }
    localJSONLexer.nextToken(16);
    return localObject;
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public Map<String, FieldDeserializer> getFieldDeserializerMap()
  {
    return this.feildDeserializerMap;
  }
  
  public final boolean isSupportArrayToBean(JSONLexer paramJSONLexer)
  {
    return (Feature.isEnabled(this.beanInfo.getParserFeatures(), Feature.SupportArrayToBean)) || (paramJSONLexer.isEnabled(Feature.SupportArrayToBean));
  }
  
  void parseExtra(DefaultJSONParser paramDefaultJSONParser, Object paramObject, String paramString)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (!localJSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
      throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + paramString);
    }
    localJSONLexer.nextTokenWithColon();
    Type localType = FilterUtils.getExtratype(paramDefaultJSONParser, paramObject, paramString);
    if (localType == null) {}
    for (Object localObject = paramDefaultJSONParser.parse();; localObject = paramDefaultJSONParser.parseObject(localType))
    {
      FilterUtils.processExtra(paramDefaultJSONParser, paramObject, paramString, localObject);
      return;
    }
  }
  
  public boolean parseField(DefaultJSONParser paramDefaultJSONParser, String paramString, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    FieldDeserializer localFieldDeserializer = (FieldDeserializer)this.feildDeserializerMap.get(paramString);
    if (localFieldDeserializer == null)
    {
      Iterator localIterator = this.feildDeserializerMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((String)localEntry.getKey()).equalsIgnoreCase(paramString)) {
          localFieldDeserializer = (FieldDeserializer)localEntry.getValue();
        }
      }
    }
    if (localFieldDeserializer == null)
    {
      parseExtra(paramDefaultJSONParser, paramObject, paramString);
      return false;
    }
    localJSONLexer.nextTokenWithColon(localFieldDeserializer.getFastMatchToken());
    localFieldDeserializer.parseField(paramDefaultJSONParser, paramObject, paramType, paramMap);
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */