package com.example.najm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class activityQ extends AppCompatActivity {

    private TextView tvQuestion, tvFeedback;
    private RadioGroup rgAnswers;
    private RadioButton rbOption1, rbOption2, rbOption3, rbOption4;
    private Button btnSubmit;

    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();
    private ArrayList<String[]> options = new ArrayList<>();
    private Random random = new Random();
    private int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);

        // Initialize UI components
        tvQuestion = findViewById(R.id.tv_question);
        tvFeedback = findViewById(R.id.tv_feedback);
        rgAnswers = findViewById(R.id.rg_answers);
        rbOption1 = findViewById(R.id.rb_option1);
        rbOption2 = findViewById(R.id.rb_option2);
        rbOption3 = findViewById(R.id.rb_option3);
        rbOption4 = findViewById(R.id.rb_option4);
        btnSubmit = findViewById(R.id.btn_submit);

        // Initialize questions, answers, and options for the quiz
        loadGeographyQuestions();

        // Display the first question
        displayNextQuestion();

        // Button click listener to submit the answer
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void loadGeographyQuestions() {
        // Add questions, answers, and options
        questions.add("Which is the most sacred city in Islam, located in Saudi Arabia?");
        options.add(new String[]{"Medina", "Riyadh", "Mecca", "Jeddah"});
        answers.add("Mecca");

        questions.add("Which body of water is to the west of Saudi Arabia?");
        options.add(new String[]{"Red Sea", "Arabian Sea", "Persian Gulf", "Gulf of Aden"});
        answers.add("Red Sea");

        // Add more questions as needed
    }

    private void displayNextQuestion() {
        // Generate a random question index
        currentIndex = random.nextInt(questions.size());

        // Display the question and options
        tvQuestion.setText(questions.get(currentIndex));
        String[] currentOptions = options.get(currentIndex);
        rbOption1.setText(currentOptions[0]);
        rbOption2.setText(currentOptions[1]);
        rbOption3.setText(currentOptions[2]);
        rbOption4.setText(currentOptions[3]);

        // Clear previous selections and feedback
        rgAnswers.clearCheck();
        tvFeedback.setText("");
    }

    private void checkAnswer() {
        // Get the selected radio button ID
        int selectedId = rgAnswers.getCheckedRadioButtonId();

        // Find which option was selected
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            // Check if the answer is correct
            if (selectedAnswer.equals(answers.get(currentIndex))) {
                tvFeedback.setText("Correct!");
                tvFeedback.setTextColor(getResources().getColor(R.color.green));

                // Change the button text to "Next Question" if the answer is correct
                btnSubmit.setText("Next Question");

                // Change the button functionality to display the next question
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Display the next question
                        displayNextQuestion();

                        // Reset the button text to "Submit Answer"
                        btnSubmit.setText("Submit Answer");

                        // Reassign the original checkAnswer() functionality to the button
                        btnSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer();
                            }
                        });
                    }
                });

            } else {
                tvFeedback.setText("Incorrect! Try again.");
                tvFeedback.setTextColor(getResources().getColor(R.color.red));

                // Keep the button as "Submit Answer" and allow retry
                btnSubmit.setText("Submit Answer");
            }
        } else {
            Toast.makeText(activityQ.this, "Please select an answer.", Toast.LENGTH_SHORT).show();
        }
    }
}
