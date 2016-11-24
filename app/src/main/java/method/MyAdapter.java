package method;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import bean.bean_stage;

/**
 * Created by kjb on 2016-11-24.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<bean_stage> al;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<bean_stage> al){
        context=this.context;
        layout=this.layout;
        al=this.al;
        inf=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }
        /*
        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView tvName = (TextView)convertView.findViewById(R.id.textView1);
        TextView tvInfo = (TextView)convertView.findViewById(R.id.textView2);

        Song m = al.get(position);
        iv.setImageResource(m.img);
        tvName.setText(m.title);
        tvInfo.setText(m.artist);
        */
        return null;
    }
}
