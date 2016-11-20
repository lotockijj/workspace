package roman.order.dto;

/**
 * Created by Роман Лотоцький on 15.10.2016.
 */
public class Order {

    int id;
    String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
