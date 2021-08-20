package com.afd.member;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 회원 더미를 만드는 클래스
 * @author 3조
 *
 */
public class MemberDummy {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {

			System.out.printf(
					"INSERT INTO TBLMEMBER (memberSeq, name, id, pw, nickName, registrationNumber, tel, address, email) values (memberSeq.nextVal, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');\r\n",
					fullName(), nId(), pw(), nNick(), ssn(), nPhone(), address(), Email());

		}

	}

	// 이름 생성하는 메소드
	public static String fullName() {

		List<String> lastName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권",
				"황", "안", "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽",
				"성", "차", "주", "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현",
				"함", "변", "염", "양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표",
				"명", "기", "반", "왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구",
				"용");

		List<String> firstName = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남",
				"노", "누", "다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문",
				"미", "민", "바", "박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세",
				"소", "솔", "수", "숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완",
				"요", "용", "우", "원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재",
				"전", "정", "제", "조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태",
				"택", "판", "하", "한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배",
				"부", "림", "봉", "혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송",
				"욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번",
				"식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학",
				"개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");

		Collections.shuffle(lastName);
		Collections.shuffle(firstName);

		return lastName.get(0) + firstName.get(0) + firstName.get(1);

	}

	// 닉네임 생성하는 메소드
	public static String nNick() {

		List<String> nick = Arrays.asList("기분나쁜", "기분좋은", "신바람나는", "상쾌한", "짜릿한", "그리운", "자유로운", "서운한", "울적한", "비참한",
				"위축되는", "긴장되는", "두려운", "당당한", "배부른", "수줍은", "창피한", "멋있는", "열받은", "심심한", "잘생긴", "이쁜", "시끄러운");

		List<String> name = Arrays.asList("사자", "코끼리", "호랑이", "곰", "여우", "늑대", "너구리", "침팬치", "고릴라", "참새", "고슴도치", "강아지",
				"고양이", "거북이", "토끼", "앵무새", "하이에나", "돼지", "하마", "원숭이", "물소", "얼룩말", "치타", "악어", "기린", "수달", "염소", "다람쥐",
				"판다");

		Collections.shuffle(nick);
		Collections.shuffle(name);
		String text = nick.get(0) + name.get(0);
		return text;

	}

	// 아이디 생성하는 메소드
	public static String nId() {

		String text = "";

		String ran = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		for (int i = 0; i < 6; i++) {

			text += ran.charAt((int) (Math.random() * ran.length()));

		}

		return text + (int) (Math.random() * 99) + 1 + "";

	}

	
	

	// 핸드폰 번호 생성하는 메소드
	public static String nPhone() {

		List<String> number = Arrays.asList("010");

		Collections.shuffle(number);

		String ssn1 = (int)(Math.random() * 8999) + 1000 + "";
		String ssn2 = (int)(Math.random() * 8999) + 1000 + "";

		return number.get(0) + "-" + ssn1 + "-" + ssn2;

	}

	// 핸드폰 번호 생성하는 메소드2
//	public static String nNo() { 
//		
//		return (int)(Math.random() * 8999)+1000 +""; 
//		
//	}

	public static String ssn() {

		Random rand = new Random();

		int suff_num = rand.nextInt(9);

		List<String> 월 = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
		List<String> 일 = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");

		Collections.shuffle(월);
		Collections.shuffle(일);
		String ssn = "9" + String.valueOf(suff_num) + 월.get(0) + 일.get(0);

		List<String> ssn1 = Arrays.asList("1", "2");
		List<String> ssn2 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

		Collections.shuffle(ssn1);
		Collections.shuffle(ssn2);

		String test_ssn = ssn1.get(0);

		for (int i = 0; i < 6; i++) {

			test_ssn += ssn2.get(i);

		}

		return ssn + "-" + test_ssn;
	}

	public static String pw() {

		String[] id1 = { "aa", "bb", "cc", "ad", "ag", "jd", "go", "fd", "gd", "pc", "op", "pp", "ds" };
		String[] id2 = { "12", "23", "34", "56", "78", "96", "04", "25", "63", "53", "11", "22", "03", "04", "94" };

		Random rnd = new Random();

		return id1[rnd.nextInt(id1.length)] + id1[rnd.nextInt(id1.length)] + id2[rnd.nextInt(id2.length)]
				+ id2[rnd.nextInt(id2.length)];

	}

	public static String address() {

		Random rnd = new Random();

		String[] si = { "경기도 용인시 ", "서울특별시 " };

		String[] gu = { "종로구 ", "용산구 ", "성동구 ", "광진구 ", "동대문구 ", "은평구 ", "마포구 ", "서대문구 ", "강서구 ", "강남구 ", "도봉구 ",
				"중랑구 ", "양천구 " };

		String[] dong = { "상도동", "논현동", "역삼동", "삼성동", "중곡동", "자양동", "신사동", "압구정동", "청담동", "대치동", "도곡동", "개포동", "잠원동",
				"방배동", "반포동", "양재동", "혜화동", "이화동", "명동", "회현동", "신당동", "황학동", "마장동", "금호동", "옥수동", "성북동", "안암동" };

		return si[rnd.nextInt(si.length)] + gu[rnd.nextInt(gu.length)] + dong[rnd.nextInt(dong.length)];

	}

	public static String Email() {

		String[] firstEmail = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "m", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		String[] address = { "hanmail.net", "naver.com", "gmail.com", "yahoo.co.kr", "nate.com" };

		Random rnd = new Random();

		return firstEmail[rnd.nextInt(firstEmail.length)] + firstEmail[rnd.nextInt(firstEmail.length)]
				+ firstEmail[rnd.nextInt(firstEmail.length)] + firstEmail[rnd.nextInt(firstEmail.length)]
				+ firstEmail[rnd.nextInt(firstEmail.length)] + firstEmail[rnd.nextInt(firstEmail.length)] + "@"
				+ address[rnd.nextInt(address.length)];

	}

}
