package com.boohee.pictures.qiniu;

public class AuthException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  
  protected AuthException() {}
  
  public AuthException(String paramString)
  {
    super(paramString);
  }
  
  public AuthException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AuthException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.qiniu.AuthException
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */