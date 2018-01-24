package vj.project.base.ui;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.arialyy.frame.core.AbsActivity;
import com.arialyy.frame.view.TitleBar;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;

import vj.project.R;
import xyz.bboylin.universialtoast.UniversalToast;

/**
 * Created by lyy on 2016/7/13.
 * https://github.com/AriaLyy/MVVM
 */
public abstract class BaseActivity<VB extends ViewDataBinding> extends AbsActivity<VB> {
    TitleBar title_bar;
    UniversalToast toast;
    public AlertDialog.Builder builder;
    public BaseNiceDialog load_dialog;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        builder = new AlertDialog.Builder(this).setTitle("正在加载...");
        int imageViewId = getResources().getIdentifier("title_bar", "id", getPackageName());
        title_bar = (TitleBar) findViewById(imageViewId);
        if (title_bar != null) {
            title_bar.setLeftClick(new TitleBar.LeftClick() {
                @Override
                public void onClick() {
                    finish();
                }
            });
        }
        load_dialog = NiceDialog.init()
                .setLayoutId(R.layout.loading_layout)
                .setWidth(100)
                .setHeight(100)
                .setDimAmount(0f);
    }


    @Override
    protected void dataCallback(int result, Object data) {

    }

    /**
     * 消息弹出框
     *
     * @param msg 弹出的消息
     */
    public void toast(String msg) {
        toast(msg, 0);
    }

    /**
     * 成功的消息弹出框
     *
     * @param msg 弹出的消息
     */
    public void toast_success(String msg) {
        toast(msg, R.drawable.ic_done_white_24dp);
    }

    /**
     * 错误的消息弹出框
     *
     * @param msg 弹出的消息
     */
    public void toast_error(String msg) {
        toast(msg, R.drawable.ic_clear_white_24dp);
    }

    /**
     * 警示的消息弹出框
     *
     * @param msg 弹出的消息
     */
    public void toast_waring(String msg) {
        toast(msg, R.drawable.ic_error_outline_white_24dp);
    }

    /**
     * 左侧带图标的弹出框
     *
     * @param msg   弹出的消息
     * @param resId 左侧图标id
     */
    public void toast(String msg, int resId) {
        //if (toast == null) {
        toast = UniversalToast.makeText(this, msg, UniversalToast.LENGTH_SHORT);
//        } else {
//            toast.setText(msg);
//        }
        if (resId != 0) {
            toast.setIcon(resId);
            toast.show();
        }
    }
}
