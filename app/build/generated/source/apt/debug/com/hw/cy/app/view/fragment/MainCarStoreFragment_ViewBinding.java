// Generated code from Butter Knife. Do not modify!
package com.hw.cy.app.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hw.cy.app.R;
import com.hw.cy.app.view.widget.RefreshRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainCarStoreFragment_ViewBinding implements Unbinder {
  private MainCarStoreFragment target;

  @UiThread
  public MainCarStoreFragment_ViewBinding(MainCarStoreFragment target, View source) {
    this.target = target;

    target.refreshRecyclerView = Utils.findRequiredViewAsType(source, R.id.refresh_recyclerview, "field 'refreshRecyclerView'", RefreshRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainCarStoreFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.refreshRecyclerView = null;
  }
}
