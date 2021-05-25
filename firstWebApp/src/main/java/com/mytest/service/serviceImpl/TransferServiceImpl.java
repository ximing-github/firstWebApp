package com.mytest.service.serviceImpl;

import com.mytest.beans.User;
import com.mytest.dao.TransferDao;

import com.mytest.service.TransferService;


import java.util.List;

/**
 * ClassName:TransferServiceImpl
 * Package: com.mytest.service.serviceImpl
 * Description:
 *
 * @Date: 2021/5/10 11:01
 * @Author: 惜名
 */
public class TransferServiceImpl implements TransferService {
    private TransferDao transferDao;

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    @Override
    public List<User> selectAllUser() {
       return transferDao.selectAll();
    }

    @Override
    public boolean transfer(String outusername, String inusername, double num)  {
         User outuser = transferDao.selectByUsername(outusername);
         User inuser = transferDao.selectByUsername(inusername);

         if(outuser.getBalance()>=num){
             outuser.setBalance(outuser.getBalance()-num);

             inuser.setBalance(inuser.getBalance()+num);
             transferDao.updateByUser(outuser);

             transferDao.updateByUser(inuser);

             return true;
         }
            return  false;
    }

    @Override
    public User selectOne(String name) {
        return transferDao.selectByUsername(name);
    }


}
