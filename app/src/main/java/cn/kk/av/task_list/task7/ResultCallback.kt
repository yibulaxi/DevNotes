package cn.kk.av.task_list.task7

interface ResultCallback {

    fun onSuccess(res: String)
    fun onError(err: String)
}