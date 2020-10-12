package rest.assured.utils;

import com.github.javafaker.Faker;
import rest.assured.pojos.BankTransactionPojo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * All the methods about asking for
 * a requirement of any data structure.
 *
 * @author Alejandro Taborda Cadavid
 */
public class DataValidation {

    public static BankTransactionPojo createBankObject() {
        Faker faker = new Faker();
        BankTransactionPojo bankTransactionPojo = new BankTransactionPojo();
        bankTransactionPojo.setName(faker.name().firstName());
        bankTransactionPojo.setLastName(faker.name().lastName());
        bankTransactionPojo.setAccountNumber(faker.finance().creditCard());
        bankTransactionPojo.setAmount(faker.finance().bic());
        bankTransactionPojo.setTransactionType(faker.business().creditCardType());
        bankTransactionPojo.setEmail(faker.internet().emailAddress());
        bankTransactionPojo.setActive(faker.bool().bool());
        bankTransactionPojo.setCountry(faker.address().country());
        bankTransactionPojo.setTelephone(String.valueOf(faker.number().randomNumber()));
        return bankTransactionPojo;
    }

    public static boolean isTheEmailTaken(String jsonResponse, String email) {
        return jsonResponse.contains(email);
    }

    public static void storeDataIntoPropertiesFile(String data) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.put("lastId", data);
        String path = "jiraIncrementalId.properties";
        FileOutputStream outputStrem = null;
        outputStrem = new FileOutputStream(path);
        props.store(outputStrem,"Information about Jira items");
    }
}
