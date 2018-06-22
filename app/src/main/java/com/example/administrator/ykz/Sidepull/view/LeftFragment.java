package com.example.administrator.ykz.Sidepull.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.ykz.R;
import com.example.administrator.ykz.base.BaseFragment;
import com.example.administrator.ykz.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class LeftFragment extends BaseFragment {
    @BindView(R.id.left_tz)
    RelativeLayout leftTz;
    @BindView(R.id.left_tx)
    SimpleDraweeView leftTx;
    @BindView(R.id.leftfragment_name)
    TextView name;
    @BindView(R.id.left_guanzhu)
    RelativeLayout leftGuanzhu;
    @BindView(R.id.left_shoucang)
    RelativeLayout leftShoucang;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.left_sousuo)
    RelativeLayout leftSousuo;
    @BindView(R.id.left_tongzhi)
    RelativeLayout leftTongzhi;
    @BindView(R.id.left_qiehuan)
    ImageView leftQiehuan;
    @BindView(R.id.left_shezhi)
    ImageView leftShezhi;
    Unbinder unbinder;


    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.leftfragment_layout;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @OnClick(R.id.left_tz)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), LoginActivity.class));

    }


    @OnClick({R.id.left_tx, R.id.left_guanzhu, R.id.left_shoucang, R.id.left_sousuo, R.id.left_tongzhi, R.id.left_qiehuan, R.id.left_shezhi, R.id.leftfragment_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_tx:
                break;
            case R.id.left_guanzhu:
                startActivity(new Intent(getActivity(), MyFollowActivity.class));
                break;
            case R.id.left_shoucang:
                startActivity(new Intent(getActivity(), CollectionActivity.class));
                break;
            case R.id.left_sousuo:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.left_tongzhi:
                startActivity(new Intent(getActivity(), NoticeActivity.class));
                break;
            case R.id.left_qiehuan:
                break;
            case R.id.left_shezhi:
                break;
            case R.id.leftfragment_name:

                break;
        }
    }
}
