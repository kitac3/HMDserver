package hello;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class AndroidServerControler {


	@RequestMapping("/CameraImage/{fileName}")
	@ResponseBody
	public void chatWebPut(@RequestBody byte[] m,@PathVariable String fileName) {
		CameraImage ci=new CameraImage();
		ci.setData(m);
		ci.setFileName(fileName);
		File f=new File("/tmp/image.jpg");
		try {
			BufferedOutputStream os= new BufferedOutputStream(new FileOutputStream(f));
			try{
			os.write(ci.getData());
				os.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		System.out.println("ImageData recived "+ci.getFileName()+":size="+ci.getSize());
	}
}