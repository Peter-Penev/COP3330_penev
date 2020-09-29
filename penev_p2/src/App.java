import java.util.*;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        BodyMassIndex.displayBmiStatistics(bmiData);
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        BodyMassIndex.displayBmiInfo(bmi);
    }

    private static double getUserWeight() {
        return BodyMassIndex.getUserWeight();
    }

    private static double getUserHeight() {
        return BodyMassIndex.getUserHeight();
    }

    private static boolean moreInput() {
        return BodyMassIndex.moreInput();
    }
}
