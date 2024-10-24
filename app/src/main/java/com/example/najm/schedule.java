package com.example.najm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class schedule extends AppCompatActivity {

    private TextView tvDay, tvTime, tvSchedule;
    private EditText etSubject;
    private Button btnAddSubject, btnShowSchedule;

    private List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    private List<String> times = Arrays.asList("9:00 AM", "11:00 AM", "1:00 PM", "3:00 PM");
    private ArrayList<String> mysel = new ArrayList<>();
    private int dayIndex = 0, timeIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        // Initialize views
       tvDay = findViewById(R.id.tv_day);
        tvTime = findViewById(R.id.tv_time);
        etSubject = findViewById(R.id.et_subject);
        btnAddSubject = findViewById(R.id.btn_add_subject);
        btnShowSchedule = findViewById(R.id.btn_show_schedule);
        tvSchedule = findViewById(R.id.tv_schedule);

        // Set initial day and time
        updateDayTimeDisplay();

        // Button click listener for adding subjects to the schedule
        btnAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubject();
            }
        });

        // Button click listener for displaying the schedule
        btnShowSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySchedule();
            }
        });
    }

    // Function to update the day and time display
    private void updateDayTimeDisplay() {
        tvDay.setText("Day: " + days.get(dayIndex));
        tvTime.setText("Time: " + times.get(timeIndex));
    }

    // Function to add subject to the schedule
    private void addSubject() {
        String subject = etSubject.getText().toString().trim();
        if (subject.isEmpty()) {
            Toast.makeText(schedule.this, "Please enter a subject", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add the subject to the list
        mysel.add(times.get(timeIndex) + ": " + subject);

        // Move to the next time slot, and if finished with times, move to the next day
        timeIndex++;
        if (timeIndex >= times.size()) {
            timeIndex = 0;
            dayIndex++;
        }

        // Check if we've completed the entire schedule
        if (dayIndex >= days.size()) {
            Toast.makeText(schedule.this, "Schedule complete!", Toast.LENGTH_SHORT).show();
            btnAddSubject.setEnabled(false);  // Disable adding subjects when the schedule is full
        } else {
            updateDayTimeDisplay();  // Update the display to the next day/time slot
        }

        // Clear the subject input field
        etSubject.setText("");
    }

    // Function to display the schedule
    private void displaySchedule() {
        if (!mysel.isEmpty()) {
            StringBuilder scheduleDisplay = new StringBuilder("\nYour schedule:\n");
            int index = 0;
            for (String day : days) {
                scheduleDisplay.append(day).append("\n");
                for (int j = 0; j < times.size(); j++) {
                    if (index < mysel.size()) {
                        scheduleDisplay.append(mysel.get(index++)).append("\n");
                    }
                }
            }
            tvSchedule.setText(scheduleDisplay.toString());
        } else {
            tvSchedule.setText("You have not made a schedule yet.");
        }
    }
}
