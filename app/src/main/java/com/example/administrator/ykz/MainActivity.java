package com.example.administrator.ykz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ykz.Paragraph.view.ParagraphFragment;
import com.example.administrator.ykz.base.BaseActivity;
import com.example.administrator.ykz.base.BasePresenter;
import com.example.administrator.ykz.hot.view.HotFragment;
import com.example.administrator.ykz.video.view.VedioFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.nineoldandroids.view.ViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.imageViews)
    SimpleDraweeView imageViews;
    @BindView(R.id.titles)
    TextView titles;
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    @BindView(R.id.drawer_main)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_bji)
    ImageView mainBji;

    @Override
    protected void initData() {
        imageViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                slideAnim(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(60, 50)
                .setChangeColor(Color.BLUE, Color.GRAY)
                .addTabItem("推荐", R.mipmap.raw_1500085367, R.mipmap.raw_1500083878, HotFragment.class)
                .addTabItem("段子", R.mipmap.raw_1500085899, R.mipmap.raw_1500085327, ParagraphFragment.class)
                .addTabItem("视频", R.mipmap.raw_1500086067, R.mipmap.raw_1500083686, VedioFragment.class)
                .isShowDivider(true).setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {

            @Override
            public void onTabChange(int position, String name) {
                switch (position) {
                    case 0:
                        titles.setText("推荐");
                        break;
                    case 1:
                        titles.setText("段子");
                        break;
                    case 2:
                        titles.setText("视频");
                        break;
                }
            }

        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }




    private void slideAnim(View drawerView, float slideOffset) {
        View contentView = drawerLayout.getChildAt(0);

        float scale = 1 - slideOffset;
        float rightScale = 0.8f + scale * 0.2f;
        float leftScale = 1 - 0.3f * scale;

        ViewHelper.setScaleX(drawerView, leftScale);
        ViewHelper.setScaleY(drawerView, leftScale);
        ViewHelper.setAlpha(drawerView, 0.6f + 0.4f * (1 - scale));
        ViewHelper.setTranslationX(contentView, drawerView.getMeasuredWidth() * (1 - scale));
        ViewHelper.setPivotX(contentView, 0);
        ViewHelper.setPivotY(contentView, contentView.getMeasuredHeight() / 2);
        contentView.invalidate();
        ViewHelper.setScaleX(contentView, rightScale);
        ViewHelper.setScaleY(contentView, rightScale);
    }



    @OnClick(R.id.main_bji)
    public void onViewClicked() {
        startActivity(new Intent(this, ALiteraryCreationActivity.class));
    }
}
