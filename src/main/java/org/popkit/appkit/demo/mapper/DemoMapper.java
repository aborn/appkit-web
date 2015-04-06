package org.popkit.appkit.demo.mapper;

import org.popkit.appkit.demo.entity.BasicDo;

import java.util.List;

/**
 * Like ibatis's DAO
 * @author guobao.jiang
 * @date 3/15/15
 * @time 4:00 PM
 */
public interface DemoMapper {
    public void insert(BasicDo basicDo);
    List<BasicDo> listAllUsersInfo();
}
