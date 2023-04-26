package cn.dream.materialsample.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.dream.materialsample.R
import cn.dream.materialsample.databinding.ActivityMaterialButtonBinding

class MaterialButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMaterialButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_material_button
        )
    }

}