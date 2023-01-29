package com.example.numad23sp_huiyingchen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ActivityClicky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky);

        final TextView textView=(TextView)findViewById(R.id.textView1);

        List<Integer> ids = Arrays.asList(
                R.id.a_button,
                R.id.b_button,
                R.id.c_button,
                R.id.d_button,
                R.id.e_button,
                R.id.f_button
                );

        for(int i = 0 ; i < ids.size() ; ++ i) {
            Integer id = ids.get(i);
            final Button button =  (Button)findViewById(id);

            //Implement listener for your button so that when you click the
            //button, android will listen to it.
            final char c = (char)(65+i);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    textView.setText("Pressed:" + c);

                }         });
        }
    }
}
