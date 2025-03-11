package com.example.week8_imageviewer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    private View colorView;
    private int[] colors;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //The colors are imported from android.graphics.Color. I tried to upload my own colors but this seemed
        //like an easier way to do it.
        colors = new int[]{
                Color.RED,
                Color.GREEN,
                Color.BLUE,
        };

        colorView = findViewById(R.id.colorBoxView);
        Button changeColorButton = findViewById(R.id.changeColorButton);

        //Do the button pressing like in web development -> set an onClickListener to initiate the change
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(view);
            }
        });
    }

    public void changeColor(View view) {
        // Increment index to cycle through colors
        index = (index + 1) % colors.length;

        // Set the background color of the view
        colorView.setBackgroundColor(colors[index]);
    }
}