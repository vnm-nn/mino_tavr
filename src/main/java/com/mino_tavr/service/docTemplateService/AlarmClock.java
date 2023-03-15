package com.mino_tavr.service.docTemplateService;

import lombok.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Component
public class AlarmClock {

    @Value("${alarm.time}")
    private String alarmTime;

    @Value("${alarm.message}")
    private String alarmMessage;

    public void scheduleAlarm() throws ParseException {
        // Create a timer task to display the alarm message
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(alarmMessage);
            }
        };

        // Schedule the timer task to run at the specified alarm time
        Timer timer = new Timer();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = dateFormat.parse(alarmTime);
        timer.schedule(task, date);
    }
}
