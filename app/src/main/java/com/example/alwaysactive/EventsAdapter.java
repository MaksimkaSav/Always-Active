package com.example.alwaysactive;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EventsAdapter extends BaseAdapter {

    Context context;
    String[] events;
    String[] names;
    String[] tss;
    String[] tes;

    public EventsAdapter(Context ctx , String[] events){
        context = ctx;
        this.events = events;

        names = new String[events.length];
        tss = new String[events.length];
        tes = new String[events.length];

        for (int i = 0; i < events.length; i++){
            names[i] = events[i].substring(12);
            tss[i] = events[i].substring(0, 5);
            tes[i] = events[i].substring(6, 11);
        }
    }

    @Override
    public int getCount() {
        return events.length;
    }

    @Override
    public Object getItem(int position) {
        return events[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.item_list, parent, false);
        }
        TextView name = view.findViewById(R.id.name);
        name.setText(names[position]);
        TextView ts = view.findViewById(R.id.ts);
        ts.setText(tss[position]);
        TextView te = view.findViewById(R.id.te);
        te.setText(tes[position]);
        return view;
    }
}
