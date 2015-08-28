package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public abstract class JSONLexerBase
  implements JSONLexer, Closeable
{
  private static final Map<String, Integer> DEFAULT_KEYWORDS;
  protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
  protected static final int INT_N_MULTMAX_RADIX_TEN = -214748364;
  protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
  protected static final long N_MULTMAX_RADIX_TEN = -922337203685477580L;
  private static final ThreadLocal<SoftReference<char[]>> SBUF_REF_LOCAL;
  protected static final int[] digits;
  protected static final char[] typeFieldName;
  protected static boolean[] whitespaceFlags;
  protected int bp;
  protected Calendar calendar = null;
  protected char ch;
  protected int eofPos;
  protected int features = JSON.DEFAULT_PARSER_FEATURE;
  protected boolean hasSpecial;
  protected Map<String, Integer> keywods = DEFAULT_KEYWORDS;
  public int matchStat = 0;
  protected int np;
  protected int pos;
  protected char[] sbuf;
  protected int sp;
  protected int token;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("null", Integer.valueOf(8));
    localHashMap.put("new", Integer.valueOf(9));
    localHashMap.put("true", Integer.valueOf(6));
    localHashMap.put("false", Integer.valueOf(7));
    localHashMap.put("undefined", Integer.valueOf(23));
    DEFAULT_KEYWORDS = localHashMap;
    SBUF_REF_LOCAL = new ThreadLocal();
    typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    whitespaceFlags = new boolean[256];
    whitespaceFlags[32] = true;
    whitespaceFlags[10] = true;
    whitespaceFlags[13] = true;
    whitespaceFlags[9] = true;
    whitespaceFlags[12] = true;
    whitespaceFlags[8] = true;
    digits = new int[103];
    for (int i = 48; i <= 57; i++) {
      digits[i] = (i - 48);
    }
    for (int j = 97; j <= 102; j++) {
      digits[j] = (10 + (j - 97));
    }
    for (int k = 65; k <= 70; k++) {
      digits[k] = (10 + (k - 65));
    }
  }
  
  public JSONLexerBase()
  {
    SoftReference localSoftReference = (SoftReference)SBUF_REF_LOCAL.get();
    if (localSoftReference != null)
    {
      this.sbuf = ((char[])localSoftReference.get());
      SBUF_REF_LOCAL.set(null);
    }
    if (this.sbuf == null) {
      this.sbuf = new char[64];
    }
  }
  
  public static final boolean isWhitespace(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == '\f') || (paramChar == '\b');
  }
  
  private final void scanStringSingleQuote()
  {
    this.np = this.bp;
    this.hasSpecial = false;
    for (;;)
    {
      char c1 = next();
      if (c1 == '\'')
      {
        this.token = 4;
        next();
        return;
      }
      if (c1 == '\032') {
        throw new JSONException("unclosed single-quote string");
      }
      if (c1 == '\\')
      {
        if (!this.hasSpecial)
        {
          this.hasSpecial = true;
          if (this.sp > this.sbuf.length)
          {
            char[] arrayOfChar2 = new char[2 * this.sp];
            System.arraycopy(this.sbuf, 0, arrayOfChar2, 0, this.sbuf.length);
            this.sbuf = arrayOfChar2;
          }
          copyTo(1 + this.np, this.sp, this.sbuf);
        }
        char c2 = next();
        switch (c2)
        {
        default: 
          this.ch = c2;
          throw new JSONException("unclosed single-quote string");
        case '0': 
          putChar('\000');
          break;
        case '1': 
          putChar('\001');
          break;
        case '2': 
          putChar('\002');
          break;
        case '3': 
          putChar('\003');
          break;
        case '4': 
          putChar('\004');
          break;
        case '5': 
          putChar('\005');
          break;
        case '6': 
          putChar('\006');
          break;
        case '7': 
          putChar('\007');
          break;
        case 'b': 
          putChar('\b');
          break;
        case 't': 
          putChar('\t');
          break;
        case 'n': 
          putChar('\n');
          break;
        case 'v': 
          putChar('\013');
          break;
        case 'F': 
        case 'f': 
          putChar('\f');
          break;
        case 'r': 
          putChar('\r');
          break;
        case '"': 
          putChar('"');
          break;
        case '\'': 
          putChar('\'');
          break;
        case '/': 
          putChar('/');
          break;
        case '\\': 
          putChar('\\');
          break;
        case 'x': 
          int j = next();
          int k = next();
          putChar((char)(16 * digits[j] + digits[k]));
          break;
        case 'u': 
          putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16));
          break;
        }
      }
      else if (!this.hasSpecial)
      {
        this.sp = (1 + this.sp);
      }
      else if (this.sp == this.sbuf.length)
      {
        putChar(c1);
      }
      else
      {
        char[] arrayOfChar1 = this.sbuf;
        int i = this.sp;
        this.sp = (i + 1);
        arrayOfChar1[i] = c1;
      }
    }
  }
  
  public abstract String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable);
  
  protected abstract void arrayCopy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3);
  
  public abstract byte[] bytesValue();
  
  public abstract char charAt(int paramInt);
  
  public void close()
  {
    if (this.sbuf.length <= 8192) {
      SBUF_REF_LOCAL.set(new SoftReference(this.sbuf));
    }
    this.sbuf = null;
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.features = Feature.config(this.features, paramFeature, paramBoolean);
  }
  
  protected abstract void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfChar);
  
  public final Number decimalValue(boolean paramBoolean)
  {
    int i = charAt(-1 + (this.np + this.sp));
    if (i == 70) {
      return Float.valueOf(Float.parseFloat(numberString()));
    }
    if (i == 68) {
      return Double.valueOf(Double.parseDouble(numberString()));
    }
    if (paramBoolean) {
      return decimalValue();
    }
    return Double.valueOf(doubleValue());
  }
  
  public final BigDecimal decimalValue()
  {
    return new BigDecimal(numberString());
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(numberString());
  }
  
  public float floatValue()
  {
    return Float.parseFloat(numberString());
  }
  
  public final int getBufferPosition()
  {
    return this.bp;
  }
  
  public Calendar getCalendar()
  {
    return this.calendar;
  }
  
  public final char getCurrent()
  {
    return this.ch;
  }
  
  public Integer getKeyword(String paramString)
  {
    return (Integer)this.keywods.get(paramString);
  }
  
  public abstract int indexOf(char paramChar, int paramInt);
  
  public final int intValue()
  {
    if (this.np == -1) {
      this.np = 0;
    }
    int i = this.np;
    int j = this.np + this.sp;
    int n;
    int k;
    int m;
    int i1;
    int i2;
    if (charAt(this.np) == '-')
    {
      int i7 = i + 1;
      n = 1;
      k = -2147483648;
      m = i7;
      if ((n != 0) && (m >= j)) {
        break label256;
      }
      int[] arrayOfInt = digits;
      i1 = m + 1;
      i2 = -arrayOfInt[charAt(m)];
    }
    for (;;)
    {
      label91:
      int i3;
      int i4;
      if (i1 < j)
      {
        i3 = i1 + 1;
        i4 = charAt(i1);
        if ((i4 != 76) && (i4 != 83) && (i4 != 66)) {}
      }
      for (;;)
      {
        if (n != 0)
        {
          if (i3 > 1 + this.np)
          {
            return i2;
            k = -2147483647;
            m = i;
            n = 0;
            break;
            int i5 = digits[i4];
            if (i2 < -214748364) {
              throw new NumberFormatException(numberString());
            }
            int i6 = i2 * 10;
            if (i6 < k + i5) {
              throw new NumberFormatException(numberString());
            }
            i2 = i6 - i5;
            i1 = i3;
            break label91;
          }
          throw new NumberFormatException(numberString());
        }
        return -i2;
        i3 = i1;
      }
      label256:
      i1 = m;
      i2 = 0;
    }
  }
  
  public final Number integerValue()
  {
    long l1 = 0L;
    if (this.np == -1) {
      this.np = 0;
    }
    int i = this.np;
    int j = this.np + this.sp;
    int k = 32;
    long l2;
    int n;
    int m;
    label106:
    long l3;
    label116:
    int i1;
    switch (charAt(j - 1))
    {
    default: 
      if (charAt(this.np) == '-')
      {
        int i4 = i + 1;
        l2 = -9223372036854775808L;
        n = 1;
        m = i4;
        if (n == 0) {
          break label238;
        }
        l3 = -922337203685477580L;
        if (m >= j) {
          break label436;
        }
        int[] arrayOfInt2 = digits;
        i1 = m + 1;
        l1 = -arrayOfInt2[charAt(m)];
      }
      break;
    }
    for (;;)
    {
      if (i1 < j)
      {
        int[] arrayOfInt1 = digits;
        int i2 = i1 + 1;
        int i3 = arrayOfInt1[charAt(i1)];
        if (l1 < l3)
        {
          return new BigInteger(numberString());
          j--;
          k = 76;
          break;
          j--;
          k = 83;
          break;
          j--;
          k = 66;
          break;
          l2 = -9223372036854775807L;
          m = i;
          n = 0;
          break label106;
          label238:
          l3 = -922337203685477580L;
          break label116;
        }
        long l5 = l1 * 10L;
        if (l5 < l2 + i3) {
          return new BigInteger(numberString());
        }
        l1 = l5 - i3;
        i1 = i2;
        continue;
      }
      if (n != 0)
      {
        if (i1 > 1 + this.np)
        {
          if ((l1 >= -2147483648L) && (k != 76))
          {
            if (k == 83) {
              return Short.valueOf((short)(int)l1);
            }
            if (k == 66) {
              return Byte.valueOf((byte)(int)l1);
            }
            return Integer.valueOf((int)l1);
          }
          return Long.valueOf(l1);
        }
        throw new NumberFormatException(numberString());
      }
      long l4 = -l1;
      if ((l4 <= 2147483647L) && (k != 76))
      {
        if (k == 83) {
          return Short.valueOf((short)(int)l4);
        }
        if (k == 66) {
          return Byte.valueOf((byte)(int)l4);
        }
        return Integer.valueOf((int)l4);
      }
      return Long.valueOf(l4);
      label436:
      i1 = m;
    }
  }
  
  public final boolean isBlankInput()
  {
    for (int i = 0;; i++)
    {
      char c = charAt(i);
      boolean bool2;
      if (c == '\032') {
        bool2 = true;
      }
      boolean bool1;
      do
      {
        return bool2;
        bool1 = isWhitespace(c);
        bool2 = false;
      } while (!bool1);
    }
  }
  
  public abstract boolean isEOF();
  
  public final boolean isEnabled(Feature paramFeature)
  {
    return Feature.isEnabled(this.features, paramFeature);
  }
  
  public final boolean isRef()
  {
    if (this.sp != 4) {}
    while ((charAt(1 + this.np) != '$') || (charAt(2 + this.np) != 'r') || (charAt(3 + this.np) != 'e') || (charAt(4 + this.np) != 'f')) {
      return false;
    }
    return true;
  }
  
  protected void lexError(String paramString, Object... paramVarArgs)
  {
    this.token = 1;
  }
  
  public final long longValue()
  {
    long l1 = 0L;
    int i = this.np;
    int j = this.np + this.sp;
    int m;
    long l2;
    int k;
    int n;
    if (charAt(this.np) == '-')
    {
      int i4 = i + 1;
      m = 1;
      l2 = -9223372036854775808L;
      k = i4;
      if ((m != 0) && (k >= j)) {
        break label252;
      }
      int[] arrayOfInt = digits;
      n = k + 1;
      l1 = -arrayOfInt[charAt(k)];
    }
    for (;;)
    {
      label83:
      int i1;
      int i2;
      if (n < j)
      {
        i1 = n + 1;
        i2 = charAt(n);
        if ((i2 != 76) && (i2 != 83) && (i2 != 66)) {}
      }
      for (;;)
      {
        if (m != 0)
        {
          if (i1 > 1 + this.np)
          {
            return l1;
            l2 = -9223372036854775807L;
            k = i;
            m = 0;
            break;
            int i3 = digits[i2];
            if (l1 < -922337203685477580L) {
              throw new NumberFormatException(numberString());
            }
            long l3 = l1 * 10L;
            if (l3 < l2 + i3) {
              throw new NumberFormatException(numberString());
            }
            l1 = l3 - i3;
            n = i1;
            break label83;
          }
          throw new NumberFormatException(numberString());
        }
        return -l1;
        i1 = n;
      }
      label252:
      n = k;
    }
  }
  
  public abstract char next();
  
  public final void nextIdent()
  {
    while (isWhitespace(this.ch)) {
      next();
    }
    if ((this.ch == '_') || (Character.isLetter(this.ch)))
    {
      scanIdent();
      return;
    }
    nextToken();
  }
  
  public final void nextToken()
  {
    this.sp = 0;
    for (;;)
    {
      this.pos = this.bp;
      if (this.ch == '"')
      {
        scanString();
        return;
      }
      if (this.ch == ',')
      {
        next();
        this.token = 16;
        return;
      }
      if ((this.ch >= '0') && (this.ch <= '9'))
      {
        scanNumber();
        return;
      }
      if (this.ch == '-')
      {
        scanNumber();
        return;
      }
      switch (this.ch)
      {
      default: 
        if (!isEOF()) {
          break label460;
        }
        if (this.token != 20) {
          break;
        }
        throw new JSONException("EOF error");
      case '\'': 
        if (!isEnabled(Feature.AllowSingleQuotes)) {
          throw new JSONException("Feature.AllowSingleQuotes is false");
        }
        scanStringSingleQuote();
        return;
      case '\b': 
      case '\t': 
      case '\n': 
      case '\f': 
      case '\r': 
      case ' ': 
        next();
      }
    }
    scanTrue();
    return;
    scanTreeSet();
    return;
    scanSet();
    return;
    scanFalse();
    return;
    scanNullOrNew();
    return;
    scanUndefined();
    return;
    next();
    this.token = 10;
    return;
    next();
    this.token = 11;
    return;
    next();
    this.token = 14;
    return;
    next();
    this.token = 15;
    return;
    next();
    this.token = 12;
    return;
    next();
    this.token = 13;
    return;
    next();
    this.token = 17;
    return;
    this.token = 20;
    int i = this.eofPos;
    this.bp = i;
    this.pos = i;
    return;
    label460:
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = String.valueOf(this.ch);
    lexError("illegal.char", arrayOfObject);
    next();
  }
  
  public final void nextToken(int paramInt)
  {
    this.sp = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b'))
      {
        next();
        break;
        if (this.ch == '{')
        {
          this.token = 12;
          next();
          return;
        }
        if (this.ch == '[')
        {
          this.token = 14;
          next();
          return;
          if (this.ch == ',')
          {
            this.token = 16;
            next();
            return;
          }
          if (this.ch == '}')
          {
            this.token = 13;
            next();
            return;
          }
          if (this.ch == ']')
          {
            this.token = 15;
            next();
            return;
          }
          if (this.ch == '\032')
          {
            this.token = 20;
            return;
            if ((this.ch >= '0') && (this.ch <= '9'))
            {
              this.pos = this.bp;
              scanNumber();
              return;
            }
            if (this.ch == '"')
            {
              this.pos = this.bp;
              scanString();
              return;
            }
            if (this.ch == '[')
            {
              this.token = 14;
              next();
              return;
            }
            if (this.ch == '{')
            {
              this.token = 12;
              next();
              return;
              if (this.ch == '"')
              {
                this.pos = this.bp;
                scanString();
                return;
              }
              if ((this.ch >= '0') && (this.ch <= '9'))
              {
                this.pos = this.bp;
                scanNumber();
                return;
              }
              if (this.ch == '[')
              {
                this.token = 14;
                next();
                return;
              }
              if (this.ch == '{')
              {
                this.token = 12;
                next();
                return;
                if (this.ch == '[')
                {
                  this.token = 14;
                  next();
                  return;
                }
                if (this.ch == '{')
                {
                  this.token = 12;
                  next();
                  return;
                  if (this.ch == ']')
                  {
                    this.token = 15;
                    next();
                    return;
                  }
                  if (this.ch == '\032')
                  {
                    this.token = 20;
                    return;
                    nextIdent();
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    nextToken();
  }
  
  public final void nextTokenWithChar(char paramChar)
  {
    this.sp = 0;
    for (;;)
    {
      if (this.ch == paramChar)
      {
        next();
        nextToken();
        return;
      }
      if ((this.ch != ' ') && (this.ch != '\n') && (this.ch != '\r') && (this.ch != '\t') && (this.ch != '\f') && (this.ch != '\b')) {
        break;
      }
      next();
    }
    throw new JSONException("not match " + paramChar + " - " + this.ch);
  }
  
  public final void nextTokenWithColon()
  {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithColon(int paramInt)
  {
    nextTokenWithChar(':');
  }
  
  public abstract String numberString();
  
  public final int pos()
  {
    return this.pos;
  }
  
  protected final void putChar(char paramChar)
  {
    if (this.sp == this.sbuf.length)
    {
      char[] arrayOfChar2 = new char[2 * this.sbuf.length];
      System.arraycopy(this.sbuf, 0, arrayOfChar2, 0, this.sbuf.length);
      this.sbuf = arrayOfChar2;
    }
    char[] arrayOfChar1 = this.sbuf;
    int i = this.sp;
    this.sp = (i + 1);
    arrayOfChar1[i] = paramChar;
  }
  
  public final void resetStringPosition()
  {
    this.sp = 0;
  }
  
  public Enum<?> scanEnum(Class<?> paramClass, SymbolTable paramSymbolTable, char paramChar)
  {
    String str = scanSymbolWithSeperator(paramSymbolTable, paramChar);
    if (str == null) {
      return null;
    }
    return Enum.valueOf(paramClass, str);
  }
  
  public final void scanFalse()
  {
    if (this.ch != 'f') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'a') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'l') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 's') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse false");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
    {
      this.token = 7;
      return;
    }
    throw new JSONException("scan false error");
  }
  
  public final void scanIdent()
  {
    this.np = (-1 + this.bp);
    this.hasSpecial = false;
    do
    {
      this.sp = (1 + this.sp);
      next();
    } while (Character.isLetterOrDigit(this.ch));
    Integer localInteger = getKeyword(stringVal());
    if (localInteger != null)
    {
      this.token = localInteger.intValue();
      return;
    }
    this.token = 18;
  }
  
  public int scanInt(char paramChar)
  {
    this.matchStat = 0;
    int i = this.bp;
    int j = 1;
    int k = charAt(i + 0);
    int m;
    int i1;
    char c;
    if ((k >= 48) && (k <= 57))
    {
      m = digits[k];
      for (;;)
      {
        int n = this.bp;
        i1 = j + 1;
        c = charAt(j + n);
        if ((c < '0') || (c > '9')) {
          break;
        }
        m = m * 10 + digits[c];
        j = i1;
      }
      if (c == '.')
      {
        this.matchStat = -1;
        return 0;
      }
      if (m < 0)
      {
        this.matchStat = -1;
        return 0;
      }
    }
    else
    {
      this.matchStat = -1;
      return 0;
    }
    if (c == paramChar)
    {
      this.bp += i1 - 1;
      next();
      this.matchStat = 3;
      this.token = 16;
      return m;
    }
    this.matchStat = -1;
    return m;
  }
  
  public long scanLong(char paramChar)
  {
    this.matchStat = 0;
    int i = this.bp;
    int j = 1;
    int k = charAt(i + 0);
    long l;
    int n;
    char c;
    if ((k >= 48) && (k <= 57))
    {
      l = digits[k];
      for (;;)
      {
        int m = this.bp;
        n = j + 1;
        c = charAt(j + m);
        if ((c < '0') || (c > '9')) {
          break;
        }
        l = l * 10L + digits[c];
        j = n;
      }
      if (c == '.')
      {
        this.matchStat = -1;
        return 0L;
      }
      if (l < 0L)
      {
        this.matchStat = -1;
        return 0L;
      }
    }
    else
    {
      this.matchStat = -1;
      return 0L;
    }
    if (c == paramChar)
    {
      this.bp += n - 1;
      next();
      this.matchStat = 3;
      this.token = 16;
      return l;
    }
    this.matchStat = -1;
    return l;
  }
  
  public final void scanNullOrNew()
  {
    if (this.ch != 'n') {
      throw new JSONException("error parse null or new");
    }
    next();
    if (this.ch == 'u')
    {
      next();
      if (this.ch != 'l') {
        throw new JSONException("error parse true");
      }
      next();
      if (this.ch != 'l') {
        throw new JSONException("error parse true");
      }
      next();
      if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
      {
        this.token = 8;
        return;
      }
      throw new JSONException("scan true error");
    }
    if (this.ch != 'e') {
      throw new JSONException("error parse e");
    }
    next();
    if (this.ch != 'w') {
      throw new JSONException("error parse w");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
    {
      this.token = 9;
      return;
    }
    throw new JSONException("scan true error");
  }
  
  public final void scanNumber()
  {
    this.np = this.bp;
    if (this.ch == '-')
    {
      this.sp = (1 + this.sp);
      next();
    }
    while ((this.ch >= '0') && (this.ch <= '9'))
    {
      this.sp = (1 + this.sp);
      next();
    }
    int i = this.ch;
    int j = 0;
    if (i == 46)
    {
      this.sp = (1 + this.sp);
      next();
      while ((this.ch >= '0') && (this.ch <= '9'))
      {
        this.sp = (1 + this.sp);
        next();
      }
      j = 1;
    }
    if (this.ch == 'L')
    {
      this.sp = (1 + this.sp);
      next();
    }
    while (j != 0)
    {
      this.token = 3;
      return;
      if (this.ch == 'S')
      {
        this.sp = (1 + this.sp);
        next();
      }
      else if (this.ch == 'B')
      {
        this.sp = (1 + this.sp);
        next();
      }
      else if (this.ch == 'F')
      {
        this.sp = (1 + this.sp);
        next();
        j = 1;
      }
      else if (this.ch == 'D')
      {
        this.sp = (1 + this.sp);
        next();
        j = 1;
      }
      else if ((this.ch == 'e') || (this.ch == 'E'))
      {
        this.sp = (1 + this.sp);
        next();
        if ((this.ch == '+') || (this.ch == '-'))
        {
          this.sp = (1 + this.sp);
          next();
        }
        while ((this.ch >= '0') && (this.ch <= '9'))
        {
          this.sp = (1 + this.sp);
          next();
        }
        if ((this.ch == 'D') || (this.ch == 'F'))
        {
          this.sp = (1 + this.sp);
          next();
        }
        j = 1;
      }
    }
    this.token = 2;
  }
  
  public final void scanSet()
  {
    if (this.ch != 'S') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 't') {
      throw new JSONException("error parse true");
    }
    next();
    if ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == '[') || (this.ch == '('))
    {
      this.token = 21;
      return;
    }
    throw new JSONException("scan set error");
  }
  
  public String scanString(char paramChar)
  {
    this.matchStat = 0;
    int i = charAt(0 + this.bp);
    if (i == 110)
    {
      if ((charAt(1 + this.bp) == 'u') && (charAt(1 + (1 + this.bp)) == 'l') && (charAt(2 + (1 + this.bp)) == 'l'))
      {
        if (charAt(4 + this.bp) == paramChar)
        {
          this.bp = (4 + this.bp);
          next();
          this.matchStat = 3;
          return null;
        }
      }
      else
      {
        this.matchStat = -1;
        return null;
      }
      this.matchStat = -1;
      return null;
    }
    if (i != 34)
    {
      this.matchStat = -1;
      return stringDefaultValue();
    }
    int j = 1 + this.bp;
    int k = indexOf('"', j);
    if (k == -1) {
      throw new JSONException("unclosed str");
    }
    String str = subString(1 + this.bp, k - j);
    for (int m = 1 + this.bp;; m++)
    {
      int n = 0;
      if (m < k)
      {
        if (charAt(m) == '\\') {
          n = 1;
        }
      }
      else
      {
        if (n == 0) {
          break;
        }
        this.matchStat = -1;
        return stringDefaultValue();
      }
    }
    int i1 = 1 + (1 + (k - (1 + this.bp)));
    int i2 = this.bp;
    int i3 = i1 + 1;
    if (charAt(i1 + i2) == paramChar)
    {
      this.bp += i3 - 1;
      next();
      this.matchStat = 3;
      return str;
    }
    this.matchStat = -1;
    return str;
  }
  
  public final void scanString()
  {
    this.np = this.bp;
    this.hasSpecial = false;
    for (;;)
    {
      char c1 = next();
      if (c1 == '"')
      {
        this.token = 4;
        this.ch = next();
        return;
      }
      if (c1 == '\032') {
        throw new JSONException("unclosed string : " + c1);
      }
      if (c1 == '\\')
      {
        if (!this.hasSpecial)
        {
          this.hasSpecial = true;
          if (this.sp >= this.sbuf.length)
          {
            int m = 2 * this.sbuf.length;
            if (this.sp > m) {
              m = this.sp;
            }
            char[] arrayOfChar2 = new char[m];
            System.arraycopy(this.sbuf, 0, arrayOfChar2, 0, this.sbuf.length);
            this.sbuf = arrayOfChar2;
          }
          copyTo(1 + this.np, this.sp, this.sbuf);
        }
        char c2 = next();
        switch (c2)
        {
        default: 
          this.ch = c2;
          throw new JSONException("unclosed string : " + c2);
        case '0': 
          putChar('\000');
          break;
        case '1': 
          putChar('\001');
          break;
        case '2': 
          putChar('\002');
          break;
        case '3': 
          putChar('\003');
          break;
        case '4': 
          putChar('\004');
          break;
        case '5': 
          putChar('\005');
          break;
        case '6': 
          putChar('\006');
          break;
        case '7': 
          putChar('\007');
          break;
        case 'b': 
          putChar('\b');
          break;
        case 't': 
          putChar('\t');
          break;
        case 'n': 
          putChar('\n');
          break;
        case 'v': 
          putChar('\013');
          break;
        case 'F': 
        case 'f': 
          putChar('\f');
          break;
        case 'r': 
          putChar('\r');
          break;
        case '"': 
          putChar('"');
          break;
        case '\'': 
          putChar('\'');
          break;
        case '/': 
          putChar('/');
          break;
        case '\\': 
          putChar('\\');
          break;
        case 'x': 
          int j = next();
          int k = next();
          putChar((char)(16 * digits[j] + digits[k]));
          break;
        case 'u': 
          putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16));
          break;
        }
      }
      else if (!this.hasSpecial)
      {
        this.sp = (1 + this.sp);
      }
      else if (this.sp == this.sbuf.length)
      {
        putChar(c1);
      }
      else
      {
        char[] arrayOfChar1 = this.sbuf;
        int i = this.sp;
        this.sp = (i + 1);
        arrayOfChar1[i] = c1;
      }
    }
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable)
  {
    skipWhitespace();
    if (this.ch == '"') {
      return scanSymbol(paramSymbolTable, '"');
    }
    if (this.ch == '\'')
    {
      if (!isEnabled(Feature.AllowSingleQuotes)) {
        throw new JSONException("syntax error");
      }
      return scanSymbol(paramSymbolTable, '\'');
    }
    if (this.ch == '}')
    {
      next();
      this.token = 13;
      return null;
    }
    if (this.ch == ',')
    {
      next();
      this.token = 16;
      return null;
    }
    if (this.ch == '\032')
    {
      this.token = 20;
      return null;
    }
    if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
      throw new JSONException("syntax error");
    }
    return scanSymbolUnQuoted(paramSymbolTable);
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable, char paramChar)
  {
    this.np = this.bp;
    this.sp = 0;
    int i = 0;
    int j = 0;
    char c1 = next();
    int i3;
    if (c1 == paramChar)
    {
      this.token = 4;
      if (i != 0) {
        break label949;
      }
      if (this.np != -1) {
        break label938;
      }
      i3 = 0;
    }
    label50:
    label949:
    for (String str = addSymbol(i3, this.sp, j, paramSymbolTable);; str = paramSymbolTable.addSymbol(this.sbuf, 0, this.sp, j))
    {
      this.sp = 0;
      next();
      return str;
      if (c1 == '\032') {
        throw new JSONException("unclosed.str");
      }
      if (c1 == '\\')
      {
        if (i == 0)
        {
          if (this.sp >= this.sbuf.length)
          {
            int i2 = 2 * this.sbuf.length;
            if (this.sp > i2) {
              i2 = this.sp;
            }
            char[] arrayOfChar2 = new char[i2];
            System.arraycopy(this.sbuf, 0, arrayOfChar2, 0, this.sbuf.length);
            this.sbuf = arrayOfChar2;
          }
          arrayCopy(1 + this.np, this.sbuf, 0, this.sp);
          i = 1;
        }
        int m = next();
        switch (m)
        {
        default: 
          this.ch = m;
          throw new JSONException("unclosed.str.lit");
        case 48: 
          j = m + j * 31;
          putChar('\000');
          break;
        case 49: 
          j = m + j * 31;
          putChar('\001');
          break;
        case 50: 
          j = m + j * 31;
          putChar('\002');
          break;
        case 51: 
          j = m + j * 31;
          putChar('\003');
          break;
        case 52: 
          j = m + j * 31;
          putChar('\004');
          break;
        case 53: 
          j = m + j * 31;
          putChar('\005');
          break;
        case 54: 
          j = m + j * 31;
          putChar('\006');
          break;
        case 55: 
          j = m + j * 31;
          putChar('\007');
          break;
        case 98: 
          j = 8 + j * 31;
          putChar('\b');
          break;
        case 116: 
          j = 9 + j * 31;
          putChar('\t');
          break;
        case 110: 
          j = 10 + j * 31;
          putChar('\n');
          break;
        case 118: 
          j = 11 + j * 31;
          putChar('\013');
          break;
        case 70: 
        case 102: 
          j = 12 + j * 31;
          putChar('\f');
          break;
        case 114: 
          j = 13 + j * 31;
          putChar('\r');
          break;
        case 34: 
          j = 34 + j * 31;
          putChar('"');
          break;
        case 39: 
          j = 39 + j * 31;
          putChar('\'');
          break;
        case 47: 
          j = 47 + j * 31;
          putChar('/');
          break;
        case 92: 
          j = 92 + j * 31;
          putChar('\\');
          break;
        case 120: 
          char c2 = next();
          this.ch = c2;
          char c3 = next();
          this.ch = c3;
          int i1 = (char)(16 * digits[c2] + digits[c3]);
          j = i1 + j * 31;
          putChar(i1);
          break;
        case 117: 
          int n = Integer.parseInt(new String(new char[] { next(), next(), next(), next() }), 16);
          j = n + j * 31;
          putChar((char)n);
          break;
        }
      }
      j = c1 + j * 31;
      if (i == 0)
      {
        this.sp = (1 + this.sp);
        break;
      }
      if (this.sp == this.sbuf.length)
      {
        putChar(c1);
        break;
      }
      char[] arrayOfChar1 = this.sbuf;
      int k = this.sp;
      this.sp = (k + 1);
      arrayOfChar1[k] = c1;
      break;
      i3 = 1 + this.np;
      break label50;
    }
  }
  
  public final String scanSymbolUnQuoted(SymbolTable paramSymbolTable)
  {
    boolean[] arrayOfBoolean1 = IOUtils.firstIdentifierFlags;
    int i = this.ch;
    if ((this.ch >= arrayOfBoolean1.length) || (arrayOfBoolean1[i] != 0)) {}
    for (int j = 1; j == 0; j = 0) {
      throw new JSONException("illegal identifier : " + this.ch);
    }
    boolean[] arrayOfBoolean2 = IOUtils.identifierFlags;
    this.np = this.bp;
    for (this.sp = 1;; this.sp = (1 + this.sp))
    {
      int k = next();
      if ((k < arrayOfBoolean2.length) && (arrayOfBoolean2[k] == 0))
      {
        this.ch = charAt(this.bp);
        this.token = 18;
        if ((this.sp != 4) || (i != 3392903) || (charAt(this.np) != 'n') || (charAt(1 + this.np) != 'u') || (charAt(2 + this.np) != 'l') || (charAt(3 + this.np) != 'l')) {
          break;
        }
        return null;
      }
      i = k + i * 31;
    }
    return addSymbol(this.np, this.sp, i, paramSymbolTable);
  }
  
  public String scanSymbolWithSeperator(SymbolTable paramSymbolTable, char paramChar)
  {
    this.matchStat = 0;
    int i = this.bp;
    int j = 1;
    int k = charAt(i + 0);
    if (k == 110)
    {
      if ((charAt(1 + this.bp) == 'u') && (charAt(1 + (1 + this.bp)) == 'l') && (charAt(2 + (1 + this.bp)) == 'l'))
      {
        if (charAt(4 + this.bp) == paramChar)
        {
          this.bp = (4 + this.bp);
          next();
          this.matchStat = 3;
          return null;
        }
      }
      else
      {
        this.matchStat = -1;
        return null;
      }
      this.matchStat = -1;
      return null;
    }
    int m = 0;
    if (k != 34)
    {
      this.matchStat = -1;
      return null;
    }
    int i2;
    String str;
    do
    {
      j = i1;
      int n = this.bp;
      int i1 = j + 1;
      i2 = charAt(j + n);
      if (i2 == 34)
      {
        int i3 = 1 + (0 + this.bp);
        str = addSymbol(i3, -1 + (i1 + this.bp - i3), m, paramSymbolTable);
        int i4 = this.bp;
        int i5 = i1 + 1;
        if (charAt(i4 + i1) != paramChar) {
          break;
        }
        this.bp += i5 - 1;
        next();
        this.matchStat = 3;
        return str;
      }
      m = i2 + m * 31;
    } while (i2 != 92);
    this.matchStat = -1;
    return null;
    this.matchStat = -1;
    return str;
  }
  
  public final void scanTreeSet()
  {
    if (this.ch != 'T') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'r') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'S') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 't') {
      throw new JSONException("error parse true");
    }
    next();
    if ((this.ch == ' ') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\f') || (this.ch == '\b') || (this.ch == '[') || (this.ch == '('))
    {
      this.token = 22;
      return;
    }
    throw new JSONException("scan set error");
  }
  
  public final void scanTrue()
  {
    if (this.ch != 't') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'r') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'u') {
      throw new JSONException("error parse true");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse true");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
    {
      this.token = 6;
      return;
    }
    throw new JSONException("scan true error");
  }
  
  public final void scanUndefined()
  {
    if (this.ch != 'u') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'n') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'd') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'f') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'i') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'n') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'e') {
      throw new JSONException("error parse false");
    }
    next();
    if (this.ch != 'd') {
      throw new JSONException("error parse false");
    }
    next();
    if ((this.ch == ' ') || (this.ch == ',') || (this.ch == '}') || (this.ch == ']') || (this.ch == '\n') || (this.ch == '\r') || (this.ch == '\t') || (this.ch == '\032') || (this.ch == '\f') || (this.ch == '\b'))
    {
      this.token = 23;
      return;
    }
    throw new JSONException("scan false error");
  }
  
  public final void skipWhitespace()
  {
    while ((this.ch < whitespaceFlags.length) && (whitespaceFlags[this.ch] != 0)) {
      next();
    }
  }
  
  public final String stringDefaultValue()
  {
    if (isEnabled(Feature.InitStringFieldAsEmpty)) {
      return "";
    }
    return null;
  }
  
  public abstract String stringVal();
  
  public abstract String subString(int paramInt1, int paramInt2);
  
  public final int token()
  {
    return this.token;
  }
  
  public final String tokenName()
  {
    return JSONToken.name(this.token);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.JSONLexerBase
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */