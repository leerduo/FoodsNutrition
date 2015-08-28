package com.umeng.analytics.social;

public enum UMPlatformData$GENDER
{
  public int value;
  
  static
  {
    FEMALE = new UMPlatformData.GENDER.2("FEMALE", 1, 1);
    GENDER[] arrayOfGENDER = new GENDER[2];
    arrayOfGENDER[0] = MALE;
    arrayOfGENDER[1] = FEMALE;
  }
  
  private UMPlatformData$GENDER(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.UMPlatformData.GENDER
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */