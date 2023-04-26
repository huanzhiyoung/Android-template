package cn.dream.materialsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.dream.materialsample.databinding.ActivityMainBinding
import cn.dream.materialsample.material.MaterialButtonActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        initView()
    }

    private fun initView() {
        val materialListAdapter = MaterialListAdapter()
        binding.rvMaterialList.adapter = materialListAdapter
        val materialList = arrayListOf(MATERIAL_BUTTON)
        materialListAdapter.submitList(materialList)
        materialListAdapter.setOnItemClickListener { adapter, _, position ->
            when (adapter.getItem(position)) {
                MATERIAL_BUTTON -> {
                    startActivity(Intent(this, MaterialButtonActivity::class.java))
                }
            }
        }
    }

    companion object {
        private const val MATERIAL_BUTTON = "material button"
    }

    class MaterialListAdapter : BaseQuickAdapter<String, QuickViewHolder>() {

        override fun onCreateViewHolder(
            context: Context,
            parent: ViewGroup,
            viewType: Int
        ): QuickViewHolder {
            // 返回一个 ViewHolder
            return QuickViewHolder(android.R.layout.simple_list_item_1, parent)
        }

        override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: String?) {
            // 设置item数据
            val tvMaterialElement = holder.getView<TextView>(android.R.id.text1)
            tvMaterialElement.text = item
        }

    }

}