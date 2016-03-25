package com.mihail.list;

import android.app.Activity;
import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    ListView mView;
    ArrayList<Product> ListItemS = new ArrayList<Product>();
            //Arrays.asList("test1", "test2", "test3", "cyjdf", "tyruiew", "huihik", "gugjk","gugjk","gugjk","gugjk","gugjk","gugjk","huihik", "gugjk","gugjk","gugjk","gugjk","gugjk","gugjk","huihik", "gugjk","gugjk", "gugjk", "gugjk", "gugjk","gugjk");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListItemS.add(new Product("bvz 1", "16.12.1998", false));
        ListItemS.add(new Product("bvz 2", "16.01.1999", false));
        ListItemS.add(new Product("bvz 3", "15.08.2008", false));
        ListItemS.add(new Product("bvz 4", "15.08.2009", false));
        ListItemS.add(new Product("bvz 5", "15.08.2008", false));
        ListItemS.add(new Product("bvz 6", "15.08.2008", false));
        ListItemS.add(new Product("bvz 7", "15.08.2008", false));
        ListItemS.add(new Product("bvz 8", "15.08.2008", false));
        ListItemS.add(new Product("bvz 9", "15.08.2008", false));
        ListItemS.add(new Product("bvz 10", "15.08.2008", false));
        ListItemS.add(new Product("bvz 3", "15.08.2008", false));
        ListItemS.add(new Product("bvz 3", "15.08.2008", false));
        ListItemS.add(new Product("bvz 3", "15.08.2008", false));
        mView = (ListView)findViewById(R.id.lv);
        final ArrayAdapter<String> listAdapter = new CustomListAdapter(this, R.layout.content_main, ListItemS);
        mView.setEmptyView(findViewById(R.id.empty_list_item));
        mView.setAdapter(listAdapter);

        mView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ListItemS.set(position, new Product("SOME NEW!", "01.01.2000", false));
                        //.set(position, "----!!!!----");
                //Toast.makeText(MainActivity.this, ListItemS.get(position), Toast.LENGTH_SHORT).show();
                mView.setAdapter(listAdapter);
            }
        });

        // обработчик для чекбоксов



    }
}
