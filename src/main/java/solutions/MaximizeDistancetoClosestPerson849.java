package solutions;

/*
yandex

 l.maxDistToClosest(new int[]{1,0,0,0,1,0,1});
 */
public class MaximizeDistancetoClosestPerson849 {

    public int maxDistToClosest(int[] seats) {
        int lastPerson = -1;
        int maxDist = -1;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 && lastPerson == -1) {
                if (i != 0) {
                    maxDist = i - 1;
                }
                lastPerson = i;
            } else if (seats[i] == 1) {
                if (lastPerson != i - 1) {
                    int seatL = (lastPerson + i) / 2;
                    int maxDistL = Math.min(seatL - lastPerson, i - seatL) - 1;
                    if(maxDistL > maxDist) {
                        maxDist = maxDistL;
                    }
                }
                lastPerson = i;
            }
        }

        if (lastPerson != seats.length - 1 && (seats.length - lastPerson - 2) > maxDist) {
            maxDist = seats.length - 1 - lastPerson - 1;
        }

        return maxDist + 1;
    }
}
