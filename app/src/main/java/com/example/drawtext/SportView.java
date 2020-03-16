package com.example.drawtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SportView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static float IMAGE_WIDTH = Utils.dp2px(150f);
    private static float OFFSET = Utils.dp2px(150f);

    private static float STROKE_WIDTH = Utils.dp2px(10f);
    String drawStr = "agag";
    // 静态文字边界计算
    Rect bounds = new Rect();

    // 文字的五根基线位置类
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

    // 大段文字
    private String str = "对于言论自由，我们应该设置一些原则性的标准和非原则性空间。比如国家根本性制度是不容置疑的，比如煽动暴力、分裂，散布谣言，制造仇恨等就属于禁止范畴，而对于工作上的不满和批评，理性的探讨等就属于非禁止性范畴。非禁止性范畴，交由大众讨论，出现杂音不足为奇，总体上是向善向好的，是积极的，不仅有助于发现问题，也有利于纠偏，还可以提高国民理性思维能力。在扁平化的社交媒体中，群众的声音往往比某些专家学者的言论更科学更可信，也为有真知灼见的专家提供了广阔的舞台，比如钟南山、李兰娟、胡锡进等人就为群众所津津乐道。" +
            "对于言论自由，我们应该设置一些原则性的标准和非原则性空间。比如国家根本性制度是不容置疑的，比如煽动暴力、分裂，散布谣言，制造仇恨等就属于禁止范畴，而对于工作上的不满和批评，理性的探讨等就属于非禁止性范畴。非禁止性范畴，交由大众讨论，出现杂音不足为奇，总体上是向善向好的，是积极的，不仅有助于发现问题，也有利于纠偏，还可以提高国民理性思维能力。在扁平化的社交媒体中，群众的声音往往比某些专家学者的言论更科学更可信，也为有真知灼见的专家提供了广阔的舞台，比如钟南山、李兰娟、胡锡进等人就为群众所津津乐道。" +
            "对于言论自由，我们应该设置一些原则性的标准和非原则性空间。比如国家根本性制度是不容置疑的，比如煽动暴力、分裂，散布谣言，制造仇恨等就属于禁止范畴，而对于工作上的不满和批评，理性的探讨等就属于非禁止性范畴。非禁止性范畴，交由大众讨论，出现杂音不足为奇，总体上是向善向好的，是积极的，不仅有助于发现问题，也有利于纠偏，还可以提高国民理性思维能力。在扁平化的社交媒体中，群众的声音往往比某些专家学者的言论更科学更可信，也为有真知灼见的专家提供了广阔的舞台，比如钟南山、李兰娟、胡锡进等人就为群众所津津乐道。" +
            "对于言论自由，我们应该设置一些原则性的标准和非原则性空间。比如国家根本性制度是不容置疑的，比如煽动暴力、分裂，散布谣言，制造仇恨等就属于禁止范畴，而对于工作上的不满和批评，理性的探讨等就属于非禁止性范畴。非禁止性范畴，交由大众讨论，出现杂音不足为奇，总体上是向善向好的，是积极的，不仅有助于发现问题，也有利于纠偏，还可以提高国民理性思维能力。在扁平化的社交媒体中，群众的声音往往比某些专家学者的言论更科学更可信，也为有真知灼见的专家提供了广阔的舞台，比如钟南山、李兰娟、胡锡进等人就为群众所津津乐道。" +
            "对于言论自由，我们应该设置一些原则性的标准和非原则性空间。比如国家根本性制度是不容置疑的，比如煽动暴力、分裂，散布谣言，制造仇恨等就属于禁止范畴，而对于工作上的不满和批评，理性的探讨等就属于非禁止性范畴。非禁止性范畴，交由大众讨论，出现杂音不足为奇，总体上是向善向好的，是积极的，不仅有助于发现问题，也有利于纠偏，还可以提高国民理性思维能力。在扁平化的社交媒体中，群众的声音往往比某些专家学者的言论更科学更可信，也为有真知灼见的专家提供了广阔的舞台，比如钟南山、李兰娟、胡锡进等人就为群众所津津乐道。" +
            "对于言论自由，我们应该设置一些原则性的标准和非原则性空间。比如国家根本性制度是不容置疑的，比如煽动暴力、分裂，散布谣言，制造仇恨等就属于禁止范畴，而对于工作上的不满和批评，理性的探讨等就属于非禁止性范畴。非禁止性范畴，交由大众讨论，出现杂音不足为奇，总体上是向善向好的，是积极的，不仅有助于发现问题，也有利于纠偏，还可以提高国民理性思维能力。在扁平化的社交媒体中，群众的声音往往比某些专家学者的言论更科学更可信，也为有真知灼见的专家提供了广阔的舞台，比如钟南山、李兰娟、胡锡进等人就为群众所津津乐道。" +
            "对于言论自由，我们应该设置一些原则性的标准和非原则性空间。比如国家根本性制度是不容置疑的，比如煽动暴力、分裂，散布谣言，制造仇恨等就属于禁止范畴，而对于工作上的不满和批评，理性的探讨等就属于非禁止性范畴。非禁止性范畴，交由大众讨论，出现杂音不足为奇，总体上是向善向好的，是积极的，不仅有助于发现问题，也有利于纠偏，还可以提高国民理性思维能力。在扁平化的社交媒体中，群众的声音往往比某些专家学者的言论更科学更可信，也为有真知灼见的专家提供了广阔的舞台，比如钟南山、李兰娟、胡锡进等人就为群众所津津乐道。";
    private TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    /**
     * 写一个长度数组
     */
    float[] cutWidth = new float[1];

    Bitmap bitmap;
    {
        paint.setTextSize(Utils.dp2px(15));
        bitmap = Utils.getAvatar(getResources(), (int)Utils.dp2px(150));
    }

    public SportView(Context context) {
        super(context);
    }

    public SportView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        /**
         * 文字为什么要dp呢？
         * ScalePix 经过放缩的像素 有全局影响的
         * 因为跟需求无关
         */
