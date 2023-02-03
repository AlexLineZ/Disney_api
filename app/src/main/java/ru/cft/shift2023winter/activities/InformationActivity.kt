package ru.cft.shift2023winter.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
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
        var id = intent.getIntExtra("findCharacterInformation", 0)

        GlobalScope.launch(Dispatchers.IO) {
            val response = DisneyAPI().getCharacterById(id)
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    val info = response.body()!!
                    binding.name.text = info.name
                    binding.films.text = remove(info.films.toString())
                    binding.shortfilms.text = remove(info.shortFilms.toString())
                    binding.tvshows.text = remove(info.tvShows.toString())
                    binding.parks.text = remove(info.parkAttractions.toString())
                    binding.allies.text = remove(info.allies.toString())
                    binding.enemies.text = remove(info.enemies.toString())
                }
            }
        }
    }

    fun remove(str: String): String{
        var str2 = str.substring(1, str.length - 1)
        return if (str2 == ""){
            "Nothing"
        } else {
            str2
        }
    }
}


