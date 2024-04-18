package DTO;

public class PosPermissionDTO {
    private PermissionDTO permissionDTO;
    private PositionDTO positionDTO;

    public PosPermissionDTO(PermissionDTO permissionDTO, PositionDTO positionDTO) {
        this.permissionDTO = permissionDTO;
        this.positionDTO = positionDTO;
    }

    public PosPermissionDTO() {
    }

    public PermissionDTO getPermissionDTO() {
        return permissionDTO;
    }

    public void setPermissionDTO(PermissionDTO permissionDTO) {
        this.permissionDTO = permissionDTO;
    }

    public PositionDTO getPositionDTO() {
        return positionDTO;
    }

    public void setPositionDTO(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }

}
