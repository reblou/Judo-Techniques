package com.example.rebecca.judotechniques;

/**
 * Created by rebecca on 15/01/18.
 */

public class ContentGetter {
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

        //     {"Dai Ikkyo", "Dai Nikkyo", "Dai Sankyo", "Dai Yonkyo", "Dai Gokyo"};
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

}
