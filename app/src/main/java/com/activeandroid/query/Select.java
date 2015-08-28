package com.activeandroid.query;

import android.text.TextUtils;
import com.activeandroid.Model;

public final class Select
  implements Sqlable
{
  private String[] a;
  private boolean b = false;
  private boolean c = false;
  
  public From a(Class<? extends Model> paramClass)
  {
    return new From(paramClass, this);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT ");
    if (this.b)
    {
      localStringBuilder.append("DISTINCT ");
      if ((this.a == null) || (this.a.length <= 0)) {
        break label98;
      }
      localStringBuilder.append(TextUtils.join(", ", this.a) + " ");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (!this.c) {
        break;
      }
      localStringBuilder.append("ALL ");
      break;
      label98:
      localStringBuilder.append("* ");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.query.Select
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */