package com.lin.mvpdemo.mvp.info;

import com.lin.mvpdemo.mvp.BasePresenter;
import com.lin.mvpdemo.network.RetrofitHelper;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

/**
 * @author ljz.
 * @date 2017/11/15
 */

public class InfoPresenter extends BasePresenter<InfoContract.View> implements InfoContract.Presenter<InfoContract.View> {


    @Inject
    public InfoPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void setText(String s) {

        String info1 = "1e92bebbfca93a3ed9d3f0c473877fd78c2178dba39050e139852152ad730ff6f9402c037159968c1de93de489e4c9fed7fe5036608996679ba50b88c0485178a22db5564f16c9ed10684e93c7c3ce1a6a0171200cc03c53774a14245a2834c20712b45d14563b30e4d6f65184c8b9df8cf503aa0bff8d0027e9c2dbe8d8b95c532317695838111db66940e5d0385c5c61e39f5e118b095a8ee3384c82e902760dc5bbcc3784d81bf230cd288a99473f268c0e16730c8cde45c4364535c60a2e68ee4b2e207dfd96e223a80ddea6cae521fdfe94dfbc3618a8286003e7046e0d596cd8cd41a5b4e2824b89d16cbb416450fbd3c510cbafd53a8da584fb8c34b5804cf5497cfb9cff22c61e650144f869fc05fd5bb2a11b91121f83a2c24c68d2cc688c9d0a4317c782b4ab754898f3925720d412ef76d9e6320d229972f1612b4c7634bd6757fe7cd1dbde7776d1800d";
        String info2 = "ec7e85dbce6e6869e73ea13d410b6dbc16a0a5c0d30c346cbb87754797dd08f1bb9b95ee5d9ee5ccf9882da8e1b5470acad65ea15a2b93403c534863687e6da5a63d11daefc2aa87800fb76540a299a0b344e64b43f5c28f1775fabf5d1676dfe063a5616ac41a217247eb2f3b4e7842b7dd07caa8b02543921d7ed807a0ac9ec8b479d6329ad6a0e0d126df788a0db30ea6815ca2f1e62b43fe93d4fdfc84885cbfecda1df4e9f59dce0108564afab18b59fbd84ca7fa7db7d5153a22350646cd514cbf90ce498e52acda3b1ffc755d90a2bff67a7e4a650429cdefed04464f1ee3d90527134e365aed2e9ca18f5a8e3b27422e93d5de464a8e6cb9e897968d814bfd41ea4b749431c797cb0ad0142d897d1598bd17abfaeefbd2dfc4ef34f4583e41b9e3d1906d410f4d36f5b1e6dbc07aa7a559910e0d53b9ce58ac10a2831bf89972396dfbb0460b6bf5ffcbfe9c";


        addSubscribe(mRetrofitHelper.info1(100, this, info1));
        addSubscribe(mRetrofitHelper.info2(200, this, info2, null));

        mView.showToash(s);
        mView.showText(s);
    }


    @Override
    public void onSuccess2(int tag, JSONObject response) throws JSONException {
        super.onSuccess2(tag, response);

        if (tag == 100) {

            mView.showText(response.toString());
        }
    }
}
