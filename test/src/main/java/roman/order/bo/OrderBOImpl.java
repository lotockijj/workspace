package roman.order.bo;

import roman.order.bo.OrderBO;
import roman.order.dao.OrderDAO;
import roman.order.dto.Order;
import roman.order.exception.BOException;
import java.sql.SQLException;

/**
 * Created by Роман Лотоцький on 15.10.2016.
 */
public class OrderBOImpl implements OrderBO {

    OrderDAO dao;

    public boolean placeOrder(Order order) throws BOException {
        try {
            int result =  dao.create(order);
            if(result == 0){
                return false;
            }
        } catch (SQLException e) {
           throw  new BOException(e);
        }
        return true;
    }

    public boolean cancelOrder(int id) throws BOException {
        try {
            Order order = dao.read(id);
            order.setStatus("cancelled");
            int result = dao.update(order);
            if(result == 0){
                return false;
            }
        } catch (SQLException e) {
            throw  new BOException(e);
        }
        return true;
    }

    public boolean deleteOrder(int id) throws BOException {
        try {
            int result = dao.delete(id);
            if(result == 0){
                return false;
            }
        } catch (SQLException e) {
            throw  new BOException(e);
        }
        return true;
    }

    public OrderDAO getDao() {
        return dao;
    }

    public void setDao(OrderDAO dao) {
        this.dao = dao;
    }

}
