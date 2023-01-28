package DAO;
import Model.Staff;

import javax.swing.table.DefaultTableModel;
import java.util.*;
public interface IDAO<T>{

    boolean insert(T t) throws Exception;

//    void Select(DefaultTableModel tbl) throws Exception;

    void Search(DefaultTableModel tbl, String name, String type, String status) throws Exception;
//    void Search(DefaultTableModel tbl) throws Exception;
}
