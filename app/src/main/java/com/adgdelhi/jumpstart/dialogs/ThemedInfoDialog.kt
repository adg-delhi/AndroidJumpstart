package com.adgdelhi.jumpstart.dialogs

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.adgdelhi.jumpstart.databinding.FragmentThemedDialogBinding

/**
 * Created by viveksingh
 * on 18/01/16.
 */
class ThemedInfoDialog : DialogFragment() {

    var okListener: View.OnClickListener? = null
    var button: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Applying the theme
        isCancelable = true
    }

    private lateinit var binding: FragmentThemedDialogBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentThemedDialogBinding.inflate(inflater)

        dialog?.setCanceledOnTouchOutside(true)
        val args = arguments
        with(binding) {
            tvMessage.text = args!!.getString(KEY_MESSAGE)
            tvTitle.text = args.getString(KEY_TITLE)
            btnNo.visibility = View.GONE
            button = args.getBoolean(KEY_SHOW_CANCEL_BUTTON)
            if (button) {
                btnNo.visibility = View.VISIBLE
            }

            if (TextUtils.isEmpty(args.getString(KEY_POSITIVE_BUTTON_TEXT))) {
                btnOk.text = getString(android.R.string.ok)
            } else {
                btnOk.text = args.getString(KEY_POSITIVE_BUTTON_TEXT)
            }

            btnOk.setOnClickListener { onClickOk(it) }
            btnNo.setOnClickListener { onClickCancel() }
        }


        return binding.root
    }

    private fun onClickOk(view: View) {
        dismiss()
        if (okListener != null) {
            okListener!!.onClick(view)
        }
    }

    fun onClickCancel() {
        dismiss()
    }

    companion object {

        private val KEY_MESSAGE = "message"
        private val KEY_TITLE = "title"
        private val KEY_POSITIVE_BUTTON_TEXT = "positive_button_text"
        private val KEY_NEGATIVE_BUTTON_TEXT = "negative_button_text"
        private val KEY_SHOW_CANCEL_BUTTON = "show_cancel_button"


        fun newInstance(title: String, message: String, positiveText: String,
                        negativeText: String, cancelButton: Boolean): ThemedInfoDialog {
            val bundle = createBundle(title, message, positiveText, negativeText, cancelButton)
            val dialog = ThemedInfoDialog()
            dialog.arguments = bundle
            return dialog
        }

        protected fun createBundle(title: String, message: String,
                                   positiveButtonText: String, negativeButtonText: String, cancelButton: Boolean): Bundle {
            val args = Bundle()
            args.putString(KEY_MESSAGE, message)
            args.putString(KEY_TITLE, title)
            args.putString(KEY_POSITIVE_BUTTON_TEXT, positiveButtonText)
            args.putString(KEY_NEGATIVE_BUTTON_TEXT, negativeButtonText)
            args.putBoolean(KEY_SHOW_CANCEL_BUTTON, cancelButton)

            return args
        }
    }
}