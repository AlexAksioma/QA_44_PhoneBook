package tests;

import dto.ContactDtoLombok;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RandomUtils.*;
import static utils.RandomUtils.generateString;

public class EditContactsTests extends ApplicationManager {

    UserDto user = new UserDto("qa_mail@mail.com", "Qwerty123!");
    ContactPage contactPage;

    @BeforeMethod
    public void login() {
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        contactPage = loginPage.typeLoginForm(user).clickBtnLoginPositive();
    }

    @Test
    public void editContactPositiveTest(){
        ContactDtoLombok newContact = ContactDtoLombok.builder()
                .name("new-"+generateString(5))
                .lastName("new-"+generateString(10))
                .phone("000"+generatePhone(7))
                .email("new-"+generateEmail(12))
                .address("new-"+generateString(20))
                .description("new-"+generateString(10))
                .build();
        contactPage.clickFirstElementOfContactsList();
        contactPage.fillEditForm(newContact);
        contactPage.clickBtnSaveContact();
        ContactDtoLombok contact = contactPage.getContactFromDetailedCard();
    }
}
