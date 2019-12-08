package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item);

        Intent intent = getIntent();
        Button add_btn = (Button) findViewById(R.id.add_button);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText title = (TextInputEditText) findViewById(R.id.add_title);
                TextInputEditText director = (TextInputEditText) findViewById(R.id.add_director);
                TextInputEditText year = (TextInputEditText) findViewById(R.id.add_year);
                TextInputEditText runtime = (TextInputEditText) findViewById(R.id.add_runtime);

                AppDatabase db = AppDatabase.getDatabase(getApplicationContext());

                db.movieDao().insert(new Movie(MovieContent.ITEMS.size()+1, title.getText().toString(), director.getText().toString(), year.getText().toString(), runtime.getText().toString()));

                NavUtils.navigateUpTo(AddItemActivity.this, new Intent(AddItemActivity.this, ItemListActivity.class));
                finish();
            }
        });


    }

}
