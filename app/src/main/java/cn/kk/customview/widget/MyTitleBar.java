package cn.kk.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.kk.customview.R;

/**
 * 项目: CustomView
 * 类描述: 自定义组合控件
 * 创建人: kk
 * 创建时间: 3/22/21
 */
public class MyTitleBar extends RelativeLayout {
    private static final int DEFAULT_BG_COLOR = Color.GRAY;
    private static final int DEFAULT_TEXT_COLOR = Color.WHITE;
    private int mColor;
    private int mTextColor;
    private String mTitleName;

    private RelativeLayout rootView;
    private ImageView ivTitleBarLeft;
    private ImageView ivTitleBarRight;
    private TextView tvTitleText;

    public MyTitleBar(Context context) {
        super(context);
        initView(context);
    }

    public MyTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获取自定义属性
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.MyTitleBar);
        mColor = mTypedArray.getColor(R.styleable.MyTitleBar_title_bg_color,DEFAULT_BG_COLOR);
        mTextColor = mTypedArray.getColor(R.styleable.MyTitleBar_title_text_color,DEFAULT_TEXT_COLOR);
        mTitleName = mTypedArray.getString(R.styleable.MyTitleBar_title_text);

        mTypedArray.recycle();

        initView(context);
    }

    public MyTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化操作
     * @param context
     */
    private void initView(Context context) {

        // 将布局填充进来
        LayoutInflater.from(context).inflate(R.layout.my_titlebar, this, true);

        // 初始化控件
        rootView = findViewById(R.id.titlebar_root);
        ivTitleBarLeft = findViewById(R.id.iv_titlebar_left);
        ivTitleBarRight = findViewById(R.id.iv_titlebar_right);
        tvTitleText = findViewById(R.id.tv_titlebar_title);

        // 设置颜色
        rootView.setBackgroundColor(mColor);
        tvTitleText.setTextColor(mTextColor);

//        tvTitleText.setTextSize(30);
        tvTitleText.setText(mTitleName);
    }

    /**
     * 设置标题颜色
     *
     * @param titleName
     */
    public void setTitle(String titleName) {
        if (!TextUtils.isEmpty(titleName)) {
            mTitleName = titleName;
            tvTitleText.setText(titleName);
        }
    }

    /**
     * 设置点击事件
     * @param leftListener
     */
    public void setLeftListener(OnClickListener leftListener) {
        ivTitleBarLeft.setOnClickListener(leftListener);
    }

    public void setRightListener(OnClickListener listener) {
        ivTitleBarRight.setOnClickListener(listener);
    }

}
