import java.io.*;
import java.util.ArrayList;

/**
 * Класс отвечающий за проверку входных данных и последующее распределение работы
 */

public class Checker extends Merger{

    /**
     * Отвечает за направление сортировки -a/-d и сортирует с помощью Merger.miracle()
     * @param strList ArrayList<String> из входных аргументов без учёта параметров
     */

    public void strScaning(ArrayList<String> strList) {


        if (strList.size() < 1) {
            System.out.println("Нет файлов для чтения");
            return;
        }
        if (strList.contains("-i") && !strList.contains("-s")) {
            strList.remove("-i");
            if (strList.contains("-d")) {
                strList.remove("-d");
                new CheckHandler().intworking(strList, "-d");
            } else {
                if (strList.contains("-a")) {
                    strList.remove("-a");
                    new CheckHandler().intworking(strList, "-a");
                }
            }
        }
        if (strList.contains("-s") && !strList.contains("-i")) {
            strList.remove("-s");
            if (strList.contains("-d")) {
                strList.remove("-d");
                new CheckHandler().strworking(strList, "-d");
            } else {
                if (strList.contains("-a")) {
                    strList.remove("-a");}
                    new CheckHandler().strworking(strList, "-a");
            }
        } else {
            System.out.println("Запись завершена");
        }
    }
    /**
     * Отвечает за считывание значений из файлов указанных во входных параметрах
     * @param myList список аргументов для обработки указанных .txt входящих файлов в один для последующей записи
     * @param param_1 параметр отвечающий за направление сортировки
     * @param param_2 параметр отвечающий за тип данных
     * @return возвращает значения каждого входного .txt файла
     * формирует из них список массивов с данными из каждого файла
     */
        public ArrayList<String[]> getMyScanner(ArrayList<String> myList, String param_1, String param_2) {
           return myScanner(myList, param_1, param_2);
        }

        private ArrayList<String[]> myScanner(ArrayList<String> myList, String param_1, String param_2) {
        ArrayList<String[]> readList = new ArrayList();
        for (int i = 1; i < myList.size(); i++) {
            try {
                ArrayList<String> temp = new ArrayList<>();                                                                   //?????? temp?????
                FileReader fileReader = new FileReader(new File(System.getProperty("user.home") + File.separator + myList.get(i)));
                BufferedReader br = new BufferedReader(fileReader);
                String line;
                while ((line = br.readLine()) != null) {
                   temp.add(line);
                }
                String[] t = miracle(temp.toArray(new String[0]), param_1, param_2);
                readList.add(t);
                br.close();
            } catch (FileNotFoundException e) {
                System.out.println("ошибка чтения из файла");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("ошибка чтения из файла");
                e.printStackTrace();
            }
        }
        return readList;
    }
}
