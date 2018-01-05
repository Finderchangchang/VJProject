package vj.project.control

import android.content.Context
import com.google.gson.reflect.TypeToken
import vj.project.base.http.HttpUtil
import vj.project.base.ui.BaseModule
import vj.project.config.command
import vj.project.config.url
import vj.project.model.VersionModel
import java.util.HashMap

/**
 * Created by Administrator on 2018/1/4.
 */
class MainModule : BaseModule {
    constructor(context: Context?) : super(context)

    /**
     * 检查更新
     * */
    fun check_version() {
        var map = HashMap<String, String>()
        HttpUtil<VersionModel>().new_get(url.key + "ylUpload.php", command.login + 5, map, this, object : TypeToken<VersionModel>() {})
    }
}