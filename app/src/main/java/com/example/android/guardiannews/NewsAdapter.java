package com.example.android.guardiannews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dzsub on 2018.06.04..
 */

public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(@NonNull Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        // Find the News at the given position in the list of news
        News currentNews = getItem(position);

        if (currentNews != null) {
            // Find the TextView with view ID section
            TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
            sectionView.setText(currentNews.getmSection());

            // Find the TextView with view ID article
            TextView articleView = (TextView) listItemView.findViewById(R.id.article);
            articleView.setText(currentNews.getmArticle());

            TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
            dateTextView.setText(formatDate(currentNews.getmDate()));

            if (currentNews.getmAuthor() != null) {
                // Find the TextView with view ID section
                TextView nameView = (TextView) listItemView.findViewById(R.id.author);
                nameView.setText(currentNews.getmAuthor());
            }

        }

        return listItemView;
    }

    //Format date and time so we can easily read them
    private String formatDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Date dateObject = null;
        try {
            dateObject = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        simpleDateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm a");
        String date = simpleDateFormat.format(dateObject);

        return date;
    }

}
