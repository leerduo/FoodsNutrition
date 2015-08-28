package org.apache.commons.codec;

import java.util.Comparator;

public class StringEncoderComparator
  implements Comparator
{
  private StringEncoder stringEncoder;
  
  public StringEncoderComparator() {}
  
  public StringEncoderComparator(StringEncoder paramStringEncoder)
  {
    this.stringEncoder = paramStringEncoder;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    try
    {
      int i = ((Comparable)this.stringEncoder.encode(paramObject1)).compareTo((Comparable)this.stringEncoder.encode(paramObject2));
      return i;
    }
    catch (EncoderException localEncoderException) {}
    return 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.StringEncoderComparator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */