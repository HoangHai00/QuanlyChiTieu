package com.example.quanlychitieu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ChiTieuAdapter extends RecyclerView.Adapter<ChiTieuAdapter.ViewHolder>{
  public   ArrayList<ChiTieu> chiTieuList;
    public  MainActivity context;
    int khoangcachngay;

    public ChiTieuAdapter(ArrayList<ChiTieu> chiTieuList, MainActivity context) {
        this.chiTieuList = chiTieuList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.dong_chi_tieu,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ChiTieu chiTieu = chiTieuList.get(position);

        // sắp xếp theo ngày tháng năm
        Collections.sort(chiTieuList, new Comparator<ChiTieu>() {
            @Override
            public int compare(ChiTieu o1, ChiTieu o2) {
                try {
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getNgayChi());
                    Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getNgayChi());
                   khoangcachngay = (int) ((date1.getTime() - date2.getTime())/(1000*60*60*24));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (khoangcachngay <0) {
                    return -1;
                }
                if (khoangcachngay == 0) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });


        holder.txtKhoanChi.setText(chiTieuList.get(position).getTenKhoanChi()+"");
        holder.txtSoTien.setText(chiTieuList.get(position).getSoTien()+"");
        holder.txtNgayChi.setText(chiTieuList.get(position).getNgayChi()+"");


        holder.imgSua.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                context.DiaLogCapNhatChiTieu(chiTieu.getIdChiTieu(), chiTieu.getTenKhoanChi(),chiTieu.getSoTien(), chiTieu.getNgayChi());
            }
        });
        

        holder.imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DiaLogXoaChiTieu(chiTieu.getIdChiTieu(), chiTieu.getTenKhoanChi(),chiTieu.getSoTien(), chiTieu.getNgayChi());
            }
        });
    }

    @Override
    public int getItemCount() {
        return chiTieuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtKhoanChi, txtSoTien, txtNgayChi;
        ImageView imgXoa, imgSua;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtKhoanChi = itemView.findViewById(R.id.txtKhoanChi);
            txtNgayChi = itemView.findViewById(R.id.txtNgayChi);
            txtSoTien = itemView.findViewById(R.id.txtSoTien);
            imgXoa = itemView.findViewById(R.id.imgXoa);
            imgSua = itemView.findViewById(R.id.imgSua);

        }
    }
}
