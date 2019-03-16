package com.example.retrofitnews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<NewsModel> list;
    Context context;

    public RecyclerAdapter(List<NewsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        NewsModel model=list.get(i);
        myViewHolder.author.setText(model.getArticles().get(i).getAuthor());
        myViewHolder.title.setText(model.getArticles().get(i).getTitle());
        myViewHolder.name.setText(model.getArticles().get(i).getSource().getName());
        Picasso.get().load(model.getArticles().get(i).getUrlToImage()).into(myViewHolder.urlImge);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView urlImge;
        TextView title,author,name;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            urlImge=itemView.findViewById(R.id.imgurl);
            title=itemView.findViewById(R.id.title);
            author=itemView.findViewById(R.id.author);
            name=itemView.findViewById(R.id.name);

        }
    }
}
