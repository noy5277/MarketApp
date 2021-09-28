package com.example.market_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.metrics.Event;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class activity_calender extends AppCompatActivity {

    private CalendarView nCalendarView;
    private Calendar beginTime=Calendar.getInstance();
    private int hour,minute,year,month,day;
    private Button timeButton;
    private static final String barberEmail="noy@barbershop.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        timeButton = findViewById(R.id.selectTime_Btn);
        nCalendarView = (CalendarView) findViewById(R.id.calendarView);
        nCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int selectedYear, int selectedMonth, int selectdedDay) {
                year = selectedYear;
                month = selectedMonth;
                day = selectdedDay;
            }
        });
    }


    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour=selectedHour;
                minute=selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(),"%02d:%02d",hour,minute));
            }
        };
        int style= AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog=new TimePickerDialog(this,style,onTimeSetListener,hour,minute,true);
        timePickerDialog.show();
    }


    public void createEvent(View view) {
        Intent calenderIntent=new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        beginTime.set(year,month,day,hour,minute);
        Log.d("check:", String.valueOf(beginTime));
        calenderIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime.getTimeInMillis());
        calenderIntent.putExtra(CalendarContract.Events.TITLE,"Barber-Shop");
        calenderIntent.putExtra(CalendarContract.Events.EVENT_LOCATION,"Duhifat 15 Gedera");
        calenderIntent.putExtra(CalendarContract.Events.CAN_INVITE_OTHERS,true);
        calenderIntent.putExtra(Intent.EXTRA_EMAIL,barberEmail);
        startActivity(calenderIntent);
    }
}