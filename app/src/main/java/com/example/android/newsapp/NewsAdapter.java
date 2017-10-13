package com.example.android.newsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;


/**
 * Created by karenulmer on 7/2/2017.
 */

public class NewsAdapter extends ArrayAdapter <News>{

    static class ViewHolder {
        TextView sectionTitle;
        TextView articleTitle;
    }
    Context mContext;


    public NewsAdapter(Activity context, ArrayList<News> news) {
            super(context, 0, news);
        }


        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItemView = convertView;

            // Check if an existing view is being reused, otherwise inflate the view
            final News currentArticle = getItem(position);
            ViewHolder holder;

            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);

                holder = new ViewHolder();
                holder.sectionTitle = (TextView) listItemView.findViewById(R.id.section_title);
                holder.articleTitle = (TextView) listItemView.findViewById(R.id.article_title);
                listItemView.setTag(holder);


            } else {
                holder = (ViewHolder) listItemView.getTag();
            }


            holder.sectionTitle.setText(currentArticle.getSection());
            holder.articleTitle.setText(currentArticle.getArticle());


            return listItemView;

        }


}





