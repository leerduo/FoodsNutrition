package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

public class SymbolTable
{
  public static final int DEFAULT_TABLE_SIZE = 512;
  public static final int MAX_BUCKET_LENTH = 8;
  public static final int MAX_SIZE = 4096;
  private final SymbolTable.Entry[] buckets;
  private final int indexMask;
  private int size = 0;
  private final String[] symbols;
  private final char[][] symbols_char;
  
  public SymbolTable()
  {
    this(512);
    addSymbol("$ref", 0, 4, "$ref".hashCode());
    addSymbol(JSON.DEFAULT_TYPE_KEY, 0, 5, JSON.DEFAULT_TYPE_KEY.hashCode());
  }
  
  public SymbolTable(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.buckets = new SymbolTable.Entry[paramInt];
    this.symbols = new String[paramInt];
    this.symbols_char = new char[paramInt][];
  }
  
  public static final int hash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    int n;
    for (int j = 0; i < paramInt2; j = n)
    {
      int k = j * 31;
      int m = paramInt1 + 1;
      n = k + paramArrayOfChar[paramInt1];
      i++;
      paramInt1 = m;
    }
    return j;
  }
  
  private static String subString(String paramString, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      arrayOfChar[(i - paramInt1)] = paramString.charAt(i);
    }
    return new String(arrayOfChar);
  }
  
  public String addSymbol(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 & this.indexMask;
    String str = this.symbols[i];
    int i2;
    int j;
    if (str != null) {
      if (str.length() == paramInt2)
      {
        char[] arrayOfChar2 = this.symbols_char[i];
        int i1 = 0;
        while (i1 < paramInt2)
        {
          if (paramString.charAt(paramInt1 + i1) != arrayOfChar2[i1])
          {
            i2 = 0;
            if (i2 != 0) {
              return str;
            }
          }
          else
          {
            i1++;
            continue;
          }
          j = i2;
        }
      }
    }
    for (;;)
    {
      SymbolTable.Entry localEntry1 = this.buckets[i];
      int k = 0;
      label99:
      int m;
      if (localEntry1 != null)
      {
        char[] arrayOfChar1 = localEntry1.characters;
        if ((paramInt2 == arrayOfChar1.length) && (paramInt3 == localEntry1.hashCode))
        {
          m = 0;
          label131:
          if (m >= paramInt2) {
            break label298;
          }
          if (paramString.charAt(paramInt1 + m) == arrayOfChar1[m]) {
            break label180;
          }
        }
      }
      label298:
      for (int n = 0;; n = 1)
      {
        if (n == 0)
        {
          k++;
          localEntry1 = localEntry1.next;
          break label99;
          j = 0;
          break;
          label180:
          m++;
          break label131;
        }
        return localEntry1.symbol;
        if (k >= 8) {
          return subString(paramString, paramInt1, paramInt2);
        }
        if (this.size >= 4096) {
          return subString(paramString, paramInt1, paramInt2);
        }
        SymbolTable.Entry localEntry2 = new SymbolTable.Entry(paramString, paramInt1, paramInt2, paramInt3, this.buckets[i]);
        this.buckets[i] = localEntry2;
        if (j != 0)
        {
          this.symbols[i] = localEntry2.symbol;
          this.symbols_char[i] = localEntry2.characters;
        }
        this.size = (1 + this.size);
        return localEntry2.symbol;
      }
      i2 = 1;
      break;
      j = 1;
    }
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return addSymbol(paramArrayOfChar, paramInt1, paramInt2, hash(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 & this.indexMask;
    String str = this.symbols[i];
    int i2;
    int j;
    if (str != null) {
      if (str.length() == paramInt2)
      {
        char[] arrayOfChar2 = this.symbols_char[i];
        int i1 = 0;
        while (i1 < paramInt2)
        {
          if (paramArrayOfChar[(paramInt1 + i1)] != arrayOfChar2[i1])
          {
            i2 = 0;
            if (i2 != 0) {
              return str;
            }
          }
          else
          {
            i1++;
            continue;
          }
          j = i2;
        }
      }
    }
    for (;;)
    {
      SymbolTable.Entry localEntry1 = this.buckets[i];
      int k = 0;
      label97:
      int m;
      if (localEntry1 != null)
      {
        char[] arrayOfChar1 = localEntry1.characters;
        if ((paramInt2 == arrayOfChar1.length) && (paramInt3 == localEntry1.hashCode))
        {
          m = 0;
          label129:
          if (m >= paramInt2) {
            break label302;
          }
          if (paramArrayOfChar[(paramInt1 + m)] == arrayOfChar1[m]) {
            break label176;
          }
        }
      }
      label302:
      for (int n = 0;; n = 1)
      {
        if (n == 0)
        {
          k++;
          localEntry1 = localEntry1.next;
          break label97;
          j = 0;
          break;
          label176:
          m++;
          break label129;
        }
        return localEntry1.symbol;
        if (k >= 8) {
          return new String(paramArrayOfChar, paramInt1, paramInt2);
        }
        if (this.size >= 4096) {
          return new String(paramArrayOfChar, paramInt1, paramInt2);
        }
        SymbolTable.Entry localEntry2 = new SymbolTable.Entry(paramArrayOfChar, paramInt1, paramInt2, paramInt3, this.buckets[i]);
        this.buckets[i] = localEntry2;
        if (j != 0)
        {
          this.symbols[i] = localEntry2.symbol;
          this.symbols_char[i] = localEntry2.characters;
        }
        this.size = (1 + this.size);
        return localEntry2.symbol;
      }
      i2 = 1;
      break;
      j = 1;
    }
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.SymbolTable
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */