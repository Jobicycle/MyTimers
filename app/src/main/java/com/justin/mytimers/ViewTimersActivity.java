package com.justin.mytimers;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class ViewTimersActivity extends AppCompatActivity {
    TextView timer1TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_timers);

        TextView timer1LabelTV = findViewById(R.id.timer1Label);
        timer1LabelTV.setText("mb");

        timer1TV = findViewById(R.id.timer1);
        timer1TV.setDrawingCacheEnabled(true);

        Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.setOnChronometerTickListener(chronometerTickListener);
        chronometer.setBase(1526241129000L);
        chronometer.start();
    }


    private Chronometer.OnChronometerTickListener chronometerTickListener = new Chronometer.OnChronometerTickListener() {
        @Override
        public void onChronometerTick(Chronometer chronometer) {
            long t = System.currentTimeMillis() - chronometer.getBase();

            long days = TimeUnit.MILLISECONDS.toDays(t);
            t -= TimeUnit.DAYS.toMillis(days);

            long hours = TimeUnit.MILLISECONDS.toHours(t);
            t -= TimeUnit.HOURS.toMillis(hours);

            long minutes = TimeUnit.MILLISECONDS.toMinutes(t);
            t -= TimeUnit.MINUTES.toMillis(minutes);

            long seconds = TimeUnit.MILLISECONDS.toSeconds(t);

            if (days > 0) {
                timer1TV.setText(String.format("%d:%02d:%02d:%02d", days, hours, minutes, seconds));
            } else if (hours > 0) {
                timer1TV.setText(String.format("%d:%02d:%02d", hours, minutes, seconds));
            } else if (minutes > 0) {
                timer1TV.setText(String.format("%d:%02d", minutes, seconds));
            } else {
                timer1TV.setText(String.format("%d", seconds));
            }
        }
    };
}
