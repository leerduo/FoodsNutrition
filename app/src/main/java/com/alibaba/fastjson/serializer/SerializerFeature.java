package com.alibaba.fastjson.serializer;

public enum SerializerFeature
{
  private final int mask = 1 << ordinal();
  
  static
  {
    WriteEnumUsingToString = new SerializerFeature("WriteEnumUsingToString", 3);
    UseISO8601DateFormat = new SerializerFeature("UseISO8601DateFormat", 4);
    WriteNullListAsEmpty = new SerializerFeature("WriteNullListAsEmpty", 5);
    WriteNullStringAsEmpty = new SerializerFeature("WriteNullStringAsEmpty", 6);
    WriteNullNumberAsZero = new SerializerFeature("WriteNullNumberAsZero", 7);
    WriteNullBooleanAsFalse = new SerializerFeature("WriteNullBooleanAsFalse", 8);
    SkipTransientField = new SerializerFeature("SkipTransientField", 9);
    SortField = new SerializerFeature("SortField", 10);
    WriteTabAsSpecial = new SerializerFeature("WriteTabAsSpecial", 11);
    PrettyFormat = new SerializerFeature("PrettyFormat", 12);
    WriteClassName = new SerializerFeature("WriteClassName", 13);
    DisableCircularReferenceDetect = new SerializerFeature("DisableCircularReferenceDetect", 14);
    WriteSlashAsSpecial = new SerializerFeature("WriteSlashAsSpecial", 15);
    BrowserCompatible = new SerializerFeature("BrowserCompatible", 16);
    WriteDateUseDateFormat = new SerializerFeature("WriteDateUseDateFormat", 17);
    NotWriteRootClassName = new SerializerFeature("NotWriteRootClassName", 18);
    DisableCheckSpecialChar = new SerializerFeature("DisableCheckSpecialChar", 19);
    BeanToArray = new SerializerFeature("BeanToArray", 20);
    WriteNonStringKeyAsString = new SerializerFeature("WriteNonStringKeyAsString", 21);
    NotWriteDefaultValue = new SerializerFeature("NotWriteDefaultValue", 22);
    SerializerFeature[] arrayOfSerializerFeature = new SerializerFeature[23];
    arrayOfSerializerFeature[0] = QuoteFieldNames;
    arrayOfSerializerFeature[1] = UseSingleQuotes;
    arrayOfSerializerFeature[2] = WriteMapNullValue;
    arrayOfSerializerFeature[3] = WriteEnumUsingToString;
    arrayOfSerializerFeature[4] = UseISO8601DateFormat;
    arrayOfSerializerFeature[5] = WriteNullListAsEmpty;
    arrayOfSerializerFeature[6] = WriteNullStringAsEmpty;
    arrayOfSerializerFeature[7] = WriteNullNumberAsZero;
    arrayOfSerializerFeature[8] = WriteNullBooleanAsFalse;
    arrayOfSerializerFeature[9] = SkipTransientField;
    arrayOfSerializerFeature[10] = SortField;
    arrayOfSerializerFeature[11] = WriteTabAsSpecial;
    arrayOfSerializerFeature[12] = PrettyFormat;
    arrayOfSerializerFeature[13] = WriteClassName;
    arrayOfSerializerFeature[14] = DisableCircularReferenceDetect;
    arrayOfSerializerFeature[15] = WriteSlashAsSpecial;
    arrayOfSerializerFeature[16] = BrowserCompatible;
    arrayOfSerializerFeature[17] = WriteDateUseDateFormat;
    arrayOfSerializerFeature[18] = NotWriteRootClassName;
    arrayOfSerializerFeature[19] = DisableCheckSpecialChar;
    arrayOfSerializerFeature[20] = BeanToArray;
    arrayOfSerializerFeature[21] = WriteNonStringKeyAsString;
    arrayOfSerializerFeature[22] = NotWriteDefaultValue;
  }
  
  private SerializerFeature() {}
  
  public static int config(int paramInt, SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt | paramSerializerFeature.getMask();
    }
    return paramInt & (0xFFFFFFFF ^ paramSerializerFeature.getMask());
  }
  
  public static boolean isEnabled(int paramInt, SerializerFeature paramSerializerFeature)
  {
    return (paramInt & paramSerializerFeature.getMask()) != 0;
  }
  
  public static int of(SerializerFeature[] paramArrayOfSerializerFeature)
  {
    int i = 0;
    if (paramArrayOfSerializerFeature == null) {}
    for (;;)
    {
      return i;
      int j = paramArrayOfSerializerFeature.length;
      int k = 0;
      while (k < j)
      {
        int m = i | paramArrayOfSerializerFeature[k].getMask();
        k++;
        i = m;
      }
    }
  }
  
  public final int getMask()
  {
    return this.mask;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SerializerFeature
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */