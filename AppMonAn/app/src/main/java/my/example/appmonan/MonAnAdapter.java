package my.example.appmonan;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;

    private Context context;

    public MonAnAdapter(Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewHienHanh = view;

        if (viewHienHanh == null) {
            viewHienHanh = layoutInflater.inflate(R.layout.item_monan, viewGroup, false);
        }

        MonAn monAnhienTai = dsMonAn.get(i);

        TextView textView_TenMon = viewHienHanh.findViewById(R.id.tvTenMonAn);
        TextView textView_DonGia = viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = viewHienHanh.findViewById(R.id.tvMota);
        ImageView imageView_Anh = viewHienHanh.findViewById(R.id.imAnhDaiDien);

        textView_TenMon.setText(monAnhienTai.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnhienTai.getDonGia()));
        textView_MoTa.setText(monAnhienTai.getMoTa());
        imageView_Anh.setImageResource(monAnhienTai.getAnh());

        return viewHienHanh;
    }


}
