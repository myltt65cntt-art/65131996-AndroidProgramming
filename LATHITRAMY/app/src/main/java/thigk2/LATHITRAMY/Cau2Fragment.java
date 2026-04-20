package thigk2.LATHITRAMY;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
public class Cau2Fragment extends Fragment {
    LandScapeAdapter adapter;
    ArrayList<LandScape>List;
    RecyclerView recyclerViewLandScape;
    public Cau2Fragment() {
    }
    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List = new ArrayList<>();
        List.add(new LandScape("eff","THÁP EFFEL",
                "THÁP EFFEL"));
        List.add(new LandScape("buckingham","buckingham",
                "buckingham"));
        List.add(new LandScape("lb","Lăng Bác",
                "Lăng Bác"));
        List.add(new LandScape("cchn","Tháp Hà Nội",
                ""));
        List.add(new LandScape("cdh","CUNG ĐÌNH HUẾ",
                ""));
        List.add(new LandScape("bnt","Biển Nha Trang",
                ""));
        List.add(new LandScape("cdh","Hồ Gươm",
                ""));
        List.add(new LandScape("cdh","Chùa Một Cột",
                ""));
        List.add(new LandScape("cdh","CUNG ĐÌNH HUẾ",
                ""));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewCau2=  inflater.inflate(R.layout.fragment_cau2, container, false);
        recyclerViewLandScape= viewCau2.findViewById(R.id.ryCau2);
        RecyclerView.LayoutManager layoutLinear= new LinearLayoutManager(viewCau2.getContext());
        recyclerViewLandScape.setLayoutManager(layoutLinear);

        adapter= new LandScapeAdapter(viewCau2.getContext(),List);
        recyclerViewLandScape.setAdapter(adapter);

        return viewCau2;
    }
}