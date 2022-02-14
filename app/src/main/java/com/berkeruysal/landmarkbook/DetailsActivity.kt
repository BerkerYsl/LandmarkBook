package com.berkeruysal.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berkeruysal.landmarkbook.databinding.ActivityDetailsBinding
import com.berkeruysal.landmarkbook.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var intent=intent
        //Casting işlemi yaptık çünkü dönen değer serializable olduğu için property'lere erişemedik
        var getProp=intent.getSerializableExtra("landmark") as Landmark
        binding.countryText.text=getProp.countryName
        binding.nameText.text=getProp.name
        binding.imageView.setImageResource(getProp.image!!)
    }
}