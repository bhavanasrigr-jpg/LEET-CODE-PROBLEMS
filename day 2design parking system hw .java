class ParkingSystem {

    int[] parking;

    public ParkingSystem(int big, int medium, int small) {
        parking = new int[4];
        parking[1] = big;
        parking[2] = medium;
        parking[3] = small;
    }

    public boolean addCar(int carType) {
        if (parking[carType] > 0) {
            parking[carType]--;
            return true;
        }
        return false;
    }
}
