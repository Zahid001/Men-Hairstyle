package com.twobugs.hairstyle2017;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;

import  de.hdodenhof.circleimageview.CircleImageView;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {

    //private Button men,women;
    private ImageView men;
    private  TextView tryAgain,send_your;
    public static int hairType = 1;
    private InterstitialAd mInterstitialAd;
    private AdView mBannerAd;
    private ProgressBar loadingBar;
    private boolean netState = false;
    private int buttonClickType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mBannerAd = (AdView)findViewById(R.id.banner_AdView);
        loadingBar = (ProgressBar)findViewById(R.id.progressBar);
        men = (ImageView)findViewById(R.id.men);
        tryAgain = (TextView)findViewById(R.id.tryAgain);
        send_your = (TextView)findViewById(R.id.send_your);

        men.setVisibility(View.INVISIBLE);
        tryAgain.setPaintFlags(tryAgain.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        send_your.setPaintFlags(tryAgain.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        tryAgain.setVisibility(View.INVISIBLE);
        send_your.setVisibility(View.INVISIBLE);




        if(haveNetworkConnection()) {



            //-- Show the loadingBar
            LoadingBarShow();

            // Creating and load a  new InterstitialAd .
            mInterstitialAd = createNewIntAd();
            loadIntAdd();

            //Load BannerAd
            showBannerAd();
            //Toast t = Toast.makeText(MainActivity.this,"Netstate : "+ netState,Toast.LENGTH_LONG);
            //t.show();




        }else {


           // Toast t = Toast.makeText(MainActivity.this,"Netstate : "+ netState,Toast.LENGTH_LONG);
            ButtonsDisable();
            send_your.setVisibility(View.INVISIBLE);
            TimerCheck();

        }



        men.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {

                hairType = 1;
                buttonClickType = 1;

                if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    Intent myIntent = new Intent(MainActivity.this, ImageList.class);
                    startActivity(myIntent);
                    //finish();
                }
            }
        });

        tryAgain.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        send_your.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {

                buttonClickType = 2;

                if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    Intent myIntent = new Intent(MainActivity.this, FacebookOpen.class);
                    startActivity(myIntent);
                    //finish();
                }
            }
        });




        //---------------------




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_bar, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();



        if (id == R.id.rate) {
            OnRateButtonClick();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //----------
    //Rating_purpose
    private boolean MyStartActivity(Intent aIntent) {
        try
        {
            startActivity(aIntent);
            return true;
        }
        catch (ActivityNotFoundException e)
        {
            return false;
        }
    }

    public  void OnRateButtonClick() {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        //Try Google play
        intent.setData(Uri.parse("market://details?id=com.twobugs.hairstyle2017"));
        if (!MyStartActivity(intent)) {
            //Market (Google play) app seems not installed, let's try to open a webbrowser
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.twobugs.hairstyle2017"));
            if (!MyStartActivity(intent)) {
                //Well if this also fails, we have run out of options, inform the user.
                Toast.makeText(this, "Could not open Play Store, please install the Google play app.", Toast.LENGTH_LONG).show();
            }
        }

    }



    //-----------

    //-- Checking internet connection

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    //-- Timer

    public void TimerCheck(){
        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        LoadingBarHide();
                        //ButtonsEnable();
                        ShowWarning();
                        tryAgain.setVisibility(View.VISIBLE);
                    }
                });
            }
        }, 5000);
    }

    //-- Show Warning

    public void ShowWarning(){
        Toast t = Toast.makeText(MainActivity.this,"Synchronization failed, please connect to internet",Toast.LENGTH_LONG);
        t.show();
    }

//-- Enable buttons
    public void ButtonsEnable() {

        men.setEnabled(true);

    }

    //-- Disable buttons
    public  void ButtonsDisable() {

        men.setEnabled(false);


    }

    //-- Showing loading Bar for synchronization

    public void LoadingBarShow() {

        loadingBar.setVisibility(View.VISIBLE);

    }

    public void LoadingBarHide() {

        loadingBar.setVisibility(View.INVISIBLE);
        //Toast t = Toast.makeText(MainActivity.this,"Synchronization failed, please connect to internet",Toast.LENGTH_LONG);
        //t.show();

    }
    //-- Banner ad loading method
    private void showBannerAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("143C4BEC8A2C3E7C041336DD4D7FA0B8")
                .build();
        mBannerAd.loadAd(adRequest);

    }

    //-- FullScreen ad maintaining method
    private InterstitialAd createNewIntAd() {
        InterstitialAd intAd = new InterstitialAd(this);
        // set the adUnitId (defined in values/strings.xml)
        intAd.setAdUnitId(getString(R.string.ad_id_interstitial));
        intAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

                LoadingBarHide();
                men.setVisibility(View.VISIBLE);
                send_your.setVisibility(View.VISIBLE);
                //Toast t = Toast.makeText(MainActivity.this,"Synchronizing successful",Toast.LENGTH_LONG);
               // t.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

               // LoadingBarHide();
               // Toast t = Toast.makeText(MainActivity.this,"Synchronization failed, please connect to internet",Toast.LENGTH_LONG);
               // t.show();
            }

            @Override
            public void onAdClosed() {

                LoadingBarHide();
                // Proceed to the next level.
                if(buttonClickType == 1) {
                    Intent myIntent = new Intent(MainActivity.this, ImageList.class);
                    startActivity(myIntent);
                    //finish();
                }else if (buttonClickType == 2) {
                    Intent myIntent = new Intent(MainActivity.this, FacebookOpen.class);
                    startActivity(myIntent);
                    //finish();
                }
            }
        });
        return intAd;
    }
    //-- FullScreen Ad loading method
    private void loadIntAdd() {
        // Disable the  level two button and load the ad.

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("143C4BEC8A2C3E7C041336DD4D7FA0B8")
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

    //--- Back button pressing
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }

    //--------------------


}
