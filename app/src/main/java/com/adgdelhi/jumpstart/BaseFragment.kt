package com.adgdelhi.jumpstart

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.adgdelhi.jumpstart.utils.fragmenttransactionhandler.FragmentTransactionHandler

abstract class BaseFragment : Fragment() {

    lateinit var handler: FragmentTransactionHandler
        protected set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handler = FragmentTransactionHandler()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //enabling toolbar to have menu items in fragment
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        handler.setActivity(activity)
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
}
