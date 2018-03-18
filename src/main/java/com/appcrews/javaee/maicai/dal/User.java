package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.base.UserInfo;

import java.util.List;

/**t
 * Created by micheal on 2017/2/5.
 */
public interface User {
    List<UserInfo> getListUser();
    List<UserInfo> getListUser(int pageNo, int pageSize);
    UserInfo getUserInfo(String account);
    int count(int power);

}
