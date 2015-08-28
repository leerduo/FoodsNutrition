package com.xiaomi.kenai.jbosh;

import java.lang.ref.SoftReference;
import org.xmlpull.v1.XmlPullParser;

final class af
  extends ThreadLocal<SoftReference<XmlPullParser>>
{
  protected SoftReference<XmlPullParser> a()
  {
    return new SoftReference(null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.af
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */