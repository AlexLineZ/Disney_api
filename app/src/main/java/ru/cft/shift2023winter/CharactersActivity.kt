package ru.cft.shift2023winter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import ru.cft.shift2023winter.databinding.ActivityCharactersBinding

class CharactersActivity : AppCompatActivity(){
    private val binding by lazy {ActivityCharactersBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {
            var response = DisneyAPI().getListOfCharacter()
            if (response.isSuccessful){
                withContext(Dispatchers.Main){
                    var list = response.body()!!.data!!
                    var adapter = CharacterAdapter(list)
                    binding.list.adapter = adapter
                }
            }
        }

    }

}