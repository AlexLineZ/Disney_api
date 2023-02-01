package ru.cft.shift2023winter.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.cft.shift2023winter.R
import ru.cft.shift2023winter.databinding.ActivityCharactersBinding
import ru.cft.shift2023winter.databinding.ActivityInformationBinding

class InformationActivity : AppCompatActivity() {
    private val binding by lazy { ActivityInformationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.name.text = intent.getIntExtra("findCharacterInformation", 0).toString()


    }

}

