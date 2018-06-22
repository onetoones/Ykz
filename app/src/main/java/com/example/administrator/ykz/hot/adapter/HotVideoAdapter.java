package com.example.administrator.ykz.hot.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.example.administrator.ykz.R;
import com.example.administrator.ykz.hot.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HotVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HotBean.DataBean> list;

    public HotVideoAdapter(Context context, List<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hotvideo_layout, null);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyView myView = (MyView) holder;
        HotBean.DataBean bean = list.get(position);
        String[] split = bean.getUser().getIcon().split("\\|");
        Uri parse = Uri.parse(split[0]);
        myView.tx.setImageURI(parse);
        myView.name.setText(bean.getUser().getNickname());
        myView.time.setText(bean.getCreateTime());
        myView.nr.setText(bean.getWorkDesc());
        String videoUrl = bean.getVideoUrl();
        Uri uris = Uri.parse(videoUrl);
        Glide.with(context).load(bean.getCover()).into(((MyView) holder).video.mPlayerThumb);

        myView.video.init()
                .setVideoPath(uris)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku()
                .stop();

    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? null : list.size();
    }

    class MyView extends RecyclerView.ViewHolder {

        private final SimpleDraweeView tx;
        private final TextView name;
        private final TextView time;
        private final TextView nr;
        private final IjkPlayerView video;

        public MyView(View itemView) {
            super(itemView);
            tx = itemView.findViewById(R.id.video_tx);
            name = itemView.findViewById(R.id.video_name);
            time = itemView.findViewById(R.id.video_time);
            nr = itemView.findViewById(R.id.video_nr);
            video = itemView.findViewById(R.id.video_view_c);
        }
    }
}
