package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener{
            selectDate(it)
        }


    }

    fun selectDate(view:View)
    {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd=DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener
            {view,selectedYear,selectedMonth,selectedDay->

                val dob="$selectedDay/${selectedMonth+1}/$selectedYear"
                selectedDate.setText(dob)

                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val dob_date=sdf.parse(dob)
                val tillDob=dob_date!!.time/60000


                val CurrDate=sdf.parse(sdf.format(System.currentTimeMillis()))

                val tillCurrDate=CurrDate!!.time/60000
              // Toast.makeText(this,"$tillCurrDate $tillDob",Toast.LENGTH_LONG).show()
                AgeInMinutes.setText((tillCurrDate-tillDob).toString())



            },
            year,
            month,
            day
        )

        dpd.datePicker.maxDate=Date().time
        dpd.show()
    }
}