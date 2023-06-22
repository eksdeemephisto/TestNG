package class01;

import org.testng.annotations.*;

public class EnableDisable {
    @Test(enabled = false)
    public void ATest() {
        System.out.println("I am test A");
    }

    @Test
    public void BTest() {
        System.out.println("I am test B");
    }

    @Test(enabled = false)
    public void CTest() {
        System.out.println("I am test C");
    }
}
