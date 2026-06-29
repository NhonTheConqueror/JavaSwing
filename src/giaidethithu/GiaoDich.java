package giaidethithu;

public abstract class GiaoDich {
	protected String maSo;
	protected String ngayThucHien;
	
	public GiaoDich() {}
	
	public GiaoDich(String maSo, String ngayThucHien) {
		super();
		this.maSo = maSo;
		this.ngayThucHien = ngayThucHien;
	}

	public abstract boolean isLenhBan();
	public abstract boolean isLenhMua();
	public abstract boolean isChuyenNhuong();
	
	
}
