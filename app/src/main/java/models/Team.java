package models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Team {

    private int id;
    private String name;
    private String photo;
    private Project project;
    private ArrayList<String> membersList = new ArrayList<String>();

    public Team() {
    }

    public Team(int id, String name, String photo, Project project, ArrayList<String> members) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.project = project;
        this.membersList = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ArrayList<String> getMembers() {
        return membersList;
    }

    public void setMembers(ArrayList<String> members) {
        this.membersList = members;
    }

    public void addMember(String member){
        membersList.add(member);
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
