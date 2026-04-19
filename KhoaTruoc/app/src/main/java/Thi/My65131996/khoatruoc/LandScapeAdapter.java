package Thi.My65131996.khoatruoc;

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
import java.util.Date;
import java.util.zip.Inflater;

public class LandScapeAdapter extends RecyclerView.Adapter< LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom= LayoutInflater.from(context);
        View vItem= cai_bom.inflate(R.layout.item_land,parent,false);
        ItemLandHolder viewHolderCreate= new ItemLandHolder(vItem);

        return viewHolderCreate;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
// lay doi tuong hien thi
        LandScape landScapHienThi= lstData.get(position);
        //trich thong tin
        String caption= landScapHienThi.getLandCation();
        String tenfileAnh= landScapHienThi.getLandImageFilename();
        //dawt vao ca TH thong tin cia holder
        holder.tvCaption.setText(caption);
        //dat anh
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID= holder.itemView.getResources().getIdentifier(tenfileAnh,"mipmap", packageName);
        holder.ivlandScape.setImageResource(imageID);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(landScapHienThi.getUrl()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder{
        TextView tvCaption;
        ImageView ivlandScape;
        public ItemLandHolder(@NonNull View itemView){
            super(itemView);
            tvCaption= itemView.findViewById(R.id.textViewCaption);
            ivlandScape= itemView.findViewById(R.id.imageViewLand);
        }

    }
}
