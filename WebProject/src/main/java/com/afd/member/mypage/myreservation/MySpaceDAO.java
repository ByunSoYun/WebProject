package com.afd.member.mypage.myreservation;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import com.afd.DBUtil;
import com.afd.member.space.SpaceImageDTO;
import com.afd.member.space.SpaceMainDTO;

public class MySpaceDAO {
	
	public MySpaceDAO() {
		
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ArrayList<MySpaceImageDTO> selectMyImg(int memberseq){
		ArrayList<MySpaceImageDTO> list_img = new ArrayList<MySpaceImageDTO>();
		
		try {

			String sql = " select si.imagename, me.memberseq " + 
					" from tblspacerental sr, tblspaceimage si, tblspacereservation se, tblmember me " + 
					" where sr.rentalseq = si.rentalseq and sr.rentalseq = se.rentalseq and se.memberseq = me.memberseq " + 
					" and se.memberseq = ?"; 
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, memberseq);
			
			rs = pstat.executeQuery();	
			
			
			if(rs.next()) {
				MySpaceImageDTO dto = new MySpaceImageDTO();
				dto.setImageName(rs.getString("imagename"));
				dto.setMemberseq(rs.getInt("memberseq"));
				
				list_img.add(dto);
			}
			
			return list_img;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}//selectImg
	
	public ArrayList<MySpaceDTO> selectMySpaceAll(int memberseq) {
		ArrayList<MySpaceDTO> list = new ArrayList<MySpaceDTO>();

		try {
			// 원래 쓰던 거
			String sql = " select sr.rentalseq, sr.name, sr.hourpay, sr.limitperson, sl.address, se.memberseq, se.purpose, se.reservationdate, se.paydate, se.request, se.startdate, se.enddate, se.personcount, se.totalpay " + 
					" from tblspacerental sr, tblspacelocation sl, tblspacereservation se " + 
					" where sr.rentalseq = sl.rentalseq and sr.rentalseq = se.rentalseq " + 
					" and se.memberseq = ? ";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, memberseq);
			
			rs = pstat.executeQuery();	
			
		
			while(rs.next()) { 
				
				MySpaceDTO msDTO = new MySpaceDTO();
				
				msDTO.setRentalseq(rs.getInt("rentalseq"));
				msDTO.setName(rs.getString("name"));
				msDTO.setHourpay(rs.getInt("hourpay"));
				msDTO.setLimitperson(rs.getInt("limitperson"));
				msDTO.setAddress(rs.getString("address"));
				msDTO.setMemberseq(rs.getInt("memberseq"));
				msDTO.setPurpose(rs.getString("purpose"));
				msDTO.setReservationdate(rs.getDate("reservationdate"));
				msDTO.setPaydate(rs.getDate("paydate"));
				msDTO.setRequest(rs.getString("request"));
				msDTO.setStartdate(rs.getInt("startdate"));
				msDTO.setEnddate(rs.getInt("enddate"));
				msDTO.setPersoncount(rs.getInt("personcount"));
				msDTO.setTotalpay(rs.getInt("totalpay"));
				
				list.add(msDTO);
								
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			return list;
			
			
		
			
	}//fin
	
	
	
	

}//fin DAO
