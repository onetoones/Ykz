package com.example.administrator.ykz.video.view;

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
import com.example.administrator.ykz.hot.view.TabLayouts;
import com.example.administrator.ykz.video.view.fragment.HotVideoFragment;
import com.example.administrator.ykz.video.view.fragment.NearbyVedioFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VedioFragment extends BaseFragment {
    @BindView(R.id.videof_tab)
    TabLayout videofTab;
    @BindView(R.id.videof_vp)
    ViewPager videofVp;
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
        videofTab.setupWithViewPager(videofVp);

        list.add("热门");
        list.add("附近");
        fraglist.add(new HotVideoFragment());
        fraglist.add(new NearbyVedioFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fraglist, list);
        videofVp.setAdapter(adapter);
        videofTab.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    public void onStart() {
        super.onStart();
        videofTab.post(new Runnable() {
            @Override
            public void run() {
                new TabLayouts().setIndicator(videofTab,50,50);
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.vedio_fragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
