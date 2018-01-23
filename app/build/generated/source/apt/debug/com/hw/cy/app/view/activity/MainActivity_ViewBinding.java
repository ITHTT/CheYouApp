// Generated code from Butter Knife. Do not modify!
package com.hw.cy.app.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hw.cy.app.R;
import com.hw.cy.app.view.widget.MainTabView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131230865;

  private View view2131230863;

  private View view2131230864;

  private View view2131230867;

  private View view2131230866;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.menu_tab_home, "field 'tabHome' and method 'onClickMenuViewTab'");
    target.tabHome = Utils.castView(view, R.id.menu_tab_home, "field 'tabHome'", MainTabView.class);
    view2131230865 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickMenuViewTab(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.menu_tab_buycar, "field 'tabBuyCar' and method 'onClickMenuViewTab'");
    target.tabBuyCar = Utils.castView(view, R.id.menu_tab_buycar, "field 'tabBuyCar'", MainTabView.class);
    view2131230863 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickMenuViewTab(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.menu_tab_carstore, "field 'tabCarStore' and method 'onClickMenuViewTab'");
    target.tabCarStore = Utils.castView(view, R.id.menu_tab_carstore, "field 'tabCarStore'", MainTabView.class);
    view2131230864 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickMenuViewTab(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.menu_tab_news, "field 'tabCarNews' and method 'onClickMenuViewTab'");
    target.tabCarNews = Utils.castView(view, R.id.menu_tab_news, "field 'tabCarNews'", MainTabView.class);
    view2131230867 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickMenuViewTab(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.menu_tab_mine, "field 'tabMine' and method 'onClickMenuViewTab'");
    target.tabMine = Utils.castView(view, R.id.menu_tab_mine, "field 'tabMine'", MainTabView.class);
    view2131230866 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickMenuViewTab(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabHome = null;
    target.tabBuyCar = null;
    target.tabCarStore = null;
    target.tabCarNews = null;
    target.tabMine = null;

    view2131230865.setOnClickListener(null);
    view2131230865 = null;
    view2131230863.setOnClickListener(null);
    view2131230863 = null;
    view2131230864.setOnClickListener(null);
    view2131230864 = null;
    view2131230867.setOnClickListener(null);
    view2131230867 = null;
    view2131230866.setOnClickListener(null);
    view2131230866 = null;
  }
}
