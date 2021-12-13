package co.scrumfit.labadvancedfirebasedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import models.Project;
import models.Team;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etId,etTeamName,etProjectTitle,etDescription,etTotalStories,etMemberOne,
            etMemberTwo,etMemberThree,etMemberFourth;
    ImageView ivTeamPhoto;
    Button btnAdd, btnFind, btnList, btnQuit;

    DatabaseReference teamDatabase;

    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {

        etId = findViewById(R.id.etId);
        etTeamName = findViewById(R.id.etTeamName);
        etProjectTitle = findViewById(R.id.etProjectTitle);
        etDescription = findViewById(R.id.etDescription);
        etTotalStories = findViewById(R.id.etTotalStories);
        etMemberOne = findViewById(R.id.etMemberOne);
        etMemberTwo = findViewById(R.id.etMemberTwo);
        etMemberThree = findViewById(R.id.etMemberThree);
        etMemberFourth = findViewById(R.id.etMemberFourth);

        ivTeamPhoto = findViewById(R.id.ivTeamPhoto);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnFind = findViewById(R.id.btnFind);
        btnFind.setOnClickListener(this);
        btnList = findViewById(R.id.btnList);
        btnList.setOnClickListener(this);
        btnQuit = findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(this);

        teamDatabase = FirebaseDatabase.getInstance().getReference("teams");
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btnAdd:
                addTeam();

                Toast.makeText(this, "Add Btn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnFind:
                Toast.makeText(this, "find Btn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnList:
                Toast.makeText(this, "List Btn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnQuit:
                Toast.makeText(this, "Quite Btn", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    private void addTeam() {

        try {
            Project prj = new Project();
            prj.setTitle(etProjectTitle.getText().toString());
            prj.setDescription(etDescription.getText().toString());
            prj.setTotalUserStories(Integer.parseInt(etTotalStories.getText().toString()));

            Team team = new Team();
            team.setId(Integer.parseInt(etId.getText().toString()));
            team.setName(etTeamName.getText().toString());
            team.setProject(prj);
            team.addMember(etMemberOne.getText().toString());
            team.addMember(etMemberTwo.getText().toString());
            team.addMember(etMemberThree.getText().toString());
            team.addMember(etMemberFourth.getText().toString());
            String newId = String.valueOf((team.getId()));

            teamDatabase.child(newId).setValue(team);

        }catch (Exception e){
            Log.d("ADV_FIREBASE", e.getMessage());
        }




    }
}