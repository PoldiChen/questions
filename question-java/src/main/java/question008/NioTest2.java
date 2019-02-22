package question008;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
	
	public static void main(String[] args) throws Exception {
		
		String readFile = "E:/@test/test.txt";
		String writeFile = "E:/@test/test-empty.txt";
		@SuppressWarnings("resource")
		FileChannel channelIn = new FileInputStream(readFile).getChannel();
		@SuppressWarnings("resource")
		FileChannel channelOut = new FileInputStream(writeFile).getChannel();
		
		channelIn.transferTo(0,  channelIn.size(), channelOut);
		
//		ByteBuffer buffer = ByteBuffer.allocate(1024);
//		while (true) {
//			buffer.clear();
//			if (channelIn.read(buffer) == -1) {
//				break;
//			}
//			buffer.flip();
//			channelOut.write(buffer);
//		}
		
		System.out.println("done");
		
	}

}
