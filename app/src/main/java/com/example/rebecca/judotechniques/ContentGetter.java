package com.example.rebecca.judotechniques;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by rebecca on 15/01/18.
 */

public class ContentGetter extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
    public static String[] getThrows(String pressed) {
        String ikkyo[] = {
                "De-ashi-harai",
                "Hiza-guruma",
                "Sasae-tsurikomi-ashi",
                "Uki-goshi",
                "Osoto-gari",
                "O-goshi",
                "Ouchi-gari",
                "Seoi-nage"
        };
        String nikkyo[] = {
                "Kosoto-gari",
                "Kouchi-gari",
                "Koshi-guruma",
                "Tsurikomi-goshi",
                "Okuri-ashi-harai",
                "Tai-Otoshi",
                "Harai-goshi",
                "Uchi-mata"
        };
        String sankyo[] = {
                "Kosoto-gake",
                "Tsuri-goshi",
                "Yoko-Otoshi",
                "Ashi-guruma",
                "Hane-goshi",
                "Harai-tsurikomi-ashi",
                "Tomoe-nage",
                "Kata-guruma"
        };
        String yonkyo[] = {
                "Sumi-gaeshi",
                "Tani-Otoshi",
                "Hane-makikomi",
                "Sukui-nage",
                "Utsuri-goshi",
                "O-guruma",
                "Soto-makikomi",
                "Uki-Otoshi"
        };
        String gokyo[] = {
                "Osoto-guruma",
                "Uki-waza",
                "Yoko-wakare",
                "Yoko-guruma",
                "Ushiro-goshi",
                "Ura-nage",
                "Sumi-Otoshi",
                "Yoko-gake"
        };

        if (pressed.equals("Dai Ikkyo")) {
            return ikkyo;
        } else if (pressed.equals("Dai Nikkyo")) {
            return nikkyo;
        } else if (pressed.equals("Dai Sankyo")) {
            return sankyo;
        } else if (pressed.equals("Dai Yonkyo")) {
            return yonkyo;
        } else {
            return gokyo;
        }

    }

    public static String[] getCodes(Context context, String throw_name) {
        String path = "app/src/main/assets/";
        AssetManager a = context.getAssets();
        ArrayList<String> codes = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(a.open(throw_name + ".txt")));

            String line;
            String[] splitted;

            while ((line = br.readLine()) != null) {
                splitted = line.split("\\s+");
                codes.add(splitted[0]);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        System.out.println(codes.toString());

        String[] cds = new String[codes.size()];
        return codes.toArray(cds);
    }

    public static int[] getThumbIds(Context context, String[] codes) {
        // int drawableResourceId = this.getResources().getIdentifier("nameOfDrawable", "drawable", this.getPackageName());
        int[] ids = new int[codes.length];
        int idN = 0;
        String fn;
        for (int i = 0; i < codes.length; i++) {
            fn = encode(codes[i]);
            ids[idN++] = context.getResources().getIdentifier(fn, "drawable", context.getPackageName());
        }
        return ids;
    }

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
}
