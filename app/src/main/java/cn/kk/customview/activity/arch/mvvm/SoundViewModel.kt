package cn.kk.customview.activity.arch.mvvm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * 视图模型类
 *
 * 功能：让视图模型和布局文件沟通起来。需要三个步骤：
 * 1. 继承 BaseObservable 类
 * 2. 使用 @Bindable 注解可绑定的属性
 * 3. 每次可绑定的属性值改变时，就调用 notifyChange() 或者 notifyPropertyChanged(fieldId)
 *
 * 关于 notifyPropertyChanged(fieldId)
 * 比如：notifyPropertyChanged(BR.title)
 *  - 其中 BR.title 是数据绑定库生成的一个常量
 *  - BR: binding resource
 *  - 使用 @Bindable 注解的属性都会有一个同名 BR 常量
 */
class SoundViewModel(private val beatBox: BeatBox): BaseObservable() {

    var sound: Sound? = null
        set(sound){
            field = sound
            notifyChange()
        }

    @get: Bindable
    val title: String ?
        get() = sound?.name

    // region functions
    fun onButtonClicked() {
        sound?.let {
            beatBox.play(it)
        }
    }

    // endregion
}