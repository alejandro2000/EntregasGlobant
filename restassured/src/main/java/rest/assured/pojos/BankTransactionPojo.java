package rest.assured.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * class to create the main pojo.
 *
 * @author Alejandro Taborda Cadavid
 */
public class BankTransactionPojo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("TransactionType")
    @Expose
    private String transactionType;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Active")
    @Expose
    private Boolean active;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Telephone")
    @Expose
    private String telephone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "BankTransactionPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", country='" + country + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
