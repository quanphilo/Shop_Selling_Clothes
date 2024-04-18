package BLL;

import java.util.Vector;

import DAL.PermissionDAL;
import DTO.PermissionDTO;

public class PermissionBLL {
    PermissionDAL permissionDAL = new PermissionDAL();
    
    public Vector<PermissionDTO> getPermissions() {
        return permissionDAL.getPermissions();
    }

    public PermissionDTO getPermissionById(String id_permission) {
        return permissionDAL.getPermissionById(id_permission);
    }

    public int insert(PermissionDTO permissionDTO) {
        return permissionDAL.insert(permissionDTO);
    }
}
