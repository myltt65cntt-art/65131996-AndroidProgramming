package Thi.My65131996.khoatruoc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Cau1Fragment extends Fragment {
    EditText editText_Met;
    EditText editText_KiloMet;
    Button btnChuyen;
    public Cau1Fragment() {
    }


    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau1= inflater.inflate(R.layout.fragment_cau1, container, false);
        // Inflate the layout for this fragment
        editText_Met= viewCau1.findViewById(R.id.edtSoMet);
        editText_KiloMet= viewCau1.findViewById(R.id.edtSoKiloM);
        btnChuyen = viewCau1.findViewById(R.id.btnDoi);
        btnChuyen.setOnClickListener(v -> {
            String dulieuMet = editText_Met.getText().toString();
            String dulieuKiloMet = editText_KiloMet.getText().toString();

            if (!dulieuMet.isEmpty()) {
                double m = Double.parseDouble(dulieuMet);
                double km = m / 1000;
                editText_KiloMet.setText(String.valueOf(km));
            } else if (!dulieuKiloMet.isEmpty()) {
                double km = Double.parseDouble(dulieuKiloMet);
                double m = km * 1000;
                editText_Met.setText(String.valueOf(m));
            } else {
                Toast.makeText(getContext(), "Nhập dữ liệu!", Toast.LENGTH_SHORT).show();
            }
        });

        return viewCau1;
    }
}