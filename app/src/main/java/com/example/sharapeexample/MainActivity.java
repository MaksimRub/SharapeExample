package com.example.sharapeexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText purchaseText,costText;
    Button addSaveButton;
    SharedPreferences preferences;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        purchaseText=findViewById(R.id.purchase);
        costText=findViewById(R.id.cost);
        addSaveButton=findViewById(R.id.add_save_button);

        preferences=getSharedPreferences("purchas",MODE_PRIVATE);
        editor=preferences.edit();

        addSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putFloat(purchaseText.getText().toString(),
                        Float.parseFloat(costText.getText().toString()));
                editor.commit();
            }
        });

    }
}