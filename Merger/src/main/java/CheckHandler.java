import java.util.ArrayList;

/**
 * Класс содержащий методы для последующей сортировки
 */
public class CheckHandler extends Merger {

    /**
     * Метод сортировки по убыванию
     * @param strList ArrayList<String> из входных аргументов
     * @param param параметр для последующей передачи его в метод слияния (для определения int или String)
     */
    private void decrease (ArrayList<String> strList, String param) {
        ArrayList<String[]> resultList = new Checker().getMyScanner(strList, "-d", param);
        int manySortedArgs = resultList.size();

        while ((manySortedArgs > 0) && (resultList.size() > 1)) {
            resultList.set(1, merge_d(resultList.get(0),resultList.get(1),param));
            resultList.remove(0);
            manySortedArgs--;
        }
        MyWriter.setWriter(resultList.get(0), strList.get(0));
    }

    /**
     * Метод для сортировки на увеличение,параметры аналогичны decrease()
     * @param strList
     * @param param
     */
    public void ascending (ArrayList<String> strList, String param) {
        ArrayList<String[]> resultList = new Checker().getMyScanner(strList,"-a",param);
        int manySortedArgs = resultList.size();

        while ((manySortedArgs > 0) && (resultList.size() > 1)) {
            resultList.set(1,merge(resultList.get(0),resultList.get(1),param));
            resultList.remove(0);
            manySortedArgs--;
        }
        MyWriter.setWriter(resultList.get(0), strList.get(0));
    }

    /**
     * Метод определяющий направление сортировки для int массива входных данных
     * @param strList список аргументов
     * @param param параметр для определения направления сортировки (-a/-d)
     */
    public void intworking(ArrayList<String> strList, String param){
        if (param.equals("-d")) {
            decrease(strList, "-i");
        } else {
            ascending(strList, "-i");
        }
    }

    /**
     * Метод определяющий  направление сортировки для String массива входных данных
     * @param strList список аргументов
     * @param param параметр для определения направления сортировки (-a/-d)
     */
    public void strworking(ArrayList<String> strList, String param){
        if (param.equals("-d")){
            decrease(strList,param);
        } else {
            ascending(strList,param);
        }
    }

}
