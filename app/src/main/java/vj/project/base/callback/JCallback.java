package vj.project.base.callback;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;

import okhttp3.Response;

/**
 * 数据解析回调类
 * Created by Administrator on 2018/2/24.
 */

public abstract class JCallback<T> extends AbsCallback<T> {
    TypeToken<T> type;

    public JCallback(TypeToken typeToken) {
        type = typeToken;
    }

    @Override
    public T convertSuccess(Response response) throws Exception {
        String s = StringConvert.create().convertSuccess(response);
        T obj = new Gson().fromJson(s, type.getType());
        response.close();
        return obj;
    }
}