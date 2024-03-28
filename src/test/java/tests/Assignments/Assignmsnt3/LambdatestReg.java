package tests.Assignments.Assignmsnt3;

import org.testng.annotations.Test;
import pages.lambdtest.Login;
import tests.testng.Tests;

public class LambdatestReg extends Tests {

    @Test
    public void passLogin(){
        new Login(driver , bot)
                .toGo()
                .login("Leen","Mohammed","leen@yyy.com","9667665758574","123456","123456");
    }
}
