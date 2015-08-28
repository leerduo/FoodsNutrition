package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityChooserModel
  extends DataSetObservable
{
  private static final String a = ActivityChooserModel.class.getSimpleName();
  private static final Object b = new Object();
  private static final Map<String, ActivityChooserModel> c = new HashMap();
  private final Object d = new Object();
  private final List<ActivityChooserModel.ActivityResolveInfo> e = new ArrayList();
  private final List<ActivityChooserModel.HistoricalRecord> f = new ArrayList();
  private final Context g;
  private final String h;
  private Intent i;
  private ActivityChooserModel.ActivitySorter j = new ActivityChooserModel.DefaultSorter(this, null);
  private int k = 50;
  private boolean l = true;
  private boolean m = false;
  private boolean n = true;
  private boolean o = false;
  private ActivityChooserModel.OnChooseActivityListener p;
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.g = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      this.h = (paramString + ".xml");
      return;
    }
    this.h = paramString;
  }
  
  public static ActivityChooserModel a(Context paramContext, String paramString)
  {
    synchronized (b)
    {
      ActivityChooserModel localActivityChooserModel = (ActivityChooserModel)c.get(paramString);
      if (localActivityChooserModel == null)
      {
        localActivityChooserModel = new ActivityChooserModel(paramContext, paramString);
        c.put(paramString, localActivityChooserModel);
      }
      return localActivityChooserModel;
    }
  }
  
  private boolean a(ActivityChooserModel.HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.f.add(paramHistoricalRecord);
    if (bool)
    {
      this.n = true;
      j();
      e();
      g();
      notifyChanged();
    }
    return bool;
  }
  
  private void e()
  {
    if (!this.m) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.n) {}
    do
    {
      return;
      this.n = false;
    } while (TextUtils.isEmpty(this.h));
    ActivityChooserModel.PersistHistoryAsyncTask localPersistHistoryAsyncTask = new ActivityChooserModel.PersistHistoryAsyncTask(this, null);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.f;
    arrayOfObject[1] = this.h;
    AsyncTaskCompat.executeParallel(localPersistHistoryAsyncTask, arrayOfObject);
  }
  
  private void f()
  {
    boolean bool = h() | i();
    j();
    if (bool)
    {
      g();
      notifyChanged();
    }
  }
  
  private boolean g()
  {
    if ((this.j != null) && (this.i != null) && (!this.e.isEmpty()) && (!this.f.isEmpty()))
    {
      this.j.a(this.i, this.e, Collections.unmodifiableList(this.f));
      return true;
    }
    return false;
  }
  
  private boolean h()
  {
    boolean bool1 = this.o;
    boolean bool2 = false;
    if (bool1)
    {
      Intent localIntent = this.i;
      bool2 = false;
      if (localIntent != null)
      {
        this.o = false;
        this.e.clear();
        List localList = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int i1 = localList.size();
        for (int i2 = 0; i2 < i1; i2++)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i2);
          this.e.add(new ActivityChooserModel.ActivityResolveInfo(this, localResolveInfo));
        }
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean i()
  {
    if ((this.l) && (this.n) && (!TextUtils.isEmpty(this.h)))
    {
      this.l = false;
      this.m = true;
      k();
      return true;
    }
    return false;
  }
  
  private void j()
  {
    int i1 = this.f.size() - this.k;
    if (i1 <= 0) {}
    for (;;)
    {
      return;
      this.n = true;
      for (int i2 = 0; i2 < i1; i2++) {
        ((ActivityChooserModel.HistoricalRecord)this.f.remove(0));
      }
    }
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	android/support/v7/internal/widget/ActivityChooserModel:g	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 117	android/support/v7/internal/widget/ActivityChooserModel:h	Ljava/lang/String;
    //   8: invokevirtual 229	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 235	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore 11
    //   17: aload 11
    //   19: aload_2
    //   20: aconst_null
    //   21: invokeinterface 241 3 0
    //   26: iconst_0
    //   27: istore 12
    //   29: iload 12
    //   31: iconst_1
    //   32: if_icmpeq +21 -> 53
    //   35: iload 12
    //   37: iconst_2
    //   38: if_icmpeq +15 -> 53
    //   41: aload 11
    //   43: invokeinterface 244 1 0
    //   48: istore 12
    //   50: goto -21 -> 29
    //   53: ldc 246
    //   55: aload 11
    //   57: invokeinterface 249 1 0
    //   62: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifne +56 -> 121
    //   68: new 223	org/xmlpull/v1/XmlPullParserException
    //   71: dup
    //   72: ldc 254
    //   74: invokespecial 255	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: astore 8
    //   80: getstatic 43	android/support/v7/internal/widget/ActivityChooserModel:a	Ljava/lang/String;
    //   83: new 107	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 257
    //   93: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 117	android/support/v7/internal/widget/ActivityChooserModel:h	Ljava/lang/String;
    //   100: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload 8
    //   108: invokestatic 262	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   111: pop
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 267	java/io/FileInputStream:close	()V
    //   120: return
    //   121: aload_0
    //   122: getfield 66	android/support/v7/internal/widget/ActivityChooserModel:f	Ljava/util/List;
    //   125: astore 13
    //   127: aload 13
    //   129: invokeinterface 188 1 0
    //   134: aload 11
    //   136: invokeinterface 244 1 0
    //   141: istore 14
    //   143: iload 14
    //   145: iconst_1
    //   146: if_icmpne +15 -> 161
    //   149: aload_2
    //   150: ifnull -30 -> 120
    //   153: aload_2
    //   154: invokevirtual 267	java/io/FileInputStream:close	()V
    //   157: return
    //   158: astore 16
    //   160: return
    //   161: iload 14
    //   163: iconst_3
    //   164: if_icmpeq -30 -> 134
    //   167: iload 14
    //   169: iconst_4
    //   170: if_icmpeq -36 -> 134
    //   173: ldc_w 269
    //   176: aload 11
    //   178: invokeinterface 249 1 0
    //   183: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifne +60 -> 246
    //   189: new 223	org/xmlpull/v1/XmlPullParserException
    //   192: dup
    //   193: ldc_w 271
    //   196: invokespecial 255	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   199: athrow
    //   200: astore 5
    //   202: getstatic 43	android/support/v7/internal/widget/ActivityChooserModel:a	Ljava/lang/String;
    //   205: new 107	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 257
    //   215: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 117	android/support/v7/internal/widget/ActivityChooserModel:h	Ljava/lang/String;
    //   222: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: aload 5
    //   230: invokestatic 262	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: aload_2
    //   235: ifnull -115 -> 120
    //   238: aload_2
    //   239: invokevirtual 267	java/io/FileInputStream:close	()V
    //   242: return
    //   243: astore 7
    //   245: return
    //   246: aload 13
    //   248: new 219	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord
    //   251: dup
    //   252: aload 11
    //   254: aconst_null
    //   255: ldc_w 273
    //   258: invokeinterface 277 3 0
    //   263: aload 11
    //   265: aconst_null
    //   266: ldc_w 279
    //   269: invokeinterface 277 3 0
    //   274: invokestatic 285	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   277: aload 11
    //   279: aconst_null
    //   280: ldc_w 287
    //   283: invokeinterface 277 3 0
    //   288: invokestatic 293	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   291: invokespecial 296	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   294: invokeinterface 138 2 0
    //   299: pop
    //   300: goto -166 -> 134
    //   303: astore_3
    //   304: aload_2
    //   305: ifnull +7 -> 312
    //   308: aload_2
    //   309: invokevirtual 267	java/io/FileInputStream:close	()V
    //   312: aload_3
    //   313: athrow
    //   314: astore 10
    //   316: return
    //   317: astore 4
    //   319: goto -7 -> 312
    //   322: astore_1
    //   323: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	ActivityChooserModel
    //   322	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   11	298	2	localFileInputStream	java.io.FileInputStream
    //   303	10	3	localObject	Object
    //   317	1	4	localIOException1	java.io.IOException
    //   200	29	5	localIOException2	java.io.IOException
    //   243	1	7	localIOException3	java.io.IOException
    //   78	29	8	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   314	1	10	localIOException4	java.io.IOException
    //   15	263	11	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   27	22	12	i1	int
    //   125	122	13	localList	List
    //   141	30	14	i2	int
    //   158	1	16	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   12	26	78	org/xmlpull/v1/XmlPullParserException
    //   41	50	78	org/xmlpull/v1/XmlPullParserException
    //   53	78	78	org/xmlpull/v1/XmlPullParserException
    //   121	134	78	org/xmlpull/v1/XmlPullParserException
    //   134	143	78	org/xmlpull/v1/XmlPullParserException
    //   173	200	78	org/xmlpull/v1/XmlPullParserException
    //   246	300	78	org/xmlpull/v1/XmlPullParserException
    //   153	157	158	java/io/IOException
    //   12	26	200	java/io/IOException
    //   41	50	200	java/io/IOException
    //   53	78	200	java/io/IOException
    //   121	134	200	java/io/IOException
    //   134	143	200	java/io/IOException
    //   173	200	200	java/io/IOException
    //   246	300	200	java/io/IOException
    //   238	242	243	java/io/IOException
    //   12	26	303	finally
    //   41	50	303	finally
    //   53	78	303	finally
    //   80	112	303	finally
    //   121	134	303	finally
    //   134	143	303	finally
    //   173	200	303	finally
    //   202	234	303	finally
    //   246	300	303	finally
    //   116	120	314	java/io/IOException
    //   308	312	317	java/io/IOException
    //   0	12	322	java/io/FileNotFoundException
  }
  
  public int a()
  {
    synchronized (this.d)
    {
      f();
      int i1 = this.e.size();
      return i1;
    }
  }
  
  public int a(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i2;
      synchronized (this.d)
      {
        f();
        List localList = this.e;
        int i1 = localList.size();
        i2 = 0;
        if (i2 < i1)
        {
          if (((ActivityChooserModel.ActivityResolveInfo)localList.get(i2)).a == paramResolveInfo) {
            return i2;
          }
        }
        else {
          return -1;
        }
      }
      i2++;
    }
  }
  
  public ResolveInfo a(int paramInt)
  {
    synchronized (this.d)
    {
      f();
      ResolveInfo localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.e.get(paramInt)).a;
      return localResolveInfo;
    }
  }
  
  public Intent b(int paramInt)
  {
    synchronized (this.d)
    {
      if (this.i == null) {
        return null;
      }
      f();
      ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)this.e.get(paramInt);
      ComponentName localComponentName = new ComponentName(localActivityResolveInfo.a.activityInfo.packageName, localActivityResolveInfo.a.activityInfo.name);
      Intent localIntent1 = new Intent(this.i);
      localIntent1.setComponent(localComponentName);
      if (this.p != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.p.a(this, localIntent2)) {
          return null;
        }
      }
      a(new ActivityChooserModel.HistoricalRecord(localComponentName, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }
  
  public ResolveInfo b()
  {
    synchronized (this.d)
    {
      f();
      if (!this.e.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.e.get(0)).a;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int c()
  {
    synchronized (this.d)
    {
      f();
      int i1 = this.f.size();
      return i1;
    }
  }
  
  public void c(int paramInt)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        f();
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)this.e.get(paramInt);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)this.e.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f1 = 5.0F + (localActivityResolveInfo2.b - localActivityResolveInfo1.b);
          a(new ActivityChooserModel.HistoricalRecord(new ComponentName(localActivityResolveInfo1.a.activityInfo.packageName, localActivityResolveInfo1.a.activityInfo.name), System.currentTimeMillis(), f1));
          return;
        }
      }
      float f1 = 1.0F;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */