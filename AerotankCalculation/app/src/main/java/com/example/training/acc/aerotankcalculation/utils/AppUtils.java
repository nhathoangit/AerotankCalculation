package com.example.training.acc.aerotankcalculation.utils;
/*
 * Created by NhatHoang on 03/12/2017.
 */

public class AppUtils {

    public static double luongBODHoaTan(double bod, double cod, double bodRa, double ssRa) {
        return bodRa - (0.65 * 1.42 * 0.8 * ssRa * (bod / cod));
    }

    public static double hieuQuaXuLy(double bod, double luongBODHoaTan) {
        return ((bod - luongBODHoaTan) / bod) * 100;
    }

}
