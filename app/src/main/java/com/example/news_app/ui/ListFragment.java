package com.example.news_app.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.news_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    @BindView(R.id.top_headlines)
    Button topHeadlines;
    @BindView(R.id.all_news)
    Button allNews;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnListFragmentInteractionListener) context;
        } catch (ClassCastException e){
                throw new RuntimeException("Must Implement List Fragment Interaction Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this,view);
        initViews();
        return view;
    }


    private void initViews(){
        topHeadlines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onInteraction("Top");
            }
        });

        allNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onInteraction("All");
            }
        });
    }

    public interface OnListFragmentInteractionListener {
        void onInteraction(String arguments);
    }
}
