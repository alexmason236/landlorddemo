package com.atguigu.landlord;

public class LandLordMain {
    public static void main(String[] args) {
        int[] pokers = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4,5};
        PokerUtils pokerUtils = new PokerUtils(pokers);
        pokerUtils.get3With2(0, 0);
    }
}
