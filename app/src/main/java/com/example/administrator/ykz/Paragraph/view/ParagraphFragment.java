package com.example.administrator.ykz.Paragraph.view;

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

import com.example.administrator.ykz.Paragraph.adapter.ParagAdapter;
import com.example.administrator.ykz.Paragraph.bean.ParagBean;
import com.example.administrator.ykz.Paragraph.presenter.ParagPresenter;
import com.example.administrator.ykz.Paragraph.view.iview.IParagrapFragment;
import com.example.administrator.ykz.R;
import com.example.administrator.ykz.Sidepull.view.SigninActivity;
import com.example.administrator.ykz.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ParagraphFragment extends BaseFragment<ParagPresenter> implements IParagrapFragment {


    @BindView(R.id.parag_rec)
    RecyclerView paragRec;
    Unbinder unbinder;
    @BindView(R.id.parags_dl)
    TextView paragsDl;
    @BindView(R.id.parags_ll1)
    LinearLayout paragsLl1;
    @BindView(R.id.parags_ll)
    LinearLayout paragsLl;
    Unbinder unbinder1;
    private String token;

    @Override
    protected ParagPresenter setPresenter() {
        return new ParagPresenter();
    }

    @Override
    protected void initData() {
        SharedPreferences sp = getActivity().getSharedPreferences("Users", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        if (token.equals("")) {
            paragsLl1.setVisibility(View.VISIBLE);
            paragsLl.setVisibility(View.GONE);
            paragsDl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), SigninActivity.class));
                }
            });
        } else {
            paragsLl1.setVisibility(View.GONE);
            paragsLl.setVisibility(View.VISIBLE);
            presenter.getparagrap("1","android",token,"101");

        }

    }

    @Override
    protected int setLayout() {
        return R.layout.paragraph_fragment;
    }

    @Override
    public void getshow(ParagBean bean) {
        List<ParagBean.DataBean> data = bean.getData();
        ParagAdapter adapter = new ParagAdapter(data, getActivity());
        paragRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        paragRec.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.onDestroys();
    }

}
