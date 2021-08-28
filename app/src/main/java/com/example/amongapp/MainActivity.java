    package com.example.amongapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
    ImageView imgNenAnh, imgChonNhanVat, imgMu, imgQuan, imgPet, imgVote, imgVeAnhNen,imgVeAnhNhanVat, imgVeAnhMu, imgVeAnhQuan, imgVeAnhPet, imgVeAnhVote, imgDownload;
    GridView gdvChonItem;
    ArrayList<ImageView> arrChonKieu;
    ArrayList<Integer> arrAnhNen;
    ArrayList<Integer> arrAnhNhanVat;
        ArrayList<Integer> arrAnhMu;
        ArrayList<Integer> arrAnhQuan;
        ArrayList<Integer> arrAnhPet;
        ArrayList<Integer> arrAnhVote;

        int chonNen =0, chonNhanVat=0, chonMu=0, chonQuan=0, chonPet=0, chonVote=0;
        String danChonCaiGi ="";

    AnhAdapter anhAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
    }


    private  void init(){
    arrAnhNen = new ArrayList<>();
    arrAnhNen.add(R.drawable.z1);
        arrAnhNen.add(R.drawable.z2);
        arrAnhNen.add(R.drawable.z3);
        arrAnhNen.add(R.drawable.z4);
        arrAnhNen.add(R.drawable.z5);
        arrAnhNen.add(R.drawable.z6);
        arrAnhNen.add(R.drawable.z7);
        arrAnhNen.add(R.drawable.z8);
        arrAnhNen.add(R.drawable.z9);



        arrAnhNhanVat = new ArrayList<>();
        arrAnhNhanVat.add(R.drawable.x1);
        arrAnhNhanVat.add(R.drawable.x2);
        arrAnhNhanVat.add(R.drawable.x3);
        arrAnhNhanVat.add(R.drawable.x4);
        arrAnhNhanVat.add(R.drawable.x5);
        arrAnhNhanVat.add(R.drawable.x6);
        arrAnhNhanVat.add(R.drawable.x12);

        arrAnhMu = new ArrayList<>();
        arrAnhMu.add(R.drawable.v1);
        arrAnhMu.add(R.drawable.v2);
        arrAnhMu.add(R.drawable.v3);
        arrAnhMu.add(R.drawable.v4);
        arrAnhMu.add(R.drawable.v5);
        arrAnhMu.add(R.drawable.v6);
        arrAnhMu.add(R.drawable.v7);
        arrAnhMu.add(R.drawable.v8);
        arrAnhMu.add(R.drawable.v9);

        arrAnhQuan = new ArrayList<>();
        arrAnhQuan.add(R.drawable.n1);
        arrAnhQuan.add(R.drawable.n2);
        arrAnhQuan.add(R.drawable.n3);
        arrAnhQuan.add(R.drawable.n4);
        arrAnhQuan.add(R.drawable.n5);
        arrAnhQuan.add(R.drawable.n6);
        arrAnhQuan.add(R.drawable.n7);
        arrAnhQuan.add(R.drawable.n8);
        arrAnhQuan.add(R.drawable.n9);

        arrAnhPet = new ArrayList<>();
        arrAnhPet.add(R.drawable.m1);
        arrAnhPet.add(R.drawable.m2);
        arrAnhPet.add(R.drawable.m3);
        arrAnhPet.add(R.drawable.m4);
        arrAnhPet.add(R.drawable.m5);
        arrAnhPet.add(R.drawable.m6);
        arrAnhPet.add(R.drawable.m7);
        arrAnhPet.add(R.drawable.m8);
        arrAnhPet.add(R.drawable.m9);
        arrAnhVote = new ArrayList<>();
        arrAnhVote.add(R.drawable.l1);
        arrAnhVote.add(R.drawable.l2);
        arrAnhVote.add(R.drawable.l3);

        anhAdapter = new AnhAdapter(this,0,arrAnhNen);
    }
    private void anhXa(){
        arrChonKieu = new ArrayList<>();
        imgNenAnh = (ImageView)findViewById(R.id.imgNenAnh);
        imgChonNhanVat = (ImageView)findViewById(R.id.imgChonNhanVat);
        imgMu = (ImageView)findViewById(R.id.imgMu);
        imgQuan = (ImageView)findViewById(R.id.imgQuan);
        imgPet = (ImageView)findViewById(R.id.imgPet);
        imgVote = findViewById(R.id.imgVote);
        imgDownload = findViewById(R.id.imgDownload);
        imgVeAnhNen = findViewById(R.id.imgVeAnhNen);
        imgVeAnhNhanVat=findViewById(R.id.imgVeAnhNhanVat);
        imgVeAnhMu= findViewById(R.id.imgVeAnhMu);
        imgVeAnhQuan=findViewById(R.id.imgVeAnhQuan);
        imgVeAnhPet=findViewById(R.id.imgVeAnhPet) ;
        imgVeAnhVote= findViewById(R.id.imgVeAnhVote);

        gdvChonItem = findViewById(R.id.gdvChonItem);
        arrChonKieu.add(imgNenAnh);
        arrChonKieu.add(imgChonNhanVat);
        arrChonKieu.add(imgMu);
        arrChonKieu.add(imgQuan);
        arrChonKieu.add(imgPet);
    }
    private void setUp(){
        danChonCaiGi="ChonNen";
        gdvChonItem.setAdapter(anhAdapter);
        veAnh();
    }

    private void setClick(){
        imgNenAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danChonCaiGi="ChonNen";
               setAnhDuocChon(imgNenAnh);
               anhAdapter.upDate(arrAnhNen);
               anhAdapter.upDateChon(chonNen);
               veAnh();
            }
        });
        imgChonNhanVat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danChonCaiGi="ChonNhanVat";
               setAnhDuocChon(imgChonNhanVat);
                anhAdapter.upDate(arrAnhNhanVat);
                anhAdapter.upDateChon(chonNhanVat);
                veAnh();
            }
        });
        imgMu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danChonCaiGi="ChonMu";
                setAnhDuocChon(imgMu);
                anhAdapter.upDate(arrAnhMu);
                anhAdapter.upDateChon(chonMu);
                veAnh();
            }
        });
        imgQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danChonCaiGi="ChonQuan";
                setAnhDuocChon(imgQuan);
                anhAdapter.upDate(arrAnhQuan);
                anhAdapter.upDateChon(chonQuan);
                veAnh();
            }
        });
        imgPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danChonCaiGi="ChonPet";
                setAnhDuocChon(imgPet);
                anhAdapter.upDate(arrAnhPet);
                anhAdapter.upDateChon(chonPet);
                veAnh();
            }
        });
        imgVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danChonCaiGi="ChonVote";
                setAnhDuocChon(imgVote);
                anhAdapter.upDate(arrAnhVote);
                anhAdapter.upDateChon(chonVote);
                veAnh();
            }
        });
        gdvChonItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                anhAdapter.upDateChon(position);
                if(danChonCaiGi.equals("ChonNen")){
                    chonNen = position;
                }else if(danChonCaiGi.equals("ChonNhanVat")){
                    chonNhanVat=position;
                }
                else if(danChonCaiGi.equals("ChonMu")){
                    chonMu=position;
                }
                else if(danChonCaiGi.equals("ChonQuan")){
                    chonQuan=position;
                }
                else if(danChonCaiGi.equals("ChonPet")){
                    chonPet=position;
                }
                else if(danChonCaiGi.equals("ChonVote")){
                    chonVote=position;
                }
                veAnh();
//                Toast.makeText(MainActivity.this,danChonCaiGi,Toast.LENGTH_SHORT).show();
            }
        });
        imgDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean a =  saveImageToGallery(R.id.layoutAnhVe);
            }
        });
    }
    private void setAnhDuocChon(ImageView img){
        for(ImageView i: arrChonKieu){
            i.setBackgroundColor(Color.WHITE);
        }
        img.setBackgroundColor(Color.parseColor("#FFEB3B"));
    }
    private void veAnh(){
        imgVeAnhNen.setImageResource(arrAnhNen.get(chonNen));
        imgVeAnhNhanVat.setImageResource(arrAnhNhanVat.get(chonNhanVat));
        imgVeAnhMu.setImageResource(arrAnhMu.get(chonMu));
        imgVeAnhQuan.setImageResource(arrAnhQuan.get(chonQuan));
        imgVeAnhPet.setImageResource(arrAnhPet.get(chonPet));
        imgVeAnhVote.setImageResource(arrAnhVote.get(chonVote));
    }
        public  boolean saveImageToGallery(int idlayout) {
            RelativeLayout rlMain =findViewById(idlayout);
            rlMain.setDrawingCacheEnabled(false);
            rlMain.setDrawingCacheEnabled(true);
            Bitmap bmp = rlMain.getDrawingCache();

            String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "dearxy";
            File appDir = new File(storePath);
            if (!appDir.exists()) {
                appDir.mkdir();
            }
            String fileName = System.currentTimeMillis() + ".png";
            File file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                boolean isSuccess = bmp.compress(Bitmap.CompressFormat.PNG, 60, fos);
                fos.flush();
                fos.close();

                MediaStore.Images.Media.insertImage(this.getContentResolver(), file.getAbsolutePath(), fileName, null);

                Uri uri = Uri.fromFile(file);
                this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
                if (isSuccess) {
                    Toast.makeText(this,"Lưu Thành Công",Toast.LENGTH_LONG).show();
                    return true;
                } else {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

    }