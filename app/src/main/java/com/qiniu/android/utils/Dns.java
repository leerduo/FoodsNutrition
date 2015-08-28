package com.qiniu.android.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class Dns
{
  public static String[] getAddresses(String paramString)
  {
    int i = 0;
    try
    {
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
      String[] arrayOfString = new String[arrayOfInetAddress.length];
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = arrayOfInetAddress[i].getHostAddress();
        i++;
      }
      return arrayOfString;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
      return new String[0];
    }
  }
  
  public static String getAddressesString(String paramString)
  {
    return StringUtils.join(getAddresses(paramString), ";");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.utils.Dns
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */