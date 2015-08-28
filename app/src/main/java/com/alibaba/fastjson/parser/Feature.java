package com.alibaba.fastjson.parser;

public enum Feature
{
  private final int mask = 1 << ordinal();
  
  static
  {
    AllowComment = new Feature("AllowComment", 1);
    AllowUnQuotedFieldNames = new Feature("AllowUnQuotedFieldNames", 2);
    AllowSingleQuotes = new Feature("AllowSingleQuotes", 3);
    InternFieldNames = new Feature("InternFieldNames", 4);
    AllowISO8601DateFormat = new Feature("AllowISO8601DateFormat", 5);
    AllowArbitraryCommas = new Feature("AllowArbitraryCommas", 6);
    UseBigDecimal = new Feature("UseBigDecimal", 7);
    IgnoreNotMatch = new Feature("IgnoreNotMatch", 8);
    SortFeidFastMatch = new Feature("SortFeidFastMatch", 9);
    DisableASM = new Feature("DisableASM", 10);
    DisableCircularReferenceDetect = new Feature("DisableCircularReferenceDetect", 11);
    InitStringFieldAsEmpty = new Feature("InitStringFieldAsEmpty", 12);
    SupportArrayToBean = new Feature("SupportArrayToBean", 13);
    Feature[] arrayOfFeature = new Feature[14];
    arrayOfFeature[0] = AutoCloseSource;
    arrayOfFeature[1] = AllowComment;
    arrayOfFeature[2] = AllowUnQuotedFieldNames;
    arrayOfFeature[3] = AllowSingleQuotes;
    arrayOfFeature[4] = InternFieldNames;
    arrayOfFeature[5] = AllowISO8601DateFormat;
    arrayOfFeature[6] = AllowArbitraryCommas;
    arrayOfFeature[7] = UseBigDecimal;
    arrayOfFeature[8] = IgnoreNotMatch;
    arrayOfFeature[9] = SortFeidFastMatch;
    arrayOfFeature[10] = DisableASM;
    arrayOfFeature[11] = DisableCircularReferenceDetect;
    arrayOfFeature[12] = InitStringFieldAsEmpty;
    arrayOfFeature[13] = SupportArrayToBean;
  }
  
  private Feature() {}
  
  public static int config(int paramInt, Feature paramFeature, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt | paramFeature.getMask();
    }
    return paramInt & (0xFFFFFFFF ^ paramFeature.getMask());
  }
  
  public static boolean isEnabled(int paramInt, Feature paramFeature)
  {
    return (paramInt & paramFeature.getMask()) != 0;
  }
  
  public static int of(Feature[] paramArrayOfFeature)
  {
    int i = 0;
    if (paramArrayOfFeature == null) {}
    for (;;)
    {
      return i;
      int j = paramArrayOfFeature.length;
      int k = 0;
      while (k < j)
      {
        int m = i | paramArrayOfFeature[k].getMask();
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
 * Qualified Name:     com.alibaba.fastjson.parser.Feature
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */