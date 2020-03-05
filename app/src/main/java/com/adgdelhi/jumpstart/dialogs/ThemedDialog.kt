package com.adgdelhi.jumpstart.dialogs

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.adgdelhi.jumpstart.databinding.FragmentThemedDialogBinding

/**
 * A themed dialog which should be styled as per your choice
 */
open class ThemedDialog : DialogFragment() {

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
        arguments?.let {
            with(binding) {
                messageTv.text = it.getString(KEY_MESSAGE)
                titleTv.text = it.getString(KEY_TITLE)
                negativeBtn.visibility = View.GONE
                button = it.getBoolean(KEY_SHOW_CANCEL_BUTTON)
                if (button) {
                    negativeBtn.visibility = View.VISIBLE
                }

                if (TextUtils.isEmpty(it.getString(KEY_POSITIVE_BUTTON_TEXT))) {
                    positiveBtn.text = getString(android.R.string.ok)
                } else {
                    positiveBtn.text = it.getString(KEY_POSITIVE_BUTTON_TEXT)
                }

                positiveBtn.setOnClickListener { view -> onClickOk(view) }
                negativeBtn.setOnClickListener { onClickCancel() }
            }
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
                        negativeText: String, cancelButton: Boolean): ThemedDialog {
            val bundle = createBundle(title, message, positiveText, negativeText, cancelButton)
            val dialog = ThemedDialog()
            dialog.arguments = bundle
            return dialog
        }

        protected fun createBundle(title: String, message: String,
                                   positiveButtonText: String, negativeButtonText: String,
                                   cancelButton: Boolean): Bundle {
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