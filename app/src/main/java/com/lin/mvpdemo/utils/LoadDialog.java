package com.lin.mvpdemo.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.lin.mvpdemo.R;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author ljz.
 * @date 2017/11/20.
 * 描述：加载Dialog
 */

public class LoadDialog extends Dialog {

    private String TAG = "LoadDialog";
    private CompositeDisposable mCompositeDisposable;
    private LoadDialog loadDialog;

    public LoadDialog(final Context context) {
        super(context, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);
        setContentView(View.inflate(context, R.layout.dialog_loading, null));

        loadDialog = this;
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(false);
        getWindow().getDecorView().getBackground().setAlpha(0);
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        Log.e(TAG, "onKeyDown: 0");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 取消网络请求
            if (mCompositeDisposable != null) {
                Log.e(TAG, "onKeyDown: mCompositeDisposable.size = " + mCompositeDisposable.size());
                mCompositeDisposable.dispose();
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    public void show(CompositeDisposable compositeDisposable) {
        this.mCompositeDisposable = compositeDisposable;
        if (!loadDialog.isShowing()){
            loadDialog.show();
        }
    }
}
