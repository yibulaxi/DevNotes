package cn.kk.customview.ui.system.material

import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R

class MaterialActivity: BaseActivity() {
    override fun getLayout(): Int {
      return  R.layout.activity_material
    }

    override fun getItemNameList(): MutableList<String> {
        return mutableListOf<String>().apply {
            add("CardView")
        }
    }

    override fun setListViewID(): Int {
        return R.id.rv_list
    }

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()
    }

    override fun initAdapter() {
        super.initAdapter()

        listAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0 -> openNextUI(CardViewActivity::class.java, "CardView")
            }
        }
    }

}