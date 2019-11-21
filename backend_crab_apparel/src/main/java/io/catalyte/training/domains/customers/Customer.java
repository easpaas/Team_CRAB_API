package io.catalyte.training.domains.customers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotNull
    @Pattern(regexp = "^CUSTOMER$")
    private String role;
    @NotNull(message = "Customer First Name must be filled out")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String firstName;
    @NotNull(message = "Customer Last Name must be filled out")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String lastName;
    @NotNull(message = "Customer Email must be filled out")
    @Email
    private String email;
    @NotNull(message = "Customer Password must be filled out")
    private String password;
    @NotNull(message = "Customer Phone Number must be filled out")
    @Pattern(regexp = "^[\\\\(]{0,1}([0-9]){3}[\\\\)]{0,1}[ ]?([^0-1]){1}([0-9]){2}[ ]?[-]?[ ]?([0-9]){4}[ ]*((x){0,1}([0-9]){1,5}){0,1}$")
    private String phoneNumber;
    private String street;
    private String city;
    @Pattern(regexp = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$")
    private String state;
    @Pattern(regexp = "(^(?!0{5})(\\d{5})(?!-?0{4})(-?\\d{4})?$)")
    private String zipCode;
    private String country;
    @Pattern(regexp ="^(?:(4[0-9]{12}(?:[0-9]{3})?)|(5[1-5][0-9]{14})|↵\n" +
            "(6(?:011|5[0-9][0-9])[0-9]{12})|(3[47][0-9]{13})|↵\n" +
            "(3(?:0[0-5]|[68][0-9])[0-9]{11})|((?:2131|1800|35\\d{3})\\d{11}))$")
    private String cardNumber;
    @Pattern(regexp = "^((0[1-9])|(1[0-2]))\\/(\\d{2})$")
    private String expiration;
    @Pattern(regexp = "^[0-9]{3,4}$")
    private String CVV;

    public Customer() {
    }

    public Customer(@NotNull @Pattern(regexp = "^CUSTOMER$") String role ,
                    @NotNull(message = "Customer First Name must be filled out") @Pattern(regexp = "^[a-zA-Z]*$") String firstName,
                    @NotNull(message = "Customer Last Name must be filled out") @Pattern(regexp = "^[a-zA-Z]*$") String lastName,
                    @NotNull(message = "Customer Email must be filled out") @Email String email,
                    @NotNull(message = "Customer Password must be filled out") String password,
                    @NotNull(message = "Customer Phone Number must be filled out") @Pattern(regexp = "^[\\\\(]{0,1}([0-9]){3}[\\\\)]{0,1}[ ]?([^0-1]){1}([0-9]){2}[ ]?[-]?[ ]?([0-9]){4}[ ]*((x){0,1}([0-9]){1,5}){0,1}$") String phoneNumber,
                    String street,
                    String city,
                    @Pattern(regexp = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$") String state,
                    @Pattern(regexp = "(^(?!0{5})(\\d{5})(?!-?0{4})(-?\\d{4})?$)") String zipCode,
                    String country,
                    @Pattern(regexp = "^(?:(4[0-9]{12}(?:[0-9]{3})?)|(5[1-5][0-9]{14})|↵\n" + "(6(?:011|5[0-9][0-9])[0-9]{12})|(3[47][0-9]{13})|↵\n" + "(3(?:0[0-5]|[68][0-9])[0-9]{11})|((?:2131|1800|35\\d{3})\\d{11}))$") String cardNumber,
                    @Pattern(regexp = "^((0[1-9])|(1[0-2]))\\/(\\d{2})$") String expiration,
                    @Pattern(regexp = "^[0-9]{3,4}$") String CVV) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.CVV = CVV;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getRoles() {
        return role;
    }

    public void setRoles(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiration='" + expiration + '\'' +
                ", CVV='" + CVV + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(role, customer.role) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(state, customer.state) &&
                Objects.equals(zipCode, customer.zipCode) &&
                Objects.equals(country, customer.country) &&
                Objects.equals(cardNumber, customer.cardNumber) &&
                Objects.equals(expiration, customer.expiration) &&
                Objects.equals(CVV, customer.CVV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, role, firstName, lastName, email, password, phoneNumber, street, city, state, zipCode, country, cardNumber, expiration, CVV);
    }
}
