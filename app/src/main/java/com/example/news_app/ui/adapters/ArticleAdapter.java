package com.example.news_app.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.news_app.R;
import com.example.news_app.Utils.GlideApp;
import com.example.news_app.data.database.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kundan on 26-08-2018.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.article_iv)
        ImageView articleIV;
        @BindView(R.id.article_tv)
        TextView articleTV;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private List<Article> articleList;
    private Context context;

    public ArticleAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View articleView = layoutInflater.inflate(R.layout.article_row_item,parent,false);
        return new ViewHolder(articleView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Article article = articleList.get(position);

        GlideApp.with(getContext())
                .load(article.getUrlToImage())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.articleIV);

        holder.articleTV.setText(article.getDescription());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    private Context getContext(){
        return context;
    }
}
