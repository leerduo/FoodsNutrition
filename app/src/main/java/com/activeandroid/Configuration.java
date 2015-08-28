package com.activeandroid;

import android.content.Context;
import com.activeandroid.serializer.TypeSerializer;
import java.util.List;

public class Configuration
{
  private Context a;
  private String b;
  private int c;
  private String d;
  private List<Class<? extends Model>> e;
  private List<Class<? extends TypeSerializer>> f;
  private int g;
  
  private Configuration(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public List<Class<? extends Model>> e()
  {
    return this.e;
  }
  
  public List<Class<? extends TypeSerializer>> f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return (this.e != null) && (this.e.size() > 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.Configuration
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */