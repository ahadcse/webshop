<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Application JavaScript Includes -->
<script type="text/javascript" src="js/test.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<div>
		<button type="button" onclick="test('Ahad')">Try javascript</button>
	</div>
	<div>
		<select data-bind="options: availableOption, optionsText: 'name', value: availableOption"></select>
	</div>
	<form action="Webshop" method="post">
		<input type="submit" name="cart" value="Print Shopping Cart">
		<BR> <input type="submit" name="organization"
			value="Print Organizations">
	</form>
</body>
</html>