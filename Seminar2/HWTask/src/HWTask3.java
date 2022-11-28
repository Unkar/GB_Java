//3. **
//
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder,
//        создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
public class HWTask3 {

    public static void main(String[] args) {
        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        System.out.println(json);
        System.out.println(parseJson(json));
    }

    public static String parseJson(String json) {
        StringBuilder sb = new StringBuilder();
        String[] jsonArr = json.split("},");
        for (int i = 0; i < jsonArr.length; i++) {
            String[] jsonArr2 = jsonArr[i].split(",");
            for (int j = 0; j < jsonArr2.length; j++) {
                String[] jsonArr3 = jsonArr2[j].split(":");
                for (int k = 0; k < jsonArr3.length; k++) {
                    if (jsonArr3[k].contains("фамилия")) {
                        sb.append("Студент ").append(jsonArr3[k + 1].replace("\"", "")).append(" получил ");
                    }
                    if (jsonArr3[k].contains("оценка")) {
                        sb.append(jsonArr3[k + 1].replace("\"", "")).append(" по предмету ");
                    }
                    if (jsonArr3[k].contains("предмет")) {
                        sb.append(jsonArr3[k + 1].replace("\"", "").replaceAll("}]", "")).append(".\n");

                    }
                }
            }
        }
        return sb.toString();
    }
}
