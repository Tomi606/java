package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	
	private int fi_num;
	private int fi_bo_num;
	private String fi_name;
	private String fi_ori_name;
	
	public FileVO(int bo_num, String fileName, String fileOriName) {
		fi_bo_num = bo_num;
		fi_name = fileName;
		fi_ori_name = fileOriName;
	}
}