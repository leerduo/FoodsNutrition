package com.boohee.food;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.boohee.food.fragment.LoadingFragment;
import com.boohee.food.volley.RequestManager;
import com.umeng.analytics.MobclickAgent;
import de.keyboardsurfer.android.widget.crouton.Crouton;

public abstract class BaseActivity extends FragmentActivity {
    protected Context a;
    private LoadingFragment b;

    private void a() {
        ActionBar localActionBar = getActionBar();
        localActionBar.setDisplayHomeAsUpEnabled(true);
        localActionBar.setDisplayShowHomeEnabled(true);
        localActionBar.setIcon(17170445);
        localActionBar.setHomeButtonEnabled(true);
    }

    public void a(Class paramClass) {
        startActivity(new Intent(this, paramClass));
    }

    public void c() {
        try {
            if (this.b == null) {
                this.b = LoadingFragment.a();
            }
            if (!this.b.isAdded()) {
                getSupportFragmentManager().beginTransaction().remove(this.b).commitAllowingStateLoss();
                this.b.show(getSupportFragmentManager(), "loading");
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void d() {
        try {
            if ((this.b != null) && (this.b.isAdded())) {
                this.b.dismiss();
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onBackPressed() {
        if (!((FoodApplication) getApplication()).b()) {
            Intent localIntent = new Intent(this, MainActivity.class);
            localIntent.setFlags(67108864);
            startActivity(localIntent);
            finish();
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a = this;
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        RequestManager.a(this);
        Crouton.a();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        onBackPressed();
        return true;
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.BaseActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */