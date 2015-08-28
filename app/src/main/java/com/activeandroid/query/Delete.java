package com.activeandroid.query;

import com.activeandroid.Model;

public final class Delete
  implements Sqlable
{
  public From a(Class<? extends Model> paramClass)
  {
    return new From(paramClass, this);
  }
  
  public String a()
  {
    return "DELETE ";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.query.Delete
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */