
import java.util.Scanner;

public class CapDo2
{
    // Bai 1: Tinh thue thu nhap theo tung bac
    // Don vi thu nhap va thue: trieu dong
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

            double thuNhapBac = Math.min(
                    thuNhap, moc[i]
            ) - mocTruoc;

            thue += thuNhapBac * thueSuat[i];
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

    // Bai 3: Xoa ky tu trung lap
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bai 1: Tinh thue");
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

        System.out.println("Bai 2:");
        System.out.println(ktraChuoiDoiXung("madam"));
        System.out.println(ktraChuoiDoiXung("hello"));

        System.out.println("Bai 3:");
        System.out.println(xoaKyTuLap("programming"));
        System.out.println(xoaKyTuLap("abca"));

        sc.close();
    }
}
