package day01;

public class RocketEquation {

    public static void main(String[] args) {
//        int[] ints = {12, 14, 1969, 100756};
        int[] ints = {93129, 111125, 77024, 65507, 61045, 131569, 139270, 124313, 53144, 144718, 58125, 66535, 62637, 87439, 87522, 96145,
                96336, 104386, 112966, 70987, 56103, 90244, 81316, 99630, 120150, 60287, 142597, 55786, 87751, 84473, 116447, 110360,
                64172, 100324, 146574, 109091, 89219, 147775, 133309, 92298, 107849, 109079, 80327, 149330, 57857, 54523, 70676, 74738,
                103435, 82406, 108528, 85974, 78132, 143283, 55868, 127473, 52759, 74341, 132410, 116466, 107343, 61847, 77448, 138823,
                138447, 146540, 134294, 124951, 58788, 88585, 72256, 86398, 62902, 92070, 113591, 72733, 116019, 132097, 59848, 78899,
                131667, 135218, 85063, 147862, 102936, 92492, 74320, 138712, 141699, 66850, 72380, 71793, 116187, 127101, 75980, 89708, 99640, 60915, 57840, 144763};
        int sum = 0;
        for (int mass : ints) {
//            int fuel = fuelRequired(mass);
            int fuel = allFuelRequired(mass);
            sum += fuel;
            System.out.println("Mass " + mass + " requires " + fuel + " units of fuel.");
        }
        System.out.println("Total fuel required: " + sum);
    }

    public static int allFuelRequired(int mass) {
        int fuel = fuelRequired(mass);
        int totalFuel = fuel;

        while (fuel > 0) {
            fuel = fuelRequired(fuel);
            totalFuel += fuel;
        }
        return totalFuel;
    }

    //  Mass / 3, rounded down. Subtract two.
    public static int fuelRequired(int mass) {
        double massD = (double) mass;
        massD /= 3;
        massD = Math.floor(massD);
        massD -= 2;
        if(massD < 0){
            return 0;
        }
        return (int) massD;
    }
}
