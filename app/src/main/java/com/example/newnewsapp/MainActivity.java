package com.example.newnewsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnNewsClickListener {

    private RecyclerView topRecyclerView, topnewsRecyclerView;
    private ArrayList<News> topStoriesNewsList, topnewsList;
    private NewsAdapter topStoriesNewsAdapter, topnewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topRecyclerView = findViewById(R.id.topStoriesRecyclerView);
        topnewsRecyclerView = findViewById(R.id.newsRecyclerView);

        topStoriesNewsList = getSampleNews();
        topnewsList = getSampleNews();


        topStoriesNewsAdapter = new NewsAdapter(topStoriesNewsList, this);
        topRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topRecyclerView.setAdapter(topStoriesNewsAdapter);

        topnewsAdapter = new NewsAdapter(topnewsList, this);
        topnewsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topnewsRecyclerView.setAdapter(topnewsAdapter);
    }

    private ArrayList<News> getSampleNews() {
        ArrayList<News> list = new ArrayList<>();
        list.add(new News("Top Breaking News", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic.", R.drawable.news_image));
        list.add(new News("Latest News", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. ", R.drawable.news_image1));
        return list;
    }

    @Override
    public void onNewsClick(News news) {
        NewsDetailFragment fragment = NewsDetailFragment.newInstance(news);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
