package com.example.bbizet.javarssfeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bbizet.javarssfeed.receiver.Login;
import com.example.bbizet.javarssfeed.requestClass.LoginBody;
import com.example.bbizet.javarssfeed.service.RequestService;
import com.example.bbizet.javarssfeed.service.ServiceFactory;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bbizet on 07/04/2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final EditText login = (EditText) findViewById(R.id.user_login);
        final EditText pass = (EditText) findViewById(R.id.user_password);
        final Button loginButton = (Button) findViewById(R.id.connectionbutton);
        final TextView create_account = (TextView) findViewById(R.id.create_account);


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this, SubscribeActivity.class);
                startActivity(intent);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (login.getText().toString() != "" && pass.getText().toString() != "") {
                    Log.d("TEST", "I'm HEREEE ?");

                    RequestService service = ServiceFactory.createRetrofitService(RequestService.class, RequestService.ENDPOINT);
                    service.getToken(new LoginBody(login.getText().toString(), pass.getText().toString()))
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<Login>()
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
                                public final void onNext(Login response) {
                                    if (response.getToken() != null) {
                                        Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                                        Bundle mybundle = new Bundle();
                                        Log.d("TEST", "tokenLEL = " + response.getToken());
                                        if (response != null) {

                                            intent.putExtra("token", response.getToken());
                                            startActivity(intent);
                                        }
                                    }
                                    else
                                        Toast.makeText(getApplicationContext(), "Login Failed probably wrong information", Toast.LENGTH_LONG).show();
                                }
                            });

                }
                else
                    Toast.makeText(getApplicationContext(), "Vous devez remplir les champs pour vous connecter", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
