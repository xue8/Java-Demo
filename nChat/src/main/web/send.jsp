<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>send messages</h2>
<body>

<form action="/doSend">
  发送给谁：<input type="text" name="uid"/>
  发送什么信息：<input type="text" name="messages"/>
  <input type="submit" value="发送"/>
</form>

</body>
</body>
</html>