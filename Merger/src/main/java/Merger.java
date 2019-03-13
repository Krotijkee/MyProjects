
import java.util.Arrays;

/**
 * Класс предназначен для работы с сортировкой
 */

public class Merger {

    /**
     * @param arr массив значений String полученый из file.txt
     * @param param_1 параметр для выбора сортировки
     * @param param_2 параметр определяющий тип сортируемых данных (-i,-s)
     * @return возвращает отсортированный массив
     */
    protected static String[] miracle(String[] arr, String param_1, String param_2) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        if (param_1.equals("-d")) {
            String[] bb = merge_d(miracle(Arrays.copyOfRange(arr, 0, middle),"-d", param_2),
                    miracle(Arrays.copyOfRange(arr, middle, len), "-d", param_2),param_2);
            return bb;
        } else {
            String[] bb = merge(miracle(Arrays.copyOfRange(arr, 0, middle),"-a", param_2),
                    miracle(Arrays.copyOfRange(arr, middle, len),"-a", param_2), param_2);
            return bb;
        }
    }



    /**
     * Метод сортировки от большего к меньшему
     * @param arr_1 первая часть массива который нужно отсортировать
     * @param arr_2 вторая часть того же массива
     * @return возвращает отсортированный массив
     */
    protected static String[] merge_d (String[] arr_1, String[] arr_2,String param){
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if(param.equals("-i")){
                    if ((Integer.parseInt(arr_1[a])) > (Integer.parseInt(arr_2[b]))) {
                        result[i] = arr_1[a];
                        a++;
                    } else {
                        result[i] = arr_2[b];
                        b++;
                    }
                }else if (arr_1[a].compareToIgnoreCase(arr_2[b]) > 0) {
                    result[i] = arr_1[a];
                    a++;
                } else {
                    result[i] = arr_2[b];
                    b++;
                }
            } else if (b < len_2) {
                result[i] = arr_2[b];
                b++;
            } else {
                result[i] = arr_1[a];
                a++;
            }
        }
        return result;
    }

    /**
     * Метод сортировки от меньшего к большему (по умолчанию)
     * @param arr_1
     * @param arr_2
     * @return
     */
    protected static String[] merge(String[] arr_1, String[] arr_2, String param) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0,len = len_1 + len_2;
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if(param.equals("-i")) {
                    if ((Integer.parseInt(arr_1[a])) > (Integer.parseInt(arr_2[b]))) {
                        result[i] = arr_2[b];
                        b++;
                    } else {
                        result[i] = arr_1[a];
                        a++;
                    }
                } else if (arr_1[a].compareToIgnoreCase(arr_2[b]) > 0) {
                    result[i] = arr_2[b];
                    b++;
                    } else {
                    result[i] = arr_1[a];
                    a++;
                }
            } else if (b < len_2) {
                result[i] = arr_2[b];
                b++;
            } else {
                result[i] = arr_1[a];
                a++;
            }
        }
        return result;
    }

}
