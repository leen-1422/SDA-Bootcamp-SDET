package tests.Assignments.Assignment2;

/*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */

import org.testng.annotations.Test;
import tests.junit.TestBase;
import tests.testng.Tests;

public class Assignment2 extends Tests {
    @Test
    public void exelPrvider(){
   driver.navigate().to("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

    }

}
