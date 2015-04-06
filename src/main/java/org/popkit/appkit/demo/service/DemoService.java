package org.popkit.appkit.demo.service;

import org.popkit.appkit.demo.entity.BasicDo;
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
        demoMapper.insert(new BasicDo("" + new Random().nextInt(), "" + new Random().nextInt()));
        //demoMapper.insert(new Testing()); // this will throw an exception
    }

    public void insert(String name, String address) {
        demoMapper.insert(new BasicDo(name, address));
    }

    public List<BasicDo> queryAllUsersInfo() {
        return demoMapper.listAllUsersInfo();
    }

}
