package com.e.dayandtime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Month;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView tvdate,tvtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdate=findViewById(R.id.tvdate);
        tvtime=findViewById(R.id.tvtime);

        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();

            }

        });

        tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             loadTime();
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String m="";
        switch (month){
            case 0:
                m="jan";
                break;

            case 1:
                m="feb";
                break;

            case 2:
                m="march";
                break;

            case 3:
                m="april";
                break;

            case 4:
                m="may";
                break;
            case 5:
                m="june";
                break;

            case 6:
                m="july";
                break;

            case 7:
                m="august";
                break;

            case 8:
                m="september";
                break;

            case 9:
                m="october";
                break;

            case 10:
                m="november";
                break;

            case 11:
                m="december";
                break;
        }

        String date="Month/Day/Year:"+ m+"/"+ dayOfMonth+"/"+year;
        tvdate.setText(date);
    }


   private void loadDatePicker(){
        final Calendar c= Calendar.getInstance() ;
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        c.add(Calendar.DATE,3);

        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,this,year,month,day);
        datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());
        datePickerDialog.show();
    }

    private void loadTime(){
        final Calendar c=Calendar.getInstance();
        final int hour=c.get(Calendar.HOUR);
        int minute=c.get(Calendar.MINUTE);
        int second=c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvtime.setText("Time is:"+hourOfDay+":"+minute);

            }
        },hour,minute,false);
        timePickerDialog.show();


    }


}
