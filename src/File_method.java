
import java.io.*;
import java.io.IOException;



public class File_method {
	public static void NewFile(String FileName , Boolean CreateOrDelete) {
		try {
			File file = new File(FileName);
			if (file.exists()) {
				if (!CreateOrDelete) {
					file.delete();
					System.out.println("文件已删除！");
				}
				else
					System.out.println("文件已存在！");
			}
			else {
				file.createNewFile();
				System.out.println("文件创建成功!");
			}		
	    } catch (IOException e) {
	    }
	}
	public static void WriteData(String FileName,String data, Boolean isAppend) {

		try {
			BufferedWriter out;
			out = new BufferedWriter(new FileWriter(FileName,isAppend));
	        out.write(data);
	        out.newLine();
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String ReadData(String FileName) {
        String result = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(FileName));
            String str;

            while ((str = in.readLine()) != null) {
                result+=str+"\n";
            }
            in.close();
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	public static void main(String[] args) {
		String FileName="./src/data/test.txt";
//		 NewFile(FileName,true);
		 WriteData(FileName,"aaa",false);
		 WriteData(FileName,"第二行",true);
		 WriteData(FileName,"第三行",true);
		 System.out.print(ReadData(FileName));
	    }
}
