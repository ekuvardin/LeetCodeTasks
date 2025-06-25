package solutions;


import java.util.ArrayList;
import java.util.List;

/*
Привет, первая задача звучала так: есть матрица данных.
Каждый столбец - это день,
каждая строчка - это список объектов типа id "бегуна" и кол-во км,
 которые он пробежал в этот день. Нужно определить чемпиона (или чемпионов, если их несколько),
 которые пробежали больше всего км за все дни. Плюс чемпион должен бежать каждый день, то есть без пропусков.
  new int[][]{{0,0,1,1,1},{3,4,4,1,0},{1,1,1,1,1},{1,1,1,1,2},{1,1,1,1,2}};
 */
public class RunnerAvito {
    public List<Integer> calculate(int[][] values) {
        List<Integer> result = new ArrayList<>();

        int maxRun = 0;

        for (int i = 0; i < values.length; i++) {
            int currentRun = 0;

            for (int j = 0; j < values[0].length; j++) {
                if (values[i][j] == 0) {
                    currentRun=0;
                    break;
                }
                currentRun += values[i][j];
            }

            if (currentRun == maxRun && currentRun>0) {
                result.add(i);
            } else if (currentRun > maxRun) {
                result.clear();
                result.add(i);
                maxRun = currentRun;
            }
        }

        return result;
    }
}
