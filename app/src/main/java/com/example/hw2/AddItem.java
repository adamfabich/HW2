package com.example.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hw2.tasks.TaskListContent;

import java.util.Random;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void Save(View view) {
        EditText model = findViewById ( R.id.editText );
        EditText color = findViewById ( R.id.editText2 );
        EditText details = findViewById ( R.id.editText3 );
        if(!model.getText ().toString ().equals ( "" ) && !color.getText ().toString ().equals ( "" ) && !details.getText ().toString ().equals ( "" ))
        {
            Random random = new Random ( );
            String selectedImage;
            Intent intent = getIntent ();
            selectedImage = intent.getStringExtra ( "photo");
            if (intent.getStringExtra ( "photo" )==null) {
                selectedImage="drawable "+(random.nextInt (3)+1);
            }
            TaskListContent.addItem ( new TaskListContent.Task ( "Task." +TaskListContent.ITEMS.size ()+1, model.getText ().toString (), details.getText ().toString (),color.getText ().toString (), selectedImage ) );
            Intent main_intent=new Intent ( );
            setResult ( RESULT_OK, main_intent );
            finish ();
        }
    }
}
