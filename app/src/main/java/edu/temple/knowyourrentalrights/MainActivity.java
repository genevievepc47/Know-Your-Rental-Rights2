package edu.temple.knowyourrentalrights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button emergencyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button17);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

        button = (Button) findViewById(R.id.makeComplaint);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openmakeComplaint();
            }
        });

        button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEmergency();
            }
        });

    }//end on create

    public void openmakeComplaint()
    {
        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);
    }

    public void openActivity2()
    {
        Intent intent = new Intent(this, activity2.class);
        startActivity(intent);
    }

    public void openEmergency()
    {
        Intent intent = new Intent(this, activity3.class);
        startActivity(intent);
    }
}
