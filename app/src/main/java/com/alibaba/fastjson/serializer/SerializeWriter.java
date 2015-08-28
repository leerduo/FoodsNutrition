package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.Base64;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;

public final class SerializeWriter
  extends Writer
{
  private static final ThreadLocal<SoftReference<char[]>> bufLocal = new ThreadLocal();
  protected char[] buf;
  protected int count;
  private int features;
  private final Writer writer;
  
  public SerializeWriter()
  {
    this((Writer)null);
  }
  
  public SerializeWriter(int paramInt)
  {
    this(null, paramInt);
  }
  
  public SerializeWriter(Writer paramWriter)
  {
    this.writer = paramWriter;
    this.features = JSON.DEFAULT_GENERATE_FEATURE;
    SoftReference localSoftReference = (SoftReference)bufLocal.get();
    if (localSoftReference != null)
    {
      this.buf = ((char[])localSoftReference.get());
      bufLocal.set(null);
    }
    if (this.buf == null) {
      this.buf = new char[1024];
    }
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt)
  {
    this.writer = paramWriter;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Negative initial size: " + paramInt);
    }
    this.buf = new char[paramInt];
  }
  
  public SerializeWriter(Writer paramWriter, SerializerFeature... paramVarArgs)
  {
    this.writer = paramWriter;
    SoftReference localSoftReference = (SoftReference)bufLocal.get();
    if (localSoftReference != null)
    {
      this.buf = ((char[])localSoftReference.get());
      bufLocal.set(null);
    }
    if (this.buf == null) {
      this.buf = new char[1024];
    }
    int j = paramVarArgs.length;
    for (int k = 0; k < j; k++) {
      i |= paramVarArgs[k].getMask();
    }
    this.features = i;
  }
  
  public SerializeWriter(SerializerFeature... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  static final boolean isSpecial(char paramChar, int paramInt)
  {
    if (paramChar == ' ') {}
    do
    {
      return false;
      if ((paramChar == '/') && (SerializerFeature.isEnabled(paramInt, SerializerFeature.WriteSlashAsSpecial))) {
        return true;
      }
    } while (((paramChar > '#') && (paramChar != '\\')) || ((paramChar > '\037') && (paramChar != '\\') && (paramChar != '"')));
    return true;
  }
  
  private void writeFieldValueStringWithDoubleQuote(char paramChar, String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = paramString1.length();
    int j = this.count;
    int k;
    int m;
    if (paramString2 == null)
    {
      k = 4;
      m = j + (i + 8);
    }
    while (m > this.buf.length) {
      if (this.writer != null)
      {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':', paramBoolean);
        writeStringWithDoubleQuote(paramString2, '\000', paramBoolean);
        return;
        k = paramString2.length();
        m = j + (6 + (i + k));
      }
      else
      {
        expandCapacity(m);
      }
    }
    this.buf[this.count] = paramChar;
    int n = 2 + this.count;
    int i1 = n + i;
    this.buf[(1 + this.count)] = '"';
    paramString1.getChars(0, i, this.buf, n);
    this.count = m;
    this.buf[i1] = '"';
    int i2 = i1 + 1;
    char[] arrayOfChar1 = this.buf;
    int i3 = i2 + 1;
    arrayOfChar1[i2] = ':';
    if (paramString2 == null)
    {
      char[] arrayOfChar27 = this.buf;
      int i59 = i3 + 1;
      arrayOfChar27[i3] = 'n';
      char[] arrayOfChar28 = this.buf;
      int i60 = i59 + 1;
      arrayOfChar28[i59] = 'u';
      char[] arrayOfChar29 = this.buf;
      int i61 = i60 + 1;
      arrayOfChar29[i60] = 'l';
      char[] arrayOfChar30 = this.buf;
      (i61 + 1);
      arrayOfChar30[i61] = 'l';
      return;
    }
    char[] arrayOfChar2 = this.buf;
    int i4 = i3 + 1;
    arrayOfChar2[i3] = '"';
    int i5 = i4 + k;
    paramString2.getChars(0, k, this.buf, i4);
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i48;
    int i54;
    int i55;
    int i50;
    int i53;
    int i52;
    int i49;
    int i51;
    if ((paramBoolean) && (!isEnabled(SerializerFeature.DisableCheckSpecialChar)))
    {
      i6 = 0;
      i7 = -1;
      i8 = 0;
      i9 = i4;
      i10 = m;
      i11 = -1;
      if (i9 < i5)
      {
        i48 = this.buf[i9];
        if (i48 == 8232)
        {
          i54 = i6 + 1;
          i55 = i10 + 4;
          if (i11 != -1) {
            break label1510;
          }
          i50 = i48;
          i53 = i55;
          i52 = i54;
          i49 = i9;
          i51 = i9;
        }
      }
    }
    for (;;)
    {
      i9++;
      i10 = i53;
      i6 = i52;
      i7 = i51;
      i8 = i50;
      i11 = i49;
      break;
      if (i48 >= 93)
      {
        if ((i48 >= 127) && (i48 <= 160))
        {
          if (i11 == -1) {
            i11 = i9;
          }
          int i57 = i6 + 1;
          i53 = i10 + 4;
          i52 = i57;
          i51 = i9;
          int i58 = i11;
          i50 = i48;
          i49 = i58;
        }
      }
      else
      {
        if (isSpecial(i48, this.features))
        {
          i54 = i6 + 1;
          if ((i48 < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[i48] == 4)) {}
          for (i55 = i10 + 4;; i55 = i10)
          {
            if (i11 == -1)
            {
              i50 = i48;
              i53 = i55;
              i52 = i54;
              i49 = i9;
              i51 = i9;
              break;
              if (i6 > 0)
              {
                int i12 = i10 + i6;
                if (i12 > this.buf.length) {
                  expandCapacity(i12);
                }
                this.count = i12;
                if (i6 != 1) {
                  break label1041;
                }
                if (i8 != 8232) {
                  break label766;
                }
                i41 = i7 + 1;
                i42 = i7 + 6;
                i43 = -1 + (i5 - i7);
                System.arraycopy(this.buf, i41, this.buf, i42, i43);
                this.buf[i7] = '\\';
                arrayOfChar23 = this.buf;
                i44 = i7 + 1;
                arrayOfChar23[i44] = 'u';
                arrayOfChar24 = this.buf;
                i45 = i44 + 1;
                arrayOfChar24[i45] = '2';
                arrayOfChar25 = this.buf;
                i46 = i45 + 1;
                arrayOfChar25[i46] = '0';
                arrayOfChar26 = this.buf;
                i47 = i46 + 1;
                arrayOfChar26[i47] = '2';
                this.buf[(i47 + 1)] = '8';
              }
              label766:
              while (i6 <= 1) {
                for (;;)
                {
                  int i41;
                  int i42;
                  int i43;
                  char[] arrayOfChar23;
                  int i44;
                  char[] arrayOfChar24;
                  int i45;
                  char[] arrayOfChar25;
                  int i46;
                  char[] arrayOfChar26;
                  int i47;
                  this.buf[(-1 + this.count)] = '"';
                  return;
                  if ((i8 < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[i8] == 4))
                  {
                    int i33 = i7 + 1;
                    int i34 = i7 + 6;
                    int i35 = -1 + (i5 - i7);
                    System.arraycopy(this.buf, i33, this.buf, i34, i35);
                    char[] arrayOfChar17 = this.buf;
                    int i36 = i7 + 1;
                    arrayOfChar17[i7] = '\\';
                    char[] arrayOfChar18 = this.buf;
                    int i37 = i36 + 1;
                    arrayOfChar18[i36] = 'u';
                    char[] arrayOfChar19 = this.buf;
                    int i38 = i37 + 1;
                    arrayOfChar19[i37] = IOUtils.DIGITS[(0xF & i8 >>> 12)];
                    char[] arrayOfChar20 = this.buf;
                    int i39 = i38 + 1;
                    arrayOfChar20[i38] = IOUtils.DIGITS[(0xF & i8 >>> 8)];
                    char[] arrayOfChar21 = this.buf;
                    int i40 = i39 + 1;
                    arrayOfChar21[i39] = IOUtils.DIGITS[(0xF & i8 >>> 4)];
                    char[] arrayOfChar22 = this.buf;
                    (i40 + 1);
                    arrayOfChar22[i40] = IOUtils.DIGITS[(i8 & 0xF)];
                  }
                  else
                  {
                    int i30 = i7 + 1;
                    int i31 = i7 + 2;
                    int i32 = -1 + (i5 - i7);
                    System.arraycopy(this.buf, i30, this.buf, i31, i32);
                    this.buf[i7] = '\\';
                    this.buf[(i7 + 1)] = IOUtils.replaceChars[i8];
                  }
                }
              }
              label1041:
              int i13 = i11 - i4;
              int i14 = i5;
              int i15 = i11;
              int i16 = i13;
              int i17 = i15;
              label1070:
              int i18;
              int i25;
              if (i16 < paramString2.length())
              {
                i18 = paramString2.charAt(i16);
                if (((i18 >= IOUtils.specicalFlags_doubleQuotes.length) || (IOUtils.specicalFlags_doubleQuotes[i18] == 0)) && ((i18 != 47) || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
                  break label1320;
                }
                char[] arrayOfChar10 = this.buf;
                i25 = i17 + 1;
                arrayOfChar10[i17] = '\\';
                if (IOUtils.specicalFlags_doubleQuotes[i18] != 4) {
                  break label1291;
                }
                char[] arrayOfChar12 = this.buf;
                int i26 = i25 + 1;
                arrayOfChar12[i25] = 'u';
                char[] arrayOfChar13 = this.buf;
                int i27 = i26 + 1;
                arrayOfChar13[i26] = IOUtils.DIGITS[(0xF & i18 >>> 12)];
                char[] arrayOfChar14 = this.buf;
                int i28 = i27 + 1;
                arrayOfChar14[i27] = IOUtils.DIGITS[(0xF & i18 >>> 8)];
                char[] arrayOfChar15 = this.buf;
                int i29 = i28 + 1;
                arrayOfChar15[i28] = IOUtils.DIGITS[(0xF & i18 >>> 4)];
                char[] arrayOfChar16 = this.buf;
                i17 = i29 + 1;
                arrayOfChar16[i29] = IOUtils.DIGITS[(i18 & 0xF)];
                i14 += 5;
              }
              for (;;)
              {
                i16++;
                break label1070;
                break;
                label1291:
                char[] arrayOfChar11 = this.buf;
                i17 = i25 + 1;
                arrayOfChar11[i25] = IOUtils.replaceChars[i18];
                i14++;
                continue;
                label1320:
                if (i18 == 8232)
                {
                  char[] arrayOfChar4 = this.buf;
                  int i20 = i17 + 1;
                  arrayOfChar4[i17] = '\\';
                  char[] arrayOfChar5 = this.buf;
                  int i21 = i20 + 1;
                  arrayOfChar5[i20] = 'u';
                  char[] arrayOfChar6 = this.buf;
                  int i22 = i21 + 1;
                  arrayOfChar6[i21] = IOUtils.DIGITS[(0xF & i18 >>> 12)];
                  char[] arrayOfChar7 = this.buf;
                  int i23 = i22 + 1;
                  arrayOfChar7[i22] = IOUtils.DIGITS[(0xF & i18 >>> 8)];
                  char[] arrayOfChar8 = this.buf;
                  int i24 = i23 + 1;
                  arrayOfChar8[i23] = IOUtils.DIGITS[(0xF & i18 >>> 4)];
                  char[] arrayOfChar9 = this.buf;
                  i17 = i24 + 1;
                  arrayOfChar9[i24] = IOUtils.DIGITS[(i18 & 0xF)];
                  i14 += 5;
                }
                else
                {
                  char[] arrayOfChar3 = this.buf;
                  int i19 = i17 + 1;
                  arrayOfChar3[i17] = i18;
                  i17 = i19;
                }
              }
            }
            label1510:
            i53 = i55;
            i52 = i54;
            i51 = i9;
            int i56 = i11;
            i50 = i48;
            i49 = i56;
            break;
          }
        }
        i49 = i11;
        i50 = i8;
        i51 = i7;
        i52 = i6;
        i53 = i10;
      }
    }
  }
  
  private void writeKeyWithDoubleQuoteIfHasSpecial(String paramString)
  {
    byte[] arrayOfByte = IOUtils.specicalFlags_doubleQuotes;
    int i = paramString.length();
    int j = 1 + (i + this.count);
    int i7;
    if (j > this.buf.length) {
      if (this.writer != null)
      {
        if (i == 0)
        {
          write('"');
          write('"');
          write(':');
          return;
        }
        i7 = 0;
        if (i7 >= i) {
          break label619;
        }
        int i11 = paramString.charAt(i7);
        if ((i11 >= arrayOfByte.length) || (arrayOfByte[i11] == 0)) {}
      }
    }
    label521:
    label619:
    for (int i8 = 1;; i8 = 0)
    {
      if (i8 != 0) {
        write('"');
      }
      int i9 = 0;
      label107:
      if (i9 < i)
      {
        int i10 = paramString.charAt(i9);
        if ((i10 < arrayOfByte.length) && (arrayOfByte[i10] != 0))
        {
          write('\\');
          write(IOUtils.replaceChars[i10]);
        }
        for (;;)
        {
          i9++;
          break label107;
          i7++;
          break;
          write(i10);
        }
      }
      if (i8 != 0) {
        write('"');
      }
      write(':');
      return;
      expandCapacity(j);
      if (i == 0)
      {
        if (3 + this.count > this.buf.length) {
          expandCapacity(3 + this.count);
        }
        char[] arrayOfChar4 = this.buf;
        int i4 = this.count;
        this.count = (i4 + 1);
        arrayOfChar4[i4] = '"';
        char[] arrayOfChar5 = this.buf;
        int i5 = this.count;
        this.count = (i5 + 1);
        arrayOfChar5[i5] = '"';
        char[] arrayOfChar6 = this.buf;
        int i6 = this.count;
        this.count = (i6 + 1);
        arrayOfChar6[i6] = ':';
        return;
      }
      int k = this.count;
      int m = k + i;
      paramString.getChars(0, i, this.buf, k);
      this.count = j;
      int n = 0;
      int i1 = k;
      if (i1 < m)
      {
        int i2 = this.buf[i1];
        if ((i2 < arrayOfByte.length) && (arrayOfByte[i2] != 0))
        {
          if (n != 0) {
            break label521;
          }
          j += 3;
          if (j > this.buf.length) {
            expandCapacity(j);
          }
          this.count = j;
          System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 3, -1 + (m - i1));
          System.arraycopy(this.buf, 0, this.buf, 1, i1);
          this.buf[k] = '"';
          char[] arrayOfChar2 = this.buf;
          int i3 = i1 + 1;
          arrayOfChar2[i3] = '\\';
          char[] arrayOfChar3 = this.buf;
          i1 = i3 + 1;
          arrayOfChar3[i1] = IOUtils.replaceChars[i2];
          m += 2;
          this.buf[(-2 + this.count)] = '"';
          n = 1;
        }
        for (;;)
        {
          i1++;
          break;
          j++;
          if (j > this.buf.length) {
            expandCapacity(j);
          }
          this.count = j;
          System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 2, m - i1);
          this.buf[i1] = '\\';
          char[] arrayOfChar1 = this.buf;
          i1++;
          arrayOfChar1[i1] = IOUtils.replaceChars[i2];
          m++;
        }
      }
      this.buf[(-1 + this.count)] = ':';
      return;
    }
  }
  
  private void writeKeyWithSingleQuoteIfHasSpecial(String paramString)
  {
    byte[] arrayOfByte = IOUtils.specicalFlags_singleQuotes;
    int i = paramString.length();
    int j = 1 + (i + this.count);
    int i7;
    if (j > this.buf.length) {
      if (this.writer != null)
      {
        if (i == 0)
        {
          write('\'');
          write('\'');
          write(':');
          return;
        }
        i7 = 0;
        if (i7 >= i) {
          break label617;
        }
        int i11 = paramString.charAt(i7);
        if ((i11 >= arrayOfByte.length) || (arrayOfByte[i11] == 0)) {}
      }
    }
    label521:
    label617:
    for (int i8 = 1;; i8 = 0)
    {
      if (i8 != 0) {
        write('\'');
      }
      int i9 = 0;
      label107:
      if (i9 < i)
      {
        int i10 = paramString.charAt(i9);
        if ((i10 < arrayOfByte.length) && (arrayOfByte[i10] != 0))
        {
          write('\\');
          write(IOUtils.replaceChars[i10]);
        }
        for (;;)
        {
          i9++;
          break label107;
          i7++;
          break;
          write(i10);
        }
      }
      if (i8 != 0) {
        write('\'');
      }
      write(':');
      return;
      expandCapacity(j);
      if (i == 0)
      {
        if (3 + this.count > this.buf.length) {
          expandCapacity(3 + this.count);
        }
        char[] arrayOfChar4 = this.buf;
        int i4 = this.count;
        this.count = (i4 + 1);
        arrayOfChar4[i4] = '\'';
        char[] arrayOfChar5 = this.buf;
        int i5 = this.count;
        this.count = (i5 + 1);
        arrayOfChar5[i5] = '\'';
        char[] arrayOfChar6 = this.buf;
        int i6 = this.count;
        this.count = (i6 + 1);
        arrayOfChar6[i6] = ':';
        return;
      }
      int k = this.count;
      int m = k + i;
      paramString.getChars(0, i, this.buf, k);
      this.count = j;
      int n = 0;
      int i1 = k;
      if (i1 < m)
      {
        int i2 = this.buf[i1];
        if ((i2 < arrayOfByte.length) && (arrayOfByte[i2] != 0))
        {
          if (n != 0) {
            break label521;
          }
          j += 3;
          if (j > this.buf.length) {
            expandCapacity(j);
          }
          this.count = j;
          System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 3, -1 + (m - i1));
          System.arraycopy(this.buf, 0, this.buf, 1, i1);
          this.buf[k] = '\'';
          char[] arrayOfChar2 = this.buf;
          int i3 = i1 + 1;
          arrayOfChar2[i3] = '\\';
          char[] arrayOfChar3 = this.buf;
          i1 = i3 + 1;
          arrayOfChar3[i1] = IOUtils.replaceChars[i2];
          m += 2;
          this.buf[(-2 + this.count)] = '\'';
          n = 1;
        }
        for (;;)
        {
          i1++;
          break;
          j++;
          if (j > this.buf.length) {
            expandCapacity(j);
          }
          this.count = j;
          System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 2, m - i1);
          this.buf[i1] = '\\';
          char[] arrayOfChar1 = this.buf;
          i1++;
          arrayOfChar1[i1] = IOUtils.replaceChars[i2];
          m++;
        }
      }
      this.buf[(j - 1)] = ':';
      return;
    }
  }
  
  private void writeStringWithDoubleQuote(String paramString, char paramChar)
  {
    writeStringWithDoubleQuote(paramString, paramChar, true);
  }
  
  private void writeStringWithDoubleQuote(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null)
    {
      writeNull();
      if (paramChar != 0) {
        write(paramChar);
      }
    }
    int i;
    int j;
    do
    {
      return;
      i = paramString.length();
      j = 2 + (i + this.count);
      if (paramChar != 0) {
        j++;
      }
      if (j <= this.buf.length) {
        break label400;
      }
      if (this.writer == null) {
        break;
      }
      write('"');
      int i60 = 0;
      if (i60 < paramString.length())
      {
        int i61 = paramString.charAt(i60);
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
          if ((i61 == 8) || (i61 == 12) || (i61 == 10) || (i61 == 13) || (i61 == 9) || (i61 == 34) || (i61 == 47) || (i61 == 92))
          {
            write('\\');
            write(IOUtils.replaceChars[i61]);
          }
        }
        for (;;)
        {
          i60++;
          break;
          if (i61 < 32)
          {
            write('\\');
            write('u');
            write('0');
            write('0');
            write(IOUtils.ASCII_CHARS[(i61 * 2)]);
            write(IOUtils.ASCII_CHARS[(1 + i61 * 2)]);
          }
          else if (i61 >= 127)
          {
            write('\\');
            write('u');
            write(IOUtils.DIGITS[(0xF & i61 >>> 12)]);
            write(IOUtils.DIGITS[(0xF & i61 >>> 8)]);
            write(IOUtils.DIGITS[(0xF & i61 >>> 4)]);
            write(IOUtils.DIGITS[(i61 & 0xF)]);
            continue;
            if (((i61 < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[i61] != 0)) || ((i61 == 47) && (isEnabled(SerializerFeature.WriteSlashAsSpecial))))
            {
              write('\\');
              write(IOUtils.replaceChars[i61]);
            }
          }
          else
          {
            write(i61);
          }
        }
      }
      write('"');
    } while (paramChar == 0);
    write(paramChar);
    return;
    expandCapacity(j);
    label400:
    int k = 1 + this.count;
    int m = k + i;
    this.buf[this.count] = '"';
    paramString.getChars(0, i, this.buf, k);
    this.count = j;
    if (isEnabled(SerializerFeature.BrowserCompatible))
    {
      int i53 = j;
      int i54 = -1;
      int i55 = k;
      if (i55 < m)
      {
        int i59 = this.buf[i55];
        if ((i59 == 34) || (i59 == 47) || (i59 == 92))
        {
          i53++;
          i54 = i55;
        }
        for (;;)
        {
          i55++;
          break;
          if ((i59 == 8) || (i59 == 12) || (i59 == 10) || (i59 == 13) || (i59 == 9))
          {
            i53++;
            i54 = i55;
          }
          else if (i59 < 32)
          {
            i53 += 5;
            i54 = i55;
          }
          else if (i59 >= 127)
          {
            i53 += 5;
            i54 = i55;
          }
        }
      }
      if (i53 > this.buf.length) {
        expandCapacity(i53);
      }
      this.count = i53;
      int i56 = i54;
      int i57 = m;
      if (i56 >= k)
      {
        int i58 = this.buf[i56];
        if ((i58 == 8) || (i58 == 12) || (i58 == 10) || (i58 == 13) || (i58 == 9))
        {
          System.arraycopy(this.buf, i56 + 1, this.buf, i56 + 2, -1 + (i57 - i56));
          this.buf[i56] = '\\';
          this.buf[(i56 + 1)] = IOUtils.replaceChars[i58];
          i57++;
        }
        for (;;)
        {
          i56--;
          break;
          if ((i58 == 34) || (i58 == 47) || (i58 == 92))
          {
            System.arraycopy(this.buf, i56 + 1, this.buf, i56 + 2, -1 + (i57 - i56));
            this.buf[i56] = '\\';
            this.buf[(i56 + 1)] = i58;
            i57++;
          }
          else if (i58 < 32)
          {
            System.arraycopy(this.buf, i56 + 1, this.buf, i56 + 6, -1 + (i57 - i56));
            this.buf[i56] = '\\';
            this.buf[(i56 + 1)] = 'u';
            this.buf[(i56 + 2)] = '0';
            this.buf[(i56 + 3)] = '0';
            this.buf[(i56 + 4)] = IOUtils.ASCII_CHARS[(i58 * 2)];
            this.buf[(i56 + 5)] = IOUtils.ASCII_CHARS[(1 + i58 * 2)];
            i57 += 5;
          }
          else if (i58 >= 127)
          {
            System.arraycopy(this.buf, i56 + 1, this.buf, i56 + 6, -1 + (i57 - i56));
            this.buf[i56] = '\\';
            this.buf[(i56 + 1)] = 'u';
            this.buf[(i56 + 2)] = IOUtils.DIGITS[(0xF & i58 >>> 12)];
            this.buf[(i56 + 3)] = IOUtils.DIGITS[(0xF & i58 >>> 8)];
            this.buf[(i56 + 4)] = IOUtils.DIGITS[(0xF & i58 >>> 4)];
            this.buf[(i56 + 5)] = IOUtils.DIGITS[(i58 & 0xF)];
            i57 += 5;
          }
        }
      }
      if (paramChar != 0)
      {
        this.buf[(-2 + this.count)] = '"';
        this.buf[(-1 + this.count)] = paramChar;
        return;
      }
      this.buf[(-1 + this.count)] = '"';
      return;
    }
    int n = 0;
    int i1 = -1;
    int i2 = 0;
    int i3;
    int i4;
    int i5;
    int i42;
    int i48;
    int i49;
    int i44;
    int i47;
    int i46;
    int i43;
    int i45;
    if (paramBoolean)
    {
      i3 = k;
      i4 = j;
      i5 = -1;
      if (i3 < m)
      {
        i42 = this.buf[i3];
        if (i42 == 8232)
        {
          i48 = n + 1;
          i49 = i4 + 4;
          if (i5 != -1) {
            break label2334;
          }
          i44 = i42;
          i47 = i49;
          i46 = i48;
          i43 = i3;
          i45 = i3;
        }
      }
    }
    for (;;)
    {
      i3++;
      i4 = i47;
      n = i46;
      i1 = i45;
      i2 = i44;
      i5 = i43;
      break;
      if (i42 >= 93)
      {
        if ((i42 >= 127) && (i42 <= 160))
        {
          if (i5 == -1) {
            i5 = i3;
          }
          int i51 = n + 1;
          i47 = i4 + 4;
          i46 = i51;
          i45 = i3;
          int i52 = i5;
          i44 = i42;
          i43 = i52;
        }
      }
      else
      {
        if (isSpecial(i42, this.features))
        {
          i48 = n + 1;
          if ((i42 < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[i42] == 4)) {}
          for (i49 = i4 + 4;; i49 = i4)
          {
            if (i5 == -1)
            {
              i44 = i42;
              i47 = i49;
              i46 = i48;
              i43 = i3;
              i45 = i3;
              break;
              if (n > 0)
              {
                int i6 = i4 + n;
                if (i6 > this.buf.length) {
                  expandCapacity(i6);
                }
                this.count = i6;
                if (n != 1) {
                  break label1851;
                }
                if (i2 != 8232) {
                  break label1576;
                }
                int i35 = i1 + 1;
                int i36 = i1 + 6;
                int i37 = -1 + (m - i1);
                System.arraycopy(this.buf, i35, this.buf, i36, i37);
                this.buf[i1] = '\\';
                char[] arrayOfChar21 = this.buf;
                int i38 = i1 + 1;
                arrayOfChar21[i38] = 'u';
                char[] arrayOfChar22 = this.buf;
                int i39 = i38 + 1;
                arrayOfChar22[i39] = '2';
                char[] arrayOfChar23 = this.buf;
                int i40 = i39 + 1;
                arrayOfChar23[i40] = '0';
                char[] arrayOfChar24 = this.buf;
                int i41 = i40 + 1;
                arrayOfChar24[i41] = '2';
                this.buf[(i41 + 1)] = '8';
              }
              while (paramChar != 0)
              {
                this.buf[(-2 + this.count)] = '"';
                this.buf[(-1 + this.count)] = paramChar;
                return;
                label1576:
                label2101:
                if ((i2 < IOUtils.specicalFlags_doubleQuotes.length) && (IOUtils.specicalFlags_doubleQuotes[i2] == 4))
                {
                  int i27 = i1 + 1;
                  int i28 = i1 + 6;
                  int i29 = -1 + (m - i1);
                  System.arraycopy(this.buf, i27, this.buf, i28, i29);
                  char[] arrayOfChar15 = this.buf;
                  int i30 = i1 + 1;
                  arrayOfChar15[i1] = '\\';
                  char[] arrayOfChar16 = this.buf;
                  int i31 = i30 + 1;
                  arrayOfChar16[i30] = 'u';
                  char[] arrayOfChar17 = this.buf;
                  int i32 = i31 + 1;
                  arrayOfChar17[i31] = IOUtils.DIGITS[(0xF & i2 >>> 12)];
                  char[] arrayOfChar18 = this.buf;
                  int i33 = i32 + 1;
                  arrayOfChar18[i32] = IOUtils.DIGITS[(0xF & i2 >>> 8)];
                  char[] arrayOfChar19 = this.buf;
                  int i34 = i33 + 1;
                  arrayOfChar19[i33] = IOUtils.DIGITS[(0xF & i2 >>> 4)];
                  char[] arrayOfChar20 = this.buf;
                  (i34 + 1);
                  arrayOfChar20[i34] = IOUtils.DIGITS[(i2 & 0xF)];
                }
                else
                {
                  int i24 = i1 + 1;
                  int i25 = i1 + 2;
                  int i26 = -1 + (m - i1);
                  System.arraycopy(this.buf, i24, this.buf, i25, i26);
                  this.buf[i1] = '\\';
                  this.buf[(i1 + 1)] = IOUtils.replaceChars[i2];
                  continue;
                  label1851:
                  if (n > 1)
                  {
                    int i7 = i5 - k;
                    int i8 = m;
                    int i9 = i5;
                    int i10 = i7;
                    int i11 = i9;
                    label1880:
                    int i12;
                    int i19;
                    if (i10 < paramString.length())
                    {
                      i12 = paramString.charAt(i10);
                      if (((i12 >= IOUtils.specicalFlags_doubleQuotes.length) || (IOUtils.specicalFlags_doubleQuotes[i12] == 0)) && ((i12 != 47) || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
                        break label2130;
                      }
                      char[] arrayOfChar8 = this.buf;
                      i19 = i11 + 1;
                      arrayOfChar8[i11] = '\\';
                      if (IOUtils.specicalFlags_doubleQuotes[i12] != 4) {
                        break label2101;
                      }
                      char[] arrayOfChar10 = this.buf;
                      int i20 = i19 + 1;
                      arrayOfChar10[i19] = 'u';
                      char[] arrayOfChar11 = this.buf;
                      int i21 = i20 + 1;
                      arrayOfChar11[i20] = IOUtils.DIGITS[(0xF & i12 >>> 12)];
                      char[] arrayOfChar12 = this.buf;
                      int i22 = i21 + 1;
                      arrayOfChar12[i21] = IOUtils.DIGITS[(0xF & i12 >>> 8)];
                      char[] arrayOfChar13 = this.buf;
                      int i23 = i22 + 1;
                      arrayOfChar13[i22] = IOUtils.DIGITS[(0xF & i12 >>> 4)];
                      char[] arrayOfChar14 = this.buf;
                      i11 = i23 + 1;
                      arrayOfChar14[i23] = IOUtils.DIGITS[(i12 & 0xF)];
                      i8 += 5;
                    }
                    for (;;)
                    {
                      i10++;
                      break label1880;
                      break;
                      char[] arrayOfChar9 = this.buf;
                      i11 = i19 + 1;
                      arrayOfChar9[i19] = IOUtils.replaceChars[i12];
                      i8++;
                      continue;
                      label2130:
                      if (i12 == 8232)
                      {
                        char[] arrayOfChar2 = this.buf;
                        int i14 = i11 + 1;
                        arrayOfChar2[i11] = '\\';
                        char[] arrayOfChar3 = this.buf;
                        int i15 = i14 + 1;
                        arrayOfChar3[i14] = 'u';
                        char[] arrayOfChar4 = this.buf;
                        int i16 = i15 + 1;
                        arrayOfChar4[i15] = IOUtils.DIGITS[(0xF & i12 >>> 12)];
                        char[] arrayOfChar5 = this.buf;
                        int i17 = i16 + 1;
                        arrayOfChar5[i16] = IOUtils.DIGITS[(0xF & i12 >>> 8)];
                        char[] arrayOfChar6 = this.buf;
                        int i18 = i17 + 1;
                        arrayOfChar6[i17] = IOUtils.DIGITS[(0xF & i12 >>> 4)];
                        char[] arrayOfChar7 = this.buf;
                        i11 = i18 + 1;
                        arrayOfChar7[i18] = IOUtils.DIGITS[(i12 & 0xF)];
                        i8 += 5;
                      }
                      else
                      {
                        char[] arrayOfChar1 = this.buf;
                        int i13 = i11 + 1;
                        arrayOfChar1[i11] = i12;
                        i11 = i13;
                      }
                    }
                  }
                }
              }
              this.buf[(-1 + this.count)] = '"';
              return;
            }
            label2334:
            i47 = i49;
            i46 = i48;
            i45 = i3;
            int i50 = i5;
            i44 = i42;
            i43 = i50;
            break;
          }
        }
        i43 = i5;
        i44 = i2;
        i45 = i1;
        i46 = n;
        i47 = i4;
      }
    }
  }
  
  private void writeStringWithSingleQuote(String paramString)
  {
    int i = 0;
    if (paramString == null)
    {
      int i14 = 4 + this.count;
      if (i14 > this.buf.length) {
        expandCapacity(i14);
      }
      "null".getChars(0, 4, this.buf, this.count);
      this.count = i14;
      return;
    }
    int j = paramString.length();
    int k = 2 + (j + this.count);
    if (k > this.buf.length)
    {
      if (this.writer != null)
      {
        write('\'');
        if (i < paramString.length())
        {
          char c = paramString.charAt(i);
          if ((c <= '\r') || (c == '\\') || (c == '\'') || ((c == '/') && (isEnabled(SerializerFeature.WriteSlashAsSpecial))))
          {
            write('\\');
            write(IOUtils.replaceChars[c]);
          }
          for (;;)
          {
            i++;
            break;
            write(c);
          }
        }
        write('\'');
        return;
      }
      expandCapacity(k);
    }
    int m = 1 + this.count;
    int n = m + j;
    this.buf[this.count] = '\'';
    paramString.getChars(0, j, this.buf, m);
    this.count = k;
    int i1 = -1;
    int i2 = m;
    int i3 = 0;
    int i12;
    int i13;
    if (i2 < n)
    {
      int i11 = this.buf[i2];
      if ((i11 > 13) && (i11 != 92) && (i11 != 39) && ((i11 != 47) || (!isEnabled(SerializerFeature.WriteSlashAsSpecial)))) {
        break label615;
      }
      i12 = i3 + 1;
      i = i11;
      i13 = i2;
    }
    for (;;)
    {
      i2++;
      i3 = i12;
      i1 = i13;
      break;
      int i4 = k + i3;
      if (i4 > this.buf.length) {
        expandCapacity(i4);
      }
      this.count = i4;
      if (i3 == 1)
      {
        System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 2, -1 + (n - i1));
        this.buf[i1] = '\\';
        this.buf[(i1 + 1)] = IOUtils.replaceChars[i];
      }
      for (;;)
      {
        this.buf[(-1 + this.count)] = '\'';
        return;
        if (i3 > 1)
        {
          System.arraycopy(this.buf, i1 + 1, this.buf, i1 + 2, -1 + (n - i1));
          this.buf[i1] = '\\';
          char[] arrayOfChar = this.buf;
          int i5 = i1 + 1;
          arrayOfChar[i5] = IOUtils.replaceChars[i];
          int i6 = n + 1;
          int i7 = i5 - 2;
          int i8 = i6;
          for (int i9 = i7; i9 >= m; i9--)
          {
            int i10 = this.buf[i9];
            if ((i10 <= 13) || (i10 == 92) || (i10 == 39) || ((i10 == 47) && (isEnabled(SerializerFeature.WriteSlashAsSpecial))))
            {
              System.arraycopy(this.buf, i9 + 1, this.buf, i9 + 2, -1 + (i8 - i9));
              this.buf[i9] = '\\';
              this.buf[(i9 + 1)] = IOUtils.replaceChars[i10];
              i8++;
            }
          }
        }
      }
      label615:
      i13 = i1;
      i12 = i3;
    }
  }
  
  public SerializeWriter append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public SerializeWriter append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (String str = "null";; str = paramCharSequence.toString())
    {
      write(str, 0, str.length());
      return this;
    }
  }
  
  public SerializeWriter append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "null";
    }
    String str = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
    write(str, 0, str.length());
    return this;
  }
  
  public void close()
  {
    if ((this.writer != null) && (this.count > 0)) {
      flush();
    }
    if (this.buf.length <= 8192) {
      bufLocal.set(new SoftReference(this.buf));
    }
    this.buf = null;
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.features |= paramSerializerFeature.getMask();
      return;
    }
    this.features &= (0xFFFFFFFF ^ paramSerializerFeature.getMask());
  }
  
  public void expandCapacity(int paramInt)
  {
    int i = 1 + 3 * this.buf.length / 2;
    if (i < paramInt) {}
    for (;;)
    {
      char[] arrayOfChar = new char[paramInt];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      this.buf = arrayOfChar;
      return;
      paramInt = i;
    }
  }
  
  public void flush()
  {
    if (this.writer == null) {
      return;
    }
    try
    {
      this.writer.write(this.buf, 0, this.count);
      this.writer.flush();
      this.count = 0;
      return;
    }
    catch (IOException localIOException)
    {
      throw new JSONException(localIOException.getMessage(), localIOException);
    }
  }
  
  public int getBufferLength()
  {
    return this.buf.length;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return SerializerFeature.isEnabled(this.features, paramSerializerFeature);
  }
  
  public void reset()
  {
    this.count = 0;
  }
  
  public int size()
  {
    return this.count;
  }
  
  public byte[] toBytes(String paramString)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    if (paramString == null) {
      paramString = "UTF-8";
    }
    try
    {
      byte[] arrayOfByte = new String(this.buf, 0, this.count).getBytes(paramString);
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new JSONException("toBytes error", localUnsupportedEncodingException);
    }
  }
  
  public char[] toCharArray()
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    char[] arrayOfChar = new char[this.count];
    System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
    return arrayOfChar;
  }
  
  public String toString()
  {
    return new String(this.buf, 0, this.count);
  }
  
  public void write(char paramChar)
  {
    int i = 1 + this.count;
    if (i > this.buf.length)
    {
      if (this.writer != null) {
        break label44;
      }
      expandCapacity(i);
    }
    for (;;)
    {
      this.buf[this.count] = paramChar;
      this.count = i;
      return;
      label44:
      flush();
      i = 1;
    }
  }
  
  public void write(int paramInt)
  {
    int i = 1 + this.count;
    if (i > this.buf.length)
    {
      if (this.writer != null) {
        break label45;
      }
      expandCapacity(i);
    }
    for (;;)
    {
      this.buf[this.count] = ((char)paramInt);
      this.count = i;
      return;
      label45:
      flush();
      i = 1;
    }
  }
  
  public void write(String paramString)
  {
    if (paramString == null)
    {
      writeNull();
      return;
    }
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2 + this.count;
    int j;
    if (i > this.buf.length) {
      if (this.writer == null)
      {
        expandCapacity(i);
        j = paramInt2;
        paramInt2 = i;
      }
    }
    for (;;)
    {
      paramString.getChars(paramInt1, j + paramInt1, this.buf, this.count);
      this.count = paramInt2;
      return;
      do
      {
        int k = this.buf.length - this.count;
        paramString.getChars(paramInt1, paramInt1 + k, this.buf, this.count);
        this.count = this.buf.length;
        flush();
        paramInt2 -= k;
        paramInt1 += k;
      } while (paramInt2 > this.buf.length);
      j = paramInt2;
      continue;
      j = paramInt2;
      paramInt2 = i;
    }
  }
  
  public void write(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      write("true");
      return;
    }
    write("false");
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    int i = paramInt2 + this.count;
    int j;
    if (i > this.buf.length) {
      if (this.writer == null)
      {
        expandCapacity(i);
        j = paramInt2;
        paramInt2 = i;
      }
    }
    for (;;)
    {
      System.arraycopy(paramArrayOfChar, paramInt1, this.buf, this.count, j);
      this.count = paramInt2;
      return;
      do
      {
        int k = this.buf.length - this.count;
        System.arraycopy(paramArrayOfChar, paramInt1, this.buf, this.count, k);
        this.count = this.buf.length;
        flush();
        paramInt2 -= k;
        paramInt1 += k;
      } while (paramInt2 > this.buf.length);
      j = paramInt2;
      continue;
      j = paramInt2;
      paramInt2 = i;
    }
  }
  
  public void writeByteArray(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    boolean bool = isEnabled(SerializerFeature.UseSingleQuotes);
    char c1;
    if (bool)
    {
      c1 = '\'';
      if (i != 0) {
        break label53;
      }
      if (!bool) {
        break label45;
      }
    }
    label45:
    for (String str = "''";; str = "\"\"")
    {
      write(str);
      return;
      c1 = '"';
      break;
    }
    label53:
    char[] arrayOfChar1 = Base64.CA;
    int j = 3 * (i / 3);
    int k = 1 + (i - 1) / 3 << 2;
    int m = this.count;
    int n = 2 + (k + this.count);
    if (n > this.buf.length)
    {
      if (this.writer != null)
      {
        write(c1);
        int i17 = 0;
        while (i17 < j)
        {
          int i22 = i17 + 1;
          int i23 = (0xFF & paramArrayOfByte[i17]) << 16;
          int i24 = i22 + 1;
          int i25 = i23 | (0xFF & paramArrayOfByte[i22]) << 8;
          i17 = i24 + 1;
          int i26 = i25 | 0xFF & paramArrayOfByte[i24];
          write(arrayOfChar1[(0x3F & i26 >>> 18)]);
          write(arrayOfChar1[(0x3F & i26 >>> 12)]);
          write(arrayOfChar1[(0x3F & i26 >>> 6)]);
          write(arrayOfChar1[(i26 & 0x3F)]);
        }
        int i18 = i - j;
        int i21;
        if (i18 > 0)
        {
          int i19 = (0xFF & paramArrayOfByte[j]) << 10;
          int i20 = 0;
          if (i18 == 2) {
            i20 = (0xFF & paramArrayOfByte[(i - 1)]) << 2;
          }
          i21 = i20 | i19;
          write(arrayOfChar1[(i21 >> 12)]);
          write(arrayOfChar1[(0x3F & i21 >>> 6)]);
          if (i18 != 2) {
            break label361;
          }
        }
        label361:
        for (char c2 = arrayOfChar1[(i21 & 0x3F)];; c2 = '=')
        {
          write(c2);
          write('=');
          write(c1);
          return;
        }
      }
      expandCapacity(n);
    }
    this.count = n;
    char[] arrayOfChar2 = this.buf;
    int i1 = m + 1;
    arrayOfChar2[m] = c1;
    int i2 = 0;
    while (i2 < j)
    {
      int i9 = i2 + 1;
      int i10 = (0xFF & paramArrayOfByte[i2]) << 16;
      int i11 = i9 + 1;
      int i12 = i10 | (0xFF & paramArrayOfByte[i9]) << 8;
      i2 = i11 + 1;
      int i13 = i12 | 0xFF & paramArrayOfByte[i11];
      char[] arrayOfChar4 = this.buf;
      int i14 = i1 + 1;
      arrayOfChar4[i1] = arrayOfChar1[(0x3F & i13 >>> 18)];
      char[] arrayOfChar5 = this.buf;
      int i15 = i14 + 1;
      arrayOfChar5[i14] = arrayOfChar1[(0x3F & i13 >>> 12)];
      char[] arrayOfChar6 = this.buf;
      int i16 = i15 + 1;
      arrayOfChar6[i15] = arrayOfChar1[(0x3F & i13 >>> 6)];
      char[] arrayOfChar7 = this.buf;
      i1 = i16 + 1;
      arrayOfChar7[i16] = arrayOfChar1[(i13 & 0x3F)];
    }
    int i3 = i - j;
    int i6;
    char[] arrayOfChar3;
    int i7;
    if (i3 > 0)
    {
      int i4 = (0xFF & paramArrayOfByte[j]) << 10;
      int i5 = 0;
      if (i3 == 2) {
        i5 = (0xFF & paramArrayOfByte[(i - 1)]) << 2;
      }
      i6 = i5 | i4;
      this.buf[(n - 5)] = arrayOfChar1[(i6 >> 12)];
      this.buf[(n - 4)] = arrayOfChar1[(0x3F & i6 >>> 6)];
      arrayOfChar3 = this.buf;
      i7 = n - 3;
      if (i3 != 2) {
        break label729;
      }
    }
    label729:
    for (int i8 = arrayOfChar1[(i6 & 0x3F)];; i8 = 61)
    {
      arrayOfChar3[i7] = i8;
      this.buf[(n - 2)] = '=';
      this.buf[(n - 1)] = c1;
      return;
    }
  }
  
  public void writeFieldName(String paramString)
  {
    writeFieldName(paramString, false);
  }
  
  public void writeFieldName(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      write("null:");
      return;
    }
    if (isEnabled(SerializerFeature.UseSingleQuotes))
    {
      if (isEnabled(SerializerFeature.QuoteFieldNames))
      {
        writeStringWithSingleQuote(paramString);
        write(':');
        return;
      }
      writeKeyWithSingleQuoteIfHasSpecial(paramString);
      return;
    }
    if (isEnabled(SerializerFeature.QuoteFieldNames))
    {
      writeStringWithDoubleQuote(paramString, ':', paramBoolean);
      return;
    }
    writeKeyWithDoubleQuoteIfHasSpecial(paramString);
  }
  
  public void writeFieldValue(char paramChar, String paramString, long paramLong)
  {
    if ((paramLong == -9223372036854775808L) || (!isEnabled(SerializerFeature.QuoteFieldNames)))
    {
      writeFieldValue1(paramChar, paramString, paramLong);
      return;
    }
    int i;
    if (isEnabled(SerializerFeature.UseSingleQuotes))
    {
      i = 39;
      if (paramLong >= 0L) {
        break label115;
      }
    }
    int k;
    int m;
    label115:
    for (int j = 1 + IOUtils.stringSize(-paramLong);; j = IOUtils.stringSize(paramLong))
    {
      k = paramString.length();
      m = j + (4 + (k + this.count));
      if (m <= this.buf.length) {
        break label130;
      }
      if (this.writer == null) {
        break label124;
      }
      write(paramChar);
      writeFieldName(paramString);
      writeLong(paramLong);
      return;
      i = 34;
      break;
    }
    label124:
    expandCapacity(m);
    label130:
    int n = this.count;
    this.count = m;
    this.buf[n] = paramChar;
    int i1 = 1 + (n + k);
    this.buf[(n + 1)] = i;
    paramString.getChars(0, k, this.buf, n + 2);
    this.buf[(i1 + 1)] = i;
    this.buf[(i1 + 2)] = ':';
    IOUtils.getChars(paramLong, this.count, this.buf);
  }
  
  public void writeFieldValue(char paramChar, String paramString1, String paramString2)
  {
    if (isEnabled(SerializerFeature.QuoteFieldNames))
    {
      if (isEnabled(SerializerFeature.UseSingleQuotes))
      {
        write(paramChar);
        writeFieldName(paramString1);
        if (paramString2 == null)
        {
          writeNull();
          return;
        }
        writeString(paramString2);
        return;
      }
      if (isEnabled(SerializerFeature.BrowserCompatible))
      {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, '\000');
        return;
      }
      writeFieldValueStringWithDoubleQuote(paramChar, paramString1, paramString2, true);
      return;
    }
    write(paramChar);
    writeFieldName(paramString1);
    if (paramString2 == null)
    {
      writeNull();
      return;
    }
    writeString(paramString2);
  }
  
  public void writeFieldValue1(char paramChar, String paramString, long paramLong)
  {
    write(paramChar);
    writeFieldName(paramString);
    writeLong(paramLong);
  }
  
  public void writeInt(int paramInt)
  {
    if (paramInt == -2147483648)
    {
      write("-2147483648");
      return;
    }
    if (paramInt < 0) {}
    for (int i = 1 + IOUtils.stringSize(-paramInt);; i = IOUtils.stringSize(paramInt))
    {
      int j = i + this.count;
      if (j > this.buf.length)
      {
        if (this.writer != null) {
          break;
        }
        expandCapacity(j);
      }
      IOUtils.getChars(paramInt, j, this.buf);
      this.count = j;
      return;
    }
    char[] arrayOfChar = new char[i];
    IOUtils.getChars(paramInt, i, arrayOfChar);
    write(arrayOfChar, 0, arrayOfChar.length);
  }
  
  public void writeLong(long paramLong)
  {
    if (paramLong == -9223372036854775808L)
    {
      write("-9223372036854775808");
      return;
    }
    if (paramLong < 0L) {}
    for (int i = 1 + IOUtils.stringSize(-paramLong);; i = IOUtils.stringSize(paramLong))
    {
      int j = i + this.count;
      if (j > this.buf.length)
      {
        if (this.writer != null) {
          break;
        }
        expandCapacity(j);
      }
      IOUtils.getChars(paramLong, j, this.buf);
      this.count = j;
      return;
    }
    char[] arrayOfChar = new char[i];
    IOUtils.getChars(paramLong, i, arrayOfChar);
    write(arrayOfChar, 0, arrayOfChar.length);
  }
  
  public void writeLongAndChar(long paramLong, char paramChar)
  {
    if (paramLong == -9223372036854775808L)
    {
      write("-9223372036854775808");
      write(paramChar);
      return;
    }
    if (paramLong < 0L) {}
    int j;
    int k;
    for (int i = 1 + IOUtils.stringSize(-paramLong);; i = IOUtils.stringSize(paramLong))
    {
      j = i + this.count;
      k = j + 1;
      if (k <= this.buf.length) {
        break label94;
      }
      if (this.writer == null) {
        break;
      }
      writeLong(paramLong);
      write(paramChar);
      return;
    }
    expandCapacity(k);
    label94:
    IOUtils.getChars(paramLong, j, this.buf);
    this.buf[j] = paramChar;
    this.count = k;
  }
  
  public void writeNull()
  {
    write("null");
  }
  
  public void writeString(String paramString)
  {
    if (isEnabled(SerializerFeature.UseSingleQuotes))
    {
      writeStringWithSingleQuote(paramString);
      return;
    }
    writeStringWithDoubleQuote(paramString, '\000');
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString)
  {
    writeTo(paramOutputStream, Charset.forName(paramString));
  }
  
  public void writeTo(OutputStream paramOutputStream, Charset paramCharset)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    paramOutputStream.write(new String(this.buf, 0, this.count).getBytes(paramCharset.name()));
  }
  
  public void writeTo(Writer paramWriter)
  {
    if (this.writer != null) {
      throw new UnsupportedOperationException("writer not null");
    }
    paramWriter.write(this.buf, 0, this.count);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SerializeWriter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */