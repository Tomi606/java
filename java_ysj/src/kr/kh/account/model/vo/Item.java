package kr.kh.account.model.vo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

//10번
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

	int it_num;
	int it_ca_num;
	Date it_date;
	int it_money;
    String it_content;
    //item 테이블에 없는 속성, 쿼리문으로 가져옴
    String it_ca_name;
    //없는 속성(수입/지출)
    String it_ty_name;

    //Item 생성자
    public Item(int categoryNum, String date, int money, String content, String type) throws ParseException {
    	it_ca_num = categoryNum;
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	it_date = format.parse(date);
    	it_money = money;
    	it_content = content;
    	it_ty_name = type;
    }
    
	@Override
	public String toString() {
		return it_num + ". " + getIt_date_str() + " " + it_ty_name + " "
				+ it_ca_name + " " + it_money +"원 "+ it_content;
	}

	private String getIt_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(it_date);
	}
    //date getter(이미 @Data로 되있음)
	//  public Date getIt_date() {
	//  	return it_date;
	//  }
	
	//it_num가 같을 때 생성자
	public Item(int it_num) {
		this.it_num = it_num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return it_num == other.it_num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(it_num);
	}

	
}
