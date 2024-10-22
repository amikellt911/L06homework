package cn.edu.zucc;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.zucc.model.User;


@SpringBootTest
public class JdbcApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    /**
     * @Description: 创建表
     */
    public void createUserTable() throws Exception {
        String sql = "CREATE TABLE `user` (\n" +
                "  `id` int(10) NOT NULL AUTO_INCREMENT,\n" +
                "  `username` varchar(100) DEFAULT NULL,\n" +
                "  `password` varchar(100) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n" +
                "\n";

        jdbcTemplate.execute(sql);
    }

    @Test
    public void saveUserTest() throws Exception {
        String sql = "INSERT INTO user (USERNAME,PASSWORD) VALUES ('abc','123456')";
        int rows = jdbcTemplate.update(sql);
        System.out.println(rows);
    }
    @Test
    public void updateUserPassword() throws Exception {
        Integer id = 1;
        String passWord = "999888";
        String sql = "UPDATE user SET PASSWORD = ? WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, passWord, id);
        System.out.println(rows);
    }
    @Test
    public void deleteUserById() throws Exception {
        String sql = "DELETE FROM  user  WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, 1);
        System.out.println(rows);
    }
    @Test
    public void getUserByName() throws Exception {
        String name = "longzhiran";
        String sql = "SELECT * FROM user WHERE USERNAME = ?";
        List<User> list = jdbcTemplate.query(sql, new User(), new Object[]{name});
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void batchSaveUser() {
    }

    @Test
    public void addUser() {
    }





    @Test
    public void getMapById() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void list() throws Exception {
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(User.class));
        for (User userLists : userList) {
            System.out.println(userLists);
        }
    }
}
