package Controller;

import DAO.ItemDAO;
import Model.Item;

public class ItemController {
    ItemDAO dao = new ItemDAO();

    public Boolean Insert(Item item) throws Exception {
        boolean check = dao.insert(item);
        return check;
    }
}
