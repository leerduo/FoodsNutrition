package org.apache.commons.codec.language;

public class DoubleMetaphone$DoubleMetaphoneResult
{
  private StringBuffer alternate;
  private int maxLength;
  private StringBuffer primary;
  private final DoubleMetaphone this$0;
  
  public DoubleMetaphone$DoubleMetaphoneResult(DoubleMetaphone paramDoubleMetaphone, int paramInt)
  {
    this.this$0 = paramDoubleMetaphone;
    this.primary = new StringBuffer(this.this$0.getMaxCodeLen());
    this.alternate = new StringBuffer(this.this$0.getMaxCodeLen());
    this.maxLength = paramInt;
  }
  
  public void append(char paramChar)
  {
    appendPrimary(paramChar);
    appendAlternate(paramChar);
  }
  
  public void append(char paramChar1, char paramChar2)
  {
    appendPrimary(paramChar1);
    appendAlternate(paramChar2);
  }
  
  public void append(String paramString)
  {
    appendPrimary(paramString);
    appendAlternate(paramString);
  }
  
  public void append(String paramString1, String paramString2)
  {
    appendPrimary(paramString1);
    appendAlternate(paramString2);
  }
  
  public void appendAlternate(char paramChar)
  {
    if (this.alternate.length() < this.maxLength) {
      this.alternate.append(paramChar);
    }
  }
  
  public void appendAlternate(String paramString)
  {
    int i = this.maxLength - this.alternate.length();
    if (paramString.length() <= i)
    {
      this.alternate.append(paramString);
      return;
    }
    this.alternate.append(paramString.substring(0, i));
  }
  
  public void appendPrimary(char paramChar)
  {
    if (this.primary.length() < this.maxLength) {
      this.primary.append(paramChar);
    }
  }
  
  public void appendPrimary(String paramString)
  {
    int i = this.maxLength - this.primary.length();
    if (paramString.length() <= i)
    {
      this.primary.append(paramString);
      return;
    }
    this.primary.append(paramString.substring(0, i));
  }
  
  public String getAlternate()
  {
    return this.alternate.toString();
  }
  
  public String getPrimary()
  {
    return this.primary.toString();
  }
  
  public boolean isComplete()
  {
    return (this.primary.length() >= this.maxLength) && (this.alternate.length() >= this.maxLength);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */