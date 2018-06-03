<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Style.css"></link>
<link href="https://afeld.github.io/emoji-css/emoji.css" rel="stylesheet">
<title>Insert title here</title>

</head>
<body>
    <form method="post" action="addPlaylist">
        <label for='txtPlaylistUrl'> <i class="em em-tv"></i> Enter you playlist url here :</label> 
        <input id='txtPlaylistUrl' name='txtPlaylistUrl' type='text' /> 
        <br /> <br />
        <input name='addPlaylist' type='submit' /> 
        <br /><br />

        <div class="errorMessage">${errorMessage}</div>
        <div class="validMessage">${validMessage}</div>
    </form>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
	    <tr bgcolor="#A52A2A">
			<td><b>Id</b></td>
			<td><b>Url</b></td>
			<td><b>Last Sync</b></td>
		</tr>
        <c:forEach var="playlist" items="${playlistList}">
            <tr>
                <td><c:out value="${playlist.getIdPlaylist()}"/></td>
                <td><c:out value="${playlist.getUrl()}"/></td>
                <td><c:out value="${playlist.getLastSync()}"/></td>
            </tr>
        </c:forEach>
	</table>
</body>
</html>