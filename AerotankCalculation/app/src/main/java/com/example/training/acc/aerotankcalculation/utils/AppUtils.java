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

    public static double luongBunSinhRa(double y, double kd, double tb, double qTb, double bodVao, double bodRa) {
        return ((double) Math.round((((y / (1 + kd * tb)) * qTb * (bodVao - bodRa)) / 1000) * 100) / 100);
    }

    public static double luuLuongXaBun(double v, double x, double qTb, double ssRa, double tb, double xt) {
        return ((double) Math.round((v * x - qTb * 0.65 * 0.8 * ssRa * tb) / (0.8 * xt * tb) * 100) / 100);
    }

    public static double khoiLuongBunXaRa(double qXaBun, double xt) {
        return qXaBun * xt / 1000;
    }

    public static double luuLuongTuanHoan(double qTb, double x, double xt) {
        return Math.round(qTb * (x / (0.8 * xt - x)));
    }
}
