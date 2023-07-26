package pet.ui.des.com.acts

import pet.ui.des.com.BaseActivity
import pet.ui.des.com.databinding.ActivityDyynamicBinding

class DynamicActivity : BaseActivity() {

  private val binding : ActivityDyynamicBinding by lazy { ActivityDyynamicBinding.inflate(layoutInflater) }

  override fun initializeActivity() {

  }

  override fun getCurrentViewBinding() : ActivityDyynamicBinding {
    return binding
  }

}