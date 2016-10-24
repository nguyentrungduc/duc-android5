package com.example.duc.recyclerviewdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.recyclerviewdemo.R;
import com.example.duc.recyclerviewdemo.models.Post;
import com.example.duc.recyclerviewdemo.viewholders.PostViewHolder;

/**
 * Created by DUC on 10/23/2016.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    //Create new
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1 inflate view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_post, parent, false);

        //2 create view holder
        PostViewHolder postViewHolder = new PostViewHolder(itemView);
        return postViewHolder;
    }
    //Update
    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        //Model
        Post post = Post.list.get(position);
        //Bind
        holder.bind(post);


    }
    //get count
    @Override
    public int getItemCount() {
        return Post.list.size();
    }
}
