package edu.bu.projectportal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectDetailActivity extends AppCompatActivity {

    ProjectDetailFragment projectDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        //add fragments dynamically
        //create a fragment object
        projectDetailFragment = new ProjectDetailFragment();
        projectDetailFragment.setArguments(getIntent().getExtras());
        // get the reference to the FragmentManger object
        FragmentManager fragManager = getSupportFragmentManager();
        // get the reference to the FragmentTransaction object
        FragmentTransaction transaction = fragManager.beginTransaction();
        // add the fragment into the transaction
        transaction.add(R.id.proDetailfragContainer, projectDetailFragment);
        // commit the transaction.
        transaction.commit();



    }

    public void onClick(View view){
        int id = projectDetailFragment.getProjectId();
        projectDetailFragment.setProject( (id + 1) % Project.projects.length);
    }
    public void onClickSubmit(View view){

        Toast.makeText(this, "Submit successfully!", Toast.LENGTH_LONG).show();

        EditText nameEditText = (EditText)findViewById(R.id.AuthorsName);
        String name = nameEditText.getText().toString();


        CheckBox favCheckBox = (CheckBox)findViewById(R.id.checkBox2);
        Boolean isFav = favCheckBox.isChecked();

        EditText keywordEditText = (EditText)findViewById(R.id.editText5);
        String keyword = keywordEditText.getText().toString();


        String msg = "Here is all the infomation above: \n" +"Authors Name:" + name + (isFav? "\n this is my favorate project" : "\n this is not my favorite project" ) +
                "\n Keywords that can be used to search the project: " + keyword;

        TextView infoTextView = (TextView) findViewById(R.id.textView8);
        infoTextView.setText(msg);


    }

}