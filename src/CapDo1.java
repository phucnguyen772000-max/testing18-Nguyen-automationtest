
public class CapDo1
{ // Bai 1: Xoa nguyen am trong chuoi
    public static String xoaNguyenAm(String s) {
        String ketQua = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != 'a' && c != 'e' &&
                    c != 'i' && c != 'o' &&
                    c != 'u' && c != 'A' &&
                    c != 'E' && c != 'I' &&
                    c != 'O' && c != 'U') {

                ketQua += c;
            }
        }

        return ketQua;
    }

    public static void main(String[] args) {
        System.out.println(xoaNguyenAm("Cybersoft"));
        System.out.println(xoaNguyenAm("hello"));
    }
}
