package ru.cft.shift2023winter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.cft.shift2023winter.R
import ru.cft.shift2023winter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		val getButton = binding.getButton
		getButton.setOnClickListener {
			val intent = Intent(this, CharactersActivity::class.java)
			startActivity(intent)
		}
	}

}