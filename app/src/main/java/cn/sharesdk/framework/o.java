package cn.sharesdk.framework;

import java.util.Comparator;

class o
  implements Comparator<Platform>
{
  o(n paramn) {}
  
  public int a(Platform paramPlatform1, Platform paramPlatform2)
  {
    if (paramPlatform1.getSortId() != paramPlatform2.getSortId()) {
      return paramPlatform1.getSortId() - paramPlatform2.getSortId();
    }
    return paramPlatform1.getPlatformId() - paramPlatform2.getPlatformId();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.o
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */