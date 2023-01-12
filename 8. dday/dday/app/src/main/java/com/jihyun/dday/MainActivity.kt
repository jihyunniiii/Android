package com.jihyun.dday

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit
import kotlin.time.DurationUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startBtn)
        val endButton = findViewById<Button>(R.id.endBtn)

        var calendar_start = Calendar.getInstance()
        var calendar_end = Calendar.getInstance()

        startButton.setText("시작일\n"+"${calendar_start.get(Calendar.YEAR)}.${calendar_start.get(Calendar.MONTH) + 1}.${calendar_start.get(Calendar.DAY_OF_MONTH)}")
        endButton.setText("종료일\n"+"${calendar_end.get(Calendar.YEAR)}.${calendar_end.get(Calendar.MONTH) + 1}.${calendar_end.get(Calendar.DAY_OF_MONTH)}")

        startButton.setOnClickListener {
            val today = Calendar.getInstance()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    calendar_start.set(p1, p2, p3)
                    startButton.setText("시작일\n"+"${p1}.${p2 + 1}.${p3}")

                    if (calendar_end.timeInMillis > calendar_start.timeInMillis)
                    {
                        val finaldate = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                        val textarea = findViewById<TextView>(R.id.finalDate)
                        textarea.setText("+" + (finaldate + 1).toString())
                    }
                    else if (calendar_end.timeInMillis < calendar_start.timeInMillis)
                    {
                        val finaldate = TimeUnit.MILLISECONDS.toDays(calendar_start.timeInMillis - calendar_end.timeInMillis)

                        val textarea = findViewById<TextView>(R.id.finalDate)
                        textarea.setText("-" + (finaldate).toString())
                    }

                    if (calendar_end.get(Calendar.YEAR) == calendar_start.get(Calendar.YEAR) && calendar_end.get(Calendar.MONTH) == calendar_start.get(Calendar.MONTH) && calendar_end.get(Calendar.DAY_OF_MONTH) == calendar_start.get(Calendar.DAY_OF_MONTH))
                    {
                        val textarea = findViewById<TextView>(R.id.finalDate)
                        textarea.setText("D-DAY!")
                    }
                }

            }, year, month, day)
            dlg.show()
        }

        endButton.setOnClickListener {
            val today = Calendar.getInstance()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    calendar_end.set(p1, p2, p3)

                    endButton.setText("종료일\n"+"${p1}.${p2 + 1}.${p3}")

                    if (calendar_end.timeInMillis > calendar_start.timeInMillis)
                    {
                        val finaldate = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                        val textarea = findViewById<TextView>(R.id.finalDate)
                        textarea.setText("+" + (finaldate + 1).toString())
                    }
                    else if (calendar_end.timeInMillis < calendar_start.timeInMillis)
                    {
                        val finaldate = TimeUnit.MILLISECONDS.toDays(calendar_start.timeInMillis - calendar_end.timeInMillis)

                        val textarea = findViewById<TextView>(R.id.finalDate)
                        textarea.setText("-" + (finaldate).toString())
                    }

                    if (calendar_end.get(Calendar.YEAR) == calendar_start.get(Calendar.YEAR) && calendar_end.get(Calendar.MONTH) == calendar_start.get(Calendar.MONTH) && calendar_end.get(Calendar.DAY_OF_MONTH) == calendar_start.get(Calendar.DAY_OF_MONTH))
                    {
                        val textarea = findViewById<TextView>(R.id.finalDate)
                        textarea.setText("D-DAY!")
                    }
                }

            }, year, month, day)
            dlg.show()
        }
    }
}