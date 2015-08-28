package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class JSONSerializer
{
  private List<AfterFilter> afterFilters = null;
  private List<BeforeFilter> beforeFilters = null;
  private final SerializeConfig config;
  private SerialContext context;
  private DateFormat dateFormat;
  private String dateFormatPattern;
  private String indent = "\t";
  private int indentCount = 0;
  private List<NameFilter> nameFilters = null;
  private final SerializeWriter out;
  private List<PropertyFilter> propertyFilters = null;
  private List<PropertyPreFilter> propertyPreFilters = null;
  private IdentityHashMap<Object, SerialContext> references = null;
  private List<ValueFilter> valueFilters = null;
  
  public JSONSerializer()
  {
    this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeConfig paramSerializeConfig)
  {
    this(new SerializeWriter(), paramSerializeConfig);
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter)
  {
    this(paramSerializeWriter, SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter, SerializeConfig paramSerializeConfig)
  {
    this.out = paramSerializeWriter;
    this.config = paramSerializeConfig;
  }
  
  public static final void write(SerializeWriter paramSerializeWriter, Object paramObject)
  {
    new JSONSerializer(paramSerializeWriter).write(paramObject);
  }
  
  public static final void write(Writer paramWriter, Object paramObject)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      new JSONSerializer(localSerializeWriter).write(paramObject);
      localSerializeWriter.writeTo(paramWriter);
      return;
    }
    catch (IOException localIOException)
    {
      throw new JSONException(localIOException.getMessage(), localIOException);
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public void close()
  {
    this.out.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    this.out.config(paramSerializerFeature, paramBoolean);
  }
  
  public boolean containsReference(Object paramObject)
  {
    if (this.references == null) {
      return false;
    }
    return this.references.containsKey(paramObject);
  }
  
  public void decrementIdent()
  {
    this.indentCount = (-1 + this.indentCount);
  }
  
  public List<AfterFilter> getAfterFilters()
  {
    if (this.afterFilters == null) {
      this.afterFilters = new ArrayList();
    }
    return this.afterFilters;
  }
  
  public List<AfterFilter> getAfterFiltersDirect()
  {
    return this.afterFilters;
  }
  
  public List<BeforeFilter> getBeforeFilters()
  {
    if (this.beforeFilters == null) {
      this.beforeFilters = new ArrayList();
    }
    return this.beforeFilters;
  }
  
  public List<BeforeFilter> getBeforeFiltersDirect()
  {
    return this.beforeFilters;
  }
  
  public SerialContext getContext()
  {
    return this.context;
  }
  
  public DateFormat getDateFormat()
  {
    if ((this.dateFormat == null) && (this.dateFormatPattern != null)) {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern);
    }
    return this.dateFormat;
  }
  
  public String getDateFormatPattern()
  {
    if ((this.dateFormat instanceof SimpleDateFormat)) {
      return ((SimpleDateFormat)this.dateFormat).toPattern();
    }
    return this.dateFormatPattern;
  }
  
  public int getIndentCount()
  {
    return this.indentCount;
  }
  
  public SerializeConfig getMapping()
  {
    return this.config;
  }
  
  public List<NameFilter> getNameFilters()
  {
    if (this.nameFilters == null) {
      this.nameFilters = new ArrayList();
    }
    return this.nameFilters;
  }
  
  public List<NameFilter> getNameFiltersDirect()
  {
    return this.nameFilters;
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass)
  {
    ObjectSerializer localObjectSerializer1 = (ObjectSerializer)this.config.get(paramClass);
    if (localObjectSerializer1 == null)
    {
      if (!Map.class.isAssignableFrom(paramClass)) {
        break label51;
      }
      this.config.put(paramClass, MapSerializer.instance);
    }
    for (;;)
    {
      localObjectSerializer1 = (ObjectSerializer)this.config.get(paramClass);
      return localObjectSerializer1;
      label51:
      if (List.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, ListSerializer.instance);
      }
      else if (Collection.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, CollectionSerializer.instance);
      }
      else if (Date.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, DateSerializer.instance);
      }
      else if (JSONAware.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, JSONAwareSerializer.instance);
      }
      else if (JSONSerializable.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, JSONSerializableSerializer.instance);
      }
      else if (JSONStreamAware.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, JSONStreamAwareSerializer.instance);
      }
      else if ((paramClass.isEnum()) || ((paramClass.getSuperclass() != null) && (paramClass.getSuperclass().isEnum())))
      {
        this.config.put(paramClass, EnumSerializer.instance);
      }
      else if (paramClass.isArray())
      {
        Class localClass2 = paramClass.getComponentType();
        ObjectSerializer localObjectSerializer3 = getObjectWriter(localClass2);
        this.config.put(paramClass, new ArraySerializer(localClass2, localObjectSerializer3));
      }
      else if (Throwable.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, new ExceptionSerializer(paramClass));
      }
      else if (TimeZone.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, TimeZoneCodec.instance);
      }
      else if (Charset.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, CharsetCodec.instance);
      }
      else if (Enumeration.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, EnumerationSeriliazer.instance);
      }
      else
      {
        if (!Calendar.class.isAssignableFrom(paramClass)) {
          break;
        }
        this.config.put(paramClass, CalendarCodec.instance);
      }
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    int j = 0;
    label419:
    Class localClass1;
    int k;
    int m;
    if (j < i)
    {
      localClass1 = arrayOfClass[j];
      if ((localClass1.getName().equals("net.sf.cglib.proxy.Factory")) || (localClass1.getName().equals("org.springframework.cglib.proxy.Factory")))
      {
        k = 0;
        m = 1;
      }
    }
    for (;;)
    {
      if ((m != 0) || (k != 0))
      {
        ObjectSerializer localObjectSerializer2 = getObjectWriter(paramClass.getSuperclass());
        this.config.put(paramClass, localObjectSerializer2);
        return localObjectSerializer2;
        if (localClass1.getName().equals("javassist.util.proxy.ProxyObject"))
        {
          k = 1;
          m = 0;
          continue;
        }
        j++;
        break label419;
      }
      if (Proxy.isProxyClass(paramClass))
      {
        this.config.put(paramClass, this.config.createJavaBeanSerializer(paramClass));
        break;
      }
      this.config.put(paramClass, this.config.createJavaBeanSerializer(paramClass));
      break;
      k = 0;
      m = 0;
    }
  }
  
  public List<PropertyFilter> getPropertyFilters()
  {
    if (this.propertyFilters == null) {
      this.propertyFilters = new ArrayList();
    }
    return this.propertyFilters;
  }
  
  public List<PropertyFilter> getPropertyFiltersDirect()
  {
    return this.propertyFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFilters()
  {
    if (this.propertyPreFilters == null) {
      this.propertyPreFilters = new ArrayList();
    }
    return this.propertyPreFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFiltersDirect()
  {
    return this.propertyPreFilters;
  }
  
  public SerialContext getSerialContext(Object paramObject)
  {
    if (this.references == null) {
      return null;
    }
    return (SerialContext)this.references.get(paramObject);
  }
  
  public List<ValueFilter> getValueFilters()
  {
    if (this.valueFilters == null) {
      this.valueFilters = new ArrayList();
    }
    return this.valueFilters;
  }
  
  public List<ValueFilter> getValueFiltersDirect()
  {
    return this.valueFilters;
  }
  
  public SerializeWriter getWriter()
  {
    return this.out;
  }
  
  public void incrementIndent()
  {
    this.indentCount = (1 + this.indentCount);
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return this.out.isEnabled(paramSerializerFeature);
  }
  
  public final boolean isWriteClassName(Type paramType, Object paramObject)
  {
    if (!this.out.isEnabled(SerializerFeature.WriteClassName)) {}
    for (;;)
    {
      return false;
      if ((paramType == null) && (isEnabled(SerializerFeature.NotWriteRootClassName))) {
        if (this.context.getParent() != null) {
          break label47;
        }
      }
      label47:
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
    }
  }
  
  public void println()
  {
    this.out.write('\n');
    for (int i = 0; i < this.indentCount; i++) {
      this.out.write(this.indent);
    }
  }
  
  public void setContext(SerialContext paramSerialContext)
  {
    this.context = paramSerialContext;
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt)
  {
    if (isEnabled(SerializerFeature.DisableCircularReferenceDetect)) {
      return;
    }
    this.context = new SerialContext(paramSerialContext, paramObject1, paramObject2, paramInt);
    if (this.references == null) {
      this.references = new IdentityHashMap();
    }
    this.references.put(paramObject1, this.context);
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormatPattern = paramString;
    if (this.dateFormat != null) {
      this.dateFormat = null;
    }
  }
  
  public void setDateFormat(DateFormat paramDateFormat)
  {
    this.dateFormat = paramDateFormat;
    if (this.dateFormatPattern != null) {
      this.dateFormatPattern = null;
    }
  }
  
  public String toString()
  {
    return this.out.toString();
  }
  
  public final void write(Object paramObject)
  {
    if (paramObject == null)
    {
      this.out.writeNull();
      return;
    }
    ObjectSerializer localObjectSerializer = getObjectWriter(paramObject.getClass());
    try
    {
      localObjectSerializer.write(this, paramObject, null, null);
      return;
    }
    catch (IOException localIOException)
    {
      throw new JSONException(localIOException.getMessage(), localIOException);
    }
  }
  
  public final void write(String paramString)
  {
    StringCodec.instance.write(this, paramString);
  }
  
  protected final void writeKeyValue(char paramChar, String paramString, Object paramObject)
  {
    if (paramChar != 0) {
      this.out.write(paramChar);
    }
    this.out.writeFieldName(paramString);
    write(paramObject);
  }
  
  public void writeNull()
  {
    this.out.writeNull();
  }
  
  public void writeReference(Object paramObject)
  {
    SerialContext localSerialContext1 = getContext();
    if (paramObject == localSerialContext1.getObject())
    {
      this.out.write("{\"$ref\":\"@\"}");
      return;
    }
    SerialContext localSerialContext2 = localSerialContext1.getParent();
    if ((localSerialContext2 != null) && (paramObject == localSerialContext2.getObject()))
    {
      this.out.write("{\"$ref\":\"..\"}");
      return;
    }
    while (localSerialContext1.getParent() != null) {
      localSerialContext1 = localSerialContext1.getParent();
    }
    if (paramObject == localSerialContext1.getObject())
    {
      this.out.write("{\"$ref\":\"$\"}");
      return;
    }
    String str = getSerialContext(paramObject).getPath();
    this.out.write("{\"$ref\":\"");
    this.out.write(str);
    this.out.write("\"}");
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2)
  {
    writeWithFieldName(paramObject1, paramObject2, null, 0);
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2, Type paramType, int paramInt)
  {
    if (paramObject1 == null) {}
    try
    {
      this.out.writeNull();
      return;
    }
    catch (IOException localIOException)
    {
      throw new JSONException(localIOException.getMessage(), localIOException);
    }
    getObjectWriter(paramObject1.getClass()).write(this, paramObject1, paramObject2, paramType);
  }
  
  public final void writeWithFormat(Object paramObject, String paramString)
  {
    if ((paramObject instanceof Date))
    {
      Object localObject = getDateFormat();
      if (localObject == null) {
        localObject = new SimpleDateFormat(paramString);
      }
      String str = ((DateFormat)localObject).format((Date)paramObject);
      this.out.writeString(str);
      return;
    }
    write(paramObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.JSONSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */