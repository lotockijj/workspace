package roman.order.exception;

import java.sql.SQLException;

/**
 * Created by Роман Лотоцький on 15.10.2016.
 */
public class BOException extends Exception {

    public BOException(SQLException e) {
        super(e);
    }
}
