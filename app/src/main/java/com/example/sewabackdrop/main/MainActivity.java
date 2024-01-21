package com.example.sewabackdrop.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.sewabackdrop.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ModelCategories> modelCategories = new ArrayList<>();
    List<ModelTending> modelTending = new ArrayList<>();
    CategoriesAdapter categoriesAdapter;
    TrendingAdapter trendingAdapter;
    ModelCategories modelCategories;
    ModelTrending modelTrending;
    RecyclerView rvCategories, rvTrending;
    CardView cvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStatusbar();
        setInitLayout();
        setCategories();
        setTrending();

    }

    private void setInitLayout(){
        cvHistory = findViewById(R.id.cvHistory);
        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryOrderActivity.class);
                startActivity(intent);
            }
        });

        rvCategories = findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(new GridLayoutManager(this,3));
        rvCategories.setHasFixedSize(true);

        rvTrending = findViewById(R.id.rvTrending);
        rvTrending.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvTrending.setHasFixedSize(true);

    }

    private void setCategories(){
        modelCategories = new ModelCategories(R.drawable.complete_1,"Complete Package");
        modelCategoriesList.add(modelCategories);

        categoriesAdapter = new CategoriesAdapter(this, modelCategoriesList);
        rvCategories.setAdapter(categoriesAdapter);

    }

    private void setTrending(){
        modelTending = new ModelTrending(R.drawable.complete_1,"Menu 1", "2.200 disukai");
        modelTrendingList.add(modelTendings);


        trendingAdapter = new TrendingAdapter(this,modelTrendingList);
        rvTrending.setAdapter(trendingAdapter);

    }

    public void setStatusbar(){
        if (Build.VERSION.SDK_INT < 21){
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >=19){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
        if (Build.VERSION.SDK_INT >= 21){
            setWindowFlag(this,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(android.TRANSPARENT);
        }
    }

    public static void setWindowFlag(@NonNull Activity activity,final int bits, boolean on){
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on){
            layoutParams.flags |= bits;
        }else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }


}