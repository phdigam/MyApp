package com.example.myapp

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var stopwatch:Chronometer // Хронометр
    var running = false // Хронометр работает?
    var offset: Long = 0 // Базовое смещение

    val OFFSET_KEY = "offset" // String
    val RUNNING_KEY = "running" // String
    val BASE_KEY = "base" // String

    override fun onCreate(savedInstanceState: Bundle?) {  // метод родительского класса типа Bundle
         // т.е. связка(пара) ключь типа String, и значение (тип, указываем тип сохраняемой переменной)
        super.onCreate(savedInstanceState)  // если правильно понял то здесь мы "говорим" IDE что
        // переопределяется метод onCreate суперкласса Activity
        setContentView(R.layout.activity_main)

        stopwatch = findViewById(R.id.stopwatch)  // ищем вьюшку с id stopwatch
                // в нашем случае это секундомер ,со всеми его методами

        if (savedInstanceState != null) {  // если в Bundle что то уже попало, то присваиваем переменным
            // сохраненные значения
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            if (running){
                stopwatch.base = savedInstanceState.getLong(BASE_KEY)
                stopwatch.start()
            } else {
                setBaseTime()
            }
        }

        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener {
            if(!running) {
                setBaseTime()
                stopwatch.start()
                running = true
            }
        }
        val pauseButton = findViewById<Button>(R.id.pause_button)
        pauseButton.setOnClickListener {
            if (running) {
                saveOffset()
                stopwatch.stop()
                running = false
            }
        }

        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {
            offset = 0
            setBaseTime()
        }

    }

    override fun onStop() {  //сохраняем текущий "снимок" программы при переходе в фон
        super.onStop()
        if (running){
            saveOffset()
            stopwatch.stop()
        }
    }

    override fun onPause() {
        super.onPause()
        if (running){
            saveOffset()
            stopwatch.stop()
        }
    }

    override fun onResume() {
        super.onResume()
        if (running){
            setBaseTime()
            stopwatch.start()
            offset = 0
        }
    }

    override fun onRestart() { // возобновляем работу программы с последнего "снимка" проги
        super.onRestart()
        if (running) {
            setBaseTime()
            stopwatch.start()
            offset = 0
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putLong(OFFSET_KEY, offset)
        savedInstanceState.putBoolean(RUNNING_KEY, running)
        savedInstanceState.putLong(BASE_KEY, stopwatch.base)
        super.onSaveInstanceState(savedInstanceState)
    }

    private fun saveOffset() {
        offset = SystemClock.elapsedRealtime() - stopwatch.base
    }

    private fun setBaseTime() {
        stopwatch.base = SystemClock.elapsedRealtime() - offset
    }
}