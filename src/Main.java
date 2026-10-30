
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    // Bai 1: Xoa nguyen am trong chuoi
    public static String xoaNguyenAm(String s) {
        String ketQua = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char cThuong = Character.toLowerCase(c);

            if (cThuong != 'a' && cThuong != 'e' &&
                    cThuong != 'i' && cThuong != 'o' &&
                    cThuong != 'u') {
                ketQua += c;
            }
        }

        return ketQua;
    }

    // Bai 2: Tim gia tri lon thu hai phan biet
    public static int timSoLonThuHai(int[] a) {
        if (a == null || a.length < 2) {
            return Integer.MIN_VALUE;
        }

        int lonNhat = Integer.MIN_VALUE;
        int lonThuHai = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > lonNhat) {
                lonThuHai = lonNhat;
                lonNhat = a[i];
            } else if (a[i] < lonNhat &&
                    a[i] > lonThuHai) {
                lonThuHai = a[i];
            }
        }

        return lonThuHai;
    }

    // Bai 3: Tinh tong cac so chan tu 0 den n
    public static int tinhTongSoChan(int n) {
        int tong = 0;

        for (int i = 0; i <= n; i += 2) {
            tong += i;
        }

        return tong;
    }

    // Bai 4: Dem so tu trong chuoi
    public static int demSoTu(String s) {
        int dem = 0;
        boolean trongTu = false;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                if (!trongTu) {
                    dem++;
                    trongTu = true;
                }
            } else {
                trongTu = false;
            }
        }

        return dem;
    }

    // Bai 5: Lay chu cai dau moi tu
    public static String layChuCaiDau(String s) {
        String ketQua = "";
        boolean dauTu = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) {
                dauTu = true;
            } else if (dauTu) {
                if (!ketQua.isEmpty()) {
                    ketQua += " ";
                }

                ketQua += Character.toUpperCase(c);
                dauTu = false;
            }
        }

        return ketQua;
    }

    // Bai 1: Tinh thue thu nhap theo tung bac

    public static double tinhThueThuNhap(double thuNhap) {
        if (thuNhap < 0) {
            throw new IllegalArgumentException(
                    "Thu nhap khong duoc am"
            );
        }

        double[] moc = {5, 10, 18, 32, 52, 80};
        double[] thueSuat = {
                0.05, 0.10, 0.15, 0.20,
                0.25, 0.30, 0.35
        };

        double thue = 0;
        double mocTruoc = 0;

        for (int i = 0; i < moc.length; i++) {
            if (thuNhap <= mocTruoc) {
                return thue;
            }

            double phanThuNhap =
                    Math.min(thuNhap, moc[i]) - mocTruoc;

            thue += phanThuNhap * thueSuat[i];
            mocTruoc = moc[i];
        }

        if (thuNhap > 80) {
            thue += (thuNhap - 80) * 0.35;
        }

        return thue;
    }

    // Bai 2: Kiem tra chuoi doi xung
    public static boolean ktraChuoiDoiXung(String s) {
        int trai = 0;
        int phai = s.length() - 1;

        while (trai < phai) {
            if (s.charAt(trai) != s.charAt(phai)) {
                return false;
            }

            trai++;
            phai--;
        }

        return true;
    }

    // Bai 3: Xoa ky tu trung lap trong chuoi
    public static String xoaKyTuLap(String s) {
        String ketQua = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean daTonTai = false;

            for (int j = 0; j < ketQua.length(); j++) {
                if (c == ketQua.charAt(j)) {
                    daTonTai = true;
                    break;
                }
            }

            if (!daTonTai) {
                ketQua += c;
            }
        }

        return ketQua;
    }
    // Bai 1: Two Sum II
    public static int[] timHaiSoCoTong(int[] a, int target) {
        int trai = 0;
        int phai = a.length - 1;

        while (trai < phai) {
            long tong = (long) a[trai] + a[phai];

            if (tong == target) {
                return new int[]{trai + 1, phai + 1};
            } else if (tong < target) {
                trai++;
            } else {
                phai--;
            }
        }

        return new int[]{-1, -1};
    }

    // Bai 2: Longest Palindromic Substring
    public static String timChuoiDoiXungDaiNhat(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int batDau = 0;
        int doDaiMax = 1;

        for (int i = 0; i < s.length(); i++) {

            // Xet chuoi doi xung do dai le
            int trai = i;
            int phai = i;

            while (trai >= 0 && phai < s.length()
                    && s.charAt(trai) == s.charAt(phai)) {

                int doDai = phai - trai + 1;

                if (doDai > doDaiMax) {
                    batDau = trai;
                    doDaiMax = doDai;
                }

                trai--;
                phai++;
            }

            // Xet chuoi doi xung do dai chan
            trai = i;
            phai = i + 1;

            while (trai >= 0 && phai < s.length()
                    && s.charAt(trai) == s.charAt(phai)) {

                int doDai = phai - trai + 1;

                if (doDai > doDaiMax) {
                    batDau = trai;
                    doDaiMax = doDai;
                }

                trai--;
                phai++;
            }
        }

        return s.substring(batDau, batDau + doDaiMax);
    }

    // Bai 3: Minimum Window Substring
    public static String timChuoiConNhoNhat(String s, String t) {
        if (s == null || t == null ||
                s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> can = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            can.put(c, can.getOrDefault(c, 0) + 1);
        }

        int conThieu = t.length();
        int trai = 0;
        int batDau = 0;
        int doDaiMin = Integer.MAX_VALUE;

        for (int phai = 0; phai < s.length(); phai++) {
            char c = s.charAt(phai);

            int soLuong = can.getOrDefault(c, 0);

            if (soLuong > 0) {
                conThieu--;
            }

            can.put(c, soLuong - 1);

            while (conThieu == 0) {
                int doDai = phai - trai + 1;

                if (doDai < doDaiMin) {
                    doDaiMin = doDai;
                    batDau = trai;
                }

                char cTrai = s.charAt(trai);
                int soLuongMoi = can.get(cTrai) + 1;
                can.put(cTrai, soLuongMoi);

                if (soLuongMoi > 0) {
                    conThieu++;
                }

                trai++;
            }
        }

        if (doDaiMin == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(batDau, batDau + doDaiMin);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CAP DO 1 SAO =====");

        System.out.println("Bai 1: Xoa nguyen am");
        System.out.println(xoaNguyenAm("Cybersoft"));
        System.out.println(xoaNguyenAm("hello"));

        System.out.println("Bai 2: So lon thu hai");
        int[] a = {1, 3, 4, 5, 0, 2};
        int[] b = {10, 5, 10};
        int[] c = {3};

        System.out.println(timSoLonThuHai(a));
        System.out.println(timSoLonThuHai(b));
        System.out.println(timSoLonThuHai(c));

        System.out.println("Bai 3: Tong so chan");
        System.out.println(tinhTongSoChan(10));
        System.out.println(tinhTongSoChan(5));

        System.out.println("Bai 4: Dem so tu");
        System.out.println(demSoTu("Xin chào các bạn"));
        System.out.println(demSoTu("Hello World"));

        System.out.println("Bai 5: Chu cai dau");
        System.out.println(layChuCaiDau("Xin chào các bạn"));
        System.out.println(layChuCaiDau("Hello World"));

        System.out.println("\n===== CAP DO 2 SAO =====");

        System.out.println("Bai 1: Tinh thue thu nhap");
        System.out.print("Nhap thu nhap (trieu dong): ");

        double thuNhap = sc.nextDouble();

        if (thuNhap < 0) {
            System.out.println("Thu nhap khong hop le");
        } else {
            System.out.printf(
                    "Thue phai tra: %.2f trieu dong%n",
                    tinhThueThuNhap(thuNhap)
            );
        }

        System.out.println("Bai 2: Chuoi doi xung");
        System.out.println(ktraChuoiDoiXung("madam"));
        System.out.println(ktraChuoiDoiXung("hello"));

        System.out.println("Bai 3: Xoa ky tu lap");
        System.out.println(xoaKyTuLap("programming"));
        System.out.println(xoaKyTuLap("abca"));

        System.out.println("\n===== CAP DO 3 SAO =====");

        System.out.println("Bai 1: Two Sum II");
        int[] numbers = {2, 7, 11, 15};

        System.out.println(
                Arrays.toString(timHaiSoCoTong(numbers, 9))
        );

        System.out.println(
                "Bai 2: Longest Palindromic Substring"
        );
        System.out.println(
                timChuoiDoiXungDaiNhat("babad")
        );

        System.out.println(
                "Bai 3: Minimum Window Substring"
        );
        System.out.println(
                timChuoiConNhoNhat("ADOBECODEBANC", "ABC")
        );

        sc.close();
    }
}
