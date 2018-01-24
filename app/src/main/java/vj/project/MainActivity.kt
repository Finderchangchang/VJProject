package vj.project

import android.os.Bundle
import com.arialyy.frame.module.AbsModule
import com.othershe.nicedialog.BaseNiceDialog
import com.othershe.nicedialog.NiceDialog
import kotlinx.android.synthetic.main.activity_main.*
import vj.project.base.http.NormalRequest
import vj.project.base.ui.BaseActivity
import vj.project.control.MainModule
import vj.project.databinding.ActivityMainBinding
import xyz.bboylin.universialtoast.UniversalToast

class MainActivity : BaseActivity<ActivityMainBinding>(), AbsModule.OnCallback {
    override fun onSuccess(result: Int, success: Any?) {
        when (result) {

        }
        var s = success as NormalRequest<String>
    }

    override fun onError(result: Int, error: Any?) {

    }

    var i = 0;
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        //getModule(MainModule::class.java, this).check_version()
        title_ll.setOnClickListener {
            load_dialog.show(supportFragmentManager);
            object : Thread() {
                override fun run() {
                    Thread.sleep(3000)
                    runOnUiThread {
                        toast_error("error")
                        load_dialog.dismiss()
                    }
                }
            }.start()
        }

    }

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }
}
