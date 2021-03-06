package model.bo;

import java.sql.SQLException;

import model.bean.Information;
import model.dao.InsertInformationDAO;

public class InsertInformationBO {
	InsertInformationDAO insertInformationDAO = new InsertInformationDAO();
	
	public void insertInformation(Information _infor) throws ClassNotFoundException, SQLException {
		insertInformationDAO.insertInformation(_infor);
	}
	
	public String checkFormUpdateInformation(Information _infor) {
		String error = null;
		String regex = "\\d+";
		if (_infor.getName().equals("") || _infor.getGender().equals("") || _infor.getEmail().equals("") || _infor.getBirth().equals("")) {
			return "Fill in all fields";
		}
		if (!(_infor.getIdentitynumber().matches(regex)) || (_infor.getIdentitynumber().length()!=9)) {
			return "Invalid identity number";
		}
		if (!(_infor.getPhone().matches(regex)) || ((_infor.getPhone().length()!=10) && (_infor.getPhone().length()!=11))) {
			return "Invalid phone number";
		}
		return error;
	}
}
