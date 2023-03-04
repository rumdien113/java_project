package Controller;

import DAO.LoginDAO;

public class LoginController {
    private LoginDAO dao;
    public LoginController() {
        dao = new LoginDAO();
    }
    public String selectpw(String id) throws Exception {
        return dao.selectpw(id);
    }
    public String selectName(String id) throws Exception {
        return dao.selectName(id);
    }
}
