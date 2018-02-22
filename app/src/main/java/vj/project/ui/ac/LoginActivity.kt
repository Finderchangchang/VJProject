package vj.project.ui.ac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.arialyy.frame.module.AbsModule
import kotlinx.android.synthetic.main.activity_login.*
import vj.project.R
import vj.project.base.ui.BaseActivity
import vj.project.config.command
import vj.project.control.MainModule
import vj.project.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(), AbsModule.OnCallback {
    override fun onSuccess(result: Int, success: Any?) {
        when (result) {
            command.login + 1 -> {

            }
            command.login + 2 -> {

            }
        }
    }

    override fun onError(result: Int, error: Any?) {

    }

    var control: MainModule? = null
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        control = MainModule(this)
        control!!.check_version()//检查更新操作
        login_btn.setOnClickListener {
            var name = name_et.text.toString().trim()
            var pwd = pwd_et.text.toString().trim()
            if (TextUtils.isEmpty(name)) {
                toast(getString(R.string.name_is_error))
            } else if (TextUtils.isEmpty(pwd)) {
                toast(getString(R.string.pwd_is_error))
            } else {
                control!!.login(name, pwd)//登录
            }
        }
    }


    override fun setLayoutId(): Int {
        return R.layout.activity_login
    }
}
