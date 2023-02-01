package ru.cft.shift2023winter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.cft.shift2023winter.R

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val getButton = findViewById<Button>(R.id.getButton)
		getButton.setOnClickListener {
			val intent = Intent(this, CharactersActivity::class.java)
			startActivity(intent)
		}
	}

}