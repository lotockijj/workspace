package roman.order.dao;

import roman.order.dto.Order;

import java.sql.SQLException;

/**
 * Created by Роман Лотоцький on 15.10.2016.
 */
public interface OrderDAO {

    int create(Order id) throws SQLException;

    Order read(int id) throws SQLException;

    int update(Order order) throws SQLException;

    int delete(int id) throws SQLException;

}
