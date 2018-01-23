package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.htt.framelibrary.log.KLog;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;
import com.hw.cy.app.util.StatusBarUtil;
import com.hw.cy.app.view.fragment.MainBuyCarFragment;
import com.hw.cy.app.view.fragment.MainCarNewsFragment;
import com.hw.cy.app.view.fragment.MainCarStoreFragment;
import com.hw.cy.app.view.fragment.MainHomeFragment;
import com.hw.cy.app.view.fragment.MainMineFragment;
import com.hw.cy.app.view.widget.MainTabView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ithtt on 2018/1/22.
 */

public class MainActivity extends BaseActivity{
    @BindView(R.id.menu_tab_home)
    MainTabView tabHome;
    @BindView(R.id.menu_tab_buycar)
    MainTabView tabBuyCar;
    @BindView(R.id.menu_tab_carstore)
    MainTabView tabCarStore;
    @BindView(R.id.menu_tab_news)
    MainTabView tabCarNews;
    @BindView(R.id.menu_tab_mine)
    MainTabView tabMine;

    private MainHomeFragment homeFragment;
    private MainBuyCarFragment buyCarFragment;
    private MainCarStoreFragment carStoreFragment;
    private MainCarNewsFragment carNewsFragment;
    private MainMineFragment mineFragment;

    private int currentIndex=-1;
    private Fragment currentFragment;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViewData(Intent intent, Bundle saved) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            StatusBarUtil.statusBarLightMode(this);
        }
        tabHome.performClick();

    }

    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    public Object newPersenter() {
        return null;
    }

    @Override
    protected boolean isSwipeBack() {
        return false;
    }

    @OnClick({R.id.menu_tab_home,
            R.id.menu_tab_buycar,
            R.id.menu_tab_carstore,
            R.id.menu_tab_news,
            R.id.menu_tab_mine})
    public void onClickMenuViewTab(View view){
        setTabSelectedPager(view.getId());
    }

    private void setSelectedMenuTab(int id){
        if(id==R.id.menu_tab_home){
            tabHome.setSelected(true);
            tabBuyCar.setSelected(false);
            tabCarStore.setSelected(false);
            tabCarNews.setSelected(false);
            tabMine.setSelected(false);
        }else if(id==R.id.menu_tab_buycar){
            tabHome.setSelected(false);
            tabBuyCar.setSelected(true);
            tabCarStore.setSelected(false);
            tabCarNews.setSelected(false);
            tabMine.setSelected(false);
        }else if(id==R.id.menu_tab_carstore){
            tabHome.setSelected(false);
            tabBuyCar.setSelected(false);
            tabCarStore.setSelected(true);
            tabCarNews.setSelected(false);
            tabMine.setSelected(false);
        }else if(id==R.id.menu_tab_news){
            tabHome.setSelected(false);
            tabBuyCar.setSelected(false);
            tabCarStore.setSelected(false);
            tabCarNews.setSelected(true);
            tabMine.setSelected(false);
        }else if(id==R.id.menu_tab_mine){
            tabHome.setSelected(false);
            tabBuyCar.setSelected(false);
            tabCarStore.setSelected(false);
            tabCarNews.setSelected(false);
            tabMine.setSelected(true);
        }
    }

    protected void setTabSelectedPager(int id){
        int index=0;
        Fragment toFragment=null;
        switch(id){
            case R.id.menu_tab_home:
                if(homeFragment==null) {
                    homeFragment = (MainHomeFragment) getSupportFragmentManager().findFragmentByTag(MainHomeFragment.class.getSimpleName());
                    if (homeFragment == null) {
                        homeFragment = new MainHomeFragment();
                    }
                }
                index=0;
                toFragment=homeFragment;
                break;
            case R.id.menu_tab_buycar:
                if(buyCarFragment==null) {
                    buyCarFragment = (MainBuyCarFragment) getSupportFragmentManager().findFragmentByTag(MainBuyCarFragment.class.getSimpleName());
                    if (buyCarFragment == null) {
                        buyCarFragment = new MainBuyCarFragment();
                    }
                }
                index=1;
                toFragment=buyCarFragment;
                break;
            case R.id.menu_tab_carstore:
                if(carStoreFragment==null) {
                    carStoreFragment = (MainCarStoreFragment) getSupportFragmentManager().findFragmentByTag(MainCarStoreFragment.class.getSimpleName());
                    if (carStoreFragment == null) {
                        carStoreFragment = new MainCarStoreFragment();
                    }
                }
                index=2;
                toFragment=carStoreFragment;
                break;
            case R.id.menu_tab_news:
                if(carNewsFragment==null) {
                    carNewsFragment = (MainCarNewsFragment) getSupportFragmentManager().findFragmentByTag(MainCarNewsFragment.class.getSimpleName());
                    if (carNewsFragment == null) {
                        carNewsFragment = new MainCarNewsFragment();
                    }
                }
                index=3;
                toFragment=carNewsFragment;
                break;
            case R.id.menu_tab_mine:
                if(mineFragment==null){
                    mineFragment=(MainMineFragment)getSupportFragmentManager().findFragmentByTag(MainMineFragment.class.getSimpleName());
                    if(mineFragment==null){
                        mineFragment=new MainMineFragment();
                    }
                }
                index=4;
                toFragment=mineFragment;
                break;
        }
        setSelectedMenuTab(id);
        switchTabPager(index,toFragment);
    }

    /**
     * 获取一个带动画的FragmentTransaction
     * @param index
     * @return
     */
    private FragmentTransaction obtainFragmentTransaction(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // 设置切换动画
        if(currentIndex>=0) {
            if (index > currentIndex) {
                ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
            } else {
                ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
            }
        }
        return ft;
    }

    private void switchTabPager(int toIndex, Fragment toFragment) {
        if (toFragment != currentFragment) {
            KLog.i("toIndex:"+toIndex);

            FragmentTransaction transaction = obtainFragmentTransaction(toIndex);
            if (currentFragment == null) {
                if (toFragment.isAdded()) {
                    //KLog.i("显示Fragment...");
                    transaction.show(toFragment);
                } else {
                   // KLog.i("添加Fragment...");
                    transaction.add(R.id.layout_container, toFragment,toFragment.getClass().getSimpleName());
                }
            } else {
                if (toFragment.isAdded()) {
                    //KLog.i("显示Fragment...");
                    transaction.show(toFragment).hide(currentFragment);
                } else {
                    //KLog.i("添加Fragment...");
                    transaction.add(R.id.layout_container, toFragment).hide(currentFragment);
                }
            }
            transaction.commitAllowingStateLoss();
            currentFragment = toFragment;
            currentIndex = toIndex;
        }
    }
}
