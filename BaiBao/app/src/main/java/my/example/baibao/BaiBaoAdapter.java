package my.example.baibao;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaiBaoAdapter extends RecyclerView.Adapter<BaiBaoAdapter.ItemBaiBaoHolder> {

    Context context;
    ArrayList<BaiBao> lstData;

    public BaiBaoAdapter(Context context, ArrayList<BaiBao> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemBaiBaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater caiBom = LayoutInflater.from(context);
        View vItem = caiBom.inflate(R.layout.item_bai_bao, parent, false);
        return new ItemBaiBaoHolder(vItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemBaiBaoHolder holder, int position) {
        BaiBao baiBaoHienThi = lstData.get(position);

        String tieuDe = baiBaoHienThi.getTieuDe();
        String tenFileAnh = baiBaoHienThi.getTenFileAnh();
        String mota = baiBaoHienThi.getMota();
        String duongDan = baiBaoHienThi.getDuongDan();

        holder.tvTieuDe.setText(tieuDe);
        holder.tvMota.setText(mota);

        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.ivBaiBao.setImageResource(imageID);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(duongDan));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public class ItemBaiBaoHolder extends RecyclerView.ViewHolder {
        TextView tvTieuDe;
        TextView tvMota;
        ImageView ivBaiBao;

        public ItemBaiBaoHolder(@NonNull View itemView) {
            super(itemView);
            tvTieuDe = itemView.findViewById(R.id.textViewTieuDe);
            tvMota = itemView.findViewById(R.id.textViewMoTa);
            ivBaiBao = itemView.findViewById(R.id.imageViewBaiBao);
        }
    }
}