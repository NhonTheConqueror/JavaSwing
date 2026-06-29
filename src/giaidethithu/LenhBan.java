package giaidethithu;

import java.util.Scanner;

public class LenhBan extends GiaoDich{
	private int soluongBan;

	public LenhBan(String maSo, String ngayThucHien,int soluongBan) {
		super(maSo,ngayThucHien);
		this.soluongBan = soluongBan;
	}

	@Override
	public boolean isLenhBan() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isLenhMua() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChuyenNhuong() {
		// TODO Auto-generated method stub
		return false;
	}

	public static GiaoDich create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ID lenh ban : ");
		String id = scanner.nextLine();
		System.out.println("Nhap ngay thuc hien : ");
		String date = scanner.nextLine();
		System.out.println("Nhap so luong ban : ");
		int nums = scanner.nextInt();
		return new LenhBan(id, date, nums);
	}
	
	
	
}
