package baba88.com.aidlsclient;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import baba88.com.aidlstest.PersonAIDL;

public class MainActivity extends AppCompatActivity {

    ServiceConnection mConn;
    PersonAIDL mPersonAIDL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = new Intent("baba88.com.aidlstest.PersonService");

        intent.setPackage("baba88.com.aidlstest");

        mConn = new AIDLSconn();
        bindService(intent, mConn, Service.BIND_AUTO_CREATE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int sss = mPersonAIDL.query(1);
                    Snackbar.make(view, "Query:" + sss, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private final class AIDLSconn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mPersonAIDL = PersonAIDL.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mPersonAIDL = null;
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(mConn);
        super.onDestroy();
    }
}
