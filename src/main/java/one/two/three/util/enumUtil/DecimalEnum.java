package one.two.three.util.enumUtil;

public enum DecimalEnum {

    Binary("0b", 2, "01"),
    Octal("0o", 8, "01234567"),
    Hexadecimal("0x", 16, "0123456789ABCDEF");

    final String prefix;


    final int num;

    final String tokens;

    public String getPrefix() {
        return prefix;
    }

    public int getNum() {
        return num;
    }


    public String getTokens() {
        return tokens;
    }

    DecimalEnum(String prefix, int num, String tokens) {
        this.prefix = prefix;
        this.num = num;
        this.tokens = tokens;
    }
}
