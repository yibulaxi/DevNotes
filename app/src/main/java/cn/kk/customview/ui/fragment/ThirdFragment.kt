package cn.kk.customview.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.kk.base.adapter.CommentAdapter
import cn.kk.base.bean.CommentModel
import cn.kk.customview.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val names = mutableListOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S")
        val modelList = mutableListOf<CommentModel>()
        var index = 0
        for (name in names) {
            modelList.add(CommentModel(name, "", "content".plus(name), System.currentTimeMillis() + index * 7200, index / 2 == 0 ))
            index ++
        }
        view.findViewById<RecyclerView>(R.id.rv_list).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            /*adapter = object: BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_comment, names){
                override fun convert(holder: BaseViewHolder, item: String) {
                    holder.setText(R.id.tv_nikename, item)
                }
            }*/
            adapter = CommentAdapter(modelList, context)

        }

    }


}