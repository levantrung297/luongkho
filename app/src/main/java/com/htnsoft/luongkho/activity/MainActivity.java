package com.htnsoft.luongkho.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.htnsoft.luongkho.R;
import com.htnsoft.luongkho.adapter.DanhMucAdapter;
import com.htnsoft.luongkho.adapter.SanPhamAdapter;
import com.htnsoft.luongkho.model.danhmuc;
import com.htnsoft.luongkho.model.quangcao;
import com.htnsoft.luongkho.model.sanpham;
import com.htnsoft.luongkho.util.Checkconnect;
import com.htnsoft.luongkho.util.Server;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    android.support.v7.widget.Toolbar toolbar;
    ListView listViewMain;
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    ArrayList<sanpham> mangsanpham;
    ArrayList<quangcao> mangquangcao;
    ArrayList<danhmuc> mangdanhmuc;
    SanPhamAdapter sanphamAdapter;
    DanhMucAdapter danhMucAdapter;
    RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionBar();
        if (Checkconnect.haveNetworkConnection(getApplicationContext())){
            ActionViewFlipper();
            GetDuLieuSPMoiNhat();
            ActionNavigation();
        }else {
            Checkconnect.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối");
        }

    }

    private void ActionNavigation() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.linkdanhmuc, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response !=null){
                    for (int i=0; i<response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            int madanhmuc = jsonObject.getInt("id");
                            String tendanhmuc = jsonObject.getString("ten");
                            String hinhanhdanhmuc = jsonObject.getString("hinhanh");
                            mangdanhmuc.add(new danhmuc(madanhmuc, tendanhmuc, hinhanhdanhmuc));
                            danhMucAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void GetDuLieuSPMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.linkSPmoiNhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response !=null){
                    int Masanpham=0;
                    String Tensanpham ="";
                    Integer Giasanpham =0;
                    String Hinhanhsanpham="";
                    String Motasanpham="";
                    int Loaisanpham=0;
                    for (int i=0; i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Masanpham = jsonObject.getInt("masp");
                            Tensanpham = jsonObject.getString("tensp");
                            Giasanpham = jsonObject.getInt("giasp");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            Motasanpham = jsonObject.getString("motasp");
                            Loaisanpham = jsonObject.getInt("loaisp");
                            mangsanpham.add(new sanpham(Masanpham, Tensanpham, Giasanpham, Motasanpham, Hinhanhsanpham, Loaisanpham));
                            sanphamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFlipper() {
        mangquangcao = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest( Server.linkquangcao, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0 ; i< response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int maqc = jsonObject.getInt("MaQC");
                        String tenqc = jsonObject.getString("TenQC");
                        String motaqc = jsonObject.getString("MoTaQC");
                        String hinhanh = jsonObject.getString("HinhAnhQC");
                        mangquangcao.add(new quangcao(maqc, tenqc, motaqc,hinhanh));
                        ImageView imageView = new ImageView(getApplicationContext());
                        Picasso.with(getApplicationContext()).load(mangquangcao.get(i).getHinhAnhQC().toString().trim()).into(imageView);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        viewFlipper.addView(imageView);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Bạn gặp lôi " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void AnhXa() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarmain);
        navigationView = (NavigationView) findViewById(R.id.navigationmain);
        listViewMain = (ListView) findViewById(R.id.listviewmain);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        mangsanpham = new ArrayList<>();
        sanphamAdapter = new SanPhamAdapter(getApplicationContext(),mangsanpham);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerview.setAdapter(sanphamAdapter);
        mangdanhmuc = new ArrayList<danhmuc>();
        danhMucAdapter = new DanhMucAdapter(getApplicationContext(), R.layout.dong_danh_muc, mangdanhmuc);
        listViewMain.setAdapter(danhMucAdapter);
    }
}
