package com.xiaomi.network;

import com.xiaomi.common.logger.thrift.mfs.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

final class a
  implements UploadHostStatHelper.HttpRecordCallback
{
  public List<b> a()
  {
    try
    {
      ArrayList localArrayList = HostManager.i().g();
      return localArrayList;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public double b()
  {
    Fallback localFallback = HostManager.i().a("f3.mi-stat.gslb.mi-idc.com");
    double d = 0.1D;
    if (localFallback != null) {
      d = localFallback.f();
    }
    return d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */