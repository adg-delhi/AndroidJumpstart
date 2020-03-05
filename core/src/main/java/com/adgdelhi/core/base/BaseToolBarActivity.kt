package com.adgdelhi.core.base

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.widget.FrameLayout
import com.adgdelhi.core.R
import com.adgdelhi.core.base.BaseActivity

abstract class BaseToolBarActivity : BaseActivity() {

    private var contentFrame: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base_toolbar)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        contentFrame = findViewById(R.id.activity_content)
    }

    override fun setContentView(layoutResId: Int) {
        layoutInflater.inflate(layoutResId, contentFrame, true)
    }
}
