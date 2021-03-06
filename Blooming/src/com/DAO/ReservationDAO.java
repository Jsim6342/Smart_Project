package com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.C_ProfileDTO;
import com.DTO.ReservationDTO;

public class ReservationDAO {

	//전역변수 선언
	//conn의 경우 static변수로 선언
	private PreparedStatement pst;
	private ResultSet rs;
	int cnt = 0;
		
	Connect dao = new Connect();
	
	//예약 하기
		public int reserve_insert(String nickname, String res_date, String consultant, String pro_email) {
			
			
			try {
				
				//DB연결 기능
				dao.getConn();
				
				String sql = "insert into reservation values(res_seq.nextval,?,?,?,?)";
				
				pst = Connect.conn.prepareStatement(sql); //static변수 Connect.conn 사용
				
				pst.setString(1, nickname);
				pst.setString(2, res_date);
				pst.setString(3, consultant);
				pst.setString(4, pro_email);
				
				cnt = pst.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//DB연결 종료
				dao.close();
			}
			return cnt;
		}
		
		
		//예약 현황 출력
		public ArrayList<ReservationDTO> showProfile() {
			
			ReservationDTO reservation = null;
			ArrayList<ReservationDTO> reservationList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB 연결(고정된 문법)
		         
		         String sql = "select * from reservation";
		         pst = Connect.conn.prepareStatement(sql);
		         // --------------------- DB에 SQL문 명령준비
		         rs = pst.executeQuery(); //select문은 DB에서 data를 반환받기 때문에 excuteQuery함수를 사용
		         // --------------------- SQL문 실행/ 실행 후 처리
		         
		         while(rs.next()) {
		        	 
		        	//전체 후기 데이터를 출력
		        	 int res_num = rs.getInt(1);
		        	 String nickname = rs.getString(2);
		        	 String res_date = rs.getString(3);
		        	 String consultant = rs.getString(4);
		        	 String pro_email = rs.getString(5);

	 	        	 //ReviewDTO 객체를 1개씩 DB에서 받은 후, ArrayList인 reviewList에 저장
		        	 reservation = new ReservationDTO(res_num, nickname, res_date, consultant,pro_email);
		        	 reservationList.add(reservation);
		         
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally는 정상실행이 되도, 오류가 나도 무조건 실행되는 부분.
				dao.close();
			}
			return reservationList;
		}
	
		//예약 현황 지우기
		public int delete_Reservation(String nickname, String res_date, String pro_email) {
			
			
			try {
		        
		         dao.getConn();
		         // --------------------- DB 연결(고정된 문법)
		         
		         String sql = "delete from reservation where nickname=? and res_date=? and pro_email=?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, nickname);
		         pst.setString(2, res_date);
		         pst.setString(3, pro_email);
		      
		      // --------------------- DB에 SQL문 명령준비
		         
		         cnt = pst.executeUpdate(); //성공 시 1을 반환
		      // --------------------- SQL문 실행/ 실행 후 처리
			
		        
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally는 정상실행이 되도, 오류가 나도 무조건 실행되는 부분.
			dao.close();
		}
		 return cnt;
		}
		
		//예약한 상담 조회 기능 (nickname값으로 일치하는 상담사 조회 )
		public ArrayList<ReservationDTO> return_consultant(String nickname) {
			
			ReservationDTO reservation = null;
			ArrayList<ReservationDTO> reservationList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB 연결(고정된 문법)
		         
		         String sql = "select * from reservation where nickname=?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, nickname);
		         
		         // --------------------- DB에 SQL문 명령준비
		         rs = pst.executeQuery(); //select문은 DB에서 data를 반환받기 때문에 excuteQuery함수를 사용
		         // --------------------- SQL문 실행/ 실행 후 처리
		         
		         while(rs.next()) {
		        	 
		        	//전체 예약 데이터를 출력
		        	 int res_num = rs.getInt(1);
		        	 String nicknames = rs.getString(2);
		        	 String res_date = rs.getString(3);
		        	 String consultant = rs.getString(4);
		        	 String pro_email = rs.getString(5);

		        	 //reservationDTO 객체를 1개씩 DB에서 받은 후, ArrayList인 reviewList에 저장
		        	 reservation = new ReservationDTO(res_num, nicknames, res_date, consultant,pro_email);
		        	 reservationList.add(reservation);
		         
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally는 정상실행이 되도, 오류가 나도 무조건 실행되는 부분.
				dao.close();
			}
			return reservationList;
		}
		
