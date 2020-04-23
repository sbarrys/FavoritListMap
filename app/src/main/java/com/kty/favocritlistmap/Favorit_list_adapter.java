package com.kty.favocritlistmap;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Favorit_list_adapter extends  RecyclerView.Adapter<Favorit_list_adapter.CustomViewHolder>{
    private ArrayList<favorit_list_VO> Data_List;

    public  class CustomViewHolder extends RecyclerView.ViewHolder{
        public TextView name, lan,lon;

        public CustomViewHolder(View view) {
            super(view);
            this.name=  view.findViewById(R.id.name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Favorit_list_adapter(ArrayList<favorit_list_VO> myDataset) {
        Data_List = myDataset;
    }


    //새로운 뷰를 생성
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorite_single, parent, false);
        return  new CustomViewHolder(view);

    }
    //레이아웃 매니져에 의해서 생성된 뷰들 배치.
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        // - 데이터 셋으로 부터 각 포지션에 맞는 데이터 생성.
        // - replace the contents of the view with that element.
        Log.d("데이터리스트", "onBindViewHolder: "+position);

        holder.name.setText(Data_List.get(position).getItem());
        //클릭이벤트
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //번들이라는 데이터 포장용기에 담아서 mapFragment 생성할떄 보내주면, 거기서 받아서 지도위치를 탐색할것이다.
                Bundle bundle= new Bundle();

                bundle.putString("Name",Data_List.get(position).getItem());
                bundle.putDouble("X",Data_List.get(position).getX());
                bundle.putDouble("Y",Data_List.get(position).getY());
                Log.d("adapter에서Bundle", "onClick: "+bundle.toString());
                MapFragment mapFragment= new MapFragment();
                mapFragment.setArguments(bundle);
                Log.d("클릭", "onClick: 클릭?");
                //클릭시 name과 좌표정보를 지도 프래그먼트로 보내자.
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.area_map, mapFragment).addToBackStack(null).commit();
            }
    });

    }

    @Override
    public int getItemCount() {

        return Data_List.size();
    }


}