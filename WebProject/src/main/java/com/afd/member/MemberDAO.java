package com.afd.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.afd.DBUtil;
import com.afd.member.community.CommunityDTO;

/**
 * 회원이 로그인할 때 필요한 클래스
 * @author 3조
 *
 */
public class MemberDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	//DB연결
	public MemberDAO() {
		
		try {
			
			conn = DBUtil.open();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.MemberDAO()");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 회원이 로그인 하도록 해주는 메소드
	 * @param dto
	 * @return resultDTO, null
	 */
	public MemberDTO login(MemberDTO dto) {

		try {
			
			//로그인 처리
			String sql = "select * from tblMember where id=? and pw=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				//로그인 O
				MemberDTO resultDTO = new MemberDTO();
				
				resultDTO.setMemberSeq(rs.getString("memberSeq"));
				resultDTO.setName(rs.getString("name"));
				resultDTO.setId(rs.getString("id"));
				resultDTO.setNickName(rs.getString("nickName"));
				resultDTO.setRegistrationNumber(rs.getString("registrationNumber"));
				resultDTO.setTel(rs.getString("tel"));
				resultDTO.setAddress(rs.getString("address"));
				resultDTO.setEmail(rs.getString("email"));
				
				return resultDTO;
			}
	
		} catch (Exception e) {
			System.out.println("MemberDAO.login()");
			e.printStackTrace();
		} 
	
		
		return null;
	}

	/**
	 * 회원이 새로 회원가입할 때 필요한 메소드
	 * @param dto
	 * @return pstat.executeUpdate(), 0
	 */
	public int add(MemberDTO dto) {

		try {
			
			String sql = "insert into tblMember(memberSeq, name, id, pw, nickName, registrationNumber, tel, address, email) "
					+ "values (memberSeq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?)";
					
			
			pstat = conn.prepareStatement(sql);
			
			
		
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getId());
			pstat.setString(3, dto.getPw());
			pstat.setString(4, dto.getNickName());
			pstat.setString(5, dto.getRegistrationNumber());
			pstat.setString(6, dto.getTel());
			pstat.setString(7, dto.getAddress());
			pstat.setString(8, dto.getEmail());
			
			
			
			
			return pstat.executeUpdate(); //성공하면 1 실패하면 0

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 모든 회원들의 목록을 출력하는 메소드
	 * @return list, null
	 */
	public ArrayList<MemberDTO> list() {
		
		
		try {
			
			String sql = "select * from tblMember";
			
			
			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();
					
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); //옮겨 담을 큰상자
		
			
			while (rs.next()) {
				
				//레코드 1줄 -> BoardDTO 1개
				MemberDTO dto = new MemberDTO();
				
				  dto.setId(rs.getString("id"));
				  dto.setPw(rs.getString("pw"));
				  dto.setNickName(rs.getString("nickName"));
				 
				list.add(dto);
				
				
			}
			
		return list;	
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 멤버의 새로운 프로필 정보를 추가하는 메소드
	 * @param dto
	 * @return pstat.executeUpdate(), 0
	 */
   public int addprofile(MemberDTO dto) {
       try {
    	   
    	   String memberSeq = findSeq();
    	   
          
          String sql = "insert into tblMemberprofile(memberprofileseq, memberseq, career, academicbackground, gender, interestoccupation, availableLanguage, major,score)"
        			+ "values (memberprofileSeq.nextVal, ?, null, null, null, null, null, null ,0)";
          	
          
          
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, memberSeq);
		
		return pstat.executeUpdate(); //성공하면 1 실패하면 0


       }catch(Exception e) {
          System.out.println(e);
       }
     
	     return 0;
  }

   /**
    * 찾고자 하는 회원의 회원 번호를 찾는 메소드
    * @return number, null
    */
	private String findSeq() {
		// TODO Auto-generated method stub
		
		try {

			String sql = "select memberseq from tblmember where memberseq = (select max(memberseq) from tblmember)";
  			
			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();
			
			if(rs.next()) {
				String number = rs.getString("memberSeq");
				
				return number;
			}
			
			

		} catch (Exception e) {

			System.out.println();
			e.printStackTrace();

		}

		
		return null;
	}
}
