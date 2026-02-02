package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
yandex

Есть n пользователей, каждый с уникальным id.
Пользователей может быть много.
 Изначально заданы:
 Threshold - максимальное количество запросов, которое выполнит пользователь.
 Time - окно, в течение которого мы будем искать запросы

 Нужно реализовать методы:
  registerRequest(user_id) -  Метод регистрирует запрос пользователя с идентификатором user_id. Время регистрации брать текущее.
  getCountUser( time)  - получить количество пользователей, чье количество запросов, превысило threshold
                        за время: текущее время - time
  Оба метода должны работать за O(1)

Время   кол запр user1  кол запросов user 2
12:11   1               1
12:12   3               1
GetUserCount(time = 2 sec) = 1;
У пользователя 1 - 4 запроса,
у пользователя 2 - 2 запроса за последние 2 секунды.
 Итого только у 1 пользователя, код запросов больше 2
 */
public class RateLimiterCustom {

    private final int threshold;
    private final int windowSize;
    private final Bucket[] buckets;
    private final Map<Integer, Integer> userRequests;
    private long lastProcessedTime = -1;
    int usersExceedRates = 0;

    public RateLimiterCustom(int threshold, int windowSize) {
        this.threshold = threshold;
        this.windowSize = windowSize;
        this.buckets = new Bucket[windowSize];
        this.userRequests = new HashMap<>();

        for (int i = 0; i < windowSize; i++) {
            buckets[i] = new Bucket();
            buckets[i].timestamp = -1;
        }
    }

    public static class Bucket {
        long timestamp;
        Map<Integer, Integer> userHits = new HashMap<>();

        void clear() {
            userHits.clear();
        }
    }

    public void registerRequest(int userId) {
        long timestamp = System.currentTimeMillis() / 1000;
        registerRequest(timestamp, userId);
    }

    //For test
    public void registerRequest(long timestamp, int userId) {
        clearBuckets(timestamp);

        int index = (int) (timestamp % this.windowSize);
        Bucket currentBucket = buckets[index];

        if (currentBucket.timestamp != timestamp) {
            currentBucket.timestamp = timestamp;
            currentBucket.clear();
        }

        currentBucket.userHits.merge(userId, 1, Integer::sum);

        int cnt = userRequests.getOrDefault(userId, 0);
        userRequests.put(userId, cnt + 1);

        if (cnt == threshold) {
            usersExceedRates++;
        }
    }

    public void clearBuckets(long now) {
        if (lastProcessedTime == -1) {
            lastProcessedTime = now;
            return;
        }

        long oldestValid = now - windowSize + 1;
        long start = Math.max(lastProcessedTime + 1, oldestValid);

        for (long ts = start; ts <= now; ts++) {
            int index = (int) (ts % windowSize);
            Bucket bucket = buckets[index];

            if (bucket.timestamp == ts) {
                clearBucket(bucket);
            }
        }

        lastProcessedTime = now;
    }

    public void clearBucket(Bucket bucket) {
        for (Map.Entry<Integer, Integer> entry : bucket.userHits.entrySet()) {
            int userId = entry.getKey();
            int value = entry.getValue();

            int prev = userRequests.get(userId);
            int newCnt = prev - value;

            if (prev > threshold && newCnt <= threshold) {
                usersExceedRates--;
            }

            if (newCnt == 0) {
                userRequests.remove(userId);
            } else {
                userRequests.put(userId, newCnt);
            }
        }
        bucket.clear();
    }

    public int getCountUser() {
        return usersExceedRates;
    }

    /*Tests*/

    public static void basisThreshold() {
        RateLimiterCustom rateLimiterCustom = new RateLimiterCustom(2, 2);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);

        assert rateLimiterCustom.getCountUser() == 1;
    }

    public static void noThreshold() {
        RateLimiterCustom rateLimiterCustom = new RateLimiterCustom(2, 2);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(11, 1);

        assert rateLimiterCustom.getCountUser() == 0;
    }

    public static void windowShift() {
        RateLimiterCustom rateLimiterCustom = new RateLimiterCustom(2, 2);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);

        assert rateLimiterCustom.getCountUser() == 1;

        rateLimiterCustom.registerRequest(12, 1);

        assert rateLimiterCustom.getCountUser() == 0;
    }


    public static void windowShiftNSeconds() {
        RateLimiterCustom rateLimiterCustom = new RateLimiterCustom(2, 2);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(11, 1);

        assert rateLimiterCustom.getCountUser() == 1;

        rateLimiterCustom.registerRequest(15, 2);

        assert rateLimiterCustom.getCountUser() == 0;
    }


    public static void reuseBacket() {
        RateLimiterCustom rateLimiterCustom = new RateLimiterCustom(2, 2);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(11, 1);
        rateLimiterCustom.registerRequest(12, 2);

        assert rateLimiterCustom.getCountUser() == 0;
    }

    public static void twoUsersExitWindow() {
        RateLimiterCustom rateLimiterCustom = new RateLimiterCustom(2, 2);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(11, 2);
        rateLimiterCustom.registerRequest(11, 2);
        rateLimiterCustom.registerRequest(11, 2);

        assert rateLimiterCustom.getCountUser() == 1;

        rateLimiterCustom.registerRequest(12, 1);

        assert rateLimiterCustom.getCountUser() == 1;
    }

    public static void noThresholdSecondTime() {
        RateLimiterCustom rateLimiterCustom = new RateLimiterCustom(2, 2);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);
        rateLimiterCustom.registerRequest(10, 1);


        assert rateLimiterCustom.getCountUser() == 1;

        rateLimiterCustom.registerRequest(12, 2);

        assert rateLimiterCustom.getCountUser() == 0;
    }
}


