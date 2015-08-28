package android.support.v4.app;

import android.view.View;
import android.view.Window;

class FragmentActivity$2
  implements FragmentContainer
{
  FragmentActivity$2(FragmentActivity paramFragmentActivity) {}
  
  public View findViewById(int paramInt)
  {
    return this.this$0.findViewById(paramInt);
  }
  
  public boolean hasView()
  {
    Window localWindow = this.this$0.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */