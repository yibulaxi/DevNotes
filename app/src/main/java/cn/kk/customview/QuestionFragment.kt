package cn.kk.customview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cn.kk.customview.adpater.ListAdapter
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment(val value: String) : Fragment() {

    var topStateCallback: TopStateCallback?=null
    var isTop = true
    lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_question, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val answer = rootView.findViewById<TextView>(R.id.tv_answer)

        progressBar.postDelayed({
            progressBar.hide()
            answer.text = value
        }, 1500)

        // 模拟初始化数据
        val itemList = mutableListOf<String>()
        for (index in 0..25){
            itemList.add(index.toString())
        }
        rvList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvList.adapter = ListAdapter(itemList)
        rvList.isNestedScrollingEnabled = false

        scrollViewContainer.viewTreeObserver.addOnScrollChangedListener {

        }

        topStateCallback?.onTop()
        scrollViewContainer.setOnScrollChangeListener {
                v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            Log.d("QuestionFragment", "onActivityCreated: scrollY= $scrollY")
            if (scrollY == 0){
                isTop = true
                topStateCallback?.onTop()
            } else {
                if (isTop){
                    isTop = false
                    topStateCallback?.onNotTop()
                }
            }
        }

    }

    interface TopStateCallback{
        fun onTop()

        fun onNotTop()
    }
}