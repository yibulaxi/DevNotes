package cn.kk.customview.fragment

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import cn.kk.base.activity.BaseActivity
import cn.kk.base.fragment.BaseFragment
import cn.kk.customview.R
import cn.kk.customview.activity.arch.JetPackActivity
import cn.kk.customview.activity.arch.MvcActivity
import cn.kk.customview.activity.arch.MvpActivity
import cn.kk.customview.activity.arch.MvvmActivity
import java.util.jar.JarEntry

class ArchFragment: BaseFragment() {
    override fun getLayoutId(): Int {
       return R.layout.fragment_arch
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView.findViewById<CardView>(R.id.card_mvc).setOnClickListener { openMVC() }
        rootView.findViewById<CardView>(R.id.card_mvp).setOnClickListener { openMVP() }
        rootView.findViewById<CardView>(R.id.card_mvvm).setOnClickListener { openMVVM() }
        rootView.findViewById<CardView>(R.id.card_jetpack).setOnClickListener { openJetPack() }
    }

   private fun openMVC(){
      getBaseActivity()?.openNextUI(MvcActivity::class.java, "MVC")
    }

   private fun openMVP(){
      getBaseActivity()?.openNextUI(MvpActivity::class.java, "MVP")
    }

   private fun openMVVM(){
       getBaseActivity()?.openNextUI(MvvmActivity::class.java, "MVVM")
    }

   private fun openJetPack(){
       getBaseActivity()?.openNextUI(JetPackActivity::class.java, "JetPack")
    }

    private fun getBaseActivity(): BaseActivity ?{
        if (activity is BaseActivity) return (activity as BaseActivity)
        return null
    }
}