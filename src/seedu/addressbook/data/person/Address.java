package seedu.addressbook.data.person;


import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person addresses should follow the format 'BLOCK, STREET, UNIT, POSTAL_CODE'";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    public static final String ADDRESS_SPLIT_REGEX=",";
    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTAL_INDEX = 3;

    public final String value;
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] splitAddress = trimmedAddress.split(ADDRESS_SPLIT_REGEX);
        this.block = new Block(splitAddress[BLOCK_INDEX].trim());
        this.street = new Street(splitAddress[STREET_INDEX].trim());
        this.unit = new Unit(splitAddress[UNIT_INDEX].trim());
        this.postalCode = new PostalCode(splitAddress[POSTAL_INDEX].trim());

        this.value = this.block.getValue() + ADDRESS_SPLIT_REGEX + " "
                + this.street.getValue() + ADDRESS_SPLIT_REGEX + " "
                + this.unit.getValue() + ADDRESS_SPLIT_REGEX + " "
                + this.postalCode.getValue();

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
