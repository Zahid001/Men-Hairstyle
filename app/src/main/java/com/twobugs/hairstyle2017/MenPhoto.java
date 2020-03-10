package com.twobugs.hairstyle2017;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zahid on 4/26/2017.
 */

public class MenPhoto implements Parcelable {

    private String mUrl;
    private String mTitle;
    //-----------
    /*
    public static String link1, link2, link3, link4, link5, link6, link7, link8, link9, link10,
            link11, link12, link13, link14, link15, link16, link17, link18, link19, link20,
            link21, link22, link23, link24, link25, link26, link27, link28, link29, link30,
            link31, link32, link33, link34, link35, link36, link37, link38, link39, link40,
            link41, link42, link43, link44, link45, link46, link47, link48, link49, link50;
            */

    //--------------

    public MenPhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected MenPhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<MenPhoto> CREATOR = new Creator<MenPhoto>() {
        @Override
        public MenPhoto createFromParcel(Parcel in) {
            return new MenPhoto(in);
        }

        @Override
        public MenPhoto[] newArray(int size) {
            return new MenPhoto[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static MenPhoto[] getMenPhotos() {

/*
        if (MainActivity.hairType == 1) {
            link1 = "http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Long-Fringe-Low-Fade.jpg";
            link2 = "http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade.jpg";
            link3 = "http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-Loose-Pompadour.jpg";
            link4 = "";
            link5 = "";
            link6 = "";
            link7 = "";
            link8 = "";
            link9 = "";
            link10 = "";

            link11 = "";
            link12 = "";
            link13 = "";
            link14 = "";
            link15 = "";
            link16 = "";
            link17 = "";
            link18 = "";
            link19 = "";
            link20 = "";

            link21 = "";
            link22 = "";
            link23 = "";
            link24 = "";
            link25 = "";
            link26 = "";
            link27 = "";
            link28 = "";
            link29 = "";
            link30 = "";

            link31 = "";
            link32 = "";
            link33 = "";
            link34 = "";
            link35 = "";
            link36 = "";
            link37 = "";
            link38 = "";
            link39 = "";
            link40 = "";

            link41 = "";
            link42 = "";
            link43 = "";
            link44 = "";
            link45 = "";
            link46 = "";
            link47 = "";
            link48 = "";
            link49 = "";
            link50 = "";

        } else {

            link1 = "http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Long-Messy-Hair-with-Low-Fade.jpg";
            link2 = "http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Long-Fringe-Low-Fade.jpg";
            link3 = "";
            link4 = "";
            link5 = "";
            link6 = "";
            link7 = "";
            link8 = "";
            link9 = "";
            link10 = "";

            link11 = "";
            link12 = "";
            link13 = "";
            link14 = "";
            link15 = "";
            link16 = "";
            link17 = "";
            link18 = "";
            link19 = "";
            link20 = "";

            link21 = "";
            link22 = "";
            link23 = "";
            link24 = "";
            link25 = "";
            link26 = "";
            link27 = "";
            link28 = "";
            link29 = "";
            link30 = "";

            link31 = "";
            link32 = "";
            link33 = "";
            link34 = "";
            link35 = "";
            link36 = "";
            link37 = "";
            link38 = "";
            link39 = "";
            link40 = "";

            link41 = "";
            link42 = "";
            link43 = "";
            link44 = "";
            link45 = "";
            link46 = "";
            link47 = "";
            link48 = "";
            link49 = "";
            link50 = "";
        }

        return new MenPhoto[]{
                new MenPhoto(link1, "Hair Style 2017"),
                new MenPhoto(link2, "Hair Style 2017"),
                new MenPhoto(link3, "Hair Style 2017"),
                new MenPhoto(link4, "Hair Style 2017"),
                new MenPhoto(link5, "Hair Style 2017"),
                new MenPhoto(link6, "Hair Style 2017"),
                new MenPhoto(link7, "Hair Style 2017"),
                new MenPhoto(link8, "Hair Style 2017"),
                new MenPhoto(link9, "Hair Style 2017"),
                new MenPhoto(link10, "Hair Style 2017"),

                new MenPhoto(link11, "Hair Style 2017"),
                new MenPhoto(link12, "Hair Style 2017"),
                new MenPhoto(link13, "Hair Style 2017"),
                new MenPhoto(link14, "Hair Style 2017"),
                new MenPhoto(link15, "Hair Style 2017"),
                new MenPhoto(link16, "Hair Style 2017"),
                new MenPhoto(link17, "Hair Style 2017"),
                new MenPhoto(link18, "Hair Style 2017"),
                new MenPhoto(link19, "Hair Style 2017"),
                new MenPhoto(link20, "Hair Style 2017"),

                new MenPhoto(link21, "Hair Style 2017"),
                new MenPhoto(link22, "Hair Style 2017"),
                new MenPhoto(link23, "Hair Style 2017"),
                new MenPhoto(link24, "Hair Style 2017"),
                new MenPhoto(link25, "Hair Style 2017"),
                new MenPhoto(link26, "Hair Style 2017"),
                new MenPhoto(link27, "Hair Style 2017"),
                new MenPhoto(link28, "Hair Style 2017"),
                new MenPhoto(link29, "Hair Style 2017"),
                new MenPhoto(link30, "Hair Style 2017"),

                new MenPhoto(link31, "Hair Style 2017"),
                new MenPhoto(link32, "Hair Style 2017"),
                new MenPhoto(link33, "Hair Style 2017"),
                new MenPhoto(link34, "Hair Style 2017"),
                new MenPhoto(link35, "Hair Style 2017"),
                new MenPhoto(link36, "Hair Style 2017"),
                new MenPhoto(link37, "Hair Style 2017"),
                new MenPhoto(link38, "Hair Style 2017"),
                new MenPhoto(link39, "Hair Style 2017"),
                new MenPhoto(link40, "Hair Style 2017"),

                new MenPhoto(link41, "Hair Style 2017"),
                new MenPhoto(link42, "Hair Style 2017"),
                new MenPhoto(link43, "Hair Style 2017"),
                new MenPhoto(link44, "Hair Style 2017"),
                new MenPhoto(link45, "Hair Style 2017"),
                new MenPhoto(link46, "Hair Style 2017"),
                new MenPhoto(link47, "Hair Style 2017"),
                new MenPhoto(link48, "Hair Style 2017"),
                new MenPhoto(link49, "Hair Style 2017"),
                new MenPhoto(link50, "Hair Style 2017"),


        };

 */

        return new MenPhoto[]{

                //-- 35 New Hairstyles For Men in 2017 --  http://www.menshairstylestoday.com/new-hairstyles-for-men/
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Long-Messy-Hair-with-Low-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Long-Fringe-Low-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-Loose-Pompadour.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-with-Hard-Part-and-Quiff.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Braided-Razor-Part-with-Pompadour.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Man-Bun-with-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Short-Hair-with-Cropped-Fringe.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Short-Sides-with-Medium-Length-Hair-on-Top.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Classic-Short-Haircut.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Slicked-Back-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Modern-Faux-Hawk.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Hard-Part-Pompadour.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-with-Thick-Long-Hair-Quiff.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Undercut-with-Top-Knot.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Mid-Fade-with-Side-Part-and-Long-Fringe.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Mohawk.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Tall-Thick-Hair-on-Top.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Low-Skin-Fade-with-Wavy-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Side-Quiff.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Classic-Pompadour.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Classic-Messy-Long-Hair-with-Thick-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-Hard-Part-Curly-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Curly-Hair-Undercut.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Slicked-Back-Undercut-with-Long-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-Comb-Over.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Skin-Fade-Solid-Fringe.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Faux-Hawk.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Bald-Fade-with-Natural-Curls-on-Top.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-with-Braids-Long-Spiked-Hair.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Layered-Long-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Black-Men-Hairstyles-FroHawk.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Black-Men-Haircuts-Simple-Buzz-with-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Long-Hair-Undercut.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Man-Bun.jpg", "Hair Style 2017"),

                //-- 49 Men’s Hairstyles To Try In 2017 -- http://www.menshairstylestoday.com/mens-hairstyles-2017/
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Modern-Mens-Haircuts-Undercut-with-Shape-Up-and-Thick-Comb-Over.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Barbershop-Haircuts-Faux-Hawk-FoHawk-with-High-Burst-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Low-Taper-Fade-with-Messy-Spiky-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Long-Flowing-Wavy-Hair-Brushed-Back.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Pompadour-with-High-Taper-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Long-Curly-Fringe-with-Fade-and-Hair-Design.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Mens-Top-Knot-Hairstyle-Undercut-with-Top-Knot.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Quiff-with-High-Fade-and-Shape-Up.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Spiky-Hair-with-Taper-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Modern-Mens-Hairstyles-Side-Part-with-High-Bald-Fade.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Fade-with-Messy-Hair-and-Brush-Up.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Fringe-with-Disconnected-Hard-Part-and-Low-Skin-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Hairstyles-with-Beards-High-Taper-Fade-with-Long-Slicked-Back-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Thick-Hair-on-Top-with-Mid-Skin-Fade-and-Part.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Drop-Fade-with-Curly-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Buzz-Cut-with-Skin-Fade-and-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Bald-Undercut-with-Pompadour.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Wavy-Hairstyles-For-Men-Short-Sides-with-Messy-Wavy-Crew-Cut.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Medium-Length-Comb-Over-with-Low-Taper-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/High-Skin-Fade-with-Comb-Over-and-Hard-Part.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Undercut-with-Textured-Slicked-Back-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Side-Swept-Fringe-with-Messy-Crew-Cut.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Quiff-with-Brush-Up-and-Undercut.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/High-Fade-with-French-Crop.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Medium-Length-Haircut-Medium-Length-Textured-Hair-with-High-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Dapper-Haircuts-High-Fade-with-Thick-Textured-Spiky-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/High-Bald-Fade-with-Curly-Twists.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Fresh-Low-Taper-Fade-with-Thick-Brushed-Back-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Low-Skin-Fade-with-Curly-Hair-on-Top.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Cool-Hairstyles-For-Men-High-Fade-with-Angular-Brush-Back.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Side-Swept-Hair-with-Mid-Skin-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Pompadour-with-High-Skin-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Undercut-with-Thick-Textured-Spiked-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Messy-Hair-with-Brushed-Up-Fringe-and-High-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Low-Skin-Fade-with-Line-Up-and-Wavy-Quiff.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Buzz-Cut-with-Beard-1.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/High-Fade-with-Side-Part.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Mid-Skin-Fade-with-Textured-Slick-Back.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Undercut-with-Thick-Comb-Over.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Mid-Bald-Fade-with-Textured-Spiky-Hair.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Long-Fringe-with-Fade-and-Edge-Up.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Cool-Textured-Curly-Hair-with-Fade-and-Hard-Part.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Spiky-Fringe-with-High-Bald-Fade-and-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2016/12/Bald-Fade-with-Crew-Cut-and-Brushed-Up-Fringe.jpg", "Hair Style 2017"),


                //-- 21 Top Men’s Fade Haircuts -- http://www.menshairstylestoday.com/mens-fade-haircuts/
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-High-Bald-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-High-Fade-Pompadour.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-High-Fade-With-Long-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Taper-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Curly-Hair-With-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Comb-Over-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-High-Low-Fade-with-Pompadour.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Disconnected-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Low-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-Haircut-12.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Low-Bald-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Fade-Haircut-11.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Faded-Mohawk.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Mid-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Fade-Haircut-Classic-Fade.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Low-Skin-Fade-with-Spiky-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Mid-Fade-with-Textured-Slick-Back.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Temple-Fade-with-Comb-Over.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Taper-Fade-with-Design.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/High-Bald-Fade-with-Crew-Cut.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2015/12/Low-Bald-Fade-with-Slick-Back.jpg", "Hair Style 2017"),

                //-- The Slicked Back Undercut Hairstyle -- http://www.menshairstylestoday.com/slicked-back-undercut-hairstyle/
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Slicked-Back-Undercut-with-Thick-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Long-Slicked-Back-Undercut-Hairstyle.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/How-To-Style-The-Slicked-Back-Undercut.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Classic-Slicked-Back-Hair.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Long-Modern-Slicked-Back-Undercut.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Slicked-Back-Hair-with-Design.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Best-Slicked-Back-Undercut-Hairstyles.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Mens-Long-Undercut-Slick-Back-with-Hair-Design.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Long-Textured-Slicked-Back-Hair-with-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Mens-Slicked-Back-Undercut-Style.jpg", "Hair Style 2017"),

                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Mens-Slicked-Back-Hairstyles-How-To-Get-The-Slick-Back.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Thick-Textured-Slicked-Back-Hair-with-Full-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Undercut-Slicked-Back-with-Thick-Full-Beard.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Thick-Textured-Hair-Slicked-Back-with-Undercut-on-the-Sides.jpg", "Hair Style 2017"),
                new MenPhoto("http://www.menshairstylestoday.com/wp-content/uploads/2017/02/Cool-Slicked-Back-Hair-with-Undercut-Hairstyle.jpg", "Hair Style 2017"),

                //--
                //new MenPhoto("", "Hair Style 2017"),




        };



    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}
