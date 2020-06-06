package com.chana.benapp.recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chana.benapp.R;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView ivImg, ivShare;
    public CheckBox cbLike;
    public TextView tvLikeCount, tvUserName, tvPostText;
    private PostAdapter mAdapter;

    public PostViewHolder(@NonNull View itemView, PostAdapter postAdapter) {
        super(itemView);
        ivImg = itemView.findViewById(R.id.iv_img);
        cbLike = itemView.findViewById(R.id.cb_like);
        ivShare = itemView.findViewById(R.id.iv_share);
        tvLikeCount = itemView.findViewById(R.id.tv_likecount);
        tvUserName = itemView.findViewById(R.id.tv_username);
        tvPostText = itemView.findViewById(R.id.tv_posttext);

        cbLike.setOnClickListener(this);
        ivShare.setOnClickListener(this);
        mAdapter = postAdapter;
    }

    @Override
    public void onClick(View v) {

            int position = getAdapterPosition();

            switch(v.getId()){
                case R.id.cb_like:
                    mAdapter.onLikeClicked(position);
                    break;
                case R.id.iv_share:
                    break;
            }
    }
}
