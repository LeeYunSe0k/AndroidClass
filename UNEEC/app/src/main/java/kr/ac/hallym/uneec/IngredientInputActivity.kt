package kr.ac.hallym.uneec

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.hallym.uneec.databinding.ActivityIngredientInputBinding

class IngredientInputActivity : AppCompatActivity() {
    lateinit var binding: ActivityIngredientInputBinding
    lateinit var db: DBHelper
    lateinit var imageData: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIngredientInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = DBHelper(this)

        binding.backButton.setOnClickListener {
            finish()
        }

        // 수업시간에 배운 이미지 호출 사용
        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            try {
                // inSampleSize 비율 계산 지정
                val calRatio = calculateInSampleSize(
                    it.data!!.data!!,
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize)
                )
                imageData = it.data!!.data!! // imageData에 이미지 Uri 저장, 추후 데이터베이스에 넘길 때 사용
                val option = BitmapFactory.Options()
                option.inSampleSize = calRatio

                // 이미지 로딩
                var inputStream = contentResolver.openInputStream(it.data!!.data!!)
                val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
                inputStream!!.close()
                inputStream = null

                bitmap?.let {
                    binding.ingImageView.setImageBitmap(bitmap)
                } ?: let {
                    Log.d("uneec", "bitmap null")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // 이미지뷰 클릭 시 갤러리 호출
        binding.ingImageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }

        // 등록 버튼 클릭 시 각각의 값을 Recipe에 넘기고 데이터베이스에 추가
        binding.inputButton.setOnClickListener {
            val ingName = binding.ingName.text.toString()
            val ingSize = binding.ingSize.text.toString()
            val ingPrice = binding.ingPrice.text.toString()
            val recipe = Ingredient(imageData.toString(),ingName,ingPrice,ingSize) // Uri를 toString()을 통해 String으로 변환하여 넘김

            db.addRecipe(recipe)
            finish()
        }
    }

    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true // 옵션만 설정하고자 true로 지정
        try {
            var inputStream = contentResolver.openInputStream(fileUri)
            BitmapFactory.decodeStream(inputStream, null, options) // 각종 이미지 정보가 옵션에 설정됨
            inputStream!!.close()
            inputStream = null
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1
        // inSampleSize 비율 계산
        if (height > reqHeight || width > reqWidth) {
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2
            while(halfHeight / inSampleSize >= reqHeight &&
                halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }
}