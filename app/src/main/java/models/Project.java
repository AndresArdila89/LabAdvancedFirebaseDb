package models;

import androidx.annotation.NonNull;

public class Project {

    private String title;
    private String description;
    private int totalUserStories;

    public Project() {
    }

    public Project(String title, String description, int totalUserStories) {
        this.title = title;
        this.description = description;
        this.totalUserStories = totalUserStories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalUserStories() {
        return totalUserStories;
    }

    public void setTotalUserStories(int totalUserStories) {
        this.totalUserStories = totalUserStories;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
