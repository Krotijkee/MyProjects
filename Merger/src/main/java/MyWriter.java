import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Класс для записи в файл
 */
public class MyWriter {

    /**
     * Проверят наличие выходного файла и создает его если нужно,
     * после чего записывает в него отсортированный массив
     * @param resTxt конечный массив String для записи в файл
     * @param out имя файла в который нужно произвести запись (*.txt)
     */
    private void writer(String[] resTxt, String out) {
        try {
            File file = new File(System.getProperty("user.home") + File.separator + out);
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            for(int i = 0; i < resTxt.length ; i++) {
            pw.println(resTxt[i]);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setWriter(String[] resTxt, String out){
        MyWriter myWriter = new MyWriter();
        myWriter.writer(resTxt, out);
        System.out.println("Запись в выходной файл");
    }
}
