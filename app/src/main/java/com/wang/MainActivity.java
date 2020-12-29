package com.wang;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.wang.fragment.FindFragment;
import com.wang.fragment.MainFragment;
import com.wang.fragment.MeFragment;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //菜单按钮布局
    private LinearLayout mainLayoutView, findLayoutView, meLayoutView;
    private FragmentTransaction fragmentTransaction;
    //当前的Fragment
    private Fragment currentFragment = new Fragment();

    //当前被选中的菜单按钮
    private LinearLayout currentLinearLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        initOnClickListener();
        //打开时显示首页
        showFragment(MainFragment.initMainFragment());

        //设置应用开启时，mainLayoutView处于选中状态
        currentLinearLayout = mainLayoutView;
        currentLinearLayout.setSelected(true);
    }

    /**
     * 初始化点击事件监听器
     */
    private void initOnClickListener() {
        mainLayoutView.setOnClickListener(this);
        findLayoutView.setOnClickListener(this);
        meLayoutView.setOnClickListener(this);
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mainLayoutView = findViewById(R.id.menu_main);
        findLayoutView = findViewById(R.id.menu_find);
        meLayoutView = findViewById(R.id.menu_me);
    }

    /**
     * 加载fragment
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        //如果传入的Fragment不是当前的Fragment
        if (fragment != currentFragment){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //隐藏当前的
            fragmentTransaction.hide(currentFragment);
            //再把传入的赋值给当前的
            currentFragment = fragment;
        }else {
            return;
        }
        //判断传入的fragment是否已经被add()过
        if (! fragment.isAdded()){
            fragmentTransaction
                    .add(R.id.container_content, fragment)
                    .show(fragment)
                    .commit();
        }else {
            fragmentTransaction.show(fragment).commit();
        }
    }

    /**
     * view点击事件
     * 创建对应的fragment
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_main:
                showFragment(MainFragment.initMainFragment());
                setViewIsSelect(mainLayoutView);
                break;
            case R.id.menu_find:
                showFragment(FindFragment.initFindFragment());
                setViewIsSelect(findLayoutView);
                break;
            case R.id.menu_me:
                showFragment(MeFragment.initMeFragment());
                setViewIsSelect(meLayoutView);
                break;
            default:
        }
    }

    /**
     * 设置mainLayoutView, findLayoutView, meLayoutView选中状态，用于图标切换
     * @param linearLayout
     */
    private void setViewIsSelect(LinearLayout linearLayout){
        if (linearLayout != currentLinearLayout){
            currentLinearLayout.setSelected(false);
            linearLayout.setSelected(true);
            currentLinearLayout = linearLayout;
        }
    }

}