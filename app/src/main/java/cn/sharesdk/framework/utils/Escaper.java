package cn.sharesdk.framework.utils;

public abstract interface Escaper
{
  public abstract Appendable escape(Appendable paramAppendable);
  
  public abstract String escape(String paramString);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.Escaper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */