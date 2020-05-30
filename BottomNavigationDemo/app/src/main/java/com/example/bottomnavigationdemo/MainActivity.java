package com.example.bottomnavigationdemo;

import android.os.Bundle;

import com.example.bottomnavigationdemo.fragment.DashboardFragment;
import com.example.bottomnavigationdemo.fragment.HomeFragment;
import com.example.bottomnavigationdemo.fragment.MyselfFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        initView();
        replaceFragment(new HomeFragment()); //启动时用HomeFragment替换掉空Fragment
    }

    @Override
    //处理导航栏子项的点击事件
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();//获取点击的位置以及对应的id
        switch (itemId) {
            case R.id.navigation_home:
                replaceFragment(new HomeFragment());//id为tab_one则第一项被点击，遂用HomeFragment替换空Fragment
                menuItem.setChecked(true);
                break;
            case R.id.navigation_dashboard:
                replaceFragment(new DashboardFragment());
                menuItem.setChecked(true);
                break;
            case R.id.navigation_notifications:
                replaceFragment(new MyselfFragment());
                menuItem.setChecked(true);
                break;
        }
        return false;
    }


    public void initView() {
        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);//设置导航栏监听器
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);//设置默认选择的导航栏子项tab_one即首页
        bottomNavigationView.setItemIconTintList(null);//取消导航栏子项图片的颜色覆盖
    }

    //替换Fragment的方法
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_empty, fragment);
        transaction.commit();
    }
}
