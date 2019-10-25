package thread;
/**
 * 枚举类可以使用构造器的形式，类似于Map 或者数据库，能快速的内存检索
 * @author haitao
 * @Date: 2019年10月25日 下午9:34:54
 *
 */
public enum Eumeration {

	ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");
	int idx;
	String value;
	
	Eumeration(int code,String message){
		this.idx = code;
		this.value = message;
	}
	
	public static Eumeration getCountry(int key) {
		Eumeration[] values = Eumeration.values();
		for (Eumeration eumeration : values) {
			if(eumeration.idx == key) {
				return eumeration;
			}
		}
		
		return null;
	}
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
