package hello;



/**
 * Created by 敦 on 2018/08/01.
 */

public class CameraImage {
    String fileName;
    byte[] data;

        public CameraImage() {
            super();
        }

        public CameraImage(String fileName, byte[] data) {
            super();
            this.fileName = fileName;
            this.data = data;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

		public int getSize() {
			// TODO 自動生成されたメソッド・スタブ
			return data.length;
		}

}

