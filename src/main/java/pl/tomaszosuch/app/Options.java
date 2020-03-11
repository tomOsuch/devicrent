package pl.tomaszosuch.app;

public enum Options {
    ADD_DEVICE(1, "Dodaj urządzenie"),
    ADD_CATEGORY(2, "Dodaj kategorię"),
    ADD_CUSTOMER(3, "Dodaj klienta"),
    RENT(4, "Wypożycz urządzenie"),
    REMOVE_DEVICE(5, "Usuń urządzenie"),
    REMOVE_CATEGORY(6, "Usuń kategorię"),
    REMOVE_CUSTOMER(7, "Usuń klienta"),
    EXIT(8, "Koniec");

    private int number;
    private String name;

    Options(int number, String name) {
        this.number = number;
        this.name = name;
    }

    static Options numberToCategory(int number){
        if (number < 1 || number > values().length)
            throw new InvalidOptionException();
        return values()[number-1];
    }
}
