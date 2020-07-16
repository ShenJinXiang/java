package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Emperor;
import com.shenjinxiang.spb.service.EmperorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 17:51
 */
@RestController
@RequestMapping("/emperors")
public class EmperorController {

    @Autowired
    private EmperorService emperorService;

    @GetMapping("")
    public List<Emperor> queryAllEmperor() {
        return this.emperorService.queryAllEmperor();
    }

    @GetMapping("/{id}")
    public Emperor queryById(@PathVariable int id) {
        return this.emperorService.queryById(id);
    }

    @PostMapping("")
    public int add(@RequestBody Emperor emperor) {
        return this.emperorService.add(emperor);
    }

    @PutMapping("/{id}")
    public int upd(@PathVariable int id, @RequestBody Emperor emperor) {
        Emperor emperor1 = this.emperorService.queryById(id);
        emperor1.setName(emperor.getName());
        emperor1.setDynasty(emperor.getDynasty());
        return this.emperorService.upd(emperor1);
    }

    @DeleteMapping("/{id}")
    public int delById(@PathVariable int id) {
        return this.emperorService.delById(id);
    }
}
