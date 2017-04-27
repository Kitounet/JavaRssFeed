package com.example.bbizet.javarssfeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.bbizet.javarssfeed.fragment.FluxFragment;
import com.example.bbizet.javarssfeed.receiver.Flux;
import com.example.bbizet.javarssfeed.receiver.Register;
import com.example.bbizet.javarssfeed.requestClass.SubscribeBody;
import com.example.bbizet.javarssfeed.service.RequestService;
import com.example.bbizet.javarssfeed.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bbizet on 26/04/2017.
 */

public class NetworkActivity extends FragmentActivity {
    private String      token;
    protected ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.network_activity);


        token = getIntent().getStringExtra("token");
        Log.d("TEST", "TOKENNNNNN = " + token);
        pager = (ViewPager) findViewById(R.id.viewpager);
        RequestService service = ServiceFactory.createRetrofitService(RequestService.class, RequestService.ENDPOINT);
        service.getFlux(token)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Flux>()
                {
                    @Override
                    public final void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public final void onError(Throwable e) {
                        Log.e("Weball", e.getMessage());
                        Toast.makeText(getApplicationContext(), "Error Message : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public final void onNext(Flux response) {
                        List<String> myTabList = new ArrayList<String>();
                        List<Fragment> fragments = new Vector<Fragment>();

                        for (int i = 0; i < response.getChannels().size(); i++)
                        {
                            myTabList.add(response.getChannels().get(i).getAlias());
                            fragments.add(FluxFragment.newInstance(response.getChannels().get(i).getTitle(), token, response.getChannels().get(i).getIdfeed()));
                        }

                        MyPagerAdapter mp = new MyPagerAdapter(getSupportFragmentManager(), fragments);
                        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments));
                        pager.setCurrentItem(0);

                        // Bind the tabs to the ViewPager
                        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
                        tabs.setIndicatorColor(getResources().getColor(R.color.green));
                        tabs.setShouldExpand(true);
                        tabs.setViewPager(pager);
                    }
                });

    }
}
