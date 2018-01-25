package com.hw.cy.app.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.allen.library.SuperButton;
import com.blankj.utilcode.util.ActivityUtils;
import com.hw.cy.app.R;
import com.hw.cy.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mac on 2018/1/24.
 */

public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.btn_login)
    SuperButton btnLogin;
    @BindView(R.id.tv_send_code)
    TextView tvSendCode;
    private TimeCount time;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void initViewData(Intent intent, Bundle saved) {
        titleBar.setTitleName("登录");
        titleBar.hideBack();
        time = new TimeCount(60000, 1000);
    }


    @Override
    public boolean isBindRxBus() {
        return false;
    }

    @Override
    protected boolean isLightMode() {
        return super.isLightMode();
    }

    @Override
    public Object newPersenter() {

        return null;
    }


    @OnClick({R.id.btn_login, R.id.tv_send_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                ActivityUtils.startActivity(MainActivity.class);
                break;
            case R.id.tv_send_code:
                time.start();
                break;
        }
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
           // tvSendCode.setBackgroundColor(Color.parseColor("#B6B6D8"));
            tvSendCode.setClickable(false);
            tvSendCode.setText("(" + millisUntilFinished / 1000 + ") 秒后可重新发送");
        }

        @Override
        public void onFinish() {
            tvSendCode.setText("重新获取验证码");
            tvSendCode.setClickable(true);
           // tvSendCode.setBackgroundColor(Color.parseColor("#4EB84A"));

        }
    }
}
