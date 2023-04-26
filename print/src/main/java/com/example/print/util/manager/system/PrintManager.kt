package com.example.print.util.manager.system

import android.app.Activity
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PageRange
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintManager
import androidx.print.PrintHelper

/**
 * Android系统打印机管理
 *
 * @author       yzh
 * @date         2023/3/18 14:25
 * @reference    https://developer.android.com/training/printing/custom-docs?hl=zh-cn#java
 */
object PrintManager {

    /**
     *  打印图片
     */
    fun doPhotoPrint(activity: Activity, drawableId: Int, jobName: String) {
        val printHelper = PrintHelper(activity)
        printHelper.apply {
            scaleMode = PrintHelper.SCALE_MODE_FILL
        }
        val bitmap = BitmapFactory.decodeResource(activity.resources, drawableId)
        printHelper.printBitmap(jobName, bitmap)
    }

    /**
     *  打印文档
     */
    fun doDocumentPrint(activity: Activity, jobName: String) {
        val printManager = activity.getSystemService(Context.PRINT_SERVICE) as PrintManager
    }

    class MyPrintDocumentAdapter : PrintDocumentAdapter() {

        /**
         *  每当用户更改影响输出的打印设置（例如不同的页面大小或页面方向）时调用，
         *  让应用有机会计算要打印的页面的布局。此方法至少必须返回打印文档预期的页数。
         *  执行 onLayout() 方法可能会产生三种结果：完成、取消或失败（在无法完成布局计算的情况下）
         *  onLayout() 的主要工作是根据打印机的属性计算预计输出的页数。计算此数字的方式在很大程度上取决于应用的打印页面布局
         */
        override fun onLayout(
            oldAttributes: PrintAttributes?,
            newAttributes: PrintAttributes?,
            cancellationSignal: CancellationSignal?,
            callback: LayoutResultCallback?,
            extras: Bundle?
        ) {
            TODO("Not yet implemented")
        }

        /**
         *  调用它来将打印的页面呈现为要打印的文件。在每次调用 onLayout() 之后，可能调用此方法一次或多次。
         */
        override fun onWrite(
            pages: Array<out PageRange>?,
            destination: ParcelFileDescriptor?,
            cancellationSignal: CancellationSignal?,
            callback: WriteResultCallback?
        ) {
            TODO("Not yet implemented")
        }

    }
}