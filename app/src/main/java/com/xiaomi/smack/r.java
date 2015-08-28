package com.xiaomi.smack;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class r
{
  private static int a = 5000;
  private static int b = 330000;
  private static int c = 300000;
  private static int d = 330000;
  private static Vector<String> e = new Vector();
  
  static
  {
    for (;;)
    {
      int j;
      try
      {
        ClassLoader[] arrayOfClassLoader = e();
        int i = arrayOfClassLoader.length;
        j = 0;
        InputStream localInputStream;
        if (j < i)
        {
          Enumeration localEnumeration = arrayOfClassLoader[j].getResources("META-INF/smack-config.xml");
          if (!localEnumeration.hasMoreElements()) {
            break label304;
          }
          URL localURL = (URL)localEnumeration.nextElement();
          localInputStream = null;
          try
          {
            localInputStream = localURL.openStream();
            XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
            localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            localXmlPullParser.setInput(localInputStream, "UTF-8");
            int k = localXmlPullParser.getEventType();
            if (k == 2)
            {
              if (localXmlPullParser.getName().equals("className")) {
                a(localXmlPullParser);
              }
            }
            else
            {
              int m = localXmlPullParser.next();
              k = m;
              if (k != 1) {
                continue;
              }
              try
              {
                localInputStream.close();
              }
              catch (Exception localException4) {}
              continue;
            }
            if (localXmlPullParser.getName().equals("packetReplyTimeout"))
            {
              a = a(localXmlPullParser, a);
              continue;
            }
            try
            {
              localInputStream.close();
              throw localObject;
            }
            catch (Exception localException2)
            {
              continue;
            }
          }
          catch (Exception localException3)
          {
            localException3 = localException3;
            localException3.printStackTrace();
            localInputStream.close();
            continue;
            if (!localXmlPullParser.getName().equals("keepAliveInterval")) {
              break label272;
            }
            b = a(localXmlPullParser, b);
            continue;
          }
          finally {}
        }
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      label272:
      if (localXmlPullParser.getName().equals("mechName"))
      {
        e.add(localXmlPullParser.nextText());
        continue;
        label304:
        j++;
      }
    }
  }
  
  private static int a(XmlPullParser paramXmlPullParser, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramXmlPullParser.nextText());
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return paramInt;
  }
  
  public static String a()
  {
    return "3.1.0";
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    String str = paramXmlPullParser.nextText();
    try
    {
      Class.forName(str);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + str);
    }
  }
  
  public static int b()
  {
    if (a <= 0) {
      a = 5000;
    }
    return a;
  }
  
  public static int c()
  {
    return b;
  }
  
  public static int d()
  {
    return c;
  }
  
  private static ClassLoader[] e()
  {
    int i = 0;
    ClassLoader[] arrayOfClassLoader = new ClassLoader[2];
    arrayOfClassLoader[0] = r.class.getClassLoader();
    arrayOfClassLoader[1] = Thread.currentThread().getContextClassLoader();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfClassLoader.length;
    while (i < j)
    {
      ClassLoader localClassLoader = arrayOfClassLoader[i];
      if (localClassLoader != null) {
        localArrayList.add(localClassLoader);
      }
      i++;
    }
    return (ClassLoader[])localArrayList.toArray(new ClassLoader[localArrayList.size()]);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.r
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */