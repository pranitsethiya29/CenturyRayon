package com.example.cr;

import android.content.Context;
import android.net.Uri;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class Activity8 extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Pot Spun Rayon Yarn", "Continuous Spun Rayon Yarn", "Viscose Rayon Tyre Yarn"};
    String mDescription[] = {" Description", " Description", "Description"};
    int images[] = {R.drawable.fabx, R.drawable.faby, R.drawable.fabz};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.centuryrayon.co.in/viscose_rayon_yarn_filament.aspx")));
                }
                if (position ==  1) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.centuryrayon.co.in/continuous_spun_yarn.aspx")));
                }

                if (position ==  2) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.centuryrayon.co.in/viscose_rayon_tyre_yarn.aspx")));
                }

            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}
