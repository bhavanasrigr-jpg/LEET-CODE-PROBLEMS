lass Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            int currDx = x - x0;
            int currDy = y - y0;

            // cross product == 0 means (currDx, currDy) is parallel to (dx, dy)
            if (dx * currDy - dy * currDx != 0) {
                return false;
            }
        }

        return true;
    }
}
