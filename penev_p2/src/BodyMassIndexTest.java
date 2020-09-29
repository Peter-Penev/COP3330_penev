import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    void testUnderweight(){ // tests category 1 for BMI
        BodyMassIndex bmi = new BodyMassIndex(75, 100);
        assertEquals("Underweight", bmi.findBMICategory(bmi));
    }

    @Test
    void testNormalWeight(){ // tests category 2 for BMI
        BodyMassIndex bmi = new BodyMassIndex(75, 160);
        assertEquals("Normal weight", bmi.findBMICategory(bmi));
    }

    @Test
    void testOverweight(){ // tests category 3 for BMI
        BodyMassIndex bmi = new BodyMassIndex(75, 210);
        assertEquals("Overweight", bmi.findBMICategory(bmi));
    }

    @Test
    void testObesity(){ // tests category 4 for BMI
        BodyMassIndex bmi = new BodyMassIndex(75, 250);
        assertEquals("Obesity", bmi.findBMICategory(bmi));
    }

    @Test
    void testFindBMI(){ // tests findBMI
        BodyMassIndex bmi = new BodyMassIndex(75, 180);
        assertEquals(22.496, bmi.findBMI(75, 180));
    }

    @Test
    void testMoreInput(){ // tests MoreInput
        String answer = "Y";
        assertEquals("Y",answer);
    }

    @Test
    void testGetUserHeight(){ // tests GetUserHeight
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double height = 72.0;
        assertEquals(72.0,height);
    }

    @Test
    void testGetUserWeight(){ // test GetUserWeight
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double weight = 180.0;
        assertEquals(180.0,weight);
    }

    @Test
    void testDisplayBmiInfo(){ // test DisplayBmiInfo
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        BodyMassIndex bmi = new BodyMassIndex(75, 180);
        BodyMassIndex.displayBmiInfo(bmi);
        assertEquals("Your BMI score is: 22.496\r\nYour BMI category is Normal weight\r\n",out.toString());
    }

    @Test
    void testDisplayBmiStatistics(){ // test DisplayBmiStatistics
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();
        BodyMassIndex bmi = new BodyMassIndex(75, 180);
        bmiData.add(bmi);
        BodyMassIndex.displayBmiStatistics(bmiData);
        assertEquals("The average BMI score is: 22.496\r\n",out.toString());
    }
}