import java.io.IOException;
import java.util.Comparator;

public class CountWord {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	//added comment
		try {
			Comparator<String> compReducer = (s1, s2) -> s1
					.compareToIgnoreCase(s2);

			CustFunction<String, String, String, String, Integer> biReducer = (
					s1, s2, s3, s4) -> {
				if (s4.equals("<"))
					if (s1.compareToIgnoreCase(s2) < 0)
						return 1;
					else
						return 0;
				else if (s4.equals(">"))
					if (s1.compareToIgnoreCase(s2) > 0)
						return 1;
					else
						return 0;
				else if (s4.equals("<>"))

					if (s1.compareToIgnoreCase(s2) > 0
							|| s2.compareToIgnoreCase(s3) > 0)
						return 1;
					else
						return 0;
				else if (s4.equals("="))
					if (s1.compareToIgnoreCase(s2) == 0)
						return 1;
					else
						return 0;
				else
					return 0;
			};

			int data1 = ReadFileDataUtil.readFile(
					"D:\\MUM_LAB\\BigData\\Lab\\Lab3\\src\\data1.txt",
					biReducer, "K", "", "<", true);
			int data11 = ReadFileDataUtil.readFile(
					"D:\\MUM_LAB\\BigData\\Lab\\Lab3\\src\\data1.txt",
					biReducer, "K", "", "<", false);
			int data2 = ReadFileDataUtil.readFile(
					"D:\\MUM_LAB\\BigData\\Lab\\Lab3\\src\\data2.txt",
					biReducer, "P", "", ">", true);
			int data22 = ReadFileDataUtil.readFile(
					"D:\\MUM_LAB\\BigData\\Lab\\Lab3\\src\\data2.txt",
					biReducer, "P", "", ">", false);
			int data3 = ReadFileDataUtil.readFile(
					"D:\\MUM_LAB\\BigData\\Lab\\Lab3\\src\\data3.txt",
					biReducer, "K", "P", "<>", true);
			int data33 = ReadFileDataUtil.readFile(
					"D:\\MUM_LAB\\BigData\\Lab\\Lab3\\src\\data3.txt",
					biReducer, "K", "P", "<>", false);

			System.out.print("\t\t Node 1 \t Node 2 \t Node 3 \n");
			System.out.println("No combiner\t" + data1 + " \t\t " + data2
					+ "\t \t " + data3 + "\t\n");
			System.out.println("with combiner\t" + data11 + " \t\t " + data22
					+ "\t \t " + data33 + "\t\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
