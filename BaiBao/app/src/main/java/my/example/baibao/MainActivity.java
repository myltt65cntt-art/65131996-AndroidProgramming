package my.example.baibao;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BaiBaoAdapter baiBaoAdapter;
    ArrayList<BaiBao> recyclerViewDatas;
    RecyclerView recyclerViewBaiBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewDatas = getDataForRecyclerView();

        recyclerViewBaiBao = findViewById(R.id.recyclerViewBaiBao);

        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewBaiBao.setLayoutManager(layoutLinear);

        baiBaoAdapter = new BaiBaoAdapter(this, recyclerViewDatas);
        recyclerViewBaiBao.setAdapter(baiBaoAdapter);
    }

    ArrayList<BaiBao> getDataForRecyclerView() {
        ArrayList<BaiBao> ds = new ArrayList<>();


        ds.add(new BaiBao(
                "baibao",
                "Thủ tướng khảo sát địa điểm dự kiến xây kho dự trữ xăng dầu quốc gia",
                "https://vnexpress.net/thu-tuong-khao-sat-dia-diem-du-kien-xay-kho-du-tru-xang-dau-quoc-gia-5056110.html",
                "Khảo sát vị trí xây dựng kho dự trữ xăng dầu quốc gia trong thời gian tới."
        ));

        ds.add(new BaiBao(
                "tainan",
                "Ôtô chở 29 người rơi xuống vực ở Tam Đảo",
                "https://vnexpress.net/oto-cho-29-nguoi-roi-xuong-vuc-o-tam-dao-5056089.html",
                "Vụ tai nạn khiến nhiều người bị thương tại khu vực Tam Đảo."

        ));

        return ds;
    }
}