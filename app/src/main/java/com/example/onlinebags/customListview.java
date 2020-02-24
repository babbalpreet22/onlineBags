package com.example.onlinebags;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.text.BreakIterator;

public class customListview extends ArrayAdapter<String>{
    private String[] productname;
    private String[] productdescription;
    private String[] productprice;
    private Button proceed;
    ///private Integer[] imgid;
    private Activity context;

    public customListview(Activity context, String[] productname, String[] productdescription , String[] productprice, Button proceed) {
        super(context, R.layout.custom, productname);

        this.context=context;
        this.productname=productname;
        this.productdescription=productdescription;
        this.productprice=productprice;
        this.proceed=proceed;
        ///this.imgid=imgid;
    }
    public View  getView(int position, View convertView, ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.custom, null);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) r.getTag();

        }
        ///viewHolder.ivw.setImageResource(imgid[position]);

        viewHolder.tvw1.setText(productname[position]);
        viewHolder.tvw2.setText(productdescription[position]);
        viewHolder.tvw3.setText(productprice[position]);
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Proceed Ahead", Toast.LENGTH_SHORT).show();
            }
        });
        return r;
    }

    class ViewHolder{

        Button btn;
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        /// ImageView ivw;

        ViewHolder(View v){
            tvw1=(TextView) v.findViewById(R.id.textView1);
            tvw2=(TextView) v.findViewById(R.id.textView2);
            tvw3=(TextView) v.findViewById(R.id.textView3);
            btn=(Button) v.findViewById(R.id.proceed);
            /// ivw=(ImageView) v.findViewById(R.id.imageView);


        }


    }
}
