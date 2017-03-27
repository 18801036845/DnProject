package com.example.dell.dnproject.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dell.dnproject.R;
import com.example.dell.dnproject.fragment.MessageFragment;
import com.example.dell.dnproject.fragment.PeopleFragment;
import com.example.dell.dnproject.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/3/27.
 */


public class MessageActivity extends AppCompatActivity implements View.OnClickListener {


    private Button  button_message,button_people,button_set;
    private ViewPager viewPager;
    FragmentManager  fm;
    private List<SettingFragment> list=new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        addTolist();
        init();
        init2();

    }

    private void init2() {
        button_message= (Button) findViewById(R.id.button_message);
        button_people= (Button) findViewById(R.id.button_people);
        button_set= (Button) findViewById(R.id.button_set);
        button_message.setOnClickListener(this);
        button_people.setOnClickListener(this);
        button_set.setOnClickListener(this);
    }

    private void init() {
        //开启事物
        fm=getSupportFragmentManager();
        //初始化viewPager
        viewPager= (ViewPager) findViewById(R.id.viewpaper);
        //给viewPager设置适配器
        FragmentPagerAdapter fp=new FragmentPagerAdapter(fm) {
            //获取item内容
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
            //获取item个数
            @Override
            public int getCount() {
                return list.size();
            }
        };
        //设置适配器
        viewPager.setAdapter(fp);
        //设置当前页面
        viewPager.setCurrentItem(0);



    }

    private void addTolist() {
        SettingFragment mf= new SettingFragment();
        SettingFragment pe= new SettingFragment();
        SettingFragment  se=new SettingFragment();
        list.add(mf);
        list.add(pe);
        list.add(se);

    }

    public void onClick(View v) {
        switch (v.getId()){
            // 点击  进入 消息页
            case R.id.button_message:
                viewPager.setCurrentItem(0);
                break;
            //点击进入联系人页
            case R.id.button_people:
                viewPager.setCurrentItem(1);
                break;
            //点击进入设置页
            case R.id.button_set:
                viewPager.setCurrentItem(2);
                break;

    }}
}
