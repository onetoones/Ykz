package com.example.administrator.ykz.hot.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.ykz.R;
import com.example.administrator.ykz.Sidepull.view.SigninActivity;
import com.example.administrator.ykz.base.BaseFragment;
import com.example.administrator.ykz.base.MyGlide;
import com.example.administrator.ykz.hot.adapter.HotVideoAdapter;
import com.example.administrator.ykz.hot.bean.AdvertisementBean;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.hot.presenter.AdverPresneter;
import com.example.administrator.ykz.hot.view.iview.IZHotFragment;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ZHotFragment extends BaseFragment<AdverPresneter> implements IZHotFragment {
    @BindView(R.id.hots_banner)
    Banner zhotBanner;
    @BindView(R.id.hots_rev)
    RecyclerView zhotRev;
    Unbinder unbinder;
    @BindView(R.id.hots_dl)
    TextView hotsDl;
    @BindView(R.id.hots_ll1)
    LinearLayout hotsLl1;
    @BindView(R.id.hots_ll)
    LinearLayout hotsLl;
    Unbinder unbinder1;
    private List<String> list;
    private String token;

    @Override
    protected AdverPresneter setPresenter() {
        return new AdverPresneter();
    }

    @Override
    protected void initData() {
        presenter.adver();
        SharedPreferences sp = getActivity().getSharedPreferences("Users", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        if (token.equals("")){
            hotsLl1.setVisibility(View.VISIBLE);
            zhotRev.setVisibility(View.GONE);
            hotsDl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().startActivity(new Intent(getActivity(), SigninActivity.class));
                }
            });
        }else {
            hotsLl1.setVisibility(View.GONE);
            zhotRev.setVisibility(View.VISIBLE);
            presenter.hots("2", "android", token, "101");
        }


    }

    @Override
    protected int setLayout() {

        return R.layout.zhotfragment_layout;


    }

    @Override
    public void gethot(AdvertisementBean bean) {

        list = new ArrayList<>();
        List<AdvertisementBean.DataBean> data = bean.getData();
        for (int i = 0; i < data.size(); i++) {
            String icon = data.get(i).getIcon();
            list.add(icon);
        }
        zhotBanner.setImages(list)
                .setImageLoader(new MyGlide())
                .setBannerAnimation(Transformer.DepthPage)
                .setDelayTime(2000)
                .start();

    }

    @Override
    public void getVideos(HotBean bean) {
        List<HotBean.DataBean> data = bean.getData();
        HotVideoAdapter adapter = new HotVideoAdapter(getActivity(), data);
        zhotRev.setLayoutManager(new LinearLayoutManager(getActivity()));
        zhotRev.setAdapter(adapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroys();
    }

}
