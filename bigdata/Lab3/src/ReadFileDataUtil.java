import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadFileDataUtil {

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static int readFile(String path, CustFunction tr,
			String initialComp, String endVal, String oper, boolean type)
			throws IOException {
		File file = new File(path);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int counter = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		while ((line = br.readLine()) != null) {
			String[] torken = line.split(" ");
			for (int i = 0; i < torken.length; i++) {
				String temp =tr.apply(initialComp, torken[i], endVal, oper).toString();
				int temp1=initialComp.compareToIgnoreCase(torken[i]);
				int temp2=torken[i].compareToIgnoreCase(endVal);
				if (tr.apply(initialComp, torken[i], endVal, oper).equals(1)) {
					counter++;
					if (map.containsKey(torken[i])) {
						map.put(torken[i], map.get(torken[i]) + 1);
					} else {
						map.put(torken[i], 1);
					}

				}
			}

		}
		br.close();
		fr.close();
		if (type) {
			return counter;
		} else {
			return map.size();
		}
	}
}
