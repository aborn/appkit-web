package org.popkit.appkit.demo.mapper;

import org.popkit.appkit.demo.entity.UserInfoDo;

import java.util.List;

/**
 * Like ibatis's DAO
 * @author aborn.jiang
 * @email aborn.jiang@foxmail.com
 * @date 3/15/15
 * @time 4:00 PM
 */
public interface DemoMapper {
    public void insert(UserInfoDo basicDo);
    public UserInfoDo getUserInfo(int id);
    List<UserInfoDo> listAllUsersInfo();
}
