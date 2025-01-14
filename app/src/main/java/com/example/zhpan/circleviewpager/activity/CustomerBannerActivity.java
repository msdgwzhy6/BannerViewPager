package com.example.zhpan.circleviewpager.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.zhpan.circleviewpager.R;
import com.example.zhpan.circleviewpager.bean.CustomBean;
import com.example.zhpan.circleviewpager.viewholder.CustomPageViewHolder;
import com.zhpan.bannerview.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class CustomerBannerActivity extends AppCompatActivity {
    private List<CustomBean> mList = new ArrayList<>();
    private BannerViewPager<CustomBean, CustomPageViewHolder> mViewPager;
    private int[] imgRes = {R.drawable.guide0, R.drawable.guide1, R.drawable.guide2};
    private String[] des = {"在这里\n你可以听到周围人的心声", "在这里\nTA会在下一秒遇见你", "在这里\n不再错过可以改变你一生的人"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_banner);
        initData();
        initViewPager();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.stopLoop();
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAutoPlay(false)
                .setCanLoop(false)
                .showIndicator(false)
                .setOnPageClickListener(position -> Toast.makeText(CustomerBannerActivity.this,
                        "点击页面" + (position + 1), Toast.LENGTH_SHORT).show())
                .setHolderCreator(() -> {
                    CustomPageViewHolder customPageViewHolder = new CustomPageViewHolder();
                    customPageViewHolder.setOnSubViewClickListener((view, position) -> Toast.makeText(CustomerBannerActivity.this,
                            "立即体验" + (position + 1), Toast.LENGTH_SHORT).show());
                    return customPageViewHolder;
                }).create(mList);
    }

    private void initData() {
        for (int i = 0; i < imgRes.length; i++) {
            CustomBean customBean = new CustomBean();
            customBean.setImageRes(imgRes[i]);
            customBean.setImageDescription(des[i]);
            mList.add(customBean);
        }
    }
}
