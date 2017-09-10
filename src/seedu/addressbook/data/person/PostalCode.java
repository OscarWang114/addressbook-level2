package seedu.addressbook.data.person;

public class PostalCode {

    public static final String POSTAL_CODE_VALIDATION_REGEX = "^\\d{6}";

    public final String value;

    public PostalCode(String postalcode){
        this.value = postalcode;
    }

    public String getValue() {
        return this.value;
    }
}
