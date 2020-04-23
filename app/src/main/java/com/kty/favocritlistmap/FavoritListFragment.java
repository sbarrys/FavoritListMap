package com.kty.favocritlistmap;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class FavoritListFragment extends Fragment {

    private ArrayList<favorit_list_VO> favorit_list_vo_list= new ArrayList<>();
    private RecyclerView recyclerView;
    private Favorit_list_adapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_favorit_list, container, false);

        //recyclerview설정
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mAdapter= new Favorit_list_adapter(favorit_list_vo_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareData();
    }
    //데이터 준비(최종적으로는 동적으로 추가하거나 삭제할 수 있어야 한다. 이 데이터를 어디에 저장할지 정해야 한다.)
    private void prepareData() {
        favorit_list_vo_list.add(new favorit_list_VO("서울시청",37.556491,126.977881));
        favorit_list_vo_list.add(new favorit_list_VO("경복궁",37.580246,126.9777234));
        favorit_list_vo_list.add(new favorit_list_VO("서울역",37.555324,126.971350));
        favorit_list_vo_list.add(new favorit_list_VO("남산",37.555390,126.981656));
        favorit_list_vo_list.add(new favorit_list_VO("을지로입구역",37.566312,126.982722));
}

}
