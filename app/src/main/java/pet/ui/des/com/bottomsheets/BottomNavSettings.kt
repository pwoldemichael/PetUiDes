package pet.ui.des.com.bottomsheets

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import pet.ui.des.com.BaseActivity
import pet.ui.des.com.R
import pet.ui.des.com.databinding.BottomsheetBottomnavSettingBinding
import pet.ui.des.com.databinding.BottomsheetSettingsBinding
import pet.ui.des.com.enums.ListOrientation

/**
 * copyright Pi Softwares
 * Created by Petros Woldemichael
 * on 26,07,2023
 * USA, MD
 */
class BottomNavSettings(var current:ListOrientation, var act : BaseActivity , var responce:(ListOrientation)->Unit) : CommonSheet()  {

  private lateinit var binding : BottomsheetBottomnavSettingBinding

  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    setStyle(DialogFragment.STYLE_NORMAL , R.style.DialogStyle)
  }


  @SuppressLint("RestrictedApi")
  override fun setupDialog(dialog : Dialog , style : Int) {
    val contentView : View = View.inflate(context , R.layout.bottomsheet_bottomnav_setting , null)
    binding = BottomsheetBottomnavSettingBinding.bind(contentView)
    dialog.setContentView(contentView)
    (contentView.parent as View).setBackgroundColor(ContextCompat.getColor(requireContext() , android.R.color.transparent))
    customizeBottomSheetBehavior(contentView)
    handleSetting()
  }

  private fun handleSetting() {

    if(current==ListOrientation.VERTICAL)
      binding.center.isChecked = true
    else binding.end.isChecked = true


    binding.center.setOnCheckedChangeListener { buttonView , isChecked ->
      if(isChecked) {
        responce.invoke(ListOrientation.VERTICAL)
        dismiss()
      }
    }

    binding.end.setOnCheckedChangeListener { buttonView , isChecked ->
      if(isChecked) {
        responce.invoke(ListOrientation.HORIZONTAL)
        dismiss()
      }
    }
  }
}