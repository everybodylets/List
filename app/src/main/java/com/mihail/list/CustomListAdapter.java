package com.mihail.list;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    private Context mContext;
    private int id;
    private ArrayList<Product> items ;


    public CustomListAdapter(Context context, int textViewResourceId , ArrayList<Product> list )
    {
        super(context, textViewResourceId, list);
        mContext = context;
        id = textViewResourceId;
        items = list ;
    }

    @Override
    public Product getItem(int position) {
        return ((Product) items.get(position));
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent)
    {
        View mView = v ;
        if(mView == null){
            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, null);
        }

        TextView text = (TextView) mView.findViewById(R.id.noteText);
        TextView textDate = (TextView) mView.findViewById(R.id.noteCreatedAt);
        CheckBox checkBox = (CheckBox) mView.findViewById(R.id.ChBox);

        if(items.get(position) != null )
        {
            text.setTextColor(Color.BLACK);
            text.setText(items.get(position).name);
            textDate.setText(items.get(position).dateS);
            checkBox.setTag(position);
            checkBox.setChecked(items.get(position).box);
//            items.get(position).name;
            text.setBackgroundColor(Color.WHITE);
            int color = Color.argb( 0, 0, 0, 64 );
            textDate.setBackgroundColor( color );

        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton checkBox,
                                         boolean isChecked) {
                // меняем данные товара (в корзине или нет)
                //CheckBox nch = (CheckBox)
                //items.get(position).box = isChecked;
                Toast.makeText(getContext(), getItem(position).toString(), Toast.LENGTH_SHORT).show();
                //getItem(position).box = isChecked;
                items.set(position,new Product(getItem(position).name, getItem(position).dateS,true));
            }
        });


        return mView;
    }



}