package com.afd.member.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/member/community/license.do")
public class License extends HttpServlet {

    @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doPostGet(req, resp);
       }
    
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
          doPostGet(req, resp);
       }
    
       private void doPostGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       //list.do
       //1. 목록보기(게시판의 시작 페이지 역할)
       //   - select ..
       //2. 검색 결과 보기(검색 버튼 눌러서 호출)
       //   - select where..
       
          String column = req.getParameter("column");
             String search = req.getParameter("search");
             String orderRegdate = req.getParameter("orderRegdate");
             String orderRecommendCount = req.getParameter("orderRecommendCount");
             String orderComment = req.getParameter("orderComment");
             String orderReadCount = req.getParameter("orderReadCount");
             
          
             String isSearch = "n";
             
             //System.out.println("column"+ column);
             //System.out.println("search"+ search);
             
             if(column != null && search != null && !column.equals("") && !search.equals("")) {
                isSearch = "y";
             }

            
         
             HashMap<String, String> map = new HashMap<String,String>();
             map.put("column", column);
             map.put("search", search);
             map.put("isSearch", isSearch);
             map.put("orderRegdate", orderRegdate);
             map.put("orderRecommendCount", orderRecommendCount);
             map.put("orderComment", orderComment);
             map.put("orderReadCount", orderReadCount);
             
       
             //카테고리별로 
       
          
          
          
             //페이징 처리 
                   // -> 보고 싶은 페이지를 정하기 위한 처리
                   int nowPage = 0;      //현재 페이지 번호
                   int totalCount = 0;      //총 게시물 수
                   int pageSize = 10;      //한 페이지당 출력할 게시물 수
                   int totalPage = 0;      //총 페이지 수
                   int begin = 0;         //가져올 게시물 시작 위치
                   int end = 0;         //가져올 게시물 끝 위치
                   int n = 0;            //페이지바 제작
                   int loop = 0;         //페이지바 제작
                   int blockSize = 10;      //페이지바 제작
                   
                   

                   //list.do > list.do?page=1
                   //list.do?page=3
                   
                   String page = req.getParameter("page");
                   
                   if (page == null || page.equals("")) {
                      nowPage = 1;
                   } else {
                      nowPage = Integer.parseInt(page);
                   }
                   
                   
                   //nowPage > 지금 보게될 페이지 번호
                   //1page -> where rnum between 1 and 10
                   //2page -> where rnum between 11 and 20
                   //3page -> where rnum between 21 and 30
                   
                   begin = ((nowPage - 1) * pageSize) + 1;
                   end = begin + pageSize - 1;
                   
                   map.put("begin", begin + "");
                   map.put("end", end + "");

                  
                   
                   CommunityDAO dao = new CommunityDAO();

                   
                   //총 게시물 수 알아내기
                   totalCount = dao.getLicenseTotalCount(map);
                   //System.out.println(totalCount);
                   
                   //총 페이지 수 알아내기
                   //393 / 10 = 39.3 > 40
                   totalPage = (int)Math.ceil((double)totalCount / pageSize);
                   //System.out.println(totalPage);
                   
                  
              
                 
                 String pagebar = "<nav>\r\n"
                       + "         <ul class=\"pagination\">";
                 
//                 for (int i=1; i<=totalPage; i++) {
//                    if (i == nowPage) {
//                       pagebar += String.format(" <a href='#!' style='color:tomato;'>%d</a>;", i, i);
//                    } else {
//                       pagebar += String.format(" <a href='/myapp/board/list.do?page=%d'>%d</a>", i, i);
//                    }
//                 }
                 
                 
                 
                 
                 loop = 1;//while 루프 변수
                 n = ((nowPage - 1) / blockSize) * blockSize + 1;//출력되는 페이지 번호
                 
                 //이전 10 페이지
                 if (n == 1) {
                    pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ");         
                 }else if (n != 1) {
                    
                    if (map.get("isSearch").equals("y")) 
                       
                          pagebar += pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&column=%s&search=%s&isSearch=%s' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n - 1, column, search, isSearch);
                          
                    } else if (map.get("isSearch").equals("n")) {
                       
                       if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
                          
                          pagebar += pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderRegdate=regdate' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n - 1);
                          
                       } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
                          
                          pagebar += pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderRecommendCount=recommendCount' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n - 1);
                          
                       } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
                          
                          pagebar += pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderComment=ccnt' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n - 1);
                          
                       } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
                          
                          pagebar += pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderReadCount=readCount' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n - 1);
                          
                       } else if (map.get("orderRegdate") == null && map.get("orderRecommendCount") == null && map.get("orderComment") == null && map.get("orderReadCount") == null) {
                          
                          pagebar += pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ", n - 1);
                          
                       }
                       
                 
                    }
                 
                 
                 //페이지 링크
