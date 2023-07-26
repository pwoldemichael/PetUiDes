package pet.ui.des.com.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

/**
 * copyright Pi Softwares
 * Created by Petros Woldemichael
 * on 25,07,2023
 * USA, MD
 */
class CustomDialog : DialogFragment() {

  var mNum = 0

  // private constructor(var c : Context , var message : String , var responce : (String) -> Unit)
  companion object {

    fun newInstance(num : Int) : CustomDialog {
      val f = CustomDialog()
      val args = Bundle()
      args.putInt("num" , num)
      f.arguments = args
      return f
    }
  }

  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    // Pick a style based on the num.
    // this fragment will be displayed in a dialog
    showsDialog = true
  }

  override fun onCreateView(inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?) : View? {
    return inflater.inflate(pet.ui.des.com.R.layout.custom_dialog_view , container , false)
  }

  override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
    super.onViewCreated(view , savedInstanceState)
    getDialog()?.setTitle("Dialog #")
  }

  /*var dialog = Dialog(c)
  private lateinit var binding : CustomDialogViewBinding

  init {
    binding = CustomDialogViewBinding.inflate(dialog.layoutInflater)
    dialog.setContentView(R.layout.custom_dialog_view)
    dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT)
    dialog.setCancelable(true)
    //dialog.window?.attributes?.windowAnimations = R.style.animation;
    binding.message.set(message)
    binding.imageView.setOnClickListener {
      dialog.dismiss()
    }
    binding.textView.setOnClickListener {
      responce.invoke("")
      dialog.dismiss()
    }
  }

  fun show() : CustomDialog {
    if(dialog != null) {
      dialog.show()
    }
    return this
  }

  fun dismmiss() : CustomDialog {
    if(dialog != null) {
      dialog.dismiss()
    }
    return this
  }*/
}