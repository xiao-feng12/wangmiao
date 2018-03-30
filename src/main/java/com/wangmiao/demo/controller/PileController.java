package com.wangmiao.demo.controller;

import com.wangmiao.demo.dao.PileMapper;
import com.wangmiao.demo.entity.Pile;
import com.wangmiao.demo.pojo.Page;
import com.wangmiao.demo.repository.PileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * DateTime 2018-03-29 11:52
 *
 * @author db
 **/
@Controller
public class PileController {
    @Autowired
    private PileRepository pileRepository;

    @Autowired
    private PileMapper pileMapper;

    @RequestMapping("/pile")
    public String index(ModelMap map) {
        List<com.wangmiao.demo.pojo.Pile> pileList = save();
        map.addAttribute("pileList", pileList);

        Page page=new Page(1);
        page.setRowcountAndCompute(10);
        map.put("page", page);
        return "pilePage";
    }

    public List<com.wangmiao.demo.pojo.Pile> save() {
        Long elect = 1L;

        Pile pile = new Pile();
        pile.setElectricQuantity(elect);
        pile.setStartTime(new Date());
        pile.setEndTime(new Date());
        pile.setCost(new BigDecimal(elect * 0.6));
        pile.setSalesAmount(new BigDecimal(elect * 1.6));
        pile.setProfit(new BigDecimal(elect * (1.6-0.6)));

        long id = pileRepository.save(pile).getId();
        System.out.println(pileRepository.findOne(id));

        List<com.wangmiao.demo.pojo.Pile> piles = pileMapper.selectPilesByLimit(0, 10);

        for (com.wangmiao.demo.pojo.Pile p : piles){
            System.out.println(p);
        }

        return piles;

    }

}
