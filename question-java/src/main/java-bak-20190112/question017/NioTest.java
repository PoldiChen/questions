package question017;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
	
	public static void main(String[] args) {
//		ioRead();
		nioRead();
	}
	
	public static void ioRead() {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("e:/@test/test.txt"));
			byte[] buffer = new byte[1024];
			int bytesRead = in.read(buffer);
			while (bytesRead != -1) {
				for (int i=0; i<bytesRead; i++) {
					System.out.println((char)buffer[i]);
				}
				bytesRead = in.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void nioRead() {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("e:/@test/test.txt", "rw");
			FileChannel fileChannel = file.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int bytesRead = fileChannel.read(buffer);
			while (bytesRead != -1) {
				buffer.flip();
				while (buffer.hasRemaining()) {
					System.out.println((char)buffer.get());
				}
				buffer.compact();
				bytesRead = fileChannel.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null) {
					file.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
