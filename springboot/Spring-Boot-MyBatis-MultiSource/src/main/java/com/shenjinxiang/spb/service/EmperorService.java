package com.shenjinxiang.spb.service;

import com.shenjinxiang.spb.domain.Emperor;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 17:45
 */
public interface EmperorService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Emperor> queryAllEmperor();

    /**
     * 单条查询
     *
     * @param id
     * @return
     */
    Emperor queryById(int id);

    /**
     * 新增
     *
     * @param emperor
     * @return
     */
    int add(Emperor emperor);

    /**
     * 修改
     *
     * @param emperor
     * @return
     */
    int upd(Emperor emperor);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delById(int id);

}
