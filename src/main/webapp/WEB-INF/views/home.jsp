<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	
	<ol class="spittle-list">
	   <c:forEach var="spittle" items="${spittles }">
	      <s:url var="spitter_url" value="/spitters/{spitterName}" >
	         <s:param name="spitterName" value="${spittle.spitter.username }"/>
	      </s:url>
	   </c:forEach>
	
	   <li>
	      <span class="spittleListImage">
	         <img src="http://s3.amazonaws.com/spitterImage/${spittle.spitter.id }.jpg"
	             width="48"
	             border="0"
	             align="middle"
	             onerror="this.src='<s:url value="/resources/images"/>/spitter_avatar.png';"/>
	      </span>
	      <span class="spittleListText"> 
	        <a href="${spittle_url }"><c:out value="${spittle.spitter.username }"/></a>
	        -<c:out value="${spittle.text }"></c:out>
	        <small><fmt:formateDate value="${spittle.when }" 
	                                     pattern="hh:mma MMM d, yyyy" /></small>
	      </span>
	   </li>
	</ol>
	
	
	
</div>


