package solutions;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ATM {

    final Map<Integer, Integer> amountBanknote;

    public ATM() {
        amountBanknote = new TreeMap<>(Comparator.reverseOrder());
        amountBanknote.put(500, 0);
        amountBanknote.put(200, 0);
        amountBanknote.put(100, 0);
        amountBanknote.put(50, 0);
        amountBanknote.put(20, 0);
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            if (banknotesCount[i] != 0) {
                Integer key = null;
                switch (i) {
                    case 0:
                        key = 20;
                        break;
                    case 1:
                        key = 50;
                        break;
                    case 2:
                        key = 100;
                        break;
                    case 3:
                        key = 200;
                        break;
                    case 4:
                        key = 500;
                        break;
                }
                Integer value = amountBanknote.get(key);
                amountBanknote.put(key, value + banknotesCount[i]);
            }
        }
    }

    public int[] withdraw(int amount) {
        if (amount % 10 != 0) {
            return new int[]{-1};
        }

        int diff = amount;

        int i = 4;
        int[] res = new int[5];
        for (Map.Entry<Integer, Integer> entry : amountBanknote.entrySet()) {
            int currentBankNot = entry.getKey();
            if (diff >= currentBankNot && entry.getValue() > 0) {
                int required = diff / currentBankNot;
                int inHouse = entry.getValue();

                int withdraw = Math.min(required, inHouse);
                res[i] = withdraw;
                diff = diff - (currentBankNot * withdraw);
            }
            i--;

            if (diff == 0) {
                break;
            }
        }

        if (diff == 0) {
            for (int j = 0; j < res.length; j++) {
                if (res[j] != 0) {
                    Integer key = null;
                    switch (j) {
                        case 0:
                            key = 20;
                            break;
                        case 1:
                            key = 50;
                            break;
                        case 2:
                            key = 100;
                            break;
                        case 3:
                            key = 200;
                            break;
                        case 4:
                            key = 500;
                            break;
                    }

                    Integer oldValue = amountBanknote.get(key);
                    amountBanknote.put(key, oldValue - res[j]);
                }
            }

            return res;


        } else {
            return new int[]{-1};
        }
    }
}
