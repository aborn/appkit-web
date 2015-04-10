package org.popkit.appkit.demo.service;

import org.popkit.appkit.demo.entity.UserInfoDo;
import org.popkit.appkit.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * @author guobao.jiang
 * @date 3/15/15
 * @time 4:06 PM
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DemoService {
    @Autowired
    private DemoMapper demoMapper;

    public void insert() throws Exception {
        demoMapper.insert(new UserInfoDo("" + new Random().nextInt(), "" + new Random().nextInt()));
        //demoMapper.insert(new Testing()); // this will throw an exception
    }

    public void insert(String name, String address) {
        demoMapper.insert(new UserInfoDo(name, address));
    }

    public List<UserInfoDo> queryAllUsersInfo() {
        return demoMapper.listAllUsersInfo();
    }

    public UserInfoDo queryUsersInfo(int userid) {
        return demoMapper.getUserInfo(userid);
    }
}
