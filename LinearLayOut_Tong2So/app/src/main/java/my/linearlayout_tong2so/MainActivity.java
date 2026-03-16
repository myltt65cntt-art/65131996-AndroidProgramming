package my.linearlayout_tong2so;

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
    //khai bao cac doi tuong gan voi dieu khien tuong ung
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong,nutTru,nutNhan,nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();

    }
    void TimDieuKhien(){
        editTextSo1= (EditText) findViewById(R.id.edtSo1);
        editTextSo2= (EditText) findViewById(R.id.edtSo2);
        editTextKQ= (EditText) findViewById(R.id.edtKetQua);
        nutCong= (Button) findViewById(R.id.btnCong);
        nutTru= (Button) findViewById(R.id.btnTru);
        nutNhan= (Button) findViewById(R.id.btnNhan);
        nutChia= (Button) findViewById(R.id.btnChia);
    }
    //Xử lý cộng
    public void XuLyCong(View v){
        //lay du lieu 2 so
        //tim editText so1 va so2

        //lay du lieu tu 2 dieu khien do
        String soThu1=editTextSo1.getText().toString();
        String soThu2=editTextSo2.getText().toString();
        //chuyen du lieu tu chuoi sang so
        float SoA= Float.parseFloat(soThu1);
        float SoB= Float.parseFloat(soThu2);
        //Tinh toan
        float Tong= SoA+ SoB;
        //hien ket qua

        //chuan bi du lieu xuat , bien thanh dang chuoi
        String chuoikQ=String.valueOf(Tong);
        //gan ket qua
        editTextKQ.setText(chuoikQ);


    }
    //Xử lý Trừ
    public void XuLyTru(View v){
//lay du lieu 2 so
        //tim editText so1 va so2

        //lay du lieu tu 2 dieu khien do
        String soThu1=editTextSo1.getText().toString();
        String soThu2=editTextSo2.getText().toString();
        //chuyen du lieu tu chuoi sang so
        float SoA= Float.parseFloat(soThu1);
        float SoB= Float.parseFloat(soThu2);
        //Tinh toan
        float Hieu= SoA - SoB;
        //hien ket qua

        //chuan bi du lieu xuat , bien thanh dang chuoi
        String chuoikQ=String.valueOf(Hieu);
        //gan ket qua
        editTextKQ.setText(chuoikQ);

    }
    //Xử lý Nhân
    public void XuLyNhan(View v){
//lay du lieu 2 so
        //tim editText so1 va so2

        //lay du lieu tu 2 dieu khien do
        String soThu1=editTextSo1.getText().toString();
        String soThu2=editTextSo2.getText().toString();
        //chuyen du lieu tu chuoi sang so
        float SoA= Float.parseFloat(soThu1);
        float SoB= Float.parseFloat(soThu2);
        //Tinh toan
        float Tich= SoA * SoB;
        //hien ket qua
        //chuan bi du lieu xuat , bien thanh dang chuoi
        String chuoikQ=String.valueOf(Tich);
        //gan ket qua
        editTextKQ.setText(chuoikQ);

    }
    //Xử lý Chia
    public void XuLyChia(View v){
//lay du lieu 2 so
        //tim editText so1 va so2

        //lay du lieu tu 2 dieu khien do
        String soThu1=editTextSo1.getText().toString();
        String soThu2=editTextSo2.getText().toString();
        //chuyen du lieu tu chuoi sang so
        float SoA= Float.parseFloat(soThu1);
        float SoB= Float.parseFloat(soThu2);
        //Tinh toan
        float Thuong= SoA / SoB;
        //hien ket qua

        //chuan bi du lieu xuat , bien thanh dang chuoi
        String chuoikQ=String.valueOf(Thuong);
        //gan ket qua
        editTextKQ.setText(chuoikQ);

    }
}