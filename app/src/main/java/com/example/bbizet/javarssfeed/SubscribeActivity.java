package com.example.bbizet.javarssfeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bbizet.javarssfeed.receiver.Register;
import com.example.bbizet.javarssfeed.requestClass.SubscribeBody;
import com.example.bbizet.javarssfeed.service.RequestService;
import com.example.bbizet.javarssfeed.service.ServiceFactory;

import java.util.List;
import java.util.Vector;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bbizet on 26/04/2017.
 */

public class SubscribeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscribe_activity);

        final EditText login = (EditText) findViewById(R.id.user_login);
        final EditText p1 = (EditText) findViewById(R.id.user_password);
        final EditText p2 = (EditText) findViewById(R.id.user_password2);
        TextView next = (TextView) findViewById(R.id.TextView2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = login.getText().toString();
                String first = p1.getText().toString();
                String second = p2.getText().toString();
                if (!first.equals("") && !second.equals("") && !username.equals(""))
                {
                    if (first.equals(second)) {
                        RequestService service = ServiceFactory.createRetrofitService(RequestService.class, RequestService.ENDPOINT);
                        service.subscribe(new SubscribeBody(username, first, second))
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<Register>()
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
                                    public final void onNext(Register response) {
                                        Toast.makeText(getApplicationContext(), "You subscribed succesfully", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(SubscribeActivity.this, MainActivity.class);
                                        Bundle mybundle = new Bundle();
                                        Log.d("TEST", "response = " + response);
                                        if (response != null) {
                                            intent.putExtra("response", response);
                                            startActivity(intent);
                                        }
                                    }
                                });
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Password are not the same", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Please fill all of these informations", Toast.LENGTH_LONG).show();
            }
        });
        ImageView prev = (ImageView) findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });
    }
}
