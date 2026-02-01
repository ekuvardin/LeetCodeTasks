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
    int usersExceedRates = 0;

    public RateLimiterCustom(int threshold, int windowSize) {
        this.threshold = threshold;
        this.windowSize = windowSize;
        this.buckets = new Bucket[windowSize];
        this.userRequests = new HashMap<>();

        for (int i = 0; i < windowSize; i++) {
            buckets[i] = new Bucket();
            buckets[i].timestamp = Integer.MIN_VALUE;
        }
    }

    private static class Bucket {
        long timestamp;
        // Можно заменить на, если много запросов от одного пользователя в секунду
        // Map<Integer, Integer> userHits = new HashMap<>();
        List<Integer> users = new ArrayList<>();

        void clear(long ts) {
            timestamp = ts;
            users.clear();
        }
    }


    public void registerRequest(int userId) {
        long timestamp = System.currentTimeMillis() / 1000;
        registerRequest(timestamp, userId);
    }

    //For test
    public void registerRequest(long timestamp, int userId) {
        int index = (int) (timestamp % this.windowSize);
        Bucket currentBucket = buckets[index];

        if (currentBucket.timestamp != timestamp) {
            clearBucket(currentBucket, timestamp);
        }

        currentBucket.users.add(userId);
        int cnt = userRequests.getOrDefault(userId, 0);
        userRequests.put(userId, cnt + 1);

        if (cnt == threshold) {
            usersExceedRates++;
        }
    }

    public void clearBucket(Bucket bucket, long timestamp) {
        for (int uid : bucket.users) {
            int prev = userRequests.get(uid);
            int newCnt = prev - 1;

            if (prev == threshold + 1) {
                usersExceedRates--;
            }

            if (newCnt == 0) {
                userRequests.remove(uid);
            } else {
                userRequests.put(uid, newCnt);
            }
        }
        bucket.clear(timestamp);
    }

    public int getCountUser() {
        return usersExceedRates;
    }
}
