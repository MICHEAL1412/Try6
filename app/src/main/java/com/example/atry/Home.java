package com.example.atry;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    LinearLayout Popular,Coming_soon,Now_showing;
    private Handler sliderHandler = new Handler();
    private ViewPager2 viewPager2;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        viewPager2=findViewById(R.id.viewPagerImageSlider);
        List<SliderItem> sliderItems=new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.digimon_adventure___last_evolution_kizuna));
        sliderItems.add(new SliderItem(R.drawable.my_hero_academia___heros_rising));
        sliderItems.add(new SliderItem(R.drawable.hitman___agent_jun));
        sliderItems.add(new SliderItem(R.drawable.baba_yaga___terror_of_the_dark_forest));
        sliderItems.add(new SliderItem(R.drawable.jumanji2));
        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });

        Popular = (LinearLayout) findViewById(R.id.Popular2);
        Coming_soon = (LinearLayout) findViewById(R.id.Coming_soon2);
        Now_showing = (LinearLayout) findViewById(R.id.Now_showing2);
    }
    public void Pop(View view){
        Popular.setVisibility(View.VISIBLE);
        Coming_soon.setVisibility(View.GONE);
        Now_showing.setVisibility(View.GONE);
    }
    public void coming(View view){
        Popular.setVisibility(View.GONE);
        Coming_soon .setVisibility(View.VISIBLE);
        Now_showing.setVisibility(View.GONE);
    }
    public void Now(View view){
        Popular.setVisibility(View.GONE);
        Coming_soon.setVisibility(View.GONE);
        Now_showing.setVisibility(View.VISIBLE);
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };
}