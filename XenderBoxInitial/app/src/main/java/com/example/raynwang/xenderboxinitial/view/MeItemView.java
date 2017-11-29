package com.example.raynwang.xenderboxinitial.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.raynwang.xenderboxinitial.R;

/**
 * Created by raynwang on 2017/11/9.
 */

public class MeItemView extends RelativeLayout{
    public static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";

    private ImageView ivImage;
    private TextView tvTitle;

    public MeItemView(Context context) {
        this(context,null);
    }

    public MeItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化布局
        initView();
        //初始化文字和图片的显示
        initAttrs(attrs);
    }
    /**
     * @param attrs  属性集合
     *                 获取在布局文件中定义出来的额自定义的额属性值,
     *                 用于初始化属性值,用于控制文本的显示,和图片的显示
     */
    private void initAttrs(AttributeSet attrs) {
        //获取自定义属性中 ,类型为

        String title = attrs.getAttributeValue(NAMESPACE, "title");

        tvTitle.setText(title);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.meItemView);

        Drawable d = typedArray.getDrawable(R.styleable.meItemView_icon);
        if (d!=null){
            setImageDrawable(d);
        }
    }

    //初始化试图
    private void initView() {
        View view = View.inflate(getContext(), R.layout.me_item_view, null);
        addView(view);
        ivImage = (ImageView) view.findViewById(R.id.iv_me_item_icon);
        tvTitle = (TextView) view.findViewById(R.id.tv_me_item_title);
    }

    public void setImageDrawable(Drawable imageDrawable) {
        ivImage.setImageDrawable(imageDrawable);
    }
}
