package com.mcode.movieapplicationmvp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mcode.movieapplicationmvp.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    OnItemClickListener onItemClickListener;
    ImageView imageIcon;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        imageIcon = (ImageView) itemView.findViewById(R.id.icon);
    }


    @Override
    public void onClick(View v) {
        onItemClickListener.onClick(v, getAdapterPosition());
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }
}
