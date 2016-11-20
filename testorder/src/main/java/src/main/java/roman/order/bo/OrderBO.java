package src.main.java.roman.order.bo;

import src.main.java.roman.order.exception.BOException;
import src.main.java.roman.order.dto.Order;

/**
 * Created by Роман Лотоцький on 15.10.2016.
 */

public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws BOException;

    boolean deleteOrder(int id) throws BOException;

}
