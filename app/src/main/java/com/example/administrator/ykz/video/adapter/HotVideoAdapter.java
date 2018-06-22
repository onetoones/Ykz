package com.example.administrator.ykz.video.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.ykz.R;
import com.example.administrator.ykz.hot.bean.HotBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HotVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HotBean.DataBean> list;
    private List<Integer> heightList;

    public HotVideoAdapter(Context context, List<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int height = new Random().nextInt(150) + 300;
            heightList.add(height);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hotvideoadapter_layout, null);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyView myView = (MyView) holder;
        String cover = list.get(position).getCover();
        Glide.with(context).load(cover).into(myView.iv);

        ViewGroup.LayoutParams layoutParams = myView.iv.getLayoutParams();
        layoutParams.height=heightList.get(position);
        myView.iv.setLayoutParams(layoutParams);

    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? null : list.size();
    }

    class MyView extends RecyclerView.ViewHolder {

        private final ImageView iv;

        public MyView(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.hot_imageview);

        }
    }

}
