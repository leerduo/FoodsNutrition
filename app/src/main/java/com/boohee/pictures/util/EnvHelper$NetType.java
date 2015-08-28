package com.boohee.pictures.util;

public enum EnvHelper$NetType
{
  static
  {
    WAP = new NetType("WAP", 2);
    NET = new NetType("NET", 3);
    MOBILE = new NetType("MOBILE", 4);
    NetType[] arrayOfNetType = new NetType[5];
    arrayOfNetType[0] = NO_NET;
    arrayOfNetType[1] = WIFI;
    arrayOfNetType[2] = WAP;
    arrayOfNetType[3] = NET;
    arrayOfNetType[4] = MOBILE;
  }
  
  private EnvHelper$NetType() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.util.EnvHelper.NetType
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */