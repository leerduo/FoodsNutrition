package com.activeandroid.query;

import android.text.TextUtils;
import com.activeandroid.Cache;
import com.activeandroid.Model;

public final class Join
  implements Sqlable
{
  private Class<? extends Model> a;
  private String b;
  private Join.JoinType c;
  private String d;
  private String[] e;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.c != null) {
      localStringBuilder.append(this.c.toString()).append(" ");
    }
    localStringBuilder.append("JOIN ");
    localStringBuilder.append(Cache.c(this.a));
    localStringBuilder.append(" ");
    if (this.b != null)
    {
      localStringBuilder.append("AS ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" ");
    }
    if (this.d != null)
    {
      localStringBuilder.append("ON ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" ");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.e != null)
      {
        localStringBuilder.append("USING (");
        localStringBuilder.append(TextUtils.join(", ", this.e));
        localStringBuilder.append(") ");
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.query.Join
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */