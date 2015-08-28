package com.boohee.food.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.boohee.food.MainActivity;

public class IntroductionFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private View a;
  private Button b;
  private int c;
  private boolean d;
  
  public static IntroductionFragment a(int paramInt, boolean paramBoolean)
  {
    IntroductionFragment localIntroductionFragment = new IntroductionFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_resource_id", paramInt);
    localBundle.putBoolean("key_is_show_go", paramBoolean);
    localIntroductionFragment.setArguments(localBundle);
    return localIntroductionFragment;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.c = localBundle.getInt("key_resource_id");
      this.d = localBundle.getBoolean("key_is_show_go");
    }
  }
  
  public void onClick(View paramView)
  {
    MainActivity.a(getActivity());
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903099, null);
    this.a = localView.findViewById(2131427577);
    this.b = ((Button)localView.findViewById(2131427578));
    this.b.setOnClickListener(this);
    if (this.c != 0) {
      this.a.setBackgroundResource(this.c);
    }
    Button localButton = this.b;
    if (this.d) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      return localView;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.IntroductionFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */