package com.zcd.controller;

import com.zcd.entity.Seckill;
import com.zcd.interfaces.IGoodService;
import com.zcd.interfaces.ISeckillService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 14:10
 **/
@Controller
@RequestMapping(value="/seckill")
public class SeckillController {

    @Autowired
    private ISeckillService  seckillService;

    @Autowired
    private IGoodService goodService;


    @RequestMapping("/list")
    public String  list(Model model){
        List<Seckill> seckillList=seckillService.seckillList();
        model.addAttribute("list", seckillList);
        model.addAttribute("totalNum", 100);
        model.addAttribute("pageNum", 1);
        return  "list";
    }


    /**
     * 图片的显示
     * @param seckillId
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/img/seckill/{seckillId}")
    public void  loadImg(@PathVariable Long seckillId, HttpServletResponse response) throws IOException {
        Seckill seckill=seckillService.selectById(seckillId);
        byte[]  goodsPhotoImages=goodService.getPhotoImg(seckill.getGoodsId());
        response.setContentType("img/*");
        OutputStream  outputStream=response.getOutputStream();
        outputStream.write(goodsPhotoImages);
        outputStream.flush();
        outputStream.close();
    }


    /**
     * 登出
     * @param model
     * @return
     */
    @RequestMapping("/signOut")
    public String  logonOut(Model model){
        Subject subject =SecurityUtils.getSubject();
        subject.logout();
        return  "redirect:/auth/toLogin";
    }

}
