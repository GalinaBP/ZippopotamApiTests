package ApiTests;

import org.testng.annotations.DataProvider;

public class Parameterized {
    @DataProvider
    public static Object [][] zipCodesAndPlaces() {
        return new Object[][] {
                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley" }

        };
    }
}
