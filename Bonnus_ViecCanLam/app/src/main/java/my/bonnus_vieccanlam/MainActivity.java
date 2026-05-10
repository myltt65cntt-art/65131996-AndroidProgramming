package my.bonnus_vieccanlam;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword, edtTask;
    Button btnRegister, btnLogin, btnAddTask;
    TextView txtTasks;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    String currentUserEmail = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtTask = findViewById(R.id.edtTask);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        btnAddTask = findViewById(R.id.btnAddTask);
        txtTasks = findViewById(R.id.txtTasks);
        // Firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        // Đăng ký
        btnRegister.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();
            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this,
                                    "Dang ky thanh cong",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this,
                                    "Dang ky that bai",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
        // Đăng nhập
        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();
            mAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this,
                                    "Dang nhap thanh cong",
                                    Toast.LENGTH_SHORT).show();
                            currentUserEmail = email;
                            loadTasks();
                        } else {
                            Toast.makeText(this,
                                    "Dang nhap that bai",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
        // Thêm việc
        btnAddTask.setOnClickListener(v -> {
            String work = edtTask.getText().toString().trim();
            if (work.isEmpty()) {
                Toast.makeText(this,
                        "Nhap cong viec",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            if (currentUserEmail.isEmpty()) {
                Toast.makeText(this,
                        "Hay dang nhap truoc",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            Map<String, Object> task = new HashMap<>();
            task.put("title", work);
            task.put("email", currentUserEmail);
            db.collection("tasks")
                    .add(task)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(this,
                                "Them viec thanh cong",
                                Toast.LENGTH_SHORT).show();
                        edtTask.setText("");
                        loadTasks();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this,
                                "Them that bai",
                                Toast.LENGTH_SHORT).show();
                    });
        });
    }
    // Hiển thị công việc theo email
    private void loadTasks() {
        txtTasks.setText("");
        db.collection("tasks")
                .whereEqualTo("email", currentUserEmail)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (var doc : queryDocumentSnapshots) {
                        String title = doc.getString("title");
                        txtTasks.append("- " + title + "\n");
                    }

                });
    }

}