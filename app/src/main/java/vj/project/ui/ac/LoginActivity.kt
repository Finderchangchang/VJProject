package vj.project.ui.ac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import vj.project.R
import vj.project.base.ui.BaseActivity
import vj.project.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_login
    }
}
