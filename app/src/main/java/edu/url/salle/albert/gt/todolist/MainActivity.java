package edu.url.salle.albert.gt.todolist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TaskManager tm;

    private RecyclerView TaskRecyclerView;
    private TaskAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tm = new TaskManager();

        TaskRecyclerView = (RecyclerView)findViewById(R.id.task_recyler_view);
        TaskRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateUI();
    }

    private void updateUI() {
        System.out.println("Gets to UI");
        List<Task> tasks = tm.getTasks();
        System.out.println("Tasks retrieved");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }

        Adapter = new TaskAdapter(tasks);
        TaskRecyclerView.setAdapter(Adapter);
    }

    // Adapter
    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new TaskHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bind(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }


    // View Holder
    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Task mTask;

        private TextView mTitleTextView;
        private TextView StatusTextView;

        public TaskHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_task, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.task_title);
            StatusTextView = (TextView) itemView.findViewById(R.id.task_status);
        }

        public void bind(Task task) {
            mTask = task;
            mTitleTextView.setText(mTask.getTitle());
            StatusTextView.setText(String.valueOf(mTask.getCompleted()));
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,
                    mTask.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

}