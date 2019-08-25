package com.clicks.yogi.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    Button btnDatePicker;
    EditText date;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker=findViewById(R.id.btn1);
        date=findViewById(R.id.edt1);

        btnDatePicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int XYear = c.get(Calendar.YEAR);
                int XMonth = c.get(Calendar.MONTH);
                int XDay = c.get(Calendar.DAY_OF_MONTH);

                // date picker dialog...
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, XYear,XMonth,XDay);
                datePickerDialog.show();
            }
        });
    }
}