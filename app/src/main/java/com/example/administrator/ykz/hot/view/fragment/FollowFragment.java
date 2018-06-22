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
import com.example.administrator.ykz.hot.adapter.HotVideoAdapter;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.hot.presenter.FollowPresenter;
import com.example.administrator.ykz.hot.view.iview.IFollowFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FollowFragment extends BaseFragment<FollowPresenter> implements IFollowFragment {


    @BindView(R.id.follow_rec)
    RecyclerView followRec;
    Unbinder unbinder;
    @BindView(R.id.follow_dl)
    TextView followDl;
    @BindView(R.id.follow_ll1)
    LinearLayout followLl1;
    @BindView(R.id.follow_ll)
    LinearLayout followLl;
    Unbinder unbinder1;
    private String token;

    @Override
    protected FollowPresenter setPresenter() {
        return new FollowPresenter();
    }

    @Override
    protected void initData() {
        SharedPreferences sp = getActivity().getSharedPreferences("Users", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        if (token.equals("")) {
            followLl.setVisibility(View.GONE);
            followLl1.setVisibility(View.VISIBLE);
            followDl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().startActivity(new Intent(getActivity(), SigninActivity.class));
                }
            });
        }else {
            followLl.setVisibility(View.VISIBLE);
            followLl1.setVisibility(View.GONE);
            presenter.getFollow("1", "android", token, "101");
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.followfragment_layout;
    }

    @Override
    public void getVideos(HotBean bean) {
        List<HotBean.DataBean> data = bean.getData();
        HotVideoAdapter adapter = new HotVideoAdapter(getActivity(), data);
        followRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        followRec.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroys();
    }
}