package edu.url.salle.albert.gt.todolist;

public class Task {
    private String Title;
    private String Completed;

    public Task(String Title, String Completed) {
        this.Title = Title;
        this.Completed = Completed;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String mTitle) {
        this.Title = mTitle;
    }

    public String getCompleted() {
        return Completed;
    }

    public void setCompleted(String Completed) {
        this.Completed = Completed;
    }
}
