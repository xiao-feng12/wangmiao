package spider;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * DateTime 2018/8/27 14:54
 *
 * @author db
 **/
public class LaGouPipe implements Pipeline {
    static int sum = 0;
    String savepath = "E:\\爬虫/wordcloud.txt";
    String sep_before = ":'";
    String sep_after = "'";

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> position = resultItems.get("positionname");
        List<String> salary = resultItems.get("salary");
        List<String> workYear = resultItems.get("workYear");
        List<String> address = resultItems.get("address");
        List<String> district = resultItems.get("district");
        List<String> createTime = resultItems.get("createTime");
        List<String> companyName = resultItems.get("companyName");
        List<String> discription = resultItems.get("discription");
        FileWriter fileWriter = null;
        try {

//            File file = new File(savepath);
//            if (!file.exists()){
//                file.mkdirs();
//            }

            fileWriter = new FileWriter(savepath, true);

            for (int j = 0; j < position.size(); j++) {
                String builder = "{" +
                        "position" + sep_before + position.get(j) + sep_after + "," +
                        "salary" + sep_before + salary.get(j) + sep_after + "," +
                        "workYear" + sep_before + workYear.get(j) + sep_after + "," +
                        "address" + sep_before + address.get(j) + sep_after + "," +
                        "district" + sep_before + district.get(j) + sep_after + "," +
                        "createTime" + sep_before + createTime.get(j) + sep_after + "," +
                        "companyName" + sep_before + companyName.get(j) + sep_after + "," +
                        "discription" + sep_before + discription.get(j) + sep_after +
                        "}";
                fileWriter.write(builder);
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
 /*       for (int i = 0; i < position.size(); i++) {
            System.out.println(position.get(i).toString() + sum);
            System.out.println(salary.get(i).toString() + sum);
            System.out.println(workYear.get(i).toString() + sum);
            System.out.println(address.get(i).toString() + sum);
            System.out.println(district.get(i).toString() + sum);
            System.out.println(createTime.get(i).toString() + sum);
            System.out.println(companyName.get(i).toString() + sum);
            System.out.println(discription.get(i).toString() + sum);

//            Record lagou = new Record()
//                    .set("positionname", position.get(i).toString())
//                    .set("salary", salary.get(i).toString())
//                    .set("workYear", workYear.get(i).toString())
//                    .set("address", address.get(i).toString())
//                    .set("district", district.get(i).toString())
//                    .set("createTime", createTime.get(i).toString())
//                    .set("companyName", companyName.get(i).toString())
//                    .set("discription", discription.get(i).toString());
//            Db.save("lagou", lagou);
            sum++;*/
//        }
    }
}
