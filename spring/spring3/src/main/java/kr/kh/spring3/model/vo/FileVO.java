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
	static final String [] imgExtensions = {".jpg", ".png", ".bmp", ".gif"};
	
	public FileVO(int bo_num, String fileName, String fileOriName) {
		fi_bo_num = bo_num;
		fi_name = fileName;
		fi_ori_name = fileOriName;
	}
	
	public boolean isImg() {
		if(fi_ori_name == null || fi_ori_name.length() == 0) {
			return false;
		}
		for(String imgExtension : imgExtensions) {
			//확장자가 하나라도 같은게 있으면 true 리턴
			if(fi_ori_name.endsWith(imgExtension)) {
				return true;
			}
		}
		return false;
	}
}
