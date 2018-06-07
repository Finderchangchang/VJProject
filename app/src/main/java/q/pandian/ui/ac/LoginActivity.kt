package q.pandian.ui.ac

import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_login.*
import q.pandian.R
import q.pandian.base.http.ListRequest
import q.pandian.base.http.ModelRequest
import q.pandian.base.ui.BaseActivity
import q.pandian.config.command
import q.pandian.control.MainModule
import q.pandian.databinding.ActivityLoginBinding
import q.pandian.model.UserModel
import q.pandian.model.VersionModel

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun onSuccess(result: Int, success: Any?) {
        try {
            var model = success as ListRequest<UserModel>
            when (result) {
                command.login + 1 -> {
                    when (model.state) {
                        1 -> {//登录成功
                            toast("登录成功")
                        }
                        else -> {
                            toast(model.msg)
                        }
                    }
                }
                command.login + 2 -> {

                }
            }
        } catch (e: Exception) {
            success as ModelRequest<String>
            toast(success.msg)
        }
    }

    override fun onError(result: Int, error: Any?) {
        super.onError(result, error)
    }

    private var control: MainModule? = null
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        control = getModule(MainModule::class.java, this)
        control!!.check_version()//检查更新操作
        login_btn.setOnClickListener {
            var name = name_et.text.toString().trim()
            var pwd = pwd_et.text.toString().trim()
            when {
                TextUtils.isEmpty(name) -> toast(getString(R.string.name_is_error))
                TextUtils.isEmpty(pwd) -> toast(getString(R.string.pwd_is_error))
                else -> control!!.login(name, pwd)//登录
            }
        }
    }


    override fun setLayoutId(): Int {
        return R.layout.activity_login
    }
}
