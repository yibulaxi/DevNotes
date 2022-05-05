package cn.kk.customview.bean

import java.io.Serializable

class ItemChapterModel(val title: String, val sections: MutableList<ItemSectionModel>,val bookType: Int = 0): Serializable{


}