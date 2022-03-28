package com.example.mefit.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.mefit.R;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity implements CategoryRVAdapter.CategorClickInterface{

    //d5f738d0c3a047509dc22d9264eb7e13 (MX)

    private RecyclerView newsRV, categoryRV;
    private SpinKitView loadingPB;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<CategoryRVModal> categoryRVModalsArrayList;
    private CategoryRVAdapter categoryRVAdapter;
    private NewsRVAdapter newsRVAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        newsRV = findViewById(R.id.idRVNews);
        categoryRV = findViewById(R.id.idRVCategories);
        loadingPB = findViewById(R.id.idPBLoading);
        articlesArrayList = new ArrayList<>();
        categoryRVModalsArrayList = new ArrayList<>();
        newsRVAdapter = new NewsRVAdapter(articlesArrayList,this);
        categoryRVAdapter = new CategoryRVAdapter(categoryRVModalsArrayList,this,this::onCategoryClick);
        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(newsRVAdapter);
        categoryRV.setAdapter(categoryRVAdapter);
        getCategories();
        getNews("All");
        newsRVAdapter.notifyDataSetChanged();
    }

    private void getCategories(){
        categoryRVModalsArrayList.add(new CategoryRVModal("All","https://www.fundeu.es/wp-content/uploads/2018/11/guerras.jpg"));
        categoryRVModalsArrayList.add(new CategoryRVModal("Tecnologia","https://definicion.de/wp-content/uploads/2008/12/tecnologia-de-punta.jpg"));
        categoryRVModalsArrayList.add(new CategoryRVModal("Science","https://www.fundacionaquae.org/wp-content/uploads/2017/08/caracteristicas-de-los-atomos-1024x683.jpg"));
        categoryRVModalsArrayList.add(new CategoryRVModal("Sports","https://media.revistagq.com/photos/61bc68e359ab05088d9a4f54/1:1/w_1600%2Cc_limit/mob-alizadeh-93or5BgHobk-unsplash.jpg"));
        categoryRVModalsArrayList.add(new CategoryRVModal("General","https://i2.wp.com/thehappening.com/wp-content/uploads/2016/11/naturaleza-playlis.jpg?fit=1024%2C694&ssl=1"));
        categoryRVModalsArrayList.add(new CategoryRVModal("Business","https://www.eleconomista.com.mx/__export/1608664974276/sites/eleconomista/img/2020/12/20/negocios_cerrados_rs6.jpg_1093282975.jpg"));
        categoryRVModalsArrayList.add(new CategoryRVModal("Entertainment","https://i.pinimg.com/originals/16/8d/ad/168dad3cbcef0812d2afc8c881f7d57d.jpg"));
        categoryRVModalsArrayList.add(new CategoryRVModal("Health","https://www.anahuac.mx/mexico/sites/default/files/noticias/El-sistema-de-salud-mexicano.jpg"));
        categoryRVAdapter.notifyDataSetChanged();
    }

    private void getNews(String category){
        loadingPB.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String categoryURL = "https://newsapi.org/v2/top-headlines?country=in&category=" + category + "&apikey=d5f738d0c3a047509dc22d9264eb7e13";
        String url = "https://newsapi.org/v2/top-headlines?country=in&excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apiKey=d5f738d0c3a047509dc22d9264eb7e13";
        String BASE_URL= "https://newsapi.org/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<NewsModal> call;

        if(category.equals("All")){
            call = retrofitAPI.getAllNews(url);
        }else{
            call = retrofitAPI.getNewsCategory(categoryURL);
        }
        call.enqueue(new Callback<NewsModal>() {
            @Override
            public void onResponse(Call<NewsModal> call, Response<NewsModal> response) {
                NewsModal newsModal = response.body();
                loadingPB.setVisibility(View.GONE);
                ArrayList<Articles> articles = newsModal.getArticles();
                for(int i=0; i<articles.size(); i++){
                    articlesArrayList.add(new Articles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),
                            articles.get(i).getUrl(),articles.get(i).getContent()));


                }
                newsRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModal> call, Throwable t) {
                Toast.makeText(NewsActivity.this, "Fall to get news", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCategoryClick(int position) {
        String category = categoryRVModalsArrayList.get(position).getCategory();
        getNews(category);
    }
}