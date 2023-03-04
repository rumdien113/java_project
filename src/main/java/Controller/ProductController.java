package Controller;

import DAO.ProductDAO;
import Model.Product;

import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ProductController {
    private ProductDAO dao;
    public ProductController() {
        dao = new ProductDAO();
    }
    public boolean insert(Product p) throws Exception {
        String getID = dao.selectLast();
        String sliceID = dao.selectLast().substring(2, getID.length());
        String id = "SP" + (Integer.valueOf(sliceID) + 1);

        p.setId(id);
        return dao.insert(p);
    }
    public boolean update(Product p) throws Exception {
        return dao.update(p);
    }
    public boolean delete(String id) throws Exception {
        return dao.delete(id);
    }
    public List<Product> selectAll() throws Exception {
        return dao.selectAll();
    }
    public void search(DefaultTableModel tbl, String name, String type, String status) throws Exception {
        dao.search(tbl, name, type, status);
    }
}
