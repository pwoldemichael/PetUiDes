package pet.ui.des.com.bottomsheets

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import pet.ui.des.com.BaseActivity
import pet.ui.des.com.R
import pet.ui.des.com.databinding.BottomsheetSettingsBinding
import pet.ui.des.com.enums.ListOrientation

class RecyclerSettings(var act : BaseActivity , var responce:(ListOrientation)->Unit) : CommonSheet() {

  private lateinit var binding : BottomsheetSettingsBinding
  val TAG = "_ShowRecyclerSettings"

  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    setStyle(DialogFragment.STYLE_NORMAL , R.style.DialogStyle)
  }

  @SuppressLint("RestrictedApi")
  override fun setupDialog(dialog : Dialog , style : Int) {
    val contentView : View = View.inflate(context , R.layout.bottomsheet_settings , null)
    binding = BottomsheetSettingsBinding.bind(contentView)
    dialog.setContentView(contentView)
    (contentView.parent as View).setBackgroundColor(ContextCompat.getColor(requireContext() , android.R.color.transparent))
    customizeBottomSheetBehavior(contentView)
    handleSetting()
  }

  private fun handleSetting() {
    binding.gridrad.setOnCheckedChangeListener { buttonView , isChecked ->
      if(isChecked) responce.invoke(ListOrientation.GRID)
    }

    binding.horizontalrad.setOnCheckedChangeListener { buttonView , isChecked ->
      if(isChecked) responce.invoke(ListOrientation.HORIZONTAL)
    }

    binding.verticalrad.setOnCheckedChangeListener { buttonView , isChecked ->
      if(isChecked) responce.invoke(ListOrientation.VERTICAL)
    }
  }

}