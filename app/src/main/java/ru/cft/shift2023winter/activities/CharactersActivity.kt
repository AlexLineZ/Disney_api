package ru.cft.shift2023winter.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.cft.shift2023winter.CharacterModel
import ru.cft.shift2023winter.adapter.CharacterAdapter
import ru.cft.shift2023winter.interfaces.DisneyAPI
import ru.cft.shift2023winter.databinding.ActivityCharactersBinding

class CharactersActivity : AppCompatActivity(){
    private val binding by lazy {ActivityCharactersBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var pageNum = 1
        var fullList = listOf<CharacterModel>()

        binding.list.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrollStateChanged(recyclerView, dx);
                if(!recyclerView.canScrollVertically(1)) {
                    pageNum++
                }
            }
        }) //пока что не смог разобраться как сделать пагинацию, поэтому этот проект будет без нее
            //(но функцию оставил, мало ли разберусь)

        GlobalScope.launch(Dispatchers.IO) {
            var response = DisneyAPI().getListOfCharacter(pageNum)
            if (response.isSuccessful){
                withContext(Dispatchers.Main){
                    var list = response.body()!!.data!!
                    var adapter = CharacterAdapter(list)
                    adapter.setOnClickImageListener {id->
                        val intent = Intent(this@CharactersActivity, InformationActivity::class.java)
                        intent.putExtra("findCharacterInformation", id)
                        startActivity(intent)
                    }
                    binding.list.adapter = adapter
                }
            }
        }
    }
}