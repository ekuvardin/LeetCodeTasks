package solutions;

/*
Вторая задача: есть магазин со списком доступных товаров. У каждого товара есть свой номер. И есть покупатель со списком нужных ему товаров. Если нужного ему товара нет, то он берет товар с ближайшим к нужному номеру. При этом неудовлетворенность покупателя равна разнице нужного номера с тем, который он взял. Нужно посчитать неудовлетворенность пользователя.
Пример: товары { 1, 2, 3, 5, 6, 9}
товары, нужные пользователю: { 1, 2, 6 }
неудовлетворенность 0

товары { 1, 2, 3, 5, 6, 9 }
товары, нужные пользователю: { 1, 5, 7 }
неудовлетворенность 1

товары { 1 }
товары, нужные пользователю: { 1, 5, 7 }
неудовлетворенность 1
 */
public class ShelfAvito {
    public int calculate(int[] goods, int[] userGoods) {
        int result = 0;

        int goodPointer = 0;
        for (int i = 0; i < goods.length; i++) {
            if (goodPointer == userGoods.length) {
                break;
            }

            if (goods[i] == userGoods[goodPointer]) {
                goodPointer++;
            } else if (goods[i] > userGoods[goodPointer]) {
                result = result + calculateDiff(goods, i, userGoods[goodPointer]);
                goodPointer++;
            }
        }

        for (int i = goodPointer; i < userGoods.length; i++) {
            result = result + userGoods[i] - goods[goods.length - 1];
        }

        return result;

    }

    private int calculateDiff(int[] goods, int num, int search) {
        return num <= 0 ? search - goods[0] : Math.min(goods[num] - search, search - goods[num - 1]);
    }
}
