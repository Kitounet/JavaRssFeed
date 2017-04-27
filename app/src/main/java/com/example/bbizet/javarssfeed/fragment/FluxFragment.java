package com.example.bbizet.javarssfeed.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bbizet.javarssfeed.R;
import com.example.bbizet.javarssfeed.receiver.SpecificFlux;
import com.example.bbizet.javarssfeed.row.FluxRow;
import com.example.bbizet.javarssfeed.row.FluxRowAdapter;
import com.example.bbizet.javarssfeed.service.RequestService;
import com.example.bbizet.javarssfeed.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bbizet on 26/04/2017.
 */

public class FluxFragment extends Fragment {
    private String token;
    private String flux;
    private int id;
    private ListView mListView;

    public FluxFragment() {
    }

    public static FluxFragment newInstance(String flux, String token, int id)
    {
        FluxFragment instance = new FluxFragment();
        instance.token = token;
        instance.flux = flux;
        instance.id = id;
        return instance;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TEST", "onCREATEVIEW!!!");
        final View mView = inflater.inflate(R.layout.flux_fragment, container, false);
        Log.d("TEST", "onCREATEVIEW1!!!");
        mListView = (ListView) mView.findViewById(R.id.listView);
        TextView title = (TextView) mView.findViewById(R.id.flux_title);
        title.setText(flux);
        Log.d("TEST", "onCREATEVIEW2!!!");

        RequestService service = ServiceFactory.createRetrofitService(RequestService.class, RequestService.ENDPOINT);
        service.getSpecificFlux(id, token)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SpecificFlux>() {
                    @Override
                    public final void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public final void onError(Throwable e) {
                        Log.e("Weball", e.getMessage());
                    }

                    @Override
                    public final void onNext(SpecificFlux response) {
                        if (response != null) {

                            List<FluxRow> rows = generateRows(response.getItem());
                            Log.d("TEST", "OnNextNotificationFragment");
                            FluxRowAdapter adapter = new FluxRowAdapter(mView.getContext(),rows);
                            mListView.setAdapter(adapter);
                        }
                    }
                });

        return mView;
    }


    private List<FluxRow> generateRows(List<SpecificFlux.Item> request)
    {
        List<FluxRow> rows = new ArrayList<FluxRow>();

        for (int i = 0; i < request.size(); i++)
        {
            rows.add(new FluxRow(request.get(i).getIditem(), request.get(i).getIdfeed(), request.get(i).getTitle(), request.get(i).getDescription(), request.get(i).getLink(),
                    request.get(i).getGuid(), request.get(i).getPubDate()));
        }

        return rows;
    }
}
