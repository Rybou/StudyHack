package com.bourymbodj.studyhack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bourymbodj on 16-11-12.
 */
public class CustomBaseAdapter extends BaseAdapter {
    private static ArrayList<CourseInfo> courseArrayList;

    private LayoutInflater mInflater;

    public CustomBaseAdapter(Context context, ArrayList <CourseInfo> results) {
        courseArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return courseArrayList.size();
    }

    public Object getItem(int position) {
        return courseArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_list_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.text1);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(courseArrayList.get(position).getCourseName());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
    }
}

