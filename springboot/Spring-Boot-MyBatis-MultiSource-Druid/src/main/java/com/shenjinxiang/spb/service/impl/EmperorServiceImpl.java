package com.shenjinxiang.spb.service.impl;

import com.shenjinxiang.spb.domain.Emperor;
import com.shenjinxiang.spb.mapper.db2.EmperorMapper;
import com.shenjinxiang.spb.service.EmperorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 17:49
 */
@Service("emperorService")
public class EmperorServiceImpl implements EmperorService {

    @Autowired
    private EmperorMapper emperorMapper;

    @Override
    public List<Emperor> queryAllEmperor() {
        return this.emperorMapper.queryAllEmperor();
    }

    @Override
    public Emperor queryById(int id) {
        return this.emperorMapper.queryById(id);
    }

    @Override
    public int add(Emperor emperor) {
        return this.emperorMapper.add(emperor);
    }

    @Override
    public int upd(Emperor emperor) {
        return this.emperorMapper.upd(emperor);
    }

    @Override
    public int delById(int id) {
        return this.emperorMapper.delById(id);
    }
}
