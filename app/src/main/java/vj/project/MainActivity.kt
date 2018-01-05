package vj.project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arialyy.frame.module.AbsModule
import vj.project.base.http.NormalRequest
import vj.project.base.ui.BaseActivity
import vj.project.control.MainModule
import vj.project.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(), AbsModule.OnCallback {
    override fun onSuccess(result: Int, success: Any?) {
        var s = success as NormalRequest<String>
    }

    override fun onError(result: Int, error: Any?) {

    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        getModule(MainModule::class.java, this).check_version()
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }
}
