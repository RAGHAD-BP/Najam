package com.example.najm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.InputMismatchException;

public class timePlan extends AppCompatActivity {

    private EditText etPages, etTime, etBreakTime;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_plan);

        // Initialize views
        etPages = findViewById(R.id.et_pages); // This was missing, now it's fixed
        etTime = findViewById(R.id.et_time);
        etBreakTime = findViewById(R.id.et_break_time);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        // Set button click listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePlan();
            }
        });
    }

    public void timePlan() {
        try {
            // Get input values
            int pages = Integer.parseInt(etPages.getText().toString());
            int time = Integer.parseInt(etTime.getText().toString());
            int breakTime = Integer.parseInt(etBreakTime.getText().toString());

            // Calculate time per page
            double timePerPage = (double) time / pages;
            StringBuilder result = new StringBuilder();

            result.append("Pages to study: ").append(pages).append("\n");
            result.append("Total time: ").append(time).append(" minutes\n");
            result.append(String.format("Spend about %.2f minutes on each page.\n", timePerPage));

            int studiedPages = 0;
            int totalTime = 0;
            int pagesBeforeBreak = (int) (60 / timePerPage); // Assume 1 break per hour

            while (studiedPages < pages && totalTime < time) {
                int timeLeft = time - totalTime;

                if (timeLeft >= 60) { // Study for 1 hour, then take a break
                    if (studiedPages + pagesBeforeBreak <= pages) {
                        studiedPages += pagesBeforeBreak;
                        totalTime += 60; // 1 hour of study
                    } else {
                        int remainingPages = pages - studiedPages;
                        totalTime += remainingPages * timePerPage;
                        studiedPages = pages;
                    }

                    if (studiedPages >= pages) break;

                    result.append(String.format("You studied %d pages. Take a %d-minute break.\n", pagesBeforeBreak, breakTime));
                    totalTime += breakTime;
                } else {
                    int remainingPages = pages - studiedPages;
                    result.append(String.format("Study the remaining %d pages without a break.\n", remainingPages));
                    totalTime += timeLeft;
                    studiedPages = pages;
                }
            }

            result.append("Study plan complete!");

            // Display result
            tvResult.setText(result.toString());

        } catch (InputMismatchException | NumberFormatException e) {
            Toast.makeText(timePlan.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}