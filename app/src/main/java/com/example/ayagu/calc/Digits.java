package com.example.ayagu.calc;

public class Digits {

    private double d1;
    private double d2;

    private String sign;

    private boolean calc = false;

    private int dotTen = 1;

    private boolean dot = false;

    public void setDotTen(int dotTen) {
        this.dotTen = dotTen;
    }

    public int getDotTen() {
        return dotTen;
    }

    public void nullifyDotTen() {
        this.dotTen = 1;
    }

    public boolean isDot() {
        return dot;
    }

    public void setDot(boolean dot) {
        this.dot = dot;
    }

    public boolean isCalc() {
        return calc;
    }

    public void setCalc(boolean calc) {
        this.calc = calc;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double dg) {
        this.d1 = setter(dg, this.d1);

    }
    public void setD2(double dg) {
        this.d2 = setter(dg, this.d2);

    }

    private double setter(double dg, double thisD){
        if (dot)
            dotTen *= 10;

            return dg == -1 ?        thisD * -1 :
                    thisD < 0 ?     (thisD * dotTen * (dot? 1:10) - dg) / dotTen :
                                    (thisD * dotTen * (dot? 1:10) + dg) / dotTen;
    }


    public double getD2() {

        return d2;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public boolean isSignNull(){
        return (sign == null);
    }

    public void clearD1(){
        d1 = 0f;
    }

    public void clearD2(){
        d2 = 0f;
    }

}
