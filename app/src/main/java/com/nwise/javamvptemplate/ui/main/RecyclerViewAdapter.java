package com.nwise.javamvptemplate.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.nwise.javamvptemplate.R;
import com.nwise.javamvptemplate.domain.models.Answer;
import com.nwise.javamvptemplate.domain.models.ListWrapper;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ListWrapper<Answer> data;
    private Context context;
    private int itemViewType;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(itemViewType, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Answer answer = data.items.get(position);
        holder.text.setText(answer.toString());
        holder.itemView.setTag(answer.answerId);
        Glide.with(context).load(answer.owner.profileImage).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        private ImageView imageView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_avator);
            text = itemView.findViewById(R.id.text1);


        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 5 == 0) {
            return itemViewType = R.layout.odd_selectable_list_item;
        } else return itemViewType = R.layout.even_selectable_list_item;
    }

    public RecyclerViewAdapter(ListWrapper<Answer> data, Context context) {
        this.data = data;
        this.context = context;
    }
}