//                 while(!(loop > blockSize || n > totalPage)) {
//                    if (n == nowPage) {
//                       pagebar += String.format(" <a href='#!' style='color:tomato;'>%d</a>", n, n);
//                    } else {
//                       pagebar += String.format(" <a href='/myapp/board/list.do?page=%d'>%d</a>", n, n);
//                    }
//                    loop++;
//                    n++;
//                    
//                 };
                 
                 if (totalPage == 0) {
                    pagebar += "<li class='active'><a href='#!'>1</a></li>";
                 }
                 
                 
                 while(!(loop > blockSize || n > totalPage)) {
                    if (n == nowPage) {
                       pagebar += String.format("<li class='active'><a href='#!'>%d</a></li>", n);
                    }else if (n != nowPage) {
                       
                       if (map.get("isSearch").equals("y")) {
                          
                          pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderRegdate=regdate&column=%s&search=%s&isSearch=%s'>%d</a></li> ", n, column, search, isSearch, n);
                          
                    } else if (map.get("isSearch").equals("n")) {
                          
                          if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
                             
                             pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderRegdate=regdate'>%d</a></li> ", n, n);
                             
                          } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
                             
                             pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderRecommendCount=recommendCount'>%d</a></li> ", n, n);
                             
                          } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
                             
                             pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderComment=ccnt'>%d</a></li> ", n, n);
                             
                          } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
                             
                             pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d&orderReadCount=readCount'>%d</a></li> ", n, n);
                             
                          } else if (map.get("orderRegdate") == null && map.get("orderRecommendCount") == null && map.get("orderComment") == null && map.get("orderReadCount") == null) {
                             
                             pagebar += String.format(" <li><a href='/webproject/main/member/community/license.do?page=%d'>%d</a></li> ", n, n);
                             
                          }
                          
                       }
                       
                    }
                    loop++;
                    n++;
                    
                 };
                 

                 //다음 10 페이지
//                 if ( n > totalPage) {
//                    pagebar += String.format(" <a href='#!'>[다음 %d페이지]</a>", blockSize);
//                 } else {
//                    pagebar += String.format(" <a href='/myapp/board/list.do?page=%d'>[다음 %d페이지]</a>", n, blockSize);
//                 }
                 
                 if (n > totalPage) {
                    pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ");         
                 }else if (!(n > totalPage)) {
                    
                    if (map.get("isSearch").equals("y")) {
                       
                       pagebar += String.format(
                             " <li><a href='/webproject/main/member/community/license.do?page=%d&orderRegdate=regdate&column=%s&search=%s&isSearch=%s' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n, column, search, isSearch);
                       
                 } else if (map.get("isSearch").equals("n")) {
                       
                       if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
                          
                          pagebar += String.format(
                                " <li><a href='/webproject/main/member/community/license.do?page=%d&orderRegdate=regdate' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n);
                          
                       } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
                          
                          pagebar += String.format(
                                " <li><a href='/webproject/main/member/community/license.do?page=%d&orderRecommendCount=recommendCount' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n);
                          
                       } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
                          
                          pagebar += String.format(
                                " <li><a href='/webproject/main/member/community/license.do?page=%d&orderComment=ccnt' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n);
                          
                       } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
                          
                          pagebar += String.format(
                                " <li><a href='/webproject/main/member/community/license.do?page=%d&orderReadCount=readCount' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n);
                          
                       } else if (map.get("orderRegdate") == null && map.get("orderRecommendCount") == null && map.get("orderComment") == null && map.get("orderReadCount") == null) {
                          
                          pagebar += String.format(
                                " <li><a href='/webproject/main/member/community/license.do?page=%d' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ", n);
                          
                       }
                       
                    }
                    
                 }
                 
                 
                 
                 
                 pagebar += "</ul>\r\n"
                       + "       </nav>";
                 
                 
                 
            
                   //2.
                   ArrayList<CommunityDTO> list = dao.licenselist(map);
                   
                   //2.5
                   for (CommunityDTO dto : list) {
                      
                      //날짜 > 가공
                      String regdate = dto.getRegdate();
                      regdate = regdate.substring(0, 10);
                      dto.setRegdate(regdate);
                   
                      
                      String title = dto.getTitle();
                      
                      //무조건 글 제목과 내용에 들어있는 <script>태그는 비활성화!!!
                      
                      //제목이 길면 > 자르기
                      if (title.length() > 25) {
                         title = title.substring(0, 25) + "..";
                         dto.setTitle(title);
                      }
                      
                     if (isSearch.equals("y") && column.equals("title")) {
                         title = title.replace(search, "<span style='color:tomato; background-color:yellow;'>" + search + "</span>");
                   dto.setTitle(title);
                }
                               
                      
                   
                   }
                   
                   
                  HttpSession session = req.getSession();
                 
                 session.setAttribute("read", "n");
                 
                 
                   
                   
                   //3.
                   req.setAttribute("list", list);
                   req.setAttribute("map", map); //*****
                   
                   req.setAttribute("totalCount", totalCount);
                   req.setAttribute("totalPage", totalPage);
                   req.setAttribute("nowPage", nowPage);
                   req.setAttribute("pagebar", pagebar);
      

      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/license.jsp");
      dispatcher.forward(req, resp);

   }

}