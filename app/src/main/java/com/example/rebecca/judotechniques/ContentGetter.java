package com.example.rebecca.judotechniques;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A bunch of static methods used to get information stored about the videos/ throws to be displayed
 * in the app.
 */

public class ContentGetter extends Application {
    public static final String PATH = "app/src/main/assets/";

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    /*
        Gets an array of throw names for each category on the main menu
     */
    public static String[] getThrows(String pressed) {
        String ikkyo[] = {
                "De ashi harai",
                "Hiza guruma",
                "Sasae tsurikomi ashi",
                "Uki goshi",
                "Osoto gari",
                "O goshi",
                "Ouchi gari",
                "Seoi nage"
        };
        String nikkyo[] = {
                "Kosoto gari",
                "Kouchi gari",
                "Koshi guruma",
                "Tsurikomi goshi",
                "Okuri ashi harai",
                "Tai Otoshi",
                "Harai goshi",
                "Uchi mata"
        };
        String sankyo[] = {
                "Kosoto gake",
                "Tsuri goshi",
                "Yoko Otoshi",
                "Ashi guruma",
                "Hane goshi",
                "Harai tsurikomi ashi",
                "Tomoe nage",
                "Kata guruma"
        };
        String yonkyo[] = {
                "Sumi gaeshi",
                "Tani Otoshi",
                "Hane makikomi",
                "Sukui nage",
                "Utsuri goshi",
                "O guruma",
                "Soto makikomi",
                "Uki Otoshi"
        };
        String gokyo[] = {
                "Osoto guruma",
                "Uki waza",
                "Yoko wakare",
                "Yoko guruma",
                "Ushiro goshi",
                "Ura nage",
                "Sumi Otoshi",
                "Yoko gake"
        };

        String others[] = {
                "Seoi Otoshi",
                "Morote Seoi Nage",
                "Sode Tsuri Komi Goshi",
                "Osoto Otoshi"
        };

        if (pressed.equals("Dai Ikkyo")) {
            return ikkyo;
        } else if (pressed.equals("Dai Nikkyo")) {
            return nikkyo;
        } else if (pressed.equals("Dai Sankyo")) {
            return sankyo;
        } else if (pressed.equals("Dai Yonkyo")) {
            return yonkyo;
        } else if (pressed.equals("Dai Gokyo")) {
            return gokyo;
        } else {
            return others;
        }

    }

    /*
        Gets the resource id of each video thumbnail for an array of video codes
     */
    public static int[] getThumbIds(Context context, String[] codes) {
        int[] ids = new int[codes.length];
        int idN = 0;
        String fn;
        for (int i = 0; i < codes.length; i++) {
            fn = encode(codes[i]);
            ids[idN++] = context.getResources().getIdentifier(fn, "drawable", context.getPackageName());
        }
        return ids;
    }

    /*
        Takes a video code and turns it into the format of the image file in res/drawable
     */
    public static String encode(String code) {
        code = code.replaceAll("\\?t=[\\s\\S]+", "");
        String enc = "i";
        char c;
        for (int i = 0; i < code.length(); i++) {
            c = code.charAt(i);
            if (Character.isUpperCase(c)) {
                enc += "_" + Character.toLowerCase(c);
            } else if (c == '_') {
                enc += "__";
            } else if (c == '-') {
                enc += "_0";
            } else {
                enc += c;
            }
        }
        return enc;

    }

    /*
        Gets data from throw_name.txt files in asset folders
        index 0 = youtube video code
        index 1 = video title
        index 2 = video uploader
        index 3 = video duration
     */
    public static String[] getThrowData(Context context, String throw_name, int index) {
        AssetManager a = context.getAssets();
        ArrayList<String> data = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(a.open(throw_name + ".txt")));

            String line;
            String[] splitted;

            while ((line = br.readLine()) != null) {
                splitted = line.split("'\\s+'");
                data.add(splitted[index].replaceAll("\'", ""));
            }

            br.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        String[] cds = new String[data.size()];
        return data.toArray(cds);
    }
}
