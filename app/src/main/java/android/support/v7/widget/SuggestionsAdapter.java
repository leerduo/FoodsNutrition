package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter
  extends ResourceCursorAdapter
  implements View.OnClickListener
{
  private final SearchManager a = (SearchManager)this.mContext.getSystemService("search");
  private final SearchView b;
  private final SearchableInfo c;
  private final Context d;
  private final WeakHashMap<String, Drawable.ConstantState> e;
  private final int f;
  private boolean g = false;
  private int h = 1;
  private ColorStateList i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.b = paramSearchView;
    this.c = paramSearchableInfo;
    this.f = paramSearchView.getSuggestionCommitIconResId();
    this.d = paramContext;
    this.e = paramWeakHashMap;
  }
  
  private Drawable a(ComponentName paramComponentName)
  {
    String str = paramComponentName.flattenToShortString();
    if (this.e.containsKey(str))
    {
      Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.e.get(str);
      if (localConstantState == null) {
        return null;
      }
      return localConstantState.newDrawable(this.d.getResources());
    }
    Drawable localDrawable = b(paramComponentName);
    Object localObject = null;
    if (localDrawable == null) {}
    for (;;)
    {
      this.e.put(str, localObject);
      return localDrawable;
      localObject = localDrawable.getConstantState();
    }
  }
  
  private Drawable a(String paramString)
  {
    Drawable localDrawable1;
    if ((paramString == null) || (paramString.length() == 0) || ("0".equals(paramString))) {
      localDrawable1 = null;
    }
    for (;;)
    {
      return localDrawable1;
      try
      {
        int i1 = Integer.parseInt(paramString);
        String str = "android.resource://" + this.d.getPackageName() + "/" + i1;
        localDrawable1 = b(str);
        if (localDrawable1 == null)
        {
          Drawable localDrawable3 = ContextCompat.getDrawable(this.d, i1);
          a(str, localDrawable3);
          return localDrawable3;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localDrawable1 = b(paramString);
        if (localDrawable1 == null)
        {
          Drawable localDrawable2 = b(Uri.parse(paramString));
          a(paramString, localDrawable2);
          return localDrawable2;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Log.w("SuggestionsAdapter", "Icon resource not found: " + paramString);
      }
    }
    return null;
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    if (this.i == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, localTypedValue, true);
      this.i = this.mContext.getResources().getColorStateList(localTypedValue.resourceId);
    }
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    localSpannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.i, null), 0, paramCharSequence.length(), 33);
    return localSpannableString;
  }
  
  private static String a(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      String str = paramCursor.getString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", localException);
    }
    return null;
  }
  
  public static String a(Cursor paramCursor, String paramString)
  {
    return a(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private void a(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (Bundle localBundle = paramCursor.getExtras();; localBundle = null)
    {
      if ((localBundle != null) && (localBundle.getBoolean("in_progress"))) {}
      return;
    }
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.e.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private Drawable b(ComponentName paramComponentName)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    ActivityInfo localActivityInfo;
    int i1;
    try
    {
      localActivityInfo = localPackageManager.getActivityInfo(paramComponentName, 128);
      i1 = localActivityInfo.getIconResource();
      if (i1 == 0) {
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.w("SuggestionsAdapter", localNameNotFoundException.toString());
      return null;
    }
    Drawable localDrawable = localPackageManager.getDrawable(paramComponentName.getPackageName(), i1, localActivityInfo.applicationInfo);
    if (localDrawable == null)
    {
      Log.w("SuggestionsAdapter", "Invalid icon resource " + i1 + " for " + paramComponentName.flattenToShortString());
      return null;
    }
    return localDrawable;
  }
  
  private Drawable b(Cursor paramCursor)
  {
    Drawable localDrawable;
    if (this.m == -1) {
      localDrawable = null;
    }
    do
    {
      return localDrawable;
      localDrawable = a(paramCursor.getString(this.m));
    } while (localDrawable != null);
    return d(paramCursor);
  }
  
  private Drawable b(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (bool) {
        try
        {
          Drawable localDrawable2 = a(paramUri);
          return localDrawable2;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          throw new FileNotFoundException("Resource does not exist: " + paramUri);
        }
      }
      localInputStream = this.d.getContentResolver().openInputStream(paramUri);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.w("SuggestionsAdapter", "Icon not found: " + paramUri + ", " + localFileNotFoundException.getMessage());
      return null;
    }
    if (localInputStream == null) {
      throw new FileNotFoundException("Failed to open " + paramUri);
    }
    try
    {
      Drawable localDrawable1 = Drawable.createFromStream(localInputStream, null);
      try
      {
        localInputStream.close();
        return localDrawable1;
      }
      catch (IOException localIOException2)
      {
        Log.e("SuggestionsAdapter", "Error closing icon stream for " + paramUri, localIOException2);
        return localDrawable1;
      }
      try
      {
        localInputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.e("SuggestionsAdapter", "Error closing icon stream for " + paramUri, localIOException1);
        }
      }
    }
    finally {}
  }
  
  private Drawable b(String paramString)
  {
    Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.e.get(paramString);
    if (localConstantState == null) {
      return null;
    }
    return localConstantState.newDrawable();
  }
  
  private Drawable c(Cursor paramCursor)
  {
    if (this.n == -1) {
      return null;
    }
    return a(paramCursor.getString(this.n));
  }
  
  private Drawable d(Cursor paramCursor)
  {
    Drawable localDrawable = a(this.c.getSearchActivity());
    if (localDrawable != null) {
      return localDrawable;
    }
    return this.mContext.getPackageManager().getDefaultActivityIcon();
  }
  
  Cursor a(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    if (paramSearchableInfo == null) {}
    String str1;
    do
    {
      return null;
      str1 = paramSearchableInfo.getSuggestAuthority();
    } while (str1 == null);
    Uri.Builder localBuilder = new Uri.Builder().scheme("content").authority(str1).query("").fragment("");
    String str2 = paramSearchableInfo.getSuggestPath();
    if (str2 != null) {
      localBuilder.appendEncodedPath(str2);
    }
    localBuilder.appendPath("search_suggest_query");
    String str3 = paramSearchableInfo.getSuggestSelection();
    if (str3 != null) {}
    for (String[] arrayOfString = { paramString };; arrayOfString = null)
    {
      if (paramInt > 0) {
        localBuilder.appendQueryParameter("limit", String.valueOf(paramInt));
      }
      Uri localUri = localBuilder.build();
      return this.mContext.getContentResolver().query(localUri, null, str3, arrayOfString, null);
      localBuilder.appendPath(paramString);
    }
  }
  
  Drawable a(Uri paramUri)
  {
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str)) {
      throw new FileNotFoundException("No authority: " + paramUri);
    }
    Resources localResources;
    List localList;
    try
    {
      localResources = this.mContext.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList == null) {
        throw new FileNotFoundException("No path: " + paramUri);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new FileNotFoundException("No package found for authority: " + paramUri);
    }
    int i1 = localList.size();
    if (i1 == 1) {}
    int i2;
    for (;;)
    {
      try
      {
        int i3 = Integer.parseInt((String)localList.get(0));
        i2 = i3;
        if (i2 != 0) {
          break;
        }
        throw new FileNotFoundException("No resource found for: " + paramUri);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new FileNotFoundException("Single path segment is not a resource ID: " + paramUri);
      }
      if (i1 == 2) {
        i2 = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), str);
      } else {
        throw new FileNotFoundException("More than two path segments: " + paramUri);
      }
    }
    return localResources.getDrawable(i2);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    SuggestionsAdapter.ChildViewCache localChildViewCache = (SuggestionsAdapter.ChildViewCache)paramView.getTag();
    if (this.o != -1) {}
    for (int i1 = paramCursor.getInt(this.o);; i1 = 0)
    {
      if (localChildViewCache.a != null)
      {
        String str2 = a(paramCursor, this.j);
        a(localChildViewCache.a, str2);
      }
      Object localObject;
      if (localChildViewCache.b != null)
      {
        String str1 = a(paramCursor, this.l);
        if (str1 == null) {
          break label239;
        }
        localObject = a(str1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label252;
        }
        if (localChildViewCache.a != null)
        {
          localChildViewCache.a.setSingleLine(false);
          localChildViewCache.a.setMaxLines(2);
        }
      }
      for (;;)
      {
        a(localChildViewCache.b, (CharSequence)localObject);
        if (localChildViewCache.c != null) {
          a(localChildViewCache.c, b(paramCursor), 4);
        }
        if (localChildViewCache.d != null) {
          a(localChildViewCache.d, c(paramCursor), 8);
        }
        if ((this.h != 2) && ((this.h != 1) || ((i1 & 0x1) == 0))) {
          break label281;
        }
        localChildViewCache.e.setVisibility(0);
        localChildViewCache.e.setTag(localChildViewCache.a.getText());
        localChildViewCache.e.setOnClickListener(this);
        return;
        label239:
        localObject = a(paramCursor, this.k);
        break;
        label252:
        if (localChildViewCache.a != null)
        {
          localChildViewCache.a.setSingleLine(true);
          localChildViewCache.a.setMaxLines(1);
        }
      }
      label281:
      localChildViewCache.e.setVisibility(8);
      return;
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (this.g)
    {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    for (;;)
    {
      return;
      try
      {
        super.changeCursor(paramCursor);
        if (paramCursor != null)
        {
          this.j = paramCursor.getColumnIndex("suggest_text_1");
          this.k = paramCursor.getColumnIndex("suggest_text_2");
          this.l = paramCursor.getColumnIndex("suggest_text_2_url");
          this.m = paramCursor.getColumnIndex("suggest_icon_1");
          this.n = paramCursor.getColumnIndex("suggest_icon_2");
          this.o = paramCursor.getColumnIndex("suggest_flags");
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("SuggestionsAdapter", "error changing cursor and caching columns", localException);
      }
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    String str2;
    do
    {
      do
      {
        return null;
        String str1 = a(paramCursor, "suggest_intent_query");
        if (str1 != null) {
          return str1;
        }
        if (this.c.shouldRewriteQueryFromData())
        {
          String str3 = a(paramCursor, "suggest_intent_data");
          if (str3 != null) {
            return str3;
          }
        }
      } while (!this.c.shouldRewriteQueryFromText());
      str2 = a(paramCursor, "suggest_text_1");
    } while (str2 == null);
    return str2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      View localView2 = super.getView(paramInt, paramView, paramViewGroup);
      return localView2;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", localRuntimeException);
      View localView1 = newView(this.mContext, this.mCursor, paramViewGroup);
      if (localView1 != null) {
        ((SuggestionsAdapter.ChildViewCache)localView1.getTag()).a.setText(localRuntimeException.toString());
      }
      return localView1;
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    View localView = super.newView(paramContext, paramCursor, paramViewGroup);
    localView.setTag(new SuggestionsAdapter.ChildViewCache(localView));
    ((ImageView)localView.findViewById(R.id.edit_query)).setImageResource(this.f);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    a(getCursor());
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    a(getCursor());
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof CharSequence)) {
      this.b.a((CharSequence)localObject);
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (String str = ""; (this.b.getVisibility() != 0) || (this.b.getWindowVisibility() != 0); str = paramCharSequence.toString()) {
      return null;
    }
    try
    {
      Cursor localCursor = a(this.c, str, 50);
      if (localCursor != null)
      {
        localCursor.getCount();
        return localCursor;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", localRuntimeException);
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SuggestionsAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */