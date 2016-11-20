package roman.order.bo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import junit.framework.TestCase;
import roman.order.dao.OrderDAO;
import roman.order.dto.Order;
import roman.order.exception.BOException;

public class OrderBOImplTest extends TestCase {

	public OrderBOImplTest(String name) {
		super(name);
	}
	
    @Mock
    OrderDAO dao;
    OrderBOImpl bo;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        bo = new OrderBOImpl();
        bo.setDao(dao);
    }

    @Test
    public void testPlaceOrder_Should_Create_An_Order() throws SQLException, BOException{

        Order order = new Order();
        when(dao.create(order)).thenReturn(new Integer(1));

        boolean result = bo.placeOrder(order);
        assertTrue(result);
        verify(dao).create(order);
    }

//    @Test
//    void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException{
//
//        Order order = new Order();
//        when(dao.create(order)).thenReturn(new Integer(0));
//
//        boolean result = bo.placeOrder(order);
//        assertFalse(result);
//        verify(dao).create(order);
//    }
//
//    @Test(expected = BOException.class)
//    void placeOrder_Should_Throw_BOException() throws SQLException, BOException{
//
//        Order order = new Order();
//        when(dao.create(order)).thenThrow(SQLException.class);
//
//        boolean result = bo.placeOrder(order);
//
//    }
//
//    @Test
//    public void testCancelOrder_Should_Cancel_the_Order() throws SQLException, BOException{
//        Order order = new Order();
//        when(dao.read(123)).thenReturn(order);
//        when(dao.update(order)).thenReturn(new Integer(1));
//        boolean result = bo.cancelOrder(123);
//        assertTrue(result);
//        verify(dao).read(123);
//        verify(dao).update(order);
//
//    }
//
//    @Test
//    public void testCancelOrder_Should_NOT_Cancel_the_Order() throws SQLException, BOException{
//        Order order = new Order();
//        when(dao.read(123)).thenReturn(order);
//        when(dao.update(order)).thenReturn(new Integer(0));
//        boolean result = bo.cancelOrder(123);
//        assertFalse(result);
//        verify(dao).read(123);
//        verify(dao).update(order);
//    }
//
//    @Test(expected = BOException.class)
//    public void testCancelOrder_Should_Throw_BOException() throws SQLException, BOException{
//        when(dao.read(123)).thenThrow(SQLException.class);
//        bo.cancelOrder(123);
//    }
//
//    @Test(expected = BOException.class)
//    public void testCancelOrder_Should_Throw_BOException_On_Update() throws SQLException, BOException{
//        Order order = new Order();
//        when(dao.read(123)).thenReturn(order);
//        when(dao.update(order)).thenThrow(SQLException.class);
//        bo.cancelOrder(123);
//    }
}