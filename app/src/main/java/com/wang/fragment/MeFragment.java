package com.wang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import com.wang.LoginActivity;
import com.wang.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public class MeFragment extends Fragment implements View.OnClickListener {
    /**
     * listView数据初始化
     */
    private final String[] arraytText = {
            "我的订单", "我的收藏", "我的口令",
            "我的锦囊", "安全中心", "收货地址",
            "客户服务", "设置", "编辑"
    };
    private final int[] arrayImg = {
            R.mipmap.list_my_menu, R.mipmap.list_save, R.mipmap.list_pwd,
            R.mipmap.list_my, R.mipmap.list_safe_center, R.mipmap.list_address,
            R.mipmap.list_service, R.mipmap.list_setting, R.mipmap.list_sug
    };

    private View view;
    private ListView listView;
    private ImageButton loginButton;

    /**
     * MeFragment对象初始化
     * @return
     */
    public static MeFragment initMeFragment(){
        MeFragment meFragment = new MeFragment();
        return meFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.me_fragment_layout, container, false);
        listView = view.findViewById(R.id.lv_me);

        SimpleAdapter listViewAdapter = new SimpleAdapter(getActivity(), dataAdapter(), R.layout.me_list_view_layout,
                new String[]{"image","text"},new int[]{R.id.image_view, R.id.text_view});

        listView.setAdapter(listViewAdapter);

        loginButton = view.findViewById(R.id.imgb_login);
        loginButton.setOnClickListener(this);
        return view;
    }

    /**
     * array数组转list进行适配
     * @return
     */
    private List<Map<String, Object>> dataAdapter() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < arraytText.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", arrayImg[i]);
            map.put("text", arraytText[i]);
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgb_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            default:
        }
    }
}
