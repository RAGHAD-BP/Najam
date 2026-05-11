package com.example.najm;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;

public class ToDolistActivity extends AppCompatActivity {

    ArrayList<String> complement = new ArrayList<>();
    ArrayList<String> notComplement = new ArrayList<>();
    ArrayAdapter<String> adapter;
    EditText editTextTask;
    ListView listViewTasks;
    Button buttonAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist_activity);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAddTask = findViewById(R.id.buttonAddTask);
        listViewTasks = findViewById(R.id.listViewTasks);

        // إعداد الـ Adapter لربط ListView مع ArrayList
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notComplement);
        listViewTasks.setAdapter(adapter);

        // زر لإضافة مهمة جديدة
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTextTask.getText().toString();
                if (!task.isEmpty()) {
                    addTask(task);
                    editTextTask.setText(""); // تفريغ النص بعد الإضافة
                } else {
                    Toast.makeText(ToDolistActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // حدث الضغط على عنصر من الـ ListView لإكمال المهمة
        listViewTasks.setOnItemClickListener((parent, view, position, id) -> {
            done(position);
        });

        // حدث الضغط المطول لحذف مهمة
        listViewTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            deleteNotComplementTask(position);
            return true;
        });
    }

    // إزالة العناصر المكررة
    public <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    // إضافة مهمة جديدة
    public void addTask(String task) {
        notComplement.add(task);
        adapter.notifyDataSetChanged();
    }

    // وسم المهمة كمكتملة
    public void done(int index) {
        if (index >= 0 && index < notComplement.size()) {
            complement.add(notComplement.get(index));
            notComplement.remove(index);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Task completed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task not found!", Toast.LENGTH_SHORT).show();
        }
    }

    // حذف مهمة من القائمة
    public void deleteNotComplementTask(int index) {
        if (index >= 0 && index < notComplement.size()) {
            notComplement.remove(index);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Task deleted!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task not found!", Toast.LENGTH_SHORT).show();
        }
    }
}