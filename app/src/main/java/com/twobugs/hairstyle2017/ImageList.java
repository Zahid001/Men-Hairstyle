package com.twobugs.hairstyle2017;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Zahid on 4/25/2017.
 */

public class ImageList extends AppCompatActivity {

    private AdView mBannerAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getActionBar().setHomeButtonEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list);

        //showActionBar();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mBannerAd = (AdView)findViewById(R.id.banner_AdView2);

        //Load BannerAd
        showBannerAd();


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ImageGalleryAdapter adapter = new ImageGalleryAdapter(this, MenPhoto.getMenPhotos());
        recyclerView.setAdapter(adapter);
    }

    //-- Banner ad loading method
    private void showBannerAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("143C4BEC8A2C3E7C041336DD4D7FA0B8")
                .build();
        mBannerAd.loadAd(adRequest);

    }


    public void ShowMSG() {
        Toast t = Toast.makeText(ImageList.this, "Value of Static", Toast.LENGTH_LONG);
        t.show();
    }
/*
    private void showActionBar() {
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_action_layout, null);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled (false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(v);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn1:
                finish();
                return true;

            case R.id.btn3:
                // right button
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_bar, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

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

    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View photoView = inflater.inflate(R.layout.item_layout, parent, false);
            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

            MenPhoto spacePhoto = mSpacePhotos[position];
            ImageView imageView = holder.mPhotoImageView;
           // ProgressBar pb = holder.loadingImageBar;

            Glide.with(mContext)
                    .load(spacePhoto.getUrl())
                    .asBitmap()
                    .placeholder(R.drawable.loadingimage)
                    .error(R.drawable.loadingimage)
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (mSpacePhotos.length);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;
            //public ProgressBar loadingImageBar;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
                //loadingImageBar = (ProgressBar)findViewById(R.id.loadingimagebar);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    MenPhoto spacePhoto = mSpacePhotos[position];
                    Intent intent = new Intent(mContext, SpacePhotoActivity.class);
                    intent.putExtra(SpacePhotoActivity.EXTRA_SPACE_PHOTO, spacePhoto);
                    startActivity(intent);
                }
            }
        }

        private MenPhoto[] mSpacePhotos;
        private Context mContext;

        public ImageGalleryAdapter(Context context, MenPhoto[] spacePhotos) {
            mContext = context;
            mSpacePhotos = spacePhotos;
        }
    }


    //--------------------

}
