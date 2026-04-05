package my.example.appdocbao;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    TextView txtTieuDe1, txtMoTa1, txtTieuDe2, txtMoTa2;
    Button btnDocBao1, btnDocBao2;
    BaiBao baiBao1, baiBao2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        txtTieuDe1 = findViewById(R.id.txtTieuDe1);
        txtMoTa1 = findViewById(R.id.txtMoTa1);
        txtTieuDe2 = findViewById(R.id.txtTieuDe2);
        txtMoTa2 = findViewById(R.id.txtMoTa2);
        btnDocBao1 = findViewById(R.id.btnDocBao1);
        btnDocBao2 = findViewById(R.id.btnDocBao2);
        // Dữ liệu bài báo viết trong class Java
        baiBao1 = new BaiBao(
                "Thủ tướng khảo sát địa điểm dự kiến xây kho dự trữ xăng dầu quốc gia",
                "Bài báo nói về việc khảo sát vị trí để xây dựng kho dự trữ xăng dầu quốc gia.",
                "https://vnexpress.net/thu-tuong-khao-sat-dia-diem-du-kien-xay-kho-du-tru-xang-dau-quoc-gia-5056110.html"
        );
        baiBao2 = new BaiBao(
                "Ôtô chở 29 người rơi xuống vực ở Tam Đảo",
                "Bài báo cập nhật vụ tai nạn giao thông xảy ra tại Tam Đảo.",
                "https://vnexpress.net/oto-cho-29-nguoi-roi-xuong-vuc-o-tam-dao-5056089.html"
        );
        txtTieuDe1.setText(baiBao1.getTieuDe());
        txtMoTa1.setText(baiBao1.getMoTa());
        txtTieuDe2.setText(baiBao2.getTieuDe());
        txtMoTa2.setText(baiBao2.getMoTa());
        btnDocBao1.setOnClickListener(v -> moBaiBao(baiBao1));
        btnDocBao2.setOnClickListener(v -> moBaiBao(baiBao2));
    }
    private void moBaiBao(BaiBao baiBao) {
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        intent.putExtra("tieuDe", baiBao.getTieuDe());
        intent.putExtra("duongDan", baiBao.getDuongDan());
        startActivity(intent);
    }
}