		//예약한 회원 조회 기능 (email값으로 일치하는 예약 값 조회)
		public ArrayList<ReservationDTO> return_reservation(String email) {
			
			ReservationDTO reservation = null;
			ArrayList<ReservationDTO> reservationList = new ArrayList<>();
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB 연결(고정된 문법)
		         
		         String sql = "select * from reservation where pro_email=?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, email);
		         
		         // --------------------- DB에 SQL문 명령준비
		         rs = pst.executeQuery(); //select문은 DB에서 data를 반환받기 때문에 excuteQuery함수를 사용
		         // --------------------- SQL문 실행/ 실행 후 처리
		         
		         while(rs.next()) {
		        	 
		        	//전체 예약 데이터를 출력
		        	 int res_num = rs.getInt(1);
		        	 String nicknames = rs.getString(2);
		        	 String res_date = rs.getString(3);
		        	 String consultant = rs.getString(4);
		        	 String pro_email = rs.getString(5);

	 	        	 //reservationDTO 객체를 1개씩 DB에서 받은 후, ArrayList인 reviewList에 저장
		        	 reservation = new ReservationDTO(res_num, nicknames, res_date, consultant,pro_email);
		        	 reservationList.add(reservation);
		         
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally는 정상실행이 되도, 오류가 나도 무조건 실행되는 부분.
				dao.close();
			}
			return reservationList;
		}
		
		//상담사 이메일, 닉네임 값에 맞는 예약현황값 반환(닉네임에 맞는 예약현황 조회)
		public boolean check_reservation(String nickname, String pro_email) {
			
			boolean check = true;
			if(nickname==null) {
				return false;
			}
			
			try {
				
				dao.getConn();
				
		         // --------------------- DB 연결(고정된 문법)
		         
		         String sql = "select * from reservation where nickname = ? and pro_email = ?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, nickname);
		         pst.setString(2, pro_email);
		         
		         // --------------------- DB에 SQL문 명령준비
		         rs = pst.executeQuery(); //select문은 DB에서 data를 반환받기 때문에 excuteQuery함수를 사용
		         // --------------------- SQL문 실행/ 실행 후 처리
		         
		         if(rs.next()) {
		        	 check = true;  
		         }else {
		        	 check = false;  
		         }
		         
			} catch (Exception e) {
				e.printStackTrace();
			}finally { //finally는 정상실행이 되도, 오류가 나도 무조건 실행되는 부분.
				dao.close();
			}
			return check;
		}
		
		//상담완료 시 상담사 이메일과 일치하는 예약현황 지우기
		public int complete_Reservation(String email) {
			
			
			try {
		        
		         dao.getConn();
		         // --------------------- DB 연결(고정된 문법)
		         
		         String sql = "delete from reservation where pro_email=?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, email);
		      
		      // --------------------- DB에 SQL문 명령준비
		         
		         cnt = pst.executeUpdate(); //성공 시 1을 반환
		      // --------------------- SQL문 실행/ 실행 후 처리
			
		        
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally는 정상실행이 되도, 오류가 나도 무조건 실행되는 부분.
			dao.close();
		}
		 return cnt;
		}
		
		
		
		
		//예약 현황 지우기(회원탈퇴 시)
		public ArrayList<ReservationDTO> delete_mem_Reservation(String nickname) {
			
			ReservationDTO reservation = new ReservationDTO();
			ArrayList<ReservationDTO> reservationList = new ArrayList<>();

			try {
		        
		         dao.getConn();
		         // --------------------- DB 연결(고정된 문법)
		         
		         String sql = "select * from reservation where nickname=?";
		         pst = Connect.conn.prepareStatement(sql);
		         
		         pst.setString(1, nickname);
		         
		         // --------------------- DB에 SQL문 명령준비
		         rs = pst.executeQuery(); //select문은 DB에서 data를 반환받기 때문에 excuteQuery함수를 사용
		         // --------------------- SQL문 실행/ 실행 후 처리
		         
		         while(rs.next()) {
		        	 
		        	//전체 예약 데이터를 출력
		        	 int res_num = rs.getInt(1);
		        	 String nicknames = rs.getString(2);
		        	 String res_date = rs.getString(3);
		        	 String consultant = rs.getString(4);
		        	 String pro_email = rs.getString(5);

	 	        	 //reservationDTO 객체를 1개씩 DB에서 받은 후, ArrayList인 reviewList에 저장
		        	 reservation = new ReservationDTO(res_num, nicknames, res_date, consultant,pro_email);
		        	 reservationList.add(reservation);
		         
		         }
		            
		         dao.getConn();
		         // --------------------- DB 연결(고정된 문법)  
		         
		         String sql2 = "delete from reservation where nickname=?";
		         pst = Connect.conn.prepareStatement(sql2);
		         
		         pst.setString(1, nickname);
		      
		      // --------------------- DB에 SQL문 명령준비
		         
		         cnt = pst.executeUpdate(); //성공 시 1을 반환
		      // --------------------- SQL문 실행/ 실행 후 처리
		         
		         
			
		        
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //finally는 정상실행이 되도, 오류가 나도 무조건 실행되는 부분.
			dao.close();
		}
			return reservationList; 	 
		}
		
}
