package com.example.drawtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CameraView extends View {

    private static float IMAGE_WIDTH = Utils.dp2px(200f);
    private static float OFFSET = Utils.dp2px(100f);

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Camera camera = new Camera();

    Bitmap bitmap;
    {
        bitmap = Utils.getAvatar(getResources(), (int)IMAGE_WIDTH);

        /**
         * 使用Camera使图片绕着x轴旋转30度
         */
        camera.rotateX(30);

        /**
         * 设置Camera的位置
         * -8指的是8英寸 72个像素
         * -8 = 8 * 72 = 576像素
         * 后面乘以像素比则可以是不同像素密度的手机实现相同的翻转效果
         */
        camera.setLocation(0, 0, Utils.getZForCamera());
    }

    public CameraView(Context context) {
        super(context);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 切出来1/4的图片
         */
//        canvas.clipRect(0, 0, OFFSET + IMAGE_WIDTH / 2, OFFSET + IMAGE_WIDTH / 2);

        /**
         * 使用Camera搞出三维坐标系
         * 应用到Canvas上面
         * 先移动Canvas至原点
         * camera完毕，再移动回去即可
         */
        canvas.translate(OFFSET + IMAGE_WIDTH / 2f, OFFSET + IMAGE_WIDTH / 2f);
        camera.applyToCanvas(canvas);

        /**
         * 转起来之前切割
         */
        canvas.clipRect(- IMAGE_WIDTH / 2f, 0, IMAGE_WIDTH / 2f, IMAGE_WIDTH / 2f);
        canvas.translate(-(OFFSET + IMAGE_WIDTH / 2f), -(OFFSET + IMAGE_WIDTH / 2f));

        /**
         * 绘制图片
         */
        canvas.drawBitmap(bitmap, OFFSET, OFFSET, paint);

    }
}
