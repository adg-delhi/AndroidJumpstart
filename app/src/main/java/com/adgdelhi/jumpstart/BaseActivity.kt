package com.adgdelhi.jumpstart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.FrameLayout
import com.adgdelhi.jumpstart.R
import com.adgdelhi.jumpstart.dialogs.LoadingDialog
import com.adgdelhi.jumpstart.utils.fragmenttransactionhandler.FragmentTransactionHandler

/**
 * Created by shishank
 * on 08/01/16.
 */
abstract class BaseActivity : AppCompatActivity() {

    private var contentFrame: FrameLayout? = null

    protected lateinit var handler: FragmentTransactionHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base)

        contentFrame = findViewById(R.id.base_container)
        handler = FragmentTransactionHandler()
    }

    override fun setContentView(layoutResId: Int) {
        layoutInflater.inflate(layoutResId, contentFrame, true)
    }

    override fun onResume() {
        super.onResume()
        handler.setActivity(this)
        handler.resume()
    }

    override fun onPause() {
        super.onPause()
        handler.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.setActivity(null)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun dismissLoadingDialogWithHandler(dialog: LoadingDialog) {
        val msg = handler.obtainMessage(FragmentTransactionHandler.LOADING_DIALOG_DISMISS_MSG,
                dialog)
        handler.sendMessage(msg)
    }

}
