package cn.zhaoliang5156.simplejokeclient.net

/**
 * Created by zhaoliang on 2018/5/13.
 * joke 数据模型
 * version 1.0
 */

// 文本笑话响应模型类
class TextResponse(
        var showapi_res_body: TextResponseBody,
        var showapi_res_code: Int,
        var showapi_res_error: String
) {
    override fun toString(): String {
        return "Response(showapi_res_body='$showapi_res_body', showapi_res_code=$showapi_res_code, showapi_res_error='$showapi_res_error')"
    }
}

// 文本笑话响应体模型类
class TextResponseBody(
        var totalNum: Int,
        var ret_code: Int,
        var list: ArrayList<TextJoke>
)

// 文本笑话模型类
class TextJoke(
        var title: String,
        var content: String
) {
    override fun toString(): String {
        return "TextJoke(title='$title', content='$content')"
    }
}

// 文本笑话响应模型类
class ImageResponse(
        var showapi_res_body: ImageResponseBody,
        var showapi_res_code: Int,
        var showapi_res_error: String
) {
    override fun toString(): String {
        return "Response(showapi_res_body='$showapi_res_body', showapi_res_code=$showapi_res_code, showapi_res_error='$showapi_res_error')"
    }
}

// 文本笑话响应体模型类
class ImageResponseBody(
        var totalNum: Int,
        var ret_code: Int,
        var list: ArrayList<ImageJoke>
)

// 图片笑话模型类
class ImageJoke(
        var title: String,
        var sourceurl: String
) {
    override fun toString(): String {
        return "ImageJoke(title='$title', sourceurl='$sourceurl')"
    }
}