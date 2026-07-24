import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, Object[]> checkIns = new HashMap<>();     // id -> [station, time]
    private Map<String, double[]> travelStats = new HashMap<>();   // "start-end" -> [totalTime, count]

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] start = checkIns.remove(id);
        String key = start[0] + "-" + stationName;
        int duration = t - (int) start[1];

        travelStats.putIfAbsent(key, new double[]{0, 0});
        double[] stats = travelStats.get(key);
        stats[0] += duration;  // total time
        stats[1] += 1;         // count
    }

    public double getAverageTime(String startStation, String endStation) {
        double[] stats = travelStats.get(startStation + "-" + endStation);
        return stats[0] / stats[1];
    }
}
