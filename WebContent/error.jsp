<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agnieszka Świderska  Kalkulator webowy</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="./css/styleErr.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<h1> Kalkulator Webowy</h1>
<fieldset>
<form action="CalculatorServlet" method="post">
<table align="center" frame="border">
<tbody>
	<tr>
        <td colspan="4" width=80%>  <button disabled="disabled" type="submit" class="btn1Wy" name="btnWynik" value="ERR">ERR</button></td>
        <td width=20%> <button type="submit" class="btn1" name="btnOp" value="C">C</button> </td>
        
    </tr>
    <tr>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="7">7</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="8">8</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="9">9</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value="/">/</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value="sqrt">sqrt</button> </td>
    </tr>
    <tr>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="4">4</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="5">5</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="6">6</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value="*">*</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value="%">%</button> </td>
    </tr>
    <tr>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="1">1</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="2">2</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="3">3</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value="-">-</button> </td>
        <td rowspan="2" > <button disabled="disabled" type="submit" class="btn2" name="btnOblicz" value="=">=</button> </td>
    </tr>
    <tr>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnArg" value="0">0</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value=".">,</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value="+/-">+/-</button> </td>
        <td> <button disabled="disabled" type="submit" class="btn1" name="btnOp" value="+">+</button> </td>
        
    </tr>
</tbody>
</table></form>
</fieldset>

</body>
</html>