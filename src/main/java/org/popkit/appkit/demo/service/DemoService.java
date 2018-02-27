package org.popkit.appkit.demo.service;

import org.popkit.appkit.demo.entity.UserInfoDo;
import org.popkit.appkit.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Aborn Jiang
 * @email aborn.jiang@foxmail.com
 * @date 3/15/15
 * @time 4:06 PM
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DemoService {
    @Autowired
    private DemoMapper demoMapper;

    /**
     * Insert Random example
     * @throws Exception
     */
    public void insert() {
        try {
            demoMapper.insert(new UserInfoDo("" + new Random().nextInt(), "" + new Random().nextInt()));
        } catch (Exception e) {
            // todo write log info
        }
    }

    public void insert(String name, String address) {
        demoMapper.insert(new UserInfoDo(name, address));
    }

    public List<UserInfoDo> queryAllUsersInfo() {
        try {
            return demoMapper.listAllUsersInfo();
        } catch (Exception e) {
            // todo write log info
            return Collections.EMPTY_LIST;
        }
    }

    public UserInfoDo queryUsersInfo(int userid) {
        try {
            return demoMapper.getUserInfo(userid);
        } catch (Exception e) {
            // todo write log info
            return null;
        }
    }
}
