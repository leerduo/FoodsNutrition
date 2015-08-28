package de.keyboardsurfer.android.widget.crouton;

public class Configuration
{
  public static final Configuration a = new Configuration.Builder().a(3000).a();
  final int b;
  final int c;
  final int d;
  
  private Configuration(Configuration.Builder paramBuilder)
  {
    this.b = Configuration.Builder.a(paramBuilder);
    this.c = Configuration.Builder.b(paramBuilder);
    this.d = Configuration.Builder.c(paramBuilder);
  }
  
  public String toString()
  {
    return "Configuration{durationInMilliseconds=" + this.b + ", inAnimationResId=" + this.c + ", outAnimationResId=" + this.d + '}';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     de.keyboardsurfer.android.widget.crouton.Configuration
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */