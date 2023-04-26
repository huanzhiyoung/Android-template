package com.example.image

import android.graphics.BitmapFactory
import android.graphics.Rect
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.image.databinding.ActivityMainBinding
import com.theartofdev.edmodo.cropper.CropImageView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.cropImageView.apply {
//            setAspectRatio(5, 10)
//            setFixedAspectRatio(true)
            guidelines = CropImageView.Guidelines.ON
//            cropShape = CropImageView.CropShape.OVAL
            scaleType = CropImageView.ScaleType.FIT_CENTER
            isAutoZoomEnabled = true
//            isShowProgressBar = true
            setImageBitmap(BitmapFactory.decodeResource(resources, R.mipmap.ic_keep_answer_bg))
            cropRect = Rect(0, 0, binding.ivTarget.width , binding.ivTarget.height)
            setOnCropImageCompleteListener(object : CropImageView.OnCropImageCompleteListener {
                override fun onCropImageComplete(
                    view: CropImageView?,
                    result: CropImageView.CropResult?
                ) {
                    result?.let {
                        binding.ivResult1.setImageBitmap(it.originalBitmap)
                        binding.ivResult2.setImageBitmap(it.bitmap)
                        binding.ivResult3.setImageURI(it.uri)
                    }
                }

            })
        }
        initListener()
    }

    private fun initListener() {
        binding.btnCrop.setOnClickListener {
            val croppedImage = binding.cropImageView.croppedImage
            binding.ivResult3.setImageBitmap(croppedImage)
        }
    }
}