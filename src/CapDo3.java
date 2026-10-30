
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CapDo3
{
    // Bai 1: Two Sum II - mang da sap xep
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
            // Chuoi doi xung co do dai le
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

            // Chuoi doi xung co do dai chan
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
        System.out.println("Bai 1:");
        int[] numbers = {2, 7, 11, 15};
        System.out.println(
                Arrays.toString(timHaiSoCoTong(numbers, 9))
        );

        System.out.println("Bai 2:");
        System.out.println(
                timChuoiDoiXungDaiNhat("babad")
        );

        System.out.println("Bai 3:");
        System.out.println(
                timChuoiConNhoNhat("ADOBECODEBANC", "ABC")
        );
    }
}
