package ltpTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.hit.ir.ltp4j.Segmentor;

public class TestSegment {
	private static String filterBOM(String content) {
		if ("".equals(content) || null == content) {
			return content;
		}
		byte[] bytes = content.getBytes();
		return new String(bytes, 3, bytes.length - 3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Segmentor.class);
		if (Segmentor.create("ltp_data/cws.model") < 0) {
			System.err.println("load failed");
			return;
		}

		//String content = null;
		/*try {
			@SuppressWarnings("resource")
			BOMInputStream bomWithOut = new BOMInputStream(new FileInputStream(new File("C:/Users/TKPad/Desktop/test.txt")));
			BOMInputStream bomWithOut = new BOMInputStream(new FileInputStream(new File("C:/Users/Administrator/Desktop/cxx.txt")));
			content = FileUtils.readFileToString(new File("C:/Users/Administrator/Desktop/cxx.txt"), "UTF-8");
			if (bomWithOut.hasBOM()) {
				// ����Bom
				content = filterBOM(content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		 String content = "华中科技大学";
		List<String> words = new ArrayList<String>();
		int size = Segmentor.segment(content, words);//�ִʽ��
		for (int i = 0; i < size; i++) {
			System.out.println(i + "->" + words.get(i).trim());
			if (i == size - 1) {
				System.out.println();
			} else {
				System.out.print("\n");
			}
		}
		Segmentor.release();
	}
	

}
