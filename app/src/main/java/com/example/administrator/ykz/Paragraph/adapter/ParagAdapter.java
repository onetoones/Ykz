package com.example.administrator.ykz.Paragraph.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dl7.player.media.IjkPlayerView;
import com.example.administrator.ykz.Paragraph.bean.ParagBean;
import com.example.administrator.ykz.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ParagAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ParagBean.DataBean> list;
    private Context context;

    public ParagAdapter(List<ParagBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.paragadapter_layout, null);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyView myView = (MyView) holder;
        if (list.get(position).getUser().getIcon()==null){

        }else {
            String icon = list.get(position).getUser().getIcon();
            Uri parse = Uri.parse(icon);
            myView.tx.setImageURI(parse) ;
        }
        myView.name.setText(list.get(position).getContent());
        myView.time.setText(list.get(position).getCreateTime());


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


        public MyView(View itemView) {
            super(itemView);
            tx = itemView.findViewById(R.id.parag_tx);
            name = itemView.findViewById(R.id.parag_name);
            time = itemView.findViewById(R.id.parag_time);
            nr = itemView.findViewById(R.id.parag_nr);

        }
    }
}
