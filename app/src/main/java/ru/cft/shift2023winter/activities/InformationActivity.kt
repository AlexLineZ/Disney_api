package ru.cft.shift2023winter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.cft.shift2023winter.R
import ru.cft.shift2023winter.databinding.ActivityCharactersBinding

class InformationActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCharactersBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

    }
}

