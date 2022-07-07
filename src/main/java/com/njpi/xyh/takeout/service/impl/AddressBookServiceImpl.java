package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.AddressBookDao;
import com.njpi.xyh.takeout.entity.AddressBook;
import com.njpi.xyh.takeout.entity.User;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.AddressBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 地址管理(AddressBook)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:54:50
 */
@Service("addressBookService")
public class AddressBookServiceImpl extends ServiceImpl<AddressBookDao, AddressBook> implements AddressBookService {

    @Resource
private HttpSession session;

    @Override
    public Result saveAddressBook(AddressBook addressBook) {

        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        addressBook.setUserId(id);

        return Result.success(baseMapper.insert(addressBook));
    }
}

