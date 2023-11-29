package one.two.three.util;

import one.two.three.util.enumUtil.DecimalEnum;

public class Converter {

    public static String toHex(int number, DecimalEnum decimalEnum, boolean prefix) {
        if (number == 0)
            return "0";

        int remainder;
        StringBuilder res = new StringBuilder();
        String tokens = decimalEnum.getTokens();
        int num = decimalEnum.getNum();
        while (number > 0) {
            remainder = number % num;
            res.insert(0, tokens.charAt(remainder));
            number /= num;
        }

        if (prefix)
            res.insert(0, decimalEnum.getPrefix());

        return res.toString();
    }

    public static void main(String[] args) {
        int hex = 17;
        System.out.println(toHex(hex, DecimalEnum.Hexadecimal, false));
        System.out.println(Integer.toHexString(hex));

        System.out.println(toHex(hex, DecimalEnum.Octal, false));
        System.out.println(Integer.toOctalString(hex));

        System.out.println(toHex(hex, DecimalEnum.Binary, false));
        System.out.println(Integer.toBinaryString(hex));
    }

}
