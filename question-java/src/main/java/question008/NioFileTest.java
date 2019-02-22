package question008;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.NonWritableChannelException;
import java.util.concurrent.atomic.AtomicInteger;

public class NioFileTest {
	
	public static void main(String[] args) {
		ioFile();
//		nioFile();
	}
	
	public static void ioFile() {
		RandomAccessFile file = null;
		FileChannel channel = null;
		try {
			file = new RandomAccessFile("e:/@test/test2.zip", "rw");
			channel  = file.getChannel();
			long timestart = System.currentTimeMillis();
			ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
			buffer.clear();
			channel.read(buffer);
			long timeend = System.currentTimeMillis();
			System.out.println("time cost:" + (timeend-timestart));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (channel != null) {
					channel.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void nioFile() {
		RandomAccessFile file = null;
		FileChannel channel = null;
		try {
			file = new RandomAccessFile("e:/@test/test2.zip", "rw");
			channel = file.getChannel();
			long starttime = System.currentTimeMillis();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, file.length());
			buffer.clear();
			channel.read(buffer);
			long endtime = System.currentTimeMillis();
			System.out.println("time cost:" + (endtime-starttime));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (channel != null) {
					channel.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
