package coatocl.exaatocl.roomdb_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class new_activity extends AppCompatActivity {

    EditText courseName, courseDuration, courseDescription;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_activity);

        courseName = findViewById(R.id.courseName);
        courseDuration = findViewById(R.id.courseDuration);
        courseDescription = findViewById(R.id.courseDescription);

        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {

            String courseNameExtra = courseName.getText().toString();
            String courseDurationExtra = courseDuration.getText().toString();
            String courseDescriptionExtra = courseDescription.getText().toString();

            if (courseNameExtra.isEmpty()) {
                courseName.setError("required");
            }
            if (courseDurationExtra.isEmpty()) {
                courseDuration.setError("required");
            }
            if (courseDescriptionExtra.isEmpty()) {
                courseDescription.setError("required");
            } else {
                saveTask(courseNameExtra, courseDurationExtra, courseDescriptionExtra);
            }
        });

    }

    private void saveTask(String courseNameExtra, String courseDurationExtra, String courseDescriptionExtra) {
        Intent data = new Intent();

        data.putExtra("courseNameExtra", courseNameExtra);
        data.putExtra("courseDurationExtra", courseDurationExtra);
        data.putExtra("courseDescriptionExtra", courseDescriptionExtra);

        int id = getIntent().getIntExtra("extra_id", -1);

        if (id != -1) {
            data.putExtra("extra_id", id);
        }
        setResult(RESULT_OK, data);
        finish();

        Toast.makeText(this, "Data gone to database", Toast.LENGTH_SHORT).show();
    }

}
