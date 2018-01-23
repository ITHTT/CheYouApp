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

public class MainCarNewsFragment_ViewBinding implements Unbinder {
  private MainCarNewsFragment target;

  @UiThread
  public MainCarNewsFragment_ViewBinding(MainCarNewsFragment target, View source) {
    this.target = target;

    target.refreshRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_car_news, "field 'refreshRecyclerView'", RefreshRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainCarNewsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.refreshRecyclerView = null;
  }
}
