package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static utils.RandomUtils.generateEmail;
import static utils.RandomUtils.generateString;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest(){
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm("my_qa_email@mail.com", "Password123_!")
                .clickBtnRegistrationPositive()
                .isElementContactPresent());
    }
    @Test
    public void registrationNegativeTest_wrongEmail(){
        String email = generateString(10);
        UserDto user = new UserDto(email, "Qwerty123!");
        new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnRegistrationNegative()
                .closeAlert()
                .isTextInElementPresent_errorMessage("Registration failed with code 400")
                ;
    }
}
