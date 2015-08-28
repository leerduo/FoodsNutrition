package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.bool;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder
  implements SupportMenu
{
  private static final int[] d = { 1, 4, 5, 3, 2, 0 };
  CharSequence a;
  Drawable b;
  View c;
  private final Context e;
  private final Resources f;
  private boolean g;
  private boolean h;
  private MenuBuilder.Callback i;
  private ArrayList<MenuItemImpl> j;
  private ArrayList<MenuItemImpl> k;
  private boolean l;
  private ArrayList<MenuItemImpl> m;
  private ArrayList<MenuItemImpl> n;
  private boolean o;
  private int p = 0;
  private ContextMenu.ContextMenuInfo q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private ArrayList<MenuItemImpl> v = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<MenuPresenter>> w = new CopyOnWriteArrayList();
  private MenuItemImpl x;
  
  public MenuBuilder(Context paramContext)
  {
    this.e = paramContext;
    this.f = paramContext.getResources();
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.l = true;
    this.m = new ArrayList();
    this.n = new ArrayList();
    this.o = true;
    d(true);
  }
  
  private static int a(ArrayList<MenuItemImpl> paramArrayList, int paramInt)
  {
    for (int i1 = -1 + paramArrayList.size(); i1 >= 0; i1--) {
      if (((MenuItemImpl)paramArrayList.get(i1)).b() <= paramInt) {
        return i1 + 1;
      }
    }
    return 0;
  }
  
  private MenuItemImpl a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    return new MenuItemImpl(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }
  
  private MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = d(paramInt3);
    MenuItemImpl localMenuItemImpl = a(paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.p);
    if (this.q != null) {
      localMenuItemImpl.a(this.q);
    }
    this.j.add(a(this.j, i1), localMenuItemImpl);
    b(true);
    return localMenuItemImpl;
  }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = d();
    if (paramView != null)
    {
      this.c = paramView;
      this.a = null;
      this.b = null;
      b(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.a = localResources.getText(paramInt1);
      label47:
      if (paramInt2 <= 0) {
        break label83;
      }
      this.b = ContextCompat.getDrawable(e(), paramInt2);
    }
    for (;;)
    {
      this.c = null;
      break;
      if (paramCharSequence == null) {
        break label47;
      }
      this.a = paramCharSequence;
      break label47;
      label83:
      if (paramDrawable != null) {
        this.b = paramDrawable;
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.j.size())) {}
    do
    {
      return;
      this.j.remove(paramInt);
    } while (!paramBoolean);
    b(true);
  }
  
  private boolean a(SubMenuBuilder paramSubMenuBuilder, MenuPresenter paramMenuPresenter)
  {
    if (this.w.isEmpty()) {
      return false;
    }
    boolean bool1 = false;
    if (paramMenuPresenter != null) {
      bool1 = paramMenuPresenter.a(paramSubMenuBuilder);
    }
    Iterator localIterator = this.w.iterator();
    boolean bool2 = bool1;
    MenuPresenter localMenuPresenter;
    boolean bool3;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.w.remove(localWeakReference);
        bool3 = bool2;
      }
    }
    for (;;)
    {
      bool2 = bool3;
      break;
      if (!bool2)
      {
        bool3 = localMenuPresenter.a(paramSubMenuBuilder);
        continue;
        return bool2;
      }
      else
      {
        bool3 = bool2;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.w.isEmpty()) {
      return;
    }
    g();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        this.w.remove(localWeakReference);
      } else {
        localMenuPresenter.a(paramBoolean);
      }
    }
    h();
  }
  
  private static int d(int paramInt)
  {
    int i1 = (0xFFFF0000 & paramInt) >> 16;
    if ((i1 < 0) || (i1 >= d.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    return d[i1] << 16 | 0xFFFF & paramInt;
  }
  
  private void d(boolean paramBoolean)
  {
    int i1 = 1;
    if ((paramBoolean) && (this.f.getConfiguration().keyboard != i1) && (this.f.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))) {}
    for (;;)
    {
      this.h = i1;
      return;
      i1 = 0;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = size();
    if (paramInt2 < 0) {
      paramInt2 = 0;
    }
    for (int i2 = paramInt2; i2 < i1; i2++) {
      if (((MenuItemImpl)this.j.get(i2)).getGroupId() == paramInt1) {
        return i2;
      }
    }
    return -1;
  }
  
  public MenuBuilder a(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
  
  protected MenuBuilder a(Drawable paramDrawable)
  {
    a(0, null, 0, paramDrawable, null);
    return this;
  }
  
  protected MenuBuilder a(View paramView)
  {
    a(0, null, 0, null, paramView);
    return this;
  }
  
  protected MenuBuilder a(CharSequence paramCharSequence)
  {
    a(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  MenuItemImpl a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.v;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    MenuItemImpl localMenuItemImpl;
    if (localArrayList.isEmpty()) {
      localMenuItemImpl = null;
    }
    label181:
    for (;;)
    {
      return localMenuItemImpl;
      int i1 = paramKeyEvent.getMetaState();
      KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
      paramKeyEvent.getKeyData(localKeyData);
      int i2 = localArrayList.size();
      if (i2 == 1) {
        return (MenuItemImpl)localArrayList.get(0);
      }
      boolean bool = b();
      int i3 = 0;
      if (i3 >= i2) {
        break;
      }
      localMenuItemImpl = (MenuItemImpl)localArrayList.get(i3);
      if (bool) {}
      for (int i4 = localMenuItemImpl.getAlphabeticShortcut();; i4 = localMenuItemImpl.getNumericShortcut())
      {
        if (((i4 == localKeyData.meta[0]) && ((i1 & 0x2) == 0)) || ((i4 == localKeyData.meta[2]) && ((i1 & 0x2) != 0)) || ((bool) && (i4 == 8) && (paramInt == 67))) {
          break label181;
        }
        i3++;
        break;
      }
    }
    return null;
  }
  
  protected String a()
  {
    return "android:menu:actionviewstates";
  }
  
  public void a(Bundle paramBundle)
  {
    int i1 = size();
    int i2 = 0;
    Object localObject2;
    for (Object localObject1 = null; i2 < i1; localObject1 = localObject2)
    {
      MenuItem localMenuItem = getItem(i2);
      View localView = MenuItemCompat.getActionView(localMenuItem);
      if ((localView != null) && (localView.getId() != -1))
      {
        if (localObject1 == null) {
          localObject1 = new SparseArray();
        }
        localView.saveHierarchyState((SparseArray)localObject1);
        if (MenuItemCompat.isActionViewExpanded(localMenuItem)) {
          paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
        }
      }
      localObject2 = localObject1;
      if (localMenuItem.hasSubMenu()) {
        ((SubMenuBuilder)localMenuItem.getSubMenu()).a(paramBundle);
      }
      i2++;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(a(), (SparseArray)localObject1);
    }
  }
  
  public void a(MenuBuilder.Callback paramCallback)
  {
    this.i = paramCallback;
  }
  
  void a(MenuItemImpl paramMenuItemImpl)
  {
    this.l = true;
    b(true);
  }
  
  public void a(MenuPresenter paramMenuPresenter)
  {
    a(paramMenuPresenter, this.e);
  }
  
  public void a(MenuPresenter paramMenuPresenter, Context paramContext)
  {
    this.w.add(new WeakReference(paramMenuPresenter));
    paramMenuPresenter.a(paramContext, this);
    this.o = true;
  }
  
  void a(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getGroupId();
    int i2 = this.j.size();
    int i3 = 0;
    if (i3 < i2)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.j.get(i3);
      if ((localMenuItemImpl.getGroupId() != i1) || (!localMenuItemImpl.f())) {}
      while (!localMenuItemImpl.isCheckable())
      {
        i3++;
        break;
      }
      if (localMenuItemImpl == paramMenuItem) {}
      for (boolean bool = true;; bool = false)
      {
        localMenuItemImpl.b(bool);
        break;
      }
    }
  }
  
  void a(List<MenuItemImpl> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = b();
    int i1 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int i2 = this.j.size();
    int i3 = 0;
    label49:
    MenuItemImpl localMenuItemImpl;
    if (i3 < i2)
    {
      localMenuItemImpl = (MenuItemImpl)this.j.get(i3);
      if (localMenuItemImpl.hasSubMenu()) {
        ((MenuBuilder)localMenuItemImpl.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label181;
      }
    }
    label181:
    for (int i4 = localMenuItemImpl.getAlphabeticShortcut();; i4 = localMenuItemImpl.getNumericShortcut())
    {
      if (((i1 & 0x5) == 0) && (i4 != 0) && ((i4 == localKeyData.meta[0]) || (i4 == localKeyData.meta[2]) || ((bool) && (i4 == 8) && (paramInt == 67))) && (localMenuItemImpl.isEnabled())) {
        paramList.add(localMenuItemImpl);
      }
      i3++;
      break label49;
      break;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.u) {
      return;
    }
    this.u = true;
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        this.w.remove(localWeakReference);
      } else {
        localMenuPresenter.a(this, paramBoolean);
      }
    }
    this.u = false;
  }
  
  boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (this.i != null) && (this.i.a(paramMenuBuilder, paramMenuItem));
  }
  
  public boolean a(MenuItem paramMenuItem, int paramInt)
  {
    return a(paramMenuItem, null, paramInt);
  }
  
  public boolean a(MenuItem paramMenuItem, MenuPresenter paramMenuPresenter, int paramInt)
  {
    MenuItemImpl localMenuItemImpl = (MenuItemImpl)paramMenuItem;
    boolean bool1 = false;
    if (localMenuItemImpl != null)
    {
      boolean bool2 = localMenuItemImpl.isEnabled();
      bool1 = false;
      if (bool2) {
        break label32;
      }
    }
    label32:
    boolean bool3;
    label99:
    do
    {
      return bool1;
      bool3 = localMenuItemImpl.a();
      ActionProvider localActionProvider = localMenuItemImpl.getSupportActionProvider();
      if ((localActionProvider != null) && (localActionProvider.hasSubMenu())) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (!localMenuItemImpl.m()) {
          break label99;
        }
        bool1 = bool3 | localMenuItemImpl.expandActionView();
        if (!bool1) {
          break;
        }
        a(true);
        return bool1;
      }
      if ((!localMenuItemImpl.hasSubMenu()) && (i1 == 0)) {
        break;
      }
      a(false);
      if (!localMenuItemImpl.hasSubMenu()) {
        localMenuItemImpl.a(new SubMenuBuilder(e(), this, localMenuItemImpl));
      }
      SubMenuBuilder localSubMenuBuilder = (SubMenuBuilder)localMenuItemImpl.getSubMenu();
      if (i1 != 0) {
        localActionProvider.onPrepareSubMenu(localSubMenuBuilder);
      }
      bool1 = bool3 | a(localSubMenuBuilder, paramMenuPresenter);
    } while (bool1);
    a(true);
    return bool1;
    if ((paramInt & 0x1) == 0) {
      a(true);
    }
    return bool3;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.f.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.e.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i1;
    int i2;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i1 = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      i2 = 0;
      if (i2 >= i1) {
        break label211;
      }
      localResolveInfo = (ResolveInfo)localList.get(i2);
      if (localResolveInfo.specificIndex >= 0) {
        break label198;
      }
    }
    label198:
    for (Intent localIntent1 = paramIntent;; localIntent1 = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      Intent localIntent2 = new Intent(localIntent1);
      localIntent2.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      MenuItem localMenuItem = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(localIntent2);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = localMenuItem;
      }
      i2++;
      break label52;
      i1 = 0;
      break;
    }
    label211:
    return i1;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.f.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    MenuItemImpl localMenuItemImpl = (MenuItemImpl)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    SubMenuBuilder localSubMenuBuilder = new SubMenuBuilder(this.e, this, localMenuItemImpl);
    localMenuItemImpl.a(localSubMenuBuilder);
    return localSubMenuBuilder;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public int b(int paramInt)
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++) {
      if (((MenuItemImpl)this.j.get(i2)).getItemId() == paramInt) {
        return i2;
      }
    }
    return -1;
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    MenuItem localMenuItem1;
    do
    {
      int i3;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(a());
        int i1 = size();
        for (int i2 = 0; i2 < i1; i2++)
        {
          MenuItem localMenuItem2 = getItem(i2);
          View localView = MenuItemCompat.getActionView(localMenuItem2);
          if ((localView != null) && (localView.getId() != -1)) {
            localView.restoreHierarchyState(localSparseArray);
          }
          if (localMenuItem2.hasSubMenu()) {
            ((SubMenuBuilder)localMenuItem2.getSubMenu()).b(paramBundle);
          }
        }
        i3 = paramBundle.getInt("android:menu:expandedactionview");
      } while (i3 <= 0);
      localMenuItem1 = findItem(i3);
    } while (localMenuItem1 == null);
    MenuItemCompat.expandActionView(localMenuItem1);
  }
  
  void b(MenuItemImpl paramMenuItemImpl)
  {
    this.o = true;
    b(true);
  }
  
  public void b(MenuPresenter paramMenuPresenter)
  {
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if ((localMenuPresenter == null) || (localMenuPresenter == paramMenuPresenter)) {
        this.w.remove(localWeakReference);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.r)
    {
      if (paramBoolean)
      {
        this.l = true;
        this.o = true;
      }
      c(paramBoolean);
      return;
    }
    this.s = true;
  }
  
  boolean b()
  {
    return this.g;
  }
  
  public int c(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public boolean c(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1 = this.w.isEmpty();
    boolean bool2 = false;
    if (bool1) {
      return bool2;
    }
    g();
    Iterator localIterator = this.w.iterator();
    boolean bool3 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.w.remove(localWeakReference);
        bool2 = bool3;
      }
      do
      {
        bool3 = bool2;
        break;
        bool2 = localMenuPresenter.a(this, paramMenuItemImpl);
      } while (!bool2);
    }
    for (;;)
    {
      h();
      if (!bool2) {
        break;
      }
      this.x = paramMenuItemImpl;
      return bool2;
      bool2 = bool3;
    }
  }
  
  public void clear()
  {
    if (this.x != null) {
      d(this.x);
    }
    this.j.clear();
    b(true);
  }
  
  public void clearHeader()
  {
    this.b = null;
    this.a = null;
    this.c = null;
    b(false);
  }
  
  public void close()
  {
    a(true);
  }
  
  Resources d()
  {
    return this.f;
  }
  
  public boolean d(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1 = this.w.isEmpty();
    boolean bool2 = false;
    if (!bool1)
    {
      MenuItemImpl localMenuItemImpl = this.x;
      bool2 = false;
      if (localMenuItemImpl == paramMenuItemImpl) {}
    }
    else
    {
      return bool2;
    }
    g();
    Iterator localIterator = this.w.iterator();
    boolean bool3 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.w.remove(localWeakReference);
        bool2 = bool3;
      }
      do
      {
        bool3 = bool2;
        break;
        bool2 = localMenuPresenter.b(this, paramMenuItemImpl);
      } while (!bool2);
    }
    for (;;)
    {
      h();
      if (!bool2) {
        break;
      }
      this.x = null;
      return bool2;
      bool2 = bool3;
    }
  }
  
  public Context e()
  {
    return this.e;
  }
  
  public void f()
  {
    if (this.i != null) {
      this.i.a(this);
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      Object localObject = (MenuItemImpl)this.j.get(i2);
      if (((MenuItemImpl)localObject).getItemId() == paramInt) {}
      do
      {
        return localObject;
        if (!((MenuItemImpl)localObject).hasSubMenu()) {
          break;
        }
        localObject = ((MenuItemImpl)localObject).getSubMenu().findItem(paramInt);
      } while (localObject != null);
    }
    return null;
  }
  
  public void g()
  {
    if (!this.r)
    {
      this.r = true;
      this.s = false;
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.j.get(paramInt);
  }
  
  public void h()
  {
    this.r = false;
    if (this.s)
    {
      this.s = false;
      b(true);
    }
  }
  
  public boolean hasVisibleItems()
  {
    int i1 = size();
    for (int i2 = 0; i2 < i1; i2++) {
      if (((MenuItemImpl)this.j.get(i2)).isVisible()) {
        return true;
      }
    }
    return false;
  }
  
  public ArrayList<MenuItemImpl> i()
  {
    if (!this.l) {
      return this.k;
    }
    this.k.clear();
    int i1 = this.j.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.j.get(i2);
      if (localMenuItemImpl.isVisible()) {
        this.k.add(localMenuItemImpl);
      }
    }
    this.l = false;
    this.o = true;
    return this.k;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  public void j()
  {
    ArrayList localArrayList = i();
    if (!this.o) {
      return;
    }
    Iterator localIterator = this.w.iterator();
    boolean bool1 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        this.w.remove(localWeakReference);
      }
      for (boolean bool2 = bool1;; bool2 = bool1 | localMenuPresenter.b())
      {
        bool1 = bool2;
        break;
      }
    }
    if (bool1)
    {
      this.m.clear();
      this.n.clear();
      int i1 = localArrayList.size();
      int i2 = 0;
      if (i2 < i1)
      {
        MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(i2);
        if (localMenuItemImpl.i()) {
          this.m.add(localMenuItemImpl);
        }
        for (;;)
        {
          i2++;
          break;
          this.n.add(localMenuItemImpl);
        }
      }
    }
    else
    {
      this.m.clear();
      this.n.clear();
      this.n.addAll(i());
    }
    this.o = false;
  }
  
  public ArrayList<MenuItemImpl> k()
  {
    j();
    return this.m;
  }
  
  public ArrayList<MenuItemImpl> l()
  {
    j();
    return this.n;
  }
  
  public CharSequence m()
  {
    return this.a;
  }
  
  public Drawable n()
  {
    return this.b;
  }
  
  public View o()
  {
    return this.c;
  }
  
  public MenuBuilder p()
  {
    return this;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    MenuItemImpl localMenuItemImpl = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (localMenuItemImpl != null) {
      bool = a(localMenuItemImpl, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      a(true);
    }
    return bool;
  }
  
  boolean q()
  {
    return this.t;
  }
  
  public MenuItemImpl r()
  {
    return this.x;
  }
  
  public void removeGroup(int paramInt)
  {
    int i1 = c(paramInt);
    if (i1 >= 0)
    {
      int i2 = this.j.size() - i1;
      int i4;
      for (int i3 = 0;; i3 = i4)
      {
        i4 = i3 + 1;
        if ((i3 >= i2) || (((MenuItemImpl)this.j.get(i1)).getGroupId() != paramInt)) {
          break;
        }
        a(i1, false);
      }
      b(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    a(b(paramInt), true);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.j.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.j.get(i2);
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        localMenuItemImpl.a(paramBoolean2);
        localMenuItemImpl.setCheckable(paramBoolean1);
      }
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i1 = this.j.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.j.get(i2);
      if (localMenuItemImpl.getGroupId() == paramInt) {
        localMenuItemImpl.setEnabled(paramBoolean);
      }
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i1 = this.j.size();
    int i2 = 0;
    int i3 = 0;
    if (i2 < i1)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.j.get(i2);
      if ((localMenuItemImpl.getGroupId() != paramInt) || (!localMenuItemImpl.c(paramBoolean))) {
        break label76;
      }
    }
    label76:
    for (int i4 = 1;; i4 = i3)
    {
      i2++;
      i3 = i4;
      break;
      if (i3 != 0) {
        b(true);
      }
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
    b(false);
  }
  
  public int size()
  {
    return this.j.size();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuBuilder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */