package DAO;
import Model.Staff;

import javax.swing.table.DefaultTableModel;
import java.util.*;
public interface IDAO<T>{

    boolean insert(T t) throws Exception;
    List<T> selectAll() throws Exception;
//    String SelectLast() throws Exception;

    void search(DefaultTableModel tbl, String name, String type, String status) throws Exception;
}
