package edu.url.salle.albert.gt.todolist;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TaskManager extends AppCompatActivity {
    private Button AddButton;
    private TextView titleBox;
    private TextView statusBox;

    public List<Task> Tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_creation);

        AddButton = findViewById(R.id.AddButton);
        titleBox = findViewById(R.id.task_title);
        statusBox = findViewById(R.id.task_status);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputTitle = titleBox.getText().toString();
                String inputStatus = titleBox.getText().toString();

                // ERROR MESSAGE
                if (inputTitle.isEmpty() || inputStatus.isEmpty() ) {
                    Toast.makeText(TaskManager.this, getString(R.string.title_missing), Toast.LENGTH_SHORT).show();
                }else {
                    Task task = new Task(inputTitle, inputStatus);
                    Tasks.add(task);

                    Toast.makeText(TaskManager.this, getString(R.string.successful), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class); // open main activity
                    startActivity(intent);

                }
            }
        });


    }

    public List<Task> getTasks() {
        return Tasks;
    }

}
