package com.lin.mvpdemo.mvp.main;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lin.mvpdemo.R;
import com.lin.mvpdemo.mvp.BaseActivity;
import com.lin.mvpdemo.mvp.info.InfoActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @Bind(R.id.btn_info)
    Button btnInfo;

    @Override
    public int initResource() {
        return R.layout.activity_main;
    }

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void initData() {
        mPresenter.showToash("123123123");

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });
    }



    @Override
    public void showToash(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
