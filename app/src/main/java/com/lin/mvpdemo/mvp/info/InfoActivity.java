package com.lin.mvpdemo.mvp.info;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lin.mvpdemo.R;
import com.lin.mvpdemo.mvp.BaseActivity;

import butterknife.Bind;

public class InfoActivity extends BaseActivity<InfoPresenter> implements InfoContract.View {


    @Bind(R.id.btn_info_toash)
    Button btnInfoToash;
    @Bind(R.id.tv_info)
    TextView tvInfo;

    @Override
    public int initResource() {
        return R.layout.activity_info;
    }

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void initData() {
        btnInfoToash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.setText("asdfasdfasdfadsfadsf");
            }
        });
    }

    @Override
    public void showToash(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showText(String s) {
        tvInfo.setText(s);
    }

}
