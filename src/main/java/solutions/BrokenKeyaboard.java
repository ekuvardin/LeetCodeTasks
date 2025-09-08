package solutions;

import java.util.Stack;

/*
У Пети сломалась клавиатура.
 Когда он вводит b, то вместо этого стирается последняя введенная строчная буква.
  Когда вводит B (большая английская бэ), то стирается последняя введенная заглавная буква.
   Остальные работают нормально. Дана строка из больших и маленьких английских букв,
   показывающая последовательность нажатия клавиш. Нужно вывести, что будет введено по факту.

     [InlineData("abcd", "cd")]
    [InlineData("ABCD", "CD")]
    [InlineData("abba", "a")]
    [InlineData("ABBA", "A")]
    [InlineData("aAbB", "")]
    [InlineData("xXyYzZbB", "xXyY")]
    [InlineData("xXyYBbzZ", "xXzZ")]
    [InlineData("abcdefgijklmnopqrstuvwxyz", "cdefgijklmnopqrstuvwxyz")]
    [InlineData("ABCDEFGIJKLMNOPQRSTUVWXYZ", "CDEFGIJKLMNOPQRSTUVWXYZ")]
    public void UnEscape(string a, string e)

    Tinkoff
 */
public class BrokenKeyaboard {

    public static String brKeybaord(String inline) {
        Stack<Pair> lower = new Stack<>();
        Stack<Pair> higher = new Stack<>();

        for (int i = 0; i < inline.length(); i++) {
            char temp = inline.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                if (temp == 'b') {
                    if (!lower.isEmpty()) {
                        lower.pop();
                    }
                } else {
                    lower.add(new Pair(temp, i));
                }
            } else {
                if (temp == 'B') {
                    if (!higher.isEmpty()) {
                        higher.pop();
                    }
                } else {
                    higher.add(new Pair(temp, i));
                }
            }
        }

        StringBuilder res = new StringBuilder();

        while (!lower.isEmpty() || !higher.isEmpty()) {
            Pair low = null;
            if (!lower.isEmpty()) {
                low = lower.peek();
            }

            Pair hh = null;
            if (!higher.isEmpty()) {
                hh = higher.peek();
            }

            if (hh == null || (low != null && low.pos >= hh.pos)) {
                lower.pop();
                res.insert(0, low.ch);
            } else {
                higher.pop();
                res.insert(0, hh.ch);
            }
        }

        return res.toString();
    }

    public static class Pair {
        char ch;
        int pos;

        public Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }

        public char getCh() {
            return ch;
        }

        public void setCh(char ch) {
            this.ch = ch;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }
}
