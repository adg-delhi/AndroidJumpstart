package com.adgdelhi.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.FrameLayout
import com.adgdelhi.core.R

/**
 * Created by shishank
 * on 08/01/16.
 */
abstract class BaseActivity : AppCompatActivity() {

    private var contentFrame: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base)

        contentFrame = findViewById(R.id.base_container)
    }

    override fun setContentView(layoutResId: Int) {
        layoutInflater.inflate(layoutResId, contentFrame, true)
    }
}