//        paint.setTextSize(Utils.dp2px(15));
        /**
         * 设置字体
         */
//        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), ".ttr"));
//        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制环
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.GRAY);
//        paint.setStrokeWidth(STROKE_WIDTH);
//        canvas.drawCircle(getWidth() / 2f, getHeight() / 2f, RADIUS, paint);

        // 绘制进度条
//        paint.setColor(Color.GREEN);
//        paint.setStrokeCap(Paint.Cap.ROUND);    // 圆的头
//        canvas.drawArc(getWidth() / 2f - RADIUS,
//                getHeight() / 2f - RADIUS,
//                getWidth() / 2f + RADIUS,
//                getHeight() / 2f + RADIUS, -90, 225, false, paint);
//        paint.setStrokeCap(Paint.Cap.BUTT);
//
//        paint.setStyle(Paint.Style.FILL);

        /**
         * 为什么不会局中呢？不是我们想要的效果怎么办呢？？？
         * 首先获取到文字的边界
         * 然后算出来上下边界的中间值
         * 最后减去这个中间值即可
         * 这种方法适合静态文字，但是不适合动态文字
         * 什么叫动态文字？
         * 就是边界中心点的位置会变，那么效果就不好，乱跳怎么办呢？？？
         * 这就需要另外一种方式了，相对局中方式
         * 五根线
         */
        // 静态文字位置计算
//        paint.getTextBounds(drawStr, 0, drawStr.length(), bounds);
//        int offset = (bounds.top + bounds.bottom) / 2;

        // 动态文字位置计算 通过计算文字中间的两根最重要的中位线 来确定位置即可
//        paint.getFontMetrics(fontMetrics);
//        float offset2 = (fontMetrics.descent + fontMetrics.ascent) / 2;
//        canvas.drawText(drawStr, getWidth() / 2f, getHeight() / 2f - offset2, paint);

        /**
         * 贴顶部
         * 1：设置画笔
         * 2：画
         * 3：发现位置不对
         * 4：挪出来，需要做一个合适的偏移
         * 5：把y设置为负的文字边界的顶部
         */
//        paint.setTextAlign(Paint.Align.LEFT);
//        canvas.drawText(drawStr, 0, -bounds.top, paint);

        /**
         * 贴左边
         * 1：设置画笔
         * 2：画
         * 3：发现位置不对
         * 4：挪出来，需要做一个合适的偏移
         * 5：把y设置为负的文字边界的顶部
         */
//        paint.setTextAlign(Paint.Align.LEFT);
//        canvas.drawText(drawStr, 0, -bounds.top, paint);

        /**
         * 绘制大段文字+图片
         * StaticLayout 大段文字绘制工具
         */
//        StaticLayout staticLayout = new StaticLayout(str, textPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL,
//                1, 0, false);
//        staticLayout.draw(canvas);

        /**
         * 1：绘制图片
         * 2：绘制文字不能盖住图片
         * 3：需要一行行绘制
         */
        canvas.drawBitmap(bitmap, getWidth() - IMAGE_WIDTH, OFFSET, paint);

        /**
         * 绘制图文
         * 1：先绘制一行
         * start: 从左向右
         * 2：一行一行绘制，一行行计算
         * 3：使用for循环来计算并绘制
         */
//        int count = paint.breakText(str, true, getWidth(), cutWidth);
//        canvas.drawText(str, 0, count, 0, paint.getFontSpacing(), paint);
        int length = str.length();
        /**
         * 每一行的偏移量
         */
        float fontSpacing = paint.getFontSpacing();
        float verticalOffset = fontSpacing;
        for (int start = 0, count; start < length; start += count, verticalOffset += fontSpacing) {
            /**
             * 1：根据每一行的宽度来计算文字的长度
             * 2：动态计算宽度，要考虑到图片
             * 3：要计算文字在不在图片的纵向高度内
             * 4：获取每一行文字的顶部和底部
             * 5：判断文字在不在图片内部，如果在，文字的可用宽度则等于宽度减去图片宽度，反之，文字宽度等于画布宽度
             */
            float usableWidth;
            float textTop = verticalOffset + fontMetrics.top;
            float textBottom = verticalOffset + fontMetrics.bottom;
            if (textTop > OFFSET && textTop < (OFFSET + IMAGE_WIDTH) || textBottom < (IMAGE_WIDTH + OFFSET) && textBottom > OFFSET) {
                usableWidth = getWidth() - IMAGE_WIDTH;
            } else {
                usableWidth = getWidth();
            }
            /**
             * 计算
             */
            count = paint.breakText(str, start, length, true, usableWidth, cutWidth);
            /**
             * 绘制
             */
            canvas.drawText(str, start, start + count, 0, verticalOffset, paint);
        }
    }
}
