package com.example.mathyourbrain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FactsActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;

    //private Handler sliderHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
        viewPager2 = findViewById(R.id.viewPager);

        List<Slideritem> slideritems = new ArrayList<>();
        slideritems.add(new Slideritem(R.drawable.fact1));//Here you can change the images
        slideritems.add(new Slideritem(R.drawable.fact2));
        slideritems.add(new Slideritem(R.drawable.fact3));
        slideritems.add(new Slideritem(R.drawable.fact4));//Here you can change the images
        slideritems.add(new Slideritem(R.drawable.fact5));
        slideritems.add(new Slideritem(R.drawable.fact6));
        slideritems.add(new Slideritem(R.drawable.fact7));
        slideritems.add(new Slideritem(R.drawable.fact8));
        slideritems.add(new Slideritem(R.drawable.fact9));
        slideritems.add(new Slideritem(R.drawable.fact10));
        slideritems.add(new Slideritem(R.drawable.fact11));


        viewPager2.setAdapter(new SliderAdapter(slideritems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        /*viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable , 1000);
            }
        });*/
    }
    /*private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };   */
}
