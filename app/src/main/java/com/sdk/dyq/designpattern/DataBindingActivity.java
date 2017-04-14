package com.sdk.dyq.designpattern;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sdk.dyq.designpattern.adapter.DataBindingListAdapter;
import com.sdk.dyq.designpattern.bean.EducationInfo;
import com.sdk.dyq.designpattern.bean.User;
import com.sdk.dyq.designpattern.databinding.ActivityDatabindingBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用dataBinding框架的基本用法
 */

public class DataBindingActivity extends AppCompatActivity{
    EducationInfo eInfo  = new EducationInfo();

    private DataBindingListAdapter listAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {//不能使用另外一个构造方法，否则ActivityDatabindingBinding失效
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_databinding);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_databinding);
        initView(binding);
        initViewWithAdapter(binding);
    }

    private void initView(ActivityDatabindingBinding binding){
        User user = new User("name","111");
        binding.setActivity(this);
        binding.setUser(user);
        eInfo.setHighSchoolName("宝高");
        eInfo.setSchoolLevel("二等");
        binding.setEInfo(eInfo);
    }
    /**
     * 更改数据，间接与数据绑定的UI也跟着改变，一定要有(View view)该参数,否则失败
     */
    public void setEducationInfo(View view){
        if(eInfo!=null) {
            eInfo.setHighSchoolName("深大");
            eInfo.setSchoolLevel("一等");
        }
    }

    /**
     * 初始化使用adapter的视图
     * @param binding
     */
    private void initViewWithAdapter(ActivityDatabindingBinding binding){
        listAdapter = new DataBindingListAdapter(this);
        List<String> ll = new ArrayList<>();
        ll.add("123");
        ll.add("234");
        ll.add("345");
        listAdapter.setmList(ll);
        listAdapter.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), v.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.lv.setAdapter(listAdapter);
    }

}
