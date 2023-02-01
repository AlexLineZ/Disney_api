package ru.cft.shift2023winter.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.cft.shift2023winter.adapter.CharacterAdapter
import ru.cft.shift2023winter.interfaces.DisneyAPI
import ru.cft.shift2023winter.databinding.ActivityCharactersBinding

class CharactersActivity : AppCompatActivity(){
    private val binding by lazy {ActivityCharactersBinding.inflate(layoutInflater) }
    @SuppressLint("WrongViewCast")
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