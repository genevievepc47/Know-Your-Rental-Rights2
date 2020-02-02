package edu.temple.knowyourrentalrights;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    List<String> complaints = new ArrayList<>();
    List<String> matchComplaints = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commen_tactivity);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyCommentRecyclerViewAdapter(complaints));

        final RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(new MyCommentRecyclerViewAdapter(matchComplaints));



        final EditText editComplaint = (EditText) findViewById(R.id.editText);
        final EditText searchComplaint = (EditText) findViewById(R.id.searchText);


        Button showButton = (Button) findViewById(R.id.submit);
        Button searchButton = (Button) findViewById(R.id.search);

        showButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String complaint = editComplaint.getText().toString();
                complaints.add(complaint);
                recyclerView.getAdapter().notifyDataSetChanged();


            }
        });

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String searchTerm = searchComplaint.getText().toString();
                matchComplaints.clear();

                //get the complaints that match the search term
                //loop through complain list
                //check if it contains the search term
                //if it does, add it to the matchComplaints list

                for(String complaint: complaints)
                {
                    if(complaint.indexOf(searchTerm) != -1)//if the complaint has the search term in it
                    {
                        matchComplaints.add(complaint);
                    }
                }

                recyclerView2.getAdapter().notifyDataSetChanged();
            }
        });
    }
}
