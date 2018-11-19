package hello;

public class ImageData {
	byte[] idata;

	public byte[] getIdata() {
		return idata;
	}

	public void setIdata(byte[] idata) {
		this.idata = idata;
	}

	public ImageData(byte[] m) {
		idata = m;
	}

	public int getSize() {
		return idata.length;
	}

}
