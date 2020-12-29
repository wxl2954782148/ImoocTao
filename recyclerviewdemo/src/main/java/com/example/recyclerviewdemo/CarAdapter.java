package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private List<Car> carList;

    /**
     * 内部类，继承RecyclerView.ViewHolder
     * 在该类中找到要适配的控件
     */
    static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView carImage;
        private final TextView carName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.car_image);
            carName = itemView.findViewById(R.id.car_name);
        }
    }

    public CarAdapter(List<Car> carList) {
        this.carList = carList;
    }

    /**
     * 用于创建ViewHolder实例,并把加载的布局传入到构造函数去,再把ViewHolder实例返回
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    /**
     * 则是用于对子项的数据进行赋值,会在每个子项被滚动到屏幕内时执行
     * position得到当前项的Car实例
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carImage.setImageResource(car.getImageID());
        holder.carName.setText(car.getName());
    }

    /**
     * 返回RecyclerView的子项数目。
     */
    @Override
    public int getItemCount() {
        return carList.size();
    }

}
