package com.example.cloth_recommender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.cloth_recommender.Frag1.Frag1;
import com.example.cloth_recommender.Frag2.Frag2;
import com.example.cloth_recommender.Frag3.Frag3;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.view_pager);
        adapter=new FragmentAdapter(getSupportFragmentManager(),1);

        //FragmentAdapter에 컬렉션 담기
        adapter.addFragment(new Frag1());
        adapter.addFragment(new Frag2());
        adapter.addFragment(new Frag3());

        //ViewPager Fragment 연결
        viewPager.setAdapter(adapter);

        //ViewPager과 TabLayout 연결
        tabLayout.setupWithViewPager(viewPager);

        //tabLayout.getTabAt(0).setText("첫 번째");
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        //tabLayout.getTabAt(1).setText("두 번째");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_bookmark_24);
        //tabLayout.getTabAt(2).setText("세 번째");
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_person_24);
        //View view1 = getLayoutInflater().inflate(R.layout.custom_tabicon, null);
        //view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.tabicon_home);
        //tabLayout.addTab(tabLayout.newTab().setCustomView(view1));


        //View view2 = getLayoutInflater().inflate(R.layout.custom_tabicon, null);
        //view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.tabicon_saved);
        //tabLayout.addTab(tabLayout.newTab().setCustomView(view2));


        //View view3 = getLayoutInflater().inflate(R.layout.custom_tabicon, null);
        //view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.tabicon_mypage);
        //tabLayout.addTab(tabLayout.newTab().setCustomView(view3));


    }
}