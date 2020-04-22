package com.kty.favocritlistmap;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class InfoNearByFragment extends Fragment {
    private LinearLayout buttonSub1;
    private LinearLayout buttonSub2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_info_near_by, container, false);
        //처음 childfragment 지정
        Log.d("111111", "onCreateView: 111111");
        getFragmentManager().beginTransaction().add(R.id.child_fragment, new SubOneFragment()).commit();
        Log.d("22222222", "onCreateView: 222222");

        buttonSub1= (LinearLayout)v.findViewById(R.id.buttonSub1);
        buttonSub2= (LinearLayout)v.findViewById(R.id.buttonSub2);

        buttonSub1.setClickable(true);
        buttonSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

                transaction.replace(R.id.child_fragment,new SubOneFragment());
                transaction.commit();
                //프래그먼트 매니져를 통해서.
                //Transaction 을 시작하고,  replace시킨다. 현재 액티비티의 framgment_map이라는 이름을 가진 fragment컴포넌트에 MapFragement라는 액티비티(fragment)를
            }
        });
        buttonSub2.setClickable(true);
        buttonSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("안녕","안녕");
                Toast.makeText(getContext(),"안녕",Toast.LENGTH_SHORT).show();

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.child_fragment,new SubTwoFragment());
                transaction.commit();
                //프래그먼트 매니져를 통해서.
                //Transaction 을 시작하고,  replace시킨다. 현재 액티비티의 framgment_map이라는 이름을 가진 fragment컴포넌트에 MapFragement라는 액티비티(fragment)를
            }
        });

        return v;
    }

}
