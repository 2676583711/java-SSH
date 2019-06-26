package cn.zhou.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class ReadAndWrite {

	public static void main(String[] args) throws IOException {

		String path = "/media/zhou/新加卷/Program/Videos/JAVA/Maven/day02/07ssh整合功能案例实现.avi";

		Date date = new Date();
		long st = System.currentTimeMillis();

		InputStream is = new FileInputStream(path);

		FileOutputStream o = new FileOutputStream("/home/zhou/abc.mp4");

		byte[] b = new byte[10240];

		while (is.read(b) != -1) {

			o.write(b);
			o.flush();
		}

		long et = System.currentTimeMillis();
		System.out.println("the time is:" + (et / 10000 - st / 10000)); //12,

		is.close();
		o.close();

	}

}
