package com.example.newnewsapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailFragment extends Fragment {

    private static final String ARG_NEWS = "news";
    private News news;

    public static NewsDetailFragment newInstance(News news) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS, news);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            news = (News) getArguments().getSerializable(ARG_NEWS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_details, container, false);
        TextView title = view.findViewById(R.id.newsTitle);
        TextView description = view.findViewById(R.id.newsDescription);
        ImageView image = view.findViewById(R.id.newsImage);

        title.setText(news.getTitle());
        description.setText(news.getDescription());
        image.setImageResource(news.getImageResId());

        return view;
    }
}
