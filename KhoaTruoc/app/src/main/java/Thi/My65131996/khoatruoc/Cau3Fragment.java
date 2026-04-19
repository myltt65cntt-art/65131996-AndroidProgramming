package Thi.My65131996.khoatruoc;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
public class Cau3Fragment extends Fragment {
    LandScapeAdapter adapter;
    ArrayList<LandScape>List;
    RecyclerView recyclerViewLandScape;
    public Cau3Fragment() {
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
                "Lăng Bác"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewCau3=  inflater.inflate(R.layout.fragment_cau3, container, false);
        recyclerViewLandScape= viewCau3.findViewById(R.id.ryCau3);
        RecyclerView.LayoutManager layoutLinear= new LinearLayoutManager(viewCau3.getContext());
        recyclerViewLandScape.setLayoutManager(layoutLinear);

        adapter= new LandScapeAdapter(viewCau3.getContext(),List);
        recyclerViewLandScape.setAdapter(adapter);

        return viewCau3;
    }
}