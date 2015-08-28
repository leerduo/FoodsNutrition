package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$AutoCompleteTextViewReflector
{
  private Method a;
  private Method b;
  private Method c;
  private Method d;
  
  /* Error */
  SearchView$AutoCompleteTextViewReflector()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 15	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 17
    //   7: ldc 19
    //   9: iconst_0
    //   10: anewarray 21	java/lang/Class
    //   13: invokevirtual 25	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   16: putfield 27	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:a	Ljava/lang/reflect/Method;
    //   19: aload_0
    //   20: getfield 27	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:a	Ljava/lang/reflect/Method;
    //   23: iconst_1
    //   24: invokevirtual 33	java/lang/reflect/Method:setAccessible	(Z)V
    //   27: aload_0
    //   28: ldc 17
    //   30: ldc 35
    //   32: iconst_0
    //   33: anewarray 21	java/lang/Class
    //   36: invokevirtual 25	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: putfield 37	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:b	Ljava/lang/reflect/Method;
    //   42: aload_0
    //   43: getfield 37	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:b	Ljava/lang/reflect/Method;
    //   46: iconst_1
    //   47: invokevirtual 33	java/lang/reflect/Method:setAccessible	(Z)V
    //   50: iconst_1
    //   51: anewarray 21	java/lang/Class
    //   54: astore 6
    //   56: aload 6
    //   58: iconst_0
    //   59: getstatic 43	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   62: aastore
    //   63: aload_0
    //   64: ldc 17
    //   66: ldc 45
    //   68: aload 6
    //   70: invokevirtual 48	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   73: putfield 50	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:c	Ljava/lang/reflect/Method;
    //   76: aload_0
    //   77: getfield 50	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:c	Ljava/lang/reflect/Method;
    //   80: iconst_1
    //   81: invokevirtual 33	java/lang/reflect/Method:setAccessible	(Z)V
    //   84: iconst_2
    //   85: anewarray 21	java/lang/Class
    //   88: astore 5
    //   90: aload 5
    //   92: iconst_0
    //   93: getstatic 53	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   96: aastore
    //   97: aload 5
    //   99: iconst_1
    //   100: ldc 55
    //   102: aastore
    //   103: aload_0
    //   104: ldc 57
    //   106: ldc 59
    //   108: aload 5
    //   110: invokevirtual 48	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   113: putfield 61	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:d	Ljava/lang/reflect/Method;
    //   116: aload_0
    //   117: getfield 61	android/support/v7/widget/SearchView$AutoCompleteTextViewReflector:d	Ljava/lang/reflect/Method;
    //   120: iconst_1
    //   121: invokevirtual 33	java/lang/reflect/Method:setAccessible	(Z)V
    //   124: return
    //   125: astore 4
    //   127: return
    //   128: astore_3
    //   129: goto -45 -> 84
    //   132: astore_2
    //   133: goto -83 -> 50
    //   136: astore_1
    //   137: goto -110 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	AutoCompleteTextViewReflector
    //   136	1	1	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   132	1	2	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   128	1	3	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   125	1	4	localNoSuchMethodException4	java.lang.NoSuchMethodException
    //   88	21	5	arrayOfClass1	java.lang.Class[]
    //   54	15	6	arrayOfClass2	java.lang.Class[]
    // Exception table:
    //   from	to	target	type
    //   84	124	125	java/lang/NoSuchMethodException
    //   50	84	128	java/lang/NoSuchMethodException
    //   27	50	132	java/lang/NoSuchMethodException
    //   4	27	136	java/lang/NoSuchMethodException
  }
  
  void a(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.a != null) {}
    try
    {
      this.a.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean)
  {
    if (this.c != null) {}
    try
    {
      Method localMethod = this.c;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(paramAutoCompleteTextView, arrayOfObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  void b(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.b != null) {}
    try
    {
      this.b.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView.AutoCompleteTextViewReflector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */