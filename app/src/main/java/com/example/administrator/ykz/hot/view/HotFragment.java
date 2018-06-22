package com.example.administrator.ykz.hot.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ykz.R;
import com.example.administrator.ykz.base.BaseFragment;
import com.example.administrator.ykz.base.BasePresenter;
import com.example.administrator.ykz.hot.adapter.ViewPagerAdapter;
import com.example.administrator.ykz.hot.view.fragment.FollowFragment;
import com.example.administrator.ykz.hot.view.fragment.ZHotFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HotFragment extends BaseFragment {
    @BindView(R.id._hot_tablayout)
    TabLayout HotTablayout;
    @BindView(R.id._hot_vp)
    ViewPager HotVp;
    Unbinder unbinder;
    private List<Fragment> fraglist;
    private List<String> list;

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        fraglist = new ArrayList<>();
        list = new ArrayList<>();

        HotTablayout.setupWithViewPager(HotVp);

        fraglist.add(new ZHotFragment());
        fraglist.add(new FollowFragment());
        list.add("热门");
        list.add("关注");
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fraglist, list);
        HotVp.setAdapter(adapter);
        HotTablayout.setTabMode(TabLayout.MODE_FIXED);


    }

    @Override
    public void onStart() {
        super.onStart();
        HotTablayout.post(new Runnable() {
            @Override
            public void run() {
            new TabLayouts().setIndicator(HotTablayout,50,50);
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.hot_fragment;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
