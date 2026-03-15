package com.example.vd2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1, edtSo2, edtKetQua;
    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        edtKetQua = findViewById(R.id.edtKetQua);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(edtSo1.getText().toString());
                float b = Float.parseFloat(edtSo2.getText().toString());
                edtKetQua.setText(String.valueOf(a + b));
            }
        });

        btnTru.setOnClickListener(v -> edtKetQua.setText(
                String.valueOf(
                        Float.parseFloat(edtSo1.getText().toString()) -
                                Float.parseFloat(edtSo2.getText().toString())
                )
        ));

        btnNhan.setOnClickListener(v -> edtKetQua.setText(
                String.valueOf(
                        Float.parseFloat(edtSo1.getText().toString()) *
                                Float.parseFloat(edtSo2.getText().toString())
                )
        ));

        btnChia.setOnClickListener(v -> {
            float a = Float.parseFloat(edtSo1.getText().toString());
            float b = Float.parseFloat(edtSo2.getText().toString());

            if (b == 0)
                edtKetQua.setText("Không chia được");
            else
                edtKetQua.setText(String.valueOf(a / b));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}