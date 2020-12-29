package com.wang.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wang.MainActivity;
import com.wang.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MainFragment extends Fragment {

    private ViewPager viewPager;
    private int[] bannerImageArray = {
            R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2,
            R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2,
    };
    private List<View> viewList;

    public static MainFragment initMainFragment(){
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);
        viewPager = view.findViewById(R.id.index_banner);
        viewPager.setAdapter(pagerAdapter);

        viewList = new ArrayList<>();
        for (int i = 0; i < bannerImageArray.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(bannerImageArray[i]);
            viewList.add(imageView);
        }

        return view;
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return bannerImageArray.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View child = viewList.get(position);
            container.addView(child);
            return child;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(viewList.get(position));
        }
    };
}
