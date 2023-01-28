package Controller;

import DAO.ProductDAO;
import Model.Product;

import javax.swing.table.DefaultTableModel;

public class ProductController {
    ProductDAO dao = new ProductDAO();

    public boolean insert(Product product) throws Exception {
        boolean check = dao.insert(product);
        return check;
    }

//    public void Select(DefaultTableModel tbl) throws Exception {
//        dao.Select(tbl);
//    }

    public void Search(DefaultTableModel tbl, String name, String type, String status) throws Exception {
        dao.Search(tbl, name, type, status);
    }
}
