package cn.kk.base.bean

/**
 * 评论数据
 */
class CommentModel(val name: String, val avatarPath: String, val content: String, val time: Long, var like: Boolean) {
}