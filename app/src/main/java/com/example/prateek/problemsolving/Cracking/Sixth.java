package com.example.prateek.problemsolving.Cracking;

/**
 * Created by admin on 1/30/18.
 */

public class Sixth {

    boolean isGirl() {
        if (Math.ceil(2 * Math.random()) == 1) {
            return true;
        }
        return false;
    }

    float ratioAfterBabiesTillGirl(int totalFamilies) {

        int totalBoys = 0;
        int totalGirls = 0;

        for (int family = 1; family < totalFamilies; family++) {
            while (!isGirl()) {
                totalBoys++;
            }
            totalGirls++;
        }
        return (float) totalGirls / totalBoys;
    }

}
