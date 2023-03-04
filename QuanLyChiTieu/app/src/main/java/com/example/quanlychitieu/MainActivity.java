package com.example.quanlychitieu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Database database;
    RecyclerView rcQuanLyChiTieu;
    ChiTieuAdapter chiTieuAdapter;
    ArrayList<ChiTieu> chiTieuArrayList = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList1 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList2 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList3 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList4 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList5 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList6 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList7 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList8 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList9 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList10 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList11 = new ArrayList<>();
    ArrayList<ChiTieu> chiTieuArrayList12 = new ArrayList<>();
    TextView txtHienThiSoTien;
    Button btnChonThang;
    Calendar calendar1;
    Calendar calendar2;
    public Long tongCa = 0l,tong1 = 0l,tong2 = 0l,tong3 = 0l,tong4 = 0l,tong5 = 0l,tong6 = 0l,tong7 = 0l,tong8 = 0l,tong9 = 0l,tong10 = 0l,tong11 = 0l,tong12 = 0l;
    String ngayMoc = "01/01/2023";
    Date dateMoc = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AddLayout();
        // tạo database cho app
        database = new Database(this,"quanly.sqlite", null, 1);

        // tạo bảng chứa dữ liệu
        database.QueryData("CREATE TABLE IF NOT EXISTS ChiTieu(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenKhoanChi VARCHAR(200), SoTien INTEGER, NgayChi TEXT)");

