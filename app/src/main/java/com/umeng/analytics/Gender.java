package com.umeng.analytics;

import u.aly.ap;

public enum Gender
{
  public int value;
  
  static
  {
    Female = new Gender.2("Female", 1, 2);
    Unknown = new Gender.3("Unknown", 2, 0);
    Gender[] arrayOfGender = new Gender[3];
    arrayOfGender[0] = Male;
    arrayOfGender[1] = Female;
    arrayOfGender[2] = Unknown;
  }
  
  private Gender(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Gender getGender(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Unknown;
    case 1: 
      return Male;
    }
    return Female;
  }
  
  public static ap transGender(Gender paramGender)
  {
    switch (Gender.4.a[paramGender.ordinal()])
    {
    default: 
      return ap.c;
    case 1: 
      return ap.a;
    }
    return ap.b;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.Gender
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */