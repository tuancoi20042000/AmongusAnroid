package com.example.amongapp;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class AnhAdapter extends ArrayAdapter<Integer> {
    ArrayList<Integer> arr;
    Context ct;
    int chon = 0;

    public  AnhAdapter(@NonNull Context context, int resource, @NonNull List<Integer>objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    public void upDate(ArrayList<Integer> a){
        this.arr = new ArrayList<>(a);
        notifyDataSetChanged();

    }
    public void upDateChon(int chon){
        this.chon = chon;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return arr.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_anh,null);
        }
        MyImage image = convertView.findViewById(R.id.imgAnh);
        image.setImageResource(arr.get(position));
        if(chon == position){
            image.setBackgroundResource(R.drawable.video_bgs);
        }
        else{
            image.setBackgroundResource(R.drawable.video_bg);
        }
        return convertView;
    }
}
