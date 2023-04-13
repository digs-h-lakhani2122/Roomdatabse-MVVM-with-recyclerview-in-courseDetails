package coatocl.exaatocl.roomdb_basic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recycler;
    ViewModelFinal viewModel12;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        recycler = findViewById(R.id.recycler);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, new_activity.class);
                startActivityForResult(intent, 1);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);

        Adapter adapter = new Adapter();
        recycler.setAdapter(adapter);

        viewModel12 = ViewModelProviders.of(this).get(ViewModelFinal.class);

        viewModel12.getAllCourses().observe(this, new Observer<List<CustomModel>>() {
            @Override
            public void onChanged(List<CustomModel> customModels) {
                adapter.setListItem(customModels);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101010 && resultCode == RESULT_OK) {
            assert data != null;

            String courseNameExtra2 = data.getStringExtra("courseNameExtra");
            String courseDurationExtra2 = data.getStringExtra("courseDurationExtra");
            String courseDescriptionExtra2 = data.getStringExtra("courseDescriptionExtra");

            CustomModel model = new CustomModel(courseNameExtra2, courseDurationExtra2, courseDescriptionExtra2);
            viewModel12.insert(model);

            Toast.makeText(this, "Course saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Course not saved", Toast.LENGTH_SHORT).show();
        }
    }

}
