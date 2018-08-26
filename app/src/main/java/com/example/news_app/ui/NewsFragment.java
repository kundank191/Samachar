package com.example.news_app.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news_app.BuildConfig;
import com.example.news_app.R;
import com.example.news_app.Utils.InjectorUtils;
import com.example.news_app.data.database.Article;
import com.example.news_app.ui.adapters.ArticleAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    private ArticleViewModel viewModel;
    private String API_KEY = BuildConfig.API_KEY;
    private ArticleAdapter articleAdapter;
    @BindView(R.id.article_rv)
    RecyclerView recyclerViewArticle;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArticleViewModelFactory viewModelFactory = InjectorUtils.provideArticleViewModelFactory(getActivity().getApplicationContext(),API_KEY);
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ArticleViewModel.class);

        initViews();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this,view);

        recyclerViewArticle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerViewArticle);

        return view;
    }

    private void initViews(){
        viewModel.getArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                populateUI(articles);
            }
        });
    }

    private void populateUI(List<Article> articles){
        articleAdapter = new ArticleAdapter(articles,getContext());
        recyclerViewArticle.setAdapter(articleAdapter);
    }
}
