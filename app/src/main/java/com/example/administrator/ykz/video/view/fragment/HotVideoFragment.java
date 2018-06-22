package com.example.administrator.ykz.video.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.ykz.Paragraph.presenter.ParagPresenter;
import com.example.administrator.ykz.R;
import com.example.administrator.ykz.Sidepull.view.SigninActivity;
import com.example.administrator.ykz.base.BaseFragment;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.example.administrator.ykz.video.adapter.HotVideoAdapter;
import com.example.administrator.ykz.video.presenter.HotVideoPresenter;
import com.example.administrator.ykz.video.view.iview.IHotVideoFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HotVideoFragment extends BaseFragment<HotVideoPresenter> implements IHotVideoFragment {
    @BindView(R.id.hotvideo_rec)
    RecyclerView hotvideoRec;
    Unbinder unbinder;
    @BindView(R.id.hotvideo_dl)
    TextView hotvideoDl;
    @BindView(R.id.hotvideo_ll1)
    LinearLayout hotvideoLl1;
    @BindView(R.id.hotvideo_ll)
    LinearLayout hotvideoLl;
    Unbinder unbinder1;
    private String token;

    @Override
    protected HotVideoPresenter setPresenter() {
        return new HotVideoPresenter();
    }

    @Override
    protected void initData() {
        SharedPreferences sp = getActivity().getSharedPreferences("Users", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        if (token.equals("")){
            hotvideoLl1.setVisibility(View.VISIBLE);
            hotvideoLl.setVisibility(View.GONE);
            hotvideoDl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().startActivity(new Intent(getActivity(), SigninActivity.class));
                }
            });

        }else {
            hotvideoLl1.setVisibility(View.GONE);
            hotvideoLl.setVisibility(View.VISIBLE);

            presenter.paragver("1","android",token,"101");

        }

    }

    @Override
    protected int setLayout() {
        return R.layout.hotvideofragment_layout;
    }

    @Override
    public void hots(HotBean bean) {
        List<HotBean.DataBean> data = bean.getData();
        HotVideoAdapter adapter = new HotVideoAdapter(getActivity(), data);
        hotvideoRec.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        hotvideoRec.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
