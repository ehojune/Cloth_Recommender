
package com.example.cloth_recommender;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.cloth_recommender.Frag1.Frag1;
import com.example.cloth_recommender.Frag2.Frag2;
import com.google.android.material.tabs.TabLayout;
import com.kakao.network.ApiErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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

        getHashKey();

        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.view_pager);
        adapter=new FragmentAdapter(getSupportFragmentManager(),1);

        //FragmentAdapter에 컬렉션 담기
        adapter.addFragment(new Frag1());
        adapter.addFragment(new Frag2());
        adapter.addFragment(new LoginActivity());

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

    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }
}