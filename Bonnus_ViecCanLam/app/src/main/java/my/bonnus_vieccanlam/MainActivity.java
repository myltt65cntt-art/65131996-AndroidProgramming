package my.bonnus_vieccanlam;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button btnRegister, btnLogin;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Anh xa
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        // Firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        // Dag ky
        btnRegister.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();
            // Kiem tra rong
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
                Toast.makeText(this,
                        "Nhap day du thong tin",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            // Dang ky Firebase Auth
            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            // Tao du lieu Firestore
                            Map<String, Object> user = new HashMap<>();
                            user.put("email", email);
                            user.put("password", pass);
                            // Luu Firestore
                            db.collection("users")
                                    .add(user)
                                    .addOnSuccessListener(documentReference -> {

                                        Toast.makeText(this,
                                                "Dang ky thanh cong + Luu Firestore",
                                                Toast.LENGTH_SHORT).show();

                                    })
                                    .addOnFailureListener(e -> {

                                        Toast.makeText(this,
                                                "Loi Firestore",
                                                Toast.LENGTH_SHORT).show();

                                    });

                        }
                        else{

                            Toast.makeText(this,
                                    "Dang ky that bai",
                                    Toast.LENGTH_SHORT).show();

                        }

                    });

        });

        // Dang nhap
        btnLogin.setOnClickListener(v -> {

            String email = edtEmail.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
                Toast.makeText(this,
                        "Nhap day du thong tin",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(task -> {

                        if(task.isSuccessful()){

                            Toast.makeText(this,
                                    "Dang nhap thanh cong",
                                    Toast.LENGTH_SHORT).show();

                        }
                        else{

                            Toast.makeText(this,
                                    "Dang nhap that bai",
                                    Toast.LENGTH_SHORT).show();

                        }

                    });

        });

    }
}