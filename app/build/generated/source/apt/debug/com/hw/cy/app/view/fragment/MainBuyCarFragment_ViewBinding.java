// Generated code from Butter Knife. Do not modify!
package com.hw.cy.app.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hw.cy.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainBuyCarFragment_ViewBinding implements Unbinder {
  private MainBuyCarFragment target;

  @UiThread
  public MainBuyCarFragment_ViewBinding(MainBuyCarFragment target, View source) {
    this.target = target;

    target.rvCarBrand = Utils.findRequiredViewAsType(source, R.id.rv_car_brand, "field 'rvCarBrand'", RecyclerView.class);
    target.rvCarSeries = Utils.findRequiredViewAsType(source, R.id.rv_car_series, "field 'rvCarSeries'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainBuyCarFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvCarBrand = null;
    target.rvCarSeries = null;
  }
}
