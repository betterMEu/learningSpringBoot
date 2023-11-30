package one.two.three;

public class Test {

    public static void main(String[] args) {

        int UNIX_LINES = 0x01;
        System.out.println(UNIX_LINES);

        int CASE_INSENSITIVE = 0x02;
        System.out.println(CASE_INSENSITIVE);

        int COMMENTS = 0x04;
        System.out.println(COMMENTS);

        int MULTILINE = 0x08;
        System.out.println(MULTILINE);

        int LITERAL = 0x10;
        System.out.println(LITERAL);

        int DOTALL = 0x20;
        System.out.println(DOTALL);

        int UNICODE_CASE = 0x40;
        System.out.println(UNICODE_CASE);

        int CANON_EQ = 0x80;
        System.out.println(CANON_EQ);

        int UNICODE_CHARACTER_CLASS = 0x100;
        System.out.println(UNICODE_CHARACTER_CLASS);

        int ALL_FLAGS = CASE_INSENSITIVE | MULTILINE |
                DOTALL | UNICODE_CASE | CANON_EQ | UNIX_LINES | LITERAL |
                UNICODE_CHARACTER_CLASS | COMMENTS;

        System.out.println(ALL_FLAGS);
    }
}