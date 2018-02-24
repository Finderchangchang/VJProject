package vj.project.base.http


import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import gd.mmanage.method.Utils
import gd.mmanage.method.Utils.string2MD5
import okhttp3.Call
import okhttp3.Response
import vj.project.base.callback.JsonCallback
import vj.project.base.callback.JsonRequest
import vj.project.base.callback.ListRequest
import vj.project.base.callback.ObjectRequest
import vj.project.base.method.Sha1
import vj.project.base.ui.BaseModule
import vj.project.config.command.login
import vj.project.config.sp
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Administrator on 2017/11/16.
 */
class HttpUtil<T> {

    fun posts(cla: Class<T>) {
        var s = cla
        var s1 = ""
//        OkGo.post("").execute(object : JsonCallback<ListRequest<T>>() {
//            override fun onSuccess(t: ListRequest<T>?, call: Call?, response: Response?) {
//
//            }
//
//            override fun onError(call: Call?, response: Response?, e: Exception?) {
//                super.onError(call, response, e)
//            }
//        })
    }

    fun new_get(url: String, back_id: Int, map: HashMap<String, String>?, control: BaseModule, type1: TypeToken<T>) {
        var go = OkGo.get(url)
        if (map != null) {
            for (model in map) {
                go.params(model.key, model.value)
            }
        }
//        go.params("signStr", "")
        go.execute(object : StringCallback() {
            override fun onSuccess(str: String, call: okhttp3.Call?, response: okhttp3.Response?) {
                var t = Gson().fromJson<JsonRequest>(str, JsonRequest::class.java)
                try {
//                    var model=Gson().fromJson(t.data.toString(),type1.type)
                    t as ListRequest<*>
                    if (t.code == 1) {
                        try {
//                            control.callback(back_id, NormalRequest(0, t.msg, t.Data))
                        } catch (e: Exception) {
//                            control.callback(back_id, NormalRequest(2, "未知错误：" + e.toString(), null))
                        }
                    } else {
//                        control.callback(back_id, NormalRequest(1, t.msg, t.Data))
                    }
                } catch (e: Exception) {
                    try {
                        t.toString() as ObjectRequest<*>
                        if (t.code == 1) {
                            try {
//                                control.callback(back_id, NormalRequest(0, t!!.msg, t!!.data))
                            } catch (e: Exception) {
//                                control.callback(back_id, NormalRequest(2, "未知错误：" + e.toString(), null))
                            }
                        } else {
//                            control.callback(back_id, NormalRequest(1, t!!.msg, null))
                        }
                    } catch (e: Exception) {
                        var s = e
                        var a = ""
                    }

                }

            }

            override fun onError(call: Call?, response: Response?, e: Exception?) {
//                control.callback(back_id, NormalRequest(2, "未知错误：" + e.toString(), null))
            }
        })
    }
}