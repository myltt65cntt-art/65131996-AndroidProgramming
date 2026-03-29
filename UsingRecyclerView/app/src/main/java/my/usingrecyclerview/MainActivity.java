package my.usingrecyclerview;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recylerViewDatas;
    RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //b3
        recylerViewDatas=getDataForRecyclerView();
        //b4
        recyclerViewLandScape= findViewById(R.id.recycleLand);
        //b5
        RecyclerView.LayoutManager layoutLinear= new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLinear);
//b6
        landScapeAdapter = new LandScapeAdapter(this,recylerViewDatas);
        //b7
        recyclerViewLandScape.setAdapter(landScapeAdapter);
    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLich= new ArrayList<LandScape>();
        LandScape landScape1= new LandScape("cchn","Tháp Hà Nội");
        dsDuLich.add(landScape1);
        dsDuLich.add(new LandScape("eff","THÁP EFFeL"));
        dsDuLich.add(new LandScape("buckingham","buckingham"));
        dsDuLich.add(new LandScape("lb","Lăng Bác"));
        return dsDuLich;
    }
}