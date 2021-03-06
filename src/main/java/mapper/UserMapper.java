package mapper;

import entity.User;

import java.util.List;

/**
 * @InterfaceName UserMapper
 * @Description User模块Mapper层
 * @Author GengRui
 * @Date 2021/3/14 10:30
 */
public interface UserMapper {
    /**
     * 通过用户id查询用户信息
     *
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> selectUserList();

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    int deleteUserById(Integer id);
}
