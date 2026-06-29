package giaidethithu;

import java.util.ArrayList;
import java.util.Scanner;



public class TaiKhoanChungKhoan{
	private String soTK, chuTK;
	private double soTienDu;
	private double soluongCP;
	private ArrayList<GiaoDich> danhsachGD;

	public TaiKhoanChungKhoan(String soTK, String chuTK, double soTienDu, double soluongCP,
			ArrayList<GiaoDich> danhsachGD) {
		this.soTK = soTK;
		this.chuTK = chuTK;
		this.soTienDu = soTienDu;
		this.soluongCP = soluongCP;
		this.danhsachGD = danhsachGD;
	}
	
	public void add(GiaoDich x) {
		danhsachGD.add(x);
	}
	
	public void autoAdd(int n) {
		Scanner scanner = new Scanner(System.in);
		while(n!=0) {
			System.out.print("Loai Giao dich (1,2,3): ");
			GiaoDich temp = taoGiaoDich(scanner.nextInt());
			danhsachGD.add(temp);
			n--;
		}
	}
	
	public GiaoDich taoGiaoDich(int type) {
		switch (type) {
		case 1: {return LenhBan.create();}
		case 2:{return LenhMua.create();}
		default: {return LenhChuyenNhuong.create();}
		}
	}
	
	public int countLenhBan() {
		int ans = 0;
		for(GiaoDich a: this.danhsachGD) {
			if(a.isLenhBan()) {ans++;}
		}
		return ans;
	}
	
	public boolean contain2DiffType() {
		int a = 0;
		int b = 0;
		int c = 0;
		for(GiaoDich x: danhsachGD) {
			if(x.isLenhBan()) {a++;}
			else if(x.isChuyenNhuong()) {c++;}
			else {b++;}
		}
		return (a*b>0 || a*c>0 || b*c>0);
		
	}
	
	public static void main(String[] args) {
		// tao 1 tai khoan chung khoan, tao danh sach giao dich co 5 giao dich ngau nhien
		TaiKhoanChungKhoan tk = new TaiKhoanChungKhoan("123456", "Nguyen Van A", 10000000, 1000, new ArrayList<>());
		tk.add(LenhBan.create());
		tk.add(LenhBan.create());
		System.out.println("So lenh ban: " + tk.countLenhBan());
		System.out.println("Co chua 2 loai giao dich khac nhau: " + tk.contain2DiffType());
	}
	
}