//        thêm dữ liệu vào data
//        database.QueryData("INSERT INTO ChiTieu VALUES(null, 'Mua bánh mì', '10000', '29/12/2022')");

        GetDataChiTieu();




        Thongke();
        btnChonThang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonThang();
            }
        });
    }
    public  void Thongke(){
        try {
            dateMoc = new SimpleDateFormat("dd/MM/yyyy").parse(ngayMoc);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (chiTieuArrayList.size() == 0){
            txtHienThiSoTien.setText("0 Đồng");
        }
        else {
            for (int i = 0; i < chiTieuArrayList.size(); i++) {
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(chiTieuArrayList.get(i).getNgayChi());
                    int khoangcachngay = (int) ((date.getTime()-dateMoc.getTime())/(1000*60*60*24));

                    if(0 <= khoangcachngay && khoangcachngay <= 30){
                        // tháng 1
                        tong1 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList1.add(chiTieuArrayList.get(i));
                    }
                    if(31 <= khoangcachngay && khoangcachngay <= 58){
                        // tháng 2
                        tong2 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList2.add(chiTieuArrayList.get(i));
                    }
                    if(59 <= khoangcachngay && khoangcachngay <= 89){
                        // tháng 3
                        tong3 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList3.add(chiTieuArrayList.get(i));
                    }
                    if(90 <= khoangcachngay && khoangcachngay <= 119){
                        // tháng 4
                        tong4 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList4.add(chiTieuArrayList.get(i));
                    }
                    if(120 <= khoangcachngay && khoangcachngay <= 150){
                        // tháng 5
                        tong5 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList5.add(chiTieuArrayList.get(i));
                    }
                    if(151 <= khoangcachngay && khoangcachngay <= 180){
                        // tháng 6
                        tong6 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList6.add(chiTieuArrayList.get(i));
                    }
                    if(181 <= khoangcachngay && khoangcachngay <= 211){
                        // tháng 7
                        tong7 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList7.add(chiTieuArrayList.get(i));
                    }
                    if(212 <= khoangcachngay && khoangcachngay <= 242){
                        // tháng 8
                        tong8 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList8.add(chiTieuArrayList.get(i));
                    }
                    if(243 <= khoangcachngay && khoangcachngay <= 272){
                        // tháng 9
                        tong9 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList9.add(chiTieuArrayList.get(i));
                    }
                    if(273 <= khoangcachngay && khoangcachngay <= 303){
                        // tháng 10
                        tong10 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList10.add(chiTieuArrayList.get(i));
                    }
                    if(304 <= khoangcachngay && khoangcachngay <= 333){
                        // tháng 11
                        tong11 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList11.add(chiTieuArrayList.get(i));
                    }
                    if (334 <= khoangcachngay && khoangcachngay <= 365){
                        // tháng 12
                        tong12 +=  chiTieuArrayList.get(i).getSoTien();
                        chiTieuArrayList12.add(chiTieuArrayList.get(i));
                    }
                    else {

                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void GetDataChiTieu(){

        //trả dữ liệu ra
        Cursor dataChiTieu = database.GetData("SELECT * FROM ChiTieu");
        chiTieuArrayList.clear();
        while (dataChiTieu.moveToNext()){
            int id = dataChiTieu.getInt(0);
            String tenKhoanChi = dataChiTieu.getString(1);
            int soTien = dataChiTieu.getInt(2);
            String ngayChi = dataChiTieu.getString(3);
            chiTieuArrayList.add(new ChiTieu(id,tenKhoanChi,soTien,ngayChi));

        }
        chiTieuAdapter.notifyDataSetChanged();
    }
    // add menu vào
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_khoanchi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // thiết lập menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuAdd){
            DiaLogThem();
        }
        return super.onOptionsItemSelected(item);
    }
    // xóa khoản chi tiêu
    public void DiaLogXoaChiTieu(int id, String khoanChi, int soTien , String ngayChi){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa dòng chi tiêu: "+ khoanChi+ " không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                database.QueryData("DELETE FROM ChiTieu WHERE Id = '"+id+"'");
                GetDataChiTieu();
                resetTien();
                Thongke();
                btnChonThang.setText("Chọn Tháng");
                txtHienThiSoTien.setText("0 Đồng");
                Toast.makeText(MainActivity.this, "Đã Xóa Khoản Chi: " + khoanChi, Toast.LENGTH_SHORT).show();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }

    // DiaLog cập nhập công việc
    public void DiaLogCapNhatChiTieu(int id, String khoanChi, int soTien , String ngayChi){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_sua_khoan_chi);
        dialog.setCanceledOnTouchOutside(false);

        EditText edtTenKhoanChi = dialog.findViewById(R.id.editSuaTextKhoanChi);
        EditText edtSoTien = dialog.findViewById(R.id.editSuaTextzSoTien);
        TextView txtNgayChi = dialog.findViewById(R.id.txtSuaTextNgayChi);
        Button btnCapNhat = dialog.findViewById(R.id.buttonSuaCapNhap);
        Button btnHuy = dialog.findViewById(R.id.buttonSuaHuy);

        edtTenKhoanChi.setText(khoanChi);
        edtSoTien.setText(soTien + "");
        txtNgayChi.setText(ngayChi);

        txtNgayChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int ngay = calendar.get(Calendar.DATE);
                int thang = calendar.get(Calendar.MONTH);
                int nam = calendar.get(Calendar.YEAR);

                // ấn để chọn giờ
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        txtNgayChi.setText(simpleDateFormat.format(calendar.getTime()));

                    }
                },nam, thang, ngay);
                datePickerDialog.show();


            }
        });

        //button hủy
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        //button cập nhập công việc
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String khoanChi = edtTenKhoanChi.getText().toString().trim();
                String soTien = edtSoTien.getText().toString().trim();
                String ngayChi = txtNgayChi.getText().toString().trim();

                if (khoanChi.equals("") || soTien.equals("")  || ngayChi.equals("") ){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.QueryData("UPDATE ChiTieu SET TenKhoanChi = '"+khoanChi +"', SoTien = '"+soTien +"', NgayChi = '"+ngayChi +"' WHERE Id = '"+ id+"'");
                    Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataChiTieu();
                    resetTien();
                    Thongke();
                    btnChonThang.setText("Chọn Tháng");
                    txtHienThiSoTien.setText("0 Đồng");
                }
            }
        });

        dialog.show();
    }

    // tạo dialog thêm chi tiêu
    private void DiaLogThem(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_khoan_chi);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        EditText edtTenKhoanChi = dialog.findViewById(R.id.editAddTextKhoanChi);
        EditText edtSoTien = dialog.findViewById(R.id.editAddTextzSoTien);
        TextView txtNgayChi = dialog.findViewById(R.id.txtAddTextNgayChi);
        Button btnXacNhan = dialog.findViewById(R.id.buttonXacNhan);
        Button btnHuy = dialog.findViewById(R.id.buttonHuy);

        txtNgayChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int ngay = calendar.get(Calendar.DATE);
                int thang = calendar.get(Calendar.MONTH);
                int nam = calendar.get(Calendar.YEAR);

                // ấn để chọn giờ
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        txtNgayChi.setText(simpleDateFormat.format(calendar.getTime()));

                    }
                },nam, thang, ngay);
                datePickerDialog.show();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String khoanChi = edtTenKhoanChi.getText().toString().trim();
                String soTien = edtSoTien.getText().toString().trim();
                String ngayChi = txtNgayChi.getText().toString().trim();

                if (khoanChi.equals("") || soTien.equals("") || ngayChi.equals("") ){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.QueryData("INSERT INTO ChiTieu VALUES(null, '" + khoanChi +"', '"+ soTien +"', '"+ ngayChi +"')");
                    Toast.makeText(MainActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataChiTieu();
                    resetTien();
                    Thongke();
                    btnChonThang.setText("Chọn Tháng");
                    txtHienThiSoTien.setText("0 Đồng");
                }
            }
        });
    }

    // Thống kê tháng Tháng
    private void ChonThang(){
        PopupMenu popupMenu = new PopupMenu(this, btnChonThang);
        popupMenu.getMenuInflater().inflate(R.menu.button_thang, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.btnTatCa:btnChonThang.setText("Tất cả");
                        tongCa = tong1 + tong2 + tong3 + tong4 + tong5 + tong6 + tong7 + tong8 + tong9 + tong10 + tong11 + tong12;
                        txtHienThiSoTien.setText(tongCa + "Đồng");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        break;

                    case R.id.btnThang1:btnChonThang.setText("Tháng 1");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList1, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong1+"Đồng");
                        break;

                    case R.id.btnThang2:btnChonThang.setText("Tháng 2");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList2, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong2+"Đồng");
                        break;

                    case R.id.btnThang3:btnChonThang.setText("Tháng 3");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList3, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong3+"Đồng");
                        break;

                    case R.id.btnThang4:btnChonThang.setText("Tháng 4");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList4, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong4+"Đồng");
                        break;

                    case R.id.btnThang5:btnChonThang.setText("Tháng 5");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList5, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong5+"Đồng");
                        break;

                    case R.id.btnThang6:btnChonThang.setText("Tháng 6");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList6, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong6+"Đồng");
                        break;

                    case R.id.btnThang7:btnChonThang.setText("Tháng 7");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList7, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong7+"Đồng");
                        break;

                    case R.id.btnThang8:btnChonThang.setText("Tháng 8");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList8, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong8+"Đồng");
                        break;

                    case R.id.btnThang9:btnChonThang.setText("Tháng 9");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList9, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong9+"Đồng");
                        break;

                    case R.id.btnThang10:btnChonThang.setText("Tháng 10");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList10, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong10+"Đồng");
                        break;
                    case R.id.btnThang11:btnChonThang.setText("Tháng 11");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList11, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong11+"Đồng");
                        break;

                    case R.id.btnThang12:btnChonThang.setText("Tháng 12");
                        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList12, MainActivity.this);
                        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);
                        txtHienThiSoTien.setText(tong12+"Đồng");
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void resetTien(){
        tongCa=0l;
        tong1=0l;
        tong2=0l;
        tong3=0l;
        tong4=0l;
        tong5=0l;
        tong6=0l;
        tong7=0l;
        tong8=0l;
        tong9=0l;
        tong10=0l;
        tong11=0l;
        tong12=0l;
        chiTieuArrayList1.clear();
        chiTieuArrayList2.clear();
        chiTieuArrayList3.clear();
        chiTieuArrayList4.clear();
        chiTieuArrayList5.clear();
        chiTieuArrayList6.clear();
        chiTieuArrayList7.clear();
        chiTieuArrayList8.clear();
        chiTieuArrayList9.clear();
        chiTieuArrayList10.clear();
        chiTieuArrayList11.clear();
        chiTieuArrayList12.clear();
    }

    // ánh xạ và add layout
    public void AddLayout(){
        // ánh xạ view
        txtHienThiSoTien = findViewById(R.id.txvHienThiSoTien);
        btnChonThang= findViewById(R.id.buttonThang);

        //ánh xạ recyclerview
        rcQuanLyChiTieu = findViewById(R.id.rcQuanLyChiTieu);
        rcQuanLyChiTieu.setLayoutManager(new LinearLayoutManager(this));
        // tạo divider ngăn các item trong recycleview
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcQuanLyChiTieu.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        rcQuanLyChiTieu.addItemDecoration(dividerItemDecoration);

        chiTieuAdapter = new ChiTieuAdapter(chiTieuArrayList, this);
        rcQuanLyChiTieu.setAdapter(chiTieuAdapter);


    }
}
