package com.example.drawerlayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initview();
        //初始化actionbar
        initactionbar();
        //初始化viewpager
        initViewPager();
    }

    private void initViewPager() {
        //创建一个集合,装fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        //把VR全景图和视频的fragment对象装入集合
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());
        //创建viewpager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.setFragments(fragments);
        //给viewpager设置适配器,
        viewPager.setAdapter(myPagerAdapter);
        //tablayout指示器有几个就创建几个
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
      //  tabLayout.addTab(tabLayout.newTab());
        //使用tablayout和viewpager相关联
        tabLayout.setupWithViewPager(viewPager);
        //给tablayout指示器添加文本
        tabLayout.getTabAt(0).setText("新闻");
        tabLayout.getTabAt(1).setText("每天");
       // tabLayout.getTabAt(2).setText("更多");

    }

    private void initactionbar() {
        //获取actionbar对象
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        toggle =  new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);


    }


    /**
     * 初始化控件
     */
    private void initview() {
        drawerLayout = (DrawerLayout) findViewById(R.id.dawerlayout);
        viewPager = (ViewPager) findViewById(R.id.tvviewpager);
        tabLayout = (TabLayout) findViewById(R.id.tvtablayout);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);

       // return super.onOptionsItemSelected(item);
    }
}
