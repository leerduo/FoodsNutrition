package com.activeandroid.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SqlParser
{
  public static List<String> a(InputStream paramInputStream)
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    label262:
    label289:
    label306:
    for (;;)
    {
      char c;
      try
      {
        Tokenizer localTokenizer = new Tokenizer(localBufferedInputStream);
        i = 0;
        if (!localTokenizer.a()) {
          break label262;
        }
        c = (char)localTokenizer.b();
        if (i == 3)
        {
          if (!localTokenizer.a("*/")) {
            continue;
          }
          i = 0;
          continue;
        }
        if (i == 2)
        {
          if (!a(c)) {
            continue;
          }
          i = 0;
          continue;
        }
        if ((i == 0) && (localTokenizer.a("/*")))
        {
          i = 3;
          continue;
        }
        if ((i == 0) && (localTokenizer.a("--")))
        {
          i = 2;
          continue;
        }
        if ((i == 0) && (c == ';'))
        {
          localArrayList.add(localStringBuffer.toString().trim());
          localStringBuffer.setLength(0);
          continue;
        }
        if (i != 0) {
          break label289;
        }
      }
      finally
      {
        IOUtils.a(localBufferedInputStream);
      }
      if (c == '\'') {}
      for (int i = 1;; i = 0) {
        do
        {
          if ((i != 0) && (i != 1)) {
            break label306;
          }
          if ((i == 0) && (b(c)))
          {
            if ((localStringBuffer.length() <= 0) || (localStringBuffer.charAt(-1 + localStringBuffer.length()) == ' ')) {
              break;
            }
            localStringBuffer.append(' ');
            break;
          }
          localStringBuffer.append(c);
          break;
          IOUtils.a(localBufferedInputStream);
          if (localStringBuffer.length() > 0) {
            localArrayList.add(localStringBuffer.toString().trim());
          }
          return localArrayList;
        } while ((i != 1) || (c != '\''));
      }
    }
  }
  
  private static boolean a(char paramChar)
  {
    return (paramChar == '\r') || (paramChar == '\n');
  }
  
  private static boolean b(char paramChar)
  {
    return (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t') || (paramChar == ' ');
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.SqlParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */