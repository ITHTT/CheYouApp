// Generated code from Butter Knife. Do not modify!
package com.hw.cy.app.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hw.cy.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainMineFragment_ViewBinding implements Unbinder {
  private MainMineFragment target;

  @UiThread
  public MainMineFragment_ViewBinding(MainMineFragment target, View source) {
    this.target = target;

    target.layoutUserProfile = Utils.findRequiredViewAsType(source, R.id.layout_user_profile, "field 'layoutUserProfile'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainMineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutUserProfile = null;
  }
}
