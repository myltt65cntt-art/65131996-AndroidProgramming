package myntu.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Hiển thị dữ liệu lên listView
        // b1+: cần có dữ liệu
        // ?? từ đâu có: từ có sở dữ liệu (SQL, noSQL,.)
        // Ở bài này code trực tiếp
        ArrayList<String> dsTenTinhThanhVN;// khai báo
        dsTenTinhThanhVN = new ArrayList<String>(); // tạo thể hiện cụ thể, xin mời
        // thêm dữ lieu ở đây
        // nhưng ta hard-code
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành Phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Bình THuận");
        dsTenTinhThanhVN.add("Ninh Thuận");
        dsTenTinhThanhVN.add("Nha Trang");
        // b2 tạo adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<String>(this,
                                                            android.R.layout.simple_list_item_1,
                                                            dsTenTinhThanhVN);
        // b3 gắn vào điều khiển hiểu thị listview
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSach);
        //3.2 GẮN
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        //3.3 lắng nghe và sử lý sự kiện user tương tác
        //để sau


    }
}