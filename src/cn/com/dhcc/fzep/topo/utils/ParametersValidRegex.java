package cn.com.dhcc.fzep.topo.utils;

public class ParametersValidRegex {
	public static final String AREA_NAME_REGEX = ".{1,15}";    //长度在1-15之间
	public static void main(String[] args) {
		String regexTest = "ddddddddddddddd";
		System.out.println(regexTest.matches(AREA_NAME_REGEX));
	}
}
