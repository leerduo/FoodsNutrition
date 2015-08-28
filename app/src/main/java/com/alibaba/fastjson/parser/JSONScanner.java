package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.Base64;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class JSONScanner
  extends JSONLexerBase
{
  protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
  public final int ISO8601_LEN_0 = "0000-00-00".length();
  public final int ISO8601_LEN_1 = "0000-00-00T00:00:00".length();
  public final int ISO8601_LEN_2 = "0000-00-00T00:00:00.000".length();
  private final String text;
  
  public JSONScanner(String paramString)
  {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(String paramString, int paramInt)
  {
    this.features = paramInt;
    this.text = paramString;
    this.bp = -1;
    next();
    if (this.ch == 65279) {
      next();
    }
  }
  
  public JSONScanner(char[] paramArrayOfChar, int paramInt)
  {
    this(paramArrayOfChar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this(new String(paramArrayOfChar, 0, paramInt1), paramInt2);
  }
  
  static boolean checkDate(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, int paramInt1, int paramInt2)
  {
    if ((paramChar1 != '1') && (paramChar1 != '2')) {}
    label71:
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramChar2 < '0') || (paramChar2 > '9') || (paramChar3 < '0') || (paramChar3 > '9') || (paramChar4 < '0') || (paramChar4 > '9'));
        if (paramChar5 != '0') {
          break;
        }
      } while ((paramChar6 < '1') || (paramChar6 > '9'));
      if (paramInt1 != 48) {
        break label124;
      }
    } while ((paramInt2 < 49) || (paramInt2 > 57));
    label124:
    do
    {
      do
      {
        return true;
        if (paramChar5 != '1') {
          break;
        }
        if ((paramChar6 == '0') || (paramChar6 == '1') || (paramChar6 == '2')) {
          break label71;
        }
        return false;
        if ((paramInt1 != 49) && (paramInt1 != 50)) {
          break label154;
        }
        if (paramInt2 < 48) {
          break;
        }
      } while (paramInt2 <= 57);
      return false;
      if (paramInt1 != 51) {
        break;
      }
    } while ((paramInt2 == 48) || (paramInt2 == 49));
    label154:
    return false;
  }
  
  private boolean checkTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6)
  {
    if (paramChar1 == '0') {
      if ((paramChar2 >= '0') && (paramChar2 <= '9')) {
        break label38;
      }
    }
    label38:
    label64:
    do
    {
      do
      {
        do
        {
          return false;
          if (paramChar1 != '1') {
            break;
          }
        } while ((paramChar2 < '0') || (paramChar2 > '9'));
        if ((paramChar3 < '0') || (paramChar3 > '5')) {
          break label114;
        }
      } while ((paramChar4 < '0') || (paramChar4 > '9'));
      if ((paramChar5 < '0') || (paramChar5 > '5')) {
        break label129;
      }
    } while ((paramChar6 < '0') || (paramChar6 > '9'));
    label114:
    do
    {
      return true;
      if ((paramChar1 != '2') || (paramChar2 < '0')) {
        break;
      }
      if (paramChar2 <= '4') {
        break label38;
      }
      return false;
      if (paramChar3 != '6') {
        break;
      }
      if (paramChar4 == '0') {
        break label64;
      }
      return false;
      if (paramChar5 != '6') {
        break;
      }
    } while (paramChar6 == '0');
    label129:
    return false;
  }
  
  private void setCalendar(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, char paramChar7, char paramChar8)
  {
    Locale localLocale = Locale.getDefault();
    this.calendar = Calendar.getInstance(TimeZone.getDefault(), localLocale);
    int i = 1000 * digits[paramChar1] + 100 * digits[paramChar2] + 10 * digits[paramChar3] + digits[paramChar4];
    int j = -1 + (10 * digits[paramChar5] + digits[paramChar6]);
    int k = 10 * digits[paramChar7] + digits[paramChar8];
    this.calendar.set(1, i);
    this.calendar.set(2, j);
    this.calendar.set(5, k);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable)
  {
    return paramSymbolTable.addSymbol(this.text, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.text.getChars(paramInt1, paramInt1 + paramInt3, paramArrayOfChar, paramInt2);
  }
  
  public byte[] bytesValue()
  {
    return Base64.decodeFast(this.text, 1 + this.np, this.sp);
  }
  
  public final char charAt(int paramInt)
  {
    if (paramInt >= this.text.length()) {
      return '\032';
    }
    return this.text.charAt(paramInt);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    this.text.getChars(paramInt1, paramInt1 + paramInt2, paramArrayOfChar, 0);
  }
  
  public final int indexOf(char paramChar, int paramInt)
  {
    return this.text.indexOf(paramChar, paramInt);
  }
  
  public boolean isEOF()
  {
    return (this.bp == this.text.length()) || ((this.ch == '\032') && (1 + this.bp == this.text.length()));
  }
  
  public final char next()
  {
    int i = 1 + this.bp;
    this.bp = i;
    char c = charAt(i);
    this.ch = c;
    return c;
  }
  
  public final String numberString()
  {
    int i = charAt(-1 + (this.np + this.sp));
    int j = this.sp;
    if ((i == 76) || (i == 83) || (i == 66) || (i == 70) || (i == 68)) {
      j--;
    }
    return subString(this.np, j);
  }
  
  public boolean scanISO8601DateIfMatch()
  {
    return scanISO8601DateIfMatch(true);
  }
  
  public boolean scanISO8601DateIfMatch(boolean paramBoolean)
  {
    int i = this.text.length() - this.bp;
    if ((!paramBoolean) && (i > 13))
    {
      int i24 = charAt(this.bp);
      int i25 = charAt(1 + this.bp);
      int i26 = charAt(2 + this.bp);
      int i27 = charAt(3 + this.bp);
      int i28 = charAt(4 + this.bp);
      int i29 = charAt(5 + this.bp);
      int i30 = charAt(-1 + (i + this.bp));
      int i31 = charAt(-2 + (i + this.bp));
      if ((i24 == 47) && (i25 == 68) && (i26 == 97) && (i27 == 116) && (i28 == 101) && (i29 == 40) && (i30 == 47) && (i31 == 41))
      {
        int i32 = -1;
        int i33 = 6;
        if (i33 < i)
        {
          int i35 = charAt(i33 + this.bp);
          if (i35 == 43) {
            i32 = i33;
          }
          while ((i35 >= 48) && (i35 <= 57))
          {
            i33++;
            break;
          }
        }
        if (i32 == -1) {
          return false;
        }
        int i34 = 6 + this.bp;
        long l = Long.parseLong(subString(i34, i32 - i34));
        Locale localLocale = Locale.getDefault();
        this.calendar = Calendar.getInstance(TimeZone.getDefault(), localLocale);
        this.calendar.setTimeInMillis(l);
        this.token = 5;
        return true;
      }
    }
    if ((i == 8) || (i == 14) || (i == 17))
    {
      if (paramBoolean) {
        return false;
      }
      char c1 = charAt(this.bp);
      char c2 = charAt(1 + this.bp);
      char c3 = charAt(2 + this.bp);
      char c4 = charAt(3 + this.bp);
      char c5 = charAt(4 + this.bp);
      char c6 = charAt(5 + this.bp);
      char c7 = charAt(6 + this.bp);
      char c8 = charAt(7 + this.bp);
      if (!checkDate(c1, c2, c3, c4, c5, c6, c7, c8)) {
        return false;
      }
      setCalendar(c1, c2, c3, c4, c5, c6, c7, c8);
      int j;
      int i1;
      int m;
      int k;
      if (i != 8)
      {
        char c9 = charAt(8 + this.bp);
        char c10 = charAt(9 + this.bp);
        char c11 = charAt(10 + this.bp);
        char c12 = charAt(11 + this.bp);
        char c13 = charAt(12 + this.bp);
        char c14 = charAt(13 + this.bp);
        if (!checkTime(c9, c10, c11, c12, c13, c14)) {
          return false;
        }
        if (i == 17)
        {
          int i2 = charAt(14 + this.bp);
          int i3 = charAt(15 + this.bp);
          int i4 = charAt(16 + this.bp);
          if ((i2 < 48) || (i2 > 57)) {
            return false;
          }
          if ((i3 < 48) || (i3 > 57)) {
            return false;
          }
          if ((i4 < 48) || (i4 > 57)) {
            return false;
          }
          j = 100 * digits[i2] + 10 * digits[i3] + digits[i4];
          i1 = 10 * digits[c9] + digits[c10];
          m = 10 * digits[c11] + digits[c12];
          k = 10 * digits[c13] + digits[c14];
        }
      }
      for (int n = i1;; n = 0)
      {
        this.calendar.set(11, n);
        this.calendar.set(12, m);
        this.calendar.set(13, k);
        this.calendar.set(14, j);
        this.token = 5;
        return true;
        j = 0;
        break;
        j = 0;
        k = 0;
        m = 0;
      }
    }
    if (i < this.ISO8601_LEN_0) {
      return false;
    }
    if (charAt(4 + this.bp) != '-') {
      return false;
    }
    if (charAt(7 + this.bp) != '-') {
      return false;
    }
    char c15 = charAt(this.bp);
    char c16 = charAt(1 + this.bp);
    char c17 = charAt(2 + this.bp);
    char c18 = charAt(3 + this.bp);
    char c19 = charAt(5 + this.bp);
    char c20 = charAt(6 + this.bp);
    char c21 = charAt(8 + this.bp);
    char c22 = charAt(9 + this.bp);
    if (!checkDate(c15, c16, c17, c18, c19, c20, c21, c22)) {
      return false;
    }
    setCalendar(c15, c16, c17, c18, c19, c20, c21, c22);
    int i5 = charAt(10 + this.bp);
    if ((i5 == 84) || ((i5 == 32) && (!paramBoolean)))
    {
      if (i < this.ISO8601_LEN_1) {
        return false;
      }
    }
    else
    {
      if ((i5 == 34) || (i5 == 26))
      {
        this.calendar.set(11, 0);
        this.calendar.set(12, 0);
        this.calendar.set(13, 0);
        this.calendar.set(14, 0);
        int i23 = 10 + this.bp;
        this.bp = i23;
        this.ch = charAt(i23);
        this.token = 5;
        return true;
      }
      return false;
    }
    if (charAt(13 + this.bp) != ':') {
      return false;
    }
    if (charAt(16 + this.bp) != ':') {
      return false;
    }
    char c23 = charAt(11 + this.bp);
    char c24 = charAt(12 + this.bp);
    char c25 = charAt(14 + this.bp);
    char c26 = charAt(15 + this.bp);
    char c27 = charAt(17 + this.bp);
    char c28 = charAt(18 + this.bp);
    if (!checkTime(c23, c24, c25, c26, c27, c28)) {
      return false;
    }
    int i6 = 10 * digits[c23] + digits[c24];
    int i7 = 10 * digits[c25] + digits[c26];
    int i8 = 10 * digits[c27] + digits[c28];
    this.calendar.set(11, i6);
    this.calendar.set(12, i7);
    this.calendar.set(13, i8);
    if (charAt(19 + this.bp) == '.')
    {
      if (i < this.ISO8601_LEN_2) {
        return false;
      }
    }
    else
    {
      this.calendar.set(14, 0);
      int i9 = 19 + this.bp;
      this.bp = i9;
      this.ch = charAt(i9);
      this.token = 5;
      return true;
    }
    int i10 = charAt(20 + this.bp);
    if ((i10 < 48) || (i10 > 57)) {
      return false;
    }
    int i11 = digits[i10];
    int i12 = 1;
    int i13 = charAt(21 + this.bp);
    if ((i13 >= 48) && (i13 <= 57))
    {
      i11 = i11 * 10 + digits[i13];
      i12 = 2;
    }
    if (i12 == 2)
    {
      int i22 = charAt(22 + this.bp);
      if ((i22 >= 48) && (i22 <= 57))
      {
        i11 = i11 * 10 + digits[i22];
        i12 = 3;
      }
    }
    this.calendar.set(14, i11);
    int i14 = charAt(i12 + (20 + this.bp));
    int i15;
    int i18;
    int i19;
    int i20;
    if (i14 != 43)
    {
      i15 = 0;
      if (i14 != 45) {}
    }
    else
    {
      i18 = charAt(1 + (i12 + (20 + this.bp)));
      if ((i18 < 48) || (i18 > 49)) {
        return false;
      }
      i19 = charAt(2 + (i12 + (20 + this.bp)));
      if ((i19 < 48) || (i19 > 57)) {
        return false;
      }
      i20 = charAt(3 + (i12 + (20 + this.bp)));
      if (i20 != 58) {
        break label1863;
      }
      if (charAt(4 + (i12 + (20 + this.bp))) != '0') {
        return false;
      }
      if (charAt(5 + (i12 + (20 + this.bp))) != '0') {
        return false;
      }
      i15 = 6;
    }
    for (;;)
    {
      int i21 = 1000 * (3600 * (10 * digits[i18] + digits[i19]));
      if (i14 == 45) {
        i21 = -i21;
      }
      if (this.calendar.getTimeZone().getRawOffset() != i21)
      {
        String[] arrayOfString = TimeZone.getAvailableIDs(i21);
        if (arrayOfString.length > 0)
        {
          TimeZone localTimeZone = TimeZone.getTimeZone(arrayOfString[0]);
          this.calendar.setTimeZone(localTimeZone);
        }
      }
      int i16 = charAt(this.bp + (i15 + (i12 + 20)));
      if ((i16 == 26) || (i16 == 34)) {
        break;
      }
      return false;
      label1863:
      if (i20 == 48)
      {
        if (charAt(4 + (i12 + (20 + this.bp))) != '0') {
          return false;
        }
        i15 = 5;
      }
      else
      {
        i15 = 3;
      }
    }
    int i17 = this.bp + (i15 + (i12 + 20));
    this.bp = i17;
    this.ch = charAt(i17);
    this.token = 5;
    return true;
  }
  
  public final String stringVal()
  {
    if (!this.hasSpecial) {
      return subString(1 + this.np, this.sp);
    }
    return new String(this.sbuf, 0, this.sp);
  }
  
  public final String subString(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      arrayOfChar[(i - paramInt1)] = this.text.charAt(i);
    }
    return new String(arrayOfChar);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.JSONScanner
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */