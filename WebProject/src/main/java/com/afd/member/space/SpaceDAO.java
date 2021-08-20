package com.afd.member.space;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import com.afd.DBUtil;

public class SpaceDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public SpaceDAO() {
		
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		public ArrayList<SpaceMainDTO> selectSpaceAll() {
		ArrayList<SpaceMainDTO> list = new ArrayList<SpaceMainDTO>();

		try {
			// 원래 쓰던 거
			String sql = "select  distinct ts.rentalseq, ts.name, ts.hourpay, ts.limitperson, tsl.dong from tblspacerental ts, tblspacelocation tsl where ts.rentalseq = tsl.rentalseq order by ts.rentalseq asc";
			
			pstat = conn.prepareStatement(sql);
						
			rs = pstat.executeQuery();	
			
		
			while(rs.next()) { 
				
				SpaceMainDTO smDTO = new SpaceMainDTO();
				
				smDTO.setRentalseq(rs.getInt("rentalseq"));
				smDTO.setName(rs.getString("name"));
				smDTO.setHourpay(rs.getInt("hourpay"));
				smDTO.setLimitperson(rs.getInt("limitperson"));
				smDTO.setDong(rs.getString("dong"));
				
				
				list.add(smDTO);
								
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			return list;
			
	}
	
		public ArrayList<SpaceImageDTO> selectImg(int rentalseq){
			ArrayList<SpaceImageDTO> imgList = new ArrayList<SpaceImageDTO>();
			
			
			try {

				String sql = "select imagename from tblspaceimage where rentalseq = ?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, rentalseq);
				rs = pstat.executeQuery();	
				
				
				while(rs.next()) { 
					SpaceImageDTO siDTO = new SpaceImageDTO();
					siDTO.setImageName(rs.getString("imagename"));
					imgList.add(siDTO);
				}
				
				return imgList;

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}//selectImg
		
		public SpaceClickInfoDTO selectclickinfo(int rentalseq) {
			SpaceClickInfoDTO clickdto = new SpaceClickInfoDTO();
			try {
				// 원래 쓰던 거
				String sql = " select sr.rentalseq, sr.name, sr.hourpay, sr.address, sr.limitperson, sr.purpose, "
						+ " sl.latitude, sl.longitude, sc.content1, sc.content2, sc.content3, sc.content4, sc.content5 "
						+ " from tblspacerental sr, tblspaceimage si, tblspacelocation sl, tblspacecontent sc "
						+ " where sr.rentalseq = si.rentalseq and si.rentalseq = sl.rentalseq and sr.rentalseq = sc.rentalseq and sr.rentalseq = ? ";
				
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, rentalseq);
							
				rs = pstat.executeQuery();	
				
			
				while(rs.next()) { 
					
					clickdto.setName(rs.getString("name"));
					clickdto.setContent1(rs.getString("content1"));
					clickdto.setContent2(rs.getString("content2"));
					clickdto.setContent3(rs.getString("content3"));
					clickdto.setContent4(rs.getString("content4"));
					clickdto.setContent5(rs.getString("content5"));
					clickdto.setHourpay(rs.getInt("hourpay"));
					clickdto.setAddress(rs.getString("address"));
					clickdto.setLimitperson(rs.getInt("limitperson"));
					clickdto.setPurpose(rs.getString("purpose"));
					clickdto.setLatitude(rs.getDouble("latitude"));
					clickdto.setLongitude(rs.getDouble("longitude"));
					
				}
				
					
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
				return clickdto;
			}
				
	
	  public ArrayList <SpaceReservationDTO> reservationinfo(int rentalseq, int year, int month, int day) { 
		  ArrayList <SpaceReservationDTO> resdto = new ArrayList<SpaceReservationDTO>(); 
		  try { // 원래 쓰던 거 
	  String sql = " select sr.rentalseq, sr.hourpay, sr.limitperson, se.purpose, se.reservationDate, "
	  + " se.request, se.startdate, se.enddate, se.personcount, se.totalpay " +
	  " from tblspacerental sr, tblspacereservation se " +
	  "where sr.rentalseq = se.rentalseq and sr.rentalseq = ? and to_date(se.reservationdate, 'yy/mm/dd') = ? "
	  ;
	  
	  pstat = conn.prepareStatement(sql); 
	  pstat.setInt(1, rentalseq);
	  
	  year = year - 1900;
	  month = month - 1;
	  java.sql.Date d = new java.sql.Date(year, month, day);
	  System.out.println(year);
	  System.out.println(month);
	  System.out.println(day);
	  System.out.println(d);
	  pstat.setDate(2, d);
	  
	  rs = pstat.executeQuery();
	  
	  
	  while(rs.next()) {
	  
	  SpaceReservationDTO srDTO = new SpaceReservationDTO();
	  
	  srDTO.setHourpay(rs.getInt("hourpay"));
	  srDTO.setLimitpserson(rs.getInt("limitperson"));
	  srDTO.setPurpose(rs.getString("purpose"));
	  srDTO.setReservationdate(rs.getDate("reservationdate"));
	  srDTO.setRequest(rs.getString("request"));
	  srDTO.setStartdate(rs.getInt("startdate"));
	  srDTO.setEnddate(rs.getInt("enddate"));
	  srDTO.setPersoncount(rs.getInt("personcount"));
	  srDTO.setTotalpay(rs.getInt("totalpay"));
	 
	  resdto.add(srDTO);
	  
	  }
	  
	  
	  } catch (Exception e) { e.printStackTrace(); return null; } return resdto; 
	  }
	  
	  public void insert_reservation(SpaceReservationDTO dto) {
		  try {
			  String sql = "insert into tblspacereservation values (reservationSeq.nextval, ?, ?, ?, ? ,sysdate, ?, ?, ?, ? ,?)";
			  pstat = conn.prepareStatement(sql); 
			  pstat.setInt(1, dto.getMemberseq()); // 얘 나중에 꼭 바꿔줘야 함 일단 고정시킴 MemberSEQ
			  pstat.setInt(2, dto.getRentalseq());
			  pstat.setString(3, dto.getPurpose());
			  int year = dto.getReservationdate().getYear();
			  int month = dto.getReservationdate().getMonth();
			  int day = dto.getReservationdate().getDate();
			  System.out.println("day:" + day);
			  year = year - 1900;
			  month = month - 1; 
			  System.out.println("month:" + month);
			  java.sql.Date d = new java.sql.Date(year, month, day);
			  pstat.setDate(4, d);
			  System.out.println("d:" + d);
			  pstat.setString(5, dto.getRequest());
			  pstat.setInt(6, dto.getStartdate());
			  pstat.setInt(7, dto.getEnddate());
			  pstat.setInt(8, dto.getPersoncount());
			  pstat.setInt(9, dto.getTotalpay());
			  
			  pstat.executeUpdate();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
		//List 서블릿이 총 게시물 수 알려달라고 요청
		public int getTotalCount(HashMap<String, String> map) {
			
			try {

				String where = "";
				
				if (map.get("isSearch").equals("y")) {
					
					if (map.get("column").equals("all")) {
						where = String.format(" where subject like '%%%s%%' or content like '%%%s%%' "
												, map.get("search"), map.get("search"));
					} else {
						where = String.format(" where %s like '%%%s%%' "
												, map.get("column"), map.get("search"));				
					}
					
				}
				
				String sql = String.format("select count(*) as cnt from tblBoard %s", where);
				
				pstat = conn.prepareStatement(sql);
				
				rs = pstat.executeQuery();
				
				if (rs.next()) {
					return rs.getInt("cnt");
				}
			
				
			} catch (Exception e) {
				System.out.println("BoardDAO.getTotalCount()");
				e.printStackTrace();
			}
			
			return 0;
		}
	  		
		
	  
}
		
		
	



