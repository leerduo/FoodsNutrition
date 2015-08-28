package com.alibaba.fastjson.parser;

public final class SymbolTable$Entry
{
  public final byte[] bytes;
  public final char[] characters;
  public final int hashCode;
  public Entry next;
  public final String symbol;
  
  public SymbolTable$Entry(String paramString, int paramInt1, int paramInt2, int paramInt3, Entry paramEntry)
  {
    this.symbol = SymbolTable.access$000(paramString, paramInt1, paramInt2).intern();
    this.characters = this.symbol.toCharArray();
    this.next = paramEntry;
    this.hashCode = paramInt3;
    this.bytes = null;
  }
  
  public SymbolTable$Entry(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, Entry paramEntry)
  {
    this.characters = new char[paramInt2];
    System.arraycopy(paramArrayOfChar, paramInt1, this.characters, 0, paramInt2);
    this.symbol = new String(this.characters).intern();
    this.next = paramEntry;
    this.hashCode = paramInt3;
    this.bytes = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.SymbolTable.Entry
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */