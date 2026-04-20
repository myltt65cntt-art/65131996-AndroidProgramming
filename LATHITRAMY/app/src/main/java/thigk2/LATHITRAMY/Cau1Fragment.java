package thigk2.LATHITRAMY;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cau1Fragment extends Fragment {

    EditText edtDai, edtRong;
    Button btnTinh;
    TextView txtKQ;

    public Cau1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cau1, container, false);

        // ánh xạ view
        edtDai = view.findViewById(R.id.edtDai);
        edtRong = view.findViewById(R.id.edtRong);
        btnTinh = view.findViewById(R.id.btnTinh);
        txtKQ = view.findViewById(R.id.txtKQ);

        // xử lý nút tính
        btnTinh.setOnClickListener(v -> {

            String daiStr = edtDai.getText().toString().trim();
            String rongStr = edtRong.getText().toString().trim();

            // kiểm tra rỗng
            if (daiStr.isEmpty() || rongStr.isEmpty()) {
                Toast.makeText(getContext(), "Nhập đầy đủ dữ liệu!", Toast.LENGTH_SHORT).show();
                return;
            }

            // chuyển sang số
            double dai = Double.parseDouble(daiStr);
            double rong = Double.parseDouble(rongStr);

            // tính toán
            double chuVi = (dai + rong) * 2;
            double dienTich = dai * rong;

            // hiển thị kết quả
            txtKQ.setText("Chu vi: " + chuVi + "\nDiện tích: " + dienTich);
        });

        return view;
    }
}
