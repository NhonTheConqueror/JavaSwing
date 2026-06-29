package giaidethithu;

import java.util.Scanner;

public class LenhChuyenNhuong extends GiaoDich{
	private String soTKNhan;
	private int soluongChuyen;
	
	public LenhChuyenNhuong(String maSo, String ngayThucHien,String soTKNhan, int soluongChuyen) {
		super(maSo,ngayThucHien);
		this.soTKNhan = soTKNhan;
		this.soluongChuyen = soluongChuyen;
	}

	@Override
	public boolean isLenhBan() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLenhMua() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChuyenNhuong() {
		// TODO Auto-generated method stub
		return true;
	}

	public static GiaoDich create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ID lenh chuyen nhuong : ");
		String id = scanner.nextLine();
		System.out.println("Nhap ngay thuc hien : ");
		String date = scanner.nextLine();
		System.out.println("Nhap so tai khoan nhan : ");
		String cid = scanner.nextLine();
		System.out.println("Nhap so luong chuyen : ");
		int nums = scanner.nextInt();
		return new LenhChuyenNhuong(id, date, cid,nums);
	}
}
