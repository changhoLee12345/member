package co.syeon.border.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.syeon.border.vo.BorderVO;

public class TestDAO {
	public List<BorderVO> getBorderList() {
		List<BorderVO> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			BorderVO vo = new BorderVO();
			vo.setBorderContent("borderContent" + i);
			vo.setBorderDate(new Date(2020, 01, 01));
			vo.setBorderHit(i);
			vo.setBorderId(i);
			vo.setBorderTitle("borderTitle" + i);
			vo.setBorderWrite("borderWrite" + i);

			list.add(vo);
		}
		return list;
	}
}
