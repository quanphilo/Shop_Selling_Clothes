package BLL;

import java.util.Vector;

import DAL.PosPermissionDAL;
import DTO.PosPermissionDTO;

public class PosPermissionBLL {
    private PosPermissionDAL posPermissionDAL = new PosPermissionDAL();
    
    public Vector<PosPermissionDTO> getPosPermissions(){
		Vector<PosPermissionDTO> listPosPermission = posPermissionDAL.getPosPermissions();
        return listPosPermission;
    }

    public Vector<PosPermissionDTO> getPermissionByPosId(String id_position) {
		Vector<PosPermissionDTO> listPosPermission = posPermissionDAL.getPermissionByPosId(id_position);
        return listPosPermission;
    }

    public int insert(PosPermissionDTO pospermissionDTO) {
        int kq = posPermissionDAL.insert(pospermissionDTO);
        return kq;
    }

    public int update(PosPermissionDTO pospermissionDTO) {
        return posPermissionDAL.update(pospermissionDTO);
    }

    public int delete(PosPermissionDTO pospermissionDTO) {
        return posPermissionDAL.delete(pospermissionDTO);
    }

    public int checkInit(PosPermissionDTO pospermissionDTO) {
        return posPermissionDAL.checkInit(pospermissionDTO);
    }

}
