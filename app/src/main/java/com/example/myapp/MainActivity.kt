package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener{            // "слушаем" нажатие кнопки
            val beerColor = findViewById<Spinner>(R.id.beer_color)  // находим по ID интересующее
            // нас изображение на макете экрана, в данном случае список
            val color  = beerColor.selectedItem // присваиваем некоторой переменной выбранную позицию списка
            val beerList = getBeers(color.toString()) // вызываем фунцию выдающую список сортов исхлдя
            // из переданного ей какого-то свойства пива
            val beers = beerList.reduce {str, item -> str +'\n' + item} // функцию reduce стоит изучить внимательнее
            val brand = findViewById<TextView>(R.id.brands) // находим необходимое нам текстовое поле
            brand.text = beers    // а теперь присваиваем ему требуемый текст
        }
    }

    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }

}
