<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  

<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<!-- 검색조건 추가. -->
<div class="center">
	<form action="boardList.do" method="get">
		<div class="row">
		  <div class="col-sm-4">
		  <select name="searchCondition" class="form-control">
		    <option value="">선택하세요</option>
		    <option value="T">제목</option>
		    <option value="W">작성자</option>
		    <option value="TW">제목 & 작성자</option>
		  </select>
		  </div>
		  <div class="col-sm-6">
		  	<input type="text" name="keyword" class="form-control">
		  </div>
		  <div class="col-sm-2">
		  	<input type="submit" value="조회" class="btn btn-primary">
		  </div>
		</div>
	</form>
</div>
<!-- 검색조건 추가. -->

<h3>게시글 </h3>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("blist");
	PageDTO dto = (PageDTO) request.getAttribute("paging");
%>
<p>${blist}</p>
<p>${paging}</p>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
		</tr>
</thead>
<tbody>

<c:forEach var="vo" items="${blist }">
	<tr>
		<td align="center">
		  <a href="getboard.do?bno=${vo.boardNo}&page=${paging.page}&searchCondition=${searchCondition}&keyword=${keyword}">${vo.boardNo}</a></td>
		<td><c:out value="${vo.title }"></c:out></td>
		<td><c:out value="${vo.writer }" /></td>
		<td><c:out value="${vo.createDate }" /></td>
	</tr>
</c:forEach>

</tbody>

</table>

<div class="center">
  <div class="pagination">

  <c:if test="${paging.prev }">
  <a href="boardList.do?page=${paging.startPage-1 }&searchCondition=${searchCondition}&keyword=${keyword}"  >&laquo;</a>
 </c:if>
 

  <c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">
  	<c:choose>
  		<c:when test="${p == paging.page }">
  		<a href="boardList.do?page=${p }&searchCondition=${searchCondition}&keyword=${keyword}" class="active">${p }</a>
  		</c:when>
  		<c:otherwise>
  		<a href="boardList.do?page=${p }&searchCondition=${searchCondition}&keyword=${keyword}">${p }</a>
  		</c:otherwise>
  	</c:choose>
  </c:forEach>
  
  <c:if test="${paging.next }">
   <a href="boardList.do?page=${paging.endPage+1 }&searchCondition=${searchCondition}&keyword=${keyword}">&raquo;</a>
  </c:if>

  <!-- <a href="boardList.do?page=2" class="active">2</a>
  <a href="boardList.do?page=3">3</a>
  <a href="#">4</a>
  <a href="#">5</a>
  <a href="#">6</a> -->

  </div>
</div>

	


