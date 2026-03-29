package my.example.appmonan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        // tim listview
        ListView lvDSNonAn = (ListView) findViewById(R.id.lvDSMonAn);
        // chuẩn bị dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<>();

        dsMonAn.add(new MonAn("Cơm tắm sườn",25000,"mô tả đây",R.drawable.comtam));
        dsMonAn.add(new MonAn("Cơm sườn trứng",30000,"mô tả đây",R.drawable.cst));
        dsMonAn.add(new MonAn("Gà xối mở",30000,"mô tả đây",R.drawable.cgsm));
        dsMonAn.add(new MonAn("Sườn bì chả",32000,"mô tả đây",R.drawable.csbc));
        dsMonAn.add(new MonAn("Cơm tắm đặc biệt",35000,"mô tả đây",R.drawable.db));
        MonAnAdapter adapter = new MonAnAdapter(this,dsMonAn);
        lvDSNonAn.setAdapter(adapter);
        lvDSNonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonAn monANchon = dsMonAn.get(position);
                Toast.makeText(MainActivity.this, monANchon.getTenMonAn(),Toast.LENGTH_SHORT).show();

            }
        });



    }
}