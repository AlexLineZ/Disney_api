package ru.cft.shift2023winter.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.cft.shift2023winter.CharacterModel
import ru.cft.shift2023winter.adapter.CharacterAdapter
import ru.cft.shift2023winter.databinding.ActivityInformationBinding
import ru.cft.shift2023winter.interfaces.DisneyAPI
import java.net.URL

class InformationActivity : AppCompatActivity() {
    private val binding by lazy { ActivityInformationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var nowId = intent.getIntExtra("findCharacterInformation", 0)

    }
}


