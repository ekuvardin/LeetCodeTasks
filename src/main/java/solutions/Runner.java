package solutions;

public class Runner {

    public static void main(String[] args) throws Exception {
        RateLimiterCustom.windowShift();
        RateLimiterCustom.basisThreshold();
        RateLimiterCustom.reuseBacket();
        RateLimiterCustom.noThreshold();
        RateLimiterCustom.noThresholdSecondTime();
        RateLimiterCustom.windowShiftNSeconds();
    }

}

