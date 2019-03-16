package com.example.retrofitnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<NewsModel> list=new ArrayList<NewsModel>();
    List<NewsModel.Article> articles=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getdata();


    }

    public void getdata(){
        Api api=ApiClass.api().create(Api.class);
        api.getData().enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {

                int size=response.body().getArticles().size();

//                list.add(response.body());
                for (int i=0;i<size;i++){
                    NewsModel model=new NewsModel();
                    NewsModel.Article article=new NewsModel.Article();
                    article.setAuthor(response.body().getArticles().get(i).getAuthor());
                    article.setTitle(response.body().getArticles().get(i).getTitle());
                    article.setDescription(response.body().getArticles().get(i).getDescription());
                    article.setUrlToImage(response.body().getArticles().get(i).getUrlToImage());
                    article.setSource(response.body().getArticles().get(i).getSource());

                    articles.add(article);

                    model.setArticles(articles);

                    list.add(model);

                }
                RecyclerAdapter recyclerAdapter=new RecyclerAdapter(list,MainActivity.this);
                recyclerView.setAdapter(recyclerAdapter);




            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
