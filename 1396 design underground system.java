class UndergroundSystem {
    // Tracks each currently "checked-in" customer: id -> [startStation, checkInTime]
    private Map<Integer, Pair<String, Integer>> checkIns;

    // Tracks travel stats per route: "startStation->endStation" -> [totalTime, tripCount]
    private Map<String, double[]> travelStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInInfo = checkIns.remove(id);
        String startStation = checkInInfo.getKey();
        int startTime = checkInInfo.getValue();

        String route = startStation + "->" + stationName;
        double[] stats = travelStats.getOrDefault(route, new double[]{0.0, 0.0});
        stats[0] += (t - startTime); // total time
        stats[1] += 1;               // trip count
        travelStats.put(route, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        double[] stats = travelStats.get(route);
        return stats[0] / stats[1];
    }
}
