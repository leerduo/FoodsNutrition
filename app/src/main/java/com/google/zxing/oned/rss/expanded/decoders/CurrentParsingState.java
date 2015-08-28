package com.google.zxing.oned.rss.expanded.decoders;

final class CurrentParsingState
{
  private int a = 0;
  private CurrentParsingState.State b = CurrentParsingState.State.a;
  
  int a()
  {
    return this.a;
  }
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  void b(int paramInt)
  {
    this.a = (paramInt + this.a);
  }
  
  boolean b()
  {
    return this.b == CurrentParsingState.State.b;
  }
  
  boolean c()
  {
    return this.b == CurrentParsingState.State.c;
  }
  
  void d()
  {
    this.b = CurrentParsingState.State.a;
  }
  
  void e()
  {
    this.b = CurrentParsingState.State.b;
  }
  
  void f()
  {
    this.b = CurrentParsingState.State.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */