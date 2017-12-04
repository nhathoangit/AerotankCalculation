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

    public static double theTichBe(double qTB, double y, double tb, double bodVao, double bodRa, double x, double kd) {
        return Math.round((qTB * y * tb * (bodVao - bodRa)) / (x * (1 + kd * tb)));
    }

    public static double chieuRongBe(double h, double l, double theTichBe) {
        return Math.round(theTichBe / (h * l));
    }

    public static double thoiGianLuuNuoc(double theTichBe, double qTB) {
        return ((double) Math.round((theTichBe / qTB) * 100) / 100) * 24;
    }

    public static double tySoFM(double bodVao, double t, double x) {
        return ((double) Math.round(bodVao / (t * x) * 100) / 100);
    }

    public static double taiTrongTheTich(double bodVao, double qTB, double v) {
        return ((double) Math.round(((bodVao * qTB) / (v * 1000)) * 100) / 100);
    }
}
