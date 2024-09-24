package data_provider;

import dto.ContactDtoLombok;
import org.testng.annotations.DataProvider;

import static utils.RandomUtils.generatePhone;
import static utils.RandomUtils.generateString;

public class DPAddContact {

    @DataProvider
    public ContactDtoLombok[] addNewContactDP(){
        ContactDtoLombok contact1 = ContactDtoLombok.builder()
                .name(generateString(4))
                .lastName(generateString(10))
                .phone(generatePhone(10))
                .email("qwertymail.com")
                .address(generateString(20))
                .description(generateString(10))
                .build();
        ContactDtoLombok contact2 = ContactDtoLombok.builder()
                .name(generateString(4))
                .lastName(generateString(10))
                .phone(generatePhone(10))
                .email("qwerty@mailcom")
                .address(generateString(20))
                .description(generateString(10))
                .build();
        return new ContactDtoLombok[]{contact1, contact2};
    }
}
