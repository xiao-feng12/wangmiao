package com.wangmiao.demo.controller;

import com.wangmiao.demo.dao.PileMapper;
import com.wangmiao.demo.entity.Pile;
import com.wangmiao.demo.pojo.Page;
import com.wangmiao.demo.repository.PileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Object  index(@RequestParam(value="pageon",defaultValue="1")int pageon
      , ModelAndView mv) {
        int beginRow = (pageon - 1) * 10;
        Page page=new Page(pageon);
        page.setRowcountAndCompute(allCount());

        List<com.wangmiao.demo.pojo.Pile> pileList = save(beginRow);

        Map<String, Object> map = new HashMap<>();
        map.put("pileList", pileList);

        map.put("page", page);
        mv.addAllObjects(map);
        return mv;
    }

    public List<com.wangmiao.demo.pojo.Pile> save(int beginRow) {
        List<com.wangmiao.demo.pojo.Pile> piles = pileMapper.selectPilesByLimit(beginRow, 10);

        for (com.wangmiao.demo.pojo.Pile p : piles){
            System.out.println(p);
        }

        return piles;

    }


    public int allCount(){
        Long elect = 1L;

        Pile pile = new Pile();
        pile.setElectricQuantity(elect);
        pile.setStartTime(new Date());
        pile.setEndTime(new Date());
        pile.setCost(new BigDecimal(elect * 0.6));
        pile.setSalesAmount(new BigDecimal(elect * 1.6));
        pile.setProfit(new BigDecimal(elect * (1.6-0.6)));

        Long id = pileRepository.save(pile).getId();
        System.out.println(pileRepository.findOne(id));
        return id.intValue();
    }

}
