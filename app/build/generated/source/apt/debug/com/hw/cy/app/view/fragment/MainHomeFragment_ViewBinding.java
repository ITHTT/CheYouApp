// Generated code from Butter Knife. Do not modify!
package com.hw.cy.app.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hw.cy.app.R;
import com.hw.cy.app.view.widget.RefreshRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainHomeFragment_ViewBinding implements Unbinder {
  private MainHomeFragment target;

  @UiThread
  public MainHomeFragment_ViewBinding(MainHomeFragment target, View source) {
    this.target = target;

    target.refreshRecyclerView = Utils.findRequiredViewAsType(source, R.id.refresh_recyclerview, "field 'refreshRecyclerView'", RefreshRecyclerView.class);
    target.statusBar = Utils.findRequiredView(source, R.id.status_bar, "field 'statusBar'");
    target.layoutTitleBar = Utils.findRequiredViewAsType(source, R.id.layout_title_bar, "field 'layoutTitleBar'", LinearLayout.class);
    target.titleBarLine = Utils.findRequiredView(source, R.id.line, "field 'titleBarLine'");
    target.tvCity = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tvCity'", TextView.class);
    target.ivAddress = Utils.findRequiredViewAsType(source, R.id.iv_address, "field 'ivAddress'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainHomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.refreshRecyclerView = null;
    target.statusBar = null;
    target.layoutTitleBar = null;
    target.titleBarLine = null;
    target.tvCity = null;
    target.ivAddress = null;
  }
}
