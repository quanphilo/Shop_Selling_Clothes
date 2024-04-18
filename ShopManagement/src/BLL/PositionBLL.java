package BLL;

import java.util.Vector;

import DAL.PositionDAL;
import DTO.PositionDTO;

public class PositionBLL {
    PositionDAL positionDAL = new PositionDAL();

    public Vector<PositionDTO> getPositions() {
        Vector<PositionDTO> listPosition = positionDAL.getPositions();
        return listPosition;
    }

    public PositionDTO getPositionById(String id_position) {
		PositionDTO positionDTO = positionDAL.getPositionById(id_position);
        return positionDTO;
    }

    public int insert(PositionDTO positionDTO) {
        int kq = positionDAL.insert(positionDTO);
        return kq;
    }

    public int delete(String id_position) {
        int kq = positionDAL.delete(id_position);
        return kq;
    }
}
