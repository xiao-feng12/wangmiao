package spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.HashMap;
import java.util.Map;

/**
 * DateTime 2018/8/27 14:20
 *
 * @author db
 **/
public class LaGouSpider implements PageProcessor {

    private int flag = 0;
    private int mark = 0;
    private int sun = 0;
    private int sub = 0;
    private int ty = 0;
    private int tr = 0;
    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
            .addHeader("Accept-Encoding", "gzip, deflate, br")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8")
            .addHeader("Connection", "keep-alive")
            //.addHeader("Content-Length","23")
            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
            .addHeader("Cookie", "Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1516684224,1516688332,1516708458,1517989813; _ga=GA1.2.803780703.1515996477; user_trace_token=20180115140756-6e315eee-f9ba-11e7-a353-5254005c3644; LGUID=20180115140756-6e316229-f9ba-11e7-a353-5254005c3644; index_location_city=%E5%85%A8%E5%9B%BD; JSESSIONID=ABAAABAAADEAAFI7B8A950147564B82F61A115D162E1281; LGSID=20180207155015-888d0972-0bdb-11e8-bdd2-525400f775ce; LGRID=20180207163606-f07d2f3d-0be1-11e8-af98-5254005c3644; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1517992563; TG-TRACK-CODE=index_navigation; SEARCH_ID=ada31aea74d74f0ba5625adf851d1c6f; X_HTTP_TOKEN=4235610f3926fcdc9a4b942f0c350399; _putrc=0DA9DA012C722A8E; login=true; unick=%E7%8E%8B%E5%86%B6; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=0; gate_login_token=fc49718b5340e22bfe7adebb2937015b765f94906d1f154c; _gat=1")
            .addHeader("Host", "www.lagou.com")
            .addHeader("Origin", "https://www.lagou.com")
            .addHeader("Referer", "https://www.lagou.com/jobs/list_Java")
            .addHeader("User-Agent", "-Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3095.5 Mobile Safari/537.36")
            .addHeader("X-Anit-Forge-Code", "0")
            .addHeader("X-Anit-Forge-Token", "None")
            .addHeader("X-Requested-With", "XMLHttpRequest");

    @Override
    public void process(Page page) {
        flag = processCity(page, "北京", flag, 30);
        mark = processCity(page, "天津", mark, 9);
        sun = processCity(page, "成都", sun, 1);
        tr = processCity(page, "大连", tr, 1);
        ty = processCity(page, "沈阳", ty, 1);
        sub = processCity(page, "西安", sub, 1);

        page.putField("positionname", new JsonPathSelector("$.content.positionResult.result[*].positionName").selectList(page.getRawText()));
        page.putField("workYear", new JsonPathSelector("$.content.positionResult.result[*].workYear").selectList(page.getRawText()));
        page.putField("salary", new JsonPathSelector("$.content.positionResult.result[*].salary").selectList(page.getRawText()));
        page.putField("address", new JsonPathSelector("$.content.positionResult.result[*].city").selectList(page.getRawText()));
        page.putField("district", new JsonPathSelector("$.content.positionResult.result[*].district").selectList(page.getRawText()));
        page.putField("createTime", new JsonPathSelector("$.content.positionResult.result[*].createTime").selectList(page.getRawText()));
        page.putField("companyName", new JsonPathSelector("$.content.positionResult.result[*].companyFullName").selectList(page.getRawText()));
        page.putField("discription", new JsonPathSelector("$.content.positionResult.result[*].secondType").selectList(page.getRawText()));

    }

    @Override
    public Site getSite() {
        return site;
    }

    private int processCity(Page page, String city, int flag, int count){
        String url = "https://www.lagou.com/jobs/positionAjax.json?px=default&city=" + city + "&needAddtionalResult=false&isSchoolJob=0";
        if (flag == 0){
            Request[] requests = new Request[count];
            for (int i = 0; i < requests.length; i++){
                Map<String, Object> map = new HashMap<>();
                if (i == 0){
                    map.put("first", true);
                } else {
                    map.put("first", false);
                }
                map.put("pn", i + 1);
                map.put("kd", "java");

                requests[i] = new Request(url);
                requests[i].setRequestBody(HttpRequestBody.form(map, "utf-8"));
                page.addTargetRequest(requests[i]);
            }
            flag++;
        }

        return flag;
    }


    public static void main(String[] args) {
        Spider.create(new LaGouSpider())
                .addPipeline(new LaGouPipe())
                .addUrl("https://www.lagou.com/jobs/positionAjax.json?px=default&city=北京&needAddtionalResult=false&isSchoolJob=0")
                .thread(2)
                .run();
    }


}
