package giaidethithu;

import java.util.Scanner;

public class LenhMua extends GiaoDich{
	private int soluongMua;
	public LenhMua(String maSo, String ngayThucHien,int soluongMua) {
		super(maSo,ngayThucHien);
		this.soluongMua = soluongMua;
	}
	@Override
	public boolean isLenhBan() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isLenhMua() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isChuyenNhuong() {
		// TODO Auto-generated method stub
		return false;
	}
	public static GiaoDich create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ID lenh mua : ");
		String id = scanner.nextLine();
		System.out.println("Nhap ngay thuc hien : ");
		String date = scanner.nextLine();
		System.out.println("Nhap so luong mua : ");
		int nums = scanner.nextInt();
		return new LenhMua(id, date, nums);
	}
}
