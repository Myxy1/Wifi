package com.example.petrik.wifi;


import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_wifiOn:
                        Toast.makeText(MainActivity.this, "Wifi bekapcsolva", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(true);
                        break;

                    case R.id.action_wifiOff:
                        Toast.makeText(MainActivity.this, "Wifi kikapcsolva", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(false);
                        break;

                    case R.id.action_wifiStatus:

                        int status = wifiManager.getWifiState();
                        String result = "";
                        switch (status)
                        {
                            case WifiManager.WIFI_STATE_DISABLED:
                                result = "kikapcsolva";
                                break;

                            case WifiManager.WIFI_STATE_ENABLED:
                                result = "bekapcsolva";
                                break;

                            case WifiManager.WIFI_STATE_DISABLING:
                                result = "kikapcsolódik";
                                break;

                            case WifiManager.WIFI_STATE_ENABLING:
                                result = "bekapcsolódik";
                                break;
                        }
                        Toast.makeText(MainActivity.this, "Wifi " + result, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
