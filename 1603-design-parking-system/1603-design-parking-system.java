class ParkingSystem {

    int big = 0;
    int medium = 0;
    int small = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        // 1. 대형, 중형, 소형은 각각 1, 2, 3으로 표시된다.
        if (carType == 1) {
            // 2. 이때, 객체 생성시 각 종류에 따른 슬롯이 남아있는지에 대해 boolean 값을 반환
            if (this.big > 0) {
                // 3. 남아있다면, 슬롯을 하나 사용하고 반환
                this.big -= 1;

                return true;
            }
        } else if (carType == 2) {
            if (this.medium > 0) {
                this.medium -= 1;

                return true;
            }
        } else {
            if (this.small > 0) {
                this.small -= 1;

                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */