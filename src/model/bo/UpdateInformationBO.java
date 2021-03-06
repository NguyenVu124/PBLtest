package model.bo;

import java.sql.SQLException;

import model.bean.Information;
import model.dao.UpdateInformationDAO;

public class UpdateInformationBO {
	UpdateInformationDAO updateInformationDAO = new UpdateInformationDAO();
	
	public Information viewInformation(int _ID) throws ClassNotFoundException, SQLException {
		return updateInformationDAO.getInformation(_ID);
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
	
	public void updateInformation(Information _infor) throws ClassNotFoundException, SQLException {
		updateInformationDAO.updateInformation(_infor);
	}
}
