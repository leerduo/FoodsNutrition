package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

public enum CharacterSetECI
{
  private static final Map<Integer, CharacterSetECI> B;
  private static final Map<String, CharacterSetECI> C;
  private final int[] D;
  private final String[] E;
  
  static
  {
    A = new CharacterSetECI("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    CharacterSetECI[] arrayOfCharacterSetECI1 = new CharacterSetECI[27];
    arrayOfCharacterSetECI1[0] = a;
    arrayOfCharacterSetECI1[1] = b;
    arrayOfCharacterSetECI1[2] = c;
    arrayOfCharacterSetECI1[3] = d;
    arrayOfCharacterSetECI1[4] = e;
    arrayOfCharacterSetECI1[5] = f;
    arrayOfCharacterSetECI1[6] = g;
    arrayOfCharacterSetECI1[7] = h;
    arrayOfCharacterSetECI1[8] = i;
    arrayOfCharacterSetECI1[9] = j;
    arrayOfCharacterSetECI1[10] = k;
    arrayOfCharacterSetECI1[11] = l;
    arrayOfCharacterSetECI1[12] = m;
    arrayOfCharacterSetECI1[13] = n;
    arrayOfCharacterSetECI1[14] = o;
    arrayOfCharacterSetECI1[15] = p;
    arrayOfCharacterSetECI1[16] = q;
    arrayOfCharacterSetECI1[17] = r;
    arrayOfCharacterSetECI1[18] = s;
    arrayOfCharacterSetECI1[19] = t;
    arrayOfCharacterSetECI1[20] = u;
    arrayOfCharacterSetECI1[21] = v;
    arrayOfCharacterSetECI1[22] = w;
    arrayOfCharacterSetECI1[23] = x;
    arrayOfCharacterSetECI1[24] = y;
    arrayOfCharacterSetECI1[25] = z;
    arrayOfCharacterSetECI1[26] = A;
    F = arrayOfCharacterSetECI1;
    B = new HashMap();
    C = new HashMap();
    for (CharacterSetECI localCharacterSetECI : values())
    {
      for (int i7 : localCharacterSetECI.D) {
        B.put(Integer.valueOf(i7), localCharacterSetECI);
      }
      C.put(localCharacterSetECI.name(), localCharacterSetECI);
      for (String str : localCharacterSetECI.E) {
        C.put(str, localCharacterSetECI);
      }
    }
  }
  
  private CharacterSetECI(int paramInt)
  {
    this(new int[] { paramInt }, new String[0]);
  }
  
  private CharacterSetECI(int paramInt, String... paramVarArgs)
  {
    this.D = new int[] { paramInt };
    this.E = paramVarArgs;
  }
  
  private CharacterSetECI(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.D = paramArrayOfInt;
    this.E = paramVarArgs;
  }
  
  public static CharacterSetECI a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 900)) {
      throw FormatException.a();
    }
    return (CharacterSetECI)B.get(Integer.valueOf(paramInt));
  }
  
  public static CharacterSetECI a(String paramString)
  {
    return (CharacterSetECI)C.get(paramString);
  }
  
  public int a()
  {
    return this.D[0];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.CharacterSetECI
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */