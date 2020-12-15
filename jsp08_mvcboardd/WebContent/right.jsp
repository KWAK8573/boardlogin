<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>게시글쓰기</title>
</head>
<body>
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <form action="write.do" method="POST">
            <tr><th>게시자id</th>
                    <td><input type="text" name="mId" size="50"></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="bTitle" size="50"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="bContent" cols="50"></textarea></td>
            <tr>
                    <td colspan="2"><input type="submit" value="입력">
                    &nbsp;&nbsp; <a href="list.do">목록보기</a></td>
                </tr>
            </tr>
            </form>
    </table>
</body>