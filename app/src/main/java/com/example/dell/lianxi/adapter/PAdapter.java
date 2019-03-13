package com.example.dell.lianxi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.lianxi.R;
import com.example.dell.lianxi.bean.One;

import java.util.List;

public class PAdapter extends BaseAdapter {
    private Context context;
    private List<One>  list;

    public PAdapter(Context context, List<One> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.pll_lis,null);
            holder.name=convertView.findViewById(R.id.text_name);
            holder.title=convertView.findViewById(R.id.text_title);
            holder.imageView=convertView.findViewById(R.id.image111);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getName());
        holder.title.setText(list.get(position).getType());
        Glide.with(context).load(list.get(position).getHeader()).into(holder.imageView);
        return convertView;
    }
    class ViewHolder{
        private TextView name;
        private TextView title;
        private ImageView imageView;
    }
}
