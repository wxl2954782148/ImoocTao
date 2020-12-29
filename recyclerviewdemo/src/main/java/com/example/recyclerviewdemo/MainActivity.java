package com.example.recyclerviewdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Car> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initData();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
   //     LayoutManager用于指定RecyclerView的布局方式。LinearLayoutManager指的是线性布局
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
//        recyclerView.setLayoutManager(gridLayoutManager);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        CarAdapter carAdapter = new CarAdapter(carList);
        recyclerView.setAdapter(carAdapter);
    }

    private void initData(){
        for (int i = 0; i < 10; i++) {
            Car a = new Car("a421421", R.drawable.find_main_hotwind);
            carList.add(a);
            Car b = new Car("433333333333333123b", R.drawable.find_main_square);
            carList.add(b);
            Car c = new Car("1a", R.drawable.find_main_travel);
            carList.add(c);
            Car d = new Car("a4211111111111143", R.drawable.list_address);
            carList.add(d);
            Car e = new Car("a1232", R.drawable.list_my);
            carList.add(e);
        }
    }
}