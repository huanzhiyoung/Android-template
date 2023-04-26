package com.example.span;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 该项目用于测试span
 * 参考资料：https://developer.android.google.cn/guide/topics/text/spans?hl=zh-cn#java
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvSpan1;
    private TextView tvSpan2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        testSpan1();
        testSpan2();
    }

    private void initView() {
        tvSpan1 = findViewById(R.id.tvSpan1);
        tvSpan2 = findViewById(R.id.tvSpan2);
    }

    private void testSpan1() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tvSpan1.getText().toString());
        spannableStringBuilder.setSpan(
                new ForegroundColorSpan(Color.RED),
                6,
                8,
                //SPAN_EXCLUSIVE_INCLUSIVE 往span的开始前面添加文字等其他不会变色，但是往span的结束后面添加文字会变色
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        );
        spannableStringBuilder.insert(6, "哈哈哈哈哈");
        spannableStringBuilder.insert(8, "hhhh");
        tvSpan1.setText(spannableStringBuilder);
    }

    /**
     * 多个span
     */
    private void testSpan2() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tvSpan2.getText().toString());
        spannableStringBuilder.setSpan(
                new ForegroundColorSpan(Color.RED),
                6,
                8,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        );
        spannableStringBuilder.setSpan(
                new StyleSpan(Typeface.BOLD),
                6,
                spannableStringBuilder.length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        );
        tvSpan2.setText(spannableStringBuilder);
    }

    private void testSpan3() {
        BulletSpan bulletSpan = new BulletSpan();
    }
}